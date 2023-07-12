package com.youku.middlewareservice.provider.task;

import android.util.Log;
import java.util.concurrent.Callable;
import org.joor.C8883a;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class TaskRunnerProviderProxy {
    private static TaskRunnerProvider sProxy;

    public static DependentTask createAnchorTask(String str, String str2, TaskType taskType, Priority priority) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            return sProxy.createAnchorTask(str, str2, taskType, priority);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static DependentTask createDependentTask(String str, DependentTask dependentTask, String str2, TaskType taskType, Priority priority, Callable<?> callable, CallableCB<?> callableCB) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            return sProxy.createDependentTask(str, dependentTask, str2, taskType, priority, callable, callableCB);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void destroyGroup(String str) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.destroyGroup(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void execute(Runnable runnable) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.execute(runnable);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static TaskRunnerProvider getProxy() {
        if (sProxy == null) {
            sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
        }
        return sProxy;
    }

    public static void initTaskGroup(String str, int i) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.initTaskGroup(str, i);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void inject(Class cls) {
        if (sProxy == null && TaskRunnerProvider.class.isAssignableFrom(cls)) {
            try {
                sProxy = (TaskRunnerProvider) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void pauseTasks(String str) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.pauseTasks(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void resumeTasks(String str) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.resumeTasks(str);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static CommonTask runCancelableTask(String str, String str2, long j, long j2, DelayType delayType, TaskType taskType, Priority priority, Runnable runnable) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            return sProxy.runCancelableTask(str, str2, j, j2, delayType, taskType, priority, runnable);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void runDelayedTask(String str, String str2, long j, long j2, DelayType delayType, TaskType taskType, Priority priority, Callable<?> callable, CallableCB<?> callableCB) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.runDelayedTask(str, str2, j, j2, delayType, taskType, priority, callable, callableCB);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void runDependentTasks(DependentTask dependentTask) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.runDependentTasks(dependentTask);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void runTask(String str, String str2, TaskType taskType, Priority priority, Callable<?> callable, CallableCB<?> callableCB) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.runTask(str, str2, taskType, priority, callable, callableCB);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static DependentTask createDependentTask(String str, DependentTask dependentTask, String str2, TaskType taskType, Priority priority, Runnable runnable) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            return sProxy.createDependentTask(str, dependentTask, str2, taskType, priority, runnable);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void execute(Runnable runnable, TaskType taskType) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.execute(runnable, taskType);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static CommonTask runCancelableTask(String str, String str2, long j, long j2, DelayType delayType, TaskType taskType, Priority priority, Callable<?> callable, CallableCB<?> callableCB) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            return sProxy.runCancelableTask(str, str2, j, j2, delayType, taskType, priority, callable, callableCB);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
            return null;
        }
    }

    public static void runDelayedTask(String str, String str2, long j, long j2, DelayType delayType, TaskType taskType, Priority priority, Runnable runnable) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.runDelayedTask(str, str2, j, j2, delayType, taskType, priority, runnable);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void runTask(String str, String str2, TaskType taskType, Priority priority, Runnable runnable) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.runTask(str, str2, taskType, priority, runnable);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }

    public static void execute(Runnable runnable, TaskType taskType, long j) {
        try {
            if (sProxy == null) {
                sProxy = (TaskRunnerProvider) C8883a.j("com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl").b().f();
            }
            sProxy.execute(runnable, taskType, j);
        } catch (Throwable th) {
            Log.e("OneService", "Create AutoProxyClass instance error, implClassName: com.youku.middlewareservice_impl.provider.task.TaskRunnerProviderImpl  Throwable: " + th.toString());
        }
    }
}
