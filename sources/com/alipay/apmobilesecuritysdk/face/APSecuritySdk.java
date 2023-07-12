package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class APSecuritySdk {
    public static APSecuritySdk a;
    public static Object c = new Object();
    public Context b;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    public APSecuritySdk(Context context) {
        this.b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (a == null) {
            synchronized (c) {
                if (a == null) {
                    a = new APSecuritySdk(context);
                }
            }
        }
        return a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public String getApdidToken() {
        String a2 = a.a(this.b, "");
        if (com.alipay.sdk.m.z.a.a(a2)) {
            initToken(0, new HashMap(), null);
        }
        return a2;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.202206130311";
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.b, "");
            tokenResult.clientKey = h.f(this.b);
            tokenResult.apdid = a.a(this.b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.b);
            if (com.alipay.sdk.m.z.a.a(tokenResult.apdid) || com.alipay.sdk.m.z.a.a(tokenResult.apdidToken) || com.alipay.sdk.m.z.a.a(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i);
        String b = h.b(this.b);
        String c2 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.sdk.m.z.a.b(b) && !com.alipay.sdk.m.z.a.a(b, c2)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.b);
            d.a(this.b);
            g.a(this.b);
            i.h();
        }
        if (!com.alipay.sdk.m.z.a.a(b, c2)) {
            h.c(this.b, c2);
        }
        String a2 = com.alipay.sdk.m.z.a.a(map, "utdid", "");
        String a3 = com.alipay.sdk.m.z.a.a(map, "tid", "");
        String a4 = com.alipay.sdk.m.z.a.a(map, "userId", "");
        if (com.alipay.sdk.m.z.a.a(a2)) {
            a2 = UtdidWrapper.getUtdid(this.b);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("utdid", a2);
        hashMap.put("tid", a3);
        hashMap.put("userId", a4);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "8");
        b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
