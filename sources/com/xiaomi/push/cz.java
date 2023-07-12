package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class cz {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a extends cy {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.cy
        public String a(Context context, String str, List<bi> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (bi biVar : list) {
                    buildUpon.appendQueryParameter(biVar.a(), biVar.b());
                }
                url = new URL(buildUpon.toString());
            }
            return bj.a(context, url);
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    private static int a(cy cyVar, String str, List<bi> list, String str2) {
        if (cyVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (cyVar.a() == 2) {
            return a(str.length(), a(list), a(str2));
        }
        return -1;
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    static int a(List<bi> list) {
        int i = 0;
        for (bi biVar : list) {
            if (!TextUtils.isEmpty(biVar.a())) {
                i += biVar.a().length();
            }
            if (!TextUtils.isEmpty(biVar.b())) {
                i += biVar.b().length();
            }
        }
        return i * 2;
    }

    public static String a(Context context, String str, List<bi> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9 A[Catch: MalformedURLException -> 0x00c2, TRY_ENTER, TryCatch #4 {MalformedURLException -> 0x00c2, blocks: (B:4:0x000f, B:6:0x0016, B:8:0x0020, B:11:0x0027, B:13:0x002d, B:14:0x0030, B:15:0x0035, B:17:0x003b, B:19:0x0044, B:21:0x004c, B:49:0x00a9, B:50:0x00bb), top: B:64:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r20, java.lang.String r21, java.util.List<com.xiaomi.push.bi> r22, com.xiaomi.push.cy r23, boolean r24) {
        /*
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = r23
            boolean r4 = com.xiaomi.push.bj.b(r20)
            r5 = 0
            if (r4 == 0) goto Lc6
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.net.MalformedURLException -> Lc2
            r4.<init>()     // Catch: java.net.MalformedURLException -> Lc2
            if (r24 == 0) goto L26
            com.xiaomi.push.cv r6 = com.xiaomi.push.cv.a()     // Catch: java.net.MalformedURLException -> Lc2
            com.xiaomi.push.cr r6 = r6.m751a(r0)     // Catch: java.net.MalformedURLException -> Lc2
            if (r6 == 0) goto L24
            java.util.ArrayList r4 = r6.a(r0)     // Catch: java.net.MalformedURLException -> Lc2
        L24:
            r13 = r6
            goto L27
        L26:
            r13 = r5
        L27:
            boolean r6 = r4.contains(r0)     // Catch: java.net.MalformedURLException -> Lc2
            if (r6 != 0) goto L30
            r4.add(r0)     // Catch: java.net.MalformedURLException -> Lc2
        L30:
            java.util.Iterator r4 = r4.iterator()     // Catch: java.net.MalformedURLException -> Lc2
            r6 = r5
        L35:
            boolean r0 = r4.hasNext()     // Catch: java.net.MalformedURLException -> Lc2
            if (r0 == 0) goto Lc1
            java.lang.Object r0 = r4.next()     // Catch: java.net.MalformedURLException -> Lc2
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14     // Catch: java.net.MalformedURLException -> Lc2
            if (r2 == 0) goto L4b
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.net.MalformedURLException -> Lc2
            r0.<init>(r2)     // Catch: java.net.MalformedURLException -> Lc2
            r15 = r0
            goto L4c
        L4b:
            r15 = r5
        L4c:
            long r16 = java.lang.System.currentTimeMillis()     // Catch: java.net.MalformedURLException -> Lc2
            boolean r0 = r3.m760a(r1, r14, r15)     // Catch: java.io.IOException -> La3
            if (r0 != 0) goto L57
            goto Lc1
        L57:
            java.lang.String r12 = r3.a(r1, r14, r15)     // Catch: java.io.IOException -> La3
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.io.IOException -> L99
            if (r0 != 0) goto L7b
            if (r13 == 0) goto L79
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.io.IOException -> L74
            long r8 = r6 - r16
            int r0 = a(r3, r14, r15, r12)     // Catch: java.io.IOException -> L74
            long r10 = (long) r0     // Catch: java.io.IOException -> L74
            r6 = r13
            r7 = r14
            r6.a(r7, r8, r10)     // Catch: java.io.IOException -> L74
            goto L79
        L74:
            r0 = move-exception
            r18 = r0
            r0 = r12
            goto La7
        L79:
            r6 = r12
            goto Lc1
        L7b:
            if (r13 == 0) goto L94
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.io.IOException -> L99
            long r8 = r6 - r16
            int r0 = a(r3, r14, r15, r12)     // Catch: java.io.IOException -> L99
            long r10 = (long) r0
            r0 = 0
            r6 = r13
            r7 = r14
            r18 = r12
            r12 = r0
            r6.a(r7, r8, r10, r12)     // Catch: java.io.IOException -> L92
            goto L96
        L92:
            r0 = move-exception
            goto L9c
        L94:
            r18 = r12
        L96:
            r6 = r18
            goto L35
        L99:
            r0 = move-exception
            r18 = r12
        L9c:
            r19 = r18
            r18 = r0
            r0 = r19
            goto La7
        La3:
            r0 = move-exception
            r18 = r0
            r0 = r6
        La7:
            if (r13 == 0) goto Lbb
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.net.MalformedURLException -> Lc2
            long r8 = r6 - r16
            int r6 = a(r3, r14, r15, r0)     // Catch: java.net.MalformedURLException -> Lc2
            long r10 = (long) r6     // Catch: java.net.MalformedURLException -> Lc2
            r6 = r13
            r7 = r14
            r12 = r18
            r6.a(r7, r8, r10, r12)     // Catch: java.net.MalformedURLException -> Lc2
        Lbb:
            r18.printStackTrace()     // Catch: java.net.MalformedURLException -> Lc2
            r6 = r0
            goto L35
        Lc1:
            return r6
        Lc2:
            r0 = move-exception
            r0.printStackTrace()
        Lc6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cz.a(android.content.Context, java.lang.String, java.util.List, com.xiaomi.push.cy, boolean):java.lang.String");
    }
}
