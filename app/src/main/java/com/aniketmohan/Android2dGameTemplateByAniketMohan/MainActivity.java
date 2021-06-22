package com.aniketmohan.Android2dGameTemplateByAniketMohan;

import android.app.*;
import android.os.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(new Game(this));
    }
}
