package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b.C7084e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.C7121i;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatService;
import com.tencent.stat.common.StatConstants;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* renamed from: com.tencent.connect.a.a */
/* loaded from: classes11.dex */
public class C7036a {
    private static Class<?> a;
    private static Class<?> b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static boolean g;

    public static boolean a(Context context, QQToken qQToken) {
        return C7121i.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f.invoke(a, Boolean.TRUE);
            } else {
                f.invoke(a, Boolean.FALSE);
            }
        } catch (Exception e2) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e2.toString());
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            boolean z = StatConfig.isAutoExceptionCaught;
            a = StatConfig.class;
            int i = StatService.a;
            b = StatService.class;
            c = StatService.class.getMethod("reportQQ", Context.class, String.class);
            d = b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls = b;
            Class<?> cls2 = Integer.TYPE;
            e = cls.getMethod("commitEvents", Context.class, cls2);
            Class<?> cls3 = a;
            Class<?> cls4 = Boolean.TYPE;
            f = cls3.getMethod("setEnableStatService", cls4);
            b(context, qQToken);
            a.getMethod("setAutoExceptionCaught", cls4).invoke(a, Boolean.FALSE);
            a.getMethod("setEnableSmartReporting", cls4).invoke(a, Boolean.TRUE);
            a.getMethod("setSendPeriodMinutes", cls2).invoke(a, 1440);
            StatReportStrategy statReportStrategy = StatReportStrategy.INSTANT;
            a.getMethod("setStatSendStrategy", StatReportStrategy.class).invoke(a, StatReportStrategy.class.getField("PERIOD").get(null));
            b.getMethod("startStatService", Context.class, String.class, String.class).invoke(b, context, str, StatConstants.class.getField("VERSION").get(null));
            g = true;
        } catch (Exception e2) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e2.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            C7084e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", "11", "0", "0", "0");
        }
        if (g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    c.invoke(b, context, qQToken.getOpenId());
                } catch (Exception e2) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e2.toString());
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (g) {
            b(context, qQToken);
            try {
                d.invoke(b, context, str, strArr);
            } catch (Exception e2) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e2.toString());
            }
        }
    }
}
