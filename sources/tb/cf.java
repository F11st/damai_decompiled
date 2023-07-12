package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.C4834e;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class cf {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;

    public cf(long j, long j2, long j3, long j4, long j5, long j6) {
        du1.d(j >= 0);
        du1.d(j2 >= 0);
        du1.d(j3 >= 0);
        du1.d(j4 >= 0);
        du1.d(j5 >= 0);
        du1.d(j6 >= 0);
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
    }

    public long a() {
        return this.f;
    }

    public long b() {
        return this.a;
    }

    public long c() {
        return this.d;
    }

    public long d() {
        return this.c;
    }

    public long e() {
        return this.b;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof cf) {
            cf cfVar = (cf) obj;
            return this.a == cfVar.a && this.b == cfVar.b && this.c == cfVar.c && this.d == cfVar.d && this.e == cfVar.e && this.f == cfVar.f;
        }
        return false;
    }

    public long f() {
        return this.e;
    }

    public int hashCode() {
        return nm1.b(Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f));
    }

    public String toString() {
        return C4834e.b(this).c("hitCount", this.a).c("missCount", this.b).c("loadSuccessCount", this.c).c("loadExceptionCount", this.d).c("totalLoadTime", this.e).c("evictionCount", this.f).toString();
    }
}
