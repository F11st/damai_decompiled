package com.huawei.hms.framework.common.check;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ProviderCheckUtil {
    private static String TAG = "ProviderCheckUtil";

    public static boolean isValid(Uri uri) {
        if (uri != null) {
            PackageManager packageManager = ContextHolder.getAppContext().getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
            if (resolveContentProvider != null) {
                ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
                if (applicationInfo != null) {
                    String str = applicationInfo.packageName;
                    String str2 = TAG;
                    Logger.v(str2, "Target provider service's package name is : " + str);
                    return str != null && packageManager.checkSignatures("com.huawei.hwid", str) == 0;
                }
                return false;
            }
            Logger.w(TAG, "Invalid param");
            return false;
        }
        return false;
    }
}
