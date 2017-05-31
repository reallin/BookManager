package com.book.csdc.bookmanager.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.book.csdc.bookmanager.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDetail.setOnClickListener{
            enterDetail()
        }
    }

    fun enterDetail(){
        startActivity<BookDetailActivity>()
    }
}
