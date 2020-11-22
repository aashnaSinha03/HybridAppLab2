package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Deletepage extends AppCompatActivity {
    public static final String DBNAME = "registration.db" ;
    public static final int DB_VERSION= 1 ;
    EditText nametodelete ;
    Button todelete ;
    DBHelper dbHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletepage);
        nametodelete = findViewById(R.id.name) ;
        todelete = findViewById(R.id.delete) ;

        todelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(Deletepage.this, DBNAME, null, DB_VERSION);
                dbHelper.delete(nametodelete.getText().toString(), Deletepage.this);

                Intent it = new Intent(Deletepage.this,MainActivity.class);
                startActivity(it);
            }
        });
    }
}