package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RadiusSpan extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    private int height;
    private int mColor;
    private int mRadius;
    private int mSize;
    private int mTextColor;

    public RadiusSpan(int i, int i2, int i3, int i4) {
        this.mColor = i;
        this.mRadius = i3;
        this.mTextColor = i2;
        this.height = i4;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306756447")) {
            ipChange.ipc$dispatch("306756447", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        paint.setColor(this.mColor);
        paint.setAntiAlias(true);
        float descent = this.height - (paint.descent() - paint.ascent());
        float f2 = i4;
        RectF rectF = new RectF(f, (paint.ascent() + f2) - descent, this.mSize + f, paint.descent() + f2);
        int i6 = this.mRadius;
        canvas.drawRoundRect(rectF, i6, i6, paint);
        paint.setColor(this.mTextColor);
        canvas.drawText(charSequence, i, i2, f + this.mRadius, f2 - (descent / 2.0f), paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1499369289")) {
            return ((Integer) ipChange.ipc$dispatch("1499369289", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue();
        }
        int measureText = (int) (paint.measureText(charSequence, i, i2) + (this.mRadius * 2));
        this.mSize = measureText;
        return measureText;
    }
}
