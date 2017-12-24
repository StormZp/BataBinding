package com.storm.batabinding.ui.act

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.storm.batabinding.R
import com.storm.batabinding.databinding.ActivityMainBinding
import com.storm.batabinding.ui.fragment.BlankVlayoutFragment
import com.storm.batabinding.ui.fragment.MainFragment
import com.storm.batabinding.ui.fragment.MineFragment
import com.storm.tool.base.BaseActivity
import com.storm.tool.utils.LogUtil


class MainActivity : BaseActivity<ActivityMainBinding>() {

//    var testServable: Subscription? = null;


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding(R.layout.activity_main)
    }

    override fun initData() {
        binding.bottom.addItem(BottomNavigationItem(R.mipmap.backtop, "首页"))
                .addItem(BottomNavigationItem(R.mipmap.backtop, "内容"))
                .addItem(BottomNavigationItem(R.mipmap.backtop, "个人中心")).initialise()

        binding.frame.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                when (position) {
                    1 -> return BlankVlayoutFragment.newInstance("展示", "展示")
                    2 -> return MineFragment.newInstance("中心", "中心")
                }
                return MainFragment.newInstance("首页", "首页")
            }

            override fun getCount(): Int {
                return 3
            }
        }
        binding.frame.setNoScroll(false)

    }

    override fun initTitle() {

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun initListener() {
        binding.frame.setOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
                LogUtil.error("onPageScrollStateChanged")
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
            }
        })
        binding.bottom.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabUnselected(position: Int) {

            }

            override fun onTabSelected(position: Int) {
                binding.frame.setCurrentItem(position, false)
            }

            override fun onTabReselected(position: Int) {

            }
        })
    }
}
