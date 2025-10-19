package com.example.x1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menu extends BaseActivity {

    // Top menu buttons
    private LinearLayout btnPlay, btnMultiplayer, btnPractice;

    // Bottom navigation buttons
    private ImageButton navAchievements, navFriends, navUserProfile, navDictionary, navQuit;
    private ImageView btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        try {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.centerButtons), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        } catch (Exception ignored) {}

        // Initialize UI
        btnPlay = findViewById(R.id.title_play).getParent() instanceof LinearLayout ?
                (LinearLayout) findViewById(R.id.title_play).getParent() : null;
        btnMultiplayer = findViewById(R.id.title_multiplayer).getParent() instanceof LinearLayout ?
                (LinearLayout) findViewById(R.id.title_multiplayer).getParent() : null;
        btnPractice = findViewById(R.id.title_practice).getParent() instanceof LinearLayout ?
                (LinearLayout) findViewById(R.id.title_practice).getParent() : null;



        navAchievements = findViewById(R.id.navAchievements);
        navFriends = findViewById(R.id.navFriends);
        navUserProfile = findViewById(R.id.navUserProfile);
        navDictionary = findViewById(R.id.navDictionary);
        navQuit = findViewById(R.id.navQuit);

        btnSettings = findViewById(R.id.btnSettings);

        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(menu.this, settings.class);
            startActivity(intent);
        });

        // --- Top Buttons ---
        if (btnPlay != null) {
            btnPlay.setOnClickListener(v -> {
                Intent intent = new Intent(menu.this, lessonsdifficulty.class);
                startActivity(intent);
            });
        }

        if (btnMultiplayer != null) {
            btnMultiplayer.setOnClickListener(v -> {
                Intent intent = new Intent(menu.this, multiplayermodes.class);
                startActivity(intent);
            });
        }

        if (btnPractice != null) {
            btnPractice.setOnClickListener(v -> {
                Intent intent = new Intent(menu.this, training.class);
                startActivity(intent);
            });
        }

        // --- Bottom Navigation ---
        navAchievements.setOnClickListener(v -> {
        });

        navFriends.setOnClickListener(v -> {
        });

        navUserProfile.setOnClickListener(v -> {
        });

        navDictionary.setOnClickListener(v -> {
        });

        navQuit.setOnClickListener(v -> {
        });

        navQuit.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}
