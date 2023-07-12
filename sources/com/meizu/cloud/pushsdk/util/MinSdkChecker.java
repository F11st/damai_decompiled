package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MinSdkChecker {
    public static boolean isSupportBigTextStyleAndAction() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean isSupportDeviceDefaultLight() {
        return Build.VERSION.SDK_INT >= 14;
    }

    public static boolean isSupportKeyguardState() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean isSupportNotificationBuild() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean isSupportNotificationChannel() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportNotificationSort() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportSendNotification() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean isSupportSetDrawableSmallIcon() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportTransmitMessageValue(Context context, String str) {
        return !TextUtils.isEmpty(MzSystemUtils.findReceiver(context, PushConstants.MZ_PUSH_SYSTEM_RECEIVER_ACTION, str));
    }

    public static boolean isSupportVideoNotification() {
        return Build.VERSION.SDK_INT >= 19;
    }
}
