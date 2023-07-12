package android.taobao.windvane.monitor;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVMonitorService {
    private static WVConfigMonitorInterface configMonitorInterface;
    private static WVErrorMonitorInterface errorMonitor;
    private static WVJSBrdigeMonitorInterface jsBridgeMonitor;
    private static WVPackageMonitorInterface packageMonitorInterface;
    private static WVPerformanceMonitorInterface performanceMonitor;
    private static WVMonitorInterface wvMonitorInterface;

    public static WVConfigMonitorInterface getConfigMonitor() {
        return configMonitorInterface;
    }

    public static WVErrorMonitorInterface getErrorMonitor() {
        return errorMonitor;
    }

    public static WVJSBrdigeMonitorInterface getJsBridgeMonitor() {
        return jsBridgeMonitor;
    }

    public static WVPackageMonitorInterface getPackageMonitorInterface() {
        return packageMonitorInterface;
    }

    public static WVPerformanceMonitorInterface getPerformanceMonitor() {
        return performanceMonitor;
    }

    public static WVMonitorInterface getWvMonitorInterface() {
        return wvMonitorInterface;
    }

    public static void registerConfigMonitor(WVConfigMonitorInterface wVConfigMonitorInterface) {
        configMonitorInterface = wVConfigMonitorInterface;
    }

    public static void registerErrorMonitor(WVErrorMonitorInterface wVErrorMonitorInterface) {
        errorMonitor = wVErrorMonitorInterface;
    }

    public static void registerJsBridgeMonitor(WVJSBrdigeMonitorInterface wVJSBrdigeMonitorInterface) {
        jsBridgeMonitor = wVJSBrdigeMonitorInterface;
    }

    public static void registerPackageMonitorInterface(WVPackageMonitorInterface wVPackageMonitorInterface) {
        packageMonitorInterface = wVPackageMonitorInterface;
    }

    public static void registerPerformanceMonitor(WVPerformanceMonitorInterface wVPerformanceMonitorInterface) {
        performanceMonitor = wVPerformanceMonitorInterface;
    }

    public static void registerWVMonitor(WVMonitorInterface wVMonitorInterface) {
        wvMonitorInterface = wVMonitorInterface;
    }
}
