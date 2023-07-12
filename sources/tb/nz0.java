package tb;

import com.taobao.alivfssdk.cache.LruCache;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class nz0<K, V> implements LruCache<K, V> {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final HashMap<K, nc1<K, V>> f;
    private nc1<K, V> g;
    private nc1<K, V> h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public nz0(int i, float f) {
        resize(i, f);
        this.f = new HashMap<>();
    }

    private void a() {
    }

    private void c(nc1<K, V> nc1Var) {
        nc1<K, V> nc1Var2 = this.h;
        if (nc1Var2 != null) {
            nc1Var.a(nc1Var2);
        }
        o(nc1Var, true);
    }

    private void d(nc1<K, V> nc1Var) {
        nc1<K, V> nc1Var2;
        nc1<K, V> nc1Var3 = this.g;
        if (nc1Var3 != null) {
            nc1Var.a(nc1Var3);
        } else {
            nc1Var.e = nc1Var;
            nc1Var.f = nc1Var;
        }
        boolean z = this.h == this.g;
        q(nc1Var, true);
        int i = this.e;
        if (i <= this.b || (nc1Var2 = this.h) == null) {
            return;
        }
        if (z && nc1Var2.e != nc1Var2) {
            this.e = i - nc1Var2.c;
            nc1Var2.g = true;
        }
        n(nc1Var2.e);
    }

    private void e(nc1<K, V> nc1Var) {
        if (nc1Var != null) {
            this.d += nc1Var.c;
        }
    }

    private void g(boolean z, nc1<K, V> nc1Var, boolean z2) {
        i(false, nc1Var, z2);
        f(z, nc1Var.a, nc1Var.b);
    }

    private void i(boolean z, nc1<K, V> nc1Var, boolean z2) {
        boolean z3;
        synchronized (this) {
            z3 = z != nc1Var.i;
            if (z3) {
                nc1Var.i = z;
                if (z) {
                    this.i += nc1Var.c;
                } else {
                    this.i -= nc1Var.c;
                }
            }
        }
        if (z3 && z2) {
            h(z, nc1Var.a, nc1Var.b);
        }
    }

    private void j(nc1<K, V> nc1Var) {
        if (nc1Var != null) {
            int i = this.d;
            int i2 = nc1Var.c;
            this.d = i - i2;
            if (nc1Var.g) {
                return;
            }
            this.e -= i2;
        }
    }

    private synchronized void k(boolean z) {
        nc1<K, V> nc1Var = this.g;
        if (nc1Var != null && (z || this.d > this.m)) {
            nc1<K, V> nc1Var2 = nc1Var.e;
            nc1<K, V> nc1Var3 = nc1Var2;
            while (this.i < this.c) {
                if (nc1Var3.d < 2) {
                    i(true, nc1Var3, true);
                }
                nc1Var3 = nc1Var3.e;
                if (nc1Var3 == nc1Var2) {
                    break;
                }
            }
            this.m = this.d;
        }
    }

    private void m(nc1<K, V> nc1Var) {
        nc1<K, V> nc1Var2 = nc1Var.f;
        if (nc1Var2 == nc1Var) {
            p(null);
            n(null);
        } else {
            nc1Var2.e = nc1Var.e;
            nc1Var.e.f = nc1Var2;
            if (this.g == nc1Var) {
                p(nc1Var.f);
            }
            if (this.h == nc1Var) {
                n(nc1Var.f);
            }
        }
        j(nc1Var);
    }

    private boolean n(nc1<K, V> nc1Var) {
        return o(nc1Var, false);
    }

    private boolean o(nc1<K, V> nc1Var, boolean z) {
        this.h = nc1Var;
        if (nc1Var == null || this.g == nc1Var) {
            return false;
        }
        if (!z && !nc1Var.g) {
            this.e -= nc1Var.c;
        }
        nc1Var.g = true;
        return true;
    }

    private void p(nc1<K, V> nc1Var) {
        q(nc1Var, false);
    }

    private void q(nc1<K, V> nc1Var, boolean z) {
        if (nc1Var != null) {
            if (z || nc1Var.g) {
                this.e += nc1Var.c;
            }
            nc1Var.g = false;
        }
        this.g = nc1Var;
    }

    protected int b(V v) {
        throw null;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public synchronized void clear() {
        this.f.clear();
        p(null);
        n(null);
        this.d = 0;
        this.e = 0;
        this.i = 0;
        this.m = 0;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized int count() {
        return this.f.size();
    }

    protected void f(boolean z, K k, V v) {
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public V get(K k) {
        nc1<K, V> nc1Var;
        synchronized (this) {
            nc1Var = this.f.get(k);
            if (nc1Var != null) {
                int i = nc1Var.d;
                nc1Var.d = i < 0 ? 1 : i + 1;
            }
        }
        if (nc1Var != null) {
            i(false, nc1Var, true);
            this.j++;
            return nc1Var.b;
        }
        this.k++;
        return null;
    }

    protected void h(boolean z, K k, V v) {
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized float hotPercent() {
        return this.b / this.a;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized boolean isEmpty() {
        return this.g == null;
    }

    protected V l(K k, boolean z) {
        nc1<K, V> remove;
        synchronized (this) {
            remove = this.f.remove(k);
            if (remove != null) {
                remove.d = -1;
                if (remove.e != null) {
                    m(remove);
                }
            }
        }
        if (remove != null) {
            g(false, remove, z);
            return remove.b;
        }
        return null;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized int maxSize() {
        return this.a;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public boolean put(K k, V v) {
        return put(17, k, v);
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final V remove(K k) {
        return l(k, true);
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
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
            a();
            trimTo(this.a);
            return;
        }
        throw new RuntimeException("HotEndLruCache size parameters error");
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final synchronized int size() {
        return this.d;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public final boolean trimTo(int i) {
        nc1<K, V> nc1Var = null;
        while (true) {
            synchronized (this) {
                if (this.d <= i) {
                    break;
                }
                while (true) {
                    nc1Var = this.g.e;
                    if (nc1Var.d < 2) {
                        break;
                    }
                    nc1Var.d = 1;
                    p(nc1Var);
                    while (true) {
                        int i2 = this.b;
                        if (i2 <= 0 || this.e <= i2 || !n(this.h.e)) {
                        }
                    }
                }
                this.f.remove(nc1Var.a);
                m(nc1Var);
                this.l++;
            }
            g(false, nc1Var, true);
        }
        return nc1Var != null;
    }

    @Override // com.taobao.alivfssdk.cache.LruCache
    public boolean put(int i, K k, V v) {
        nc1<K, V> put;
        if (k == null || v == null) {
            return false;
        }
        nc1<K, V> nc1Var = new nc1<>(k, v, b(v));
        if (i == 34) {
            nc1Var.d = 2;
        }
        if (nc1Var.c > this.a) {
            return false;
        }
        synchronized (this) {
            put = this.f.put(k, nc1Var);
            if (put != null) {
                int i2 = put.d;
                m(put);
                nc1Var.d = i2 + 1;
            }
        }
        if (put != null) {
            g(true, put, true);
        }
        boolean trimTo = trimTo(this.a - nc1Var.c);
        synchronized (this) {
            if (this.g != null && this.h != null && trimTo) {
                c(nc1Var);
                e(nc1Var);
            }
            d(nc1Var);
            e(nc1Var);
            if (this.h == null && this.d > this.b) {
                n(this.g.e);
            }
        }
        k(trimTo);
        return true;
    }
}
