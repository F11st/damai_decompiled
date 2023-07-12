package tb;

import com.taobao.monitor.logger.IDataLogger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class e30 {
    private static IDataLogger a;

    public static void a(String str, Object... objArr) {
        IDataLogger iDataLogger = a;
        if (iDataLogger != null) {
            iDataLogger.log(str, objArr);
        }
    }

    public static void b(IDataLogger iDataLogger) {
        a = iDataLogger;
    }
}
