package com.jmperezra.aad_playground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.ut_01.FilePlayGround

class MainActivity : AppCompatActivity() {

    lateinit var filePlayGround: FilePlayGround
    val colors: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //save a list of string in a file.
        initColors()
        filePlayGround = FilePlayGround(this)
        filePlayGround.saveToFile(colors)

        //fetch a list of string from a file
        val colorsFromFile = filePlayGround.readFromFile()
        colorsFromFile.forEach { Log.d("@dev", it) }
    }

    private fun initColors() {
        colors.add("Red")
        colors.add("Blue")
        colors.add("Navy Blue")
        colors.add("Orange")
    }
}