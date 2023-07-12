package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.debug.WVDebug;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.jsbridge.api.WVCamera;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TBJsApiManager {
    public static void initJsApi() {
        WVCamera.registerUploadService(TBUploadService.class);
        WVPluginManager.registerPlugin(WVServer.API_SERVER, (Class<? extends WVApiPlugin>) WVServer.class);
        WVPluginManager.registerPlugin("WVACCS", (Class<? extends WVApiPlugin>) WVACCS.class);
        WVPluginManager.registerPlugin("WVApplication", (Class<? extends WVApiPlugin>) WVApplication.class);
        WVPluginManager.registerPlugin("WVWebPerformance", (Class<? extends WVApiPlugin>) WVWebPerformance.class);
        WVPluginManager.registerPlugin(WVAPI.PluginName.API_REPORTER, (Class<? extends WVApiPlugin>) WVReporterExtra.class);
        WVDebug.init();
    }
}
