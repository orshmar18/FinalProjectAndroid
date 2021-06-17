package com.example.gamega;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class ReturningPlayer extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.returning_player);

        final EditText userName = findViewById(R.id.UserNameInput);
        final EditText password = findViewById(R.id.PasswordInput);
        final EditText verifyPassword = findViewById(R.id.VerifyPasswordInput);
        Button enter =findViewById(R.id.EnterBtn);//כפתור כניסה לאפליקציה

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=userName.getText().toString();
                String passwordInput=password.getText().toString();
                String passwordVerifyInput=verifyPassword.getText().toString();

                if(name.isEmpty()||passwordInput.isEmpty()||passwordVerifyInput.isEmpty()) {
                    Toast.makeText(ReturningPlayer.this, "אחד מתיבות הטקסט אינן מלאות", Toast.LENGTH_LONG).show();
                }
                else if(name.length()<2 ||name.length()>15)
                {
                    Toast.makeText(ReturningPlayer.this, " יוזר ניים אנא הכנס קלט באורך שלוש עד חמש עשרה תווים", Toast.LENGTH_LONG).show();
                }
                else if (!passwordVerifyInput.equals(passwordInput))
                {
                    Toast.makeText(ReturningPlayer.this, "הסיסמא לא תואמת", Toast.LENGTH_LONG).show();
                }
                else if(passwordInput.length()<=4 ||name.length()>=15)
                {
                    Toast.makeText(ReturningPlayer.this, " סיסמא אנא הכנס קלט באורך שלוש עד חמש עשרה תווים", Toast.LENGTH_LONG).show();
                }
                else if(passwordVerifyInput.length()<=4 ||name.length()>=15)
                {
                    Toast.makeText(ReturningPlayer.this, "סיסמא חוזרת אנא הכנס קלט באורך שלוש עד חמש עשרה תווים", Toast.LENGTH_LONG).show();
                }
            }
        });


        ImageButton back=findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ReturningPlayer.this, Menu.class);
                startActivity(intent);
            }
        });

    }
}
