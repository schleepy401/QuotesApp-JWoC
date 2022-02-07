package com.jwoc.quotesapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jwoc.quotesapp.data.api.ApiInstance
import com.jwoc.quotesapp.data.api.Quote
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel(){
    val quotes : MutableLiveData<ArrayList<Quote>> = MutableLiveData()
    fun getQuotes(){
        viewModelScope.launch {
            try {
                quotes.value = ApiInstance.api.getQuotes().body()
            }catch (e:Exception){
                Log.d("error: ", "$e")
            }
        }
    }
}