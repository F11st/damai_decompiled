package android.taobao.windvane.log;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WMLogGlobal {
    private static WMLogGlobal global;
    private Context context;
    private List<IWMLog> externalLogHandlers = new ArrayList();

    public static WMLogGlobal getInstance() {
        if (global == null) {
            synchronized (WMLogGlobal.class) {
                if (global == null) {
                    global = new WMLogGlobal();
                }
            }
        }
        return global;
    }

    private boolean isDebugEnvironment() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public void addExternalLogHandler(IWMLog iWMLog) {
        this.externalLogHandlers.add(iWMLog);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void writeLog(LogData logData) {
        if (logData == null) {
            return;
        }
        String logString = logData.toLogString();
        String str = logData.module;
        int i = logData.level;
        if (this.externalLogHandlers.size() == 0 && isDebugEnvironment()) {
            if (i == 2) {
                Log.v(str, logString);
            } else if (i == 3) {
                Log.d(str, logString);
            } else if (i == 4) {
                Log.i(str, logString);
            } else if (i == 5) {
                Log.w(str, logString);
            } else if (i != 6) {
                Log.v(str, logString);
            } else {
                Log.e(str, logString);
            }
        }
        for (IWMLog iWMLog : this.externalLogHandlers) {
            iWMLog.writeLog(logData);
        }
    }
}
