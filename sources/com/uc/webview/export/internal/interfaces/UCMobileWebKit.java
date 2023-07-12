package com.uc.webview.export.internal.interfaces;

import android.location.LocationListener;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.extension.ILocationManager;
import com.uc.webview.export.media.MediaPlayerFactory;
import java.util.HashMap;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public interface UCMobileWebKit extends InvokeObject {
    public static final int CORE_EVENT_SETWEBCONTENTS_DEBUGGING = 100;
    public static final int CORE_EVENT_START_TCP_DEVTOOLS = 101;

    /* compiled from: Taobao */
    @Interface
    /* loaded from: classes11.dex */
    public interface ReceiveDispatchResponseListener {
        void respond(HashMap<String, String> hashMap);
    }

    void fontDownloadFinished();

    String getCoreBuildSeq();

    String getCoreVersion();

    IWebResourceInternal getWebResources();

    Object notifyCoreEvent(int i, Object obj);

    Object notifyCoreEvent(int i, Object obj, ValueCallback<Object> valueCallback);

    void onDestroy();

    void onLowMemory();

    void onOrientationChanged();

    void onPause();

    void onResume();

    void onScreenLock();

    void onScreenUnLock();

    void onTrimMemory(int i);

    void onWindowSizeChanged();

    @Deprecated
    void preloadResource(String str, int i, int i2, ValueCallback<WebResourceResponse> valueCallback);

    void removeUserScript(String str);

    void setCDLocationListener(LocationListener locationListener);

    void setLocationManagerUC(ILocationManager iLocationManager);

    void setMediaPlayerFactory(MediaPlayerFactory mediaPlayerFactory);

    void setNetLogger(INetLogger iNetLogger);

    void setNetworkDelegate(INetworkDelegate iNetworkDelegate);

    void setPluginServiceClassPath(String str);

    void setReceiveDispatchResponseListener(ReceiveDispatchResponseListener receiveDispatchResponseListener);

    @Deprecated
    void setSocketParam(String str, Object obj);

    void setThirdNetwork(INetwork iNetwork, INetworkDecider iNetworkDecider);

    void updateBussinessInfo(int i, int i2, String str, Object obj);

    void updateUserScript(String str, HashMap<String, Object> hashMap);
}
