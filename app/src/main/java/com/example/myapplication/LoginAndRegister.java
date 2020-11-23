package com.example.myapplication;

        import android.content.Intent;
        import android.os.Bundle;


        import androidx.appcompat.app.AppCompatActivity;


        import android.view.View;
        import android.widget.Button;

public class LoginAndRegister extends AppCompatActivity {
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_and_register);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(getApplicationContext(),Register.class);
                startActivity(it);

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(getApplicationContext(),Login.class);
                startActivity(it);

            }
        });
    }
}