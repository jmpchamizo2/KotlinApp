package com.example.appthrones

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character.view.*


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
            @RequiresApi(Build.VERSION_CODES.N)
            set(value){
                value?.let {
                    itemView.label_name.text = value.name
                    itemView.label_title.text = value.title

                    val overlayColor = House.getOverlayColor(value.house.name)
                    itemView.imgOverlay.background = ContextCompat.getDrawable(itemView.context, overlayColor)

                    Picasso.get()
                        .load(value.img)
                        .placeholder(R.drawable.test)
                        .into(itemView.img_character)
                }
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