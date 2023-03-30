package com.example.hw1_m6_main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.hw1_m6_main.DuplicateActivity.Companion.DU_MA_TEXT
import com.example.hw1_m6_main.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val resultLauncher: ActivityResultLauncher<Intent> by lazy {
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK && activityResult.data != null) {
                binding.etFirstText.setText(activityResult.data!!.getStringExtra(DU_MA_TEXT))
            }
        }
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnToDuplicateActivity.setOnClickListener {
                val data = binding.etFirstText.text
                if (data.isNullOrEmpty()) {
                    Toast.makeText(this@MainActivity, "Can not be empty!", Toast.LENGTH_SHORT).show()
                } else {
                    Intent(this@MainActivity, DuplicateActivity::class.java).apply {
                        putExtra(MA_DU_TEXT, etFirstText.text.toString())
                        resultLauncher.launch(this)
                    }
                }
            }
        }
    }

    companion object {
        const val MA_DU_TEXT = "maDuText"
    }
}
