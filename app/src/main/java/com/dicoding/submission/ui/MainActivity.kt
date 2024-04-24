package com.dicoding.submission.bmaap.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submission.bmaap.R
import com.dicoding.submission.bmaap.adapter.ListCarAdapter
import com.dicoding.submission.bmaap.data.Car

class MainActivity : AppCompatActivity() {
    private lateinit var rvCars: RecyclerView
    private val list = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCars = findViewById(R.id.jdm_list)
        rvCars.setHasFixedSize(true)

        list.addAll(getListCars())
        showRecyclerList()

        val about: ImageView = findViewById(R.id.about)
        about.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                // Pindah ke halaman baru
                val intent = Intent(applicationContext, AboutActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun getListCars(): ArrayList<Car> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCar = ArrayList<Car>()
        for (i in dataName.indices) {
            val hero = Car(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listCar.add(hero)
        }
        return listCar
    }

    private fun showRecyclerList() {
        rvCars.layoutManager = LinearLayoutManager(this)
        val listCarAdapter = ListCarAdapter(list)
        rvCars.adapter = listCarAdapter

        listCarAdapter.setOnItemClickCallback(object : ListCarAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Car) {
                val moveWithObjectIntent = Intent(this@MainActivity, DetailActivity::class.java)
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_CAR, data)
                startActivity(moveWithObjectIntent)
            }
        })
    }

}