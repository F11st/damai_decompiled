package com.ali.user.open.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.ali.user.open.core.callback.InitResultCallback;
import com.ali.user.open.core.config.AuthOption;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.Environment;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.task.InitTask;
import com.ali.user.open.core.util.Validate;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AliMemberSDK {
    public static String sMasterAppkey;
    private static String sMasterSite;
    public static String ttid;

    public static String getMasterSite() {
        return sMasterSite;
    }

    public static <T> T getService(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return (T) KernelContext.serviceRegistry.getService(cls, null);
    }

    public static synchronized void init(Context context, InitResultCallback initResultCallback) {
        synchronized (AliMemberSDK.class) {
            if (KernelContext.sdkInitialized.booleanValue()) {
                if (initResultCallback != null) {
                    initResultCallback.onSuccess();
                }
                return;
            }
            Validate.notNull(context, WPKFactory.INIT_KEY_CONTEXT);
            KernelContext.applicationContext = context.getApplicationContext();
            KernelContext.executorService.postHandlerTask(new FutureTask(new InitTask(initResultCallback)));
        }
    }

    public static void setAuthOption(AuthOption authOption) {
        KernelContext.authOption = authOption;
    }

    public static void setEnvironment(Environment environment) {
        ConfigManager.getInstance().setEnvironment(environment);
    }

    public static void setMasterSite(String str) {
        sMasterSite = str;
    }

    public static void setPackageName(String str) {
        KernelContext.packageName = str;
    }

    public static void setResources(Resources resources) {
        KernelContext.resources = resources;
    }

    public static void setTtid(String str) {
        ttid = str;
    }

    public static void setUUID(String str) {
        KernelContext.UUID = str;
    }

    public static void turnOnDebug() {
        Log.w("AliMemberSDK", "************************************\nDebug is enabled, make sure to turn it off in the production environment\n************************************");
        ConfigManager.DEBUG = true;
    }

    public static synchronized void init(Context context, String str, InitResultCallback initResultCallback) {
        synchronized (AliMemberSDK.class) {
            sMasterSite = str;
            init(context, initResultCallback);
        }
    }
}
