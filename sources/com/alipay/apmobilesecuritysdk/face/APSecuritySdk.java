package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.C4095a;
import com.alipay.apmobilesecuritysdk.b.C4096a;
import com.alipay.apmobilesecuritysdk.e.C4105a;
import com.alipay.apmobilesecuritysdk.e.C4108d;
import com.alipay.apmobilesecuritysdk.e.C4111g;
import com.alipay.apmobilesecuritysdk.e.C4112h;
import com.alipay.apmobilesecuritysdk.e.C4113i;
import com.alipay.apmobilesecuritysdk.f.C4115b;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.m.z.C4368a;
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
        String a2 = C4095a.a(this.b, "");
        if (C4368a.a(a2)) {
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
            tokenResult.apdidToken = C4095a.a(this.b, "");
            tokenResult.clientKey = C4112h.f(this.b);
            tokenResult.apdid = C4095a.a(this.b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.b);
            if (C4368a.a(tokenResult.apdid) || C4368a.a(tokenResult.apdidToken) || C4368a.a(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i, Map<String, String> map, final InitResultListener initResultListener) {
        C4096a.a().a(i);
        String b = C4112h.b(this.b);
        String c2 = C4096a.a().c();
        if (C4368a.b(b) && !C4368a.a(b, c2)) {
            C4105a.a(this.b);
            C4108d.a(this.b);
            C4111g.a(this.b);
            C4113i.h();
        }
        if (!C4368a.a(b, c2)) {
            C4112h.c(this.b, c2);
        }
        String a2 = C4368a.a(map, "utdid", "");
        String a3 = C4368a.a(map, "tid", "");
        String a4 = C4368a.a(map, "userId", "");
        if (C4368a.a(a2)) {
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
        C4115b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new C4095a(APSecuritySdk.this.b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
