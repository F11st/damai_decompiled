package com.alipay.sdk.m.x;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.x.c */
/* loaded from: classes10.dex */
public abstract class AbstractC4344c extends FrameLayout {
    public static final String c = "v1";
    public static final String d = "v2";
    public Activity a;
    public final String b;

    public AbstractC4344c(Activity activity, String str) {
        super(activity);
        this.a = activity;
        this.b = str;
    }

    public abstract void a(String str);

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.a.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public abstract boolean b();

    public abstract void c();

    public boolean a() {
        return c.equals(this.b);
    }

    public static void a(WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (Throwable unused) {
            }
        }
    }
}
