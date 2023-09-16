package com.example.diffuse

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.diffuse.databinding.ActivityMainBinding
import com.example.diffuse.network.ResnetApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var currentPhotoPath: String
    private val REQUEST_IMAGE_CAPTURE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.btnsubmit.setOnClickListener {
//
//        }

        binding.btnchooseImage.setOnClickListener {
            dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    Toast.makeText(this, "Error : creating file", Toast.LENGTH_SHORT).show()
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this, "com.example.diffuse.fileprovider", it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {

            val thumbnail: Bitmap? = BitmapFactory.decodeFile(currentPhotoPath)

            val file = File(currentPhotoPath)
            val inputStream = FileInputStream(file)
            val buf: ByteArray = ByteArray(inputStream.available())
            while (inputStream.read(buf) !== -1);

            val requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), buf)

            GlobalScope.launch {
                val response = ResnetApiService.service.classifyImage(requestBody)

                response.enqueue(object : retrofit2.Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        Log.d("ResponseDATA", response.body().toString())
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Log.d("ResponseDATA", t.toString())
                    }

                })

                withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }


            Toast.makeText(this, currentPhotoPath, Toast.LENGTH_SHORT).show()
            binding.ImageToClassify.setImageBitmap(thumbnail)
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }

}