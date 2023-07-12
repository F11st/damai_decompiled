package cn.damai.homepage.util;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.damai.common.util.ToastUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import tb.mu0;
import tb.qx0;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class LottieMockHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_IN_MOCK = "release_me_use_lottie_url";

    public static JSONObject a(JSONArray jSONArray) {
        JSONObject a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177076096")) {
            return (JSONObject) ipChange.ipc$dispatch("-177076096", new Object[]{jSONArray});
        }
        if (jSONArray == null || jSONArray.size() <= 0) {
            return null;
        }
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) next;
                boolean equals = "3".equals(jSONObject.get("level"));
                boolean equals2 = "7542".equals(jSONObject.get("type"));
                if (equals && equals2) {
                    return jSONObject;
                }
                Object obj = jSONObject.get("nodes");
                if ((obj instanceof JSONArray) && (a = a((JSONArray) obj)) != null) {
                    return a;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.fastjson.JSONObject b(java.lang.String r4) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.homepage.util.LottieMockHelper.$ipChange
            java.lang.String r1 = "-1368965831"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            java.lang.Object r4 = r0.ipc$dispatch(r1, r2)
            com.alibaba.fastjson.JSONObject r4 = (com.alibaba.fastjson.JSONObject) r4
            return r4
        L17:
            r0 = 0
            android.app.Application r1 = tb.mu0.a()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            int r2 = cn.damai.homepage.R$raw.home_amtosphere_mock     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.String r2 = tb.uh2.a(r1)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L60
            if (r2 == 0) goto L41
            java.lang.String r3 = "release_me_use_lottie_url"
            java.lang.String r4 = r2.replace(r3, r4)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L60
            com.alibaba.fastjson.JSONObject r4 = com.alibaba.fastjson.JSON.parseObject(r4)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L60
            if (r1 == 0) goto L40
            r1.close()     // Catch: java.io.IOException -> L3c
            goto L40
        L3c:
            r0 = move-exception
            r0.printStackTrace()
        L40:
            return r4
        L41:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L47:
            r4 = move-exception
            goto L4d
        L49:
            r4 = move-exception
            goto L62
        L4b:
            r4 = move-exception
            r1 = r0
        L4d:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = "Mock氛围解析本地数据失败"
            d(r4)     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r4 = move-exception
            r4.printStackTrace()
        L5f:
            return r0
        L60:
            r4 = move-exception
            r0 = r1
        L62:
            if (r0 == 0) goto L6c
            r0.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L68:
            r0 = move-exception
            r0.printStackTrace()
        L6c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.util.LottieMockHelper.b(java.lang.String):com.alibaba.fastjson.JSONObject");
    }

    public static void c(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1873109842")) {
            ipChange.ipc$dispatch("1873109842", new Object[]{jSONObject});
            return;
        }
        String b = qx0.b();
        if (TextUtils.isEmpty(b) || jSONObject == null || !jSONObject.containsKey("data")) {
            return;
        }
        Object obj = jSONObject.get("data");
        if (obj instanceof JSONObject) {
            JSONObject jSONObject2 = (JSONObject) obj;
            if (jSONObject2.containsKey("nodes")) {
                Object obj2 = jSONObject2.get("nodes");
                if (obj2 instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj2;
                    if (jSONArray.size() > 0) {
                        JSONObject a = a(jSONArray);
                        if (a != null) {
                            Object obj3 = a.get("data");
                            if (obj3 instanceof JSONObject) {
                                ((JSONObject) obj3).put("lottie", (Object) b);
                                d("氛围使用Lottie 1:" + b);
                                return;
                            }
                            return;
                        }
                        JSONObject b2 = b(b);
                        if (b2 != null) {
                            jSONArray.add(0, b2);
                            d("氛围使用Lottie 2:" + b);
                        }
                    }
                }
            }
        }
    }

    public static void d(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1295472367")) {
            ipChange.ipc$dispatch("1295472367", new Object[]{str});
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.homepage.util.LottieMockHelper.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-366256777")) {
                        ipChange2.ipc$dispatch("-366256777", new Object[]{this});
                    } else {
                        ToastUtil.a().j(mu0.a(), str);
                    }
                }
            });
        }
    }
}
