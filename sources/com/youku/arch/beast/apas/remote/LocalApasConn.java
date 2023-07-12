package com.youku.arch.beast.apas.remote;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LocalApasConn implements IApasConn {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public boolean containsNamespace(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-898231553") ? ((Boolean) ipChange.ipc$dispatch("-898231553", new Object[]{this, str})).booleanValue() : ApasConfigCenter.getInstance().containsNamespace(str);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public String getConfig(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1595121453") ? (String) ipChange.ipc$dispatch("1595121453", new Object[]{this, str, str2, str3}) : ApasConfigCenter.getInstance().getConfig(str, str2, str3);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public Map getConfigs(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "719979105") ? (Map) ipChange.ipc$dispatch("719979105", new Object[]{this, str}) : ApasConfigCenter.getInstance().getConfigs(str);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-542870917")) {
            ipChange.ipc$dispatch("-542870917", new Object[]{this, context});
        }
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public boolean registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090009549")) {
            return ((Boolean) ipChange.ipc$dispatch("-2090009549", new Object[]{this, str, iApasUpdateListenerInterface})).booleanValue();
        }
        ApasConfigCenter.getInstance().registerListener(str, iApasUpdateListenerInterface);
        return true;
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public void setRequestExtraInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883694288")) {
            ipChange.ipc$dispatch("883694288", new Object[]{this, str, str2});
        } else {
            ApasConfigCenter.getInstance().setRequestExtraInfo(str, str2);
        }
    }

    @Override // com.youku.arch.beast.apas.remote.IApasConn
    public boolean unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234017716")) {
            return ((Boolean) ipChange.ipc$dispatch("-234017716", new Object[]{this, str, iApasUpdateListenerInterface})).booleanValue();
        }
        ApasConfigCenter.getInstance().unregisterListener(str, iApasUpdateListenerInterface);
        return true;
    }
}
