package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class de1<K, V> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public de1(int i) {
        if (i > 0) {
            this.c = i;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int f(K k, V v) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1951218295")) {
            return ((Integer) ipChange.ipc$dispatch("-1951218295", new Object[]{this, k, v})).intValue();
        }
        int g = g(k, v);
        if (g >= 0) {
            return g;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public synchronized void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-966064358")) {
            ipChange.ipc$dispatch("-966064358", new Object[]{this});
        } else {
            this.a.clear();
        }
    }

    protected V b(K k) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63576241")) {
            return (V) ipChange.ipc$dispatch("-63576241", new Object[]{this, k});
        }
        return null;
    }

    protected void c(boolean z, K k, V v, V v2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "389539571")) {
            ipChange.ipc$dispatch("389539571", new Object[]{this, Boolean.valueOf(z), k, v, v2});
        }
    }

    public final V d(K k) {
        V put;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1225788229")) {
            return (V) ipChange.ipc$dispatch("1225788229", new Object[]{this, k});
        }
        Objects.requireNonNull(k, "key == null");
        synchronized (this) {
            V v = this.a.get(k);
            if (v != null) {
                this.g++;
                return v;
            }
            this.h++;
            V b = b(k);
            if (b == null) {
                return null;
            }
            synchronized (this) {
                this.e++;
                put = this.a.put(k, b);
                if (put != null) {
                    this.a.put(k, put);
                } else {
                    this.b += f(k, b);
                }
            }
            if (put != null) {
                c(false, k, b, put);
                return put;
            }
            h(this.c);
            return b;
        }
    }

    public final V e(K k, V v) {
        V put;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716767518")) {
            return (V) ipChange.ipc$dispatch("-1716767518", new Object[]{this, k, v});
        }
        if (k != null && v != null) {
            synchronized (this) {
                this.d++;
                this.b += f(k, v);
                put = this.a.put(k, v);
                if (put != null) {
                    this.b -= f(k, put);
                }
            }
            if (put != null) {
                c(false, k, put, v);
            }
            h(this.c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    protected int g(K k, V v) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "117848854")) {
            return ((Integer) ipChange.ipc$dispatch("117848854", new Object[]{this, k, v})).intValue();
        }
        return 1;
    }

    public void h(int i) {
        K key;
        V value;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1313841506")) {
            ipChange.ipc$dispatch("-1313841506", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                    if (this.b < 0) {
                        this.b = 0;
                        this.a.clear();
                    } else if (this.a.isEmpty() && this.b != 0) {
                        this.b = 0;
                    }
                }
                if (this.b <= i || this.a.isEmpty()) {
                    break;
                }
                Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                key = next.getKey();
                value = next.getValue();
                this.a.remove(key);
                this.b -= f(key, value);
                this.f++;
            }
            c(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1813538231")) {
            return (String) ipChange.ipc$dispatch("-1813538231", new Object[]{this});
        }
        int i = this.g;
        int i2 = this.h + i;
        return String.format("MemLruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
