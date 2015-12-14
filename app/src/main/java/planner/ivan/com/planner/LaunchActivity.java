package planner.ivan.com.planner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;

public class LaunchActivity extends AppCompatActivity {
    Button signUp;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "ePH4ZtyXVJ36kHYMQlQIr78RisHr2e9cKtcQaVa3", "o1RYQT9HhGfXmnoK2dYDiU8ujoWXFLSG4T6sBWHA");
    }

    public void listenSignUpActivity(View v) {
        startActivity(new Intent(this, SignUpActivity.class));
        return;
    }


    public void listenLogInActivity(View v) {
        startActivity(new Intent(this, LogInActivity.class));
        return;
    }

}
