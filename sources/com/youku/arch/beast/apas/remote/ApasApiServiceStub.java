package com.youku.arch.beast.apas.remote;

import android.os.RemoteException;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.apas.remote.IApasApiInterface;
import com.youku.util.Logger;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ApasApiServiceStub extends IApasApiInterface.Stub {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = ApasApiServiceStub.class.getSimpleName();

    @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
    public boolean containsNamespace(String str) throws RemoteException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064112731")) {
            return ((Boolean) ipChange.ipc$dispatch("-2064112731", new Object[]{this, str})).booleanValue();
        }
        String str2 = TAG;
        Logger.d(str2, "getConfigs:" + str);
        return ApasConfigCenter.getInstance().containsNamespace(str);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
    public String getConfig(String str, String str2, String str3) throws RemoteException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1942920121")) {
            return (String) ipChange.ipc$dispatch("-1942920121", new Object[]{this, str, str2, str3});
        }
        String str4 = TAG;
        Logger.d(str4, "getConfig:" + str + "," + str2);
        return ApasConfigCenter.getInstance().getConfig(str, str2, str3);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
    public Map getConfigs(String str) throws RemoteException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1761151739")) {
            return (Map) ipChange.ipc$dispatch("1761151739", new Object[]{this, str});
        }
        String str2 = TAG;
        Logger.d(str2, "getConfigs:" + str);
        return ApasConfigCenter.getInstance().getConfigs(str);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
    public void registerListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) throws RemoteException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-842871211")) {
            ipChange.ipc$dispatch("-842871211", new Object[]{this, str, iApasUpdateListenerInterface});
            return;
        }
        String str2 = TAG;
        Logger.d(str2, "registerListener:" + str + "," + iApasUpdateListenerInterface);
        ApasConfigCenter.getInstance().registerListener(str, iApasUpdateListenerInterface);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
    public void setRequestExtraInfo(String str, String str2) throws RemoteException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421171830")) {
            ipChange.ipc$dispatch("1421171830", new Object[]{this, str, str2});
            return;
        }
        String str3 = TAG;
        Logger.d(str3, "setRequestExtraInfo:" + str + "," + str2);
        ApasConfigCenter.getInstance().setRequestExtraInfo(str, str2);
    }

    @Override // com.youku.arch.beast.apas.remote.IApasApiInterface
    public void unregisterListener(String str, IApasUpdateListenerInterface iApasUpdateListenerInterface) throws RemoteException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29946642")) {
            ipChange.ipc$dispatch("-29946642", new Object[]{this, str, iApasUpdateListenerInterface});
            return;
        }
        String str2 = TAG;
        Logger.d(str2, "unregisterListener:" + str + "," + iApasUpdateListenerInterface);
        ApasConfigCenter.getInstance().unregisterListener(str, iApasUpdateListenerInterface);
    }
}
