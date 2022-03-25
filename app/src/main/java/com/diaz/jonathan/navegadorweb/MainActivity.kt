package com.diaz.jonathan.navegadorweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var miWeb: WebView
    lateinit var etURL: EditText
    lateinit var btnEnviar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        miWeb = findViewById(R.id.nav)
        etURL = findViewById(R.id.textURL)
        btnEnviar = findViewById(R.id.btnEnviar)

        btnEnviar.setOnClickListener() {
            Log.d("click botton", "click botton")
            val texto = etURL.text.toString()
            if (texto.equals("")) {
                Toast.makeText(this, "Ingresa minimo algo", Toast.LENGTH_SHORT).show()
            } else {
                validaEntrada(texto)
            }
        }
        miWeb.loadUrl("https://www.google.com")
        miWeb.settings.javaScriptEnabled = true
        miWeb.settings.allowContentAccess = true
        miWeb.settings.domStorageEnabled = true
        miWeb.settings.useWideViewPort = true
        miWeb.settings.setAppCacheEnabled(true)

    }
    fun validaEntrada(input:String){
        if (input.startsWith("www") or input.startsWith("https://")) {
            miWeb.loadUrl(input)
        }else{
            miWeb.loadUrl("https://google.com/search/q=$input")
        }
    }
}