package com.youku.live.arch.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.Arch;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AppUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean checkPackageInfo(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "612148597")) {
            return ((Boolean) ipChange.ipc$dispatch("612148597", new Object[]{context, str})).booleanValue();
        }
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static String getAppVersionName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1630437669") ? (String) ipChange.ipc$dispatch("-1630437669", new Object[0]) : getAppVersionName(Arch.getApp().getPackageName());
    }

    private static boolean isSpace(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "335684879")) {
            return ((Boolean) ipChange.ipc$dispatch("335684879", new Object[]{str})).booleanValue();
        }
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean openPackage(Context context, String str) {
        Intent launchIntentForPackage;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1017020395")) {
            return ((Boolean) ipChange.ipc$dispatch("-1017020395", new Object[]{context, str})).booleanValue();
        }
        if (context == null || TextUtils.isEmpty(str) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) == null) {
            return false;
        }
        context.startActivity(launchIntentForPackage);
        return true;
    }

    public static String getAppVersionName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2117462417")) {
            return (String) ipChange.ipc$dispatch("2117462417", new Object[]{str});
        }
        if (isSpace(str)) {
            return null;
        }
        try {
            PackageInfo packageInfo = Arch.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
