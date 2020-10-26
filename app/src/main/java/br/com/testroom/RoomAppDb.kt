package br.com.testroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.security.AccessControlContext

@Database(entities = [User::class], version = 1)
@TypeConverters(PerfilsTypeConverter::class)
abstract class RoomAppDb: RoomDatabase() {

    abstract fun userDao(): UserDao?

    companion object {
        private var INSTANCE: RoomAppDb? = null

        fun getAppDataBase(context: Context): RoomAppDb? {
            if(INSTANCE == null) {

                INSTANCE = Room.databaseBuilder<RoomAppDb>(
                    context.applicationContext, RoomAppDb::class.java, "AppDBB"
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE
        }
    }

}