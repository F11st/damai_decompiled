package android.taobao.windvane.log;

import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.taobao.tao.log.TTraceLog;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TLogNewImpl implements IWMLog {
    private static boolean newTLogEnable;

    static {
        try {
            int i = TTraceLog.COMMON_EVENT;
            newTLogEnable = true;
        } catch (Throwable th) {
            newTLogEnable = false;
            AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("NewTLogUnSupportWarning");
            if (Build.VERSION.SDK_INT >= 19) {
                androidRuntimeException.addSuppressed(th);
            }
            androidRuntimeException.printStackTrace();
        }
    }

    public static void setTLogEnable(boolean z) {
        newTLogEnable = newTLogEnable && z;
    }

    @Override // android.taobao.windvane.log.IWMLog
    public void writeLog(LogData logData) {
        if (newTLogEnable) {
            TTraceLog.event(logData.getUid(), logData.getPid(), logData.getModule(), logData.getTimestamp(), logData.getEvent(), logData.getErrorCode(), logData.getErrorMsg(), !TextUtils.isEmpty(logData.getExt()) ? logData.getExt() : "");
        }
    }
}
