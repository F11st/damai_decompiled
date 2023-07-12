package com.alibaba.security.common.d;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.security.realidentity.a.AbstractC3840a;
import com.taobao.runtimepermission.PermissionUtil;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.common.d.m */
/* loaded from: classes8.dex */
public final class C3819m {
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
        buildPermissionTask.setBizName(AbstractC3840a.I);
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
