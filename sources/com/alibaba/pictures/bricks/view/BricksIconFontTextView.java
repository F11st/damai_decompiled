package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.md;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BricksIconFontTextView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int angle;

    public BricksIconFontTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView
    public Typeface getTypeface() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "76895012") ? (Typeface) ipChange.ipc$dispatch("76895012", new Object[]{this}) : md.a(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "698595201")) {
            ipChange.ipc$dispatch("698595201", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        setTypeface(md.a(this));
        setIncludeFontPadding(false);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425538148")) {
            ipChange.ipc$dispatch("425538148", new Object[]{this});
            return;
        }
        setTypeface(null);
        md.b(this);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497111495")) {
            ipChange.ipc$dispatch("-1497111495", new Object[]{this, canvas});
            return;
        }
        int i = this.angle;
        if (i > 0) {
            canvas.rotate(i, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        }
        super.onDraw(canvas);
    }

    public void setRotateAngle(@IntRange(from = 0, to = 360) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1440178442")) {
            ipChange.ipc$dispatch("1440178442", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.angle = i;
        }
    }

    public BricksIconFontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BricksIconFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
