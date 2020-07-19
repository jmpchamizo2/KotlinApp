package com.example.appthrones

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_characters.*
class CharactersActivity : AppCompatActivity(), CharactersFragment.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)



        if (savedInstanceState ==  null ){
            val fragment = CharactersFragment()
            this.supportFragmentManager
                .beginTransaction()
                .add(R.id.list_container, fragment)
                .commit()
        }

    }

    override fun onItemClicked(character: Character) {

        if (isDetailViewAvailable()){
            showFragmentDetail(character.id)
        } else {
            launchDetailActivity(character.id)
        }

    }

    private fun isDetailViewAvailable() = detail_container != null

    private fun showFragmentDetail(characterId: String) {
        val detailFragment = DetailFragment.new_instance(characterId)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.detail_container, detailFragment)
            .commit()
    }

    private fun launchDetailActivity(characterId: String) {
        val intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key_id", characterId)
        startActivity(intent)
    }


}