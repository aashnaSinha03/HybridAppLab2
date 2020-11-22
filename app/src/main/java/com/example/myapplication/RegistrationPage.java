package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {
    EditText name, pass ;
    Button register ;
    DBHelper dbHelper ;
    public static final String DBNAME = "registration.db" ;
    public static final String TBNAME = "registration" ;
    public static final int DB_VERSION= 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page); ;


        name = findViewById(R.id.name) ;
        pass = findViewById(R.id.pass) ;

        String uname = name.getText().toString() ;
        String upass = pass.getText().toString();

        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            long val ;
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(RegistrationPage.this,DBNAME,null,DB_VERSION) ;
                long val = dbHelper.adduser(uname,upass) ;
                if(val == -1)
                    Toast.makeText(RegistrationPage.this, "Error in Adding user", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent = new Intent(RegistrationPage.this, MainActivity.class);;
                    startActivity(intent);
                    Toast.makeText(RegistrationPage.this, "Registered", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}