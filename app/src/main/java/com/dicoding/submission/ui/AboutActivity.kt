package com.dicoding.submission.bmaap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.dicoding.submission.bmaap.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }
    }
}