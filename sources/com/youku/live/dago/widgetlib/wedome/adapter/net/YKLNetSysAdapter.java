package com.youku.live.dago.widgetlib.wedome.adapter.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.bridge.JSCallback;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.NetworkUtils;
import com.youku.live.dago.widgetlib.protocol.YKLNetProtocol;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLNetSysAdapter implements YKLNetProtocol {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String WX_NET_CELL = "DAGONetCell";
    public static final String WX_NET_STATE_CHANGED = "DAGONetStateChanged";
    public static final String WX_NET_UNKNOWN = "DAGONetUnknow";
    public static final String WX_NET_WIFI = "DAGONetWifi";
    private boolean isEnableNet;
    private JSCallback mCallback;
    private WXSDKInstance mInstance;
    private BroadcastReceiver mNetworkReceiver = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void fireEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372784643")) {
            ipChange.ipc$dispatch("-1372784643", new Object[]{this});
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", (Object) getNetworkEvent());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        WXSDKInstance wXSDKInstance = this.mInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.fireGlobalEventCallback(WX_NET_STATE_CHANGED, jSONObject);
        }
    }

    private String getNetworkEvent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1887932991") ? (String) ipChange.ipc$dispatch("-1887932991", new Object[]{this}) : NetworkUtils.hasInternet() ? !NetworkUtils.isWifi() ? WX_NET_CELL : WX_NET_WIFI : WX_NET_UNKNOWN;
    }

    private void initNetWorkReceiver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999987916")) {
            ipChange.ipc$dispatch("-1999987916", new Object[]{this});
        } else if (this.mNetworkReceiver == null) {
            this.mNetworkReceiver = new BroadcastReceiver() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.net.YKLNetSysAdapter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1245273013")) {
                        ipChange2.ipc$dispatch("1245273013", new Object[]{this, context, intent});
                    } else if (intent.getAction().equals(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION) && YKLNetSysAdapter.this.isEnableNet) {
                        YKLNetSysAdapter.this.fireEvent();
                    }
                }
            };
        }
    }

    private void registerReceiver() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-206475785")) {
            ipChange.ipc$dispatch("-206475785", new Object[]{this});
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            this.mInstance.getContext().registerReceiver(this.mNetworkReceiver, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLNetProtocol
    public void enableNetEvent(boolean z, WXSDKInstance wXSDKInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377262365")) {
            ipChange.ipc$dispatch("-1377262365", new Object[]{this, Boolean.valueOf(z), wXSDKInstance});
            return;
        }
        this.isEnableNet = z;
        if (z) {
            this.mInstance = wXSDKInstance;
            initNetWorkReceiver();
            registerReceiver();
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLNetProtocol
    public void netStatus(JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309413142")) {
            ipChange.ipc$dispatch("309413142", new Object[]{this, jSCallback});
            return;
        }
        this.mCallback = jSCallback;
        HashMap hashMap = new HashMap();
        hashMap.put("status", getNetworkEvent());
        JSCallback jSCallback2 = this.mCallback;
        if (jSCallback2 != null) {
            jSCallback2.invokeAndKeepAlive(hashMap);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLNetProtocol
    public void onDestroy() {
        WXSDKInstance wXSDKInstance;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301932422")) {
            ipChange.ipc$dispatch("1301932422", new Object[]{this});
        } else if (this.mNetworkReceiver == null || (wXSDKInstance = this.mInstance) == null) {
        } else {
            try {
                wXSDKInstance.getContext().unregisterReceiver(this.mNetworkReceiver);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.mNetworkReceiver = null;
                throw th;
            }
            this.mNetworkReceiver = null;
        }
    }
}
