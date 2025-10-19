package com.example.x1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class lessonsdifficulty extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lessonsdifficulty);

        // Handle system bars padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get references
        ImageButton btnReturn = findViewById(R.id.btnReturn);
        ImageButton btnSettings = findViewById(R.id.btnSettings);

        LinearLayout btnEasy = findViewById(R.id.btnEasy);
        LinearLayout btnMedium = findViewById(R.id.btnMedium);
        LinearLayout btnHard = findViewById(R.id.btnHard);

        // Return button → go back to previous screen (menu)
        btnReturn.setOnClickListener(v -> {
            Intent intent = new Intent(lessonsdifficulty.this, menu.class);
            startActivity(intent);
            finish();
        });

        // Settings button → open settings screen
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(lessonsdifficulty.this, settings.class);
            startActivity(intent);
        });

        // Difficulty buttons
        btnEasy.setOnClickListener(v -> {
//            Intent intent = new Intent(lessonsdifficulty.this, lessons_easy.class);
//            startActivity(intent);
        });

        btnMedium.setOnClickListener(v -> {
//            Intent intent = new Intent(lessonsdifficulty.this, lessons_medium.class);
//            startActivity(intent);
        });

        btnHard.setOnClickListener(v -> {
//            Intent intent = new Intent(lessonsdifficulty.this, lessons_hard.class);
//            startActivity(intent);
        });
    }
}
