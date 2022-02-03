package com.jwoc.quotesapp.RecyclerViews
import android.content.ClipData
import  android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.jwoc.quotesapp.R

class RecyclerAdapter(array1 : Array<String>,array2 : Array<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    val message : Array<String> =array1;
    val author : Array<String> =array2;
//    var context : Context = TODO()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.template,parent,false);
//        context=parent.context
        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView_quotes.text = message[position]
        holder.textView_Author.text=author[position]
        holder.copy.setOnClickListener {
            val clipboardManager   = it.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text",message[position])
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(it.context,"Copied",Toast.LENGTH_SHORT).show()
        }
        holder.share.setOnClickListener {
            val i : Intent= Intent(Intent.ACTION_SEND)
            i.setType("text/plain")
            i.putExtra(Intent.EXTRA_TEXT,message[position])
            startActivity(it.context,Intent.createChooser(i,""),null)
        }
    }

    override fun getItemCount(): Int =message.size

    inner class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var textView_quotes : TextView
        var textView_Author : TextView
        var copy : ImageView
        var share : ImageView
        init {
            textView_quotes=itemView.findViewById(R.id.textView)
            textView_Author=itemView.findViewById(R.id.textView_author)
            copy=itemView.findViewById(R.id.copy)
            share=itemView.findViewById(R.id.share)
        }
    }
}