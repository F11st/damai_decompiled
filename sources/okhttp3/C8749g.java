package okhttp3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.C8753a;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: okhttp3.g */
/* loaded from: classes2.dex */
public final class C8749g {
    public static final C8749g CLEARTEXT;
    public static final C8749g COMPATIBLE_TLS;
    public static final C8749g MODERN_TLS;
    public static final C8749g RESTRICTED_TLS;
    private static final C8747e[] e;
    private static final C8747e[] f;
    final boolean a;
    final boolean b;
    @Nullable
    final String[] c;
    @Nullable
    final String[] d;

    static {
        C8747e c8747e = C8747e.TLS_AES_128_GCM_SHA256;
        C8747e c8747e2 = C8747e.TLS_AES_256_GCM_SHA384;
        C8747e c8747e3 = C8747e.TLS_CHACHA20_POLY1305_SHA256;
        C8747e c8747e4 = C8747e.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        C8747e c8747e5 = C8747e.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        C8747e c8747e6 = C8747e.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        C8747e c8747e7 = C8747e.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        C8747e c8747e8 = C8747e.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        C8747e c8747e9 = C8747e.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        C8747e[] c8747eArr = {c8747e, c8747e2, c8747e3, c8747e4, c8747e5, c8747e6, c8747e7, c8747e8, c8747e9};
        e = c8747eArr;
        C8747e[] c8747eArr2 = {c8747e, c8747e2, c8747e3, c8747e4, c8747e5, c8747e6, c8747e7, c8747e8, c8747e9, C8747e.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, C8747e.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, C8747e.TLS_RSA_WITH_AES_128_GCM_SHA256, C8747e.TLS_RSA_WITH_AES_256_GCM_SHA384, C8747e.TLS_RSA_WITH_AES_128_CBC_SHA, C8747e.TLS_RSA_WITH_AES_256_CBC_SHA, C8747e.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f = c8747eArr2;
        C8750a c = new C8750a(true).c(c8747eArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = c.f(tlsVersion, tlsVersion2).d(true).a();
        MODERN_TLS = new C8750a(true).c(c8747eArr2).f(tlsVersion, tlsVersion2).d(true).a();
        COMPATIBLE_TLS = new C8750a(true).c(c8747eArr2).f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).d(true).a();
        CLEARTEXT = new C8750a(false).a();
    }

    C8749g(C8750a c8750a) {
        this.a = c8750a.a;
        this.c = c8750a.b;
        this.d = c8750a.c;
        this.b = c8750a.d;
    }

    private C8749g e(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.c != null) {
            enabledCipherSuites = C8753a.z(C8747e.b, sSLSocket.getEnabledCipherSuites(), this.c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.d != null) {
            enabledProtocols = C8753a.z(C8753a.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int w = C8753a.w(C8747e.b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && w != -1) {
            enabledCipherSuites = C8753a.i(enabledCipherSuites, supportedCipherSuites[w]);
        }
        return new C8750a(this).b(enabledCipherSuites).e(enabledProtocols).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        C8749g e2 = e(sSLSocket, z);
        String[] strArr = e2.d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = e2.c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    public List<C8747e> b() {
        String[] strArr = this.c;
        if (strArr != null) {
            return C8747e.c(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.a) {
            String[] strArr = this.d;
            if (strArr == null || C8753a.C(C8753a.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.c;
                return strArr2 == null || C8753a.C(C8747e.b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public boolean d() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C8749g) {
            if (obj == this) {
                return true;
            }
            C8749g c8749g = (C8749g) obj;
            boolean z = this.a;
            if (z != c8749g.a) {
                return false;
            }
            return !z || (Arrays.equals(this.c, c8749g.c) && Arrays.equals(this.d, c8749g.d) && this.b == c8749g.b);
        }
        return false;
    }

    public boolean f() {
        return this.b;
    }

    @Nullable
    public List<TlsVersion> g() {
        String[] strArr = this.d;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.a) {
            return ((((527 + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.a) {
            return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(g(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + jn1.BRACKET_END_STR;
        }
        return "ConnectionSpec()";
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.g$a */
    /* loaded from: classes2.dex */
    public static final class C8750a {
        boolean a;
        @Nullable
        String[] b;
        @Nullable
        String[] c;
        boolean d;

        C8750a(boolean z) {
            this.a = z;
        }

        public C8749g a() {
            return new C8749g(this);
        }

        public C8750a b(String... strArr) {
            if (this.a) {
                if (strArr.length != 0) {
                    this.b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C8750a c(C8747e... c8747eArr) {
            if (this.a) {
                String[] strArr = new String[c8747eArr.length];
                for (int i = 0; i < c8747eArr.length; i++) {
                    strArr[i] = c8747eArr[i].a;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C8750a d(boolean z) {
            if (this.a) {
                this.d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C8750a e(String... strArr) {
            if (this.a) {
                if (strArr.length != 0) {
                    this.c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C8750a f(TlsVersion... tlsVersionArr) {
            if (this.a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return e(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C8750a(C8749g c8749g) {
            this.a = c8749g.a;
            this.b = c8749g.c;
            this.c = c8749g.d;
            this.d = c8749g.b;
        }
    }
}
