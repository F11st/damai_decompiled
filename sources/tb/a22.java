package tb;

import com.taobao.rxm.produce.ProducerListener;
import com.taobao.rxm.request.MultiplexCancelListener;
import com.taobao.rxm.request.RequestCancelListener;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a22 {
    private static final AtomicInteger j = new AtomicInteger(1);
    private final int a;
    private int b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile int e;
    private MultiplexCancelListener f;
    private Set<RequestCancelListener> g;
    private ProducerListener h;
    private final boolean i;

    public a22(boolean z) {
        this.b = 2;
        AtomicInteger atomicInteger = j;
        synchronized (atomicInteger) {
            if (atomicInteger.get() < 0) {
                atomicInteger.set(1);
            }
            this.a = atomicInteger.getAndIncrement();
        }
        this.i = z;
    }

    private void a() {
        HashSet<RequestCancelListener> hashSet;
        int size;
        synchronized (this) {
            Set<RequestCancelListener> set = this.g;
            if (set == null || (size = set.size()) <= 0) {
                hashSet = null;
            } else {
                hashSet = new HashSet(size);
                hashSet.addAll(this.g);
            }
        }
        if (hashSet != null) {
            for (RequestCancelListener requestCancelListener : hashSet) {
                requestCancelListener.onCancel(this);
            }
            hashSet.clear();
        }
    }

    public void b() {
        this.d = true;
        MultiplexCancelListener multiplexCancelListener = this.f;
        if (multiplexCancelListener != null) {
            multiplexCancelListener.onCancelRequest(this);
        }
        if (k()) {
            return;
        }
        c(true);
    }

    public void c(boolean z) {
        this.c = z;
        if (z) {
            a();
        }
    }

    public int d() {
        return this.a;
    }

    public abstract String e();

    public int f() {
        return this.e;
    }

    public ProducerListener g() {
        return this.h;
    }

    public int h() {
        return this.b;
    }

    public boolean i() {
        return this.c;
    }

    public boolean j() {
        return this.d;
    }

    public boolean k() {
        return this.e == this.a;
    }

    public boolean l(RequestCancelListener requestCancelListener) {
        boolean add;
        if (this.i) {
            Class cls = (Class) ((ParameterizedType) requestCancelListener.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
            if (!cls.isInstance(this)) {
                throw new RuntimeException("this[" + getClass() + "] CANNOT be assigned to generic[" + cls + "] of RequestCancelListener");
            }
        }
        synchronized (this) {
            if (this.g == null) {
                this.g = new HashSet();
            }
            add = this.g.add(requestCancelListener);
        }
        return add;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void m() {
        this.e = 0;
        Set<RequestCancelListener> set = this.g;
        if (set != null) {
            set.clear();
        }
    }

    public void n(MultiplexCancelListener multiplexCancelListener) {
        this.f = multiplexCancelListener;
    }

    public void o(int i) {
        this.e = i;
    }

    public void p(ProducerListener producerListener) {
        this.h = producerListener;
    }

    public void q(int i) {
        this.b = i;
    }

    public abstract void r(a22 a22Var);

    public synchronized boolean s(RequestCancelListener requestCancelListener) {
        boolean z;
        Set<RequestCancelListener> set = this.g;
        if (set != null) {
            z = set.remove(requestCancelListener);
        }
        return z;
    }

    public a22() {
        this(true);
    }
}
