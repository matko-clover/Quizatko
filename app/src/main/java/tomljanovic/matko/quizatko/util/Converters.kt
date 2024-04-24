package tomljanovic.matko.quizatko.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromStringList(list: List<String>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toStringList(data: String): List<String> {
        return Gson().fromJson(data, object : TypeToken<List<String>>() {}.type)
    }
}
