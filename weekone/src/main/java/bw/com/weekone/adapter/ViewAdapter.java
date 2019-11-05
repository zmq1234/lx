package bw.com.weekone.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Time:2019/11/4
 * Author:周盟棋
 * Description:
 */
public class ViewAdapter extends FragmentPagerAdapter {

    ArrayList<String> list;
    ArrayList<Fragment> fragments;

    public ViewAdapter(FragmentManager fm,ArrayList<String> list, ArrayList<Fragment> fragments) {
        super(fm);
        this.list=list;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
