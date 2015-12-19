package planner.ivan.com.planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ivan on 12/18/2015.
 */
public class GroupsActivity extends AppCompatActivity implements View.OnClickListener{

    Button day;
    Button groups;
    Button month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
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
                break;
            case R.id.buttonToday:
                i = new Intent(GroupsActivity.this, DayActivity.class);
                break;
            case R.id.buttonMonth:
                i = new Intent(GroupsActivity.this, MonthActivity.class);
                break;
        }

        if (i != null)
            startActivity(i);
    }
}
