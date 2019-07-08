package com.example.testheightpicker

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.brian.heightpicker.dailog.HeightPickerDialog

class MainActivity : AppCompatActivity() {

    lateinit var  tvPicker : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvPicker = findViewById(R.id.tv_picker)
        tvPicker.setOnClickListener{
            showDailog()
        }

    }

    private fun showDailog() {
        var dialog = HeightPickerDialog(this, R.style.QuesionnaireDialog)
        dialog.setOnReturnDateListener(object : HeightPickerDialog.OnReturnValueListener {
            override fun onReturnValue(height: Int) {
                Toast.makeText(this@MainActivity,"选择了："+height,Toast.LENGTH_SHORT).show()
            }

        })
        dialog.show()
    }
}
