package tb;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class s01 {

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a {
        public byte[] a = null;
    }

    static {
        System.setProperty("http.keepAlive", "true");
    }

    public a a(String str) {
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection != null) {
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setDoInput(true);
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.setRequestProperty(IRequestConst.CONNECTION, "close");
                    httpURLConnection.setInstanceFollowRedirects(true);
                    System.currentTimeMillis();
                    try {
                        httpURLConnection.connect();
                        try {
                            httpURLConnection.getResponseCode();
                        } catch (IOException e) {
                            Logger.f("HttpsUtil", e);
                        }
                        System.currentTimeMillis();
                        DataInputStream dataInputStream = null;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            try {
                                DataInputStream dataInputStream2 = new DataInputStream(httpURLConnection.getInputStream());
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = dataInputStream2.read(bArr, 0, 2048);
                                        if (read != -1) {
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e2) {
                                                Logger.f("HttpsUtil", e2);
                                            }
                                        }
                                    }
                                    dataInputStream2.close();
                                    if (byteArrayOutputStream.size() > 0) {
                                        aVar.a = byteArrayOutputStream.toByteArray();
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    dataInputStream = dataInputStream2;
                                    Logger.h("HttpsUtil", e, new Object[0]);
                                    if (dataInputStream != null) {
                                        try {
                                            dataInputStream.close();
                                        } catch (Exception e4) {
                                            Logger.f("HttpsUtil", e4);
                                        }
                                    }
                                    return aVar;
                                } catch (Throwable th) {
                                    th = th;
                                    dataInputStream = dataInputStream2;
                                    if (dataInputStream != null) {
                                        try {
                                            dataInputStream.close();
                                        } catch (Exception e5) {
                                            Logger.f("HttpsUtil", e5);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (IOException e6) {
                            e = e6;
                        }
                    } catch (Exception e7) {
                        Logger.h("HttpsUtil", e7, new Object[0]);
                        System.currentTimeMillis();
                        return aVar;
                    }
                } catch (ProtocolException e8) {
                    Logger.h("HttpsUtil", e8, new Object[0]);
                }
            }
            return aVar;
        } catch (MalformedURLException e9) {
            Logger.h("HttpsUtil", e9, new Object[0]);
            return aVar;
        } catch (IOException e10) {
            Logger.h("HttpsUtil", e10, new Object[0]);
            return aVar;
        }
    }
}
