package com.taobao.securityjni;

import android.content.Context;
import android.content.ContextWrapper;
import com.taobao.wireless.security.sdk.SecurityGuardManager;
import com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public final class GlobalInit {
    private static Context globalContext;
    private static String sAppKey;

    public static synchronized String GetGlobalAppKey() {
        String str;
        synchronized (GlobalInit.class) {
            str = sAppKey;
        }
        return str;
    }

    public static void GlobalSecurityInitAsync(ContextWrapper contextWrapper) {
        GlobalSecurityInitAsync(contextWrapper, null);
    }

    public static void GlobalSecurityInitAsyncSDK(ContextWrapper contextWrapper) {
        globalContext = contextWrapper;
        SecurityGuardManager.getInitializer().loadLibraryAsync(contextWrapper, null);
        SecurityGuardManager.getInstance(contextWrapper);
    }

    public static void GlobalSecurityInitAsyncSo(ContextWrapper contextWrapper) {
        globalContext = contextWrapper;
    }

    public static void GlobalSecurityInitSync(ContextWrapper contextWrapper) {
        GlobalSecurityInitSync(contextWrapper, null);
    }

    public static void GlobalSecurityInitSyncSDK(ContextWrapper contextWrapper) {
        globalContext = contextWrapper;
        if (SecurityGuardManager.getInitializer().loadLibrarySync(contextWrapper, null) != 0) {
            return;
        }
        SecurityGuardManager.getInstance(contextWrapper);
    }

    public static void GlobalSecurityInitSyncSo(ContextWrapper contextWrapper) {
        GlobalSecurityInitSyncSo(contextWrapper, null);
    }

    public static synchronized void SetGlobalAppKey(String str) {
        synchronized (GlobalInit.class) {
            sAppKey = str;
        }
    }

    public static Context getGlobalContext() {
        return globalContext;
    }

    private static void initSecBody(ContextWrapper contextWrapper) {
        ISecurityBodyComponent securityBodyComp;
        SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(contextWrapper);
        if (securityGuardManager == null || (securityBodyComp = securityGuardManager.getSecurityBodyComp()) == null) {
            return;
        }
        String GetGlobalAppKey = GetGlobalAppKey();
        if (GetGlobalAppKey == null) {
            GetGlobalAppKey = securityGuardManager.getStaticDataStoreComp().getAppKeyByIndex(0);
        }
        securityBodyComp.initSecurityBody(GetGlobalAppKey);
    }

    public static void setEnableOutPutExpInfo(boolean z) {
    }

    public static void GlobalSecurityInitAsync(ContextWrapper contextWrapper, String str) {
        globalContext = contextWrapper;
        SecurityGuardManager.getInitializer().loadLibraryAsync(contextWrapper, str);
    }

    public static void GlobalSecurityInitAsyncSo(ContextWrapper contextWrapper, String str) {
        globalContext = contextWrapper;
        SecurityGuardManager.getInitializer().loadLibraryAsync(contextWrapper, str);
        SecurityGuardManager.getInstance(contextWrapper);
    }

    public static void GlobalSecurityInitSync(ContextWrapper contextWrapper, String str) {
        globalContext = contextWrapper;
        SecurityGuardManager.getInitializer().loadLibrarySync(contextWrapper, str);
    }

    public static void GlobalSecurityInitSyncSo(ContextWrapper contextWrapper, String str) {
        globalContext = contextWrapper;
        if (SecurityGuardManager.getInitializer().loadLibrarySync(contextWrapper, str) != 0) {
            return;
        }
        SecurityGuardManager.getInstance(contextWrapper);
    }
}
