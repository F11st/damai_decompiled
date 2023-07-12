package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class o33 {
    private p33 a;

    public abstract p33 a();

    public final void b(j43 j43Var) {
        try {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        p33 a = a();
                        this.a = a;
                        if (a == null) {
                            return;
                        }
                    }
                }
            }
            this.a.a(j43Var);
        } catch (Throwable th) {
            w63.c("efs.processor", "log handle error", th);
        }
    }
}
