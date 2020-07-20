package com.example.appthrones

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

data class Character(
    var id: String = UUID.randomUUID().toString(),
    var name: String,
    var born: String,
    var title: String,
    var actor: String,
    var quote: String,
    var parents: String,
    var spouse: String,
    var house: House)

data class House(
    var name: String,
    var region: String,
    var words: String){

    companion object{
        private val DEFAULT_COLORS = arrayOf(R.color.starkOverlay, R.color.starkBase)
        private val colors =  mapOf(
            Pair("stark", arrayOf(R.color.starkOverlay, R.color.starkBase)),
            Pair("lannister", arrayOf(R.color.lannisterOverlay, R.color.lannisterBase)),
            Pair("tyrell", arrayOf(R.color.tyrellOverlay, R.color.tyrelBase)),
            Pair("arryn", arrayOf(R.color.arrynOverlay, R.color.arrynBase)),
            Pair("targaryen", arrayOf(R.color.targaryenOverlay, R.color.targaryenBase)),
            Pair("martel", arrayOf(R.color.martelOverlay, R.color.martelBase)),
            Pair("baratheon", arrayOf(R.color.baratheonOverlay, R.color.baratheonBase)),
            Pair("greyjoy", arrayOf(R.color.greyjoyOverlay, R.color.greyjoyBase)),
            Pair("frey", arrayOf(R.color.freyOverlay, R.color.freyBase)),
            Pair("tully", arrayOf(R.color.tullyOVerlay, R.color.tullyBase))
        )

        @RequiresApi(Build.VERSION_CODES.N)
        fun getOverlayColor(houseId: String): Int{
            return colors.getOrDefault(houseId, DEFAULT_COLORS)[0]
        }

        @RequiresApi(Build.VERSION_CODES.N)
        fun getBaseColor(houseId: String): Int{
            return colors.getOrDefault(houseId, DEFAULT_COLORS)[1]
        }
    }




}