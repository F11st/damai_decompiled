package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.C6313b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c7 {
    private static volatile c7 c;
    private JSONObject a;
    private boolean b = false;

    private c7() {
    }

    public static c7 a() {
        if (c == null) {
            synchronized (c7.class) {
                if (c == null) {
                    c = new c7();
                }
            }
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r5 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
        if (r5 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            if (r5 != 0) goto L9
            return r1
        L9:
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L44
            java.lang.String r2 = "dinamic/dx_appstyle.json"
            java.io.InputStream r5 = r5.open(r2)     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L44
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L45
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L45
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L45
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L45
        L1d:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            if (r1 == 0) goto L27
            r0.append(r1)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            goto L1d
        L27:
            r2.close()     // Catch: java.io.IOException -> L4d
            if (r5 == 0) goto L4d
        L2c:
            r5.close()     // Catch: java.io.IOException -> L4d
            goto L4d
        L30:
            r0 = move-exception
            r1 = r2
            goto L39
        L33:
            r1 = r2
            goto L45
        L35:
            r0 = move-exception
            goto L39
        L37:
            r0 = move-exception
            r5 = r1
        L39:
            if (r1 == 0) goto L3e
            r1.close()     // Catch: java.io.IOException -> L43
        L3e:
            if (r5 == 0) goto L43
            r5.close()     // Catch: java.io.IOException -> L43
        L43:
            throw r0
        L44:
            r5 = r1
        L45:
            if (r1 == 0) goto L4a
            r1.close()     // Catch: java.io.IOException -> L4d
        L4a:
            if (r5 == 0) goto L4d
            goto L2c
        L4d:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.c7.b(android.content.Context):java.lang.String");
    }

    public JSONObject c() {
        JSONObject jSONObject = this.a;
        if (jSONObject == null || !this.b) {
            JSONObject parseObject = JSON.parseObject(b(C6313b.a()));
            this.a = parseObject;
            this.b = true;
            return parseObject;
        }
        return jSONObject;
    }
}
