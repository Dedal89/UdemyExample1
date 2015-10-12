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

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class UpdateStatusActivity extends AppCompatActivity {

    protected EditText updateStatus;
    protected Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_status);

        updateStatus = (EditText) findViewById(R.id.updateMyStatusText);
        updateButton = (Button) findViewById(R.id.updateStatusBtn);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newStatus = updateStatus.getText().toString();
                if (newStatus.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(UpdateStatusActivity.this);
                    builder.setMessage("Status should not be empty!");
                    builder.setTitle("Oops!");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {

                    ParseUser currentUser = ParseUser.getCurrentUser();

                    ParseObject statusObj = new ParseObject("Status");
                    statusObj.put("status", newStatus);
                    statusObj.put("author", currentUser.getUsername());
                    statusObj.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(UpdateStatusActivity.this, "Success!", Toast.LENGTH_LONG).show();
                                Intent takeHome = new Intent(UpdateStatusActivity.this, HomeActivity.class);
                                startActivity(takeHome);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateStatusActivity.this);
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
        });
    }

}
