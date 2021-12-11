package com.example.androidintrotointentsandactivitiesandrecyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidintrotointentsandactivitiesandrecyclerviews.databinding.ActivityContentviewBinding

class Contentview : AppCompatActivity() {
    private var binding: ActivityContentviewBinding? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_contentview)
        binding = ActivityContentviewBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val myAdapter = MyAdapter()
        binding!!.recyclerView.apply {
            adapter = myAdapter
        }
    }
}

