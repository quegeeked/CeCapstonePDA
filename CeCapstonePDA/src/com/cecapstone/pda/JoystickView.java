package com.cecapstone.pda;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;

public class JoystickView {
    
    private ShapeDrawable joystick;

    public JoystickView(Context context) {
    super();

    int x = 10;
    int y = 10;
    int width = 300;
    int height = 50;

    joystick = new ShapeDrawable(new OvalShape());
    joystick.getPaint().setColor(0xff74AC23);
    joystick.setBounds(x, y, x + width, y + height);
    }

    protected void onDraw(Canvas canvas) {
    joystick.draw(canvas);
    }


}
