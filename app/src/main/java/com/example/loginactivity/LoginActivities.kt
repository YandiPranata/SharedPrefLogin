package com.example.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.loginactivity.helper.Constant
import com.example.loginactivity.helper.PreferencesHelper

class LoginActivities : AppCompatActivity() {

    lateinit var sharedpref: PreferencesHelper

    private val btnLogin: Button by lazy {
        findViewById(R.id.btn_secondpage_login)
    }

    private val etId: EditText by lazy {
        findViewById(R.id.et_secondpage_id)
    }

    private val etPassword: EditText by lazy {
        findViewById(R.id.editTextTextPassword)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activities)

        sharedpref = PreferencesHelper(this)

        btnLogin.setOnClickListener{
            if (etId.text.isNotEmpty() && etId.text.isNotEmpty()) {
                saveSession(etId.text.toString(), etPassword.text.toString())
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
                moveIntent()
            }
        }
    }

    private fun saveSession(username: String , password: String) {
        sharedpref.put(Constant.PREF_USERNAME, username)
        sharedpref.put(Constant.PREF_PASSWORD, password)
        sharedpref.put(Constant.PREF_IS_LOGIN, true)
    }

    override fun onStart() {
        super.onStart()
        if (sharedpref.getBoolean(Constant.PREF_IS_LOGIN)) {
            moveIntent()
        }

    }

    private fun moveIntent() {
        startActivity(Intent(this, HomePageActivity::class.java))
        finish()
    }
}