package planner.ivan.com.planner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;

public class SignUpActivity extends AppCompatActivity {

    EditText user;
    EditText pass;
    EditText passConfirm;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        user = (EditText) findViewById(R.id.editTextSigninUser);
        pass = (EditText) findViewById(R.id.editTextSigninPass);
        passConfirm = (EditText) findViewById(R.id.editTextSigninPassConfirm);
        signUp = (Button) findViewById(R.id.buttonSignUp);
    }

    public void listenSignUp(View v) {
        boolean valid = true;
        if (isEmpty(user))
            valid = false;
        if (isEmpty(pass))
            valid = false;
        if (isEmpty(passConfirm))
            valid = false;
        if (!isMatching(pass, passConfirm))
            valid = false;

        if (!valid) {
            Toast.makeText(this, "Fields cannot be empty, and passwords have to match", Toast.LENGTH_LONG).show();
            return;
        }

        ParseUser newUser = new ParseUser();
        newUser.setUsername(user.getText().toString());
        newUser.setPassword(pass.getText().toString());

        newUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {
                if (e != null) {
                    Toast.makeText(SignUpActivity.this, "Sign-up Successful!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Sign-up Failed...", Toast.LENGTH_LONG).show();
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

    private boolean isMatching(EditText et1, EditText et2) {
        if (et1.getText().toString().equals(et2.getText().toString()))
            return true;
        else
            return false;
    }
}
