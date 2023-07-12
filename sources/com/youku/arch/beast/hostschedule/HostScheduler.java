package com.youku.arch.beast.hostschedule;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HostScheduler {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class SingletonClassInstance {
        private static final HostScheduler instance = new HostScheduler();

        private SingletonClassInstance() {
        }
    }

    public static HostScheduler getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "318999107") ? (HostScheduler) ipChange.ipc$dispatch("318999107", new Object[0]) : SingletonClassInstance.instance;
    }

    public String[] getBackUpDomains(RequestCfg requestCfg, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1195952550") ? (String[]) ipChange.ipc$dispatch("1195952550", new Object[]{this, requestCfg, Boolean.valueOf(z)}) : HostCenter.getInstance().getBackUpDomains(requestCfg, z);
    }

    public DomainCell getDomain(RequestCfg requestCfg) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1531580234") ? (DomainCell) ipChange.ipc$dispatch("1531580234", new Object[]{this, requestCfg}) : HostCenter.getInstance().getDomain(requestCfg);
    }

    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1194721043") ? (String) ipChange.ipc$dispatch("-1194721043", new Object[]{this}) : HostCenter.getInstance().getVersion();
    }

    private HostScheduler() {
    }

    public String getDomain(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1808452426") ? (String) ipChange.ipc$dispatch("-1808452426", new Object[]{this, map}) : HostCenter.getInstance().getDomain(map);
    }
}
