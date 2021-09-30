package com.jmperezra.aad_playground.ut_01

import android.util.Log

fun MutableList<String>.print(){
    this.forEach {
        Log.d("@dev", it)
    }
}