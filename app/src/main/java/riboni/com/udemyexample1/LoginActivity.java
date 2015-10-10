package riboni.com.udemyexample1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    protected EditText mUsername;
    protected EditText mPassword;
    protected Button mLoginUser;
    protected Button mSignUpUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // initialize
        mUsername = (EditText) findViewById(R.id.loginUsername);
        mPassword = (EditText) findViewById(R.id.loginPassword);
        mLoginUser = (Button) findViewById(R.id.loginButton);
        mSignUpUser = (Button) findViewById(R.id.createAccountButton);

        mLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _doLogin();
            }
        });

        mSignUpUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(takeRegister);
            }
        });

    }

    private void _doLogin() {
        ParseUser.logInInBackground(mUsername.getText().toString().trim(), mPassword.getText().toString().trim(), new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (e == null) {
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                    Intent takeHome = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(takeHome);
                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage(e.getMessage());
                    builder.setTitle("Sorry!");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            }
        });
    }

}
