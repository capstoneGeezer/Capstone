package com.example.x1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class createaccount extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseFirestore db;

    private EditText etUsername, etEmail, etPassword, etRePassword;
    private LinearLayout btnRegister;
    private TextView btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        btnRegister = findViewById(R.id.btnRegister);

        // Fix padding if root has id="main"
        try {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        } catch (Exception e) {
            // ignore if "main" not found
        }

        // Firebase instances
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        // UI refs
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRePassword = findViewById(R.id.etRePassword);
        btnSignIn = findViewById(R.id.backLogin);


        // Register flow
        btnRegister.setOnClickListener(v -> registerUser());
        btnSignIn.setOnClickListener(v -> signInButton());
    }

    private void registerUser() {
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();
        String rePassword = etRePassword.getText().toString();

        if (username.isEmpty()) {
            etUsername.setError("Username required");
            etUsername.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("Email required");
            etEmail.requestFocus();
            return;
        }
        if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            etPassword.requestFocus();
            return;
        }
        if (!password.equals(rePassword)) {
            etRePassword.setError("Passwords do not match");
            etRePassword.requestFocus();
            return;
        }

        btnRegister.setEnabled(false);


        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        String uid = auth.getCurrentUser().getUid();
                        saveUserToFirestore(uid, username, email);
                    } else {
                        Toast.makeText(this, "Error: " + task.getException().getMessage(),
                                Toast.LENGTH_LONG).show();
                        resetRegisterButton();
                    }
                });
    }

    private void saveUserToFirestore(String uid, String username, String email) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("email", email);
        user.put("createdAt", FieldValue.serverTimestamp());

        db.collection("users").document(uid)
                .set(user)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Account created!", Toast.LENGTH_SHORT).show();

                    // Redirect to sign in screen
                    Intent intent = new Intent(createaccount.this, sign_in.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Firestore error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                    // optional: delete auth user if Firestore fails
                    if (auth.getCurrentUser() != null) {
                        auth.getCurrentUser().delete();
                    }
                    resetRegisterButton();
                });
    }

    private void resetRegisterButton() {
        btnRegister.setEnabled(true);

    }

    private void signInButton() {
        Intent intent = new Intent(createaccount.this, sign_in.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
