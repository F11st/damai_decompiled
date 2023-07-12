package tb;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f53 extends j53 {
    private int b;
    private String c;

    public f53(String str, j53 j53Var) {
        super(j53Var);
        this.b = 30;
        this.c = str;
    }

    private static int f(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            com.loc.an.m(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // tb.j53
    protected final boolean c() {
        return f(this.c) >= this.b;
    }
}
