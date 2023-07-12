package com.taobao.android.ultron.datamodel.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.ISubmitModule;
import java.util.List;
import tb.vt2;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.ultron.datamodel.imp.b */
/* loaded from: classes12.dex */
public class C6662b {
    private C6663c a = new C6663c();
    private ISubmitModule b = new C6664d();
    boolean c;

    public C6662b(boolean z) {
        this.c = true;
        this.c = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0044 A[Catch: all -> 0x003b, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x003b, blocks: (B:10:0x0025, B:28:0x0044, B:17:0x0031, B:18:0x0034, B:20:0x0037), top: B:47:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            if (r6 == 0) goto L54
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto Lb
            goto L54
        Lb:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            int r2 = r6.length()
            r1.<init>(r2)
            r2 = 1
            r3 = 0
            r4 = 0
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L35
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L35
            java.lang.String r3 = "utf-8"
            byte[] r6 = r6.getBytes(r3)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2c
            r5.write(r6)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2c
            r5.close()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            goto L3e
        L29:
            r6 = move-exception
            r3 = r5
            goto L2f
        L2c:
            r3 = r5
            goto L35
        L2e:
            r6 = move-exception
        L2f:
            if (r3 == 0) goto L34
            r3.close()     // Catch: java.io.IOException -> L34 java.lang.Throwable -> L3b
        L34:
            throw r6     // Catch: java.lang.Throwable -> L3b
        L35:
            if (r3 == 0) goto L3d
            r3.close()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            goto L3d
        L3b:
            r6 = move-exception
            goto L50
        L3d:
            r2 = 0
        L3e:
            if (r2 != 0) goto L44
            r1.close()     // Catch: java.io.IOException -> L43
        L43:
            return r0
        L44:
            byte[] r6 = r1.toByteArray()     // Catch: java.lang.Throwable -> L3b
            r1.close()     // Catch: java.io.IOException -> L4b
        L4b:
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r4)
            return r6
        L50:
            r1.close()     // Catch: java.io.IOException -> L53
        L53:
            throw r6
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.ultron.datamodel.imp.C6662b.b(java.lang.String):java.lang.String");
    }

    public String a(C6661a c6661a, IDMComponent iDMComponent) {
        String jSONString = JSON.toJSONString(this.b.asyncRequestData(c6661a, iDMComponent));
        vt2.b("DMEngine", "asyncRequestData: " + jSONString);
        return this.c ? b(jSONString) : jSONString;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<IDMComponent> c(C6661a c6661a, String str) {
        return this.a.f(c6661a, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IDMComponent d() {
        return this.a.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(C6661a c6661a, JSONObject jSONObject) {
        return this.a.n(c6661a, jSONObject);
    }

    public void f(ISubmitModule iSubmitModule) {
        if (iSubmitModule != null) {
            this.b = iSubmitModule;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g(C6661a c6661a) {
        String jSONString = JSON.toJSONString(this.b.submitRequestData(c6661a));
        vt2.b("DMEngine", "submitRequestData: " + jSONString);
        return this.c ? b(jSONString) : jSONString;
    }
}
