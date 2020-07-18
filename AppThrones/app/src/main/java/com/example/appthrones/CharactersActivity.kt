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
    val list: RecyclerView by lazy {
        val list: RecyclerView = findViewById(R.id.rcv)
        list.layoutManager = LinearLayoutManager(this)
        list
    }

    val adapter: CharactersAdapter by lazy {
        val adapter = CharactersAdapter {item, position ->
            showDetails(item.id)
        }
        adapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        val characters: MutableList<Character> = CharactersRepo.characters
        adapter.setCharacters(characters)

        list.adapter = adapter
    }

    fun showDetails(characterId: String) {
        val intent: Intent = Intent(this@CharactersActivity, DetailActivity::class.java)
        intent.putExtra("key_id", characterId)
        startActivity(intent)
    }

}