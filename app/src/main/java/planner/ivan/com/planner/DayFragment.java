package planner.ivan.com.planner;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;

/**
 * Created by Ivan on 12/4/2015.
 */
public class DayFragment extends Fragment {

    private TabLayout tabs;
    private ViewPager viewPager;
    private DayPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewPagerDay);
        adapter = new DayPagerAdapter(getActivity().getSupportFragmentManager(), getActivity().getApplicationContext());
        viewPager.setAdapter(adapter);

        tabs = (TabLayout) view.findViewById(R.id.tabLayoutDay);
        tabs.setupWithViewPager(viewPager);
        /*
        tabs.post(new Runnable() {
            @Override
            public void run() {
                tabs.setupWithViewPager(viewPager);
            }
        });
        */

        tabs.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                super.onTabReselected(tab);
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
        return view;

    }


}
