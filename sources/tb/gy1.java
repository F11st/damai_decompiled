package tb;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class gy1 {
    private boolean a = false;
    private boolean b = true;
    protected long c;

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a() {
        if (this.b) {
            if (System.currentTimeMillis() - this.c > c() * 1000) {
                this.b = false;
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean b(double d) {
        return d < 40.0d;
    }

    public int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(boolean z) {
        this.a = z;
    }
}
