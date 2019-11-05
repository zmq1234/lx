package bw.com.weekone;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TableLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import bw.com.weekone.adapter.ViewAdapter;
import bw.com.weekone.fragment.FragF;
import bw.com.weekone.fragment.FragS;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tablay)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<String> list;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //标签集合
        list = new ArrayList<>();
        list.add("首页");
        list.add("副页");
        //fragment集合
        fragments = new ArrayList<>();
        fragments.add(new FragS());
        fragments.add(new FragF());
        //新建适配器
        ViewAdapter viewAdapter = new ViewAdapter(getSupportFragmentManager(),list,fragments);
        vp.setAdapter(viewAdapter);
        tabLayout.setupWithViewPager(vp);
    }
}
