package com.taobao.monitor.impl.processor;

import com.taobao.monitor.impl.processor.IProcessor;
import com.taobao.monitor.impl.trace.IDispatcher;
import tb.C8934b0;
import tb.fu0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbsProcessor implements IProcessor {
    private C8934b0 a;
    private IProcessor.IProcessorLifeCycle b;
    private volatile boolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsProcessor() {
        this(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IDispatcher a(String str) {
        return C8934b0.a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        fu0.e().d().post(new Runnable() { // from class: com.taobao.monitor.impl.processor.AbsProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                AbsProcessor.this.e();
            }
        });
    }

    public void c(IProcessor.IProcessorLifeCycle iProcessorLifeCycle) {
        this.b = iProcessorLifeCycle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        IProcessor.IProcessorLifeCycle iProcessorLifeCycle = this.b;
        if (iProcessorLifeCycle != null) {
            iProcessorLifeCycle.processorOnStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.c) {
            return;
        }
        this.c = true;
        IProcessor.IProcessorLifeCycle iProcessorLifeCycle = this.b;
        if (iProcessorLifeCycle != null) {
            iProcessorLifeCycle.processorOnEnd(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsProcessor(boolean z) {
        this.a = C8934b0.b();
        this.c = false;
    }
}
