package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final Map<String, List<ByteString>> hostnameToPins;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class Builder {
        private final Map<String, List<ByteString>> hostnameToPins = new LinkedHashMap();

        public Builder add(String str, String... strArr) {
            if (str != null) {
                ArrayList arrayList = new ArrayList();
                List<ByteString> put = this.hostnameToPins.put(str, Collections.unmodifiableList(arrayList));
                if (put != null) {
                    arrayList.addAll(put);
                }
                for (String str2 : strArr) {
                    if (str2.startsWith("sha1/")) {
                        ByteString decodeBase64 = ByteString.decodeBase64(str2.substring(5));
                        if (decodeBase64 != null) {
                            arrayList.add(decodeBase64);
                        } else {
                            throw new IllegalArgumentException("pins must be base64: " + str2);
                        }
                    } else {
                        throw new IllegalArgumentException("pins must start with 'sha1/': " + str2);
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("hostname == null");
        }

        public CertificatePinner build() {
            return new CertificatePinner(this);
        }
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + sha1((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static ByteString sha1(X509Certificate x509Certificate) {
        return Util.sha1(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<ByteString> list2 = this.hostnameToPins.get(str);
        if (list2 == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list2.contains(sha1((X509Certificate) list.get(i)))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            sb.append("\n    ");
            sb.append(pin(x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            sb.append("\n    sha1/");
            sb.append(list2.get(i3).base64());
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    private CertificatePinner(Builder builder) {
        this.hostnameToPins = Util.immutableMap(builder.hostnameToPins);
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }
}
