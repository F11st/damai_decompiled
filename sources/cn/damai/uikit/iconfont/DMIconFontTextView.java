package cn.damai.uikit.iconfont;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.IntRange;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ur;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DMIconFontTextView extends TextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int angle;

    public DMIconFontTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView
    public Typeface getTypeface() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-677431652") ? (Typeface) ipChange.ipc$dispatch("-677431652", new Object[]{this}) : ur.a(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "312039177")) {
            ipChange.ipc$dispatch("312039177", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        setTypeface(ur.a(this));
        setIncludeFontPadding(false);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687613460")) {
            ipChange.ipc$dispatch("-1687613460", new Object[]{this});
            return;
        }
        setTypeface(null);
        ur.b(this);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1912324529")) {
            ipChange.ipc$dispatch("1912324529", new Object[]{this, canvas});
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
        if (AndroidInstantRuntime.support(ipChange, "212414082")) {
            ipChange.ipc$dispatch("212414082", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.angle = i;
        }
    }

    public DMIconFontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMIconFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
