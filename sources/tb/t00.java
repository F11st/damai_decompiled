package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class t00<T> {
    public T a;
    private com.taobao.android.dinamicx.e b;
    private d00 c;

    public t00(T t) {
        this.a = t;
    }

    public com.taobao.android.dinamicx.e a() {
        return this.b;
    }

    public d00 b() {
        if (this.c == null) {
            this.c = new d00();
        }
        return this.c;
    }

    public boolean c() {
        com.taobao.android.dinamicx.e eVar = this.b;
        return eVar != null && eVar.c.size() > 0;
    }

    public void d(com.taobao.android.dinamicx.e eVar) {
        this.b = eVar;
    }

    public void e(d00 d00Var) {
        this.c = d00Var;
    }

    public void f(T t) {
        this.a = t;
    }

    public t00(com.taobao.android.dinamicx.e eVar) {
        this.b = eVar;
    }

    public t00(T t, com.taobao.android.dinamicx.e eVar) {
        this.a = t;
        this.b = eVar;
    }

    public t00() {
    }
}
