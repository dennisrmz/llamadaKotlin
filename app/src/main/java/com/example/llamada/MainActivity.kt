package com.example.llamada

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var botonLlamar : Button?=null
    var loadingContainer :View? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<View>(R.id.editText) as EditText
        val keyboard = findViewById<View>(R.id.keyboard) as MyKeyboard
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT)
        editText.setTextIsSelectable(true)

        val ic = editText.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic)

        botonLlamar = findViewById(R.id.botonLlamar)
        botonLlamar!!.setOnClickListener { showLoading(true) }
        loadingContainer = findViewById(R.id.loadingContainer)
        loadingContainer!!.setOnClickListener { showLoading(false) }
    }
    private fun showLoading(show: Boolean) {
        val visibility = if(show) View.VISIBLE else View.GONE
        loadingContainer!!.visibility = visibility
        val visibility1 = if(show) View.GONE else View.VISIBLE

        botonLlamar!!.visibility = visibility1
    }
}
