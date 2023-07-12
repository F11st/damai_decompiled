package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class d {
    public static final d DEFAULT = new a().a();
    private final Set<b> a;
    @Nullable
    private final okhttp3.internal.tls.b b;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class a {
        private final List<b> a = new ArrayList();

        public d a() {
            return new d(new LinkedHashSet(this.a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class b {
        final String a;
        final String b;
        final String c;
        final ByteString d;

        boolean a(String str) {
            if (this.a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.b.length()) {
                    String str2 = this.b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.a.equals(bVar.a) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.a.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return this.c + this.d.base64();
        }
    }

    d(Set<b> set, @Nullable okhttp3.internal.tls.b bVar) {
        this.a = set;
        this.b = bVar;
    }

    public static String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + e((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString d(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    static ByteString e(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> b2 = b(str);
        if (b2.isEmpty()) {
            return;
        }
        okhttp3.internal.tls.b bVar = this.b;
        if (bVar != null) {
            list = bVar.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = b2.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar2 = b2.get(i2);
                if (bVar2.c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = e(x509Certificate);
                    }
                    if (bVar2.d.equals(byteString)) {
                        return;
                    }
                } else if (bVar2.c.equals("sha1/")) {
                    if (byteString2 == null) {
                        byteString2 = d(x509Certificate);
                    }
                    if (bVar2.d.equals(byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar2.c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = b2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ");
            sb.append(b2.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<b> b(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (Objects.equals(this.b, dVar.b) && this.a.equals(dVar.a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d f(@Nullable okhttp3.internal.tls.b bVar) {
        return Objects.equals(this.b, bVar) ? this : new d(this.a, bVar);
    }

    public int hashCode() {
        return (Objects.hashCode(this.b) * 31) + this.a.hashCode();
    }
}
