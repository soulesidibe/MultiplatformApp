package com.soulesidibe.multiplatformapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.soulesidibe.multiplaform.getRandomNumber
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRandomNumber(
            {
                idTextView.text = it
            },
            { message, code ->
                Toast.makeText(this, "message", Toast.LENGTH_SHORT).show()
            }
        )
    }
}
