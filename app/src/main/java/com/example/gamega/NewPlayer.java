package com.example.gamega;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class NewPlayer extends Activity
{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_player);

        final EditText email = findViewById(R.id.MailInput);
        final EditText password = findViewById(R.id.PasswordInput);
        final EditText verifyPassword = findViewById(R.id.VerifyPasswordInput);
        Button enter =findViewById(R.id.EnterBtn);//כפתור כניסה לאפליקציה

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=email.getText().toString();
                String passwordInput=password.getText().toString();
                String passwordVerifyInput=verifyPassword.getText().toString();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(email.getText().toString().isEmpty()||passwordInput.isEmpty()||passwordVerifyInput.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"אחד מתיבות הטקסט אינן מלאות",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (email.getText().toString().trim().matches(emailPattern)) {
                        Toast.makeText(getApplicationContext(), "valid email address", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                    }
                    if (!passwordVerifyInput.equals(passwordInput))
                    {
                        Toast.makeText(NewPlayer.this, "הסיסמא לא תואמת", Toast.LENGTH_SHORT).show();
                    }
                    else if(passwordInput.length()<=4 ||name.length()>=15)
                    {
                        Toast.makeText(NewPlayer.this, " סיסמא אנא הכנס קלט באורך שלוש עד חמש עשרה תווים", Toast.LENGTH_SHORT).show();
                    }
                    else if(passwordVerifyInput.length()<=4 ||name.length()>=15)
                    {
                        Toast.makeText(NewPlayer.this, "סיסמא חוזרת אנא הכנס קלט באורך שלוש עד חמש עשרה תווים", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        ImageButton back=findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(NewPlayer.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}
