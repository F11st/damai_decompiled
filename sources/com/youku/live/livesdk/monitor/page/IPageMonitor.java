package com.youku.live.livesdk.monitor.page;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IPageMonitor {
    public static final int STATE_MONITOR_FINISH = 2;
    public static final int STATE_MONITOR_INIT = 0;
    public static final int STATE_MONITOR_START = 1;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class MonitorTask implements Comparable<MonitorTask> {
        private static transient /* synthetic */ IpChange $ipChange = null;
        public static final int PRIORITY_EXTREMELY_HIGH = 0;
        public static final int PRIORITY_HIGH = 1;
        public static final int PRIORITY_LOW = 3;
        public static final int PRIORITY_MIDDLE = 2;
        String pageName;
        Runnable runnable;
        String taskName;
        boolean runInMainThread = true;
        int delayTime = 50;
        int taskPriority = 2;

        public static MonitorTask buildMonitorTask(Runnable runnable, String str, String str2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-450243713") ? (MonitorTask) ipChange.ipc$dispatch("-450243713", new Object[]{runnable, str, str2}) : buildMonitorTask(true, runnable, str, str2, 50);
        }

        public int getTaskPriority() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "693129137") ? ((Integer) ipChange.ipc$dispatch("693129137", new Object[]{this})).intValue() : this.taskPriority;
        }

        public MonitorTask setTaskPriority(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1449954916")) {
                return (MonitorTask) ipChange.ipc$dispatch("-1449954916", new Object[]{this, Integer.valueOf(i)});
            }
            this.taskPriority = i;
            return this;
        }

        public static MonitorTask buildMonitorTask(boolean z, Runnable runnable, String str, String str2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2090065955") ? (MonitorTask) ipChange.ipc$dispatch("2090065955", new Object[]{Boolean.valueOf(z), runnable, str, str2}) : buildMonitorTask(z, runnable, str, str2, 50);
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull MonitorTask monitorTask) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "687962695") ? ((Integer) ipChange.ipc$dispatch("687962695", new Object[]{this, monitorTask})).intValue() : this.taskPriority - monitorTask.taskPriority;
        }

        public static MonitorTask buildMonitorTask(boolean z, Runnable runnable, String str, String str2, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2059514220")) {
                return (MonitorTask) ipChange.ipc$dispatch("-2059514220", new Object[]{Boolean.valueOf(z), runnable, str, str2, Integer.valueOf(i)});
            }
            MonitorTask monitorTask = new MonitorTask();
            monitorTask.runInMainThread = z;
            monitorTask.runnable = runnable;
            monitorTask.pageName = str;
            monitorTask.taskName = str2;
            monitorTask.delayTime = i;
            return monitorTask;
        }
    }

    void addMonitorTask(MonitorTask monitorTask);

    void clear();

    void clearBarrier();

    void initMonitor(String... strArr);

    void removeMonitorTask(MonitorTask monitorTask);

    void setBarrier();

    void setExecuteDelay(long j);
}
