package com.example.loginsharedprefernces;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    private EditText edittext1,edittext2;
    private Button btn1,btn2;
    private String em,pass;
    private  String email,password;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext1 = findViewById(R.id.et1);
        edittext2 = findViewById(R.id.et2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        gettingsharedpreferncedata();
        login();
        signup();


    }
    public void gettingsharedpreferncedata(){
     //getting data stored in shared prefernce

        sharedPreferences=getSharedPreferences("login",Context.MODE_PRIVATE);
        email= sharedPreferences.getString("emailkey","3");
        password=sharedPreferences.getString("passwordkey","2");

    }

    public void login(){

            btn1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //comparing current details with sharedprefences
                    em= edittext1.getText().toString();
                    pass=edittext2.getText().toString();
                    Log.i("main","em "+em);
                    Log.i("main","pass "+pass);
                    Log.i("main","email "+email);
                    Log.i("main","password "+password);

                    if((sharedPreferences.getAll().size()>0) && (email.equals(em)) && (password.equals(pass))) {
                        Toast.makeText(MainActivity.this, "welcome to home", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(MainActivity.this,Home.class);
                        startActivity(intent);



                    }
                    else if(sharedPreferences.getAll().size()>0 &&!(email.equals(em)) && !(password.equals(pass)))
                    {
                        Toast.makeText(MainActivity.this, "Enter correct details", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Please signup first", Toast.LENGTH_SHORT).show();
                    }

                }
            });

    }
    public void signup()
    {
     //signing up the page
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(sharedPreferences.getAll().size()>0)
                {
                    Toast.makeText(MainActivity.this, "you have already signedup", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, Logindetails.class);
                    startActivity(intent);
                }

            }
        });


    }
}
