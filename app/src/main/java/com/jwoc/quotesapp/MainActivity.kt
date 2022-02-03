package com.jwoc.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.jwoc.quotesapp.RecyclerViews.RecyclerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inialization
        val viewPager : ViewPager2 =findViewById(R.id.viewpager);

        //data's
        val message : Array<String> =arrayOf("Don't let Your happiness depend on something you may lose",
            "Fantacy is hardly An Escape From Reality It's A Way Of understanding It",
            "When Something is Important enough,you Do It Even If The Odds Aren't In Yout Favor",
            "In Life Don't react always respond",
            "It's Only Bad Day Not Bad Life",
            "All arts is kind of confussion");
        val authors : Array<String> =arrayOf("C.S.lewis","Loyd Alexander",
            "Elon Musk",
            "Sundar Pitchai",
            "Johnny Depp",
            "James Baldwin")
        viewPager.adapter = RecyclerAdapter(message,authors)
    }
}