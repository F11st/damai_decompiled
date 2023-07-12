package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class dc0<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String b;
    @Nullable
    private String d;
    @Nullable
    private String e;
    @Nullable
    private Object f;
    @Nullable
    private BizResponse g;
    @Nullable
    private Object h;
    @Nullable
    private String a = "-1";
    private int c = -1;

    @Nullable
    public final BizResponse a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1462580600") ? (BizResponse) ipChange.ipc$dispatch("1462580600", new Object[]{this}) : this.g;
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1627688689") ? ((Integer) ipChange.ipc$dispatch("1627688689", new Object[]{this})).intValue() : this.c;
    }

    @Nullable
    public final String c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1513792937") ? (String) ipChange.ipc$dispatch("1513792937", new Object[]{this}) : this.e;
    }

    @Nullable
    public final String d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "180397544") ? (String) ipChange.ipc$dispatch("180397544", new Object[]{this}) : this.d;
    }

    @Nullable
    public final String e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1181193985") ? (String) ipChange.ipc$dispatch("1181193985", new Object[]{this}) : this.a;
    }

    @Nullable
    public final String f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1655785495") ? (String) ipChange.ipc$dispatch("-1655785495", new Object[]{this}) : this.b;
    }

    public final void g(@Nullable BizResponse bizresponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "494573410")) {
            ipChange.ipc$dispatch("494573410", new Object[]{this, bizresponse});
        } else {
            this.g = bizresponse;
        }
    }

    public final void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1692151751")) {
            ipChange.ipc$dispatch("-1692151751", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.c = i;
        }
    }

    public final void i(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781994003")) {
            ipChange.ipc$dispatch("-781994003", new Object[]{this, str});
        } else {
            this.e = str;
        }
    }

    public final void j(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125561846")) {
            ipChange.ipc$dispatch("125561846", new Object[]{this, str});
        } else {
            this.d = str;
        }
    }

    public final void k(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-326802141")) {
            ipChange.ipc$dispatch("-326802141", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public final void l(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077269323")) {
            ipChange.ipc$dispatch("1077269323", new Object[]{this, obj});
        } else {
            this.f = obj;
        }
    }

    public final void m(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "147391741")) {
            ipChange.ipc$dispatch("147391741", new Object[]{this, str});
        } else {
            this.a = str;
        }
    }

    public final void n(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1658406483")) {
            ipChange.ipc$dispatch("-1658406483", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }

    public final void o(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2145055484")) {
            ipChange.ipc$dispatch("2145055484", new Object[]{this, obj});
        } else {
            this.h = obj;
        }
    }
}
