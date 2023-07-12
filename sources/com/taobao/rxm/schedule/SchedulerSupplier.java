package com.taobao.rxm.schedule;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface SchedulerSupplier {
    Scheduler forCpuBound();

    Scheduler forDecode();

    Scheduler forIoBound();

    Scheduler forNetwork();

    Scheduler forUiThread();
}
