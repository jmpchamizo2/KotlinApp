package com.example.appthrones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CharactersAdapter(val itemClickListener: ((Character, Int) -> Unit)): RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private val items = mutableListOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.character = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setCharacters(characters: MutableList<Character>) {
        items.clear()
        items.addAll(characters)
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var character: Character? = null
            set(value){
                itemView.findViewById<TextView>(R.id.label_name).text = value?.name
                field = value
            }
        init {
            itemView.setOnClickListener{
                character?.let{
                    itemClickListener?.invoke(character as Character, adapterPosition)
                }
            }

        }

    }
}