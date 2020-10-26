package br.com.testroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userDao = RoomAppDb.getAppDataBase(this)?.userDao()!!

        inserir.setOnClickListener { inserir() }
        listar.setOnClickListener { listar() }
    }

    fun inserir(){

        val perfil =  Perfil(0, "perfil 1")
        val perfil2 =  Perfil(0, "perfil 2")

        val arraysPerfil = ArrayList<Perfil>()
        arraysPerfil.add(perfil)
        arraysPerfil.add(perfil2)

        val user = User(0, "User 1", arraysPerfil)

        userDao.insertUser(user)

        Toast.makeText(this, "Inserir", Toast.LENGTH_LONG).show()
    }

    fun listar() {

        val allUser = userDao.getAllUser()

        Toast.makeText(this, allUser.toString(), Toast.LENGTH_LONG).show()
    }
}