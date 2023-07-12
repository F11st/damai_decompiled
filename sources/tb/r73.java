package tb;

import com.amap.api.location.AMapLocation;

/* compiled from: Taobao */
@com.loc.as(a = com.huawei.hms.opendevice.c.a)
/* loaded from: classes10.dex */
public class r73 {
    @com.loc.at(a = "a2", b = 6)
    private String a;
    @com.loc.at(a = "a3", b = 5)
    private long b;
    @com.loc.at(a = "a4", b = 6)
    private String c;
    private AMapLocation d;

    public final AMapLocation a() {
        return this.d;
    }

    public final void b(long j) {
        this.b = j;
    }

    public final void c(AMapLocation aMapLocation) {
        this.d = aMapLocation;
    }

    public final void d(String str) {
        this.c = str;
    }

    public final String e() {
        return this.c;
    }

    public final void f(String str) {
        this.a = str;
    }

    public final String g() {
        return this.a;
    }

    public final long h() {
        return this.b;
    }
}
