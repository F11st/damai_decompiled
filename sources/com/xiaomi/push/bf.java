package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class bf implements au {
    private static String a = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static String b = a + "OAID";
    private static String c = a + "VAID_";
    private static String d = a + "AAID_";
    private static String e = a + com.alipay.sdk.m.p0.b.h;
    private static String f = com.alipay.sdk.m.p0.c.c;

    /* renamed from: a  reason: collision with other field name */
    private Context f129a;

    public bf(Context context) {
        this.f129a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r10 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r10 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.f129a     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L3a
            if (r10 == 0) goto L2a
            boolean r1 = r10.moveToNext()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            if (r1 == 0) goto L2a
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            java.lang.String r0 = r10.getString(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L28
            goto L2a
        L26:
            r0 = move-exception
            goto L34
        L28:
            goto L3b
        L2a:
            if (r10 == 0) goto L3e
        L2c:
            r10.close()
            goto L3e
        L30:
            r10 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        L34:
            if (r10 == 0) goto L39
            r10.close()
        L39:
            throw r0
        L3a:
            r10 = r0
        L3b:
            if (r10 == 0) goto L3e
            goto L2c
        L3e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bf.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a */
    public String mo670a() {
        return a(b);
    }

    @Override // com.xiaomi.push.au
    /* renamed from: a */
    public boolean mo671a() {
        return "1".equals(u.a(f, "0"));
    }
}
