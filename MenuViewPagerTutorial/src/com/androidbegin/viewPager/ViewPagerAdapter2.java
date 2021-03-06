package com.androidbegin.viewPager;

import com.androidbegin.menuviewpagertutorial.blok2;
//import com.androidbegin.menuviewpagertutorial.blok2b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter2 extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 2;
	private String titles[] = new String[] { "Tab1", "Tab2" };

	public ViewPagerAdapter2(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

			// Open FragmentTab1.java
		case 0:
			blok2 fragmenttab1 = new blok2();
			
			return fragmenttab1;

			// Open FragmentTab2.java
//		case 1:
//			blok2b fragmenttab2 = new blok2b();
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