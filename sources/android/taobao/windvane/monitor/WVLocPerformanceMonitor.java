package android.taobao.windvane.monitor;

import android.content.Context;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVLocPerformanceMonitor implements WVEventListener {
    public static final int APP_STATUS = 1;
    public static final int LOADURL_STATUS = 3;
    private static String TAG = "WVLocPerformanceMonitor";
    public static final int WEBVIEW_STATUS = 2;
    private static WVLocPerformanceMonitor instance;
    private static boolean isOpenLocPerformanceMonitor;
    private HashMap<String, Object> monitorData;
    public float cpu_app = 0.0f;
    public float mem_app = 0.0f;
    public float cpu_webview = 0.0f;
    public float mem_webview = 0.0f;
    private long time_webview_start = 0;
    private long time_webview = 0;
    public float cpu_loadurl = 0.0f;
    public float mem_loadurl = 0.0f;
    private long time_load_start = 0;
    private long time_load = 0;
    private boolean isInit = false;

    public static WVLocPerformanceMonitor getInstance() {
        if (instance == null) {
            synchronized (WVMonitorConfigManager.class) {
                instance = new WVLocPerformanceMonitor();
            }
        }
        return instance;
    }

    public static boolean isOpenLocPerformanceMonitor() {
        return isOpenLocPerformanceMonitor;
    }

    public static void setOpenLocPerformanceMonitor(boolean z) {
        isOpenLocPerformanceMonitor = z;
    }

    public HashMap<String, Object> getMonitorData() {
        return this.monitorData;
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        if (3009 == i) {
            setCpuAndMemery(GlobalConfig.context, 1);
            return null;
        } else if (3008 == i) {
            this.time_webview_start = System.currentTimeMillis();
            return null;
        } else if (3010 == i) {
            long currentTimeMillis = System.currentTimeMillis();
            this.time_load_start = currentTimeMillis;
            this.time_webview = currentTimeMillis - this.time_webview_start;
            setCpuAndMemery(GlobalConfig.context, 2);
            return null;
        } else if (1001 == i) {
            this.time_load_start = System.currentTimeMillis();
            return null;
        } else if (1002 == i) {
            try {
                this.time_load = System.currentTimeMillis() - this.time_load_start;
                setCpuAndMemery(GlobalConfig.context, 3);
                IWVWebView iWVWebView = wVEventContext.webView;
                IWVWebView.JsbridgeHis.clear();
                return null;
            } catch (Exception unused) {
                return null;
            }
        } else {
            return null;
        }
    }

    public void reset() {
        this.cpu_app = 0.0f;
        this.mem_app = 0.0f;
        this.cpu_webview = 0.0f;
        this.mem_webview = 0.0f;
        this.time_webview = 0L;
        this.cpu_loadurl = 0.0f;
        this.mem_loadurl = 0.0f;
        this.time_load = 0L;
        this.isInit = false;
    }

    public void setCpuAndMemery(Context context, int i) {
        if (!isOpenLocPerformanceMonitor()) {
            TaoLog.d(TAG, "非debug状态，不开启性能数据采集模式");
            return;
        }
        if (i == 1) {
            this.cpu_app = 0.0f;
            this.mem_app = 0.0f;
        } else if (i == 2) {
            this.cpu_webview = 0.0f;
            this.mem_webview = 0.0f;
        } else if (i == 3) {
            this.cpu_loadurl = 0.0f;
            this.mem_loadurl = 0.0f;
        }
        this.isInit = true;
    }

    public void setMonitorData(HashMap<String, Object> hashMap) {
        this.monitorData = hashMap;
        setCpuAndMemery(GlobalConfig.context, 3);
    }

    public String toString() {
        if (this.isInit) {
            try {
                String jSONString = JSON.toJSONString(getInstance());
                String str = TAG;
                TaoLog.d(str, "data: " + jSONString);
                return jSONString;
            } catch (Exception e) {
                e.printStackTrace();
                String str2 = TAG;
                TaoLog.d(str2, "性能数据采集失败，json解析异常 json 解析异常：" + e.getMessage());
                return null;
            }
        }
        TaoLog.d(TAG, "性能数据未初始化");
        return null;
    }
}
