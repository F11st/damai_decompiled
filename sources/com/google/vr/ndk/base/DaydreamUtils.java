package com.google.vr.ndk.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DaydreamUtils {
    public static final int DAYDREAM_NOT_SUPPORTED = 1;
    public static final int DAYDREAM_OPTIONAL = 2;
    public static final int DAYDREAM_REQUIRED = 3;
    private static boolean sDaydreamPhoneOverrideForTesting;

    private static boolean canResolveIntent(PackageManager packageManager, ComponentName componentName, Intent intent) {
        ActivityInfo activityInfo;
        String str;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 128);
        if (queryIntentActivities != null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && (str = activityInfo.name) != null && str.equals(componentName.getClassName())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static int getComponentDaydreamCompatibility(Context context, ComponentName componentName) {
        return getComponentDaydreamCompatibility(context, context.getPackageManager(), componentName);
    }

    public static boolean isDaydreamPhone(Context context) {
        if (sDaydreamPhoneOverrideForTesting) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        return context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance");
    }

    static int getComponentDaydreamCompatibility(Context context, PackageManager packageManager, ComponentName componentName) {
        Intent intent = new Intent();
        intent.setPackage(componentName.getPackageName());
        intent.addCategory("com.google.intent.category.DAYDREAM");
        if (canResolveIntent(packageManager, componentName, intent)) {
            Intent intent2 = new Intent();
            intent2.setPackage(componentName.getPackageName());
            intent2.addCategory("com.google.intent.category.CARDBOARD");
            return canResolveIntent(packageManager, componentName, intent2) ? 2 : 3;
        }
        return 1;
    }
}
