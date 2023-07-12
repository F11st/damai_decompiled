package com.youku.live.livesdk.wkit.module;

import android.content.Context;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.linkout.ILinkOut;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoNavigate extends WXModule implements Destroyable, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ENTER_PIP_MODE_RESULT_BY_BIZ = "enterPipModeResultByBiz";
    private boolean isInited = false;
    private Context mActivity;
    JSCallback mCallback;
    IEngineInstance mEngineInstance;

    private void initDataHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930114716")) {
            ipChange.ipc$dispatch("-1930114716", new Object[]{this});
        } else if (this.isInited) {
        } else {
            this.isInited = true;
            initWithNothing();
        }
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361376739")) {
            ipChange.ipc$dispatch("-361376739", new Object[]{this});
            return;
        }
        Log.d("fornia", "pip live DagoNavigate initWithNothing 初始化nodule" + this + " ");
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            this.mActivity = wXSDKInstance.getContext();
        }
        if (this.mEngineInstance == null) {
            this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance != null) {
            iEngineInstance.addDataHandlers(new String[]{"enterPipResult", ENTER_PIP_MODE_RESULT_BY_BIZ}, this);
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1583164534")) {
            ipChange.ipc$dispatch("1583164534", new Object[]{this});
            return;
        }
        Log.d("fornia", "pip live DagoNavigate releaseWithNothing 释放module" + this + " ");
        ((ILinkOut) Dsl.getService(ILinkOut.class)).unregister();
        if (this.mEngineInstance == null) {
            this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance != null) {
            iEngineInstance.removeData("enterPipResult");
            this.mEngineInstance.removeDataHandler("enterPipResult", this);
            this.mEngineInstance.removeData(ENTER_PIP_MODE_RESULT_BY_BIZ);
            this.mEngineInstance.removeDataHandler(ENTER_PIP_MODE_RESULT_BY_BIZ, this);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113057082")) {
            ipChange.ipc$dispatch("113057082", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283803445")) {
            ipChange.ipc$dispatch("-283803445", new Object[]{this, str, obj, obj2});
        } else if ("enterPipResult".equals(str) || ENTER_PIP_MODE_RESULT_BY_BIZ.equals(str)) {
            Log.d("fornia", "pip live DagoNavigate DAGO_ENTER_PIP_RESULT" + this + " " + obj);
            JSCallback jSCallback = this.mCallback;
            if (jSCallback != null) {
                jSCallback.invokeAndKeepAlive(null);
                this.mCallback = null;
            }
        }
    }

    @JSMethod
    public void willNavigate(int i, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1186080328")) {
            ipChange.ipc$dispatch("-1186080328", new Object[]{this, Integer.valueOf(i), jSCallback});
            return;
        }
        initDataHandler();
        this.mCallback = jSCallback;
        if (this.mEngineInstance == null) {
            this.mEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        }
        IEngineInstance iEngineInstance = this.mEngineInstance;
        if (iEngineInstance != null) {
            iEngineInstance.asyncPutData(DagoExitPlayer.ENTER_PIP_MODE_BY_WEEX_NOTIFY, 4);
        }
    }
}
