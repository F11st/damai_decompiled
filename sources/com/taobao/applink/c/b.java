package com.taobao.applink.c;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.applink.TBAppLinkSDK;
import java.util.HashMap;
import tb.a63;
import tb.c33;
import tb.d33;
import tb.sj2;
import tb.uj2;
import tb.y63;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    private static volatile b c;
    private CharSequence a;
    private String b;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface a {
        void a(d33 d33Var);
    }

    private b() {
        this.a = "unkown";
        new HashMap();
        this.a = a63.b(uj2.a());
        sj2 sj2Var = TBAppLinkSDK.a().a;
        throw null;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        System.currentTimeMillis();
        stringBuffer.append("logtype=2&wappkey=");
        stringBuffer.append(this.b);
        stringBuffer.append("&");
        stringBuffer.append("packagename=");
        stringBuffer.append(c33.a(uj2.a()));
        stringBuffer.append("&");
        stringBuffer.append("os=");
        stringBuffer.append("android");
        stringBuffer.append("&");
        stringBuffer.append("imei=");
        stringBuffer.append(this.a);
        stringBuffer.append("&t=");
        stringBuffer.append("&sdkversion=");
        stringBuffer.append(uj2.SDKVERSION);
        if (!TextUtils.isEmpty(str3)) {
            stringBuffer.append("&");
            stringBuffer.append(str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append("&type=");
            stringBuffer.append(str2);
        }
        sj2 sj2Var = TBAppLinkSDK.a().a;
        throw null;
    }

    public void c(String str, String str2, String str3) {
        if (y63.a(str)) {
            return;
        }
        synchronized (this) {
            try {
                new com.taobao.applink.c.a(this, str, str2, str3).execute(new Void[0]);
            } catch (Exception e) {
                Log.d("flush exception", e.getStackTrace().toString());
            }
        }
    }
}
