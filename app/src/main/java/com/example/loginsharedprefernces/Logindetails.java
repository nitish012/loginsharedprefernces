package com.example.loginsharedprefernces;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;


public class Logindetails extends AppCompatActivity {

    private Button sub;
    private EditText et3, et4, et5;
    private String email = "emailkey";
    private String password = "passwordkey";
    private String name = "namekey";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logindetails);

        sub = findViewById(R.id.sub);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        enterdetails();

    }

    public void enterdetails() {


        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //storing data in sharedprefernces and get back to main activity page
                String e = et3.getText().toString();
                String p = et4.getText().toString();
                String n = et5.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(email, e);
                editor.putString(password, p);
                editor.putString(name, n);
                editor.apply();
                editor.commit();

                Intent intent = new Intent(Logindetails.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Logindetails.this, "Enter previous id and password for login", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
