package com.taobao.rxm.schedule;

import android.os.Process;
import androidx.annotation.NonNull;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.request.RequestCancelListener;
import tb.a22;
import tb.d62;
import tb.e62;
import tb.h42;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ScheduledAction implements Runnable, Comparable<ScheduledAction> {
    private static final int MAX_REJECT_STACK_DEPTH = 10;
    private static final int STATE_READY = 1;
    private static final int STATE_RECYCLING = 3;
    private static final int STATE_RUNNING = 2;
    static ThreadLocal<ScheduledAction> sActionCallerThreadLocal = new ThreadLocal<>();
    private e62 mActionPool;
    private boolean mAllowedDirectRun;
    private ScheduledActionListener mBranchActionListener;
    private Consumer<?, ? extends a22> mConsumer;
    private boolean mIsNotConsumeAction;
    private ScheduledActionListener mMasterActionListener;
    private int mPriority = 1;
    private Integer mRejectedStackDepth;
    private d62 mResultWrapper;
    private long mRunningThreadId;
    private int mState;
    private long mTimeStamp;

    public ScheduledAction(int i, Consumer<?, ? extends a22> consumer, d62 d62Var) {
        reset(i, consumer, d62Var);
    }

    private synchronized a22 getRequest() {
        Consumer<?, ? extends a22> consumer = this.mConsumer;
        if (consumer == null || consumer.getContext() == null) {
            return null;
        }
        return this.mConsumer.getContext();
    }

    public boolean canRunDirectly() {
        return (h42.b() || mayStackOverflowAfterRejected() || !this.mAllowedDirectRun) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void cancelActing() {
        d62 d62Var = this.mResultWrapper;
        if (d62Var != null) {
            OUT out = d62Var.c;
            if (out instanceof Releasable) {
                ((Releasable) out).release();
            }
        }
        Consumer<?, ? extends a22> consumer = this.mConsumer;
        if (consumer != null) {
            consumer.onCancellation();
            e62 e62Var = this.mActionPool;
            if (e62Var != null) {
                e62Var.recycle(this);
            }
        }
    }

    public int getContextId() {
        a22 request = getRequest();
        if (request != null) {
            return request.d();
        }
        return -1;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public Integer getRejectedStackDepth() {
        return this.mRejectedStackDepth;
    }

    public long getRunningThreadId() {
        return this.mRunningThreadId;
    }

    public int getState() {
        return this.mState;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public boolean isConsumeAction() {
        return (this.mIsNotConsumeAction && this.mResultWrapper == null) ? false : true;
    }

    public boolean isProduceAction() {
        return this.mResultWrapper == null;
    }

    public boolean mayStackOverflowAfterRejected() {
        ScheduledAction scheduledAction;
        if (this.mRejectedStackDepth == null) {
            if (!h42.b() && (scheduledAction = sActionCallerThreadLocal.get()) != null && scheduledAction.getState() == 2 && scheduledAction.getRunningThreadId() == Thread.currentThread().getId()) {
                this.mRejectedStackDepth = scheduledAction.getRejectedStackDepth();
            } else {
                this.mRejectedStackDepth = 0;
            }
        }
        Integer num = this.mRejectedStackDepth;
        return num != null && num.intValue() >= 10;
    }

    public void notConsumeAction(boolean z) {
        this.mIsNotConsumeAction = z;
    }

    public void registerCancelListener(RequestCancelListener requestCancelListener) {
        a22 request = getRequest();
        if (request != null) {
            request.l(requestCancelListener);
        }
    }

    public ScheduledAction reset() {
        reset(1, null, null);
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mRunningThreadId = Thread.currentThread().getId();
        if (!h42.b()) {
            try {
                Process.setThreadPriority(10);
            } catch (Throwable unused) {
            }
            ScheduledAction scheduledAction = sActionCallerThreadLocal.get();
            if (scheduledAction != null && scheduledAction.getState() == 2 && scheduledAction.getRunningThreadId() == Thread.currentThread().getId()) {
                Integer num = this.mRejectedStackDepth;
                this.mRejectedStackDepth = Integer.valueOf((num != null ? num.intValue() : 0) + 1);
            } else {
                this.mRejectedStackDepth = 0;
            }
            sActionCallerThreadLocal.set(this);
        }
        this.mState = 2;
        run(this.mConsumer, this.mResultWrapper);
        if (!h42.b()) {
            sActionCallerThreadLocal.set(this);
        }
        ScheduledActionListener scheduledActionListener = this.mMasterActionListener;
        if (scheduledActionListener != null) {
            scheduledActionListener.onActionFinished(this);
        }
        ScheduledActionListener scheduledActionListener2 = this.mBranchActionListener;
        if (scheduledActionListener2 != null) {
            scheduledActionListener2.onActionFinished(this);
        }
        this.mState = 3;
        synchronized (this) {
            e62 e62Var = this.mActionPool;
            if (e62Var != null) {
                e62Var.recycle(this);
            }
        }
    }

    public abstract void run(Consumer consumer, d62 d62Var);

    public void setBranchActionListener(ScheduledActionListener scheduledActionListener) {
        this.mBranchActionListener = scheduledActionListener;
    }

    public void setMasterActionListener(ScheduledActionListener scheduledActionListener) {
        this.mMasterActionListener = scheduledActionListener;
    }

    public synchronized void setScheduledActionPool(e62 e62Var) {
        this.mActionPool = e62Var;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(hashCode()));
        sb.append("@(");
        Object obj = this.mConsumer;
        if (obj == null) {
            obj = "NullConsumer";
        }
        sb.append(obj);
        sb.append(")[");
        sb.append(this.mPriority);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append(this.mTimeStamp);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    public synchronized void unregisterCancelListener(RequestCancelListener requestCancelListener) {
        a22 request = getRequest();
        if (request != null) {
            request.s(requestCancelListener);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull ScheduledAction scheduledAction) {
        int priority = scheduledAction.getPriority() - getPriority();
        return priority == 0 ? (int) (this.mTimeStamp - scheduledAction.getTimeStamp()) : priority;
    }

    public ScheduledAction reset(int i, Consumer<?, ? extends a22> consumer, d62 d62Var) {
        return reset(i, consumer, d62Var, true);
    }

    public synchronized ScheduledAction reset(int i, Consumer<?, ? extends a22> consumer, d62 d62Var, boolean z) {
        this.mTimeStamp = System.nanoTime();
        this.mPriority = i;
        this.mConsumer = consumer;
        this.mResultWrapper = d62Var;
        this.mAllowedDirectRun = z;
        this.mRejectedStackDepth = null;
        this.mState = 1;
        this.mRunningThreadId = 0L;
        this.mMasterActionListener = null;
        this.mBranchActionListener = null;
        this.mIsNotConsumeAction = false;
        return this;
    }

    public ScheduledAction(int i, Consumer<?, ? extends a22> consumer, d62 d62Var, boolean z) {
        reset(i, consumer, d62Var, z);
    }
}
