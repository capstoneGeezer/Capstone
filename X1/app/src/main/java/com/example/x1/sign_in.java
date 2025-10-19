package com.example.x1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class sign_in extends BaseActivity {

    private FirebaseAuth auth;
    private EditText etUsername, etPassword;
    private LinearLayout btnLogin, btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        try {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sign_in), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        } catch (Exception ignored) {}

        auth = FirebaseAuth.getInstance();

        // UI refs
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        // Sign in
        btnLogin.setOnClickListener(v -> loginUser());

        // Go to create account screen
        btnCreateAccount.setOnClickListener(v -> {
            Intent intent = new Intent(sign_in.this, createaccount.class);
            startActivity(intent);
            finish();
        });
    }

    private void loginUser() {
        String email = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etUsername.setError("Email required");
            etUsername.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password required");
            etPassword.requestFocus();
            return;
        }

        btnLogin.setEnabled(false);

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    btnLogin.setEnabled(true);
                    if (task.isSuccessful()) {
//                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                        // Go to main screen
                        Intent intent = new Intent(sign_in.this, menu.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    } else {
//                        Toast.makeText(this, "Error: " + task.getException().getMessage(),
//                                Toast.LENGTH_LONG).show();
                    }
                });
    }
}
