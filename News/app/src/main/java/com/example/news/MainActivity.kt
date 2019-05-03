package com.example.news

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpager.adapter = ViewPagerAdapter(supportFragmentManager)
        tablayout.setupWithViewPager(viewpager)
    }
    class ViewPagerAdapter(fm : FragmentManager?): FragmentPagerAdapter(fm)
    {
        override fun getItem(p0: Int): Fragment {
            return when(p0)
            {
                0 -> A()
                1 -> B()
                else ->
                {
                    A()
                }
            }
        }

        override fun getCount(): Int = 2
        override fun getPageTitle(position: Int): CharSequence? {
            return when(position)
            {
                 0 -> "News"
                1 -> "Notes"

                else -> "Others"
            }
        }
    }
}
