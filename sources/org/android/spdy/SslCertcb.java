package org.android.spdy;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface SslCertcb {
    void getPerformance(SpdySession spdySession, SslPermData sslPermData);

    SslPublickey getPublicKey(SpdySession spdySession);

    int putCertificate(SpdySession spdySession, byte[] bArr, int i);
}
