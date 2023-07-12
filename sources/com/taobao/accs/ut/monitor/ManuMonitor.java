package com.taobao.accs.ut.monitor;

import anet.channel.statist.Dimension;
import anet.channel.statist.Monitor;
import com.alibaba.security.common.track.model.a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;

/* compiled from: Taobao */
@Monitor(module = "accs", monitorPoint = "manufacturer")
/* loaded from: classes8.dex */
public class ManuMonitor extends BaseMonitor {
    private static final String TAG = "ManuMonitor";
    @Dimension
    public boolean abort;
    @Dimension
    public boolean result;
    @Dimension
    public String sdk;
    @Dimension
    public boolean isTokenEmpty = true;
    @Dimension
    public boolean isDeviceSupport = true;

    public ManuMonitor() {
    }

    @Override // com.taobao.accs.utl.BaseMonitor, anet.channel.statist.StatObject
    public boolean beforeCommit() {
        ALog.e(TAG, "manufacturer_monitor", a.C0166a.a, this.sdk, "isTokenEmpty", Boolean.valueOf(this.isTokenEmpty), "abort", Boolean.valueOf(this.abort), "result", Boolean.valueOf(this.result));
        return super.beforeCommit();
    }

    public ManuMonitor(String str, boolean z) {
        this.sdk = str;
        this.abort = z;
    }
}
