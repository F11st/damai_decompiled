package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FTOSPushHelper {
    private static long a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f24a;

    private static void a(Context context) {
        AbstractPushManager a2 = C7569f.a(context).a(EnumC7568e.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            AbstractC7535b.m586a("ASSEMBLE_PUSH :  register fun touch os when network change!");
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
        return C7572i.m652a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a2 = C7572i.a(context)) == null) {
            return;
        }
        MiPushMessage a3 = C7572i.a(str);
        if (a3.getExtra().containsKey("notify_effect")) {
            return;
        }
        a2.onNotificationMessageClicked(context, a3);
    }

    public static void setNeedRegister(boolean z) {
        f24a = z;
    }

    public static void uploadToken(Context context, String str) {
        C7572i.m651a(context, EnumC7568e.ASSEMBLE_PUSH_FTOS, str);
    }
}
