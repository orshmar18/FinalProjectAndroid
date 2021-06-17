package com.example.gamega;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity
{
    Button InstructionsBtn;
    Dialog Instruction_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        InstructionsBtn=findViewById(R.id.InstructionsBtn);
        Instruction_dialog=new Dialog(this);

        InstructionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Instruction_dialog.setContentView(R.layout.instructions);
                Instruction_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Instruction_dialog.show();
            }
        });

        Button returning_player_btn=findViewById(R.id.ReturningPlayerBtn);
        returning_player_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Menu.this, ReturningPlayer.class);
                startActivity(intent);
            }
        });

        Button new_player_btn=findViewById(R.id.NewPlayerBtn);
        new_player_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Menu.this, NewPlayer.class);
                startActivity(intent);
            }
        });

        ImageButton sGame=findViewById(R.id.StartBtn);
        sGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Menu.this, Game.class);
                startActivity(intent);
            }
        });

    }
}
