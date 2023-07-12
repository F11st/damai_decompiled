package com.vivo.push.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7410a;
import com.vivo.push.ServiceConnectionC7412b;
import com.vivo.push.c.C7443d;
import com.vivo.push.util.C7508a;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7527t;
import com.vivo.push.util.C7528u;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.a.a */
/* loaded from: classes11.dex */
public final class C7411a {
    public static void a(Context context, String str, AbstractC7496o abstractC7496o) {
        boolean c = abstractC7496o.c();
        ServiceConnectionC7412b a = ServiceConnectionC7412b.a(context, c ? "com.vivo.vms.upstageservice" : "com.vivo.vms.aidlservice");
        boolean a2 = a.a();
        if (TextUtils.isEmpty(abstractC7496o.a())) {
            abstractC7496o.a(context.getPackageName());
        }
        if (a2 && !"com.vivo.pushservice".equals(context.getPackageName())) {
            C7410a c7410a = new C7410a(abstractC7496o.a(), str, new Bundle());
            abstractC7496o.a(c7410a);
            if (a.a(c7410a.b())) {
                return;
            }
            C7523p.b("CommandBridge", "send command error by aidl");
            C7523p.c(context, "send command error by aidl");
        }
        Intent intent = new Intent("com.vivo.pushservice.action.METHOD");
        intent.setPackage(str);
        intent.setClassName(str, c ? "com.vivo.push.sdk.service.UpstageService" : "com.vivo.push.sdk.service.PushService");
        abstractC7496o.a(intent);
        try {
            a(context, intent);
        } catch (Exception e) {
            C7523p.a("CommandBridge", "CommandBridge startService exception: ", e);
        }
    }

    private static void a(Context context, Intent intent) throws Exception {
        if (context != null) {
            try {
                context.startService(intent);
                return;
            } catch (Exception e) {
                C7523p.a("CommandBridge", "start service error", e);
                intent.setComponent(null);
                context.sendBroadcast(intent);
                return;
            }
        }
        C7523p.d("CommandBridge", "enter startService context is null");
        throw new Exception("context is null");
    }

    public static void a(Context context, AbstractC7496o abstractC7496o, String str) {
        try {
            boolean d = C7527t.d(context, str);
            String str2 = d ? "com.vivo.pushservice.action.RECEIVE" : "com.vivo.pushclient.action.RECEIVE";
            if (!TextUtils.isEmpty(str)) {
                if (d || a(context, str2, str)) {
                    if (TextUtils.isEmpty(abstractC7496o.a())) {
                        abstractC7496o.a(context.getPackageName());
                    }
                    Intent intent = new Intent();
                    intent.setFlags(1048576);
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setAction(str2);
                    }
                    intent.setPackage(str);
                    intent.setClassName(str, d ? "com.vivo.push.sdk.service.CommandService" : "com.vivo.push.sdk.service.CommandClientService");
                    intent.putExtra("security_avoid_pull", C7508a.a(context).a("com.vivo.pushservice"));
                    abstractC7496o.b(intent);
                    intent.putExtra("command_type", "reflect_receiver");
                    if (Build.VERSION.SDK_INT >= 18) {
                        intent.putExtra("security_avoid_pull_rsa", C7443d.a(context).a().a("com.vivo.pushservice"));
                        intent.putExtra("security_avoid_rsa_public_key", C7528u.a(C7443d.a(context).a().a()));
                    }
                    a(context, intent);
                    return;
                }
                return;
            }
            C7523p.c(context, "消息接受者包名为空！");
            throw new Exception("消息接受者包名为空！");
        } catch (Exception e) {
            C7523p.a("CommandBridge", "CommandBridge sendCommandToClient exception", e);
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
            C7523p.b("CommandBridge", "action check error：action>>" + str + ";pkgname>>" + str2);
            return false;
        } catch (Exception unused) {
            C7523p.b("CommandBridge", "queryBroadcastReceivers error");
            return false;
        }
    }
}
