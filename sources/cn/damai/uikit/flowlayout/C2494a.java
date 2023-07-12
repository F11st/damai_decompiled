package cn.damai.uikit.flowlayout;

import android.view.View;
import cn.damai.uikit.flowlayout.FlowLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: cn.damai.uikit.flowlayout.a */
/* loaded from: classes17.dex */
public class C2494a {
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

    public C2494a(int i, LayoutConfiguration layoutConfiguration) {
        this.c = i;
        this.b = layoutConfiguration;
    }

    public void a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "674066091")) {
            ipChange.ipc$dispatch("674066091", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.i += i;
        }
    }

    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1878472619")) {
            ipChange.ipc$dispatch("1878472619", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.h += i;
        }
    }

    public void c(int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-419185720")) {
            ipChange.ipc$dispatch("-419185720", new Object[]{this, Integer.valueOf(i), view});
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
        if (AndroidInstantRuntime.support(ipChange, "537503449")) {
            ipChange.ipc$dispatch("537503449", new Object[]{this, view});
        } else {
            c(this.a.size(), view);
        }
    }

    public boolean e(View view) {
        int measuredHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "545516204")) {
            return ((Boolean) ipChange.ipc$dispatch("545516204", new Object[]{this, view})).booleanValue();
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
        return AndroidInstantRuntime.support(ipChange, "-683770750") ? ((Integer) ipChange.ipc$dispatch("-683770750", new Object[]{this})).intValue() : this.d;
    }

    public int g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1546739008") ? ((Integer) ipChange.ipc$dispatch("-1546739008", new Object[]{this})).intValue() : this.i;
    }

    public int h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1407230646") ? ((Integer) ipChange.ipc$dispatch("1407230646", new Object[]{this})).intValue() : this.h;
    }

    public int i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "420370868") ? ((Integer) ipChange.ipc$dispatch("420370868", new Object[]{this})).intValue() : this.g;
    }

    public List<View> j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "435972980") ? (List) ipChange.ipc$dispatch("435972980", new Object[]{this}) : this.a;
    }

    public void k(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109481292")) {
            ipChange.ipc$dispatch("2109481292", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
        this.f = i + (this.f - this.d);
    }

    public void l(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656640662")) {
            ipChange.ipc$dispatch("-656640662", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.g = i;
        this.e = i - (this.g - this.e);
    }
}
