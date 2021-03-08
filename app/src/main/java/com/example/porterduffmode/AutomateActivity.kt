package com.example.porterduffmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.porterduffmode.databinding.ActivityAutomateBinding

class AutomateActivity : AppCompatActivity() {

    lateinit var binding: ActivityAutomateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutomateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animatiPorterDaff.mode
        binding.animateAngel.mode
    }
    override fun onPause() {
        super.onPause()
        binding.animatiPorterDaff.mode
        binding.animateAngel.mode
    }
}