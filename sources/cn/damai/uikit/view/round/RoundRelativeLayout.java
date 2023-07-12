package cn.damai.uikit.view.round;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.y32;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RoundRelativeLayout extends RelativeLayout implements RoundMethodInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private y32 mHelper;

    public RoundRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2120101525")) {
            ipChange.ipc$dispatch("-2120101525", new Object[]{this, canvas});
            return;
        }
        this.mHelper.d(canvas);
        super.draw(canvas);
        this.mHelper.a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239782456")) {
            ipChange.ipc$dispatch("1239782456", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mHelper.c(i, i2);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1259155272")) {
            ipChange.ipc$dispatch("1259155272", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.f(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650780243")) {
            ipChange.ipc$dispatch("650780243", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.h(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottomLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897985798")) {
            ipChange.ipc$dispatch("-897985798", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.i(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottomRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032999809")) {
            ipChange.ipc$dispatch("-1032999809", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.j(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "70345071")) {
            ipChange.ipc$dispatch("70345071", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.k(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1079513942")) {
            ipChange.ipc$dispatch("-1079513942", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.l(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTop(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883864611")) {
            ipChange.ipc$dispatch("883864611", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.m(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTopLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2055274294")) {
            ipChange.ipc$dispatch("-2055274294", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.n(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTopRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1745762479")) {
            ipChange.ipc$dispatch("1745762479", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.o(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1124869426")) {
            ipChange.ipc$dispatch("-1124869426", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHelper.p(i);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137632366")) {
            ipChange.ipc$dispatch("1137632366", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.q(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeWidthColor(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "452830040")) {
            ipChange.ipc$dispatch("452830040", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
        } else {
            this.mHelper.r(f, i);
        }
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadius(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723281032")) {
            ipChange.ipc$dispatch("-723281032", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        } else {
            this.mHelper.g(f, f2, f3, f4);
        }
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        y32 y32Var = new y32();
        this.mHelper = y32Var;
        y32Var.b(context, attributeSet, this);
    }
}
