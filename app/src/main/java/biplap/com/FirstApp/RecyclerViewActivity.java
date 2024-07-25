package biplap.com.FirstApp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView=findViewById(R.id.recyclerView);
        RecyclerDTO[] recyclerDTOS=new RecyclerDTO[]{
                new RecyclerDTO("Java", R.drawable.java),
                new RecyclerDTO("Python", R.drawable.python),
                new RecyclerDTO("JavaScript", R.drawable.javascript),
                new RecyclerDTO("C++", R.drawable.cpp),
                new RecyclerDTO("Swift", R.drawable.swift),
                new RecyclerDTO("Ruby", R.drawable.ruby),
                new RecyclerDTO("Go", R.drawable.go),
                new RecyclerDTO("PHP", R.drawable.img),
                new RecyclerDTO("TypeScript", R.drawable.typescript),
                new RecyclerDTO("Rust", R.drawable.img),
                new RecyclerDTO("Scala", R.drawable.img),
                new RecyclerDTO("Haskell", R.drawable.img),
                new RecyclerDTO("Kotlin", R.drawable.kotlin),
                new RecyclerDTO("C#", R.drawable.cs),
                new RecyclerDTO("Perl", R.drawable.img),
                new RecyclerDTO("Lua", R.drawable.img),
                new RecyclerDTO("Erlang", R.drawable.img),
                new RecyclerDTO("Dart", R.drawable.img),
                new RecyclerDTO("Matlab", R.drawable.img),
                new RecyclerDTO("Swift", R.drawable.img)


        };
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(recyclerDTOS);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}