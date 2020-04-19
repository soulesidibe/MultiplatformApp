package com.soulesidibe.multiplatformapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.soulesidibe.multiplaform.getRandomNumber
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRandomNumber {
            lifecycleScope.launch(Dispatchers.Main) {
                idTextView.text = it
            }
        }
    }
}
