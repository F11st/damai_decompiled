package com.youku.live.dago.widgetlib.doodle.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.doodle.SketchBoard;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SoftwareSketchBoard extends View implements SketchBoard {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mDrawCount;
    private int mDrawLimit;
    private Bitmap mDrawingBuffer;
    private Canvas mDrawingCanvas;
    private Rect mDrawingRect;
    private SketchBoard.OnDrawListener mOnDrawListener;

    public SoftwareSketchBoard(Context context) {
        this(context, null);
    }

    private void checkThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-157618422")) {
            ipChange.ipc$dispatch("-157618422", new Object[]{this});
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("SoftwareSketchBoard api must call on UI thread");
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845583")) {
            ipChange.ipc$dispatch("1845583", new Object[]{this});
            return;
        }
        checkThread();
        Canvas canvas = this.mDrawingCanvas;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            invalidate();
        }
        this.mDrawCount = 0;
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void draw(@NonNull Drawable drawable, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "161694261")) {
            ipChange.ipc$dispatch("161694261", new Object[]{this, drawable, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            draw(drawable, i, i2, i3, i2 + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(drawable.getBounds()) == 0 ? drawable.getIntrinsicWidth() : com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(drawable.getBounds())), i3 + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(drawable.getBounds()) == 0 ? drawable.getIntrinsicHeight() : com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(drawable.getBounds())));
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public int getBoardHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1514947114") ? ((Integer) ipChange.ipc$dispatch("1514947114", new Object[]{this})).intValue() : getMeasuredHeight();
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public int getBoardWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-870587015") ? ((Integer) ipChange.ipc$dispatch("-870587015", new Object[]{this})).intValue() : getMeasuredWidth();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920557914")) {
            ipChange.ipc$dispatch("920557914", new Object[]{this, canvas});
            return;
        }
        Bitmap bitmap = this.mDrawingBuffer;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477835800")) {
            ipChange.ipc$dispatch("-1477835800", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else if (i <= 0 || i2 <= 0) {
        } else {
            Bitmap bitmap = this.mDrawingBuffer;
            this.mDrawingBuffer = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.mDrawingCanvas = new Canvas(this.mDrawingBuffer);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.mDrawingCanvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            bitmap.recycle();
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void setDrawLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542179466")) {
            ipChange.ipc$dispatch("1542179466", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDrawLimit = i;
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void setOnDrawListener(SketchBoard.OnDrawListener onDrawListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801928912")) {
            ipChange.ipc$dispatch("1801928912", new Object[]{this, onDrawListener});
        } else {
            this.mOnDrawListener = onDrawListener;
        }
    }

    public SoftwareSketchBoard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SoftwareSketchBoard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawingRect = new Rect();
        this.mDrawCount = 0;
        this.mDrawLimit = 100;
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void draw(@NonNull Drawable drawable, int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770304341")) {
            ipChange.ipc$dispatch("770304341", new Object[]{this, drawable, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            return;
        }
        checkThread();
        if (this.mDrawCount >= this.mDrawLimit || this.mDrawingCanvas == null) {
            return;
        }
        Rect rect = this.mDrawingRect;
        rect.left = i2;
        rect.top = i3;
        rect.right = i4;
        rect.bottom = i5;
        drawable.setBounds(rect);
        drawable.draw(this.mDrawingCanvas);
        invalidate();
        int i6 = this.mDrawCount + 1;
        this.mDrawCount = i6;
        SketchBoard.OnDrawListener onDrawListener = this.mOnDrawListener;
        if (onDrawListener != null) {
            onDrawListener.onDraw(i, i2, i3, i6);
        }
    }
}
