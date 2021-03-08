package com.example.porterduffmode

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioButton
import com.example.porterduffmode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val radioList by lazy {
        listOf(
            binding.radioClear, binding.radioDarken, binding.radioDestination, binding.radioDestinationAtop,binding.radioDestinationIn,
            binding.radioDestinationOut, binding.radioDestinationOver, binding.radioLighten, binding.radioMultiply, binding.radioOverlay,
            binding.radioScreen, binding.radioSource, binding.radioSourceAtop, binding.radioSourceIn, binding.radioSourceOut,
            binding.radioSourceOver, binding.radioAdd, binding.radioXor
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listener: CompoundButton.OnCheckedChangeListener =
            CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                if (!isChecked) return@OnCheckedChangeListener
                when (buttonView.id) {
                    binding.radioClear.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.CLEAR
                        binding.textPorterDuff.text = "Clear"
                    }
                    binding.radioDarken.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.DARKEN
                        binding.textPorterDuff.text = "Darken"
                    }
                    binding.radioDestination.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.DST
                        binding.textPorterDuff.text = "Destination"
                    }
                    binding.radioDestinationAtop.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.DST_ATOP
                        binding.textPorterDuff.text = "Destination Atop"
                    }
                    binding.radioSourceAtop.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.SRC_ATOP
                        binding.textPorterDuff.text = "Source Atop"
                    }
                    binding.radioDestinationIn.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.DST_IN
                        binding.textPorterDuff.text = "Destination In"
                    }
                    binding.radioDestinationOut.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.DST_OUT
                        binding.textPorterDuff.text = "Destination Out"
                    }
                    binding.radioDestinationOver.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.DST_OVER
                        binding.textPorterDuff.text = "Destination Over"
                    }
                    binding.radioLighten.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.LIGHTEN
                        binding.textPorterDuff.text = "Lighten"
                    }
                    binding.radioMultiply.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.MULTIPLY
                        binding.textPorterDuff.text = "Multiply"
                    }
                    binding.radioOverlay.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.OVERLAY
                        binding.textPorterDuff.text = "Overlay"
                    }
                    binding.radioScreen.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.SCREEN
                        binding.textPorterDuff.text = "Screen"
                    }
                    binding.radioSource.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.SRC
                        binding.textPorterDuff.text = "Source"
                    }
                    binding.radioSourceIn.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.SRC_IN
                        binding.textPorterDuff.text = "Source In"
                    }
                    binding.radioSourceOut.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.SRC_OUT
                        binding.textPorterDuff.text = "Source Out"
                    }
                    binding.radioSourceOver.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.SRC_OVER
                        binding.textPorterDuff.text = "Source Over"
                    }
                    binding.radioAdd.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.ADD
                        binding.textPorterDuff.text = "Add"
                    }
                    binding.radioXor.id -> if (isChecked) {
                        binding.drawPorterDuff.mode = PorterDuff.Mode.XOR
                        binding.textPorterDuff.text = "Exclusive Or"
                    }
                }
                uncheckedAllExcept(buttonView as RadioButton)
            }

        radioList.forEach {
            it.setOnCheckedChangeListener(listener)
        }
    }
    private fun uncheckedAllExcept(radioButton: RadioButton) {
        radioList.filter{ it != radioButton }.forEach { it.isChecked = false }
    }
}