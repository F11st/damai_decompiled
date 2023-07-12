package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
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
        return AndroidInstantRuntime.support(ipChange, "550716598") ? ((Integer) ipChange.ipc$dispatch("550716598", new Object[]{this})).intValue() : this.d;
    }

    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-348874193") ? ((Integer) ipChange.ipc$dispatch("-348874193", new Object[]{this})).intValue() : this.e;
    }

    public int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-586257420") ? ((Integer) ipChange.ipc$dispatch("-586257420", new Object[]{this})).intValue() : this.a;
    }

    public float d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1783846024") ? ((Float) ipChange.ipc$dispatch("-1783846024", new Object[]{this})).floatValue() : this.c;
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1521129094") ? ((Boolean) ipChange.ipc$dispatch("1521129094", new Object[]{this})).booleanValue() : this.b;
    }

    public void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1038154574")) {
            ipChange.ipc$dispatch("1038154574", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.b = z;
        }
    }

    public void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879361004")) {
            ipChange.ipc$dispatch("-1879361004", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-912007237")) {
            ipChange.ipc$dispatch("-912007237", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            this.e = i;
        } else {
            this.e = 0;
        }
    }

    public void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-74047338")) {
            ipChange.ipc$dispatch("-74047338", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            this.a = i;
        } else {
            this.a = 0;
        }
    }

    public void j(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75548244")) {
            ipChange.ipc$dispatch("-75548244", new Object[]{this, Float.valueOf(f)});
        } else {
            this.c = Math.max(0.0f, f);
        }
    }
}
