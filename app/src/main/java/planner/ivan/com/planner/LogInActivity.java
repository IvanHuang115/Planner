package planner.ivan.com.planner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogInActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        user = (EditText) findViewById(R.id.editTextLoginUser);
        pass = (EditText) findViewById(R.id.editTextLoginPass);
        logIn = (Button) findViewById(R.id.buttonLogIn);
    }

    public void listenLogIn(View v) {
        boolean valid = true;
        if (isEmpty(user))
            valid = false;
        if (isEmpty(pass))
            valid = false;

        if (!valid) {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_LONG).show();
            return;
        }

        ParseUser.logInInBackground(user.getText().toString(), pass.getText().toString(), new LogInCallback() {

            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Toast.makeText(LogInActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    ParseUser currUser = ParseUser.getCurrentUser();
                    Toast.makeText(LogInActivity.this, currUser.getUsername(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LogInActivity.this, DayActivity.class));
                }

            }
        });
    }

    private boolean isEmpty(EditText et) {
        if (et.getText().toString().trim().length() > 0)
            return false;
        else
            return true;
    }
}
