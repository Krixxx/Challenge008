package com.hepicode.challenge008;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedActivity extends AppCompatActivity {

    TextView loggedUser;
    Button logoutButton;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        loggedUser = findViewById(R.id.logged_user_text);
        logoutButton = findViewById(R.id.button);

        username = getIntent().getStringExtra("username");
        loggedUser.setText(username);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
