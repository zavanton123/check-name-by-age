package ru.zavanton.demo.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.demo.R
import ru.zavanton.demo.main.di.ActivityComponentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ActivityComponentManager.getAppComponent()
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            ActivityComponentManager.clear()
        }
    }
}
