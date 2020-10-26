package br.com.testroom

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var nome: String,
    var perfis: List<Perfil>
)

data class Perfil(
    var id: Int = 0,
    var perfil: String
)

class PerfilsTypeConverter {
    @TypeConverter
    fun listToJson(value: List<Perfil>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Perfil>::class.java).toList()
}