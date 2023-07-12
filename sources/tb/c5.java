package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c5 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private String c;
    private qy1<Integer> d;

    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-624907988") ? (String) ipChange.ipc$dispatch("-624907988", new Object[]{this}) : this.c;
    }

    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1703043465") ? ((Integer) ipChange.ipc$dispatch("1703043465", new Object[]{this})).intValue() : this.b;
    }

    public qy1<Integer> c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "98806413") ? (qy1) ipChange.ipc$dispatch("98806413", new Object[]{this}) : this.d;
    }

    public int d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1248389848") ? ((Integer) ipChange.ipc$dispatch("1248389848", new Object[]{this})).intValue() : this.a;
    }

    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1809932082")) {
            ipChange.ipc$dispatch("1809932082", new Object[]{this, str});
        } else {
            this.c = str;
        }
    }

    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2129445063")) {
            ipChange.ipc$dispatch("-2129445063", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b = i;
        }
    }

    public void g(qy1<Integer> qy1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677744353")) {
            ipChange.ipc$dispatch("-1677744353", new Object[]{this, qy1Var});
        } else {
            this.d = qy1Var;
        }
    }

    public void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-43170358")) {
            ipChange.ipc$dispatch("-43170358", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a = i;
        }
    }
}
