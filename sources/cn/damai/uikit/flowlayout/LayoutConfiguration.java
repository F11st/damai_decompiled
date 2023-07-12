package cn.damai.uikit.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LayoutConfiguration {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a = 0;
    private boolean b = false;
    private float c = 0.0f;
    private int d = 51;
    private int e = 0;

    public LayoutConfiguration(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout);
        try {
            i(obtainStyledAttributes.getInteger(R$styleable.FlowLayout_android_orientation, 0));
            f(obtainStyledAttributes.getBoolean(R$styleable.FlowLayout_debugDraw, false));
            j(obtainStyledAttributes.getFloat(R$styleable.FlowLayout_weightDefault, 0.0f));
            g(obtainStyledAttributes.getInteger(R$styleable.FlowLayout_android_gravity, 0));
            h(obtainStyledAttributes.getInteger(R$styleable.FlowLayout_layoutDirection, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "244952821") ? ((Integer) ipChange.ipc$dispatch("244952821", new Object[]{this})).intValue() : this.d;
    }

    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2050468498") ? ((Integer) ipChange.ipc$dispatch("-2050468498", new Object[]{this})).intValue() : this.e;
    }

    public int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1359453875") ? ((Integer) ipChange.ipc$dispatch("1359453875", new Object[]{this})).intValue() : this.a;
    }

    public float d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-266065289") ? ((Float) ipChange.ipc$dispatch("-266065289", new Object[]{this})).floatValue() : this.c;
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "632386599") ? ((Boolean) ipChange.ipc$dispatch("632386599", new Object[]{this})).booleanValue() : this.b;
    }

    public void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1655108783")) {
            ipChange.ipc$dispatch("1655108783", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.b = z;
        }
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526863797")) {
            ipChange.ipc$dispatch("1526863797", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if ((i & 7) == 0) {
            i |= 3;
        }
        if ((i & 112) == 0) {
            i |= 48;
        }
        this.d = i;
    }

    public void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2121823140")) {
            ipChange.ipc$dispatch("-2121823140", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            this.e = i;
        } else {
            this.e = 0;
        }
    }

    public void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113460663")) {
            ipChange.ipc$dispatch("113460663", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            this.a = i;
        } else {
            this.a = 0;
        }
    }

    public void j(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-268985715")) {
            ipChange.ipc$dispatch("-268985715", new Object[]{this, Float.valueOf(f)});
        } else {
            this.c = Math.max(0.0f, f);
        }
    }
}
