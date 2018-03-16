package wizrole.horizontalscrollview.activity;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import wizrole.horizontalscrollview.R;
import wizrole.horizontalscrollview.activity.fragment.Fragment_TabLayout;
import wizrole.horizontalscrollview.adapter.SingleStoreFragAdapter;

/**
 * Created by liushengping on 2018/3/16.
 * 何人执笔？
 */

public class TabLayoutActivity extends AppCompatActivity {

    public TabLayout tab_layout;
    public ViewPager viewPager;
    public List<Fragment> fragments;
    public List<String> tabList=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        initUI();
//        reflex();//该方法会导致滑动后一刹那位移界面
        setViewPager();
        initTab();
    }
    public void initUI(){
        tab_layout=(TabLayout)findViewById(R.id.tab_layout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);

        tabList.add("推荐");
        tabList.add("关注");
        tabList.add("视频");
        tabList.add("北京");
        tabList.add("音乐");
        tabList.add("体育");
        tabList.add("娱乐");
        tabList.add("体育");
    }

    public void setViewPager() {
        fragments = new ArrayList<Fragment>();
        for (int i = 0; i < tabList.size(); i++) {
            if (i == 0) {
                fragments.add(Fragment_TabLayout.newInstance(1, false));
            } else {
                fragments.add(Fragment_TabLayout.newInstance(i + 1, true));
            }
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        SingleStoreFragAdapter adapter = new SingleStoreFragAdapter(tabList, fragments, supportFragmentManager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(fragments.size());
        tab_layout.setupWithViewPager(viewPager);

    }

    /***
     * 设置TabLayout的字体样式
     */
    public void initTab() {
        for (int i = 0; i < tabList.size(); i++) {
            TabLayout.Tab tab = tab_layout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(getTabView(i));
            }
        }
        updateTabTextView(tab_layout.getTabAt(tab_layout.getSelectedTabPosition()), true);
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTabTextView(tab, true);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabTextView(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private View getTabView(int currentPosition) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_name, null);
        TextView textView = (TextView) view.findViewById(R.id.tab_item_textview);
        textView.setText(tabList.get(currentPosition));
        return view;
    }

    private void updateTabTextView(TabLayout.Tab tab, boolean isSelect) {
        if (isSelect) {
            for (int i = 0; i < tabList.size(); i++) {
                TabLayout.Tab all_tab = tab_layout.getTabAt(i);
                if (all_tab != null) {
                    TextView tabSelect = (TextView) all_tab.getCustomView().findViewById(R.id.tab_item_textview);
                    tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    tabSelect.setAlpha(0.5f);
                }
            }
            //选中加粗
            TextView tabSelect = (TextView) tab.getCustomView().findViewById(R.id.tab_item_textview);
            tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tabSelect.setText(tab.getText());
            tabSelect.setAlpha(1.0f);
        } else {
            TextView tabUnSelect = (TextView) tab.getCustomView().findViewById(R.id.tab_item_textview);
            tabUnSelect.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            tabUnSelect.setText(tab.getText());
            tabUnSelect.setAlpha(0.6f);

        }
    }

    /*
    设置taLayout的下划线宽度
     */
    public void reflex(){
        tab_layout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tab_layout,-5,-5);
            }
        });
    }
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}