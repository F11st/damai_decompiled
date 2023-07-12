package tb;

/* compiled from: Taobao */
/* renamed from: tb.g0 */
/* loaded from: classes8.dex */
public class C9152g0 {
    public Long a = -1L;
    public long b = -1;
    public long c = -1;

    public static C9152g0 a() {
        C9152g0 c9152g0 = new C9152g0();
        c9152g0.a = 10485760L;
        c9152g0.b = 0L;
        c9152g0.c = 0L;
        return c9152g0;
    }

    public void b(C9152g0 c9152g0) {
        if (c9152g0.a.longValue() >= 0) {
            this.a = c9152g0.a;
        }
        long j = c9152g0.b;
        if (j >= 0) {
            this.b = j;
        }
        long j2 = c9152g0.c;
        if (j2 >= 0) {
            this.c = j2;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AVFSCacheConfig{");
        stringBuffer.append("limitSize=");
        stringBuffer.append(C9248i0.a(this.a.longValue()));
        stringBuffer.append(", fileMemMaxSize=");
        stringBuffer.append(C9248i0.a(this.b));
        stringBuffer.append(", sqliteMemMaxSize=");
        stringBuffer.append(C9248i0.a(this.c));
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
