package com.jwoc.quotesapp.RecylerView

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jwoc.quotesapp.R

class RecyclerViewAdapter(array1 : ArrayList<String>,array2 : ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    val quotes : ArrayList<String> =array1;
    val author : ArrayList<String> =array2;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.template,parent,false);
        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView_quotes.text = quotes[position]
        holder.textView_Author.text=author[position]
        holder.copy.setOnClickListener {
            val clipboardManager   = it.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text",quotes[position])
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(it.context,"Copied",Toast.LENGTH_SHORT).show()
        }
        holder.share.setOnClickListener {
            val i : Intent = Intent(Intent.ACTION_SEND)
            i.setType("text/plain")
            i.putExtra(Intent.EXTRA_TEXT,quotes[position])
            startActivity(it.context,Intent.createChooser(i,""),null)
        }
    }

    override fun getItemCount(): Int =quotes.size

    inner class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var textView_quotes : TextView
        var textView_Author : TextView
        var copy : FloatingActionButton
        var share : FloatingActionButton
        init {
            textView_quotes=itemView.findViewById(R.id.quoteText)
            textView_Author=itemView.findViewById(R.id.quoteAuthor)
            copy=itemView.findViewById(R.id.copy_icon)
            share=itemView.findViewById(R.id.share_icon)
        }
    }
}