package ru.open.oilstone.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import ru.open.oilstone.R

abstract class BaseActivity : AppCompatActivity() {

    fun add(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(ROOT_ID, fragment).commit()
    }

    fun replace(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(ROOT_ID, fragment).commit()
    }

    fun addBackStack(fragment: Fragment, name: String) {
        supportFragmentManager.beginTransaction().add(ROOT_ID, fragment, name).addToBackStack(name).commit()
    }

    fun currentFragment(): BaseFragment? = supportFragmentManager.findFragmentById(ROOT_ID) as BaseFragment

    fun resolveToolbar(fragment: BaseFragment) {
        if (fragment.getToolbar() != null) {
            setSupportActionBar(fragment.getToolbar())
        }

        val actionBar = supportActionBar
        if (actionBar != null) {
            if (fragment.isBack()) {
                actionBar.setDisplayHomeAsUpEnabled(true)
            }
            if (fragment.getTitle() != null) {
                actionBar.title = fragment.getTitle()
            }
        }
    }

    companion object {
        val ROOT_ID = R.id.frame
    }
}