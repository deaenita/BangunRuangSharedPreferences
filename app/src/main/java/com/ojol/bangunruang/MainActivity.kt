package com.ojol.bangunruang
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var etNumberOne: EditText
    private lateinit var etNumberTwo: EditText
    private lateinit var tvResult: TextView
    private lateinit var container: SharedPreferences
    private var nilai = 0.0f
    private val SHARED = "KeyShared"
    private val RESULT = "ResultCac"
    private val ETONE = "EtOne"
    private val ETTWO = "EtTwo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumberOne = findViewById(R.id.et_number_one)
        etNumberTwo = findViewById(R.id.et_number_two)
        tvResult = findViewById(R.id.tv_result)
        container = getSharedPreferences(SHARED, Context.MODE_PRIVATE)
        val btnPlus = findViewById<Button>(R.id.btn_plus)
        val btnMin = findViewById<Button>(R.id.btn_min)
        val btnMul = findViewById<Button>(R.id.btn_mul)
        val btnDiv = findViewById<Button>(R.id.btn_div)
        btnPlus.setOnClickListener {
            nilai = etNumberOne.text.toString().toFloat() + etNumberTwo.text.toString().toFloat()
            tvResult.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(ETONE, etNumberOne.text.toString())
            editor.putString(ETTWO, etNumberTwo.text.toString())
            editor.apply()
        }
        btnMin.setOnClickListener {
            nilai = etNumberOne.text.toString().toFloat() - etNumberTwo.text.toString().toFloat()
            tvResult.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(ETONE, etNumberOne.text.toString())
            editor.putString(ETTWO, etNumberTwo.text.toString())
            editor.apply()
        }
        btnMul.setOnClickListener {
            nilai = etNumberOne.text.toString().toFloat() * etNumberTwo.text.toString().toFloat()
            tvResult.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(ETONE, etNumberOne.text.toString())
            editor.putString(ETTWO, etNumberTwo.text.toString())
            editor.apply()
        }
        btnDiv.setOnClickListener {
            nilai = etNumberOne.text.toString().toFloat() / etNumberTwo.text.toString().toFloat()

            tvResult.text = nilai.toString()
            val editor = container.edit()
            editor.putFloat(RESULT, nilai)
            editor.putString(ETONE, etNumberOne.text.toString())
            editor.putString(ETTWO, etNumberTwo.text.toString())
            editor.apply()
        }
        val getResultCalc = container.getFloat(RESULT, 0.0f)
        val getResultEtONE =
        container.getString(ETONE, "")
        val getResultEtTwo = container.getString(ETTWO, "")
        tvResult.text = getResultCalc.toString()
        etNumberOne.setText(getResultEtONE)
        etNumberTwo.setText(getResultEtTwo)

        //Persegi
        findViewById<Button>(R.id.btn_persegi).setOnClickListener() {
            intent = Intent(this, PersegiActivity::class.java)
            startActivity(intent)
        }

        //Segitiga
        findViewById<Button>(R.id.btn_segitiga).setOnClickListener() {
            intent = Intent(this, SegitigaActivity::class.java)
            startActivity(intent)
        }

    }
}