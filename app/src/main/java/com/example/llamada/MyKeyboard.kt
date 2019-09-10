package com.example.llamada

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.LinearLayout
import android.view.View

import java.security.cert.Extension

class MyKeyboard @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {

    private var boton1: Button? = null
    private var boton2: Button? = null
    private var boton3: Button? = null
    private var boton4: Button? = null
    private var boton5: Button? = null
    private var boton6: Button? = null
    private var boton7: Button? = null
    private var boton8: Button? = null
    private var boton9: Button? = null
    private var boton0: Button? = null
    private var botonC: Button? = null
    private val keyValues = SparseArray<String>()
    private var inputConnection: InputConnection? = null

    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true)
        boton1 = findViewById<View>(R.id.boton1) as Button
        boton1!!.setOnClickListener(this)
        boton2 = findViewById<View>(R.id.boton2) as Button
        boton2!!.setOnClickListener(this)
        boton3 = findViewById<View>(R.id.boton3) as Button
        boton3!!.setOnClickListener(this)
        boton4 = findViewById<View>(R.id.boton4) as Button
        boton4!!.setOnClickListener(this)
        boton5 = findViewById<View>(R.id.boton5) as Button
        boton5!!.setOnClickListener(this)
        boton6 = findViewById<View>(R.id.boton6) as Button
        boton6!!.setOnClickListener(this)
        boton7 = findViewById<View>(R.id.boton7) as Button
        boton7!!.setOnClickListener(this)
        boton8 = findViewById<View>(R.id.boton8) as Button
        boton8!!.setOnClickListener(this)
        boton9 = findViewById<View>(R.id.boton9) as Button
        boton9!!.setOnClickListener(this)
        boton0 = findViewById<View>(R.id.boton0) as Button
        boton0!!.setOnClickListener(this)
        botonC = findViewById<View>(R.id.botonC) as Button
        botonC!!.setOnClickListener(this)

        keyValues.put(R.id.boton1, "1")
        keyValues.put(R.id.boton2, "2")
        keyValues.put(R.id.boton3, "3")
        keyValues.put(R.id.boton4, "4")
        keyValues.put(R.id.boton5, "5")
        keyValues.put(R.id.boton6, "6")
        keyValues.put(R.id.boton7, "7")
        keyValues.put(R.id.boton8, "8")
        keyValues.put(R.id.boton9, "9")
        keyValues.put(R.id.boton0, "0")
    }


    override fun onClick(view: View) {
        if (inputConnection == null)
            return
        if (view.id == R.id.botonC) {
            val selectedText = inputConnection!!.getSelectedText(0)
            if (TextUtils.isEmpty(selectedText)) {
                inputConnection!!.deleteSurroundingText(1, 0)
            } else {
                inputConnection!!.commitText("", 1)
            }
        } else {
            val value = keyValues.get(view.id)
            inputConnection!!.commitText(value, 1)
        }
    }


    fun setInputConnection(ic: InputConnection) {
        inputConnection = ic
    }
}
