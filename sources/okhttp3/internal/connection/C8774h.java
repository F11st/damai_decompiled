package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.C8735a;
import okhttp3.C8818m;
import okhttp3.C8831s;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.C8753a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.h */
/* loaded from: classes2.dex */
public final class C8774h {
    private final C8735a a;
    private final C8773g b;
    private final Call c;
    private final EventListener d;
    private int f;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<C8831s> h = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.h$a */
    /* loaded from: classes2.dex */
    public static final class C8775a {
        private final List<C8831s> a;
        private int b = 0;

        C8775a(List<C8831s> list) {
            this.a = list;
        }

        public List<C8831s> a() {
            return new ArrayList(this.a);
        }

        public boolean b() {
            return this.b < this.a.size();
        }

        public C8831s c() {
            if (b()) {
                List<C8831s> list = this.a;
                int i = this.b;
                this.b = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8774h(C8735a c8735a, C8773g c8773g, Call call, EventListener eventListener) {
        this.a = c8735a;
        this.b = c8773g;
        this.c = call;
        this.d = eventListener;
        g(c8735a.l(), c8735a.g());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy e() throws IOException {
        if (c()) {
            List<Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.l().m() + "; exhausted proxy configurations: " + this.e);
    }

    private void f(Proxy proxy) throws IOException {
        String m;
        int x;
        this.g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                m = a(inetSocketAddress);
                x = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            m = this.a.l().m();
            x = this.a.l().x();
        }
        if (x >= 1 && x <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.g.add(InetSocketAddress.createUnresolved(m, x));
                return;
            }
            this.d.k(this.c, m);
            List<InetAddress> lookup = this.a.c().lookup(m);
            if (!lookup.isEmpty()) {
                this.d.j(this.c, m, lookup);
                int size = lookup.size();
                for (int i = 0; i < size; i++) {
                    this.g.add(new InetSocketAddress(lookup.get(i), x));
                }
                return;
            }
            throw new UnknownHostException(this.a.c() + " returned no addresses for " + m);
        }
        throw new SocketException("No route to " + m + ":" + x + "; port is out of range");
    }

    private void g(C8818m c8818m, Proxy proxy) {
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.a.i().select(c8818m.D());
            this.e = (select == null || select.isEmpty()) ? C8753a.u(Proxy.NO_PROXY) : C8753a.t(select);
        }
        this.f = 0;
    }

    public boolean b() {
        return c() || !this.h.isEmpty();
    }

    public C8775a d() throws IOException {
        if (b()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy e = e();
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    C8831s c8831s = new C8831s(this.a, e, this.g.get(i));
                    if (this.b.c(c8831s)) {
                        this.h.add(c8831s);
                    } else {
                        arrayList.add(c8831s);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.h);
                this.h.clear();
            }
            return new C8775a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
