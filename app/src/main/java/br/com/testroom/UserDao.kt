package br.com.testroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAllUser(): List<User>

    @Insert
    fun insertUser(user: User)

}