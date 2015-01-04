package com.androidbegin.viewPager;

import com.androidbegin.menuviewpagertutorial.awal1;
import com.androidbegin.menuviewpagertutorial.awal2;
import com.androidbegin.menuviewpagertutorial.awal3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapterAwal extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 3;
	private String titles[] = new String[] { "Selamat Datang", "Perhatian","Daftar" };

	public ViewPagerAdapterAwal(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {

			// Open FragmentTab1.java
		case 0:
			awal1 fragmenttab1 = new awal1();
			return fragmenttab1;

			// Open FragmentTab2.java
		case 1:
			awal2 fragmenttab2 = new awal2();
			return fragmenttab2;
		case 2:
			awal3 fragmenttab3 = new awal3();
			return fragmenttab3;
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