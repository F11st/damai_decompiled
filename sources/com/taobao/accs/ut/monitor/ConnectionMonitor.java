package com.taobao.accs.ut.monitor;

import android.os.SystemClock;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.aranger.utils.IPCUtils;

/* compiled from: Taobao */
@Monitor(module = "accs", monitorPoint = "conn_performance")
/* loaded from: classes8.dex */
public class ConnectionMonitor extends BaseMonitor {
    @Measure
    public long authRespTimeInMill;
    @Measure
    public long authUrlGenerateTimeInMill;
    @Dimension
    public String process = IPCUtils.getCurrentProcessName();
    @Measure
    public long serverRtInMill;
    private long startAuthTimeInMill;

    public void authFinish(long j) {
        if (this.startAuthTimeInMill > 0) {
            this.authRespTimeInMill = SystemClock.elapsedRealtime() - this.startAuthTimeInMill;
        }
        this.serverRtInMill = j;
    }

    public void authUrlGenerated() {
        if (this.startAuthTimeInMill > 0) {
            this.authUrlGenerateTimeInMill = SystemClock.elapsedRealtime() - this.startAuthTimeInMill;
        }
    }

    public void startAuth() {
        this.startAuthTimeInMill = SystemClock.elapsedRealtime();
    }
}
