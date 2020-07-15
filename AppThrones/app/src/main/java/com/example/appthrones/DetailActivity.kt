package com.example.appthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val button: Button = findViewById(R.id.btn)
        button.setOnClickListener({
            Toast.makeText(this@DetailActivity, "The winter is comming!!", Toast.LENGTH_LONG).show()
        })
    }
}