package com.jmperezra.aad_playground.ut01

import android.app.Activity
import java.io.File

/**
 * Android dispone de cuatro formas de guardar la información:
 *  1. Específicos: sólo pueden acceder a los ficheros la propia aplicación.
 *  2. Compartida: los ficheros se pueden compartir con otras aplicaciones.
 *  3. Clave-Valor.
 *  4. Bases de datos.
 *
 */
class DataStorageType (private val activity: Activity) {

    /**
     * Fichero específico de la app en el directorio de la aplicación.
     * Las aplicaciones externas no pueden acceder a estos ficheros.
     * No se necesitan permisos especiales.
     * Los ficheros desaparecen si se desinstala la aplicación.
     */
    fun privateFile(){
        val file = File(activity.filesDir, "private.txt")
        file.writeText("Hola!")
    }

    /**
     * Fichero específico de la app en el directorio de la caché.
     * Las aplicaciones externas no pueden acceder a estos ficheros.
     * No se necesitan permisos especiales.
     * Los ficheros desaparecen si se desinstala la aplicación.
     */
    fun privateCacheFile(){
        val cacheFile = File(activity.cacheDir, "private_cache.txt")
        cacheFile.writeText("Hola!")
    }

    /**
     * Fichero específico de la app en un medio externo.
     * Las aplicaciones externas no pueden acceder a estos ficheros.
     * No se necesitan permisos especiales cuando la app es usada en dispositivos con la versión
     * api 19 (4.4) o posterior.
     * Los ficheros desaparecen si se desinstala la aplicación.
     */
    fun privateExternalFile(){
        val externalFile = File(activity.getExternalFilesDir("path_directory"), "external_private_file.txt")
        externalFile.writeText("Hola!")
    }

    /**
     * Fichero específico de la app de caché en un medio externo.
     * Las aplicaciones externas no pueden acceder a estos ficheros.
     * No se necesitan permisos especiales cuando la app es usada en dispositivos con la versión
     * api 19 (4.4) o posterior.
     * Los ficheros desaparecen si se desinstala la aplicación.
     */
    fun privateExternalCacheFile(){
        val externalFile = File(activity.getExternalFilesDir("path_directory"), "external_private_cache.txt")
        externalFile.writeText("Hola!")
    }

    /**
     * Ficheros para ser compartido con otras aplicaciones: vídeo, música, fotos...
     * Las aplicaciones externas pueden acceder a estos ficheros siempre que tengan los permisos de lectura en disco.
     * Se necesita el permiso de lectura si es la versión Api Level 30 o superior (Android 11)
     * Se necesita el permiso de lectura/escritura si es la versión Api Level 29 o superior (Android 10)
     * Se necesita el permiso para todos los ficheros si la versión es Api Level 28 o anterior (Android 9)
     * Los ficheros desaparecen si se desinstala la aplicación.
     */
    fun mediaStore(){

    }
}