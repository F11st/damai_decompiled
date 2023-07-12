package okhttp3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class g {
    public static final g CLEARTEXT;
    public static final g COMPATIBLE_TLS;
    public static final g MODERN_TLS;
    public static final g RESTRICTED_TLS;
    private static final e[] e;
    private static final e[] f;
    final boolean a;
    final boolean b;
    @Nullable
    final String[] c;
    @Nullable
    final String[] d;

    static {
        e eVar = e.TLS_AES_128_GCM_SHA256;
        e eVar2 = e.TLS_AES_256_GCM_SHA384;
        e eVar3 = e.TLS_CHACHA20_POLY1305_SHA256;
        e eVar4 = e.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        e eVar5 = e.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        e eVar6 = e.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        e eVar7 = e.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        e eVar8 = e.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        e eVar9 = e.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        e[] eVarArr = {eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9};
        e = eVarArr;
        e[] eVarArr2 = {eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, e.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, e.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, e.TLS_RSA_WITH_AES_128_GCM_SHA256, e.TLS_RSA_WITH_AES_256_GCM_SHA384, e.TLS_RSA_WITH_AES_128_CBC_SHA, e.TLS_RSA_WITH_AES_256_CBC_SHA, e.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f = eVarArr2;
        a c = new a(true).c(eVarArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = c.f(tlsVersion, tlsVersion2).d(true).a();
        MODERN_TLS = new a(true).c(eVarArr2).f(tlsVersion, tlsVersion2).d(true).a();
        COMPATIBLE_TLS = new a(true).c(eVarArr2).f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).d(true).a();
        CLEARTEXT = new a(false).a();
    }

    g(a aVar) {
        this.a = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.b = aVar.d;
    }

    private g e(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.c != null) {
            enabledCipherSuites = okhttp3.internal.a.z(e.b, sSLSocket.getEnabledCipherSuites(), this.c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.d != null) {
            enabledProtocols = okhttp3.internal.a.z(okhttp3.internal.a.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int w = okhttp3.internal.a.w(e.b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && w != -1) {
            enabledCipherSuites = okhttp3.internal.a.i(enabledCipherSuites, supportedCipherSuites[w]);
        }
        return new a(this).b(enabledCipherSuites).e(enabledProtocols).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        g e2 = e(sSLSocket, z);
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
    public List<e> b() {
        String[] strArr = this.c;
        if (strArr != null) {
            return e.c(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.a) {
            String[] strArr = this.d;
            if (strArr == null || okhttp3.internal.a.C(okhttp3.internal.a.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.c;
                return strArr2 == null || okhttp3.internal.a.C(e.b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }

    public boolean d() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof g) {
            if (obj == this) {
                return true;
            }
            g gVar = (g) obj;
            boolean z = this.a;
            if (z != gVar.a) {
                return false;
            }
            return !z || (Arrays.equals(this.c, gVar.c) && Arrays.equals(this.d, gVar.d) && this.b == gVar.b);
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
    /* loaded from: classes2.dex */
    public static final class a {
        boolean a;
        @Nullable
        String[] b;
        @Nullable
        String[] c;
        boolean d;

        a(boolean z) {
            this.a = z;
        }

        public g a() {
            return new g(this);
        }

        public a b(String... strArr) {
            if (this.a) {
                if (strArr.length != 0) {
                    this.b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a c(e... eVarArr) {
            if (this.a) {
                String[] strArr = new String[eVarArr.length];
                for (int i = 0; i < eVarArr.length; i++) {
                    strArr[i] = eVarArr[i].a;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a d(boolean z) {
            if (this.a) {
                this.d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a e(String... strArr) {
            if (this.a) {
                if (strArr.length != 0) {
                    this.c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a f(TlsVersion... tlsVersionArr) {
            if (this.a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return e(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(g gVar) {
            this.a = gVar.a;
            this.b = gVar.c;
            this.c = gVar.d;
            this.d = gVar.b;
        }
    }
}
