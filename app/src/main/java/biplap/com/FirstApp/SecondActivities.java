package biplap.com.FirstApp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivities extends AppCompatActivity {
TextView textView;
TextView editView;
Button contextButton,btnPopupMenu,btnAlert,btnCustom;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView=findViewById(R.id.textView);
        editView=findViewById(R.id.editView);
        contextButton= findViewById(R.id.btnContextMenu);
        btnPopupMenu = findViewById(R.id.btnPopupMenu);
        btnAlert = findViewById(R.id.btnAlert);
        btnCustom= findViewById(R.id.btnCustom);
        textView.setText(getIntent().getStringExtra("name"));
        editView.setText(getIntent().getStringExtra("message"));


        registerForContextMenu(contextButton);

        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showpopupMenu();
            }
        });

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivities.this);
                AlertDialog alertDialog = builder.create();
                builder.setTitle("Are you sure ?");
                builder.setMessage("Do you want to continue enter ok other wise click cancel");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(SecondActivities.this,"Ok Clicked",Toast.LENGTH_SHORT).show();

//                    finish();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivities.this,"Cancel Clicked",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(SecondActivities.this);
                dialog.setContentView(R.layout.layout_custom_dialog);
                Button buttonOk = dialog.findViewById(R.id.btnPositive);
                Button buttonCancel = dialog.findViewById(R.id.btnNegative);

                buttonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog.show();
            }
        });

    }

    private void showpopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this,btnPopupMenu);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(SecondActivities.this,"Selected::" +item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Items");
        menu.add("Refresh");
        menu.add("Create New Page");
        menu.add("Accept");
        menu.add("Cancel");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if((item.getTitle()=="Refresh")){
            Toast.makeText(this,"Refresh Selected",Toast.LENGTH_SHORT).show();
        } else if ((item.getTitle()=="Create New Page")) {
            Toast.makeText(this,"Create New Page Selected",Toast.LENGTH_SHORT).show();
        } else if ((item.getTitle()=="Accept")) {
            Toast.makeText(this,"Accept Selected",Toast.LENGTH_SHORT).show();
        } else if ((item.getTitle()=="Cancel")) {
            Toast.makeText(this,"Cancel Selected",Toast.LENGTH_SHORT).show();
        }
        return true;
    }






}
