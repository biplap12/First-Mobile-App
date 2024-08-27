package biplap.com.FirstApp;

import android.database.Cursor;
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

public class SqLiteTutorialActivity extends AppCompatActivity {

    EditText editName,editPhone,editEmail,editAddress;
    Button btnInsert,btnSelect,btnUpdate,btnDelete;
    String edName,edPhone,edEmail,edAddress;
    TextView tvSelected;
    MyDBHelper myDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sq_lite_tutorial);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editName= findViewById(R.id.edName);
        editEmail=findViewById(R.id.edEmail);
        editPhone= findViewById(R.id.edPhone);
        editAddress= findViewById(R.id.edAddress);
        btnInsert= findViewById(R.id.btnInsert);
        btnSelect= findViewById(R.id.btnSelect);
        tvSelected=findViewById(R.id.tvSelected);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);

        myDBHelper= new MyDBHelper(SqLiteTutorialActivity.this);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edName=editName.getText().toString();
                edPhone=editPhone.getText().toString();
                edEmail=editEmail.getText().toString();
                edAddress=editAddress.getText().toString();
                myDBHelper.addContacts(edName,edEmail,edPhone,edAddress);

            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SqLiteTutorialActivity.this,"Hello",Toast.LENGTH_SHORT).show();

                Cursor cursor = myDBHelper.selectData();
                while (cursor.moveToNext()){
                    edName= cursor.getString(1);
                    edEmail= cursor.getString(2);
                    edPhone= cursor.getString(3);
                    edAddress= cursor.getString(4);
                    myDBHelper.addContacts(edName,edEmail,edPhone,edAddress);
                    tvSelected.setText("Name: " + edName + "\nEmail: " + edEmail + "\nPhone: " + edPhone + "\nAddress: " + edAddress);

                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SqLiteTutorialActivity.this,"Update",Toast.LENGTH_LONG).show();
                edName=editName.getText().toString();
                edPhone=editPhone.getText().toString();
                edEmail=editEmail.getText().toString();
                edAddress=editAddress.getText().toString();
                myDBHelper.updateData(1,edName,edEmail,edPhone,edAddress);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDBHelper.deleteData(1);
            }
        });
    }
}