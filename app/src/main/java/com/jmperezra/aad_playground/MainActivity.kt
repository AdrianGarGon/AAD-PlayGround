package com.jmperezra.aad_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jmperezra.aad_playground.ut_01.FilePlayGround
import com.jmperezra.aad_playground.ut_01.print

class MainActivity : AppCompatActivity() {

    lateinit var filePlayGround : FilePlayGround
    val colors : MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initColors()
        filePlayGround = FilePlayGround(this)
        filePlayGround.readLineByLine2()
        //filePlayGround.createFolder()
        //filePlayGround.saveToFile(colors)
        //val colorsFromFile = filePlayGround.readFromFile()
        //colorsFromFile.forEach { Log.d("@dev", it) }
        //colorsFromFile.print()
    }

    private fun initColors(){
        colors.add("Red")
        colors.add("Blue")
        colors.add("Navy Blue")
        colors.add("Orange")
    }
}