package com.example.diffusion

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.diffusion.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DiffusionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[DiffusionViewModel::class.java]

        setContentView(binding.root)


        binding.submit.setOnClickListener {
            val query = binding.query.editableText.toString()
            viewModel.getImageFromText(query)
            Toast.makeText(this, "Image generating for '$query'", Toast.LENGTH_SHORT).show()
            binding.result.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }

        viewModel.imageFromTextResponse.observe(this) {

            Log.d("Result", it.toString())

            if (it.status == "success") {
                Picasso.get().load(it.output[0]).into(binding.result);
            }

            binding.result.visibility = View.VISIBLE
            binding.progressBar.visibility = View.INVISIBLE
        }
    }
}