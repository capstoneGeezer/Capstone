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

public class training extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_training);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Top bar
        ImageButton btnReturn = findViewById(R.id.btnReturn);
        ImageButton btnSettings = findViewById(R.id.btnSettings);

        btnReturn.setOnClickListener(v -> {
            finish(); // just go back to menu
        });

        btnSettings.setOnClickListener(v -> {
            startActivity(new Intent(training.this, settings.class));
        });

        // Practice buttons
        LinearLayout btnWritingPractice = findViewById(R.id.btnWritingPractice);
        LinearLayout btnRecognitionPractice = findViewById(R.id.btnRecognitionPractice);

        btnWritingPractice.setOnClickListener(v -> {
//            startActivity(new Intent(training.this, writing_practice.class));
        });

        btnRecognitionPractice.setOnClickListener(v -> {
//            startActivity(new Intent(training.this, recognition_practice.class));
        });

        // Bottom navigation
        ImageButton navAchievements = findViewById(R.id.navAchievements);
        ImageButton navFriends = findViewById(R.id.navFriends);
        ImageButton navUserProfile = findViewById(R.id.navUserProfile);
        ImageButton navDictionary = findViewById(R.id.navDictionary);
        ImageButton navQuit = findViewById(R.id.navQuit);

        navAchievements.setOnClickListener(v -> {
//            startActivity(new Intent(training.this, achievements.class));
        });

        navFriends.setOnClickListener(v -> {
//            startActivity(new Intent(training.this, friends.class));
        });

        navUserProfile.setOnClickListener(v -> {
//            startActivity(new Intent(training.this, user_profile.class));
        });

        navDictionary.setOnClickListener(v -> {
//            startActivity(new Intent(training.this, dictionary.class));
        });

        navQuit.setOnClickListener(v -> {
            finishAffinity(); // closes all activities and exits app
        });
    }
}
