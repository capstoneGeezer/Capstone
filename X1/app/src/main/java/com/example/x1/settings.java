package com.example.x1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class settings extends BaseActivity {

    private Switch switchMusic, switchSoundEffects, switchVibrations, switchNotifications;
    private Spinner spinnerLanguage;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        // Handle insets (status + nav bar)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        // Initialize views
        switchMusic = findViewById(R.id.switchMusic);
        switchSoundEffects = findViewById(R.id.switchSoundEffects);
        switchVibrations = findViewById(R.id.switchVibrations);
        switchNotifications = findViewById(R.id.switchNotifications);
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        btnBack = findViewById(R.id.btnBack);

        // Example toggle listeners
        switchMusic.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Save to preferences or update music state
        });

        switchSoundEffects.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Enable/disable SFX
        });

        switchVibrations.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Enable/disable vibration
        });

        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Enable/disable notifications
        });

        // Back button -> return to previous screen
        btnBack.setOnClickListener(v -> {
            finish();
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        });
    }
}
