package com.alibaba.verificationsdk.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BallView extends View {
    public static final int STATUS_END = 2;
    public static final int STATUS_FINISH = 1;
    public static final int STATUS_INIT = -1;
    public static final int STATUS_START = 0;
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private float currentX;
    private float currentY;
    private Bitmap frame;
    private float initX;
    private float initY;
    boolean is;
    private int mScreenHeight;
    private int mScreenWidth;
    Paint paint;
    private float radius;
    private float radiusTouch;
    private int status;

    public BallView(Context context) {
        super(context);
        this.currentX = 40.0f;
        this.currentY = 50.0f;
        this.radius = 100.0f;
        this.radiusTouch = 120.0f;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.bitmap1 = null;
        this.bitmap2 = null;
        this.frame = null;
        this.paint = null;
        this.is = false;
        this.initX = 40.0f;
        this.initY = 50.0f;
        this.status = -1;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        this.mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        this.paint = new Paint();
    }

    public float getInitBottom() {
        return this.initY + (this.radius * 2.0f);
    }

    public float getInitLeft() {
        return this.initX;
    }

    public float getInitRight() {
        return this.initX + (this.radius * 2.0f);
    }

    public float getInitTop() {
        return this.initY;
    }

    public float getRadius() {
        return this.radius;
    }

    public float getRadiusTouch() {
        return this.radiusTouch;
    }

    public int getStatus() {
        return this.status;
    }

    public void init(Bitmap bitmap, Bitmap bitmap2) {
        this.bitmap1 = bitmap;
        this.frame = bitmap2;
        if (bitmap.getWidth() < this.frame.getWidth() || this.bitmap1.getHeight() < this.frame.getHeight()) {
            this.bitmap1 = Bitmap.createScaledBitmap(this.bitmap1, this.frame.getWidth(), this.frame.getHeight(), true);
        }
        this.radius = this.bitmap1.getWidth() / 2;
        Bitmap bitmap3 = this.bitmap1;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap3, (bitmap3.getWidth() * 6) / 5, (this.bitmap1.getHeight() * 6) / 5, true);
        this.bitmap2 = createScaledBitmap;
        this.radiusTouch = createScaledBitmap.getWidth() / 2;
    }

    public void initPostion(float f, float f2) {
        setStatus(-1);
        this.initX = f;
        this.currentX = f;
        this.initY = f2;
        this.currentY = f2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        int i = this.status;
        if (i == -1) {
            Bitmap bitmap2 = this.bitmap1;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.initX, this.initY, this.paint);
            }
        } else if (i == 0) {
            Bitmap bitmap3 = this.bitmap2;
            if (bitmap3 != null) {
                canvas.drawBitmap(bitmap3, this.currentX - (bitmap3.getWidth() / 2), this.currentY - (this.bitmap2.getHeight() / 2), this.paint);
            }
        } else if (i != 1) {
            if (i == 2 && (bitmap = this.bitmap1) != null) {
                canvas.drawBitmap(bitmap, this.currentX - (bitmap.getWidth() / 2), this.currentY - (this.bitmap1.getHeight() / 2), this.paint);
            }
        } else {
            Bitmap bitmap4 = this.bitmap1;
            if (bitmap4 != null) {
                canvas.drawBitmap(bitmap4, this.currentX - (bitmap4.getWidth() / 2), this.currentY - (this.bitmap1.getHeight() / 2), this.paint);
            }
        }
    }

    public void resetPostion() {
        setStatus(-1);
        this.currentX = this.initX;
        this.currentY = this.initY;
    }

    public void setPosition(float f, float f2) {
        setStatus(0);
        this.currentX = f;
        this.currentY = f2;
    }

    public void setPositionEnd(float f, float f2) {
        setStatus(2);
        this.currentX = f;
        this.currentY = f2;
    }

    public void setPositionFinish(float f, float f2) {
        setStatus(1);
        this.currentX = f;
        this.currentY = f2;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
