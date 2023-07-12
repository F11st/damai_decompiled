package com.tencent.open.a;

import android.os.Build;
import android.text.TextUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.AbstractC8825p;
import okhttp3.C8749g;
import okhttp3.C8813j;
import okhttp3.C8820n;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import tb.fx2;
import tb.xd1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.tencent.open.a.e */
/* loaded from: classes11.dex */
public class C7072e implements InterfaceC7068a {
    private OkHttpClient a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.tencent.open.a.e$a */
    /* loaded from: classes11.dex */
    public static class C7073a implements Interceptor {
        private final String a;

        public C7073a(String str) {
            this.a = str;
        }

        @Override // okhttp3.Interceptor
        public C8827q intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().h().d(IRequestConst.USER_AGENT, this.a).b());
        }
    }

    public C7072e(String str) throws NoClassDefFoundError {
        a(str);
    }

    private void a(String str) {
        String a = fx2.a();
        if (a != null && a.startsWith("okhttp/3")) {
            C7073a c7073a = new C7073a(str);
            OkHttpClient.C8734b e = new OkHttpClient.C8734b().e(Arrays.asList(C8749g.MODERN_TLS, C8749g.COMPATIBLE_TLS));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.C8734b a2 = e.d(15000L, timeUnit).k(30000L, timeUnit).n(30000L, timeUnit).c(null).a(c7073a);
            a(a2);
            this.a = a2.b();
            return;
        }
        throw new NoClassDefFoundError();
    }

    @Override // com.tencent.open.a.InterfaceC7068a
    public void a(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return;
        }
        if (this.a.connectTimeoutMillis() == j && this.a.readTimeoutMillis() == j2) {
            return;
        }
        SLog.i("OkHttpServiceImpl", "setTimeout changed.");
        OkHttpClient.C8734b newBuilder = this.a.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.a = newBuilder.d(j, timeUnit).k(j2, timeUnit).n(j2, timeUnit).b();
    }

    @Override // com.tencent.open.a.InterfaceC7068a
    public InterfaceC7075g a(String str, String str2) throws IOException {
        SLog.i("OkHttpServiceImpl", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return new C7071d(this.a.newCall(new C8823o.C8824a().k(str).c().b()).execute(), str2.length());
    }

    @Override // com.tencent.open.a.InterfaceC7068a
    public InterfaceC7075g a(String str, Map<String, String> map) throws IOException {
        SLog.i("OkHttpServiceImpl", "post data");
        C8813j.C8814a c8814a = new C8813j.C8814a();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    c8814a.a(str2, str3);
                }
            }
        }
        C8813j b = c8814a.b();
        return new C7071d(this.a.newCall(new C8823o.C8824a().k(str).g(b).b()).execute(), (int) b.a());
    }

    @Override // com.tencent.open.a.InterfaceC7068a
    public InterfaceC7075g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.i("OkHttpServiceImpl", "post data, has byte data");
            C8820n.C8821a c8821a = new C8820n.C8821a();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        c8821a.a(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    c8821a.b(str4, str4, AbstractC8825p.d(xd1.c("content/unknown"), bArr));
                    SLog.w("OkHttpServiceImpl", "post byte data.");
                }
            }
            C8820n d = c8821a.d();
            return new C7071d(this.a.newCall(new C8823o.C8824a().k(str).g(d).b()).execute(), (int) d.a());
        }
        return a(str, map);
    }

    private void a(OkHttpClient.C8734b c8734b) {
        int i = Build.VERSION.SDK_INT;
        if (i < 16 || i >= 21) {
            return;
        }
        try {
            C7076h c7076h = new C7076h();
            TrustManager a = c7076h.a();
            if (a == null) {
                return;
            }
            c8734b.m(c7076h, (X509TrustManager) a);
            SLog.i("OkHttpServiceImpl", "enableTls2: enabled.");
        } catch (KeyManagementException e) {
            SLog.e("OkHttpServiceImpl", "enableTls2: failed.", e);
        } catch (KeyStoreException e2) {
            SLog.e("OkHttpServiceImpl", "enableTls2: failed.", e2);
        } catch (NoSuchAlgorithmException e3) {
            SLog.e("OkHttpServiceImpl", "enableTls2: failed.", e3);
        }
    }
}
