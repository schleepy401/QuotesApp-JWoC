package com.jwoc.quotesapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class Splash_Screen : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT < 16) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        } else {
            val decorView = window.decorView
            val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
            decorView.systemUiVisibility = uiOptions
            val actionBar: android.app.ActionBar? = actionBar
            actionBar?.hide()
        }
        setContentView(R.layout.activity_splash_screen)
       //this one is for hiding taskBar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        //variables for animation
       // Animation topAnim,bottomAnim
        val backgroundImg : ImageView = findViewById(R.id.iv_logo)
        val topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        backgroundImg.startAnimation(topAnim)

        val textView1 : TextView = findViewById(R.id.textView1)
        val bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_navigation)
        textView1.startAnimation(bottomAnim)

        val textView2 : TextView = findViewById(R.id.textView1)
        val bottomAnim2 = AnimationUtils.loadAnimation(this,R.anim.bottom_navigation)
        textView2.startAnimation(bottomAnim2)

        Handler().postDelayed({
            startActivity(Intent(this,AboutApp::class.java))
            finish()
        },5000)



    }
}