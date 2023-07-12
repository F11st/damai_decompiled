package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.service.C7761l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ei implements eg {
    private void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                String[] split = str.split("/");
                if (split.length > 0 && !TextUtils.isEmpty(split[split.length - 1])) {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        dz.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String decode = Uri.decode(str2);
                    if (TextUtils.isEmpty(decode)) {
                        dz.a(context, "provider", 1008, "B get a incorrect message");
                        return;
                    }
                    String b = dy.b(decode);
                    if (!TextUtils.isEmpty(b)) {
                        dz.a(context, b, 1007, "play with provider successfully");
                        return;
                    }
                }
            }
            dz.a(context, "provider", 1008, "B get a incorrect message");
        } catch (Exception e) {
            dz.a(context, "provider", 1008, "B meet a exception" + e.getMessage());
        }
    }

    private void b(Context context, ec ecVar) {
        String b = ecVar.b();
        String d = ecVar.d();
        int a = ecVar.a();
        if (context == null || TextUtils.isEmpty(b) || TextUtils.isEmpty(d)) {
            if (TextUtils.isEmpty(d)) {
                dz.a(context, "provider", 1008, "argument error");
            } else {
                dz.a(context, d, 1008, "argument error");
            }
        } else if (!C7761l.b(context, b)) {
            dz.a(context, d, 1003, "B is not ready");
        } else {
            dz.a(context, d, 1002, "B is ready");
            dz.a(context, d, 1004, "A is ready");
            String a2 = dy.a(d);
            try {
                if (TextUtils.isEmpty(a2)) {
                    dz.a(context, d, 1008, "info is empty");
                } else if (a == 1 && !ed.m854a(context)) {
                    dz.a(context, d, 1008, "A not in foreground");
                } else {
                    String type = context.getContentResolver().getType(dy.a(b, a2));
                    if (TextUtils.isEmpty(type) || !"success".equals(type)) {
                        dz.a(context, d, 1008, "A is fail to help B's provider");
                        return;
                    }
                    dz.a(context, d, 1005, "A is successful");
                    dz.a(context, d, 1006, "The job is finished");
                }
            } catch (Exception e) {
                AbstractC7535b.a(e);
                dz.a(context, d, 1008, "A meet a exception when help B's provider");
            }
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // com.xiaomi.push.eg
    public void a(Context context, ec ecVar) {
        if (ecVar != null) {
            b(context, ecVar);
        } else {
            dz.a(context, "provider", 1008, "A receive incorrect message");
        }
    }
}
