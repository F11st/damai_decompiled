package com.taobao.rxm.consume;

import com.taobao.rxm.schedule.Scheduler;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Consumer<OUT, CONTEXT> {
    Consumer<OUT, CONTEXT> consumeOn(Scheduler scheduler);

    CONTEXT getContext();

    void onCancellation();

    void onFailure(Throwable th);

    void onNewResult(OUT out, boolean z);

    void onProgressUpdate(float f);
}
