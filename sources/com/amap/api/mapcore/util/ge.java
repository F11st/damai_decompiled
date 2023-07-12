package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes10.dex */
public class ge {
    public static int a = -1;
    public static String b = "";
    private static gm c = null;
    private static String d = "http://apiinit.amap.com/v3/log/init";
    private static String e;

    private static boolean a(Context context, gm gmVar, boolean z) {
        c = gmVar;
        try {
            String a2 = a();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put(IRequestConst.CONNECTION, IRequestConst.CONNECTION_VALUE);
            hashMap.put(IRequestConst.USER_AGENT, c.d());
            hashMap.put("X-INFO", gf.b(context));
            hashMap.put("logversion", "2.1");
            hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", c.b(), c.a()));
            id a3 = id.a();
            go goVar = new go();
            goVar.setProxy(gl.a(context));
            goVar.a(hashMap);
            goVar.b(a(context));
            goVar.a(a2);
            return a(a3.b(goVar));
        } catch (Throwable th) {
            C4573ha.a(th, "Auth", "getAuth");
            return true;
        }
    }

    @Deprecated
    public static synchronized boolean a(Context context, gm gmVar) {
        boolean a2;
        synchronized (ge.class) {
            a2 = a(context, gmVar, false);
        }
        return a2;
    }

    private static String a() {
        return d;
    }

    private static boolean a(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(gn.a(bArr));
            if (jSONObject.has("status")) {
                int i = jSONObject.getInt("status");
                if (i == 1) {
                    a = 1;
                } else if (i == 0) {
                    a = 0;
                }
            }
            if (jSONObject.has("info")) {
                b = jSONObject.getString("info");
            }
            if (a == 0) {
                Log.i("AuthFailure", b);
            }
            return a == 1;
        } catch (JSONException e2) {
            C4573ha.a(e2, "Auth", "lData");
            return false;
        } catch (Throwable th) {
            C4573ha.a(th, "Auth", "lData");
            return false;
        }
    }

    private static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("resType", Preloader.KEY_JSON);
            hashMap.put("encode", "UTF-8");
            String a2 = gf.a();
            hashMap.put("ts", a2);
            hashMap.put("key", C4554gc.f(context));
            hashMap.put("scode", gf.a(context, a2, gn.d("resType=json&encode=UTF-8&key=" + C4554gc.f(context))));
        } catch (Throwable th) {
            C4573ha.a(th, "Auth", "gParams");
        }
        return hashMap;
    }
}
