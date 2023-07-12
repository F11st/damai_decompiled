package com.taobao.monitor.impl.processor;

import com.taobao.monitor.impl.processor.IProcessor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface INamedProcessorFactory<T extends IProcessor> {
    T createProcessor(String str);
}
