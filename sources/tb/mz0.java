package tb;

import com.taobao.phenix.cache.LruCache;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mz0<K, V> implements LruCache<K, V> {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private HashMap<K, mc1<K, V>> f;
    private mc1<K, V> g;
    private mc1<K, V> h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public mz0(int i, float f) {
        resize(i, f);
        this.f = new HashMap<>();
    }

    private void b(mc1<K, V> mc1Var, boolean z, boolean z2, boolean z3) {
        boolean z4;
        synchronized (this) {
            z4 = z != mc1Var.i;
            if (z4) {
                mc1Var.i = z;
                if (z) {
                    this.i += mc1Var.c;
                } else {
                    this.i -= mc1Var.c;
                }
            }
        }
        if (z4 && z2) {
            l(z, mc1Var.a, mc1Var.b, z3);
        }
    }

    private void c() {
        boolean z = this.c < this.a;
        cu1.b(z, "MAX_PRE_EVICTED_SIZE(" + this.c + ") must lower than MAX_LIMIT_SIZE(" + this.a + jn1.BRACKET_END_STR);
    }

    private void f(mc1<K, V> mc1Var) {
        mc1<K, V> mc1Var2 = this.h;
        if (mc1Var2 != null) {
            mc1Var.a(mc1Var2);
        }
        r(mc1Var, true);
    }

    private void g(mc1<K, V> mc1Var) {
        mc1<K, V> mc1Var2;
        mc1<K, V> mc1Var3 = this.g;
        if (mc1Var3 != null) {
            mc1Var.a(mc1Var3);
        } else {
            mc1Var.e = mc1Var;
            mc1Var.f = mc1Var;
        }
        boolean z = this.h == this.g;
        t(mc1Var, true);
        int i = this.e;
        if (i <= this.b || (mc1Var2 = this.h) == null) {
            return;
        }
        if (z && mc1Var2.e != mc1Var2) {
            this.e = i - mc1Var2.c;
            mc1Var2.g = true;
        }
        q(mc1Var2.e);
    }

    private void i(mc1<K, V> mc1Var) {
        if (mc1Var != null) {
            this.d += mc1Var.c;
        }
    }

    private void k(boolean z, mc1<K, V> mc1Var, boolean z2) {
        b(mc1Var, false, z2, true);
        j(z, mc1Var.a, mc1Var.b);
    }

    private void m(mc1<K, V> mc1Var) {
        if (mc1Var != null) {
            int i = this.d;
            int i2 = mc1Var.c;
            this.d = i - i2;
            if (mc1Var.g) {
                return;
            }
            this.e -= i2;
        }
    }

    private synchronized void n(boolean z) {
        mc1<K, V> mc1Var = this.g;
        if (mc1Var != null && (z || this.d > this.m)) {
            mc1<K, V> mc1Var2 = mc1Var.e;
            mc1<K, V> mc1Var3 = mc1Var2;
            while (this.i < this.c) {
                if (mc1Var3.d < 2) {
                    b(mc1Var3, true, true, false);
                }
                mc1Var3 = mc1Var3.e;
                if (mc1Var3 == mc1Var2) {
                    break;
                }
            }
            this.m = this.d;
        }
    }

    private void p(mc1<K, V> mc1Var) {
        mc1<K, V> mc1Var2 = mc1Var.f;
        if (mc1Var2 == mc1Var) {
            s(null);
            q(null);
        } else {
            mc1Var2.e = mc1Var.e;
            mc1Var.e.f = mc1Var2;
            if (this.g == mc1Var) {
                s(mc1Var.f);
            }
            if (this.h == mc1Var) {
                q(mc1Var.f);
            }
        }
        m(mc1Var);
    }

    private boolean q(mc1<K, V> mc1Var) {
        return r(mc1Var, false);
    }

    private boolean r(mc1<K, V> mc1Var, boolean z) {
        this.h = mc1Var;
        if (mc1Var == null || this.g == mc1Var) {
            return false;
        }
        if (!z && !mc1Var.g) {
            this.e -= mc1Var.c;
        }
        mc1Var.g = true;
        return true;
    }

    private void s(mc1<K, V> mc1Var) {
        t(mc1Var, false);
    }

    private void t(mc1<K, V> mc1Var, boolean z) {
        if (mc1Var != null) {
            if (z || mc1Var.g) {
                this.e += mc1Var.c;
            }
            mc1Var.g = false;
        }
        this.g = mc1Var;
    }

    public void a(String str) {
        if (hh0.g(3)) {
            int i = this.j;
            xt2.a(str, "%K(%K)/%K, pre-evicted:%K/%K, rate:%.1f%%, count:%d, hits:%d, misses:%d, evicts:%d", Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.a), Integer.valueOf(this.i), Integer.valueOf(this.c), Float.valueOf((i * 100.0f) / (i + this.k)), Integer.valueOf(count()), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l));
        }
    }

    @Override // com.taobao.phenix.cache.LruCache, com.taobao.phenix.bitmap.BitmapPool
    public synchronized void clear() {
        this.f.clear();
        s(null);
        q(null);
        this.d = 0;
        this.e = 0;
        this.i = 0;
        this.m = 0;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized int count() {
        return this.f.size();
    }

    public final synchronized boolean d(K k) {
        return this.f.containsKey(k);
    }

    protected int e(V v) {
        throw null;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public V get(K k) {
        mc1<K, V> mc1Var;
        synchronized (this) {
            mc1Var = this.f.get(k);
            if (mc1Var != null) {
                int i = mc1Var.d;
                mc1Var.d = i < 0 ? 1 : i + 1;
            }
        }
        if (mc1Var != null) {
            b(mc1Var, false, true, false);
            this.j++;
            return mc1Var.b;
        }
        this.k++;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized int h() {
        return this.c;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized float hotPercent() {
        return this.b / this.a;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized boolean isEmpty() {
        return this.g == null;
    }

    protected void j(boolean z, K k, V v) {
    }

    protected void l(boolean z, K k, V v, boolean z2) {
        throw null;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized int maxSize() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V o(K k, boolean z) {
        mc1<K, V> remove;
        synchronized (this) {
            remove = this.f.remove(k);
            if (remove != null) {
                remove.d = -1;
                if (remove.e != null) {
                    p(remove);
                }
            }
        }
        if (remove != null) {
            k(false, remove, z);
            return remove.b;
        }
        return null;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public boolean put(K k, V v) {
        return put(17, k, v);
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final V remove(K k) {
        return o(k, true);
    }

    @Override // com.taobao.phenix.cache.LruCache
    public void resize(int i, float f) {
        if (i >= 2 && f >= 0.0f && f < 1.0f) {
            synchronized (this) {
                this.a = i;
                int i2 = (int) (i * f);
                this.b = i2;
                if (i2 < 1) {
                    this.b = 1;
                } else if (i - i2 < 1) {
                    this.b = i - 1;
                }
            }
            c();
            trimTo(this.a);
            return;
        }
        throw new RuntimeException("HotEndLruCache size parameters error");
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final synchronized int size() {
        return this.d;
    }

    @Override // com.taobao.phenix.cache.LruCache
    public final boolean trimTo(int i) {
        mc1<K, V> mc1Var = null;
        while (true) {
            synchronized (this) {
                if (this.d <= i) {
                    break;
                }
                while (true) {
                    mc1Var = this.g.e;
                    if (mc1Var.d < 2) {
                        break;
                    }
                    mc1Var.d = 1;
                    s(mc1Var);
                    while (true) {
                        int i2 = this.b;
                        if (i2 <= 0 || this.e <= i2 || !q(this.h.e)) {
                        }
                    }
                }
                this.f.remove(mc1Var.a);
                p(mc1Var);
                this.l++;
            }
            k(false, mc1Var, true);
        }
        return mc1Var != null;
    }

    public synchronized void u(int i) {
        this.c = i;
        c();
        n(true);
    }

    @Override // com.taobao.phenix.cache.LruCache
    public boolean put(int i, K k, V v) {
        mc1<K, V> put;
        if (k == null || v == null) {
            return false;
        }
        mc1<K, V> mc1Var = new mc1<>(k, v, e(v));
        if (i == 34) {
            mc1Var.d = 2;
        }
        if (mc1Var.c > this.a) {
            return false;
        }
        synchronized (this) {
            put = this.f.put(k, mc1Var);
            if (put != null) {
                int i2 = put.d;
                p(put);
                mc1Var.d = i2 + 1;
            }
        }
        if (put != null) {
            k(true, put, true);
        }
        boolean trimTo = trimTo(this.a - mc1Var.c);
        synchronized (this) {
            if (this.g != null && this.h != null && trimTo) {
                f(mc1Var);
                i(mc1Var);
            }
            g(mc1Var);
            i(mc1Var);
            if (this.h == null && this.d > this.b) {
                q(this.g.e);
            }
        }
        n(trimTo);
        return true;
    }
}
