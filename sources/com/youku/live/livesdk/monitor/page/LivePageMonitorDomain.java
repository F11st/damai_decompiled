package com.youku.live.livesdk.monitor.page;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.livesdk.monitor.page.IPageMonitor;
import com.youku.live.livesdk.util.LivePerfUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LivePageMonitorDomain extends PageMonitorTaskDomain {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DOMAIN_NAME = "LivePageMonitor";
    private int mObjectKey;

    public LivePageMonitorDomain(int i) {
        this.mObjectKey = i;
        initMonitor(new String[0]);
    }

    private boolean supportMonitorDomain() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "71643930") ? ((Boolean) ipChange.ipc$dispatch("71643930", new Object[]{this})).booleanValue() : LivePerfUtils.supportPageMonitorTask();
    }

    @Override // com.youku.live.livesdk.monitor.page.PageMonitorTaskDomain, com.youku.live.livesdk.monitor.page.IPageMonitor
    public void addMonitorTask(IPageMonitor.MonitorTask monitorTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "455301502")) {
            ipChange.ipc$dispatch("455301502", new Object[]{this, monitorTask});
        } else if (supportMonitorDomain()) {
            super.addMonitorTask(monitorTask);
        } else {
            executeTask(monitorTask);
        }
    }

    @Override // com.youku.live.livesdk.monitor.page.PageMonitorTaskDomain
    protected long getCheckRunnableDelay() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "690578821") ? ((Long) ipChange.ipc$dispatch("690578821", new Object[]{this})).longValue() : OptConfigUtils.getConfigLong("checkRunnableDelay", 1500L);
    }

    @Override // com.youku.live.livesdk.monitor.page.PageMonitorTaskDomain, com.youku.live.livesdk.monitor.page.IPageMonitor
    public void initMonitor(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704095900")) {
            ipChange.ipc$dispatch("-1704095900", new Object[]{this, strArr});
        } else {
            super.initMonitor(DOMAIN_NAME);
        }
    }

    public void onPageStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671818799")) {
            ipChange.ipc$dispatch("-671818799", new Object[]{this});
        } else {
            changeMonitorState(DOMAIN_NAME, 1);
        }
    }

    public void onVideoPlayComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "511686428")) {
            ipChange.ipc$dispatch("511686428", new Object[]{this});
        } else {
            changeMonitorState(DOMAIN_NAME, 2);
        }
    }

    @Override // com.youku.live.livesdk.monitor.page.PageMonitorTaskDomain
    protected void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169436382")) {
            ipChange.ipc$dispatch("1169436382", new Object[]{this});
        }
    }
}
