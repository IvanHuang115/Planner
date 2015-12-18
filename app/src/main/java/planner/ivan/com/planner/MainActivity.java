package planner.ivan.com.planner;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View groups;
    View day;
    View month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        day = findViewById(R.id.fragmentDay);
        month = findViewById(R.id.fragmentMonth);
        groups = findViewById(R.id.fragmentGroups);
        day.setVisibility(View.VISIBLE);

    }

    public void listenDay(View v) {
        day.setVisibility(View.VISIBLE);
        month.setVisibility(View.GONE);
        groups.setVisibility(View.GONE);

    }

    public void listenGroups(View v) {
        day.setVisibility(View.GONE);
        month.setVisibility(View.GONE);
        groups.setVisibility(View.VISIBLE);
    }

    public void listenMonth(View v) {
        day.setVisibility(View.GONE);
        month.setVisibility(View.VISIBLE);
        groups.setVisibility(View.GONE);
    }


}
