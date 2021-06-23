package com.aniketmohan.Android2dGameTemplateByAniketMohan;
import android.content.*;
import android.view.*;
import android.graphics.*;

public class Gameloop extends Thread
{

	private double averageUPS;
    private double averageFPS;
	public static final double MAX_UPS = 30.0;
    private static final double UPS_PERIOD = 1E+3/MAX_UPS;
	
	private boolean isrunning;
	private SurfaceHolder surfaceholder;
	private Game game;
	// Declare time and cycle count variables
	int updateCount = 0;
	int frameCount = 0;

	long startTime;
	long elapsedTime;
	long sleepTime;
	
	public Gameloop(Game game,SurfaceHolder surfaceholder){
		this.surfaceholder = surfaceholder;
		this.game = game;
	}
	public void startloop(){
		isrunning = true;
		start();
	}
	public double getAverageUPS() {
        return averageUPS;
    }

    public double getAverageFPS() {
        return averageFPS;
    }
	@Override
	public void run()
	{
		// TODO: Implement this method
		super.run();
		Canvas canvas = null;
		
		//loop
		while(isrunning){
			// Try to update and render game
            try {
                canvas = surfaceholder.lockCanvas();
                synchronized (surfaceholder) {
                    game.update();
                    updateCount++;

                    game.draw(canvas);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } finally {
                if(canvas != null) {
                    try {
                        surfaceholder.unlockCanvasAndPost(canvas);
                        frameCount++;
					} catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
			// Pause game loop to not exceed target UPS
            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long) (updateCount*UPS_PERIOD - elapsedTime);
            if(sleepTime > 0) {
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
			// Skip frames to keep up with target UPS
            while(sleepTime < 0 && updateCount < MAX_UPS-1) {
                game.update();
                updateCount++;
                elapsedTime = System.currentTimeMillis() - startTime;
                sleepTime = (long) (updateCount*UPS_PERIOD - elapsedTime);
            }

            // Calculate average UPS and FPS
            elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime >= 1000) {
                averageUPS = updateCount / (1E-3 * elapsedTime);
                averageFPS = frameCount / (1E-3 * elapsedTime);
                updateCount = 0;
                frameCount = 0;
                startTime = System.currentTimeMillis();
            }
		}
	}
	
}
