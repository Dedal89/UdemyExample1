package riboni.com.udemyexample1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;

public class HomeActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            Intent takeLogin = new Intent(this, LoginActivity.class);
            startActivity(takeLogin);
        }

        AppCompatCallback callback = new AppCompatCallback() {
            @Override
            public void onSupportActionModeStarted(ActionMode mode) {

            }

            @Override
            public void onSupportActionModeFinished(ActionMode mode) {

            }

            @Nullable
            @Override
            public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
                return null;
            }
        };

        AppCompatDelegate delegate = AppCompatDelegate.create(this,callback);

        delegate.onCreate(savedInstanceState);
        delegate.setContentView(R.layout.activity_home);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        delegate.setSupportActionBar(toolbar);


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
