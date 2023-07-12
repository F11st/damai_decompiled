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
import okhttp3.internal.tls.AbstractC8805b;
import okio.ByteString;

/* compiled from: Taobao */
/* renamed from: okhttp3.d */
/* loaded from: classes2.dex */
public final class C8744d {
    public static final C8744d DEFAULT = new C8745a().a();
    private final Set<C8746b> a;
    @Nullable
    private final AbstractC8805b b;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.d$a */
    /* loaded from: classes2.dex */
    public static final class C8745a {
        private final List<C8746b> a = new ArrayList();

        public C8744d a() {
            return new C8744d(new LinkedHashSet(this.a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: okhttp3.d$b */
    /* loaded from: classes2.dex */
    public static final class C8746b {
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
            if (obj instanceof C8746b) {
                C8746b c8746b = (C8746b) obj;
                if (this.a.equals(c8746b.a) && this.c.equals(c8746b.c) && this.d.equals(c8746b.d)) {
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

    C8744d(Set<C8746b> set, @Nullable AbstractC8805b abstractC8805b) {
        this.a = set;
        this.b = abstractC8805b;
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
        List<C8746b> b = b(str);
        if (b.isEmpty()) {
            return;
        }
        AbstractC8805b abstractC8805b = this.b;
        if (abstractC8805b != null) {
            list = abstractC8805b.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = b.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                C8746b c8746b = b.get(i2);
                if (c8746b.c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = e(x509Certificate);
                    }
                    if (c8746b.d.equals(byteString)) {
                        return;
                    }
                } else if (c8746b.c.equals("sha1/")) {
                    if (byteString2 == null) {
                        byteString2 = d(x509Certificate);
                    }
                    if (c8746b.d.equals(byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + c8746b.c);
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
        int size4 = b.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ");
            sb.append(b.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<C8746b> b(String str) {
        List<C8746b> emptyList = Collections.emptyList();
        for (C8746b c8746b : this.a) {
            if (c8746b.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(c8746b);
            }
        }
        return emptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C8744d) {
            C8744d c8744d = (C8744d) obj;
            if (Objects.equals(this.b, c8744d.b) && this.a.equals(c8744d.a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8744d f(@Nullable AbstractC8805b abstractC8805b) {
        return Objects.equals(this.b, abstractC8805b) ? this : new C8744d(this.a, abstractC8805b);
    }

    public int hashCode() {
        return (Objects.hashCode(this.b) * 31) + this.a.hashCode();
    }
}
