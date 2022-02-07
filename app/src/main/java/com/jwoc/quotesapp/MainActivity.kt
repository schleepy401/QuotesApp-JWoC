package com.jwoc.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.jwoc.quotesapp.App.Companion.appContext
import com.jwoc.quotesapp.RecylerView.RecyclerViewAdapter
import com.jwoc.quotesapp.databinding.ActivityMainBinding
import com.jwoc.quotesapp.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    val message :ArrayList<String> = arrayListOf()
    val authors: ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding!!.root
        setContentView(view)

        //initialization
        val viewPager: ViewPager2 = findViewById(R.id.viewpager)
        val viewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        Log.d("this", "$message")

        if (!appContext!!.isOnline && message.isEmpty() && authors.isEmpty()) {
            Snackbar.make(view, "Please connect to internet", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK") {
                        this.recreate()
                    }
                    .show()
        }
        viewModel.getQuotes()
        viewModel.quotes.observe(this) {
            for (i in it.indices) {
                message.add(it[i].quote)
                authors.add(it[i].author)
            }
            viewPager.adapter = RecyclerViewAdapter(message, authors)
        }
    }
}