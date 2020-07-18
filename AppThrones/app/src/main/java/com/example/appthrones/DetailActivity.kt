package com.example.appthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getStringExtra("key_id")
        val character = CharactersRepo.findCharacterById(id)
        character?.let {
            with(character) {
                txvName.text = name
                txvDater.text = born
                txvActor.text = actor
                txvFather.text = father
                txvMather.text = mother
                txvQuote.text = quote
                txvTitle.text = title
                btn.text = house.name
            }
        }

        val button: Button = findViewById(R.id.btn)
        button.setOnClickListener({
            Toast.makeText(this@DetailActivity, character?.house?.words, Toast.LENGTH_LONG).show()
        })
    }
}