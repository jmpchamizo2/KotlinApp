package com.example.appthrones

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(){

    companion object{
        fun new_instance(id: String): DetailFragment {
            val instance = DetailFragment()

            val args = Bundle()
            args.putString("key_id", id)

            instance.arguments = args

            return instance
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments!!.getString("key_id")
        val character = CharactersRepo.findCharacterById(id)

        character?.let {
            with(character) {
                label_name.text = name
                txvDater.text = born
                txvActor.text = actor
                txvFather.text = father
                txvMather.text = mother
                txvQuote.text = quote
                label_title.text = title
                imgOverlay.background = ContextCompat.getDrawable(context!!, House.getOverlayColor(character.house.name))
                fab.backgroundTintList = ContextCompat.getColorStateList(context!!, House.getBaseColor(character.house.name))
            }
        }

        fab.setOnClickListener({
            Toast.makeText(context, character?.house?.words, Toast.LENGTH_LONG).show()
        })
    }

}