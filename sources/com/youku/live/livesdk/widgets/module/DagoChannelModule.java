package com.youku.live.livesdk.widgets.module;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IPlugin;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoChannelModule extends WXModule implements Destroyable, DagoChannelPlugin.Receiver {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoChannelModule";
    private Map<String, String> limitMap;
    private DagoChannelPlugin mDagoChannelPlugin;
    private boolean mHasBeenRelatived = false;
    private JSCallback mReceiver;

    private void initWithNothing() {
        IEngineInstance widgetEngineInstance;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-130262049")) {
            ipChange.ipc$dispatch("-130262049", new Object[]{this});
        } else if (this.mHasBeenRelatived || (widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this)) == null) {
        } else {
            IPlugin findPluginByName = widgetEngineInstance.findPluginByName("DagoChannel");
            if (findPluginByName instanceof DagoChannelPlugin) {
                initWithPlugin((DagoChannelPlugin) findPluginByName);
            }
        }
    }

    private void initWithPlugin(DagoChannelPlugin dagoChannelPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472195087")) {
            ipChange.ipc$dispatch("-472195087", new Object[]{this, dagoChannelPlugin});
            return;
        }
        Log.v(TAG, "initWithPlugin");
        this.mDagoChannelPlugin = dagoChannelPlugin;
        if (dagoChannelPlugin != null) {
            Log.v(TAG, "initWithPlugin addListener");
            dagoChannelPlugin.addListener(this);
            this.mHasBeenRelatived = true;
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888318836")) {
            ipChange.ipc$dispatch("1888318836", new Object[]{this});
            return;
        }
        DagoChannelPlugin dagoChannelPlugin = this.mDagoChannelPlugin;
        this.mDagoChannelPlugin = null;
        if (dagoChannelPlugin != null) {
            dagoChannelPlugin.removeListener(this);
        }
        this.mHasBeenRelatived = false;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1172273412")) {
            ipChange.ipc$dispatch("-1172273412", new Object[]{this});
        } else {
            releaseWithNothing();
        }
    }

    public Map<String, String> getLimitMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275389388")) {
            return (Map) ipChange.ipc$dispatch("-275389388", new Object[]{this});
        }
        if (this.limitMap == null) {
            synchronized (this) {
                if (this.limitMap == null) {
                    this.limitMap = new ConcurrentHashMap();
                }
            }
        }
        return this.limitMap;
    }

    @JSMethod
    public void limit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-504546075")) {
            ipChange.ipc$dispatch("-504546075", new Object[]{this, str});
            return;
        }
        Log.v(TAG, "limit");
        getLimitMap().put(str, str);
    }

    @Override // com.youku.live.livesdk.widgets.plugin.DagoChannelPlugin.Receiver
    public void onMessage(DagoChannelPlugin.Message message) {
        JSCallback jSCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747404171")) {
            ipChange.ipc$dispatch("747404171", new Object[]{this, message});
            return;
        }
        Log.v(TAG, "onMessage: " + message.data);
        message.bytes = null;
        if (getLimitMap().containsKey(message.msgType) || (jSCallback = this.mReceiver) == null) {
            return;
        }
        jSCallback.invokeAndKeepAlive(message);
    }

    @JSMethod
    public void subscribe(JSCallback jSCallback, JSCallback jSCallback2, JSCallback jSCallback3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "324332444")) {
            ipChange.ipc$dispatch("324332444", new Object[]{this, jSCallback, jSCallback2, jSCallback3});
            return;
        }
        Log.v(TAG, "subscribe");
        this.mReceiver = jSCallback;
        initWithNothing();
        if (jSCallback2 != null) {
            jSCallback2.invoke(new HashMap());
        }
    }

    @JSMethod
    public void unlimit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800347138")) {
            ipChange.ipc$dispatch("-1800347138", new Object[]{this, str});
            return;
        }
        Log.v(TAG, "unlimit");
        getLimitMap().remove(str);
    }

    @JSMethod
    public void unsubscribe(JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078411899")) {
            ipChange.ipc$dispatch("-2078411899", new Object[]{this, jSCallback, jSCallback2});
            return;
        }
        Log.v(TAG, "unsubscribe");
        this.mReceiver = null;
        releaseWithNothing();
        if (jSCallback != null) {
            jSCallback.invoke(new HashMap());
        }
    }
}
