package com.alibaba.wireless.security.aopsdk;

import android.app.Application;
import android.content.Context;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AopEntry {
    private static final String a = "AopEntry";
    private static boolean b;

    /* loaded from: classes.dex */
    public static class a extends Thread {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Application application = (Application) this.a.getApplicationContext();
                    if (application != null) {
                        com.alibaba.wireless.security.aopsdk.i.a.b(AopEntry.a, "注册Activity生命周期回调");
                        application.registerActivityLifecycleCallbacks(new com.alibaba.wireless.security.aopsdk.a());
                        com.alibaba.wireless.security.aopsdk.h.a.b(true);
                        return;
                    }
                    Thread.sleep(1000L);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    private static void a(Context context) {
        new a(context).start();
    }

    public static void init(Context context) {
        Application application;
        try {
            ConfigManager.getInstance().init(context, true);
            com.alibaba.wireless.security.aopsdk.i.a.a(a, "初始化切面组件");
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            if (application != null) {
                com.alibaba.wireless.security.aopsdk.i.a.b(a, "注册Activity生命周期回调");
                application.registerActivityLifecycleCallbacks(new com.alibaba.wireless.security.aopsdk.a());
                com.alibaba.wireless.security.aopsdk.h.a.b(true);
                return;
            }
            a(context);
        } catch (Throwable th) {
            com.alibaba.wireless.security.aopsdk.i.a.a(a, "Init failed", th);
        }
    }

    public static synchronized void init(Context context, AopInitConfig aopInitConfig) {
        Application application;
        synchronized (AopEntry.class) {
            if (!b) {
                b = true;
                com.alibaba.wireless.security.aopsdk.i.a.a(a, "初始化切面组件");
                ConfigManager.getInstance().init(context, aopInitConfig.shouldFetchConfig());
                HashMap hashMap = new HashMap();
                if (aopInitConfig.isDebug()) {
                    ConfigManager.DEBUG = true;
                    hashMap.put(ConfigManager.LOG_KEY, "1");
                }
                ConfigManager.getInstance().onConfigChanged(hashMap);
                if (aopInitConfig.shouldRegisterLifeCycleListener()) {
                    if (context instanceof Application) {
                        application = (Application) context;
                    } else {
                        application = (Application) context.getApplicationContext();
                    }
                    if (application != null) {
                        com.alibaba.wireless.security.aopsdk.i.a.b(a, "注册Activity生命周期回调");
                        application.registerActivityLifecycleCallbacks(new com.alibaba.wireless.security.aopsdk.a());
                        com.alibaba.wireless.security.aopsdk.h.a.b(true);
                    } else {
                        a(context);
                    }
                }
            } else {
                com.alibaba.wireless.security.aopsdk.i.a.b(a, "请勿重复初始化切面");
            }
        }
    }
}
