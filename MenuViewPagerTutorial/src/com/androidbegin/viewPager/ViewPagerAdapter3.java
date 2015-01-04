package com.androidbegin.viewPager;

import com.androidbegin.menuviewpagertutorial.blok3;
//import com.androidbegin.menuviewpagertutorial.blok3b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter3 extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 2;
	private String titles[] = new String[] { "Tab1", "Tab2" };

	public ViewPagerAdapter3(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

			// Open FragmentTab1.java
		case 0:
			blok3 fragmenttab1 = new blok3();
			return fragmenttab1;

			// Open FragmentTab2.java
//		case 1:
//			blok3b fragmenttab2 = new blok3b();
//			return fragmenttab2;
		}
		return null;
	}

	public CharSequence getPageTitle(int position) {
		return titles[position];
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

}