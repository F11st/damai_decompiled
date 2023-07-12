package tb;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class nc1<K, V> {
    public K a;
    public V b;
    public int c;
    public int d;
    public nc1<K, V> e;
    public nc1<K, V> f;
    public boolean g;
    public boolean h;
    public boolean i;

    public nc1(K k, V v, int i) {
        b(k, v, i);
    }

    public void a(nc1<K, V> nc1Var) {
        nc1<K, V> nc1Var2 = this.e;
        if (nc1Var2 != null && nc1Var2 != this) {
            nc1Var2.f = this.f;
        }
        nc1<K, V> nc1Var3 = this.f;
        if (nc1Var3 != null && nc1Var3 != this) {
            nc1Var3.e = nc1Var2;
        }
        this.f = nc1Var;
        nc1<K, V> nc1Var4 = nc1Var.e;
        if (nc1Var4 != null) {
            nc1Var4.f = this;
        }
        this.e = nc1Var4;
        nc1Var.e = this;
    }

    public void b(K k, V v, int i) {
        this.a = k;
        this.b = v;
        this.d = 1;
        this.c = i;
    }

    public String toString() {
        return "LruNode@" + hashCode() + "[key:" + this.a + ", value:" + this.b + ", visitCount:" + this.d + ", size:" + this.c + ", isColdNode:" + this.g + ", unlinked:" + this.h + jn1.ARRAY_END_STR;
    }
}
