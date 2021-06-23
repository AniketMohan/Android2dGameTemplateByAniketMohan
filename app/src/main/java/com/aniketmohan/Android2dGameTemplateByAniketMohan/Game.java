package com.aniketmohan.Android2dGameTemplateByAniketMohan;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.util.*;
import android.graphics.*;

public class Game extends SurfaceView implements SurfaceHolder.Callback
{
	Gameloop gameloop;
	Player player;
	@Override
	public void surfaceCreated(SurfaceHolder p1)
	{
		// TODO: Implement this method
		gameloop.startloop();
		player = new Player(getContext(),300,300,30,Color.CYAN);
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
		String averageups= Double.toString(gameloop.getAverageUPS());
		String averagefps= Double.toString(gameloop.getAverageFPS());
		Paint textpaint = new Paint();
		textpaint.setColor(Color.MAGENTA);
		textpaint.setTextSize(30);
		canvas.drawText("UPS = "+averageups,20,40,textpaint);
		canvas.drawText("FPS = "+averageups,20,100,textpaint);
		
		player.draw(canvas);
	}
	public void update(){
		player.update();
	}
    public Game(Context ctx){
		super(ctx);
		SurfaceHolder surfaceholder = getHolder();
		surfaceholder.addCallback(this);
		gameloop = new Gameloop(this, surfaceholder);
		setFocusable(true);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		// TODO: Implement this method
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
				player.setposition((double)event.getX(),(double)event.getY());
				return true;
			case MotionEvent.ACTION_MOVE:
				player.setposition((double)event.getX(),(double)event.getY());
				return true;
		}
		return super.onTouchEvent(event);
	}
	
	
}
