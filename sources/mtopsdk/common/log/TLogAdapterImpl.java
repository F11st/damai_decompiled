package mtopsdk.common.log;

import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogAdapterImpl implements LogAdapter {
    private void loge(String str, String str2, Throwable th) {
        if (th == null) {
            AdapterForTLog.loge(str, str2);
        } else {
            AdapterForTLog.loge(str, str2, th);
        }
    }

    @Override // mtopsdk.common.log.LogAdapter
    public String getLogLevel() {
        return AdapterForTLog.getLogLevel();
    }

    @Override // mtopsdk.common.log.LogAdapter
    public void printLog(int i, String str, String str2, Throwable th) {
        if (i == 1) {
            AdapterForTLog.logv(str, str2);
        } else if (i == 2) {
            AdapterForTLog.logd(str, str2);
        } else if (i == 4) {
            AdapterForTLog.logi(str, str2);
        } else if (i == 8) {
            AdapterForTLog.logw(str, str2, th);
        } else if (i != 16) {
        } else {
            loge(str, str2, th);
        }
    }

    @Override // mtopsdk.common.log.LogAdapter
    public void traceLog(String str, String str2) {
        AdapterForTLog.traceLog(str, str2);
    }
}
