package com.example.appthrones

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.Serializable
import java.util.*

data class Character(
    var id: String = UUID.randomUUID().toString(),
    var name: String,
    var born: String,
    var title: String,
    var actor: String,
    var quote: String,
    var father: String,
    var mother: String,
    var spouse: String,
    var img: String,
    var house: House)

data class House(
    var name: String,
    var region: String,
    var words: String,
    var img: String) : Serializable {

    companion object{
        private val DEFAULT_RESOURCES = arrayOf(R.color.starkOverlay, R.color.starkBase, R.drawable.ic_stark)
        private val resources =  mapOf(
            Pair("stark", arrayOf(R.color.starkOverlay, R.color.starkBase, R.drawable.ic_stark)),
            Pair("lannister", arrayOf(R.color.lannisterOverlay, R.color.lannisterBase, R.drawable.ic_lannister)),
            Pair("tyrell", arrayOf(R.color.tyrellOverlay, R.color.tyrelBase, R.drawable.ic_tyrell)),
            Pair("arryn", arrayOf(R.color.arrynOverlay, R.color.arrynBase, R.drawable.ic_arryn)),
            Pair("targaryen", arrayOf(R.color.targaryenOverlay, R.color.targaryenBase, R.drawable.ic_targaryen)),
            Pair("martel", arrayOf(R.color.martelOverlay, R.color.martelBase, R.drawable.ic_martell)),
            Pair("baratheon", arrayOf(R.color.baratheonOverlay, R.color.baratheonBase, R.drawable.ic_baratheon)),
            Pair("greyjoy", arrayOf(R.color.greyjoyOverlay, R.color.greyjoyBase, R.drawable.ic_greyjoy)),
            Pair("frey", arrayOf(R.color.freyOverlay, R.color.freyBase, R.drawable.ic_frey)),
            Pair("tully", arrayOf(R.color.tullyOVerlay, R.color.tullyBase, R.drawable.ic_tully))
        )

        @RequiresApi(Build.VERSION_CODES.N)
        fun getOverlayColor(houseId: String): Int{
            return resources.getOrDefault(houseId, DEFAULT_RESOURCES)[0]
        }

        @RequiresApi(Build.VERSION_CODES.N)
        fun getBaseColor(houseId: String): Int{
            return resources.getOrDefault(houseId, DEFAULT_RESOURCES)[1]
        }

        @RequiresApi(Build.VERSION_CODES.N)
        fun getIcon(houseId: String): Int {
            return resources.getOrDefault(houseId, DEFAULT_RESOURCES)[2]
        }
    }




}