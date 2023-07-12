package com.youku.arch.beast.apas.remote;

import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.apas.Apas;
import com.youku.util.Logger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ApasConfigCenter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ApasConfigCenter";
    private static ApasConfigCenter mInstance = new ApasConfigCenter();
    final Map<String, Map<IApasUpdateListenerInterface, Apas.ConfigUpdateListener>> mListeners = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class UpdateListenerProxy implements Apas.ConfigUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private IApasUpdateListenerInterface mRealListener;

        UpdateListenerProxy(IApasUpdateListenerInterface iApasUpdateListenerInterface) {
            this.mRealListener = iApasUpdateListenerInterface;
        }

        @Override // com.youku.arch.beast.apas.Apas.ConfigUpdateListener
        public void onUpdateConfig(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1835494854")) {
                ipChange.ipc$dispatch("1835494854", new Object[]{this, str, str2, str3});
                return;
            }
            IApasUpdateListenerInterface iApasUpdateListenerInterface = this.mRealListener;
            if (iApasUpdateListenerInterface != null) {
                try {
                    iApasUpdateListenerInterface.onConfigUpdate(str, str2, str3);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ApasConfigCenter() {
    }

    public static ApasConfigCenter getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "511996963") ? (ApasConfigCenter) ipChange.ipc$dispatch("511996963", new Object[0]) : mInstance;
    }

    public boolean containsNamespace(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-457715081") ? ((Boolean) ipChange.ipc$dispatch("-457715081", new Object[]{this, str})).booleanValue() : (TextUtils.isEmpty(str) || Apas.getInstance().getNamespace(str) == null) ? false : true;
    }

    public String getConfig(String str, String str2, String str3) {
        String stringValue;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1658412363") ? (String) ipChange.ipc$dispatch("-1658412363", new Object[]{this, str, str2, str3}) : (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || Apas.getInstance().getNamespace(str) == null || Apas.getInstance().getNamespace(str).getConfig(0) == null || (stringValue = Apas.getInstance().getNamespace(str).getConfig(0).getStringValue(str2)) == null || "null".equals(stringValue)) ? str3 : stringValue;
    }

    public Map getConfigs(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-409965591")) {
            return (Map) ipChange.ipc$dispatch("-409965591", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str) || Apas.getInstance().getNamespace(str) == null || Apas.getInstance().getNamespace(str).getConfig(0) == null) {
            return null;
        }
        String configValue = Apas.getInstance().getNamespace(str).getConfig(0).getConfigValue();
        if (TextUtils.isEmpty(configValue)) {
            return null;
        }
        return (Map) JSON.toJavaObject(JSON.parseObject(configValue), Map.class);
    }

    public void registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-253724249")) {
            ipChange.ipc$dispatch("-253724249", new Object[]{this, str, iApasUpdateListenerInterface});
            return;
        }
        String str2 = TAG;
        Logger.d(str2, "registerListener:" + str);
        if (TextUtils.isEmpty(str) || iApasUpdateListenerInterface == null) {
            return;
        }
        synchronized (this.mListeners) {
            Map<IApasUpdateListenerInterface, Apas.ConfigUpdateListener> map = this.mListeners.get(str);
            if (map == null) {
                map = new LinkedHashMap<>();
                this.mListeners.put(str, map);
            }
            if (map.keySet().contains(iApasUpdateListenerInterface)) {
                Logger.d(str2, "registerListener duplicate:" + str);
                return;
            }
            Logger.d(str2, "registerListener new:" + str);
            UpdateListenerProxy updateListenerProxy = new UpdateListenerProxy(iApasUpdateListenerInterface);
            Apas.getInstance().addConfigUpdateListener(str, updateListenerProxy);
            map.put(iApasUpdateListenerInterface, updateListenerProxy);
        }
    }

    public void setRequestExtraInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421119928")) {
            ipChange.ipc$dispatch("-1421119928", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        } else {
            Apas.getInstance().setRequestExtraInfo(str, str2);
        }
    }

    public void unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-795399232")) {
            ipChange.ipc$dispatch("-795399232", new Object[]{this, str, iApasUpdateListenerInterface});
        } else if (TextUtils.isEmpty(str) || iApasUpdateListenerInterface == null) {
        } else {
            String str2 = TAG;
            Logger.d(str2, "unregisterListener:" + str);
            synchronized (this.mListeners) {
                Map<IApasUpdateListenerInterface, Apas.ConfigUpdateListener> map = this.mListeners.get(str);
                if (map != null && map.size() > 0 && map.containsKey(iApasUpdateListenerInterface)) {
                    Apas.getInstance().removeConfigUpdateListener(str, map.get(iApasUpdateListenerInterface));
                    map.remove(iApasUpdateListenerInterface);
                    Logger.d(str2, "unregisterListener remove:" + str);
                }
            }
        }
    }
}
