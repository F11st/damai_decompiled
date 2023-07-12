package cn.damai.commonbusiness.base;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.h4;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class PermissionsHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.base.PermissionsHelper$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class AnonymousClass1 implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String val$permissionTypeMessage;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.commonbusiness.base.PermissionsHelper$1$a */
        /* loaded from: classes14.dex */
        public class DialogInterface$OnClickListenerC0579a implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC0579a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-426712110")) {
                    ipChange.ipc$dispatch("-426712110", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.parse("package:" + AnonymousClass1.this.val$activity.getPackageName()));
                AnonymousClass1.this.val$activity.startActivity(intent);
            }
        }

        AnonymousClass1(Activity activity, String str) {
            this.val$activity = activity;
            this.val$permissionTypeMessage = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1717488064")) {
                ipChange.ipc$dispatch("1717488064", new Object[]{this});
            } else {
                new h4(this.val$activity).e(this.val$permissionTypeMessage).h("去设置", new DialogInterface$OnClickListenerC0579a()).f("不再提示", null).j();
            }
        }
    }

    public static boolean a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-552233472")) {
            return ((Boolean) ipChange.ipc$dispatch("-552233472", new Object[]{context})).booleanValue();
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return notificationManager.areNotificationsEnabled();
        }
        if (i >= 19) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i2 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static void b(final Activity activity, final String str, final String str2, final DialogInterface.OnClickListener onClickListener, final String str3, final DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1030530753")) {
            ipChange.ipc$dispatch("-1030530753", new Object[]{activity, str, str2, onClickListener, str3, onClickListener2});
        } else if (TextUtils.isEmpty(str) || activity == null) {
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.commonbusiness.base.PermissionsHelper.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1520974559")) {
                        ipChange2.ipc$dispatch("1520974559", new Object[]{this});
                    } else {
                        new h4(activity).e(str).h(str2, onClickListener).f(str3, onClickListener2).j();
                    }
                }
            });
        }
    }

    public static void c(final Activity activity, final String str, final boolean z, final String str2, final String str3, final DialogInterface.OnClickListener onClickListener, final String str4, final DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849116737")) {
            ipChange.ipc$dispatch("-1849116737", new Object[]{activity, str, Boolean.valueOf(z), str2, str3, onClickListener, str4, onClickListener2});
        } else if (TextUtils.isEmpty(str2) || activity == null) {
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.damai.commonbusiness.base.PermissionsHelper.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1324461054")) {
                        ipChange2.ipc$dispatch("1324461054", new Object[]{this});
                    } else {
                        new h4(activity).i(str).c(z).e(str2).h(str3, onClickListener).f(str4, onClickListener2).j();
                    }
                }
            });
        }
    }
}
