package com.jmperezra.aad_playground.ut01

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import kotlin.io.path.*

/**
 *
 *
 * @link https://developer.android.com/studio/debug/device-file-explorer
 *
 */
class FilePlayGround(private val activity: AppCompatActivity) {

    init {
        //writeFile()
        //appendTextInFile()
        //readFile()
        //readLineByLine()
        //createFolder()
    }

    /**
     * Ver el fichero creado en: data/data/app_name
     */
    fun createFile() {
        val file = File(activity.filesDir, "aad.txt")
    }

    fun writeFile() {
        val file = File(activity.filesDir, "aad.txt")
        file.writeText("Hola Acceso a Datos")
    }

    fun readFile() {
        val file = File(activity.filesDir, "aad.txt")
        val content = file.readText()
        Log.d("@dev", "Contenido: $content")
    }

    fun appendTextInFile() {
        val file = File(activity.filesDir, "aad.txt")
        file.appendText("\n")
        file.appendText("Hola")
    }

    fun readLineByLine2() {
        val file = File(activity.filesDir, "aad.txt")
        val lines = file.readLines()
        lines.forEach {
            Log.d("@dev", it)
        }
    }

    fun readLineByLine() {
        val file = File(activity.filesDir, "aad.txt")
        if (file.exists()) {
            val fileInputStream = FileInputStream(file)
            val reader = BufferedReader(InputStreamReader(fileInputStream))
            var line = reader.readLine()
            while (line != null) {
                Log.d("@dev", line)
                line = reader.readLine()
            }
        }
    }

    fun deleteFile() {
        val file = File(activity.filesDir, "aad.txt")
        file.delete()
    }

    fun saveToFile(colors: MutableList<String>) {
        val file = File(activity.filesDir, "aad_colors.txt")
        if (file.exists()) {
            file.writeText("")
        }
        colors.forEach { color ->
            run{
                file.appendText(color)
                file.appendText("\n")
            }
        }
    }

    fun readFromFile(): MutableList<String> {
        val file = File(activity.filesDir, "aad_colors.txt")
        return if (file.exists()) {
            file.readLines().toMutableList()
        } else {
            mutableListOf()
        }
    }

    fun createFolder() {
        var path = Path(activity.filesDir.canonicalPath + "/documents")
        path.deleteIfExists()
        path.createDirectory()
        if (path.exists()){

        }
    }

    fun createFileInFolder(){
        val file = File(activity.filesDir, "/documents/aad.txt")
        file.createNewFile()
    }

    fun listFilesInFolder(){
        val file = File(activity.filesDir, "/documents")
        val files = file.list()
        files.forEach {
            Log.d("@dev", "File: $it")
        }
    }


}