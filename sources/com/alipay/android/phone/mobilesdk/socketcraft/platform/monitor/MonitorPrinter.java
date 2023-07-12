package com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor;

import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorModel;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface MonitorPrinter {
    void noteTraficConsume(DataflowMonitorModel dataflowMonitorModel);

    void print(MonitorModel monitorModel);
}
