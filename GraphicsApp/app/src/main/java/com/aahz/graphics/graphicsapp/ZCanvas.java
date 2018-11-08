package com.aahz.graphics.graphicsapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class ZCanvas extends View {
    Paint paint;
    Paint p2;
    Paint p3;
    Paint p4;
    int wScreen;
    int hScreen;
    int cwScreen;
    int chScreen;
    int canvasX;
    int canvasY;

    public ZCanvas(Context context) {
        super(context);

    paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3f);
        paint.setAntiAlias(true);
        paint.setTextSize(45f);

        p2 = new Paint();
        p2.setColor(Color.GREEN);
        p2.setStyle(Paint.Style.STROKE);
        p2.setStrokeWidth(1f);
        p2.setAntiAlias(true);
        p2.setTextSize(45f);



        p3 = new Paint();
        p3.setColor(Color.BLUE);
        p3.setStyle(Paint.Style.STROKE);
        p3.setStrokeWidth(1f);
        p3.setAntiAlias(true);
        p3.setTextSize(45f);

        p4 = new Paint();
        p4.setColor(Color.CYAN);
        p4.setStyle(Paint.Style.STROKE);
        p4.setStrokeWidth(10f);
        p4.setAntiAlias(true);
        p4.setTextSize(45f);

        // next code initialization to wrong height screen size
//        DisplayMetrics metrics = context.getResources().getDisplayMetrics();

        //Google documents reference
//        To access the DisplayMetrics members, initialize an object like this:

        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display screensize = wm.getDefaultDisplay();
        Point realScreenSize = new Point();
        screensize.getRealSize(realScreenSize);

        Log.d("SCREEN ", "x=" + realScreenSize.x + " y=" + realScreenSize.y);



        wScreen = metrics.widthPixels;
        hScreen = metrics.heightPixels;
        cwScreen = wScreen /2;
        chScreen = hScreen /2;

        cwScreen = realScreenSize.x /2;
        chScreen = (realScreenSize.y - getToolBarHeight()) /2;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasX=w;
        canvasY=h;
        Log.d("CANVAS ", "w=" + w + " h=" + h + " oldw=" + oldw + " oldh=" + oldh );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(200f,200f, 800f, 800f, paint);
        canvas.drawCircle(500f,500f, 300f,  p2);


        canvas.drawText("Рисование", 300f, 300f, paint);

        canvas.drawCircle(canvasX/2,canvasY/2, 7, p3);
        canvas.drawPath(frame(), p3);
        canvas.drawPath(triangle(), p3);
        canvas.drawPath(cirle(), p4);
    }

    public Path triangle() {
        float tPx1, tPx2, tPx3;
        float tPy1, tPy2, tPy3;
        float radius = Math.min(canvasX, canvasY)/2;

        tPx1 = (float) (canvasX/2 - radius * Math.cos(30 * Math.PI / 180));
        tPx2 = canvasX/2 ;
        tPx3 = (float) (canvasX/2 + radius * Math.cos(30 * Math.PI / 180));

        tPy1 = (int) (canvasY/2 - radius * Math.sin(30 * Math.PI / 180));
        tPy2 = canvasY/2 + radius;
        tPy3 = (int) (canvasY/2 - radius * Math.sin(30 * Math.PI / 180));

        Path path = new Path();
        path.reset();
        path.moveTo(tPx1, tPy1);
        path.lineTo(tPx2, tPy2);
        path.lineTo(tPx3, tPy3);
        path.lineTo(tPx1, tPy1);
        path.close();

        return path;
    }

    public Path frame() {

        Path path = new Path();
        path.reset();
        int padding = 3;
        path.moveTo(padding, padding);
        path.lineTo(padding, canvasY - padding);
        path.lineTo(canvasX - padding, canvasY - padding);
        path.lineTo(canvasX - padding, padding);
        path.lineTo(padding, padding);

        path.close();

        return path;
    }

    public Path cirle() {
        float radius = Math.min(canvasX, canvasY)/2;
        float sector = (float) Math.PI / 8f;

        Path path = new Path();
        path.reset();
        for(float angle = 0f; angle< Math.PI*2; angle += sector) {
            path.moveTo( (float) (canvasX/2 + radius * Math.sin(angle)), (float) (canvasY/2 + radius * Math.cos(angle)));
            path.lineTo((float) (canvasX/2 + radius * Math.sin(angle +sector/2)),
                    (float) (canvasY/2 + radius * Math.cos(angle + sector/2)));}

        path.close();

        return path;
    }

    public int getToolBarHeight() {
//        int[] attrs = new int[] {R.attr.actionBarSize};
//        TypedArray ta = getContext().obtainStyledAttributes(attrs);
//        int toolBarHeight = ta.getDimensionPixelSize(0, -1);
//        ta.recycle();


//        TypedValue tv = new TypedValue();
//        int actionBarHeight =0;
//        if (((Activity) getContext()).getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
//        {
//            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
//        }
//        return actionBarHeight;

        // status bar height
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }

        // action bar height
        int actionBarHeight = 0;
        final TypedArray styledAttributes = ((Activity) getContext()).getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.actionBarSize }
        );
        actionBarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        // navigation bar height
        int navigationBarHeight = 0;
        resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = ((Activity) getContext()).getResources().getDimensionPixelSize(resourceId);
        }
        return navigationBarHeight;
    }
}
