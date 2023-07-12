package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.b;
import com.vivo.push.c.d;
import com.vivo.push.o;
import com.vivo.push.util.p;
import com.vivo.push.util.t;
import com.vivo.push.util.u;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class a {
    public static void a(Context context, String str, o oVar) {
        boolean c = oVar.c();
        b a = b.a(context, c ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean a2 = a.a();
        if (TextUtils.isEmpty(oVar.a())) {
            oVar.a(context.getPackageName());
        }
        if (a2 && !"com.vivo.pushservice".equals(context.getPackageName())) {
            com.vivo.push.a aVar = new com.vivo.push.a(oVar.a(), str, new Bundle());
            oVar.a(aVar);
            if (a.a(aVar.b())) {
                return;
            }
            p.b("CommandBridge", "send command error by aidl");
            p.c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, c ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        oVar.a(intent);
        try {
            a(context, intent);
        } catch (Exception e) {
            p.a("CommandBridge", "CommandBridge startService exception: ", e);
        }
    }

    private static void a(Context context, Intent intent) throws Exception {
        if (context != null) {
            try {
                context.startService(intent);
                return;
            } catch (Exception e) {
                p.a("CommandBridge", "start service error", e);
                intent.setComponent(null);
                context.sendBroadcast(intent);
                return;
            }
        }
        p.d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    }

    public static void a(Context context, o oVar, String str) {
        try {
            boolean d = t.d(context, str);
            String str2 = d ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (!TextUtils.isEmpty(str)) {
                if (d || a(context, str2, str)) {
                    if (TextUtils.isEmpty(oVar.a())) {
                        oVar.a(context.getPackageName());
                    }
                    Intent intent = new Intent();
                    intent.setFlags(1048576);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setAction(str2);
                    }
                    intent.setPackage(str);
                    intent.setClassName(str, d ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                    intent.putExtra("security_avoid_pull", com.vivo.push.util.a.a(context).a("com.vivo.pushservice"));
                    oVar.b(intent);
                    intent.putExtra("command_type", "reflect_receiver");
                    if (Build.VERSION.SDK_INT >= 18) {
                        intent.putExtra("security_avoid_pull_rsa", d.a(context).a().a("com.vivo.pushservice"));
                        intent.putExtra("security_avoid_rsa_public_key", u.a(d.a(context).a().a()));
                    }
                    a(context, intent);
                    return;
                }
                return;
            }
            p.c(context, "消息接受者包名为空！");
            throw new Exception("消息接受者包名为空！");
        } catch (Exception e) {
            p.a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
        }
    }

    private static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                return true;
            }
            p.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            p.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
