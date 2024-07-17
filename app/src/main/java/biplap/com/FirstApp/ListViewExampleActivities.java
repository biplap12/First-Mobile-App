package biplap.com.FirstApp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewExampleActivities extends AppCompatActivity {

    ListView listView;
    String [] language= {"Java","kotlin","React Native","Flutter","MA-UI","Java","kotlin","React Native","Flutter","MA-UI","Java","kotlin","React Native","Flutter","MA-UI","Java","kotlin","React Native","Flutter","MA-UI"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_example_activities);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView= findViewById(R.id.listView);
        ArrayAdapter arrayAdapter= new ArrayAdapter(ListViewExampleActivities.this, android.R.layout.simple_expandable_list_item_1,language);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewExampleActivities.this,"Selected::"+language[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}