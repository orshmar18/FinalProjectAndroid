package com.example.gamega;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class FlyingPiki extends View
{
    private Bitmap piki[]=new Bitmap[2];
    private int pikiY=10;//המרחק של פיקי מצד שמאל של המסך
    private int pikiX=700;//המרחק של פיקי מהתקרה


    private  Bitmap[] life=new Bitmap[2];

    private boolean touch=false;

    private int screenX,screenY;

    private float screenRatioX,screenRatioY;
    private Paint paint;

    public FlyingPiki(Context context,int screenX, int screenY) {
        super(context);

        this.screenX=screenX;
        this.screenY=screenY;
        screenRatioX=1920f/screenX;
        screenRatioY=1080f/screenY;

        paint=new Paint();


        piki[0]= BitmapFactory.decodeResource(getResources(),R.drawable.piki2);
        piki[1]= BitmapFactory.decodeResource(getResources(),R.drawable.piki3);

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        if(touch)
        {
            pikiX=pikiX-200;
            pikiY=pikiY+100;
            touch=false;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    pikiX=pikiX+200;
                    pikiY=pikiY+100;
                }
            }, 50);
            canvas.drawBitmap(piki[1],pikiY,pikiX,null);
        }
        else
        {
            canvas.drawBitmap(piki[0],pikiY,pikiX,null);
        }

        canvas.drawBitmap(life[0],580,35,null);
        canvas.drawBitmap(life[0],640,35,null);
        canvas.drawBitmap(life[0],700,35,null);

    }


    public boolean hitCoinChecker(int x,int y)
    {
        if(pikiY<y&&pikiX<x)
        {
            return true;
        }
            return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            touch=true;
        }
        return true;
    }


}
