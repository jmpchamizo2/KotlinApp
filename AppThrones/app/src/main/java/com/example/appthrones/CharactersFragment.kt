package com.example.appthrones

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersFragment: Fragment() {

    val list: RecyclerView by lazy {
        val list: RecyclerView = view!!.findViewById(R.id.rcv)
        list.layoutManager = LinearLayoutManager(context)
        list
    }

    val adapter: CharactersAdapter by lazy {
        val adapter = CharactersAdapter {item, position ->
            clickListener.onItemClicked(item)
        }
        adapter
    }

    lateinit var clickListener: OnItemClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnItemClickListener){
            clickListener = context
        } else {
            throw IllegalArgumentException("Attached activity doesn't implement  CharacterFragment.OnItemClickListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }

    override fun onResume() {
        super.onResume()
        requestCharacters()
        list.adapter = adapter
    }

    private fun requestCharacters(){
        CharactersRepo.requestCharacters(context!!,
            {charaters ->
                adapter.setCharacters(charaters)
            },
            {})
    }

    interface OnItemClickListener {
        fun onItemClicked(character: Character)
    }
}