package com.huawei.hms.push;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.push.l */
/* loaded from: classes10.dex */
public class C5691l {
    public static int a(Context context) {
        int i = context.getApplicationInfo().icon;
        if (i == 0) {
            int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
            HMSLog.d("PushSelfShowLog", "icon is btn_star_big_on ");
            if (identifier == 0) {
                HMSLog.d("PushSelfShowLog", "icon is sym_def_app_icon ");
                return 17301651;
            }
            return identifier;
        }
        return i;
    }

    public static int b(Context context, C5690k c5690k) {
        int i = 0;
        if (context != null && c5690k != null) {
            if (!TextUtils.isEmpty(c5690k.m())) {
                String[] split = c5690k.m().split("/");
                if (split.length == 3) {
                    i = C5697r.a(context, split[1], split[2]);
                }
            }
            if (i == 0) {
                i = C5697r.a(context, "com.huawei.messaging.default_notification_icon");
            }
            return i != 0 ? i : a(context);
        }
        HMSLog.i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
        return 0;
    }

    public static Bitmap a(Context context, C5690k c5690k) {
        if (context == null || c5690k == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            } else if ("com.huawei.android.pushagent".equals(c5690k.k())) {
                return null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("get left bitmap from ");
                sb.append(c5690k.k());
                HMSLog.i("PushSelfShowLog", sb.toString());
                return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(c5690k.k())).getBitmap();
            }
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.e("PushSelfShowLog", "build left icon occur NameNotFoundException.");
            return null;
        } catch (Exception unused2) {
            HMSLog.e("PushSelfShowLog", "build left icon occur Exception.");
            return null;
        }
    }

    @TargetApi(23)
    public static void a(Context context, Notification.Builder builder, C5690k c5690k) {
        if (context != null && builder != null && c5690k != null) {
            builder.setSmallIcon(b(context, c5690k));
        } else {
            HMSLog.e("PushSelfShowLog", "msg is null");
        }
    }
}
