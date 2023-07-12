package com.youku.live.dago.widgetlib.module;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IDynamicConfig;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLSystemInfoModule extends WXModule implements Destroyable, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DAGO_CONTAINER_LOW_MEMORY_WARNING = "onDagoContainerLowMemoryWarningEvent";
    private static final int DEVICE_HIGH = 1;
    private static final int DEVICE_LOW = 3;
    private static final int DEVICE_MID = 2;
    private static final int DEVICE_SCORE_HIGH = 85;
    private static final int DEVICE_SCORE_LOW = 0;
    private static final int DEVICE_SCORE_MID = 60;
    private static final int DEVICE_UNKNOWN = 0;
    private static final String TAG = "YKLSystemInfoModule";
    private boolean mIsInitialized = false;
    private JSCallback mMemoryWarningCallback = null;

    private int getDeviceScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1324210443") ? ((Integer) ipChange.ipc$dispatch("1324210443", new Object[]{this})).intValue() : ((IDynamicConfig) Dsl.getService(IDynamicConfig.class)).getInt("device", IDynamicConfig.KEY_DEVICE_SCORE, -1);
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2048547787")) {
            ipChange.ipc$dispatch("-2048547787", new Object[]{this});
        } else if (this.mIsInitialized) {
        } else {
            this.mIsInitialized = true;
            IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            if (widgetEngineInstance != null) {
                widgetEngineInstance.addDataHandler("onDagoContainerLowMemoryWarningEvent", this);
            }
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1222228642")) {
            ipChange.ipc$dispatch("-1222228642", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler("onDagoContainerLowMemoryWarningEvent", this);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "732595538")) {
            ipChange.ipc$dispatch("732595538", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    @JSMethod
    public void getCPUInfo(JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-758627830")) {
            ipChange.ipc$dispatch("-758627830", new Object[]{this, jSCallback});
        } else {
            jSCallback.invoke(new HashMap());
        }
    }

    @JSMethod
    public void getDeviceLevel(JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454598174")) {
            ipChange.ipc$dispatch("-1454598174", new Object[]{this, jSCallback});
            return;
        }
        int deviceScore = getDeviceScore();
        int i = deviceScore < 85 ? deviceScore >= 60 ? 2 : deviceScore >= 0 ? 3 : 0 : 1;
        HashMap hashMap = new HashMap();
        hashMap.put("deviceLevel", String.valueOf(i));
        hashMap.put(IDynamicConfig.KEY_DEVICE_SCORE, String.valueOf(deviceScore));
        String str = TAG;
        ((ILog) Dsl.getService(ILog.class)).d(str, "getDeviceLevel map = " + hashMap);
        jSCallback.invoke(hashMap);
    }

    @JSMethod
    public void getMemoryInfo(JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693203391")) {
            ipChange.ipc$dispatch("-1693203391", new Object[]{this, jSCallback});
        } else {
            jSCallback.invoke(new HashMap());
        }
    }

    public void invokeMemoryWarning() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469248617")) {
            ipChange.ipc$dispatch("1469248617", new Object[]{this});
            return;
        }
        JSCallback jSCallback = this.mMemoryWarningCallback;
        if (jSCallback != null) {
            jSCallback.invokeAndKeepAlive(new HashMap());
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289540893")) {
            ipChange.ipc$dispatch("-289540893", new Object[]{this, str, obj, obj2});
        } else if ("onDagoContainerLowMemoryWarningEvent".equals(str)) {
            invokeMemoryWarning();
        }
    }

    @JSMethod
    public void removeMemoryWarning() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293990283")) {
            ipChange.ipc$dispatch("-293990283", new Object[]{this});
        } else {
            this.mMemoryWarningCallback = null;
        }
    }

    @JSMethod
    public void setMemoryWarning(JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622302691")) {
            ipChange.ipc$dispatch("622302691", new Object[]{this, jSCallback});
            return;
        }
        this.mMemoryWarningCallback = jSCallback;
        initWithNothing();
    }
}
