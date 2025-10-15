package com.example.x1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class multiplayermodes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multiplayermodes);

        // Apply padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 🔹 Return button → back to menu
        ImageButton btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(v -> {
            finish(); // just close this screen and go back
        });

        // 🔹 Settings button → open settings activity
        ImageButton btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(multiplayermodes.this, settings.class);
            startActivity(intent);
        });

        // 🔹 Showdown mode
        LinearLayout btnShowdown = findViewById(R.id.btnShowdown);
        btnShowdown.setOnClickListener(v -> {
//            Intent intent = new Intent(multiplayermodes.this, showdown.class);
//            startActivity(intent);
        });

        // 🔹 Versus mode
        LinearLayout btnVersus = findViewById(R.id.btnVersus);
        btnVersus.setOnClickListener(v -> {
//            Intent intent = new Intent(multiplayermodes.this, versus.class);
//            startActivity(intent);
        });

        // 🔹 Versus Bot mode
        LinearLayout btnVersusBot = findViewById(R.id.btnVersusBot);
        btnVersusBot.setOnClickListener(v -> {
//            Intent intent = new Intent(multiplayermodes.this, versusbot.class);
//            startActivity(intent);
        });
    }
}
