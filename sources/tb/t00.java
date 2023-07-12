package tb;

import com.taobao.android.dinamicx.C6368e;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class t00<T> {
    public T a;
    private C6368e b;
    private d00 c;

    public t00(T t) {
        this.a = t;
    }

    public C6368e a() {
        return this.b;
    }

    public d00 b() {
        if (this.c == null) {
            this.c = new d00();
        }
        return this.c;
    }

    public boolean c() {
        C6368e c6368e = this.b;
        return c6368e != null && c6368e.c.size() > 0;
    }

    public void d(C6368e c6368e) {
        this.b = c6368e;
    }

    public void e(d00 d00Var) {
        this.c = d00Var;
    }

    public void f(T t) {
        this.a = t;
    }

    public t00(C6368e c6368e) {
        this.b = c6368e;
    }

    public t00(T t, C6368e c6368e) {
        this.a = t;
        this.b = c6368e;
    }

    public t00() {
    }
}
