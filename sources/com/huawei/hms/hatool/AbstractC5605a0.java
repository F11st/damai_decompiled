package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.a0 */
/* loaded from: classes10.dex */
public abstract class AbstractC5605a0 {

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.hatool.a0$a */
    /* loaded from: classes10.dex */
    public static class C5606a extends Exception {
        public C5606a(String str) {
            super(str);
        }
    }

    public static C5608b0 a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, map, "POST");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25, types: [java.io.OutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.Closeable] */
    public static C5608b0 a(String str, byte[] bArr, Map<String, String> map, String str2) {
        BufferedOutputStream bufferedOutputStream;
        int responseCode;
        if (TextUtils.isEmpty(str)) {
            return new C5608b0(-100, "");
        }
        int i = -102;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                str = a((String) str, bArr.length, (Map<String, String>) map, str2);
                try {
                    if (str == 0) {
                        C5608b0 c5608b0 = new C5608b0(-101, "");
                        t0.a((Closeable) null);
                        t0.a((Closeable) null);
                        if (str != 0) {
                            t0.a((HttpURLConnection) str);
                        }
                        return c5608b0;
                    }
                    map = str.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(map);
                    } catch (C5606a unused) {
                    } catch (ConnectException unused2) {
                    } catch (UnknownHostException unused3) {
                    } catch (SSLHandshakeException unused4) {
                    } catch (SSLPeerUnverifiedException unused5) {
                    } catch (IOException unused6) {
                    } catch (SecurityException unused7) {
                    }
                    try {
                        try {
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            responseCode = str.getResponseCode();
                        } catch (UnknownHostException unused8) {
                        } catch (SSLHandshakeException unused9) {
                        } catch (IOException unused10) {
                        } catch (SecurityException unused11) {
                        } catch (ConnectException unused12) {
                        } catch (SSLPeerUnverifiedException unused13) {
                        }
                        try {
                            C5608b0 c5608b02 = new C5608b0(responseCode, b(str));
                            t0.a((Closeable) bufferedOutputStream);
                            t0.a((Closeable) map);
                            t0.a((HttpURLConnection) str);
                            return c5608b02;
                        } catch (SecurityException unused14) {
                            i = responseCode;
                            bufferedOutputStream2 = bufferedOutputStream;
                            C5653y.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                            C5608b0 c5608b03 = new C5608b0(i, "");
                            t0.a((Closeable) bufferedOutputStream2);
                            t0.a((Closeable) map);
                            if (str != 0) {
                                t0.a((HttpURLConnection) str);
                            }
                            return c5608b03;
                        } catch (ConnectException unused15) {
                            i = responseCode;
                            bufferedOutputStream2 = bufferedOutputStream;
                            C5653y.f("hmsSdk", "Network is unreachable or Connection refused");
                            C5608b0 c5608b04 = new C5608b0(i, "");
                            t0.a((Closeable) bufferedOutputStream2);
                            t0.a((Closeable) map);
                            if (str != 0) {
                                t0.a((HttpURLConnection) str);
                            }
                            return c5608b04;
                        } catch (UnknownHostException unused16) {
                            i = responseCode;
                            bufferedOutputStream2 = bufferedOutputStream;
                            C5653y.f("hmsSdk", "No address associated with hostname or No network");
                            C5608b0 c5608b05 = new C5608b0(i, "");
                            t0.a((Closeable) bufferedOutputStream2);
                            t0.a((Closeable) map);
                            if (str != 0) {
                                t0.a((HttpURLConnection) str);
                            }
                            return c5608b05;
                        } catch (SSLHandshakeException unused17) {
                            i = responseCode;
                            bufferedOutputStream2 = bufferedOutputStream;
                            C5653y.f("hmsSdk", "Chain validation failed,Certificate expired");
                            C5608b0 c5608b06 = new C5608b0(i, "");
                            t0.a((Closeable) bufferedOutputStream2);
                            t0.a((Closeable) map);
                            if (str != 0) {
                                t0.a((HttpURLConnection) str);
                            }
                            return c5608b06;
                        } catch (SSLPeerUnverifiedException unused18) {
                            i = responseCode;
                            bufferedOutputStream2 = bufferedOutputStream;
                            C5653y.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                            C5608b0 c5608b07 = new C5608b0(i, "");
                            t0.a((Closeable) bufferedOutputStream2);
                            t0.a((Closeable) map);
                            if (str != 0) {
                                t0.a((HttpURLConnection) str);
                            }
                            return c5608b07;
                        } catch (IOException unused19) {
                            i = responseCode;
                            bufferedOutputStream2 = bufferedOutputStream;
                            C5653y.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                            C5608b0 c5608b08 = new C5608b0(i, "");
                            t0.a((Closeable) bufferedOutputStream2);
                            t0.a((Closeable) map);
                            if (str != 0) {
                                t0.a((HttpURLConnection) str);
                            }
                            return c5608b08;
                        }
                    } catch (C5606a unused20) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        C5653y.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                        C5608b0 c5608b09 = new C5608b0(-101, "");
                        t0.a((Closeable) bufferedOutputStream2);
                        t0.a((Closeable) map);
                        if (str != 0) {
                            t0.a((HttpURLConnection) str);
                        }
                        return c5608b09;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream;
                        t0.a((Closeable) bufferedOutputStream2);
                        t0.a((Closeable) map);
                        if (str != 0) {
                            t0.a((HttpURLConnection) str);
                        }
                        throw th;
                    }
                } catch (C5606a unused21) {
                    map = 0;
                } catch (UnknownHostException unused22) {
                    map = 0;
                } catch (SSLPeerUnverifiedException unused23) {
                    map = 0;
                } catch (IOException unused24) {
                    map = 0;
                } catch (SecurityException unused25) {
                    map = 0;
                } catch (ConnectException unused26) {
                    map = 0;
                } catch (SSLHandshakeException unused27) {
                    map = 0;
                } catch (Throwable th2) {
                    th = th2;
                    map = 0;
                }
            } catch (C5606a unused28) {
                str = 0;
                map = 0;
            } catch (SecurityException unused29) {
                str = 0;
                map = 0;
            } catch (ConnectException unused30) {
                str = 0;
                map = 0;
            } catch (UnknownHostException unused31) {
                str = 0;
                map = 0;
            } catch (SSLHandshakeException unused32) {
                str = 0;
                map = 0;
            } catch (SSLPeerUnverifiedException unused33) {
                str = 0;
                map = 0;
            } catch (IOException unused34) {
                str = 0;
                map = 0;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                map = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static HttpURLConnection a(String str, int i, Map<String, String> map, String str2) {
        if (TextUtils.isEmpty(str)) {
            C5653y.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(i));
        httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.net.HttpURLConnection r3) {
        /*
            java.lang.String r0 = "hmsSdk"
            boolean r1 = r3 instanceof javax.net.ssl.HttpsURLConnection
            if (r1 == 0) goto L39
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3
            r1 = 0
            android.content.Context r2 = com.huawei.hms.hatool.AbstractC5607b.i()     // Catch: java.lang.IllegalAccessException -> L12 java.io.IOException -> L15 java.security.GeneralSecurityException -> L18 java.security.KeyStoreException -> L1b java.security.NoSuchAlgorithmException -> L1e
            com.huawei.secure.android.common.ssl.SecureSSLSocketFactory r1 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.getInstance(r2)     // Catch: java.lang.IllegalAccessException -> L12 java.io.IOException -> L15 java.security.GeneralSecurityException -> L18 java.security.KeyStoreException -> L1b java.security.NoSuchAlgorithmException -> L1e
            goto L23
        L12:
            java.lang.String r2 = "getSocketFactory(): Illegal Access Exception "
            goto L20
        L15:
            java.lang.String r2 = "getSocketFactory(): IO Exception!"
            goto L20
        L18:
            java.lang.String r2 = "getSocketFactory(): General Security Exception"
            goto L20
        L1b:
            java.lang.String r2 = "getSocketFactory(): Key Store exception"
            goto L20
        L1e:
            java.lang.String r2 = "getSocketFactory(): Algorithm Exception!"
        L20:
            com.huawei.hms.hatool.C5653y.f(r0, r2)
        L23:
            if (r1 == 0) goto L31
            r3.setSSLSocketFactory(r1)
            com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier r0 = new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier
            r0.<init>()
            r3.setHostnameVerifier(r0)
            goto L39
        L31:
            com.huawei.hms.hatool.a0$a r3 = new com.huawei.hms.hatool.a0$a
            java.lang.String r0 = "No ssl socket factory set"
            r3.<init>(r0)
            throw r3
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.AbstractC5605a0.a(java.net.HttpURLConnection):void");
    }

    public static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                return t0.a(inputStream);
            } catch (IOException unused) {
                int responseCode = httpURLConnection.getResponseCode();
                C5653y.f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + responseCode);
                t0.a((Closeable) inputStream);
                return "";
            }
        } finally {
            t0.a((Closeable) inputStream);
        }
    }
}
