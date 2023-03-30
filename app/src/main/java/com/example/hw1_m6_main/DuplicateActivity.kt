package com.example.hw1_m6_main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hw1_m6_main.MainActivity.Companion.MA_DU_TEXT
import com.example.hw1_m6_main.databinding.ActivityDuplicateBinding

class DuplicateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDuplicateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDuplicateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initClickers()
    }


    private fun initClickers() {
        with(binding) {
            btnToMainActivity.setOnClickListener {
                val data2 = binding.
                    etSecondText.text
                if (data2.isNullOrEmpty()) {
                    Toast.makeText(this@DuplicateActivity, "Can not be empty!", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent()
                    intent.putExtra(DU_MA_TEXT, binding.etSecondText.text.toString())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }
    }

    private fun initView() {
        val text = intent.getStringExtra(MA_DU_TEXT)
        binding.etSecondText.setText(text)
    }

    companion object {
        const val DU_MA_TEXT = "duMaText"
    }
}