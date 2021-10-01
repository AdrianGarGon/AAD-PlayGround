package com.jmperezra.aad_playground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.commons.inheritance.Animal
import com.jmperezra.aad_playground.commons.inheritance.Cat
import com.jmperezra.aad_playground.commons.inheritance.InheritancePlayGround
import com.jmperezra.aad_playground.commons.inheritance.Mammal
import com.jmperezra.aad_playground.ut_01.DataStorageType
import com.jmperezra.aad_playground.ut_01.FilePlayGround


class MainActivity : AppCompatActivity() {

    lateinit var filePlayGround: FilePlayGround
    val colors: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //exerciseFiles()
        //exerciseInheritance()
        //exerciseDataStorageType()
    }

    private fun exerciseFiles() {
        //save a list of string in a file.
        initColors()
        filePlayGround = FilePlayGround(this)
        filePlayGround.createFolder()

        //filePlayGround.saveToFile(colors)
        //fetch a list of string from a file
        //val colorsFromFile = filePlayGround.readFromFile()
        //colorsFromFile.forEach { Log.d("@dev", it) }

    }

    private fun initColors() {
        colors.add("Red")
        colors.add("Blue")
        colors.add("Navy Blue")
        colors.add("Orange")
    }

    private fun exerciseInheritance() {

        val animal = Animal("Dino", "Omnívoro", 1)
        animal.printTypeFeeding()

        val mammal = Mammal(3, "Pepe", "Hervívoro", 10)
        mammal.printGestation()

        val cat = Cat("blanco", 2, "Tux", "Carnivoro", 7)
        cat.printColor()


        val iniheritance = InheritancePlayGround()
        iniheritance.calculateAge(animal)
        iniheritance.calculateAge(mammal)
        iniheritance.calculateAge(cat)

        //error -> iniheritance.calculateGestation(animal)
    }

    private fun exerciseDataStorageType() {
        val dataStorageType = DataStorageType(this)
        dataStorageType.privateCacheFile()
        //dataStorageType.privateExternalFile()
    }
}