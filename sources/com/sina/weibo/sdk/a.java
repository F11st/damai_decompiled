package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.openapi.SdkListener;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class a {
    private static boolean a;
    private static AuthInfo b;

    public static void a(AuthInfo authInfo, SdkListener sdkListener) {
        if (a) {
            return;
        }
        if (authInfo != null) {
            b = authInfo;
            a = true;
            if (sdkListener != null) {
                sdkListener.onInitSuccess();
                return;
            }
            return;
        }
        throw new RuntimeException("authInfo must not be null.");
    }

    public static boolean b(Context context) {
        a.C0273a e;
        return a(context) && (e = com.sina.weibo.sdk.b.a.e(context)) != null && e.ah >= 10772;
    }

    public static boolean a(Context context) {
        List<ResolveInfo> queryIntentServices;
        String[] strArr = {"com.sina.weibo", "com.sina.weibog3"};
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.setPackage(str);
            intent.addCategory("android.intent.category.DEFAULT");
            if (context != null && (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !queryIntentServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static AuthInfo a() {
        if (a) {
            return b;
        }
        throw new RuntimeException("please init sdk before use it. Wb.install()");
    }
}
