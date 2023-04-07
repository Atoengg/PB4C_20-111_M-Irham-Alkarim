package com.example.loginpage_modul1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val username = "200441100111"
    private val password = "123"

    private lateinit var inputUsername: EditText
    private lateinit var inputPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputUsername = findViewById(R.id.inputUsername)
        inputPassword = findViewById(R.id.inputPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val usernameInput = inputUsername.text.toString().trim()
            val passwordInput = inputPassword.text.toString().trim()

            if (usernameInput != username || passwordInput != password ){
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this,"login Berhasil", Toast.LENGTH_SHORT).show()
            }
        }
    }
}