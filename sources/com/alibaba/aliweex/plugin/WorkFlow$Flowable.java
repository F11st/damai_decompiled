package com.alibaba.aliweex.plugin;

import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
interface WorkFlow$Flowable<T, R> {

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnActionCall<R> {
        void onCall(R r);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public enum RunThread {
        CURRENT,
        UI,
        SUB,
        NEW,
        SERIALTASK
    }

    WorkFlow$Flow countFlow(CountDownLatch countDownLatch);

    AbstractC3099b<T, R> currentThread();

    WorkFlow$Flow flow();

    void flowToNext(T t);

    WorkFlow$Flow getContext();

    R getResult();

    boolean hasNext();

    boolean isLooping();

    AbstractC3099b<T, R> newThread();

    WorkFlow$Flowable<R, ?> next();

    void onActionCall(OnActionCall<R> onActionCall);

    WorkFlow$Flowable<?, T> prior();

    void scheduleFlow(T t);

    AbstractC3099b<T, R> serialTask();

    AbstractC3099b<T, R> serialTask(int i);

    <A extends WorkFlow$Action<T, R>> WorkFlow$Flowable<T, R> setAction(A a);

    WorkFlow$Flowable<T, R> setContext(WorkFlow$Flow workFlow$Flow);

    WorkFlow$Flowable<T, R> setNext(WorkFlow$Flowable<R, ?> workFlow$Flowable);

    WorkFlow$Flowable<T, R> setPrior(WorkFlow$Flowable<?, T> workFlow$Flowable);

    AbstractC3099b<T, R> subThread();

    AbstractC3099b<T, R> uiThread();
}
