package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mc1<K, V> {
    public K a;
    public V b;
    public int c;
    public int d;
    public mc1<K, V> e;
    public mc1<K, V> f;
    public boolean g;
    public boolean h;
    public boolean i;

    public mc1(K k, V v, int i) {
        b(k, v, i);
    }

    public void a(mc1<K, V> mc1Var) {
        mc1<K, V> mc1Var2 = this.e;
        if (mc1Var2 != null && mc1Var2 != this) {
            mc1Var2.f = this.f;
        }
        mc1<K, V> mc1Var3 = this.f;
        if (mc1Var3 != null && mc1Var3 != this) {
            mc1Var3.e = mc1Var2;
        }
        this.f = mc1Var;
        mc1<K, V> mc1Var4 = mc1Var.e;
        if (mc1Var4 != null) {
            mc1Var4.f = this;
        }
        this.e = mc1Var4;
        mc1Var.e = this;
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
