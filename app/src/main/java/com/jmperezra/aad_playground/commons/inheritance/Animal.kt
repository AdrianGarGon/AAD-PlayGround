package com.jmperezra.aad_playground.commons.inheritance

import android.util.Log

class Animal2(name: String) {
    var age: Int? = null
    var name2: String = name.toString()

    init {
        name
    }

    fun aux() {
        age
    }
}

open class Animal(val name: String, val type_feeding: String, val age: Int) {

    fun printTypeFeeding(){
        Log.d("@dev", type_feeding)
    }
}

open class Mammal(val gestation: Int, name: String, type_feeding: String, age: Int) :
    Animal(name, type_feeding, age) {

        fun printGestation(){
            Log.d("@dev", gestation.toString())
        }
    }

// breed = raza
class Dog(val breed: String, gestation: Int, name: String, type_feeding: String, age: Int) : Mammal(
    gestation, name,
    type_feeding,
    age
){
    fun printBreed(){
        Log.d("@dev", breed)
    }
}

class Cat(val color: String, gestation: Int, name: String, type_feeding: String, age: Int) : Mammal(
    gestation, name,
    type_feeding,
    age
){
    fun printColor(){
        Log.d("@dev", color)
    }
}

class Horse(val numExercise: Int, gestation: Int, name: String, type_feeding: String, age: Int) : Mammal(
    gestation, name,
    type_feeding,
    age
){
    fun printNumExercise(){
        Log.d("@dev", numExercise.toString())
    }
}

class InheritancePlayGround(){

    fun calculateAge(animal: Animal){
        Log.d("@dev", "Edad calculada: ${animal.age}")
    }

    fun calculateGestation(mammal: Mammal){
        Log.d("@dev", "Gestación: ${mammal.gestation}")
    }

    fun calculateNumExercise(horse: Horse){
        Log.d("@dev", "Número de ejercicios: ${horse.numExercise}")
    }
}