package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bq {
    private volatile C4395b a = new C4395b((byte) 0);
    private co b = new co("HttpsDecisionUtil");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bq$a */
    /* loaded from: classes10.dex */
    public static class C4394a {
        static bq a = new bq();
    }

    public static bq a() {
        return C4394a.a;
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT == 19;
    }

    public final boolean b() {
        if (this.a == null) {
            this.a = new C4395b((byte) 0);
        }
        return this.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.bq$b */
    /* loaded from: classes10.dex */
    public static class C4395b {
        protected boolean a;
        private int b;
        private final boolean c;
        private boolean d;

        private C4395b() {
            this.b = 0;
            this.a = true;
            this.c = true;
            this.d = false;
        }

        public final void a(Context context) {
            if (context != null && this.b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z) {
            this.d = z;
        }

        public final void a(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x002e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a() {
            /*
                r5 = this;
                boolean r0 = r5.d
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
                boolean r4 = r5.a
                if (r4 == 0) goto L23
                int r4 = r5.b
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
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.bq.C4395b.a():boolean");
        }

        /* synthetic */ C4395b(byte b) {
            this();
        }
    }

    public final void a(Context context) {
        if (this.a == null) {
            this.a = new C4395b((byte) 0);
        }
        this.a.a(co.a(context, "open_common", "a3", true));
        this.a.a(context);
        bx.a(context).a();
    }

    private static void b(Context context, boolean z) {
        SharedPreferences.Editor a = co.a(context, "open_common");
        co.a(a, "a3", z);
        co.a(a);
    }

    public final boolean b(boolean z) {
        if (c()) {
            return false;
        }
        return z || b();
    }

    public static void b(Context context) {
        b(context, true);
    }

    public final void a(boolean z) {
        if (this.a == null) {
            this.a = new C4395b((byte) 0);
        }
        this.a.b(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, boolean z) {
        if (this.a == null) {
            this.a = new C4395b((byte) 0);
        }
        b(context, z);
        this.a.a(z);
    }

    public static String a(String str) {
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
}
