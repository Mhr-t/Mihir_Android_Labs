package algoqnuin.cst2335.thak0065;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    EditText usernameEditText, passwordEditText;

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG, "onStart: MainActivity is started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause: MainActivity is Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "onResume: MainActivity is Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "onCreate: Main Activity is Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy: Main Activity is destroyed");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.w(TAG, "In onCreate() - Loading Widgets");

        Button btn1 = findViewById(R.id.loginButton);
        EditText emailText = findViewById(R.id.emailEditText);

        btn1.setOnClickListener(v -> {
            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
            nextPage.putExtra("Email Address", emailText.getText().toString());
            startActivity(nextPage);
        });
    }


    private void authenticateUser(String username, String password) {
        // Simulated authentication logic, replace with actual authentication mechanism
        if ("admin".equals(username) && "password123".equals(password)) {
            // Authentication successful
            Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
            // Proceed to next activity or perform desired action
            // For example, you can start the MainActivity using an Intent
        } else {
            // Authentication failed
            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
