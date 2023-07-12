package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public final class ExecutionSequencer {

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.ExecutionSequencer$4  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ ExecutionSequencer this$0;
        final /* synthetic */ p val$newFuture;
        final /* synthetic */ ListenableFuture val$oldFuture;
        final /* synthetic */ ListenableFuture val$outputFuture;
        final /* synthetic */ AtomicReference val$runningState;
        final /* synthetic */ ListenableFuture val$taskFuture;

        AnonymousClass4(ExecutionSequencer executionSequencer, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, AtomicReference atomicReference, p pVar, ListenableFuture listenableFuture3) {
            this.val$taskFuture = listenableFuture;
            this.val$outputFuture = listenableFuture2;
            this.val$runningState = atomicReference;
            this.val$newFuture = pVar;
            this.val$oldFuture = listenableFuture3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$taskFuture.isDone() || (this.val$outputFuture.isCancelled() && this.val$runningState.compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED))) {
                this.val$newFuture.setFuture(this.val$oldFuture);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }
}
