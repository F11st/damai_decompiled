package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import tb.b43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class q1 {
    private volatile b a = new b((byte) 0);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        static q1 a = new q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private int a;
        protected boolean b;
        private boolean c;

        private b() {
            this.a = 0;
            this.b = true;
            this.c = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void a(Context context) {
            if (context != null && this.a <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.a = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z) {
            this.b = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean c() {
            /*
                r5 = this;
                boolean r0 = r5.c
                r1 = 1
                if (r0 != 0) goto L2f
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto Le
                r0 = 1
                goto Lf
            Le:
                r0 = 0
            Lf:
                boolean r4 = r5.b
                if (r4 == 0) goto L23
                int r4 = r5.a
                if (r4 > 0) goto L19
                r4 = 28
            L19:
                if (r4 < r2) goto L1d
                r2 = 1
                goto L1e
            L1d:
                r2 = 0
            L1e:
                if (r2 == 0) goto L21
                goto L23
            L21:
                r2 = 0
                goto L24
            L23:
                r2 = 1
            L24:
                if (r0 == 0) goto L2a
                if (r2 == 0) goto L2a
                r0 = 1
                goto L2b
            L2a:
                r0 = 0
            L2b:
                if (r0 == 0) goto L2e
                goto L2f
            L2e:
                return r3
            L2f:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.q1.b.c():boolean");
        }
    }

    public q1() {
        new b43("HttpsDecisionUtil");
    }

    public static q1 a() {
        return a.a;
    }

    public static String b(String str) {
        Uri.Builder buildUpon;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.startsWith("https")) {
            try {
                buildUpon = Uri.parse(str).buildUpon();
                buildUpon.scheme("https");
            } catch (Throwable unused) {
                return str;
            }
        }
        return buildUpon.build().toString();
    }

    public static void f(Context context) {
        g(context, true);
    }

    private static void g(Context context, boolean z) {
        SharedPreferences.Editor b2 = b43.b(context, "open_common");
        b43.j(b2, "a3", z);
        b43.e(b2);
    }

    private static boolean i() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final void c(Context context) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        this.a.b(b43.k(context, "open_common", "a3", true));
        this.a.a(context);
        w1.a(context).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(Context context, boolean z) {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        g(context, z);
        this.a.b(z);
    }

    public final boolean e(boolean z) {
        if (i()) {
            return false;
        }
        return z || h();
    }

    public final boolean h() {
        if (this.a == null) {
            this.a = new b((byte) 0);
        }
        return this.a.c();
    }
}
