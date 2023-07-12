package com.youku.live.livesdk.monitor.page;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.monitor.page.IPageMonitor;
import com.youku.live.livesdk.util.LivePerfUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LivePageTaskHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Handler mMainHandler;
    private SparseArray<LivePageMonitorDomain> mPageTaskDomain = new SparseArray<>(5);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class SingletonHolder {
        private static final LivePageTaskHolder INSTANCE = new LivePageTaskHolder();

        private SingletonHolder() {
        }
    }

    private void executeTask(Runnable runnable, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2049941086")) {
            ipChange.ipc$dispatch("-2049941086", new Object[]{this, runnable, Boolean.valueOf(z)});
        } else if (z) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
                return;
            }
            if (this.mMainHandler == null) {
                this.mMainHandler = new Handler(Looper.getMainLooper());
            }
            this.mMainHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static LivePageTaskHolder getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "136646715") ? (LivePageTaskHolder) ipChange.ipc$dispatch("136646715", new Object[0]) : SingletonHolder.INSTANCE;
    }

    public boolean addPageNormalTask(Activity activity, boolean z, Runnable runnable, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1628146876")) {
            return ((Boolean) ipChange.ipc$dispatch("1628146876", new Object[]{this, activity, Boolean.valueOf(z), runnable, str})).booleanValue();
        }
        LivePageMonitorDomain pageTaskDomain = getInstance().getPageTaskDomain(activity);
        if (pageTaskDomain != null) {
            pageTaskDomain.addMonitorTask(IPageMonitor.MonitorTask.buildMonitorTask(z, runnable, LivePageMonitorDomain.DOMAIN_NAME, str));
            return true;
        }
        executeTask(runnable, z);
        return false;
    }

    public void createPageTaskDomain(Activity activity) {
        int identityHashCode;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-804662950")) {
            ipChange.ipc$dispatch("-804662950", new Object[]{this, activity});
        } else if (activity == null || !LivePerfUtils.supportPageMonitorTask() || (identityHashCode = System.identityHashCode(activity)) == 0 || this.mPageTaskDomain.indexOfKey(identityHashCode) >= 0) {
        } else {
            this.mPageTaskDomain.put(identityHashCode, new LivePageMonitorDomain(identityHashCode));
        }
    }

    @Nullable
    public LivePageMonitorDomain getPageTaskDomain(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212361627")) {
            return (LivePageMonitorDomain) ipChange.ipc$dispatch("212361627", new Object[]{this, activity});
        }
        if (activity != null) {
            return this.mPageTaskDomain.get(System.identityHashCode(activity));
        }
        return null;
    }

    public void releasePageTaskDomain(Activity activity) {
        int identityHashCode;
        LivePageMonitorDomain livePageMonitorDomain;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "514300865")) {
            ipChange.ipc$dispatch("514300865", new Object[]{this, activity});
        } else if (activity == null || (livePageMonitorDomain = this.mPageTaskDomain.get((identityHashCode = System.identityHashCode(activity)))) == null) {
        } else {
            livePageMonitorDomain.clear();
            this.mPageTaskDomain.remove(identityHashCode);
        }
    }

    public boolean addPageNormalTask(Activity activity, Runnable runnable, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-19638992") ? ((Boolean) ipChange.ipc$dispatch("-19638992", new Object[]{this, activity, runnable, str})).booleanValue() : addPageNormalTask(activity, runnable, str, 2);
    }

    public boolean addPageNormalTask(Activity activity, Runnable runnable, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-608779429")) {
            return ((Boolean) ipChange.ipc$dispatch("-608779429", new Object[]{this, activity, runnable, str, Integer.valueOf(i)})).booleanValue();
        }
        LivePageMonitorDomain pageTaskDomain = getInstance().getPageTaskDomain(activity);
        if (pageTaskDomain != null) {
            pageTaskDomain.addMonitorTask(IPageMonitor.MonitorTask.buildMonitorTask(runnable, LivePageMonitorDomain.DOMAIN_NAME, str).setTaskPriority(i));
            return true;
        }
        executeTask(runnable, true);
        return false;
    }
}
