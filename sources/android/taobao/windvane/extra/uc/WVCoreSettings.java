package android.taobao.windvane.extra.uc;

import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.webview.CoreEventCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVCoreSettings {
    public static final int DOWNLOAD = 1;
    public static final int INNER = 0;
    public static final int U420 = 2;
    public static final int U430 = 3;
    private static WVCoreSettings instance;
    public List<CoreEventCallback> coreEventCallbacks;

    public static WVCoreSettings getInstance() {
        if (instance == null) {
            synchronized (WVCoreSettings.class) {
                if (instance == null) {
                    instance = new WVCoreSettings();
                }
            }
        }
        return instance;
    }

    public static void setCorePolicy(int i) {
        WVCommonConfig.commonConfig.initUCCorePolicy = i;
    }

    public static void setDownloadCore(int i) {
        WVCommonConfig.commonConfig.downloadCoreType = i;
    }

    public static void setGpuMultiPolicy(int i) {
        WVCommonConfig.commonConfig.gpuMultiPolicy = i;
    }

    public static void setInputSupportedDomains(String str) {
        WVCommonConfig.commonConfig.ucParam.u4FocusAutoPopupInputHostList = str;
    }

    public static void setWebMultiPolicy(int i) {
        WVCommonConfig.commonConfig.webMultiPolicy = i;
    }

    public void setCoreEventCallback(CoreEventCallback coreEventCallback) {
        if (coreEventCallback == null) {
            return;
        }
        if (WVCore.getInstance().isUCSupport()) {
            coreEventCallback.onUCCorePrepared();
            return;
        }
        if (this.coreEventCallbacks == null) {
            this.coreEventCallbacks = new CopyOnWriteArrayList();
        }
        if (this.coreEventCallbacks.contains(coreEventCallback)) {
            return;
        }
        this.coreEventCallbacks.add(coreEventCallback);
    }
}
