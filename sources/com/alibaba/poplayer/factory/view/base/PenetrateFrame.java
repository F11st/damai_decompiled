package com.alibaba.poplayer.factory.view.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import tb.dt1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PenetrateFrame extends FrameLayout {
    private static final int DEFAULT_PENETRATE_ALPHA = 204;
    private boolean mBitmapCacheUpdated;
    private int mPenetrateAlpha;
    private boolean mUseCacheMark;

    public PenetrateFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPenetrateAlpha = 204;
        this.mUseCacheMark = true;
        initialize(context);
    }

    private void initialize(Context context) {
        setLayoutTransition(null);
    }

    private void updateBitmapCacheIfNeed() {
        if (!this.mUseCacheMark || this.mBitmapCacheUpdated) {
            destroyDrawingCache();
            buildDrawingCache();
            this.mBitmapCacheUpdated = false;
        }
    }

    public void destroy() {
        removeAllViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            this.mBitmapCacheUpdated = true;
        } catch (Throwable th) {
            dt1.c("PenetrateFrame.dispatchDraw.error", th);
        }
    }

    public int getPenetrateAlpha() {
        return this.mPenetrateAlpha;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            int i = this.mPenetrateAlpha;
            if (255 == i) {
                return false;
            }
            if (i == 0) {
                return true;
            }
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x >= 0 && y >= 0) {
                if (motionEvent.getAction() == 0) {
                    updateBitmapCacheIfNeed();
                }
                Bitmap drawingCache = getDrawingCache();
                if (x <= drawingCache.getWidth() && y <= drawingCache.getHeight()) {
                    return 255 - Color.alpha(drawingCache.getPixel(x, y)) > this.mPenetrateAlpha;
                }
            }
            return true;
        } catch (Throwable th) {
            dt1.c("PenetrateFrame.onInterceptTouchEvent.error", th);
            return true;
        }
    }

    public void setPenetrateAlpha(int i) {
        if (i > 255) {
            i = 255;
        } else if (i < 0) {
            i = 0;
        }
        this.mPenetrateAlpha = i;
        dt1.b("PenetrateFrame.setPenetrateAlpha.penetrateAlpha{%s}", Integer.valueOf(i));
    }

    public void setUseCacheMark(boolean z) {
        this.mUseCacheMark = z;
    }

    public PenetrateFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPenetrateAlpha = 204;
        this.mUseCacheMark = true;
        initialize(context);
    }

    public PenetrateFrame(Context context) {
        super(context);
        this.mPenetrateAlpha = 204;
        this.mUseCacheMark = true;
        initialize(context);
    }
}
