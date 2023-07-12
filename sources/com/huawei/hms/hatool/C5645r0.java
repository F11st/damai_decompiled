package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.r0 */
/* loaded from: classes10.dex */
public class C5645r0 {
    public static void a(String str, String str2) {
        C5608b0 c5608b0;
        String str3;
        String replace = "{url}/getPublicKey?keytype=2".replace("{url}", AbstractC5609c.f(str, str2));
        String f = AbstractC5607b.f();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", f);
        try {
            c5608b0 = AbstractC5605a0.a(replace, new byte[0], hashMap);
        } catch (Exception e) {
            C5653y.e("GetPublicKey", "get pubKey response Exception :" + e.getMessage());
            c5608b0 = null;
        }
        if (c5608b0 == null) {
            str3 = "get pubKey response is null";
        } else if (c5608b0.b() == 200) {
            if (TextUtils.isEmpty(c5608b0.a())) {
                return;
            }
            c(c5608b0.a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + c5608b0.b();
        }
        C5653y.e("GetPublicKey", str3);
    }

    public static boolean a() {
        String a = AbstractC5607b.a();
        if (TextUtils.isEmpty(a)) {
            a = C5621g0.a(AbstractC5607b.i(), "Privacy_MY", "public_key_time_interval", "");
            AbstractC5607b.f(a);
        }
        String m = AbstractC5607b.m();
        if (TextUtils.isEmpty(m)) {
            m = C5621g0.a(AbstractC5607b.i(), "Privacy_MY", "public_key_time_last", "");
            AbstractC5607b.c(m);
        }
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(m)) {
            return true;
        }
        try {
            return System.currentTimeMillis() - Long.parseLong(m) > ((long) Integer.parseInt(a));
        } catch (NumberFormatException e) {
            C5653y.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e.getMessage());
            return true;
        }
    }

    public static String b(String str, String str2) {
        String o;
        String c = AbstractC5607b.c();
        if (TextUtils.isEmpty(c)) {
            c = C5621g0.a(AbstractC5607b.i(), "Privacy_MY", "public_key_version", "");
            AbstractC5607b.g(c);
        }
        if ("maint".equals(str2)) {
            o = AbstractC5607b.n();
            if (TextUtils.isEmpty(o)) {
                o = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", C5621g0.a(AbstractC5607b.i(), "Privacy_MY", "public_key_maint", ""));
                AbstractC5607b.d(o);
            }
        } else {
            o = AbstractC5607b.o();
            if (TextUtils.isEmpty(o)) {
                o = AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", C5621g0.a(AbstractC5607b.i(), "Privacy_MY", "public_key_oper", ""));
                AbstractC5607b.e(o);
            }
        }
        if (TextUtils.isEmpty(o) || TextUtils.isEmpty(c) || a()) {
            C5637o0.a().a(new C5633m0(str, str2));
            return null;
        }
        return o;
    }

    public static void c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("publicKey");
            String optString2 = jSONObject.optString("publicKeyOM");
            String optString3 = jSONObject.optString("pubkey_version");
            String str3 = System.currentTimeMillis() + "";
            String optString4 = jSONObject.optString("timeInterval");
            C5621g0.b(AbstractC5607b.i(), "Privacy_MY", "public_key_oper", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString));
            C5621g0.b(AbstractC5607b.i(), "Privacy_MY", "public_key_maint", AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            C5621g0.b(AbstractC5607b.i(), "Privacy_MY", "public_key_time_interval", optString4);
            C5621g0.b(AbstractC5607b.i(), "Privacy_MY", "public_key_version", optString3);
            C5621g0.b(AbstractC5607b.i(), "Privacy_MY", "public_key_time_last", str3);
            AbstractC5607b.e(optString);
            AbstractC5607b.d(optString2);
            AbstractC5607b.g(optString3);
            AbstractC5607b.c(str3);
            AbstractC5607b.f(optString4);
        } catch (JSONException e) {
            C5653y.e("GetPublicKey", "get pubKey parse json JSONException :" + e.getMessage());
        }
    }
}
