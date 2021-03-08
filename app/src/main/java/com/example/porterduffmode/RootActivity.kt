package com.example.porterduffmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.porterduffmode.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity() {

    lateinit var binding:ActivityRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnManuel.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnAnimate.setOnClickListener {
            startActivity(Intent(this, AutomateActivity::class.java))
        }
    }
}