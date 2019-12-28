package com.hepicode.challenge008;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameEt, passwordEt;
    Button loginButton;
    String username, password;
    String loginUsername, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        loginButton = findViewById(R.id.login_btn);

        saveLoginData();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = usernameEt.getText().toString().trim();
                password = passwordEt.getText().toString().trim();

                loadLoginData();

                if (!username.isEmpty() && !password.isEmpty()){

                    if (!username.equals(loginUsername)) {

                        Toast.makeText(MainActivity.this, "Username incorrect!", Toast.LENGTH_SHORT).show();

                    } else if (!password.equals(loginPassword)){

                        Toast.makeText(MainActivity.this, "Password incorrect!", Toast.LENGTH_SHORT).show();

                    }else {

                        Intent intent = new Intent(MainActivity.this, LoggedActivity.class);
                        intent.putExtra("username", username);
                        startActivity(intent);

                    }
                }else {
                    Toast.makeText(MainActivity.this, "Both fields must be filled!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveLoginData() {

        //You must store a hand coded username and password when the app initially loads.
        SharedPreferences.Editor editor = getSharedPreferences("Login", MODE_PRIVATE).edit();
        editor.putString("username", "Admin");
        editor.putString("password", "1234");
        editor.apply();

    }

    private void loadLoginData() {

        SharedPreferences prefs = getSharedPreferences("Login", MODE_PRIVATE);
        loginUsername = prefs.getString("username", "");
        loginPassword = prefs.getString("password", "");

    }

    @Override
    protected void onResume() {
        super.onResume();
        usernameEt.setText("");
        passwordEt.setText("");
    }
}

/*
1. Create a launch or intro Activity A
2. Add two EditText (Username and Password) and a Button widgets in Activity A layout file.
3. When the Button View on Activity A is clicked,
I. Check that the username and password fields are not empty
ii If they are empty instruct the user to fill in these fields
iii, If the fields are already filled validate the username and password with the username and password you stored in a Shared Preference.
4. If the username and password match then send the user to a new Activity B
5. If there is no match, stay in Activity A and notify the user of incorrect login details
6. If a user is login, display the username with welcome in Activity B and a Logout Button
7. If a user click on the Logout Button it will redirect the User to Activity A with all the EditText empty.
NOTE
You must store a hand coded username and password when the app initially loads.
 */
