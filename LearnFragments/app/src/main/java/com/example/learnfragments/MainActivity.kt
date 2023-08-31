package com.example.learnfragments

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClock = findViewById<Button>(R.id.btnTime)
        val btnExam = findViewById<Button>(R.id.btnExam)
        val btnLogin = findViewById<Button>(R.id.btn_login_validate)

        btnClock.setOnClickListener {
            setFragment(clock_fragment())
        }

        btnExam.setOnClickListener {
            setFragment(Exam_Fragment())
        }
        btnLogin.setOnClickListener {
            setFragment(Login_fragment())
        }
    }

    private fun setFragment(frag: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, frag)
        fragmentTransaction.commit()
    }
}