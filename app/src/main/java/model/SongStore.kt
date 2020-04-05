package model

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object SongStore {

    private val TAG = "CreatureStore"

    private lateinit var songs: List<Song>

    fun loadSongs(context: Context) {
        val gson = Gson()
        val json = loadJSONFromAsset("songs.json", context)
        val listType = object : TypeToken<List<Song>>() {}.type
        songs = gson.fromJson(json, listType)
        songs
            .forEach { it.isFavorite = true }
        Log.v(TAG, "Found ${songs.size} creatures")
    }

    fun getSongs() = songs

    fun getSongById(id: Int) = songs.firstOrNull { it.id == id }

    private fun loadJSONFromAsset(filename: String, context: Context): String? {
        var json: String? = null
        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: IOException) {
            Log.e(TAG, "Error reading from $filename", ex)
        }
        return json
    }
}