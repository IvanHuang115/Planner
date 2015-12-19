package planner.ivan.com.planner;

//import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DayActivity extends AppCompatActivity implements View.OnClickListener{

    TabLayout tabLayout;
    ViewPager viewPager;
    Button day;
    Button groups;
    Button month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        setButtons();

        viewPager = (ViewPager) findViewById(R.id.viewPagerMain);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayoutMain);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    public void setButtons() {
        day = (Button) findViewById(R.id.buttonToday);
        groups = (Button) findViewById(R.id.buttonGroups);
        month = (Button) findViewById(R.id.buttonMonth);
        day.setOnClickListener(this);
        month.setOnClickListener(this);
        groups.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent i = null;
        switch (id) {
            case R.id.buttonGroups:
                i = new Intent(DayActivity.this, GroupsActivity.class);
                break;
            case R.id.buttonToday:
                break;
            case R.id.buttonMonth:
                i = new Intent(DayActivity.this, MonthActivity.class);
                break;
        }

        if (i != null)
            startActivity(i);
    }


    private class MainPagerAdapter extends FragmentPagerAdapter {
        private String fragments[] = {"Yesterday", "Today", "Tomorrow"};

        public MainPagerAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new DayFragment();
                case 1:
                    return new DayFragment();
                case 2:
                    return new DayFragment();

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }
}


