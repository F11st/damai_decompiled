package com.google.vr.vrcore.base.api;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.vr.cardboard.annotations.UsedByNative;
import java.util.List;
import tb.sc2;
import tb.yd;

/* compiled from: Taobao */
@UsedByNative
/* loaded from: classes10.dex */
public final class VrCoreUtils {
    private static final String a = "VrCoreUtils";

    public static int a(Context context) {
        return b(context);
    }

    private static int b(Context context) {
        if ("com.google.vr.vrcore".equals(context.getPackageName())) {
            return 0;
        }
        try {
            if (context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 0).enabled) {
                return !f(context) ? 9 : 0;
            }
            return 2;
        } catch (PackageManager.NameNotFoundException unused) {
            if (Build.VERSION.SDK_INT >= 21) {
                List<PackageInstaller.SessionInfo> list = null;
                try {
                    list = context.getPackageManager().getPackageInstaller().getAllSessions();
                } catch (NullPointerException e) {
                    String str = a;
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 45);
                    sb.append("Failure querying package installer sessions: ");
                    sb.append(valueOf);
                    Log.w(str, sb.toString());
                }
                if (list != null) {
                    for (PackageInstaller.SessionInfo sessionInfo : list) {
                        if ("com.google.vr.vrcore".equals(sessionInfo.getAppPackageName())) {
                            return 3;
                        }
                    }
                }
            }
            try {
                return context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 8192).enabled ? 3 : 1;
            } catch (PackageManager.NameNotFoundException unused2) {
                return 1;
            }
        }
    }

    public static String c(int i) {
        switch (i) {
            case 0:
                return "VR Service present";
            case 1:
                return "VR Service missing";
            case 2:
                return "VR Service disabled";
            case 3:
                return "VR Service updating";
            case 4:
                return "VR Service obsolete";
            case 5:
                return "VR Service not connected";
            case 6:
                return "No permission to do operation";
            case 7:
                return "This operation is not supported on this device";
            case 8:
                return "An unknown failure occurred";
            default:
                StringBuilder sb = new StringBuilder(38);
                sb.append("Invalid connection result: ");
                sb.append(i);
                return sb.toString();
        }
    }

    public static String d(Context context) throws VrCoreNotAvailableException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 128);
            if (applicationInfo != null) {
                if (applicationInfo.enabled) {
                    Bundle bundle = applicationInfo.metaData;
                    if (bundle != null) {
                        String string = bundle.getString("com.google.vr.vrcore.SdkLibraryVersion", "");
                        if (!string.isEmpty()) {
                            return string.substring(1);
                        }
                        throw new VrCoreNotAvailableException(4);
                    }
                    throw new VrCoreNotAvailableException(4);
                }
                throw new VrCoreNotAvailableException(2);
            }
            throw new VrCoreNotAvailableException(8);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new VrCoreNotAvailableException(a(context));
        }
    }

    public static boolean e(String str) {
        return "com.google.vr.vrcore".equalsIgnoreCase(str);
    }

    private static boolean f(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.vr.vrcore", 64);
        if (sc2.b(packageInfo, sc2.VRCORE_RELEASE_SIGNATURE)) {
            return true;
        }
        if (yd.b(context)) {
            return sc2.b(packageInfo, sc2.VRCORE_DEBUG_SIGNATURE);
        }
        return false;
    }

    @UsedByNative
    public static int getVrCoreClientApiVersion(Context context) throws VrCoreNotAvailableException {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 128);
            if (applicationInfo.enabled) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle.getInt("com.google.vr.vrcore.ClientApiVersion", 0);
                }
                return 0;
            }
            throw new VrCoreNotAvailableException(2);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new VrCoreNotAvailableException(a(context));
        }
    }
}
