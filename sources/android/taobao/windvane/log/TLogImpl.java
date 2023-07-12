package android.taobao.windvane.log;

import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.log.ILog;
import android.util.Log;
import com.taobao.tao.log.TLog;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.io.File;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TLogImpl implements ILog {
    private static final String DELIMITER = "\n";
    private static final String LOG_MODULE_NAME = "WindVane";
    private static boolean tlogEnable = true;
    private boolean releaseOpen;

    public TLogImpl() {
        this.releaseOpen = false;
        TaoLog.setLogSwitcher(true);
        this.releaseOpen = (!EnvUtil.isAppDebug() && new File("/data/local/tmp/", ".release_open").exists()) || new File("/data/local/tmp/", ".all_windvane_log_open").exists();
        TaoLog.setTagPre("");
    }

    public static boolean isTlogEnable() {
        boolean z;
        try {
            z = WVCommonConfig.commonConfig.openTLog;
        } catch (Throwable unused) {
            z = true;
        }
        return tlogEnable && z;
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void d(String str, String str2) {
        if (isTlogEnable()) {
            TLog.logd("WindVane", str, str2);
            if (this.releaseOpen) {
                Log.d(str, str2);
                return;
            }
            return;
        }
        Log.d(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void e(String str, String str2) {
        if (isTlogEnable()) {
            TLog.loge("WindVane", str, str2);
            if (this.releaseOpen) {
                Log.e(str, str2);
                return;
            }
            return;
        }
        Log.e(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void i(String str, String str2) {
        if (isTlogEnable()) {
            TLog.logi("WindVane", str, str2);
            if (this.releaseOpen) {
                Log.i(str, str2);
                return;
            }
            return;
        }
        Log.i(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public boolean isLogLevelEnabled(int i) {
        Map<String, Integer> map;
        if (EnvUtil.isAppDebug()) {
            return true;
        }
        String logLevel = AdapterForTLog.getLogLevel();
        return (logLevel == null || (map = TaoLog.LogLevel) == null || map.get(logLevel) == null || TaoLog.LogLevel.get(logLevel).intValue() > i) ? false : true;
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void log(int i, String str, String str2) {
        if (i == 3) {
            d(str, str2);
        } else if (i == 4) {
            i(str, str2);
        } else if (i == 5) {
            w(str, str2);
        } else if (i != 6) {
            v(str, str2);
        } else {
            e(str, str2);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void v(String str, String str2) {
        if (isTlogEnable()) {
            TLog.logv("WindVane", str, str2);
            if (this.releaseOpen) {
                Log.v(str, str2);
                return;
            }
            return;
        }
        Log.v(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void w(String str, String str2) {
        if (isTlogEnable()) {
            TLog.logw("WindVane", str, str2);
            if (this.releaseOpen) {
                Log.w(str, str2);
                return;
            }
            return;
        }
        Log.w(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void d(String str, String str2, Throwable th) {
        if (isTlogEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("\n");
            sb.append(th);
            TLog.logd("WindVane", str, sb.toString() != null ? th.getMessage() : "throwable is null");
            if (this.releaseOpen) {
                Log.d(str, str2, th);
                return;
            }
            return;
        }
        Log.d(str, str2, th);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void e(String str, String str2, Throwable th) {
        if (isTlogEnable()) {
            TLog.loge("WindVane", str, str2, th);
            if (this.releaseOpen) {
                Log.e(str, str2, th);
                return;
            }
            return;
        }
        Log.e(str, str2, th);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void i(String str, String str2, Throwable th) {
        if (isTlogEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("\n");
            sb.append(th);
            TLog.logi("WindVane", str, sb.toString() != null ? th.getMessage() : "throwable is null");
            if (this.releaseOpen) {
                Log.i(str, str2, th);
                return;
            }
            return;
        }
        Log.i(str, str2, th);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void v(String str, String str2, Throwable th) {
        if (isTlogEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("\n");
            sb.append(th);
            TLog.logv("WindVane", str, sb.toString() != null ? th.getMessage() : "throwable is null");
            if (this.releaseOpen) {
                Log.v(str, str2, th);
                return;
            }
            return;
        }
        Log.v(str, str2, th);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void w(String str, String str2, Throwable th) {
        if (isTlogEnable()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("\n");
            sb.append(th);
            TLog.logw("WindVane", str, sb.toString() != null ? th.getMessage() : "throwable is null");
            if (this.releaseOpen) {
                Log.w(str, str2, th);
                return;
            }
            return;
        }
        Log.w(str, str2, th);
    }
}
