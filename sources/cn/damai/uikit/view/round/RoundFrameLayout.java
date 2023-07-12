package cn.damai.uikit.view.round;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.y32;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RoundFrameLayout extends FrameLayout implements RoundMethodInterface {
    private static transient /* synthetic */ IpChange $ipChange;
    private y32 mHelper;

    public RoundFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030204664")) {
            ipChange.ipc$dispatch("-1030204664", new Object[]{this, canvas});
            return;
        }
        this.mHelper.d(canvas);
        super.draw(canvas);
        this.mHelper.a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-767305387")) {
            ipChange.ipc$dispatch("-767305387", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mHelper.c(i, i2);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311673035")) {
            ipChange.ipc$dispatch("311673035", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.f(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottom(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "724582806")) {
            ipChange.ipc$dispatch("724582806", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.h(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottomLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "482778301")) {
            ipChange.ipc$dispatch("482778301", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.i(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusBottomRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1178985700")) {
            ipChange.ipc$dispatch("-1178985700", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.j(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1690470030")) {
            ipChange.ipc$dispatch("-1690470030", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.k(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "169792775")) {
            ipChange.ipc$dispatch("169792775", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.l(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTop(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965611456")) {
            ipChange.ipc$dispatch("965611456", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.m(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTopLeft(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232605159")) {
            ipChange.ipc$dispatch("232605159", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.n(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadiusTopRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-344418510")) {
            ipChange.ipc$dispatch("-344418510", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.o(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124437291")) {
            ipChange.ipc$dispatch("124437291", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHelper.p(i);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1908028213")) {
            ipChange.ipc$dispatch("-1908028213", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mHelper.q(f);
        }
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setStrokeWidthColor(float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "306844149")) {
            ipChange.ipc$dispatch("306844149", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)});
        } else {
            this.mHelper.r(f, i);
        }
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    @Override // cn.damai.uikit.view.round.RoundMethodInterface
    public void setRadius(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641534187")) {
            ipChange.ipc$dispatch("-641534187", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        } else {
            this.mHelper.g(f, f2, f3, f4);
        }
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        y32 y32Var = new y32();
        this.mHelper = y32Var;
        y32Var.b(context, attributeSet, this);
    }
}
