package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class COSPushHelper {
    private static long a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f23a;

    public static void convertMessage(Intent intent) {
        C7572i.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f23a;
    }

    public static boolean hasNetwork(Context context) {
        return C7572i.m652a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a2 = C7569f.a(context).a(EnumC7568e.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            AbstractC7535b.m586a("ASSEMBLE_PUSH :  register cos when network change!");
            a2.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f23a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        C7572i.m651a(context, EnumC7568e.ASSEMBLE_PUSH_COS, str);
    }
}
