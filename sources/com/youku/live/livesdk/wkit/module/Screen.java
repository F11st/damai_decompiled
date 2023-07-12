package com.youku.live.livesdk.wkit.module;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.arch.utils.ViewUtils;
import com.youku.live.livesdk.constants.ScreenConstants;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Screen extends WXModule implements Destroyable, ScreenConstants, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String FULL_CL0SE = "0";
    private static final String FULL_KEY = "full";
    private static final String FULL_OPEN = "1";
    private static final String TAG = "Screen";
    private boolean mIsInit = false;
    JSCallback mOriFailCallback;
    JSCallback mOriSucdCallback;

    private Activity getActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432379183")) {
            return (Activity) ipChange.ipc$dispatch("1432379183", new Object[]{this});
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        Context context = wXSDKInstance != null ? wXSDKInstance.getContext() : null;
        if (context != null) {
            return ViewUtils.getActivity(context);
        }
        return null;
    }

    private void globalEvent(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-514915916")) {
            ipChange.ipc$dispatch("-514915916", new Object[]{this, str, map});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.fireGlobalEventCallback(str, map);
        }
    }

    private void initWithEngineSDK() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1109697412")) {
            ipChange.ipc$dispatch("-1109697412", new Object[]{this});
        } else if (this.mIsInit) {
        } else {
            this.mIsInit = true;
            IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            if (widgetEngineInstance != null) {
                widgetEngineInstance.addDataHandler("OrientationChange", this);
            }
        }
    }

    private void releaseWithEngineSDK() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939228097")) {
            ipChange.ipc$dispatch("1939228097", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler("OrientationChange", this);
        }
    }

    private void setNotFullScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1839957294")) {
            ipChange.ipc$dispatch("-1839957294", new Object[]{this, activity});
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832388604")) {
            ipChange.ipc$dispatch("-832388604", new Object[]{this});
        } else {
            releaseWithEngineSDK();
        }
    }

    @JSMethod
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1403238460")) {
            ipChange.ipc$dispatch("1403238460", new Object[]{this});
        } else {
            initWithEngineSDK();
        }
    }

    public void lockScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265418553")) {
            ipChange.ipc$dispatch("-1265418553", new Object[]{this, activity});
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618515093")) {
            ipChange.ipc$dispatch("618515093", new Object[]{this, str, obj, obj2});
        } else if ("OrientationChange".equals(str) && (obj instanceof Map)) {
            globalEvent("DGOrientationChange", (Map) obj);
        }
    }

    @JSMethod
    public void setAutoRotate(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423656973")) {
            ipChange.ipc$dispatch("-423656973", new Object[]{this, map, jSCallback, jSCallback2});
            return;
        }
        initWithEngineSDK();
        if (this.mWXSDKInstance == null || map == null) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
            }
        } else if (getActivity() == null) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
            }
        } else {
            map.get("auto");
            if (jSCallback != null) {
                jSCallback.invoke(null);
            }
        }
    }

    @JSMethod
    public void setFullScreen(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1577645796")) {
            ipChange.ipc$dispatch("1577645796", new Object[]{this, map, jSCallback, jSCallback2});
            return;
        }
        initWithEngineSDK();
        if (this.mWXSDKInstance == null || map == null) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
                return;
            }
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
                return;
            }
            return;
        }
        String str = map.get(FULL_KEY);
        if (TextUtils.isEmpty(str)) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
            }
        } else if ("1".equals(str)) {
            setFullScreen(activity);
            if (jSCallback != null) {
                jSCallback.invoke(null);
            }
        } else if (!"0".equals(str)) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
            }
        } else {
            setNotFullScreen(activity);
            if (jSCallback != null) {
                jSCallback.invoke(null);
            }
        }
    }

    @JSMethod
    public void setOrientation(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "997391815")) {
            ipChange.ipc$dispatch("997391815", new Object[]{this, map, jSCallback, jSCallback2});
            return;
        }
        initWithEngineSDK();
        this.mOriSucdCallback = jSCallback;
        this.mOriFailCallback = jSCallback2;
        if (this.mWXSDKInstance == null || map == null) {
            if (jSCallback2 != null) {
                jSCallback2.invokeAndKeepAlive(new Object());
            }
        } else if (getActivity() == null) {
            JSCallback jSCallback3 = this.mOriFailCallback;
            if (jSCallback3 != null) {
                jSCallback3.invokeAndKeepAlive(new Object());
            }
        } else {
            String str = map.get("orientation");
            if (TextUtils.isEmpty(str)) {
                JSCallback jSCallback4 = this.mOriFailCallback;
                if (jSCallback4 != null) {
                    jSCallback4.invokeAndKeepAlive(new Object());
                    return;
                }
                return;
            }
            setOrientation(str);
            JSCallback jSCallback5 = this.mOriSucdCallback;
            if (jSCallback5 != null) {
                jSCallback5.invokeAndKeepAlive(new Object());
            }
        }
    }

    @JSMethod
    public void setSupportedOrientations(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "23021736")) {
            ipChange.ipc$dispatch("23021736", new Object[]{this, map, jSCallback, jSCallback2});
        } else {
            initWithEngineSDK();
        }
    }

    public void unlockScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525831730")) {
            ipChange.ipc$dispatch("-1525831730", new Object[]{this, activity});
        }
    }

    private void setFullScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199539475")) {
            ipChange.ipc$dispatch("199539475", new Object[]{this, activity});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && i < 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(6);
        } else if (i >= 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(4102);
        }
    }

    private void setOrientation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306985976")) {
            ipChange.ipc$dispatch("-1306985976", new Object[]{this, str});
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (!"portrait".equalsIgnoreCase(str) && !"portraitUpsideDown".equalsIgnoreCase(str)) {
            if ("landscapeRight".equalsIgnoreCase(str) || "landscapeLeft".equalsIgnoreCase(str)) {
                activity.setRequestedOrientation(0);
                setFullScreen(new HashMap<String, String>() { // from class: com.youku.live.livesdk.wkit.module.Screen.2
                    {
                        put(Screen.FULL_KEY, "1");
                    }
                }, null, null);
                return;
            }
            return;
        }
        activity.setRequestedOrientation(1);
        setFullScreen(new HashMap<String, String>() { // from class: com.youku.live.livesdk.wkit.module.Screen.1
            {
                put(Screen.FULL_KEY, "0");
            }
        }, null, null);
    }
}
