package com.youku.middlewareservice_impl.provider.task;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.OneDependentTask;
import com.alibaba.android.onescheduler.OneSchedulerExceptionHandler;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.TaskTracker;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.task.InnerOneTask;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.task.CallableCB;
import com.youku.middlewareservice.provider.task.CommonTask;
import com.youku.middlewareservice.provider.task.DelayType;
import com.youku.middlewareservice.provider.task.DependentTask;
import com.youku.middlewareservice.provider.task.TaskRunnerProvider;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.lh1;
import tb.um1;
import tb.xm1;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class TaskRunnerProviderImpl implements TaskRunnerProvider {
    private static final int THREAD_MAX_COUNT = 480;
    boolean collectTaskCreator;
    boolean collectTaskRunTime;
    boolean enableDynamicConfigure;
    private Handler mHandler;
    private lh1 mMonitorConfig;
    int thread_count_peak;
    boolean useCoroutine;
    private final String TAG = "TaskRunnerProviderImpl";
    @NonNull
    private CopyOnWriteArraySet mCpuTaskSet = new CopyOnWriteArraySet();
    @NonNull
    private CopyOnWriteArraySet mNormalTaskSet = new CopyOnWriteArraySet();
    @NonNull
    private CopyOnWriteArraySet mRpcTaskSet = new CopyOnWriteArraySet();
    @NonNull
    private CopyOnWriteArraySet mIOTaskSet = new CopyOnWriteArraySet();
    private boolean mHasRegistered = false;
    boolean useOneScheduler = true;

    /* compiled from: Taobao */
    /* renamed from: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl$3  reason: invalid class name */
    /* loaded from: classes13.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$android$onescheduler$TaskType;

        static {
            int[] iArr = new int[TaskType.values().length];
            $SwitchMap$com$alibaba$android$onescheduler$TaskType = iArr;
            try {
                iArr[TaskType.CPU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$android$onescheduler$TaskType[TaskType.IO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$android$onescheduler$TaskType[TaskType.RPC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    private class MonitorData implements Serializable {
        public long addTs;
        public long executeTs;
        public long fininshTs;
        public long scheduleTs;

        private MonitorData() {
        }
    }

    public TaskRunnerProviderImpl() {
        Log.d("TaskRunnerProviderImpl", "useOneScheduler " + this.useOneScheduler + " collectTaskCreator " + this.collectTaskCreator + " collectTaskRunTime " + this.collectTaskRunTime + " useCoroutine " + this.useCoroutine + " enableDynamicConfigure " + this.enableDynamicConfigure);
        if (this.useOneScheduler) {
            if (this.enableDynamicConfigure) {
                um1.g().enableDynamicExecutorServicePolicy(TaskType.NORMAL, true);
                um1.g().enableDynamicExecutorServicePolicy(TaskType.CPU, true);
                um1.g().enableDynamicExecutorServicePolicy(TaskType.RPC, true);
                um1.g().enableDynamicExecutorServicePolicy(TaskType.SCHEDULER, true);
                um1.g().enableDynamicExecutorServicePolicy(TaskType.IO, true);
            }
            if (this.useCoroutine) {
                um1.g().setUseCoroutine(this.useCoroutine);
            }
            um1.g().j(new OneSchedulerExceptionHandler() { // from class: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl.1
                @Override // com.alibaba.android.onescheduler.OneSchedulerExceptionHandler
                public void onThreadPoolFull(TaskType taskType, int i, List<String> list) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("taskType", taskType);
                    hashMap.put("maximumPoolSize", Integer.valueOf(i));
                    hashMap.put("taskNames", list.toString());
                    hashMap.put("dumpTaskInfo", um1.g().c());
                }
            });
            this.mMonitorConfig = new lh1.a().f();
            um1.g().k(new TaskTracker() { // from class: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl.2
                @Override // com.alibaba.android.onescheduler.TaskTracker
                public void onCanceled(OneCommonTask oneCommonTask) {
                }

                @Override // com.alibaba.android.onescheduler.TaskTracker
                public void onExecute(OneCommonTask oneCommonTask) {
                    if (!(oneCommonTask instanceof InnerOneTask)) {
                        xm1.b("Task is not InnerOneTask");
                        return;
                    }
                    InnerOneTask innerOneTask = (InnerOneTask) oneCommonTask;
                    if (innerOneTask.getInnerData() != null) {
                        ((MonitorData) innerOneTask.getInnerData()).executeTs = SystemClock.uptimeMillis();
                    }
                    if (AppInfoProviderProxy.isDebuggable()) {
                        Log.d("TaskRunnerProviderImpl", "onExecute " + innerOneTask.getGroupName() + "." + innerOneTask.getName());
                    }
                    int i = AnonymousClass3.$SwitchMap$com$alibaba$android$onescheduler$TaskType[innerOneTask.getTaskType().ordinal()];
                    if (i == 1) {
                        TaskRunnerProviderImpl.this.mCpuTaskSet.add(oneCommonTask);
                    } else if (i == 2) {
                        TaskRunnerProviderImpl.this.mIOTaskSet.add(oneCommonTask);
                    } else if (i != 3) {
                        TaskRunnerProviderImpl.this.mNormalTaskSet.add(oneCommonTask);
                    } else {
                        TaskRunnerProviderImpl.this.mRpcTaskSet.add(oneCommonTask);
                    }
                }

                @Override // com.alibaba.android.onescheduler.TaskTracker
                public void onFinished(OneCommonTask oneCommonTask) {
                    int a;
                    InnerOneTask innerOneTask = (InnerOneTask) oneCommonTask;
                    if (innerOneTask == null) {
                        return;
                    }
                    int i = AnonymousClass3.$SwitchMap$com$alibaba$android$onescheduler$TaskType[innerOneTask.getTaskType().ordinal()];
                    if (i == 1) {
                        a = TaskRunnerProviderImpl.this.mMonitorConfig.a();
                        TaskRunnerProviderImpl.this.mCpuTaskSet.remove(innerOneTask);
                    } else if (i == 2) {
                        a = TaskRunnerProviderImpl.this.mMonitorConfig.b();
                        TaskRunnerProviderImpl.this.mIOTaskSet.remove(innerOneTask);
                    } else if (i != 3) {
                        a = TaskRunnerProviderImpl.this.mMonitorConfig.c();
                        TaskRunnerProviderImpl.this.mNormalTaskSet.remove(innerOneTask);
                    } else {
                        a = TaskRunnerProviderImpl.this.mMonitorConfig.d();
                        TaskRunnerProviderImpl.this.mRpcTaskSet.remove(innerOneTask);
                    }
                    if (innerOneTask.getInnerData() != null) {
                        ((MonitorData) innerOneTask.getInnerData()).fininshTs = SystemClock.uptimeMillis();
                        long uptimeMillis = SystemClock.uptimeMillis() - ((MonitorData) innerOneTask.getInnerData()).addTs;
                        if (uptimeMillis > a) {
                            innerOneTask.getName();
                        }
                        if (AppInfoProviderProxy.isDebuggable()) {
                            if (TaskRunnerProviderImpl.this.thread_count_peak < Thread.activeCount()) {
                                TaskRunnerProviderImpl.this.thread_count_peak = Thread.activeCount();
                            }
                            Log.d("TaskRunnerProviderImpl", "Thread.activeCount() " + Thread.activeCount() + " thread_count_peak " + TaskRunnerProviderImpl.this.thread_count_peak);
                            Log.d("TaskRunnerProviderImpl", "onFinished " + innerOneTask.getGroupName() + "." + innerOneTask.getName() + " in " + uptimeMillis);
                        }
                    }
                    Thread.activeCount();
                    boolean z = TaskRunnerProviderImpl.this.collectTaskRunTime;
                }

                @Override // com.alibaba.android.onescheduler.TaskTracker
                public void onSchedule(OneCommonTask oneCommonTask) {
                    InnerOneTask innerOneTask = (InnerOneTask) oneCommonTask;
                    if (innerOneTask.getInnerData() == null) {
                        return;
                    }
                    ((MonitorData) innerOneTask.getInnerData()).scheduleTs = SystemClock.uptimeMillis();
                }

                @Override // com.alibaba.android.onescheduler.TaskTracker
                public void onStart(OneCommonTask oneCommonTask) {
                    MonitorData monitorData = new MonitorData();
                    monitorData.addTs = SystemClock.uptimeMillis();
                    ((InnerOneTask) oneCommonTask).setInnerData(monitorData);
                }
            });
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    private Priority convertEnum(com.youku.middlewareservice.provider.task.Priority priority) {
        if (priority == com.youku.middlewareservice.provider.task.Priority.IMMEDIATE) {
            return Priority.IMMEDIATE;
        }
        if (priority == com.youku.middlewareservice.provider.task.Priority.HIGH) {
            return Priority.HIGH;
        }
        if (priority == com.youku.middlewareservice.provider.task.Priority.LOW) {
            return Priority.LOW;
        }
        return Priority.NORMAL;
    }

    private void reportTaskCreator(String str) {
        try {
            if (AppInfoProviderProxy.isDebuggable()) {
                Log.d("TaskRunnerProviderImpl", "Task " + str + " trig by " + Log.getStackTraceString(new Throwable()));
            }
            new HashMap(1).put("stackTrace", Log.getStackTraceString(new Throwable()));
        } catch (Throwable unused) {
        }
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public DependentTask createAnchorTask(@NonNull String str, @NonNull String str2, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority) {
        if (this.useOneScheduler) {
            return (DependentTask) um1.g().h().setTaskName(str2).setTaskGroup((str == null || um1.g().f(str) == null) ? "default_group" : "default_group").setAnchorTask(true).setTaskType(convertEnum(taskType)).setPriority(convertEnum(priority)).buildDependentTask();
        }
        return null;
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public DependentTask createDependentTask(@NonNull String str, @NonNull DependentTask dependentTask, @NonNull String str2, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority, Callable<?> callable, CallableCB<?> callableCB) {
        if (this.useOneScheduler) {
            if (str == null || um1.g().f(str) == null) {
                str = dependentTask.getGroupName();
            }
            OneDependentTask buildDependentTask = um1.g().h().setTaskName(str2).setTaskGroup(str).setAnchorTask(false).setTaskType(convertEnum(taskType)).setPriority(convertEnum(priority)).setCallable(callable, callableCB).buildDependentTask();
            buildDependentTask.after(dependentTask);
            return (DependentTask) buildDependentTask;
        }
        return null;
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void destroyGroup(String str) {
        if (this.useOneScheduler) {
            um1.g().b(str);
        }
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    @Deprecated
    public void execute(@NonNull Runnable runnable) {
        if (this.collectTaskCreator) {
            reportTaskCreator("not set");
        }
        if (this.useOneScheduler) {
            um1.d(runnable);
        }
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void initTaskGroup(String str, int i) {
        if (this.useOneScheduler) {
            um1.g().a(str, i);
        }
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void pauseTasks(@NonNull String str) {
        if (this.useOneScheduler) {
            um1.g().i(str);
        }
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void resumeTasks(@NonNull String str) {
        if (this.useOneScheduler) {
            um1.g().l(str);
        }
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public CommonTask runCancelableTask(@NonNull String str, @NonNull String str2, long j, long j2, DelayType delayType, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority, Callable<?> callable, CallableCB<?> callableCB) {
        if (this.useOneScheduler) {
            str = (str == null || um1.g().f(str) == null) ? "default_group" : "default_group";
            if (this.collectTaskCreator) {
                reportTaskCreator(str2);
            }
            OneCommonTask buildCommonTask = um1.g().h().setTaskName(str2).setTaskGroup(str).setAnchorTask(false).setTaskType(convertEnum(taskType)).setPriority(convertEnum(priority)).setCallable(callable, callableCB).setDelayTime(j2).setInitialDelayTime(j).setIsFixDelayed(convertEnum(delayType)).buildCommonTask();
            buildCommonTask.run();
            return new CommonTask(buildCommonTask);
        }
        return null;
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void runDelayedTask(@NonNull String str, @NonNull String str2, long j, long j2, DelayType delayType, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority, Callable<?> callable, CallableCB<?> callableCB) {
        runCancelableTask(str, str2, j, j2, delayType, com.youku.middlewareservice.provider.task.TaskType.SCHEDULER, priority, callable, callableCB);
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void runDependentTasks(@NonNull DependentTask dependentTask) {
        if (this.useOneScheduler) {
            dependentTask.run();
        }
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void runTask(@NonNull String str, @NonNull String str2, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority, Callable<?> callable, CallableCB<?> callableCB) {
        if (this.useOneScheduler) {
            str = (str == null || um1.g().f(str) == null) ? "default_group" : "default_group";
            if (this.collectTaskCreator) {
                reportTaskCreator(str2);
            }
            um1.g().h().setTaskName(str2).setTaskGroup(str).setAnchorTask(false).setTaskType(convertEnum(taskType)).setPriority(convertEnum(priority)).setCallable(callable, callableCB).buildCommonTask().run();
        }
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void runDelayedTask(@NonNull String str, @NonNull String str2, long j, long j2, DelayType delayType, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority, Runnable runnable) {
        runCancelableTask(str, str2, j, j2, delayType, com.youku.middlewareservice.provider.task.TaskType.SCHEDULER, priority, runnable);
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    @Deprecated
    public void execute(@NonNull Runnable runnable, com.youku.middlewareservice.provider.task.TaskType taskType) {
        if (this.collectTaskCreator) {
            reportTaskCreator("not set");
        }
        if (this.useOneScheduler) {
            um1.e(runnable, convertEnum(taskType));
        }
    }

    private TaskType convertEnum(com.youku.middlewareservice.provider.task.TaskType taskType) {
        if (taskType == com.youku.middlewareservice.provider.task.TaskType.CPU) {
            return TaskType.CPU;
        }
        if (taskType == com.youku.middlewareservice.provider.task.TaskType.IO) {
            return TaskType.IO;
        }
        if (taskType == com.youku.middlewareservice.provider.task.TaskType.RPC) {
            return TaskType.RPC;
        }
        if (taskType == com.youku.middlewareservice.provider.task.TaskType.SCHEDULER) {
            return TaskType.SCHEDULER;
        }
        return TaskType.NORMAL;
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    @Deprecated
    public void execute(@NonNull Runnable runnable, com.youku.middlewareservice.provider.task.TaskType taskType, long j) {
        if (this.collectTaskCreator) {
            reportTaskCreator("not set");
        }
        if (this.useOneScheduler) {
            if (this.collectTaskCreator) {
                reportTaskCreator("TaskRunnerProvider execute");
            }
            um1.g().h().setTaskName("TaskRunnerProviderImpl execute").setTaskGroup("default_group").setAnchorTask(false).setPriority(Priority.NORMAL).setTaskType(TaskType.SCHEDULER).setRunnable(runnable).setDelayTime(j).setInitialDelayTime(j).setIsFixDelayed(com.alibaba.android.onescheduler.DelayType.ONE).buildCommonTask().run();
            return;
        }
        this.mHandler.postDelayed(runnable, j);
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public DependentTask createDependentTask(@NonNull String str, @NonNull DependentTask dependentTask, @NonNull String str2, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority, Runnable runnable) {
        if (this.useOneScheduler) {
            if (str == null || um1.g().f(str) == null) {
                str = dependentTask.getGroupName();
            }
            OneDependentTask buildDependentTask = um1.g().h().setTaskName(str2).setTaskGroup(str).setAnchorTask(false).setTaskType(convertEnum(taskType)).setPriority(convertEnum(priority)).setRunnable(runnable).buildDependentTask();
            buildDependentTask.after(dependentTask);
            return (DependentTask) buildDependentTask;
        }
        return null;
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public void runTask(@NonNull String str, @NonNull String str2, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority, Runnable runnable) {
        if (this.useOneScheduler) {
            str = (str == null || um1.g().f(str) == null) ? "default_group" : "default_group";
            if (this.collectTaskCreator) {
                reportTaskCreator(str2);
            }
            um1.g().h().setTaskName(str2).setTaskGroup(str).setAnchorTask(false).setTaskType(convertEnum(taskType)).setPriority(convertEnum(priority)).setRunnable(runnable).buildCommonTask().run();
        }
    }

    private com.alibaba.android.onescheduler.DelayType convertEnum(DelayType delayType) {
        if (delayType == DelayType.FIXED_DELAY) {
            return com.alibaba.android.onescheduler.DelayType.FIXED_DELAY;
        }
        if (delayType == DelayType.FIXED_RATE) {
            return com.alibaba.android.onescheduler.DelayType.FIXED_RATE;
        }
        return com.alibaba.android.onescheduler.DelayType.ONE;
    }

    @Override // com.youku.middlewareservice.provider.task.TaskRunnerProvider
    public CommonTask runCancelableTask(@NonNull String str, @NonNull String str2, long j, long j2, DelayType delayType, com.youku.middlewareservice.provider.task.TaskType taskType, com.youku.middlewareservice.provider.task.Priority priority, Runnable runnable) {
        if (this.useOneScheduler) {
            str = (str == null || um1.g().f(str) == null) ? "default_group" : "default_group";
            if (this.collectTaskCreator) {
                reportTaskCreator(str2);
            }
            OneCommonTask buildCommonTask = um1.g().h().setTaskName(str2).setTaskGroup(str).setAnchorTask(false).setTaskType(convertEnum(taskType)).setPriority(convertEnum(priority)).setRunnable(runnable).setDelayTime(j2).setInitialDelayTime(j).setIsFixDelayed(convertEnum(delayType)).buildCommonTask();
            buildCommonTask.run();
            return new CommonTask(buildCommonTask);
        }
        return null;
    }
}
