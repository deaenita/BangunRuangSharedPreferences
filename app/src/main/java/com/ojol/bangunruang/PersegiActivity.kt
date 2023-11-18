package com.ojol.bangunruang

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class PersegiActivity : AppCompatActivity() {
    private lateinit var etPanjang: EditText
    private lateinit var etLebar: EditText
    private lateinit var tvResult: TextView
    private lateinit var container: SharedPreferences
    private var nilai = 0.0f
    private val SHARED = "KeyShared"
    private val RESULT = "ResultCac"
    private val ETPANJANG = "EtPanjang"
    private val ETLEBAR = "EtLebar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persegi)

        etPanjang = findViewById(R.id.editTextPanjang)
        etLebar = findViewById(R.id.editTextLebar)
        tvResult = findViewById(R.id.textViewHasil)
        container = getSharedPreferences(SHARED, Context.MODE_PRIVATE)
        val btnHitungLuas = findViewById<Button>(R.id.buttonHitungLuas)

        btnHitungLuas.setOnClickListener{
            nilai = etPanjang.text.toString().toFloat() * etLebar.text.toString().toFloat()
            tvResult.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(ETPANJANG, etPanjang.text.toString())
            editor.putString(ETLEBAR, etLebar.text.toString())
            editor.apply()
        }

        val getResultCalc = container.getFloat(RESULT, 0.0f)
        val getResultPanjang = container.getString(ETPANJANG, "")
        val getResultLebar = container.getString(ETLEBAR, "")
        tvResult.text = getResultCalc.toString()
        etPanjang.setText(getResultPanjang)
        etLebar.setText(getResultLebar)

        //Back to Home
        findViewById<Button>(R.id.btn_kembali_home).setOnClickListener() {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}