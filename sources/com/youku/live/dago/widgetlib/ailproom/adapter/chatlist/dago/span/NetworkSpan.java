package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.style.ReplacementSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NetworkSpan extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private BitmapDrawable drawable;
    private int tint;
    private boolean tintFlag;

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319462043")) {
            ipChange.ipc$dispatch("-319462043", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        BitmapDrawable bitmapDrawable = this.drawable;
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        int i6 = (((i5 - i3) - this.drawable.getBounds().bottom) / 2) + i3;
        canvas.translate(f, 0.0f);
        if (this.tintFlag) {
            Paint paint2 = new Paint();
            paint2.setColor(this.tint);
            paint2.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.drawable.getBounds().left, i3, this.drawable.getBounds().right, i5, paint2);
        }
        canvas.translate(0.0f, i6);
        this.drawable.draw(canvas);
        canvas.restore();
    }

    public BitmapDrawable getDrawable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-690612011") ? (BitmapDrawable) ipChange.ipc$dispatch("-690612011", new Object[]{this}) : this.drawable;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-917971197")) {
            return ((Integer) ipChange.ipc$dispatch("-917971197", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue();
        }
        BitmapDrawable bitmapDrawable = this.drawable;
        if (bitmapDrawable == null) {
            return 0;
        }
        Rect bounds = bitmapDrawable.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = (bounds.bottom - bounds.top) / 2;
            int i5 = i3 / 4;
            int i6 = i4 - i5;
            int i7 = -(i4 + i5);
            fontMetricsInt.ascent = i7;
            fontMetricsInt.top = i7;
            fontMetricsInt.bottom = i6;
            fontMetricsInt.descent = i6;
        }
        return bounds.right;
    }

    public void setDrawable(BitmapDrawable bitmapDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434398881")) {
            ipChange.ipc$dispatch("-434398881", new Object[]{this, bitmapDrawable});
        } else {
            this.drawable = bitmapDrawable;
        }
    }

    public void setTintColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086531433")) {
            ipChange.ipc$dispatch("1086531433", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.tint = i;
        this.tintFlag = true;
    }

    public void setTintFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891029779")) {
            ipChange.ipc$dispatch("891029779", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.tintFlag = z;
        }
    }
}
