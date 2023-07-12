package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gi {
    private volatile b a = new b();
    private hr b = new hr("HttpsDecisionUtil");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        static gi a = new gi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        protected boolean a;
        private int b;
        private final boolean c;
        private boolean d;

        private b() {
            this.b = 0;
            this.a = true;
            this.c = true;
            this.d = false;
        }

        private boolean c() {
            return b() >= 28;
        }

        private boolean d() {
            return Build.VERSION.SDK_INT >= 28;
        }

        private boolean e() {
            return d() && (!this.a || c());
        }

        public void a(Context context) {
            if (context != null && this.b <= 0 && Build.VERSION.SDK_INT >= 4) {
                this.b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public void b(boolean z) {
            this.d = z;
        }

        private int b() {
            int i = this.b;
            if (i <= 0) {
                return 28;
            }
            return i;
        }

        public void a(boolean z) {
            this.a = z;
        }

        public boolean a() {
            return this.d || e();
        }
    }

    public static gi a() {
        return a.a;
    }

    private boolean c(Context context) {
        return this.b.b(context, "isTargetRequired", true);
    }

    private void d(Context context) {
        this.b.a(context, "isTargetRequired", true);
    }

    public void b(Context context) {
        d(context);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT == 19;
    }

    public void a(Context context) {
        if (this.a == null) {
            this.a = new b();
        }
        this.a.a(c(context));
        this.a.a(context);
    }

    public boolean b() {
        if (this.a == null) {
            this.a = new b();
        }
        return this.a.a();
    }

    private void b(Context context, boolean z) {
        this.b.a(context, "isTargetRequired", z);
    }

    public void a(boolean z) {
        if (this.a == null) {
            this.a = new b();
        }
        this.a.b(z);
    }

    public boolean b(boolean z) {
        if (c()) {
            return false;
        }
        return z || b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, boolean z) {
        if (this.a == null) {
            this.a = new b();
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
