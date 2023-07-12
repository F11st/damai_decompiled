package tb;

import androidx.annotation.NonNull;
import com.alibaba.android.onescheduler.OneCommonTask;
import com.alibaba.android.onescheduler.OneSchedulerExceptionHandler;
import com.alibaba.android.onescheduler.TaskTracker;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.event.OnTaskFinishedListener;
import com.alibaba.android.onescheduler.group.ITaskTools;
import com.alibaba.android.onescheduler.task.InnerOneTask;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.FutureTask;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class tf0 {
    @NonNull
    private CopyOnWriteArraySet a;
    @NonNull
    private CopyOnWriteArraySet b;
    private OnTaskFinishedListener c;
    private ITaskTools d;

    /* compiled from: Taobao */
    /* renamed from: tb.tf0$b */
    /* loaded from: classes5.dex */
    private static class C9726b {
        private static final tf0 a = new tf0();
    }

    @NonNull
    public static tf0 a() {
        return C9726b.a;
    }

    public void b(@NonNull OneCommonTask oneCommonTask) {
        if (oneCommonTask == null) {
            return;
        }
        TaskTracker taskTracker = ((InnerOneTask) oneCommonTask).getTaskTracker();
        if (taskTracker != null) {
            taskTracker.onCanceled(oneCommonTask);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((TaskTracker) it.next()).onCanceled(oneCommonTask);
        }
    }

    public void c(@NonNull FutureTask futureTask) {
        ITaskTools iTaskTools = this.d;
        if (iTaskTools == null) {
            xm1.a("TaskTools is null");
            return;
        }
        OneCommonTask convert = iTaskTools.convert(futureTask);
        if (convert == null) {
            return;
        }
        TaskTracker taskTracker = ((InnerOneTask) convert).getTaskTracker();
        if (taskTracker != null) {
            taskTracker.onExecute(convert);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((TaskTracker) it.next()).onExecute(convert);
        }
    }

    public void d(@NonNull FutureTask futureTask) {
        ITaskTools iTaskTools = this.d;
        if (iTaskTools == null) {
            xm1.a("TaskTools is null");
            return;
        }
        OneCommonTask convert = iTaskTools.convert(futureTask);
        if (convert == null) {
            return;
        }
        OnTaskFinishedListener onTaskFinishedListener = this.c;
        if (onTaskFinishedListener != null) {
            onTaskFinishedListener.onFinished(futureTask);
        }
        TaskTracker taskTracker = ((InnerOneTask) convert).getTaskTracker();
        if (taskTracker != null) {
            taskTracker.onFinished(convert);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((TaskTracker) it.next()).onFinished(convert);
        }
    }

    public void e(@NonNull FutureTask futureTask) {
        ITaskTools iTaskTools = this.d;
        if (iTaskTools == null) {
            xm1.a("TaskTools is null");
            return;
        }
        OneCommonTask convert = iTaskTools.convert(futureTask);
        if (convert == null) {
            return;
        }
        TaskTracker taskTracker = ((InnerOneTask) convert).getTaskTracker();
        if (taskTracker != null) {
            taskTracker.onSchedule(convert);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((TaskTracker) it.next()).onSchedule(convert);
        }
    }

    public void f(@NonNull OneCommonTask oneCommonTask) {
        if (oneCommonTask == null) {
            return;
        }
        TaskTracker taskTracker = ((InnerOneTask) oneCommonTask).getTaskTracker();
        if (taskTracker != null) {
            taskTracker.onStart(oneCommonTask);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((TaskTracker) it.next()).onStart(oneCommonTask);
        }
    }

    public void g(@NonNull TaskType taskType, int i) {
        if (this.d == null) {
            xm1.a("TaskTools is null");
            return;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((OneSchedulerExceptionHandler) it.next()).onThreadPoolFull(taskType, i, this.d.getTaskNames(taskType));
        }
    }

    public void h(@NonNull OneSchedulerExceptionHandler oneSchedulerExceptionHandler) {
        this.b.add(oneSchedulerExceptionHandler);
    }

    public void i(@NonNull TaskTracker taskTracker) {
        this.a.add(taskTracker);
    }

    public void j(OnTaskFinishedListener onTaskFinishedListener) {
        this.c = onTaskFinishedListener;
    }

    public void k(ITaskTools iTaskTools) {
        this.d = iTaskTools;
    }

    private tf0() {
        this.a = new CopyOnWriteArraySet();
        this.b = new CopyOnWriteArraySet();
    }
}
