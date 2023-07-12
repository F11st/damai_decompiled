package com.taobao.accs.ut.statistics;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MonitorStatistic implements UTInterface {
    private static final long COMMIT_INTERVAL = 1200000;
    private static final String PAGE = "MONITOR";
    private static final String TAG = "MonitorStatistic";
    public int connType;
    public boolean networkAvailable;
    public String proxy;
    public long startServiceTime;
    public int status;
    public boolean threadIsalive;
    public String url;
    private long lastCommitTime = 0;
    public boolean tcpConnected = false;
    public int messageNum = 0;
    public int unHandleMessageNum = 0;

    @Override // com.taobao.accs.ut.statistics.UTInterface
    public void commitUT() {
        String str;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d(TAG, "commitUT interval:" + (currentTimeMillis - this.lastCommitTime) + " interval1:" + (currentTimeMillis - this.startServiceTime), new Object[0]);
        }
        if (currentTimeMillis - this.lastCommitTime <= COMMIT_INTERVAL || currentTimeMillis - this.startServiceTime <= DateUtils.MILLIS_PER_MINUTE) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str3 = null;
        try {
            String valueOf = String.valueOf(this.messageNum);
            try {
                str2 = String.valueOf(this.unHandleMessageNum);
                try {
                    str = String.valueOf((int) Constants.SDK_VERSION_CODE);
                    try {
                        hashMap.put("connStatus", String.valueOf(this.status));
                        hashMap.put("connType", String.valueOf(this.connType));
                        hashMap.put("tcpConnected", String.valueOf(this.tcpConnected));
                        hashMap.put("proxy", String.valueOf(this.proxy));
                        hashMap.put("startServiceTime", String.valueOf(this.startServiceTime));
                        hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                        hashMap.put("networkAvailable", String.valueOf(this.networkAvailable));
                        hashMap.put("threadIsalive", String.valueOf(this.threadIsalive));
                        hashMap.put("url", this.url);
                        if (ALog.isPrintLog(level)) {
                            try {
                                ALog.d(TAG, UTMini.getCommitInfo(66001, valueOf, str2, str, hashMap), new Object[0]);
                            } catch (Throwable th) {
                                th = th;
                                str3 = valueOf;
                                ALog.d(TAG, UTMini.getCommitInfo(66001, str3, str2, str, hashMap) + " " + th.toString(), new Object[0]);
                            }
                        }
                        try {
                            UTMini.getInstance().commitEvent(66001, PAGE, valueOf, str2, str, hashMap);
                            this.lastCommitTime = currentTimeMillis;
                        } catch (Throwable th2) {
                            th = th2;
                            str3 = valueOf;
                            str = str;
                            str2 = str2;
                            ALog.d(TAG, UTMini.getCommitInfo(66001, str3, str2, str, hashMap) + " " + th.toString(), new Object[0]);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = null;
                }
            } catch (Throwable th5) {
                th = th5;
                str = null;
                str2 = null;
            }
        } catch (Throwable th6) {
            th = th6;
            str = null;
            str2 = null;
        }
    }
}
