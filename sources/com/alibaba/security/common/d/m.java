package com.alibaba.security.common.d;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.taobao.runtimepermission.PermissionUtil;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class m {
    public static boolean a(Context context, String... strArr) {
        for (int i = 0; i <= 0; i++) {
            if (!a(context, strArr[0])) {
                return false;
            }
        }
        return true;
    }

    public static void a(Activity activity, String[] strArr, int i, String str, Runnable runnable, Runnable runnable2) {
        if (!a()) {
            ActivityCompat.requestPermissions(activity, strArr, i);
        } else {
            a(activity, strArr, str, runnable, runnable2);
        }
    }

    private static void a(Activity activity, String[] strArr, String str, Runnable runnable, Runnable runnable2) {
        PermissionUtil.PermissionRequestTask buildPermissionTask = PermissionUtil.buildPermissionTask(activity, strArr);
        buildPermissionTask.setRationalStr(str);
        buildPermissionTask.setShowRational(true);
        buildPermissionTask.setBizName(com.alibaba.security.realidentity.a.a.I);
        buildPermissionTask.setTaskOnPermissionDenied(runnable2);
        buildPermissionTask.setTaskOnPermissionGranted(runnable);
        buildPermissionTask.execute();
    }

    private static boolean a(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    private static boolean a() {
        try {
            Class.forName("com.taobao.runtimepermission.PermissionUtil");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
