package com.example.appthrones

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import kotlin.random.Random


const val URL_CHARACTERS = "https://5f15bd7f4693a60016275e96.mockapi.io/characters"

object CharactersRepo {
    private var characters: MutableList<Character> = mutableListOf()




    fun requestCharacters(context: Context,
                          success: ((MutableList<Character>) -> Unit),
                          err: (() -> Unit)) {
        if (characters.isEmpty()){
            val request = JsonArrayRequest(Request.Method.GET, URL_CHARACTERS, null,
                {response ->
                    characters = parseCharacters(response)
                    success.invoke(characters)
                },
                {error ->
                    err.invoke()
                })
            Volley.newRequestQueue(context)
                .add(request)
        } else {
            success.invoke(characters)
        }

    }

    private fun parseCharacters(jsonArray: JSONArray): MutableList<Character> {
        val characters = mutableListOf<Character>()
        for (index in 0 until jsonArray.length()) {
            val character = parseCharacter(jsonArray.getJSONObject(index))
            characters.add(character)
        }
        return characters
    }

    private fun parseCharacter(jsonCharacter: JSONObject) : Character {
       return Character(jsonCharacter.getString("id"),
           jsonCharacter.getString("name"),
           jsonCharacter.getString("born"),
           jsonCharacter.getString("title"),
           jsonCharacter.getString("actor"),
           jsonCharacter.getString("quote"),
           jsonCharacter.getString("father"),
           jsonCharacter.getString("mother"),
           jsonCharacter.getString("spouse"),
           parseHouse(jsonCharacter.getJSONObject("house"))       )
    }


    private fun parseHouse(jsonHouse: JSONObject): House {
        return House(jsonHouse.getString("name"),
        jsonHouse.getString("region"),
        jsonHouse.getString("words"))
    }

    private fun dummyCharacters(): MutableList<Character>{
        return (1..10).map {
            intToCharacter(it)
        }.toMutableList()
    }

    private fun intToCharacter(int: Int): Character{
        return Character(
            name = "Personaje $int",
            title = "Titulo $int",
            born = "nacio en $int",
            actor = "actor $int",
            quote = "Frase $int",
            father = "padre $int",
            mother = "madre $int",
            spouse = "espos@ $int",
            house = dummyHouse())
    }

    fun findCharacterById(id: String?): Character? {
        return characters.find { it.id == id}
    }

    private fun dummyHouse(): House {
        val ids = arrayOf("stark", "lannister", "targaryen", "tyrell", "arryn", "baratheon", "tully")
        val randomIdPosition = Random.nextInt(ids.size)
        return House(name = ids[randomIdPosition],
            region = "Región",
            words = "Lema")
    }
}