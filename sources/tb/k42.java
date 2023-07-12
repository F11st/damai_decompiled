package tb;

import android.util.Log;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class k42 extends b2 {
    private Constructor<?> a;

    public k42() {
        b();
    }

    private void b() {
        try {
            Constructor<?> constructor = Class.forName("android.content.res.XmlBlock").getConstructor(byte[].class);
            this.a = constructor;
            constructor.setAccessible(true);
        } catch (Exception e) {
            Log.e("Home.FileParser", "Fail to get XmlBlock", e);
        }
    }

    public boolean c(DinamicTemplate dinamicTemplate) {
        return new File("/sdcard/com.taobao.taobao/home", dinamicTemplate.name).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007a A[Catch: Exception -> 0x007d, TRY_LEAVE, TryCatch #0 {Exception -> 0x007d, blocks: (B:21:0x0062, B:23:0x007a), top: B:28:0x0062 }] */
    @Override // com.taobao.android.dinamic.parser.Parser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.xmlpull.v1.XmlPullParser openXmlResourceParser(java.lang.String r5, com.taobao.android.dinamic.tempate.DinamicTemplate r6, tb.iy2 r7) {
        /*
            r4 = this;
            java.lang.String r5 = "Home.FileParser"
            java.lang.reflect.Constructor<?> r0 = r4.a
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.String r0 = r6.name
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L11
            return r1
        L11:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = "/sdcard/com.taobao.taobao/home"
            java.lang.String r3 = r6.name     // Catch: java.lang.Exception -> L2a
            r0.<init>(r2, r3)     // Catch: java.lang.Exception -> L2a
            boolean r2 = r0.exists()     // Catch: java.lang.Exception -> L2a
            if (r2 == 0) goto L41
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L2a
            r2.<init>(r0)     // Catch: java.lang.Exception -> L2a
            byte[] r0 = com.taobao.android.dinamic.parser.C6339a.a(r2)     // Catch: java.lang.Exception -> L2a
            goto L42
        L2a:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Fail to read sdcard layout: "
            r2.append(r3)
            java.lang.String r3 = r6.name
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r5, r2, r0)
        L41:
            r0 = r1
        L42:
            byte[] r7 = r4.a(r0, r7)
            if (r7 == 0) goto L94
            int r0 = r7.length
            if (r0 != 0) goto L4c
            goto L94
        L4c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "File parser is applied: "
            r0.append(r2)
            java.lang.String r2 = r6.name
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
            java.lang.reflect.Constructor<?> r0 = r4.a     // Catch: java.lang.Exception -> L7d
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L7d
            r3 = 0
            r2[r3] = r7     // Catch: java.lang.Exception -> L7d
            java.lang.Object r7 = r0.newInstance(r2)     // Catch: java.lang.Exception -> L7d
            java.lang.String r0 = "newParser"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L7d
            java.lang.Object r7 = tb.y02.b(r7, r0, r2)     // Catch: java.lang.Exception -> L7d
            boolean r0 = r7 instanceof android.content.res.XmlResourceParser     // Catch: java.lang.Exception -> L7d
            if (r0 == 0) goto L94
            android.content.res.XmlResourceParser r7 = (android.content.res.XmlResourceParser) r7     // Catch: java.lang.Exception -> L7d
            return r7
        L7d:
            r7 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "New sdcard parser exception: "
            r0.append(r2)
            java.lang.String r6 = r6.name
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            android.util.Log.e(r5, r6, r7)
        L94:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.k42.openXmlResourceParser(java.lang.String, com.taobao.android.dinamic.tempate.DinamicTemplate, tb.iy2):org.xmlpull.v1.XmlPullParser");
    }
}
