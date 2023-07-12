package com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SCLogCatFactory {
    private static SCLogCatInterface a;

    public static SCLogCatInterface getSCLog() {
        SCLogCatInterface sCLogCatInterface = a;
        if (sCLogCatInterface != null) {
            return sCLogCatInterface;
        }
        synchronized (SCLogCatFactory.class) {
            SCLogCatInterface sCLogCatInterface2 = a;
            if (sCLogCatInterface2 != null) {
                return sCLogCatInterface2;
            }
            if (!PlatformUtil.isAndroidPlatform()) {
                a = PlatformUtil.createJavaLogImpl();
            } else if (PlatformUtil.isAndroidMPaaSPlatform()) {
                a = PlatformUtil.createAndroidMPaaSLogImpl();
            } else {
                a = PlatformUtil.createAndroidLogImpl();
            }
            return a;
        }
    }

    public static void setLogImpl(SCLogCatInterface sCLogCatInterface) {
        a = sCLogCatInterface;
    }
}
