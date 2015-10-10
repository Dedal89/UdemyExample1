package riboni.com.udemyexample1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            Intent takeLogin = new Intent(this, LoginActivity.class);
            startActivity(takeLogin);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.updateStatus:
                Intent takeUpdateStatus = new Intent(this, UpdateStatusActivity.class);
                startActivity(takeUpdateStatus);
                break;
            case R.id.logoutUser:
                ParseUser.logOut();
                Intent takeLogin = new Intent(this, LoginActivity.class);
                startActivity(takeLogin);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
