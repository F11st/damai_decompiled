package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* renamed from: okhttp3.s */
/* loaded from: classes2.dex */
public final class C8831s {
    final C8735a a;
    final Proxy b;
    final InetSocketAddress c;

    public C8831s(C8735a c8735a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(c8735a, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.a = c8735a;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public C8735a a() {
        return this.a;
    }

    public Proxy b() {
        return this.b;
    }

    public boolean c() {
        return this.a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C8831s) {
            C8831s c8831s = (C8831s) obj;
            if (c8831s.a.equals(this.a) && c8831s.b.equals(this.b) && c8831s.c.equals(this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Route{" + this.c + "}";
    }
}
