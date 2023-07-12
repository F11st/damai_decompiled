package com.youku.alixplayer.util;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SystemUtil {
    private static Context sApplicationContext;

    public static Context getApplicationContext() {
        if (sApplicationContext == null) {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
                declaredMethod.setAccessible(true);
                sApplicationContext = ((Application) declaredMethod.invoke(null, new Object[0])).getApplicationContext();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return sApplicationContext;
    }

    public static void setApplicationContext(Context context) {
        if (sApplicationContext == null) {
            sApplicationContext = context.getApplicationContext();
        }
    }
}
