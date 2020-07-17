package com.example.appthrones

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        val list: RecyclerView = findViewById(R.id.rcv)
        val adapter = CharactersAdapter(){item, position ->
            showDetails()
        }

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
        val characters: MutableList<Character> = CharactersRepo.characters
        adapter.setCharacters(characters)

        Log.d("ChareactersActivity", "len ${characters.size}")
    }

    fun showDetails() {
        val intent: Intent = Intent(this@CharactersActivity, DetailActivity::class.java)
        startActivity(intent)
    }

}