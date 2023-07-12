package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.service.C7761l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ek implements eg {
    private void a(Service service, Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                dz.a(service.getApplicationContext(), "service", 1007, "old version message");
            } else if (TextUtils.isEmpty(stringExtra2)) {
                dz.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
            } else {
                String b = dy.b(stringExtra2);
                boolean isEmpty = TextUtils.isEmpty(b);
                Context applicationContext = service.getApplicationContext();
                if (isEmpty) {
                    dz.a(applicationContext, "service", 1008, "B get a incorrect message");
                } else {
                    dz.a(applicationContext, b, 1007, "old version message ");
                }
            }
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                dz.a(context, "service", 1008, "argument error");
            } else {
                dz.a(context, str3, 1008, "argument error");
            }
        } else if (!C7761l.a(context, str)) {
            dz.a(context, str3, 1003, "B is not ready");
        } else {
            dz.a(context, str3, 1002, "B is ready");
            dz.a(context, str3, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                intent.putExtra("waker_pkgname", context.getPackageName());
                intent.putExtra("awake_info", dy.a(str3));
                if (context.startService(intent) == null) {
                    dz.a(context, str3, 1008, "A is fail to help B's service");
                    return;
                }
                dz.a(context, str3, 1005, "A is successful");
                dz.a(context, str3, 1006, "The job is finished");
            } catch (Exception e) {
                AbstractC7535b.a(e);
                dz.a(context, str3, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            return;
        }
        a((Service) context, intent);
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, ec ecVar) {
        if (ecVar != null) {
            a(context, ecVar.m853a(), ecVar.c(), ecVar.d());
        }
    }
}
