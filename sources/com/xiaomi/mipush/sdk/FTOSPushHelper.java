package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FTOSPushHelper {
    private static long a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f24a;

    private static void a(Context context) {
        AbstractPushManager a2 = f.a(context).a(e.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            com.xiaomi.channel.commonutils.logger.b.m586a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a2.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f24a;
    }

    public static boolean hasNetwork(Context context) {
        return i.m652a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a2 = i.a(context)) == null) {
            return;
        }
        MiPushMessage a3 = i.a(str);
        if (a3.getExtra().containsKey("notify_effect")) {
            return;
        }
        a2.onNotificationMessageClicked(context, a3);
    }

    public static void setNeedRegister(boolean z) {
        f24a = z;
    }

    public static void uploadToken(Context context, String str) {
        i.m651a(context, e.ASSEMBLE_PUSH_FTOS, str);
    }
}
