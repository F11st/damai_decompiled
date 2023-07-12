package com.taobao.rxm.produce;

import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import tb.a22;
import tb.cv1;
import tb.d62;
import tb.e62;
import tb.gh;
import tb.h42;
import tb.hh0;
import tb.jh;
import tb.l60;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseChainProducer<OUT, NEXT_OUT extends Releasable, CONTEXT extends a22> extends jh<OUT, NEXT_OUT, CONTEXT> {
    private e62 h;
    private l60<OUT, NEXT_OUT, CONTEXT> i;

    public BaseChainProducer(int i, int i2) {
        this(null, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Consumer<OUT, CONTEXT> consumer, d62<NEXT_OUT> d62Var, ScheduledAction scheduledAction) {
        if (d62Var == null) {
            if (consumer.getContext().i()) {
                hh0.f("RxSysLog", "[ChainProducer] ID=%d cancelled before conducting result, producer=%s type=%s", Integer.valueOf(consumer.getContext().d()), getName(), cv1.a(k()));
                consumer.onCancellation();
                return;
            } else if (b(consumer, scheduledAction) || k() != 1) {
                return;
            } else {
                G(consumer);
                return;
            }
        }
        int i = d62Var.a;
        if (i == 1) {
            consumeNewResult(consumer, d62Var.b, d62Var.c);
        } else if (i == 4) {
            consumeProgressUpdate(consumer, d62Var.d);
        } else if (i == 8) {
            consumeCancellation(consumer);
        } else if (i != 16) {
        } else {
            consumeFailure(consumer, d62Var.e);
        }
    }

    private gh<OUT, NEXT_OUT, CONTEXT> F(Consumer<OUT, CONTEXT> consumer) {
        gh<OUT, NEXT_OUT, CONTEXT> offer = g().offer();
        return offer != null ? offer.d(consumer, this) : new gh<>(consumer, this);
    }

    private void G(Consumer<OUT, CONTEXT> consumer) {
        if (i() != null) {
            i().produceResults(F(consumer).consumeOn(getConsumeScheduler()));
            return;
        }
        throw new RuntimeException(getName() + " can't conduct result while no next producer");
    }

    @Override // com.taobao.rxm.consume.ChainConsumer
    /* renamed from: D */
    public void consumeNewResult(Consumer<OUT, CONTEXT> consumer, boolean z, NEXT_OUT next_out) {
    }

    @Override // com.taobao.rxm.consume.ChainConsumer
    public void consumeCancellation(Consumer<OUT, CONTEXT> consumer) {
    }

    @Override // com.taobao.rxm.consume.ChainConsumer
    public void consumeFailure(Consumer<OUT, CONTEXT> consumer, Throwable th) {
    }

    @Override // com.taobao.rxm.consume.ChainConsumer
    public void consumeProgressUpdate(Consumer<OUT, CONTEXT> consumer, float f) {
    }

    @Override // tb.jh
    public l60<OUT, NEXT_OUT, CONTEXT> g() {
        return this.i;
    }

    @Override // com.taobao.rxm.produce.Producer
    public void produceResults(Consumer<OUT, CONTEXT> consumer) {
        if (consumer.getContext().i()) {
            hh0.f("RxSysLog", "[ChainProducer] ID=%d cancelled before leading to produce result, producer=%s type=%s", Integer.valueOf(consumer.getContext().d()), getName(), cv1.a(k()));
            consumer.onCancellation();
        } else if (k() != 0) {
            v(getProduceScheduler(), consumer, null);
        } else {
            G(consumer);
        }
    }

    @Override // tb.jh
    protected void w(Scheduler scheduler, Consumer<OUT, CONTEXT> consumer, d62<NEXT_OUT> d62Var, boolean z) {
        if (scheduler != null && (!z || !scheduler.isScheduleMainThread() || !h42.b())) {
            ScheduledAction offer = this.h.offer();
            if (offer == null) {
                offer = new ScheduledAction(consumer.getContext().h(), consumer, d62Var, z) { // from class: com.taobao.rxm.produce.BaseChainProducer.1
                    @Override // com.taobao.rxm.schedule.ScheduledAction
                    public void run(Consumer consumer2, d62 d62Var2) {
                        BaseChainProducer.this.E(consumer2, d62Var2, this);
                    }
                };
                offer.setScheduledActionPool(this.h);
            } else {
                offer.reset(consumer.getContext().h(), consumer, d62Var, z);
            }
            scheduler.schedule(offer);
            return;
        }
        E(consumer, d62Var, null);
    }

    public BaseChainProducer(String str, int i, int i2) {
        super(str, i, i2);
        this.h = new e62();
        this.i = new l60<>();
    }
}
