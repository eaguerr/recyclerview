package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import model.SongStore

class MainActivity : AppCompatActivity() {

    private val adapter = SongAdapter(SongStore.getSongs())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        songsRecyclerView.layoutManager = LinearLayoutManager()
        songsRecyclerView.adapter = adapter
    }
}
