package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
import com.meizu.cloud.pushinternal.DebugLogger;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.notification.c.d */
/* loaded from: classes10.dex */
public class C6084d {
    private static C6084d a;
    private AssetManager b;

    private C6084d(Context context) {
        b(context);
    }

    public static C6084d a(Context context) {
        if (a == null) {
            a = new C6084d(context);
        }
        return a;
    }

    private void b(Context context) {
        this.b = context.getAssets();
    }

    public int a(Context context, String str, String str2) {
        DebugLogger.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return context.getResources().getIdentifier(str, str2, context.getApplicationInfo().packageName);
    }
}
