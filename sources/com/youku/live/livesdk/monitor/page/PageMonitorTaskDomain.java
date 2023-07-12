package com.youku.live.livesdk.monitor.page;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.thread.ILiveThreadFactory;
import com.youku.live.livesdk.monitor.page.IPageMonitor;
import com.youku.live.livesdk.util.DebugHelp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class PageMonitorTaskDomain implements IPageMonitor {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DEFAULT_DELAY = 50;
    private Object mBarrier;
    private ILiveThreadFactory mLiveThreadFactoryImpl;
    private Handler mMainHandler;
    protected HashMap<String, PageSate> mPageState;
    private PageTaskQueue mPendingTaskPool;
    private HashMap<String, PageTaskQueue> mTaskPool;
    private boolean hasInit = false;
    private long mExecutedDelay = 50;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static abstract class CheckPageStateRunnable implements Runnable {
        private WeakReference<PageSate> pageStateWK;

        public CheckPageStateRunnable(PageSate pageSate) {
            this.pageStateWK = new WeakReference<>(pageSate);
        }

        protected PageSate getPageState() {
            WeakReference<PageSate> weakReference = this.pageStateWK;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return this.pageStateWK.get();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class PageSate {
        Runnable checkStateRunnable;
        int state = 0;
    }

    private void clearMonitorTasks(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471736483")) {
            ipChange.ipc$dispatch("-471736483", new Object[]{this, str});
        } else {
            this.mMainHandler.post(new Runnable() { // from class: com.youku.live.livesdk.monitor.page.PageMonitorTaskDomain.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1642832005")) {
                        ipChange2.ipc$dispatch("-1642832005", new Object[]{this});
                        return;
                    }
                    PageTaskQueue pageTaskQueue = (PageTaskQueue) PageMonitorTaskDomain.this.mTaskPool.get(str);
                    if (pageTaskQueue != null) {
                        pageTaskQueue.clear();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executePendingTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358734545")) {
            ipChange.ipc$dispatch("-1358734545", new Object[]{this});
            return;
        }
        Iterator<IPageMonitor.MonitorTask> it = this.mPendingTaskPool.iterator();
        while (it.hasNext()) {
            executeTask(it.next());
        }
        this.mPendingTaskPool.clear();
    }

    private void initPageProperty(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280439491")) {
            ipChange.ipc$dispatch("-1280439491", new Object[]{this, strArr});
            return;
        }
        for (String str : strArr) {
            this.mTaskPool.put(str, new PageTaskQueue(10));
            this.mPageState.put(str, new PageSate());
        }
    }

    @Override // com.youku.live.livesdk.monitor.page.IPageMonitor
    public void addMonitorTask(IPageMonitor.MonitorTask monitorTask) {
        HashMap<String, PageTaskQueue> hashMap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1657802961")) {
            ipChange.ipc$dispatch("-1657802961", new Object[]{this, monitorTask});
        } else if (!TextUtils.isEmpty(monitorTask.pageName) && (hashMap = this.mTaskPool) != null && this.mPageState != null && hashMap.containsKey(monitorTask.pageName) && this.mPageState.containsKey(monitorTask.pageName)) {
            if (!this.hasInit) {
                executeTask(monitorTask);
                return;
            }
            PageSate pageSate = this.mPageState.get(monitorTask.pageName);
            if (pageSate != null && pageSate.state >= 2) {
                if (this.mBarrier != null) {
                    this.mPendingTaskPool.offer(monitorTask);
                    return;
                } else {
                    executeTask(monitorTask);
                    return;
                }
            }
            this.mTaskPool.get(monitorTask.pageName).offer(monitorTask);
        } else {
            executeTask(monitorTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeMonitorState(final String str, int i) {
        PageSate pageSate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1287219958")) {
            ipChange.ipc$dispatch("-1287219958", new Object[]{this, str, Integer.valueOf(i)});
        } else if (!this.mPageState.containsKey(str) || (pageSate = this.mPageState.get(str)) == null) {
        } else {
            pageSate.state = i;
            if (i == 1) {
                CheckPageStateRunnable checkPageStateRunnable = new CheckPageStateRunnable(pageSate) { // from class: com.youku.live.livesdk.monitor.page.PageMonitorTaskDomain.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1446318500")) {
                            ipChange2.ipc$dispatch("-1446318500", new Object[]{this});
                        } else if (PageMonitorTaskDomain.this.hasInit) {
                            PageSate pageState = getPageState();
                            if (pageState == null || pageState.state < 2) {
                                if (pageState != null) {
                                    pageState.state = 2;
                                }
                                PageMonitorTaskDomain.this.executeTaskList(str);
                            }
                        }
                    }
                };
                pageSate.checkStateRunnable = checkPageStateRunnable;
                this.mMainHandler.postDelayed(checkPageStateRunnable, getCheckRunnableDelay());
            } else if (i == 2) {
                this.mMainHandler.removeCallbacks(pageSate.checkStateRunnable);
                executeTaskList(str);
            }
        }
    }

    @Override // com.youku.live.livesdk.monitor.page.IPageMonitor
    public final void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234542151")) {
            ipChange.ipc$dispatch("1234542151", new Object[]{this});
        } else if (this.hasInit) {
            this.mMainHandler.removeCallbacksAndMessages(null);
            this.mMainHandler = null;
            release();
            this.hasInit = false;
            this.mTaskPool.clear();
            this.mPageState.clear();
            this.mPendingTaskPool.clear();
        }
    }

    @Override // com.youku.live.livesdk.monitor.page.IPageMonitor
    public void clearBarrier() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618325868")) {
            ipChange.ipc$dispatch("1618325868", new Object[]{this});
            return;
        }
        this.mBarrier = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            executePendingTask();
        } else {
            this.mMainHandler.post(new Runnable() { // from class: com.youku.live.livesdk.monitor.page.PageMonitorTaskDomain.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1839345510")) {
                        ipChange2.ipc$dispatch("-1839345510", new Object[]{this});
                    } else {
                        PageMonitorTaskDomain.this.executePendingTask();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void executeTask(IPageMonitor.MonitorTask monitorTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1414695057")) {
            ipChange.ipc$dispatch("1414695057", new Object[]{this, monitorTask});
            return;
        }
        if (DebugHelp.isDebugBuild()) {
            Log.d("PageMonitorTaskDomain", "executeTask:" + monitorTask.taskName + AVFSCacheConstants.COMMA_SEP + monitorTask.runnable.hashCode());
        }
        if (monitorTask == null) {
            return;
        }
        if (this.hasInit) {
            if (monitorTask.runInMainThread) {
                if (this.mMainHandler.getLooper() == Looper.myLooper()) {
                    monitorTask.runnable.run();
                } else {
                    this.mMainHandler.post(monitorTask.runnable);
                }
            } else if (this.mMainHandler.getLooper() == Looper.myLooper()) {
                if (this.mLiveThreadFactoryImpl == null) {
                    try {
                        this.mLiveThreadFactoryImpl = (ILiveThreadFactory) Dsl.getService(ILiveThreadFactory.class);
                    } catch (Exception e) {
                        if (DebugHelp.isDebugBuild()) {
                            e.printStackTrace();
                        }
                    }
                }
                ILiveThreadFactory iLiveThreadFactory = this.mLiveThreadFactoryImpl;
                if (iLiveThreadFactory == null) {
                    monitorTask.runnable.run();
                } else {
                    iLiveThreadFactory.excute(monitorTask.runnable);
                }
            } else {
                monitorTask.runnable.run();
            }
        } else if (monitorTask.runInMainThread) {
            if (this.mMainHandler.getLooper() == Looper.myLooper()) {
                monitorTask.runnable.run();
            } else {
                this.mMainHandler.post(monitorTask.runnable);
            }
        } else {
            monitorTask.runnable.run();
        }
    }

    protected void executeTaskList(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960702054")) {
            ipChange.ipc$dispatch("960702054", new Object[]{this, str});
            return;
        }
        Handler handler = this.mMainHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.youku.live.livesdk.monitor.page.PageMonitorTaskDomain.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2035859015")) {
                    ipChange2.ipc$dispatch("-2035859015", new Object[]{this});
                    return;
                }
                PageTaskQueue pageTaskQueue = (PageTaskQueue) PageMonitorTaskDomain.this.mTaskPool.get(str);
                if (pageTaskQueue == null || pageTaskQueue.isEmpty()) {
                    return;
                }
                do {
                    IPageMonitor.MonitorTask poll = pageTaskQueue.poll();
                    if (!PageMonitorTaskDomain.this.hasInit) {
                        return;
                    }
                    if (poll != null) {
                        if (PageMonitorTaskDomain.this.mBarrier != null) {
                            PageMonitorTaskDomain.this.mPendingTaskPool.add(poll);
                        } else {
                            PageMonitorTaskDomain.this.executeTask(poll);
                        }
                    }
                } while (!pageTaskQueue.isEmpty());
            }
        }, this.mExecutedDelay);
    }

    protected long getCheckRunnableDelay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1434542348")) {
            return ((Long) ipChange.ipc$dispatch("-1434542348", new Object[]{this})).longValue();
        }
        return 2000L;
    }

    @Override // com.youku.live.livesdk.monitor.page.IPageMonitor
    public void initMonitor(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "247497429")) {
            ipChange.ipc$dispatch("247497429", new Object[]{this, strArr});
            return;
        }
        if (!this.hasInit) {
            this.hasInit = true;
            this.mTaskPool = new HashMap<>(strArr.length);
            this.mPendingTaskPool = new PageTaskQueue(10);
            this.mPageState = new HashMap<>(strArr.length);
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        initPageProperty(strArr);
    }

    protected abstract void release();

    @Override // com.youku.live.livesdk.monitor.page.IPageMonitor
    public void removeMonitorTask(IPageMonitor.MonitorTask monitorTask) {
        PageTaskQueue pageTaskQueue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2116488496")) {
            ipChange.ipc$dispatch("2116488496", new Object[]{this, monitorTask});
        } else if (this.hasInit) {
            if ((TextUtils.isEmpty(monitorTask.pageName) && this.mTaskPool.containsKey(monitorTask.pageName)) || (pageTaskQueue = this.mTaskPool.get(monitorTask.pageName)) == null) {
                return;
            }
            pageTaskQueue.remove(monitorTask);
        }
    }

    @Override // com.youku.live.livesdk.monitor.page.IPageMonitor
    public void setBarrier() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1013045887")) {
            ipChange.ipc$dispatch("-1013045887", new Object[]{this});
        } else {
            this.mBarrier = new Object();
        }
    }

    @Override // com.youku.live.livesdk.monitor.page.IPageMonitor
    public void setExecuteDelay(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082426144")) {
            ipChange.ipc$dispatch("-1082426144", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mExecutedDelay = j;
        }
    }
}
