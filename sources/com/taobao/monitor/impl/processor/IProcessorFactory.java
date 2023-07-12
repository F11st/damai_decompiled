package com.taobao.monitor.impl.processor;

import com.taobao.monitor.impl.processor.IProcessor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IProcessorFactory<T extends IProcessor> {
    T createProcessor();
}
