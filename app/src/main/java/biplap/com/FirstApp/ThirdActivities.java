package biplap.com.FirstApp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivities extends AppCompatActivity {
TextView textView;
EditText Editname, editemail, editaddress,editmobileno;
Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third_activities);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        submitButton= findViewById(R.id.submit3rd);
        Editname = findViewById(R.id.Name);
        editemail= findViewById(R.id.Email);
        editaddress = findViewById(R.id.Address);
        editmobileno = findViewById(R.id.Mobile);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Editname.getText().toString();
                String email = editemail.getText().toString();
                String address = editaddress.getText().toString();
                String mobileno = editmobileno.getText().toString();
                if (name.isEmpty() || email.isEmpty() || address.isEmpty() || mobileno.isEmpty()) {
                    Toast.makeText(ThirdActivities.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else if (name.length() < 3) {
                    Toast.makeText(ThirdActivities.this, "Name must be longer than 3 characters", Toast.LENGTH_SHORT).show();
                } else if (address.length() < 5) {
                Toast.makeText(ThirdActivities.this, "Address must be longer than 5 characters", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(ThirdActivities.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                } else if (!isValidMobileNumber(mobileno)) {
                    Toast.makeText(ThirdActivities.this, "Please enter a valid 10-digit mobile number", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(ThirdActivities.this, ForthActivities.class);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("address", address);
                    intent.putExtra("mobileno", mobileno);
                    startActivity(intent);
                }
            }
            private boolean isValidEmail(String email) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                return email.matches(emailPattern);
            }

            private boolean isValidMobileNumber(String mobileno) {
                return mobileno.matches("\\d{10}");
            }

        });
    }
}
