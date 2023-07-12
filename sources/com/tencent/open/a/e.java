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
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.j;
import okhttp3.n;
import okhttp3.o;
import okhttp3.p;
import okhttp3.q;
import tb.fx2;
import tb.xd1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e implements com.tencent.open.a.a {
    private OkHttpClient a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements Interceptor {
        private final String a;

        public a(String str) {
            this.a = str;
        }

        @Override // okhttp3.Interceptor
        public q intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().h().d(IRequestConst.USER_AGENT, this.a).b());
        }
    }

    public e(String str) throws NoClassDefFoundError {
        a(str);
    }

    private void a(String str) {
        String a2 = fx2.a();
        if (a2 != null && a2.startsWith("okhttp/3")) {
            a aVar = new a(str);
            OkHttpClient.b e = new OkHttpClient.b().e(Arrays.asList(okhttp3.g.MODERN_TLS, okhttp3.g.COMPATIBLE_TLS));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.b a3 = e.d(15000L, timeUnit).k(30000L, timeUnit).n(30000L, timeUnit).c(null).a(aVar);
            a(a3);
            this.a = a3.b();
            return;
        }
        throw new NoClassDefFoundError();
    }

    @Override // com.tencent.open.a.a
    public void a(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return;
        }
        if (this.a.connectTimeoutMillis() == j && this.a.readTimeoutMillis() == j2) {
            return;
        }
        SLog.i("OkHttpServiceImpl", "setTimeout changed.");
        OkHttpClient.b newBuilder = this.a.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.a = newBuilder.d(j, timeUnit).k(j2, timeUnit).n(j2, timeUnit).b();
    }

    @Override // com.tencent.open.a.a
    public g a(String str, String str2) throws IOException {
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
        return new d(this.a.newCall(new o.a().k(str).c().b()).execute(), str2.length());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map) throws IOException {
        SLog.i("OkHttpServiceImpl", "post data");
        j.a aVar = new j.a();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    aVar.a(str2, str3);
                }
            }
        }
        j b = aVar.b();
        return new d(this.a.newCall(new o.a().k(str).g(b).b()).execute(), (int) b.a());
    }

    @Override // com.tencent.open.a.a
    public g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.i("OkHttpServiceImpl", "post data, has byte data");
            n.a aVar = new n.a();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        aVar.a(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    aVar.b(str4, str4, p.d(xd1.c("content/unknown"), bArr));
                    SLog.w("OkHttpServiceImpl", "post byte data.");
                }
            }
            n d = aVar.d();
            return new d(this.a.newCall(new o.a().k(str).g(d).b()).execute(), (int) d.a());
        }
        return a(str, map);
    }

    private void a(OkHttpClient.b bVar) {
        int i = Build.VERSION.SDK_INT;
        if (i < 16 || i >= 21) {
            return;
        }
        try {
            h hVar = new h();
            TrustManager a2 = hVar.a();
            if (a2 == null) {
                return;
            }
            bVar.m(hVar, (X509TrustManager) a2);
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
