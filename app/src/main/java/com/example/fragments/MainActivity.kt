package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = myviewpadapter(supportFragmentManager)
        adapter.addfragment(frag1(),title = "one")
        adapter.addfragment(frag2(),title = "two")
        adapter.addfragment(frag3(),title = "three")
        viewpager.adapter= adapter
        tablay.setupWithViewPager(viewpager)
            }

    class myviewpadapter(manager:FragmentManager):FragmentPagerAdapter(manager) {

        private val fraglist:MutableList<Fragment> = ArrayList()
        private val titletist:MutableList<String> = ArrayList()

        override fun getCount(): Int {
            return fraglist.size
        }

        override fun getItem(position: Int): Fragment {
            return fraglist[position]
        }
        fun addfragment(fragment: Fragment,title:String)
        {
            fraglist.add(fragment)
            titletist.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titletist[position]
        }

    }
}
