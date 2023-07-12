package com.alibaba.security.biometrics.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3818l;
import com.alibaba.security.common.d.C3823p;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.c.e */
/* loaded from: classes8.dex */
public final class C3758e {
    public static void a(Context context) {
        if (C3823p.a()) {
            f(context);
        } else if (C3823p.e()) {
            e(context);
        } else if (C3823p.c()) {
            g(context);
        } else if (C3823p.d()) {
            c(context);
        } else if (C3823p.b()) {
            b(context);
        } else {
            d(context);
        }
    }

    private static void b(Context context) {
        try {
            String model = Build.getMODEL();
            if ((model.contains("Y85") && !model.contains("Y85A")) || model.contains("vivo Y53L")) {
                Intent intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity");
                intent.putExtra("packagename", C3818l.a(context));
                intent.putExtra("tabId", "1");
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent2.setAction("secure.intent.action.softPermissionDetail");
            intent2.putExtra("packagename", C3818l.a(context));
            context.startActivity(intent2);
        } catch (Exception unused) {
            d(context);
        }
    }

    private static void c(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", C3818l.a(context));
            intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
            context.startActivity(intent);
        } catch (Exception unused) {
            d(context);
        }
    }

    private static void d(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", C3818l.a(context), null));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
            C3800a.b();
        }
    }

    private static void e(Context context) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", C3818l.a(context));
            context.startActivity(intent);
        } catch (Exception unused) {
            d(context);
        }
    }

    private static void f(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("packageName", C3818l.a(context));
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            context.startActivity(intent);
        } catch (Exception unused) {
            d(context);
        }
    }

    private static void g(Context context) {
        try {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity"));
            intent.putExtra("extra_pkgname", C3818l.a(context));
            context.startActivity(intent);
        } catch (Exception unused) {
            d(context);
        }
    }
}
