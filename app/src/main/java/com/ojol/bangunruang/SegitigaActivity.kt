package com.ojol.bangunruang

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SegitigaActivity : AppCompatActivity() {
    private lateinit var etAlas: EditText
    private lateinit var etTinggi: EditText
    private lateinit var tvResult: TextView
    private lateinit var container: SharedPreferences
    private var nilai = 0.0f
    private val SHARED = "KeyShared"
    private val RESULT = "ResultCac"
    private val ETALAS = "EtAlas"
    private val ETTINGGI = "EtTinggi"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segitiga)

        etAlas = findViewById(R.id.editTextAlas)
        etTinggi = findViewById(R.id.editTextTinggi)
        tvResult = findViewById(R.id.textViewHasil)
        container = getSharedPreferences(SHARED, Context.MODE_PRIVATE)
        val btnHitungLuas = findViewById<Button>(R.id.buttonHitungLuas)

        btnHitungLuas.setOnClickListener{
            nilai = etAlas.text.toString().toFloat() * etTinggi.text.toString().toFloat() * 0.5f
            tvResult.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(ETALAS, etAlas.text.toString())
            editor.putString(ETTINGGI, etTinggi.text.toString())
            editor.apply()
        }

        val getResultCalc = container.getFloat(RESULT, 0.0f)
        val getResultAlas = container.getString(ETALAS, "")
        val getResultTinggi = container.getString(ETTINGGI, "")
        tvResult.text = getResultCalc.toString()
        etAlas.setText(getResultAlas)
        etTinggi.setText(getResultTinggi)

        //Back to Home
        findViewById<Button>(R.id.btn_kembali_home).setOnClickListener() {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}