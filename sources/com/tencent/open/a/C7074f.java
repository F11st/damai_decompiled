package com.tencent.open.a;

import android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C7117f;
import com.tencent.open.utils.C7119g;
import com.tencent.open.utils.C7121i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.a.f */
/* loaded from: classes11.dex */
public class C7074f {
    private static C7074f a;
    private C7121i b;
    private InterfaceC7068a c;

    protected C7074f() {
        b();
    }

    public static C7074f a() {
        if (a == null) {
            synchronized (C7074f.class) {
                if (a == null) {
                    a = new C7074f();
                }
            }
        }
        a.c();
        return a;
    }

    private void b() {
        String str = "AndroidSDK_" + Build.VERSION.SDK + JSMethod.NOT_SET + C7117f.a().b(C7119g.a()) + JSMethod.NOT_SET + Build.VERSION.getRELEASE();
        try {
            this.c = new C7072e(str);
        } catch (NoClassDefFoundError e) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch error", e);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch throwable", th);
        }
        if (this.c == null) {
            this.c = new C7069b(str);
        }
    }

    private void c() {
        C7121i c7121i = this.b;
        if (c7121i == null) {
            return;
        }
        int a2 = c7121i.a("Common_HttpConnectionTimeout");
        if (a2 == 0) {
            a2 = 15000;
        }
        int a3 = this.b.a("Common_SocketConnectionTimeout");
        if (a3 == 0) {
            a3 = 30000;
        }
        a(a2, a3);
    }

    public void a(C7121i c7121i) {
        this.b = c7121i;
        c();
    }

    public InterfaceC7075g b(String str, Map<String, String> map) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        return this.c.a(str, map);
    }

    public void a(long j, long j2) {
        InterfaceC7068a interfaceC7068a = this.c;
        if (interfaceC7068a != null) {
            interfaceC7068a.a(j, j2);
        }
    }

    public InterfaceC7075g a(String str, Map<String, String> map) throws IOException {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder("");
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(str3, "UTF-8"));
                    sb.append("&");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return a(str, sb.toString());
        }
        return a(str, "");
    }

    public InterfaceC7075g a(String str, String str2) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        return this.c.a(str, str2);
    }

    public InterfaceC7075g a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            return this.c.a(str, map, map2);
        }
        return b(str, map);
    }
}
