package com.example.appthrones

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
            house = House(
                name = "casa $int",
                region = "region $int",
                words = "Lema $int"
            ))
    }

    fun findCharacterById(id: String?): Character? {
        return characters.find { it.id == id}
    }
}