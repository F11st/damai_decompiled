package com.taobao.rxm.produce;

import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.schedule.Scheduler;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Producer<OUT, CONTEXT> {
    String getName();

    Scheduler getProduceScheduler();

    Producer<OUT, CONTEXT> produceOn(Scheduler scheduler);

    void produceResults(Consumer<OUT, CONTEXT> consumer);
}
