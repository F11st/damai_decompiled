package com.taobao.accs.ut.monitor;

import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.utl.BaseMonitor;

/* compiled from: Taobao */
@Monitor(module = "accs", monitorPoint = "data_receive")
/* loaded from: classes8.dex */
public class DataReceiveMonitor extends BaseMonitor {
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long ackTime;
    public long endGzipTime;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long gzipTime;
    @Dimension
    public boolean oriGzip;
    @Measure(constantValue = 0.0d, max = 600000.0d, min = 0.0d)
    public long parseTime;
    public long receiveTime;
    public long recordIdTime;
    @Measure(constantValue = 0.0d, max = 60000.0d, min = 0.0d)
    public long recordTime;
    public long reportAckTime;
    @Measure(constantValue = 0.0d, max = 600000.0d, min = 0.0d)
    public long scheduledTime;
    @Dimension
    public String serviceId;
    public long startGzipTime;
    public long startParseTime;
    @Measure(constantValue = 0.0d, max = 600000.0d, min = 0.0d)
    public long totalTime;

    private long computeTime(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return 0L;
        }
        return j2 - j;
    }

    @Override // com.taobao.accs.utl.BaseMonitor, anet.channel.statist.StatObject
    public boolean beforeCommit() {
        this.scheduledTime = computeTime(this.receiveTime, this.startParseTime);
        this.parseTime = computeTime(this.startParseTime, this.startGzipTime);
        this.gzipTime = computeTime(this.startGzipTime, this.endGzipTime);
        this.recordTime = computeTime(this.endGzipTime, this.recordIdTime);
        this.ackTime = computeTime(this.recordIdTime, this.reportAckTime);
        this.totalTime = computeTime(this.receiveTime, this.reportAckTime);
        return super.beforeCommit();
    }
}
