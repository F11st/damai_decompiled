package tb;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class g0 {
    public Long a = -1L;
    public long b = -1;
    public long c = -1;

    public static g0 a() {
        g0 g0Var = new g0();
        g0Var.a = 10485760L;
        g0Var.b = 0L;
        g0Var.c = 0L;
        return g0Var;
    }

    public void b(g0 g0Var) {
        if (g0Var.a.longValue() >= 0) {
            this.a = g0Var.a;
        }
        long j = g0Var.b;
        if (j >= 0) {
            this.b = j;
        }
        long j2 = g0Var.c;
        if (j2 >= 0) {
            this.c = j2;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AVFSCacheConfig{");
        stringBuffer.append("limitSize=");
        stringBuffer.append(i0.a(this.a.longValue()));
        stringBuffer.append(", fileMemMaxSize=");
        stringBuffer.append(i0.a(this.b));
        stringBuffer.append(", sqliteMemMaxSize=");
        stringBuffer.append(i0.a(this.c));
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
