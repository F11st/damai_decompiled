package com.ali.user.mobile.login.ui;

import android.app.Activity;
import com.ali.user.mobile.common.api.AliUserLogin;
import com.ali.user.mobile.common.api.LoginApprearanceExtensions;
import com.ali.user.mobile.service.PermissionService;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class PermissionUtils {
    public static void onActivityResult(Activity activity, String str) {
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.getPermissionHelper() == null) {
                return;
            }
            ((PermissionService) AliUserLogin.mAppreanceExtentions.getPermissionHelper().newInstance()).onActivityResult(activity, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onResume(Activity activity, String str) {
        try {
            LoginApprearanceExtensions loginApprearanceExtensions = AliUserLogin.mAppreanceExtentions;
            if (loginApprearanceExtensions == null || loginApprearanceExtensions.getPermissionHelper() == null) {
                return;
            }
            ((PermissionService) AliUserLogin.mAppreanceExtentions.getPermissionHelper().newInstance()).onResume(activity, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
