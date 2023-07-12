package android.taobao.windvane.util;

import android.app.Application;
import android.content.res.Resources;
import android.taobao.windvane.config.GlobalConfig;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class EnvUtil {
    private static boolean DEBUG;
    private static boolean inited;
    private static boolean openSpdyforDebug;

    private static synchronized void init() {
        synchronized (EnvUtil.class) {
            if (!inited) {
                try {
                    Application application = GlobalConfig.context;
                    if (application != null) {
                        DEBUG = (application.getApplicationInfo().flags & 2) != 0;
                        inited = true;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean isAppDebug() {
        if (!inited) {
            init();
        }
        return DEBUG;
    }

    public static boolean isCN() {
        try {
            return Resources.getSystem().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isDebug() {
        return TaoLog.getLogStatus() && isAppDebug();
    }

    public static boolean isOpenSpdyforDebug() {
        return openSpdyforDebug;
    }

    public static boolean isTaobao() {
        Application application = GlobalConfig.context;
        if (application != null) {
            return "com.taobao.taobao".equals(application.getPackageName());
        }
        return false;
    }

    public static void setOpenSpdyforDebug(boolean z) {
        openSpdyforDebug = z;
    }
}
