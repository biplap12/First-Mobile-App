package biplap.com.FirstApp;

import android.annotation.SuppressLint;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivities extends AppCompatActivity {
TextView textView;
TextView editView;
Button contextButton,btnPopupMenu;


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
        textView.setText(getIntent().getStringExtra("name"));
        editView.setText(getIntent().getStringExtra("message"));


        registerForContextMenu(contextButton);

        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showpopupMenu();
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