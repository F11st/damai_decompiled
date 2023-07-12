package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.eu;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bk;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC7535b.c(intent.getPackage() + " is the package name");
        if (XMPushService.m1142e()) {
            return;
        }
        if (!bk.p.equals(intent.getAction())) {
            AbstractC7535b.m586a("cancel the old ping timer");
            eu.a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            AbstractC7535b.c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                ServiceClient.getInstance(context).startServiceSafely(intent2);
            } catch (Exception e) {
                AbstractC7535b.a(e);
            }
        }
    }
}
