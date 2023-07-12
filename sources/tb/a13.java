package tb;

import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmName;

/* compiled from: Taobao */
@JvmName(name = "WaterMarkUtil")
/* loaded from: classes8.dex */
public final class a13 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String a(@org.jetbrains.annotations.NotNull android.content.ContentResolver r4, @org.jetbrains.annotations.Nullable android.graphics.Bitmap r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.a13.$ipChange
            java.lang.String r1 = "-49256297"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L20
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r4 = 1
            r2[r4] = r5
            r4 = 2
            r2[r4] = r6
            r4 = 3
            r2[r4] = r7
            java.lang.Object r4 = r0.ipc$dispatch(r1, r2)
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L20:
            java.lang.String r0 = "cr"
            tb.b41.i(r4, r0)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r1 = "title"
            r0.put(r1, r6)
            java.lang.String r6 = "description"
            r0.put(r6, r7)
            java.lang.String r6 = "mime_type"
            java.lang.String r7 = "image/png"
            r0.put(r6, r7)
            r6 = 0
            android.net.Uri r7 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L64
            android.net.Uri r7 = r4.insert(r7, r0)     // Catch: java.lang.Exception -> L64
            if (r5 == 0) goto L5c
            if (r7 == 0) goto L5c
            java.io.OutputStream r0 = r4.openOutputStream(r7)     // Catch: java.lang.Exception -> L62
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L55
            r2 = 100
            r5.compress(r1, r2, r0)     // Catch: java.lang.Throwable -> L55
            tb.xj.a(r0, r6)     // Catch: java.lang.Exception -> L62
            goto L6b
        L55:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L57
        L57:
            r1 = move-exception
            tb.xj.a(r0, r5)     // Catch: java.lang.Exception -> L62
            throw r1     // Catch: java.lang.Exception -> L62
        L5c:
            if (r7 == 0) goto L6a
            r4.delete(r7, r6, r6)     // Catch: java.lang.Exception -> L62
            goto L6a
        L62:
            goto L65
        L64:
            r7 = r6
        L65:
            if (r7 == 0) goto L6b
            r4.delete(r7, r6, r6)
        L6a:
            r7 = r6
        L6b:
            if (r7 == 0) goto L71
            java.lang.String r6 = r7.toString()
        L71:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.a13.a(android.content.ContentResolver, android.graphics.Bitmap, java.lang.String, java.lang.String):java.lang.String");
    }
}
