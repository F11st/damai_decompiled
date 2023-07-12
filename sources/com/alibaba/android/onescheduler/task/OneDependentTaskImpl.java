package com.alibaba.android.onescheduler.task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.onescheduler.OneDependentTask;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.ll2;
import tb.tf0;
import tb.wm1;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class OneDependentTaskImpl extends OneCommonTaskImpl implements OneDependentTask, InnerDepentTask {
    private boolean mIsAnchorTask;
    @NonNull
    private Set<OneDependentTask> mPredecessorSet;
    private Set<OneDependentTask> mSuccessorSet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OneDependentTaskImpl(@NonNull a aVar) {
        super(aVar);
        this.mIsAnchorTask = aVar.h;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerDepentTask
    public void addPredecessor(OneDependentTask oneDependentTask) {
        if (this.mPredecessorSet == null) {
            this.mPredecessorSet = new CopyOnWriteArraySet();
        }
        this.mPredecessorSet.add(oneDependentTask);
    }

    @Override // com.alibaba.android.onescheduler.task.InnerDepentTask
    public void addSuccessor(OneDependentTask oneDependentTask) {
        if (this.mSuccessorSet == null) {
            this.mSuccessorSet = new CopyOnWriteArraySet();
        }
        this.mSuccessorSet.add(oneDependentTask);
    }

    @Override // com.alibaba.android.onescheduler.OneDependentTask
    public void after(@Nullable OneDependentTask oneDependentTask) {
        if (oneDependentTask == null) {
            return;
        }
        addPredecessor(oneDependentTask);
        ((InnerDepentTask) oneDependentTask).addSuccessor(this);
    }

    @Override // com.alibaba.android.onescheduler.OneDependentTask
    public void removePredecessor(OneDependentTask oneDependentTask) {
        Set<OneDependentTask> set = this.mPredecessorSet;
        if (set == null || oneDependentTask == null) {
            return;
        }
        set.remove(oneDependentTask);
    }

    @Override // com.alibaba.android.onescheduler.task.InnerDepentTask
    public void removePredecessorTryRun(OneDependentTask oneDependentTask) {
        Set<OneDependentTask> set = this.mPredecessorSet;
        if (set == null) {
            return;
        }
        set.remove(oneDependentTask);
        if (this.mPredecessorSet.isEmpty()) {
            run();
        }
    }

    @Override // com.alibaba.android.onescheduler.OneDependentTask
    public void removeSuccessor(OneDependentTask oneDependentTask) {
        Set<OneDependentTask> set = this.mSuccessorSet;
        if (set == null || oneDependentTask == null) {
            return;
        }
        set.remove(oneDependentTask);
    }

    @Override // com.alibaba.android.onescheduler.task.OneCommonTaskImpl, java.lang.Runnable
    public void run() {
        if (this.mStarted || this.mIsCancelled) {
            wm1.a("Warnning: OneScheduler task %s is reused !!!", this.mName);
            return;
        }
        tf0.a().f(this);
        if (this.mIsAnchorTask) {
            tryRunSuccessor();
        } else {
            ll2.f().h(this);
        }
        this.mStarted = true;
    }

    @Override // com.alibaba.android.onescheduler.task.InnerDepentTask
    public void tryRunSuccessor() {
        Set<OneDependentTask> set = this.mSuccessorSet;
        if (set == null || set.isEmpty()) {
            return;
        }
        Iterator<OneDependentTask> it = this.mSuccessorSet.iterator();
        while (it.hasNext()) {
            ((InnerDepentTask) it.next()).removePredecessorTryRun(this);
        }
    }
}
