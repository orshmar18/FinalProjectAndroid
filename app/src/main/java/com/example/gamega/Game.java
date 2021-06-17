package com.example.gamega;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.animation.AlphaAnimation;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.GONE;


public class Game extends Activity {

    private boolean touch = false;

    AlphaAnimation alphaAnimation;

    private ImageView piki;
    private AnimationDrawable pikiAnimation;
    private int pikiY;

    private ImageView coin;
    private AnimationDrawable coinAnimation;

    private ImageView background;
    private AnimationDrawable backgroundAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.game);

        piki = findViewById(R.id.piki);
        pikiAnimation = (AnimationDrawable) piki.getDrawable();

        coin = findViewById(R.id.coin);
        coinAnimation = (AnimationDrawable) coin.getDrawable();

        background = findViewById(R.id.background);
        backgroundAnimation = (AnimationDrawable) background.getDrawable();

        pikiAnimation.start();
        coinAnimation.start();
        backgroundAnimation.start();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            piki.setImageDrawable(getResources().getDrawable(R.drawable.piki1));
            touch=true;
            moveObjects();
        }
        else if (event.getAction() == MotionEvent.ACTION_UP)
        {

            piki.setImageDrawable(getResources().getDrawable(R.drawable.piki_animation));
            pikiAnimation = (AnimationDrawable) piki.getDrawable();
            pikiAnimation.start();
            touch=false;
            moveObjects();
        }
        return true;
    }



    public void moveObjects() {

        if (touch == true)
        {
            pikiY = (int) piki.getY();
            pikiY -= 150;
        }
        else
        {
            pikiY = (int) piki.getY();
            pikiY += 150;
        }

        piki.setY(pikiY);

    }

}