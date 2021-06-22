//package com.yourpackage;

import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.util.*;
import android.graphics.*;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
	Gameloop gameloop;
	public int x=0;
	public int y=0;
	@Override
	public void surfaceCreated(SurfaceHolder p1)
	{
		// TODO: Implement this method
		gameloop.startloop();
	}

	@Override
	public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
	{
		// TODO: Implement this method
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder p1)
	{
		// TODO: Implement this method
	}

	@Override
	public void draw(Canvas canvas)
	{
		// TODO: Implement this method
		super.draw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		canvas.drawRect(x++,0,x+100,100,paint);
	}
	public void update(){}
    public Game(Context ctx){
		super(ctx);
		SurfaceHolder surfaceholder = getHolder();
		surfaceholder.addCallback(this);
		gameloop = new Gameloop(this, surfaceholder);
		setFocusable(true);
	}
	
}
