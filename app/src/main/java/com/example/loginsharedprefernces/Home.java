package com.example.loginsharedprefernces;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    private TextView emailhome, passwordhome,name;
    private String emailshow,passwordshow,nameshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        emailhome=findViewById(R.id.emailhome);
        passwordhome=findViewById(R.id.passwordhome);
        name=findViewById(R.id.name);
        displaydata();

    }
    public void displaydata()
    {
        //getting data stored in sharedprefernces
        SharedPreferences sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        emailshow=sharedPreferences.getString("emailkey","3");
        passwordshow=sharedPreferences.getString("passwordkey","2");
        nameshow=sharedPreferences.getString("namekey","1");
        emailhome.setText("Email : "+emailshow);
        passwordhome.setText("Password : "+passwordshow);
        name.setText("Name :"+nameshow);

    }
}
