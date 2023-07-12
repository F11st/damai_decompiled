package com.taobao.ma.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ViewfinderView extends View {
    public long ANIMATION_DELAY;
    public int SPEEN_DISTANCE;
    public int VIEWFINDER_CORNER_HEIGHT;
    public int VIEWFINDER_CORNER_WIDTH;
    public int VIEWFINDER_HEIGHT;
    public int VIEWFINDER_MIDDLE_LINE_PADDING;
    public int VIEWFINDER_MIDDLE_LINE_WIDTH;
    public int VIEWFINDER_WIDTH;
    private boolean isFirst;
    public int laserColor;
    private Context mContext;
    private DisplayMetrics metrics;
    private final Paint paint;
    private int slideTop;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ANIMATION_DELAY = 20L;
        this.VIEWFINDER_WIDTH = 660;
        this.VIEWFINDER_HEIGHT = 660;
        this.VIEWFINDER_CORNER_HEIGHT = 16;
        this.VIEWFINDER_CORNER_WIDTH = 8;
        this.VIEWFINDER_MIDDLE_LINE_WIDTH = 5;
        this.VIEWFINDER_MIDDLE_LINE_PADDING = 15;
        this.SPEEN_DISTANCE = 6;
        this.laserColor = Color.parseColor("#ffcc0000");
        this.isFirst = false;
        this.mContext = context;
        this.paint = new Paint(1);
        this.metrics = this.mContext.getResources().getDisplayMetrics();
    }

    private Point getScreenSize() {
        DisplayMetrics displayMetrics = this.metrics;
        return new Point(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
    }

    private Rect getViewFinderRect() {
        Point screenSize = getScreenSize();
        int i = this.VIEWFINDER_WIDTH;
        int i2 = this.VIEWFINDER_HEIGHT;
        int xVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(screenSize) - i) / 2;
        int yVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(screenSize) - i2) / 2;
        return new Rect(xVar, yVar, i + xVar, i2 + yVar);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mContext = null;
        this.isFirst = false;
        this.metrics = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Rect viewFinderRect = getViewFinderRect();
        if (viewFinderRect == null) {
            return;
        }
        if (!this.isFirst) {
            this.isFirst = true;
            this.slideTop = viewFinderRect.top;
            this.VIEWFINDER_CORNER_HEIGHT = (int) (this.VIEWFINDER_CORNER_HEIGHT * this.metrics.density);
        }
        this.paint.setColor(-1);
        canvas.drawRect(viewFinderRect.left, viewFinderRect.top, i + this.VIEWFINDER_CORNER_HEIGHT, i2 + this.VIEWFINDER_CORNER_WIDTH, this.paint);
        canvas.drawRect(viewFinderRect.left, viewFinderRect.top, i3 + this.VIEWFINDER_CORNER_WIDTH, i4 + this.VIEWFINDER_CORNER_HEIGHT, this.paint);
        int i14 = viewFinderRect.right;
        canvas.drawRect(i14 - this.VIEWFINDER_CORNER_HEIGHT, viewFinderRect.top, i14, i5 + this.VIEWFINDER_CORNER_WIDTH, this.paint);
        int i15 = viewFinderRect.right;
        canvas.drawRect(i15 - this.VIEWFINDER_CORNER_WIDTH, viewFinderRect.top, i15, i6 + this.VIEWFINDER_CORNER_HEIGHT, this.paint);
        canvas.drawRect(viewFinderRect.left, i8 - this.VIEWFINDER_CORNER_WIDTH, i7 + this.VIEWFINDER_CORNER_HEIGHT, viewFinderRect.bottom, this.paint);
        canvas.drawRect(viewFinderRect.left, i10 - this.VIEWFINDER_CORNER_HEIGHT, i9 + this.VIEWFINDER_CORNER_WIDTH, viewFinderRect.bottom, this.paint);
        int i16 = viewFinderRect.right;
        canvas.drawRect(i16 - this.VIEWFINDER_CORNER_HEIGHT, i11 - this.VIEWFINDER_CORNER_WIDTH, i16, viewFinderRect.bottom, this.paint);
        int i17 = viewFinderRect.right;
        canvas.drawRect(i17 - this.VIEWFINDER_CORNER_WIDTH, i12 - this.VIEWFINDER_CORNER_HEIGHT, i17, viewFinderRect.bottom, this.paint);
        int i18 = this.slideTop + this.SPEEN_DISTANCE;
        this.slideTop = i18;
        if (i18 >= viewFinderRect.bottom) {
            this.slideTop = viewFinderRect.top;
        }
        this.paint.setColor(this.laserColor);
        float f = viewFinderRect.left + this.VIEWFINDER_MIDDLE_LINE_PADDING;
        int i19 = this.slideTop;
        int i20 = this.VIEWFINDER_MIDDLE_LINE_WIDTH;
        canvas.drawRect(f, i19 - (i20 / 2), viewFinderRect.right - i13, i19 + (i20 / 2), this.paint);
        postInvalidateDelayed(this.ANIMATION_DELAY, viewFinderRect.left, viewFinderRect.top, viewFinderRect.right, viewFinderRect.bottom);
    }
}
