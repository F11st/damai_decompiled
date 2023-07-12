package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.c.C4097a;
import com.alipay.apmobilesecuritysdk.f.C4114a;
import com.alipay.sdk.m.z.C4368a;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.e.e */
/* loaded from: classes12.dex */
public final class C4109e {
    public static C4110f a(Context context) {
        if (context == null) {
            return null;
        }
        String a = C4114a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        if (C4368a.a(a)) {
            a = C4114a.a("device_feature_file_name", "device_feature_file_key");
        }
        if (C4368a.a(a)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(a);
            C4110f c4110f = new C4110f();
            c4110f.a(jSONObject.getString("imei"));
            c4110f.b(jSONObject.getString("imsi"));
            c4110f.c(jSONObject.getString("mac"));
            c4110f.d(jSONObject.getString("bluetoothmac"));
            c4110f.e(jSONObject.getString("gsi"));
            return c4110f;
        } catch (Exception e) {
            C4097a.a(e);
            return null;
        }
    }
}
