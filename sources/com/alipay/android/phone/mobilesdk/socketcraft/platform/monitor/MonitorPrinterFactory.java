package com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor;

import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MonitorPrinterFactory {
    private static MonitorPrinter a;

    public static final MonitorPrinter getInstance() {
        MonitorPrinter monitorPrinter = a;
        if (monitorPrinter != null) {
            return monitorPrinter;
        }
        synchronized (MonitorPrinterFactory.class) {
            MonitorPrinter monitorPrinter2 = a;
            if (monitorPrinter2 != null) {
                return monitorPrinter2;
            }
            if (PlatformUtil.isAndroidMPaaSPlatform()) {
                a = PlatformUtil.createMPaaSMonitorPrinter();
            } else {
                a = new DefaultMonitorPrinter();
            }
            return a;
        }
    }

    public static void setMonitorPrinter(MonitorPrinter monitorPrinter) {
        a = monitorPrinter;
    }
}
