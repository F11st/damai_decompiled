package mtopsdk.extra.antiattack;

import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class LogTool {
    public static final int D = 2;
    public static final int E = 16;
    public static final int I = 4;
    public static final int N = 32;
    public static final int V = 1;
    public static final int W = 8;
    public static volatile boolean mEnableLog = true;
    public static volatile boolean mEnableTLog = true;
    public static volatile int mLogLevel = 4;

    private LogTool() {
    }

    public static int print(int i, String str, String str2, Throwable th) {
        if (mEnableLog) {
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (i == 1) {
                if (mEnableTLog) {
                    AdapterForTLog.logv(str, str2);
                    return 0;
                }
                return Log.v(str, str2);
            } else if (i == 2) {
                if (mEnableTLog) {
                    AdapterForTLog.logd(str, str2);
                    return 0;
                }
                return Log.d(str, str2);
            } else if (i == 4) {
                if (mEnableTLog) {
                    AdapterForTLog.logi(str, str2);
                    return 0;
                }
                return Log.i(str, str2);
            } else if (i == 8) {
                if (mEnableTLog) {
                    AdapterForTLog.logw(str, str2, th);
                    return 0;
                }
                return Log.w(str, str2, th);
            } else {
                if (i == 16) {
                    if (mEnableTLog) {
                        AdapterForTLog.loge(str, str2, th);
                        return 0;
                    }
                    return Log.e(str, str2, th);
                }
                return 0;
            }
        }
        return 0;
    }
}
