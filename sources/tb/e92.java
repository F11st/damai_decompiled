package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class e92 {
    private static transient /* synthetic */ IpChange $ipChange;
    private final boolean a;
    private boolean b;
    public final int c;
    public final boolean d;
    public final String e;
    public final String f;
    public final long g;
    public final long h;

    public e92(long j, long j2, boolean z, int i, long j3, boolean z2, String str, String str2) {
        this.g = j;
        this.h = j2;
        this.a = z;
        this.c = i;
        this.d = z2;
        this.e = str;
        this.f = str2;
    }

    public boolean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "629876612") ? ((Boolean) ipChange.ipc$dispatch("629876612", new Object[]{this})).booleanValue() : this.a;
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "324045303") ? ((Boolean) ipChange.ipc$dispatch("324045303", new Object[]{this})).booleanValue() : this.b;
    }

    public void c(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1202899195")) {
            ipChange.ipc$dispatch("1202899195", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.b = z;
        }
    }
}
