package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C8818m;
import okhttp3.internal.C8753a;

/* compiled from: Taobao */
/* renamed from: okhttp3.a */
/* loaded from: classes2.dex */
public final class C8735a {
    final C8818m a;
    final Dns b;
    final SocketFactory c;
    final Authenticator d;
    final List<Protocol> e;
    final List<C8749g> f;
    final ProxySelector g;
    @Nullable
    final Proxy h;
    @Nullable
    final SSLSocketFactory i;
    @Nullable
    final HostnameVerifier j;
    @Nullable
    final C8744d k;

    public C8735a(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable C8744d c8744d, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<C8749g> list2, ProxySelector proxySelector) {
        this.a = new C8818m.C8819a().q(sSLSocketFactory != null ? "https" : "http").e(str).l(i).a();
        Objects.requireNonNull(dns, "dns == null");
        this.b = dns;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.c = socketFactory;
        Objects.requireNonNull(authenticator, "proxyAuthenticator == null");
        this.d = authenticator;
        Objects.requireNonNull(list, "protocols == null");
        this.e = C8753a.t(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f = C8753a.t(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = c8744d;
    }

    @Nullable
    public C8744d a() {
        return this.k;
    }

    public List<C8749g> b() {
        return this.f;
    }

    public Dns c() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(C8735a c8735a) {
        return this.b.equals(c8735a.b) && this.d.equals(c8735a.d) && this.e.equals(c8735a.e) && this.f.equals(c8735a.f) && this.g.equals(c8735a.g) && Objects.equals(this.h, c8735a.h) && Objects.equals(this.i, c8735a.i) && Objects.equals(this.j, c8735a.j) && Objects.equals(this.k, c8735a.k) && l().x() == c8735a.l().x();
    }

    @Nullable
    public HostnameVerifier e() {
        return this.j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C8735a) {
            C8735a c8735a = (C8735a) obj;
            if (this.a.equals(c8735a.a) && d(c8735a)) {
                return true;
            }
        }
        return false;
    }

    public List<Protocol> f() {
        return this.e;
    }

    @Nullable
    public Proxy g() {
        return this.h;
    }

    public Authenticator h() {
        return this.d;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Objects.hashCode(this.h)) * 31) + Objects.hashCode(this.i)) * 31) + Objects.hashCode(this.j)) * 31) + Objects.hashCode(this.k);
    }

    public ProxySelector i() {
        return this.g;
    }

    public SocketFactory j() {
        return this.c;
    }

    @Nullable
    public SSLSocketFactory k() {
        return this.i;
    }

    public C8818m l() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.a.m());
        sb.append(":");
        sb.append(this.a.x());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append("}");
        return sb.toString();
    }
}
