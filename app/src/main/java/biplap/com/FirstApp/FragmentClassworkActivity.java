package biplap.com.FirstApp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentClassworkActivity extends AppCompatActivity {

    Button fragmentClassworkBtn1, fragmentClassworkBtn2,fragmentClassworkBtn3,fragmentClassworkBtn4;
    FrameLayout frameLayoutCW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment_classwork);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        fragmentClassworkBtn1 = findViewById(R.id.fragmentClassworkBtn1);
        fragmentClassworkBtn2 = findViewById(R.id.fragmentClassworkBtn2);
        fragmentClassworkBtn3 = findViewById(R.id.fragmentClassworkBtn3);
        fragmentClassworkBtn4 = findViewById(R.id.fragmentClassworkBtn4);
        frameLayoutCW = findViewById(R.id.frameLayoutCW);
        loadFragment(new FragmentClasswork1());

        fragmentClassworkBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentClasswork1());
            }
        });
        fragmentClassworkBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentClasswork2());
            }
        });
        fragmentClassworkBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentClasswork3());
            }
        });
        fragmentClassworkBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentClasswork4());
            }
        });

    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutCW, fragment);
        fragmentTransaction.commit();
    }
}