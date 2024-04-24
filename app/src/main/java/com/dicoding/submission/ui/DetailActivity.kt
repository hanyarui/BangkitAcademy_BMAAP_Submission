package com.dicoding.submission.bmaap.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.dicoding.submission.bmaap.R
import com.dicoding.submission.bmaap.data.Car

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CAR = "extra_car"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name: TextView = findViewById(R.id.detailTitleTextView)
        val desc: TextView = findViewById(R.id.detailDescriptionTextView)
        val image: ImageView = findViewById(R.id.detailImageView)

        val car = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Car>(EXTRA_CAR, Car::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Car>(EXTRA_CAR)
        }

        if (car != null) {
            name.text = car.name
            desc.text = car.description
            image.setImageResource(car.photo)
        }

        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }
    }
}