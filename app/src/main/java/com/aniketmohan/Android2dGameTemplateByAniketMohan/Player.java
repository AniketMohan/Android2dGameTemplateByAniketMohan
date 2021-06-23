package com.aniketmohan.Android2dGameTemplateByAniketMohan;
import android.content.*;
import android.graphics.*;

public class Player
{

	private double px;
	private double py;
	private double radius;
	private Paint paint;
	public Player(Context ctx,double px, double py, double radius, int color){
		this.px=px;
		this.py=py;
		this.radius=radius;
		paint = new Paint();
		paint.setColor(color);
	}

	public void setposition(double px, double py)
	{
		// TODO: Implement this method
		this.px=px;
		this.py=py;
	}
	public void draw(Canvas canvas){
		canvas.drawCircle((float) px, (float) py, (float) radius,paint);
	}
	public void update(){
		
	}
}
