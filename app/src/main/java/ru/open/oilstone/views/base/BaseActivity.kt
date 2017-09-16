package ru.open.oilstone.views.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import ru.open.oilstone.R

abstract class BaseActivity : AppCompatActivity() {

    fun add(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.frame, fragment).commit()
    }

    fun replace(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

    fun addBackStack(fragment: Fragment, name: String) {
        supportFragmentManager.beginTransaction().add(R.id.frame, fragment, name).addToBackStack(name).commit()
    }
}