package com.alibaba.pictures.bricks.view;

import android.view.View;
import com.alibaba.pictures.bricks.view.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private final LayoutConfiguration b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final List<View> a = new ArrayList();
    private int h = 0;
    private int i = 0;

    public a(int i, LayoutConfiguration layoutConfiguration) {
        this.c = i;
        this.b = layoutConfiguration;
    }

    public void a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1271645204")) {
            ipChange.ipc$dispatch("-1271645204", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.i += i;
        }
    }

    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071910090")) {
            ipChange.ipc$dispatch("2071910090", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.h += i;
        }
    }

    public void c(int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135799817")) {
            ipChange.ipc$dispatch("2135799817", new Object[]{this, Integer.valueOf(i), view});
            return;
        }
        FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams) view.getLayoutParams();
        this.a.add(i, view);
        int f = this.f + layoutParams.f();
        this.d = f;
        this.f = f + layoutParams.g();
        this.g = Math.max(this.g, layoutParams.i() + layoutParams.h());
        this.e = Math.max(this.e, layoutParams.i());
    }

    public void d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-765550984")) {
            ipChange.ipc$dispatch("-765550984", new Object[]{this, view});
        } else {
            c(this.a.size(), view);
        }
    }

    public boolean e(View view) {
        int measuredHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-604896467")) {
            return ((Boolean) ipChange.ipc$dispatch("-604896467", new Object[]{this, view})).booleanValue();
        }
        if (this.b.c() == 0) {
            measuredHeight = view.getMeasuredWidth();
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        return this.f + measuredHeight <= this.c;
    }

    public int f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-290156925") ? ((Integer) ipChange.ipc$dispatch("-290156925", new Object[]{this})).intValue() : this.d;
    }

    public int g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2131274079") ? ((Integer) ipChange.ipc$dispatch("2131274079", new Object[]{this})).intValue() : this.i;
    }

    public int h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-110550089") ? ((Integer) ipChange.ipc$dispatch("-110550089", new Object[]{this})).intValue() : this.h;
    }

    public int i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1309113363") ? ((Integer) ipChange.ipc$dispatch("1309113363", new Object[]{this})).intValue() : this.g;
    }

    public List<View> j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2137567285") ? (List) ipChange.ipc$dispatch("2137567285", new Object[]{this}) : this.a;
    }

    public void k(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593114859")) {
            ipChange.ipc$dispatch("593114859", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
        this.f = i + (this.f - this.d);
    }

    public void l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263026837")) {
            ipChange.ipc$dispatch("-263026837", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.g = i;
        this.e = i - (this.g - this.e);
    }
}
