package com.androidbegin.viewPager;

import com.androidbegin.menuviewpagertutorial.blok4;
import com.androidbegin.menuviewpagertutorial.blok6;
//import com.androidbegin.menuviewpagertutorial.blok4b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter6 extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 2;
	private String titles[] = new String[] { "Tab1" };

	public ViewPagerAdapter6(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

			// Open FragmentTab1.java
		case 0:
			blok6 fragmenttab1 = new blok6();
			return fragmenttab1;

			// Open FragmentTab2.java
//		case 1:
//			blok4b fragmenttab2 = new blok4b();
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