package com.taobao.rxm.consume;

import com.taobao.rxm.schedule.Scheduler;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ChainConsumer<OUT, NEXT_OUT, CONTEXT> {
    void consumeCancellation(Consumer<OUT, CONTEXT> consumer);

    void consumeFailure(Consumer<OUT, CONTEXT> consumer, Throwable th);

    void consumeNewResult(Consumer<OUT, CONTEXT> consumer, boolean z, NEXT_OUT next_out);

    ChainConsumer<OUT, NEXT_OUT, CONTEXT> consumeOn(Scheduler scheduler);

    void consumeProgressUpdate(Consumer<OUT, CONTEXT> consumer, float f);

    Scheduler getConsumeScheduler();
}
