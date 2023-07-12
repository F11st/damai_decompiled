package com.alibaba.verificationsdk.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DrawView extends View {
    public static final int STATUS_END = 3;
    public static final int STATUS_FINISH = 2;
    public static final int STATUS_IN_BOUND = 1;
    public static final int STATUS_START = 0;
    private Bitmap[] bitmap;
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private float boundaryX;
    private float boundaryY;
    private float centerX;
    private float centerX1;
    private float centerY;
    private float centerY1;
    private float currentX;
    private float currentY;
    private int mScreenHeight;
    private int mScreenWidth;
    private Paint paint;
    private float radius;
    private float radiusInner;
    private float radiusInner1;
    private int status;

    public DrawView(Context context) {
        super(context);
        this.currentX = 40.0f;
        this.currentY = 50.0f;
        this.radius = 120.0f;
        this.radiusInner = 60.0f;
        this.radiusInner1 = 80.0f;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.paint = null;
        this.bitmap1 = null;
        this.bitmap2 = null;
        this.bitmap = new Bitmap[10];
        this.centerX = 0.0f;
        this.centerY = 0.0f;
        this.centerX1 = 0.0f;
        this.centerY1 = 0.0f;
        this.boundaryX = 0.0f;
        this.boundaryY = 0.0f;
        this.status = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        this.mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        this.bitmap2 = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("ali_vsdk_frame1", "drawable", context.getPackageName()));
        this.bitmap[0] = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("ali_vsdk_frame", "drawable", context.getPackageName()));
        Bitmap bitmap = this.bitmap[0];
        this.bitmap1 = bitmap;
        this.radius = bitmap.getWidth() / 2;
        this.radiusInner = this.bitmap1.getWidth() / 2;
        this.radiusInner1 = this.bitmap1.getWidth() / 2;
        this.paint = new Paint();
        float f = this.radius;
        initPostion(this.mScreenWidth - f, f);
    }

    public float getBoundaryBottom() {
        return this.boundaryY + (this.radiusInner * 2.0f);
    }

    public float getBoundaryLeft() {
        return this.boundaryX;
    }

    public float getBoundaryRight() {
        return this.boundaryX + (this.radiusInner * 2.0f);
    }

    public float getBoundaryTop() {
        return this.boundaryY;
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterX1() {
        return this.centerX1;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public float getCenterY1() {
        return this.centerY1;
    }

    public float getRadius() {
        return this.radius;
    }

    public int getStatus() {
        return this.status;
    }

    public void initPostion(float f, float f2) {
        setStatus(0);
        this.currentX = f;
        this.currentY = f2;
        Bitmap bitmap = this.bitmap[0];
        this.bitmap1 = bitmap;
        this.centerX = (bitmap.getWidth() / 2) + this.currentX;
        this.centerY = (this.bitmap1.getHeight() / 2) + this.currentY;
        this.centerX1 = (this.bitmap1.getWidth() / 2) + this.currentX;
        float f3 = this.currentY;
        this.centerY1 = (this.bitmap1.getHeight() / 2) + f3;
        float f4 = this.currentX;
        float f5 = this.radius;
        float f6 = this.radiusInner;
        this.boundaryX = (f4 + f5) - f6;
        this.boundaryY = (f3 + f5) - f6;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.status;
        if (i == 0) {
            Bitmap bitmap = this.bitmap1;
            float f = this.currentX;
            float f2 = this.radius;
            float f3 = this.radiusInner1;
            canvas.drawBitmap(bitmap, (f + f2) - f3, (this.currentY + f2) - f3, this.paint);
        } else if (i != 1) {
        } else {
            Bitmap bitmap2 = this.bitmap2;
            float f4 = this.currentX;
            float f5 = this.radius;
            float f6 = this.radiusInner;
            canvas.drawBitmap(bitmap2, (f4 + f5) - f6, (this.currentY + f5) - f6, this.paint);
        }
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
