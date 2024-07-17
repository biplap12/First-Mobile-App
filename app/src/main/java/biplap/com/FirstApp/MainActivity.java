package biplap.com.FirstApp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button clrButton;
    Button explictButton;
    Button form;
    Button fragmentLayoutBtn;
    Button fragmentLayouCWtBtn;
    Button listviewBtn;
    EditText nameEditText;
    EditText emailEditText;
    EditText phoneEditText;
    EditText passwordEditText;
    EditText addressEditText;
    CheckBox javaCheckBox;
    CheckBox cPlusPlusCheckBox;
    CheckBox phpCheckBox;
    RadioGroup genderRadioGroup;
    TextView outputTextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        clrButton = findViewById(R.id.clear_button);
        explictButton=findViewById(R.id.explict_button);
        form=findViewById(R.id.biplapneupane);

        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        phoneEditText = findViewById(R.id.editTextPhone);
        passwordEditText = findViewById(R.id.password_toggle);
        addressEditText = findViewById(R.id.address);
        javaCheckBox = findViewById(R.id.JavaCheck);
        cPlusPlusCheckBox = findViewById(R.id.CPlusPlus);
        phpCheckBox = findViewById(R.id.PhpCheck);
        genderRadioGroup = findViewById(R.id.radioGroup);
        outputTextView = findViewById(R.id.output_text);
        fragmentLayoutBtn = findViewById(R.id.fragmentLayoutBtn);
        fragmentLayouCWtBtn = findViewById(R.id.fragmentLayouCWtBtn);
        listviewBtn=findViewById(R.id.listviewBtn);

        clrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all the text fields
                nameEditText.setText("");
                emailEditText.setText("");
                phoneEditText.setText("");
                passwordEditText.setText("");
                addressEditText.setText("");

                // Clear the checkboxes
                javaCheckBox.setChecked(false);
                cPlusPlusCheckBox.setChecked(false);
                phpCheckBox.setChecked(false);

                // Clear the radio group
                genderRadioGroup.clearCheck();

                // Clear the output text view
                outputTextView.setText("");

                Toast.makeText(MainActivity.this, "Successfully Cleared!!", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String address = addressEditText.getText().toString();

                // Check if any of the fields are empty
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || address.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Get the selected checkboxes
                StringBuilder selectedLanguages = new StringBuilder("Selected languages: ");
                boolean isSelected = false;
                if (javaCheckBox.isChecked()) {
                    selectedLanguages.append("Java ");
                    isSelected = true;
                }
                if (cPlusPlusCheckBox.isChecked()) {
                    selectedLanguages.append("C++ ");
                    isSelected = true;
                }
                if (phpCheckBox.isChecked()) {
                    selectedLanguages.append("PHP ");
                    isSelected = true;
                }
                if (!isSelected) {
                    selectedLanguages.append("None");
                }

                // Get the selected radio button
                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedGenderId);
                String gender = selectedRadioButton == null ? "Not specified" : selectedRadioButton.getText().toString();

                Toast.makeText(MainActivity.this, "Successfully Submitted!!", Toast.LENGTH_SHORT).show();
                //like a anchor tag
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.google.com"));
//                startActivity(intent);

                // Display the text in the TextView
                outputTextView.setText("Name: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nPassword: " + password + "\nAddress: " + address + "\nGender: " + gender + "\n" + selectedLanguages.toString());
            }
        });
        explictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivities.class);
                intent.putExtra("name","Message from first activities.");
                intent.putExtra("message", nameEditText.getText().toString());
                startActivity(intent);

            }
        });
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.biplapneupane.com.np/"));
                Intent intent = new Intent(MainActivity.this,ThirdActivities.class);
                startActivity(intent);
            }
        });
        fragmentLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.biplapneupane.com.np/"));
                Intent intent = new Intent(MainActivity.this,FragmentLearningActivity.class);
                startActivity(intent);
            }
        });
        fragmentLayouCWtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.biplapneupane.com.np/"));
                Intent intent = new Intent(MainActivity.this,FragmentClassworkActivity.class);
                startActivity(intent);
            }
        });
        listviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewExampleActivities.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // Set the message to show for the Alert time
        builder.setMessage("The Data will be deleted.");

        // Set Alert Title
        builder.setTitle("Do you want to exit?");

        // Set Cancelable false to prevent the dialog from being dismissed when clicking outside the Dialog Box
        builder.setCancelable(false);

        // Set the positive button with "Yes" and define its OnClickListener
        builder.setPositiveButton("Yes", (dialog, which) -> {
            // When the user clicks yes button, call super.onBackPressed() to close the app
            super.onBackPressed();
        });

        // Set the Negative button with "No" and define its OnClickListener
        builder.setNegativeButton("No", (dialog, which) -> {
            // If user clicks no, cancel the dialog
            dialog.cancel();
        });

        // Create the AlertDialog
        AlertDialog alertDialog = builder.create();
        // Show the AlertDialog
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            showSettingsDialog("Settings");
        } else if (id == R.id.edit) {
//            Toast.makeText(this, "Edit Clicked", Toast.LENGTH_SHORT).show();
            showSettingsDialog("Edit");
        } else if (id == R.id.delete) {
//            Toast.makeText(this, "Delete Clicked", Toast.LENGTH_SHORT).show();
            showSettingsDialog("Delete");
        } else if (id == R.id.save) {
//            Toast.makeText(this, "Save Clicked", Toast.LENGTH_SHORT).show();
            showSettingsDialog("Save");
        }
        return super.onOptionsItemSelected(item);
    }
    private void showSettingsDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation")
                .setMessage("Are you sure you want to " + message + "?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle positive button click
                        Toast.makeText(MainActivity.this, message + " Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle negative button click
                        Toast.makeText(MainActivity.this, message + " Click Cancelled", Toast.LENGTH_SHORT).show();
                    }
                })
                .show(); // Call show() to display the AlertDialog
    }



}

