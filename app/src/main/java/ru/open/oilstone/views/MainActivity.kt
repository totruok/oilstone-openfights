package ru.open.oilstone.views

import android.os.Bundle
import ru.open.oilstone.R
import ru.open.oilstone.views.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
