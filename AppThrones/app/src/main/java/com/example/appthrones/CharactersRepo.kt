package com.example.appthrones

import kotlin.random.Random

object CharactersRepo {
    val characters: MutableList<Character> = mutableListOf()
    get() {
        if (field.isEmpty()){
            field.addAll(dummyCharacters())
        }
        return field
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
            mother = "madre $int",
            father = "padre $int",
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