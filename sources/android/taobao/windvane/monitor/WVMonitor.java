package android.taobao.windvane.monitor;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVMonitor {
    public static final int OPTION_ERROR = 2;
    public static final int OPTION_JSBRIDGE = 4;
    public static final int OPTION_PERFORMANCE = 1;

    public static void init() {
        init(7);
        WVMonitorConfigManager.getInstance().init();
    }

    public static void init(int i) {
        WVMonitorImpl wVMonitorImpl = new WVMonitorImpl();
        if ((i & 1) > 0) {
            WVMonitorService.registerPerformanceMonitor(wVMonitorImpl);
            WVMonitorService.registerConfigMonitor(wVMonitorImpl);
            WVMonitorService.registerWVMonitor(wVMonitorImpl);
        }
        if ((i & 2) > 0) {
            WVMonitorService.registerErrorMonitor(wVMonitorImpl);
        }
        if ((i & 4) > 0) {
            WVMonitorService.registerJsBridgeMonitor(new WVJsMonitor());
        }
        AppMonitorUtil.init();
    }
}
