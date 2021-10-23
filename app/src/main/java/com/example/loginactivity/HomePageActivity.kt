package com.example.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.loginactivity.helper.Constant
import com.example.loginactivity.helper.PreferencesHelper

class HomePageActivity : AppCompatActivity() {

    lateinit var sharedpref: PreferencesHelper

    private val btnLogout: Button by lazy {
        findViewById(R.id.btn_logout)
    }
    private val etUsername: TextView by lazy {
        findViewById(R.id.tv_hp_user)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        sharedpref = PreferencesHelper(this)

        etUsername.text = sharedpref.getString(Constant.PREF_USERNAME)

        btnLogout.setOnClickListener{
            sharedpref.clear()
            startActivity(Intent(this, LoginActivities::class.java))
            finish()
        }
    }
}