package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class y22 {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;
    private int d;

    public final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2146093343")) {
            ipChange.ipc$dispatch("2146093343", new Object[]{this});
            return;
        }
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }

    public final int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-476578771") ? ((Integer) ipChange.ipc$dispatch("-476578771", new Object[]{this})).intValue() : this.c;
    }

    public final int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1935395260") ? ((Integer) ipChange.ipc$dispatch("1935395260", new Object[]{this})).intValue() : this.b;
    }

    public final int d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1913922471") ? ((Integer) ipChange.ipc$dispatch("1913922471", new Object[]{this})).intValue() : this.a;
    }

    public final void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1140177300")) {
            ipChange.ipc$dispatch("-1140177300", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.d = i;
        }
    }

    public final void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968976515")) {
            ipChange.ipc$dispatch("-968976515", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.c = i;
        }
    }

    public final void g(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743182642")) {
            ipChange.ipc$dispatch("-743182642", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.b = i;
        }
    }

    public final void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953323739")) {
            ipChange.ipc$dispatch("1953323739", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a = i;
        }
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058068530")) {
            return (String) ipChange.ipc$dispatch("-1058068530", new Object[]{this});
        }
        return "ResponsiveSize{suggestWidth=" + this.a + ", suggestHeight=" + this.b + ", screenWidth=" + this.c + ", screenHeight=" + this.d + '}';
    }
}
