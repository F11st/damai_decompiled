package com.taobao.accs.ut.monitor;

import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.android.tlog.protocol.model.joint.point.ForegroundJointPoint;

/* compiled from: Taobao */
@Monitor(module = "accs", monitorPoint = ForegroundJointPoint.TYPE)
/* loaded from: classes8.dex */
public class AccsForegroundMonitor extends BaseMonitor {
    @Measure
    public long aliveTime;
    @Measure
    public long onlineTime;
}
