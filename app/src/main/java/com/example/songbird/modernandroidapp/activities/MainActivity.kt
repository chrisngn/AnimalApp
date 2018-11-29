package com.example.songbird.modernandroidapp.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.example.songbird.modernandroidapp.activities.fact.FactFragment
import com.example.songbird.modernandroidapp.R
import com.example.songbird.modernandroidapp.activities.cat.PhotoFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
    }

    private fun setupUI() {
        viewPager.adapter = SectionsPagerAdapter(this, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    //    fun launchFragment() {
    //        supportFragmentManager
    //            .beginTransaction()
    //            .add(R.id.fragmentContainer, PhotoFragment.newInstance())
    //            .commit()
    //    }

}

class SectionsPagerAdapter(var activity: AppCompatActivity, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    companion object {
        private const val NUM_PAGES = 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PhotoFragment.newInstance()
            1 -> FactFragment.newInstance()
            else -> throw IllegalStateException("Trying to go beyond 2 pages")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> activity.getString(R.string.cat_title)
            1 -> activity.getString(R.string.fact_title)
            else -> super.getPageTitle(position)
        }
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }

}
