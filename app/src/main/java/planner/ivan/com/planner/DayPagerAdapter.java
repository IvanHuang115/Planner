package planner.ivan.com.planner;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Ivan on 12/16/2015.
 */
public class DayPagerAdapter extends FragmentPagerAdapter{

    Context context;
    private ArrayList<DayChildFragment> dayFrags;
    private ArrayList<String> titles;


    public DayPagerAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
        dayFrags = new ArrayList<DayChildFragment>(3);
        titles = new ArrayList<String>(3);
        titles.add("Yesterday");
        titles.add("Today");
        titles.add("Tmrw");
    }
    @Override
    public Fragment getItem(int position) {
        return new DayChildFragment();
    }

    @Override
    public int getCount() {
        return dayFrags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
