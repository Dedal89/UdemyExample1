package riboni.com.udemyexample1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends Activity {

    protected EditText mUsername;
    protected EditText mUserEmail;
    protected EditText mUserPassword;
    protected Button mSignUpUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Parse.initialize(this, "yDtXoC5vV5UQ29DUXMkzb66WeI3QltDQZLMxCMUC", "oApQ0fw7aVUoMBL0I5mVZumrHBXfTfATtiDO5q63");

        // initialize
        mUsername = (EditText) findViewById(R.id.registerUsernameEditText);
        mUserEmail = (EditText) findViewById(R.id.registerEmailEditText);
        mUserPassword = (EditText) findViewById(R.id.registerPasswordEditText);
        mSignUpUser = (Button) findViewById(R.id.signUpButton);

    }

    /** Called when the user clicks the SignUp button */
    public void signUp(View view){
        ParseUser user = new ParseUser();
        user.setUsername(mUsername.getText().toString().trim());
        user.setEmail(mUserEmail.getText().toString().trim());
        user.setPassword(mUserPassword.getText().toString().trim());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(RegisterActivity.this, "Registration Success!", Toast.LENGTH_LONG).show();

                    //redirect to login page
                    //TODO
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration Success!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
