package com.amap.api.mapcore.util;

import android.content.Context;
import com.uc.webview.export.internal.SDKFactory;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.j */
/* loaded from: classes10.dex */
public class C4596j extends fu<String, C4597a> {
    private boolean h;
    private int[] i;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.j$a */
    /* loaded from: classes10.dex */
    public static class C4597a {
        public String b;
        public String c;
        public int a = -1;
        public boolean d = false;
    }

    public C4596j(Context context, String str) {
        super(context, str);
        this.h = true;
        this.i = new int[]{10000, 0, 10018, 10019, SDKFactory.getCoreType, SDKFactory.setCoreType, SDKFactory.getGlobalSettings, 10023};
        this.g = "/feedback";
        this.isPostFlag = false;
        this.h = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        r1.d = true;
     */
    @Override // com.amap.api.mapcore.util.fu
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.amap.api.mapcore.util.C4596j.C4597a b(java.lang.String r6) throws com.amap.api.mapcore.util.ft {
        /*
            r5 = this;
            java.lang.String r0 = "errcode"
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L41
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L41
            r6 = -1
            boolean r2 = r1.has(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = ""
            if (r2 == 0) goto L21
            int r6 = r1.optInt(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = "errmsg"
            java.lang.String r3 = r1.optString(r0)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = "errdetail"
            java.lang.String r0 = r1.optString(r0)     // Catch: java.lang.Throwable -> L41
            goto L22
        L21:
            r0 = r3
        L22:
            com.amap.api.mapcore.util.j$a r1 = new com.amap.api.mapcore.util.j$a     // Catch: java.lang.Throwable -> L41
            r1.<init>()     // Catch: java.lang.Throwable -> L41
            r1.a = r6     // Catch: java.lang.Throwable -> L41
            r1.b = r3     // Catch: java.lang.Throwable -> L41
            r1.c = r0     // Catch: java.lang.Throwable -> L41
            r0 = 0
            r1.d = r0     // Catch: java.lang.Throwable -> L41
            int[] r2 = r5.i     // Catch: java.lang.Throwable -> L41
            int r3 = r2.length     // Catch: java.lang.Throwable -> L41
        L33:
            if (r0 >= r3) goto L40
            r4 = r2[r0]     // Catch: java.lang.Throwable -> L41
            if (r4 != r6) goto L3d
            r6 = 1
            r1.d = r6     // Catch: java.lang.Throwable -> L41
            goto L40
        L3d:
            int r0 = r0 + 1
            goto L33
        L40:
            return r1
        L41:
            r6 = move-exception
            r6.printStackTrace()
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C4596j.b(java.lang.String):com.amap.api.mapcore.util.j$a");
    }

    @Override // com.amap.api.mapcore.util.fu
    protected String a() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        return eq.a(getURL());
    }

    @Override // com.amap.api.mapcore.util.AbstractC4517dp, com.amap.api.mapcore.util.ii
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", C4554gc.f(this.f));
        if (this.h) {
            hashtable.put("pname", "3dmap");
        }
        String a = gf.a();
        String a2 = gf.a(this.f, a, gn.c(hashtable));
        hashtable.put("ts", a);
        hashtable.put("scode", a2);
        return hashtable;
    }

    @Override // com.amap.api.mapcore.util.ii
    public String getURL() {
        return "http://restapi.amap.com/v4" + this.g;
    }

    @Override // com.amap.api.mapcore.util.ii
    public boolean isSupportIPV6() {
        return true;
    }
}
