package com.example.gamega;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import javax.xml.namespace.QName;

public class GameView extends Activity
{

    private  FlyingPiki gameView;
    private Handler handler=new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Point point=new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        gameView=new FlyingPiki(this,point.x,point.y);
        setContentView(gameView);

        Timer timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });
            }
        },0,150);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //gameView.resume();
    }
}
