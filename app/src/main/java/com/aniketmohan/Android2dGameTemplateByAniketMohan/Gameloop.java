package com.aniketmohan.Android2dGameTemplateByAniketMohan;
import android.content.*;
import android.view.*;
import android.graphics.*;

public class Gameloop extends Thread
{

	private boolean isrunning;
	private SurfaceHolder surfaceholder;
	private Game game;
	public Gameloop(Game game,SurfaceHolder surfaceholder){
		this.surfaceholder = surfaceholder;
		this.game = game;
	}
	public void startloop(){
		isrunning = true;
		start();
	}

	@Override
	public void run()
	{
		// TODO: Implement this method
		super.run();
		Canvas canvas;
		
		//loop
		while(isrunning){
			try{
				canvas = surfaceholder.lockCanvas();
				game.update();
				game.draw(canvas);
				surfaceholder.unlockCanvasAndPost(canvas);
			}catch(IllegalArgumentException e){
				e.printStackTrace();
			}
		}
	}
	
}
