package wizrole.horizontalscrollview.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


/**
 * Created by liushengping on 2018/1/27.
 * 何人执笔？
 */

public class SingleStoreFragAdapter extends FragmentPagerAdapter {

    public List<Fragment> fragments;
    public FragmentManager fm;
    public List<String> strings;
    public SingleStoreFragAdapter(List<String> strings, List<Fragment> fragments, FragmentManager fm) {
        super(fm);
        this.fragments=fragments;
        this.fm=fm;
        this.strings=strings;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=fragments.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("two_type_id",strings.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
