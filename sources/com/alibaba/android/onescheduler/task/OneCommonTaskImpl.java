package com.alibaba.android.onescheduler.task;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.CallableCallback;
import com.alibaba.android.onescheduler.Priority;
import com.alibaba.android.onescheduler.TaskTracker;
import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.threadpool.PriorityFutureTask;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import tb.ll2;
import tb.tf0;
import tb.wm1;
import tb.xm1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class OneCommonTaskImpl implements InnerOneTask {
    protected long mAddedTime;
    protected CallableCallback mCallback;
    protected Object mData;
    protected long mDelayTime;
    protected Executor mExecutor;
    @Nullable
    protected PriorityFutureTask mFutureTask;
    protected String mGroupName;
    protected Object mInnerData;
    protected boolean mIsCancelled;
    protected boolean mIsRunning;
    protected String mName;
    protected boolean mStarted = false;
    protected TaskTracker mTaskTracker;
    protected TaskType mTaskType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OneCommonTaskImpl(@NonNull a aVar) {
        checkBuilderParameters(aVar);
        if (!aVar.h) {
            if (aVar.d != null) {
                this.mFutureTask = new PriorityFutureTask(aVar.d, null);
            } else {
                this.mFutureTask = new PriorityFutureTask(aVar.e);
            }
            this.mFutureTask.setPriority(aVar.a);
        }
        this.mGroupName = aVar.b;
        this.mName = aVar.c;
        this.mCallback = aVar.f;
        this.mTaskType = aVar.g;
        this.mExecutor = aVar.i;
        this.mTaskTracker = aVar.j;
        this.mDelayTime = aVar.k;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void cancel(boolean z) {
        if (this.mIsCancelled) {
            return;
        }
        this.mIsCancelled = true;
        tf0.a().b(this);
        if (this.mFutureTask.cancel(z)) {
            ll2.f().d(this);
        }
    }

    protected void checkBuilderParameters(@NonNull a aVar) {
        if (!aVar.h && aVar.d == null && aVar.e == null) {
            xm1.a("Runnable and Callable are null !!!");
        }
        if (TextUtils.isEmpty(aVar.c) || TextUtils.isEmpty(aVar.b)) {
            xm1.a("Name or GroupName is null !!!");
        }
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public long getAddedTime() {
        return this.mAddedTime;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public CallableCallback getCallback() {
        return this.mCallback;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public Object getData() {
        return this.mData;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public long getDelayTime() {
        return this.mDelayTime;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    @Nullable
    public FutureTask getFutureTask() {
        return this.mFutureTask;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public String getGroupName() {
        return this.mGroupName;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public Object getInnerData() {
        return this.mInnerData;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public String getName() {
        return this.mName;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public Priority getPriority() {
        PriorityFutureTask priorityFutureTask = this.mFutureTask;
        if (priorityFutureTask == null) {
            return Priority.NORMAL;
        }
        return priorityFutureTask.getPriority();
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public long getPrioritySequence() {
        PriorityFutureTask priorityFutureTask = this.mFutureTask;
        if (priorityFutureTask == null) {
            return 0L;
        }
        return priorityFutureTask.getPrioritySequence();
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public TaskTracker getTaskTracker() {
        return this.mTaskTracker;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public TaskType getTaskType() {
        return this.mTaskType;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public boolean isCancelled() {
        return this.mIsCancelled;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public boolean isRunningState() {
        return this.mIsRunning;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mStarted || this.mIsCancelled) {
            wm1.a("Warnning: OneScheduler task %s is reused or cancelled!!!", this.mName);
            return;
        }
        tf0.a().f(this);
        ll2.f().h(this);
        this.mStarted = true;
        setAddedTime(System.currentTimeMillis());
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setAddedTime(long j) {
        this.mAddedTime = j;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setData(Object obj) {
        this.mData = obj;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public void setGroupPriority(Priority priority) {
        PriorityFutureTask priorityFutureTask = this.mFutureTask;
        if (priorityFutureTask == null) {
            return;
        }
        priorityFutureTask.setGoupPriority(priority);
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public void setInnerData(Object obj) {
        this.mInnerData = obj;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public void setPrioritySequence(long j) {
        PriorityFutureTask priorityFutureTask = this.mFutureTask;
        if (priorityFutureTask == null) {
            return;
        }
        priorityFutureTask.setPrioritySequence(j);
    }

    @Override // com.alibaba.android.onescheduler.task.InnerOneTask
    public void setRunningState(boolean z) {
        this.mIsRunning = z;
    }

    @Override // com.alibaba.android.onescheduler.OneCommonTask
    public void setTaskTracker(TaskTracker taskTracker) {
        this.mTaskTracker = taskTracker;
    }
}
