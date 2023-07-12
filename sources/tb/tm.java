package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class tm {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static tm b = new tm();
    private int a;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final tm a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1826339645")) {
                return (tm) ipChange.ipc$dispatch("-1826339645", new Object[]{this});
            }
            if (tm.b == null) {
                synchronized (tm.class) {
                    if (tm.b == null) {
                        a aVar = tm.Companion;
                        tm.b = new tm(null);
                    }
                    wt2 wt2Var = wt2.INSTANCE;
                }
            }
            return tm.b;
        }
    }

    private tm() {
    }

    public /* synthetic */ tm(k50 k50Var) {
        this();
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1967125018") ? ((Integer) ipChange.ipc$dispatch("-1967125018", new Object[]{this})).intValue() : this.a;
    }

    public final void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348258544")) {
            ipChange.ipc$dispatch("1348258544", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public final void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975853840")) {
            ipChange.ipc$dispatch("-975853840", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public final void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462226972")) {
            ipChange.ipc$dispatch("-1462226972", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a = i;
        }
    }

    public final void g(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1232019277")) {
            ipChange.ipc$dispatch("1232019277", new Object[]{this, Float.valueOf(f)});
        }
    }

    public final void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078653647")) {
            ipChange.ipc$dispatch("-1078653647", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public final void i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54237327")) {
            ipChange.ipc$dispatch("54237327", new Object[]{this, Integer.valueOf(i)});
        }
    }
}
