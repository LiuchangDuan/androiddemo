package com.example.myruler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/10.
 */
public class CM extends TextView {

    public CM(Context context) {
        super(context);
        init();
    }

    public CM(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setGravity(Gravity.BOTTOM);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        float mmWidth = ((float) getWidth()) / 10;
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        float top = 2;
        for (int i = 0; i < 10; i++) {
            if (i % 5 == 0) {
                canvas.drawLine(i * mmWidth, top, i * mmWidth, top + 2 * mmWidth, p);
            } else {
                canvas.drawLine(i * mmWidth, top, i * mmWidth, top + mmWidth, p);
            }
//            if (i % 2 == 1) {
////                canvas.drawRect(i * mmWidth, top, i * mmWidth + mmWidth, top + mmWidth, p);
//                canvas.drawLine(i * mmWidth, top, i * mmWidth, top + mmWidth, p);
//            } else {
//                canvas.drawLine(i * mmWidth, top, i * mmWidth, top + 2 * mmWidth, p);
//            }
        }
    }

}
