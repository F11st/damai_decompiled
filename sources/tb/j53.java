package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class j53 {
    j53 a;

    public j53() {
    }

    public j53(j53 j53Var) {
        this.a = j53Var;
    }

    public void a(int i) {
        j53 j53Var = this.a;
        if (j53Var != null) {
            j53Var.a(i);
        }
    }

    public void b(boolean z) {
        j53 j53Var = this.a;
        if (j53Var != null) {
            j53Var.b(z);
        }
    }

    protected abstract boolean c();

    public int d() {
        j53 j53Var = this.a;
        return Math.min(Integer.MAX_VALUE, j53Var != null ? j53Var.d() : Integer.MAX_VALUE);
    }

    public final boolean e() {
        j53 j53Var = this.a;
        if (j53Var != null ? j53Var.e() : true) {
            return c();
        }
        return false;
    }
}
