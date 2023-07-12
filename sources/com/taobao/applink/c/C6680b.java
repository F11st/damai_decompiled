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
/* renamed from: com.taobao.applink.c.b */
/* loaded from: classes12.dex */
public class C6680b {
    private static volatile C6680b c;
    private CharSequence a;
    private String b;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.applink.c.b$a */
    /* loaded from: classes12.dex */
    public interface InterfaceC6681a {
        void a(d33 d33Var);
    }

    private C6680b() {
        this.a = "unkown";
        new HashMap();
        this.a = a63.b(uj2.a());
        sj2 sj2Var = TBAppLinkSDK.a().a;
        throw null;
    }

    public static synchronized C6680b a() {
        C6680b c6680b;
        synchronized (C6680b.class) {
            if (c == null) {
                c = new C6680b();
            }
            c6680b = c;
        }
        return c6680b;
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
                new AsyncTaskC6679a(this, str, str2, str3).execute(new Void[0]);
            } catch (Exception e) {
                Log.d("flush exception", e.getStackTrace().toString());
            }
        }
    }
}
