package tb;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pe2 {
    private final String a;
    private final int b;
    private final String c;
    private final long d;
    private List<me2> e;

    public pe2(String str, int i, String str2, long j) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = j;
    }

    public me2 a(String str) {
        List<me2> list = this.e;
        if (list != null) {
            for (me2 me2Var : list) {
                if (me2Var.b().equals(str)) {
                    return me2Var;
                }
            }
            return null;
        }
        return null;
    }

    public List<me2> b() {
        return this.e;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public void e(List<me2> list) {
        this.e = list;
    }

    public long f() {
        return this.d;
    }

    public String g() {
        return this.a;
    }
}
