package com.androidbegin.viewPager;

import com.androidbegin.menuviewpagertutorial.blok5a;
import com.androidbegin.menuviewpagertutorial.blok5b;
import com.androidbegin.menuviewpagertutorial.blok5c;
import com.androidbegin.menuviewpagertutorial.blok5d;
import com.androidbegin.menuviewpagertutorial.blok5e;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter5 extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 5;
	private String titles[] = new String[] { "Keterangan Kesehatan", 
											"Kesehatan Balita", "Keterangan Pendidikan",
											"Ketenagakerjaan","Fertilitas dan KB"};

	public ViewPagerAdapter5(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		
		case 0:
			blok5a fragmenttab1 = new blok5a();
			return fragmenttab1;

		case 1:
			blok5b fragmenttab2 = new blok5b();
			return fragmenttab2;
			
		case 2:
			blok5c fragmenttab3 = new blok5c();
			return fragmenttab3;
			
		case 3:
			blok5d fragmenttab4 = new blok5d();
			return fragmenttab4;
		
		case 4:
			blok5e fragmenttab5 = new blok5e();
			return fragmenttab5;
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