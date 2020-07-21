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
import kotlinx.android.synthetic.main.fragment_characters.*

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

        list.adapter = adapter

        btnRetry.setOnClickListener{
            retry()
        }
    }

    override fun onResume() {
        super.onResume()
        requestCharacters()

    }

    private fun retry() {
        layoutError.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE

        requestCharacters()
    }

    private fun requestCharacters(){
        CharactersRepo.requestCharacters(context!!,
            {charaters ->
                progressBar.visibility =View.INVISIBLE
                list.visibility = View.VISIBLE
                adapter.setCharacters(charaters)
            },
            {
                progressBar.visibility =View.INVISIBLE
                layoutError.visibility = View.VISIBLE
            })
    }

    interface OnItemClickListener {
        fun onItemClicked(character: Character)
    }
}