package com.vivo.push.sdk.service;

import android.app.Activity;
import com.vivo.push.util.p;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LinkProxyActivity extends Activity {
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6 A[Catch: Exception -> 0x00d8, TryCatch #1 {Exception -> 0x00d8, blocks: (B:23:0x008b, B:25:0x0091, B:27:0x009d, B:29:0x00a3, B:31:0x00ab, B:34:0x00b2, B:36:0x00ba, B:38:0x00be, B:43:0x00c6, B:44:0x00ca), top: B:52:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca A[Catch: Exception -> 0x00d8, TRY_LEAVE, TryCatch #1 {Exception -> 0x00d8, blocks: (B:23:0x008b, B:25:0x0091, B:27:0x009d, B:29:0x00a3, B:31:0x00ab, B:34:0x00b2, B:36:0x00ba, B:38:0x00be, B:43:0x00c6, B:44:0x00ca), top: B:52:0x008b }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "LinkProxyActivity"
            if (r7 != 0) goto L14
            java.lang.String r7 = "enter RequestPermissionsActivity onCreate, intent is null, finish"
            com.vivo.push.util.p.d(r0, r7)
            r6.finish()
            return
        L14:
            r1 = 1
            r2 = 0
            android.view.Window r3 = r6.getWindow()     // Catch: java.lang.Throwable -> L30
            r4 = 8388659(0x800033, float:1.1755015E-38)
            r3.setGravity(r4)     // Catch: java.lang.Throwable -> L30
            android.view.WindowManager$LayoutParams r4 = r3.getAttributes()     // Catch: java.lang.Throwable -> L30
            r4.x = r2     // Catch: java.lang.Throwable -> L30
            r4.y = r2     // Catch: java.lang.Throwable -> L30
            r4.height = r1     // Catch: java.lang.Throwable -> L30
            r4.width = r1     // Catch: java.lang.Throwable -> L30
            r3.setAttributes(r4)     // Catch: java.lang.Throwable -> L30
            goto L36
        L30:
            r3 = move-exception
            java.lang.String r4 = "enter onCreate error "
            com.vivo.push.util.p.b(r0, r4, r3)
        L36:
            java.lang.String r3 = r6.getPackageName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = r6.hashCode()
            r4.append(r5)
            java.lang.String r5 = " enter onCreate "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.vivo.push.util.p.d(r0, r4)
            java.lang.String r4 = "com.vivo.abe"
            boolean r3 = r4.equals(r3)
            java.lang.String r4 = "previous_intent"
            if (r3 == 0) goto L8b
            android.os.Bundle r1 = r7.getExtras()     // Catch: java.lang.Exception -> L82
            if (r1 != 0) goto L6c
            java.lang.String r7 = "adapterToService getExtras() is null"
            com.vivo.push.util.p.d(r0, r7)     // Catch: java.lang.Exception -> L82
            goto Le0
        L6c:
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> L82
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Exception -> L82
            android.content.Intent r7 = (android.content.Intent) r7     // Catch: java.lang.Exception -> L82
            if (r7 != 0) goto L7e
            java.lang.String r7 = "adapterToService proxyIntent is null"
            com.vivo.push.util.p.d(r0, r7)     // Catch: java.lang.Exception -> L82
            goto Le0
        L7e:
            com.vivo.push.util.z.a(r6, r7)     // Catch: java.lang.Exception -> L82
            goto Le0
        L82:
            r7 = move-exception
            java.lang.String r1 = r7.toString()
            com.vivo.push.util.p.a(r0, r1, r7)
            goto Le0
        L8b:
            android.os.Bundle r3 = r7.getExtras()     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Le0
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> Ld8
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Exception -> Ld8
            android.content.Intent r7 = (android.content.Intent) r7     // Catch: java.lang.Exception -> Ld8
            if (r7 == 0) goto Lc3
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Lc3
            r4 = 576(0x240, float:8.07E-43)
            java.util.List r3 = r3.queryIntentServices(r7, r4)     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Lc3
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Exception -> Ld8
            if (r4 == 0) goto Lb2
            goto Lc3
        Lb2:
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Exception -> Ld8
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Lc3
            android.content.pm.ServiceInfo r3 = r3.serviceInfo     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Lc3
            boolean r3 = r3.exported     // Catch: java.lang.Exception -> Ld8
            if (r3 == 0) goto Lc3
            goto Lc4
        Lc3:
            r1 = 0
        Lc4:
            if (r1 == 0) goto Lca
            r6.startService(r7)     // Catch: java.lang.Exception -> Ld8
            goto Le0
        Lca:
            java.lang.String r7 = "service's exported is "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> Ld8
            java.lang.String r7 = r7.concat(r1)     // Catch: java.lang.Exception -> Ld8
            com.vivo.push.util.p.b(r0, r7)     // Catch: java.lang.Exception -> Ld8
            goto Le0
        Ld8:
            r7 = move-exception
            java.lang.String r1 = r7.toString()
            com.vivo.push.util.p.a(r0, r1, r7)
        Le0:
            r6.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.sdk.service.LinkProxyActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        p.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
