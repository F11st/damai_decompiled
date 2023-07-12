package com.amap.api.mapcore.util;

import android.content.Context;
import android.taobao.windvane.connect.api.ApiResponse;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.uc.webview.export.media.CommandID;
import java.util.HashMap;
import java.util.Locale;
import tb.y90;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ju {
    private static ju b;
    id a;
    private Context c;
    private int d = jy.g;
    private boolean e = false;
    private int f = 0;

    private ju(Context context) {
        this.a = null;
        this.c = null;
        try {
            gi.a().a(context);
        } catch (Throwable unused) {
        }
        this.c = context;
        this.a = id.a();
    }

    public static ju a(Context context) {
        if (b == null) {
            b = new ju(context);
        }
        return b;
    }

    public final ik a(jv jvVar) throws Throwable {
        return this.a.a(jvVar, this.e || kc.e(this.c));
    }

    public final jv a(Context context, byte[] bArr, String str, String str2) {
        String str3;
        try {
            HashMap hashMap = new HashMap(16);
            jv jvVar = new jv(context, jy.c());
            try {
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Accept-Encoding", "gzip");
                hashMap.put("gzipped", "1");
                hashMap.put(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
                hashMap.put(IRequestConst.USER_AGENT, "AMAP_Location_SDK_Android 4.9.0");
                hashMap.put(ApiResponse.KEY, C4554gc.f(context));
                hashMap.put("enginever", y90.VER_CODE_OLD);
                String a = gf.a();
                String a2 = gf.a(context, a, "key=" + C4554gc.f(context));
                hashMap.put("ts", a);
                hashMap.put("scode", a2);
                hashMap.put("encr", "1");
                jvVar.b(hashMap);
                jvVar.l();
                jvVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "4.9.0", "loc", 3));
                jvVar.a();
                jvVar.b(str);
                jvVar.c(str2);
                jvVar.b(kc.a(bArr));
                jvVar.setProxy(gl.a(context));
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("output", "bin");
                hashMap2.put("policy", "3103");
                int i = this.f;
                if (i != 0) {
                    if (i != 1) {
                        str3 = i == 2 ? "language:en" : "language:cn";
                    }
                    hashMap2.put("custom", str3);
                    jvVar.a(hashMap2);
                    jvVar.setConnectionTimeout(this.d);
                    jvVar.setSoTimeout(this.d);
                    if ((!this.e || kc.e(context)) && str.startsWith("http:")) {
                        jvVar.b(jvVar.getURL().replace("https:", "https:"));
                        return jvVar;
                    }
                    return jvVar;
                }
                hashMap2.remove("custom");
                jvVar.a(hashMap2);
                jvVar.setConnectionTimeout(this.d);
                jvVar.setSoTimeout(this.d);
                if (this.e) {
                }
                jvVar.b(jvVar.getURL().replace("https:", "https:"));
                return jvVar;
            } catch (Throwable unused) {
                return jvVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final void a(long j, boolean z) {
        try {
            this.e = z;
            try {
                gi.a().a(z);
            } catch (Throwable unused) {
            }
            this.d = Long.valueOf(j).intValue();
            this.f = 0;
        } catch (Throwable th) {
            jy.a(th, "LocNetManager", CommandID.setOption);
        }
    }
}
