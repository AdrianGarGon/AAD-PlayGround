package com.jmperezra.aad_playground.ut_01

import java.io.File

interface DataSource {
    fun save(id: String, content: String)
    fun delete(id: String)
    fun fetch(id: String): String
    fun fetchAll(): MutableList<String>
}

class FileDataSource(private val path: String) : DataSource {

    lateinit var file: File

    init {
        file = createFile()
    }

    private fun createFile(): File {
        val file = File(path)
        if (!file.exists()) {
            file.mkdir()
        }
        return file
    }

    override fun save(id: String, content: String) {
        val file = getFile(id)
        file.writeText(content)
    }

    override fun delete(id: String) {
        val file = getFile(id)
        if (file.exists()) {
            file.delete()
        }
    }

    override fun fetch(id: String): String {
        val file = getFile(id)
        return file.readText()
    }

    override fun fetchAll(): MutableList<String> {
        return file.list()?.toMutableList() ?: mutableListOf()
    }

    private fun getFile(id: String) = File(file, id)
}

class MemDataSource() : DataSource {

    private val store: MutableMap<String, String> = mutableMapOf()

    override fun save(id: String, content: String) {
        store.put(id, content)
    }

    override fun delete(id: String) {
        store.remove(id)
    }

    override fun fetch(id: String): String {
        val value = store.get(id)
        return value!!
    }

    override fun fetchAll(): MutableList<String> {
        return store.keys.toMutableList()
    }
}