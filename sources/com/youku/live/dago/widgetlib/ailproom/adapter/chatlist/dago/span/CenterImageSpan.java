package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.util.UIUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CenterImageSpan extends ImageSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private static int mIconHeight = UIUtil.dip2px(14);
    private BitmapDrawable mDrawable;

    public CenterImageSpan(Drawable drawable) {
        super(drawable);
        setDrawable((BitmapDrawable) drawable);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "848096269")) {
            ipChange.ipc$dispatch("848096269", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        if (this.mDrawable == null) {
            this.mDrawable = (BitmapDrawable) getDrawable();
        }
        Bitmap bitmap = this.mDrawable.getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i6 = mIconHeight;
        this.mDrawable.setBounds(0, 0, (width * i6) / height, i6);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.save();
        canvas.translate(f, ((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (this.mDrawable.getBounds().bottom / 2));
        this.mDrawable.draw(canvas);
        canvas.restore();
    }

    public void setDrawable(BitmapDrawable bitmapDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-372722169")) {
            ipChange.ipc$dispatch("-372722169", new Object[]{this, bitmapDrawable});
        } else {
            this.mDrawable = bitmapDrawable;
        }
    }
}
