package com.taobao.monitor.impl.processor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IProcessor {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IProcessorLifeCycle {
        void processorOnEnd(IProcessor iProcessor);

        void processorOnStart(IProcessor iProcessor);
    }
}
