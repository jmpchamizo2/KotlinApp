package com.example.appthrones

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CharactersActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        val characters: MutableList<Character> = CharactersRepo.characters
        Log.d("ChareactersActivity", "len ${characters.size}")

        val button: Button = findViewById(R.id.btnCharacter)
        button.setOnClickListener({
            val intent: Intent = Intent(this@CharactersActivity, DetailActivity::class.java)
            startActivity(intent)
        })

    }

}