package ru.zavanton.demo.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.demo.R
import ru.zavanton.demo.app.DemoApp
import ru.zavanton.demo.main.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    private var mainActivityComponent: MainActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initDependencies() {
        mainActivityComponent = DemoApp.getAppComponent()
            .plusMainActivityComponent(MainActivityProvideModule(this))
            .apply {
                inject(this@MainActivity)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainActivityComponent = null
    }
}
