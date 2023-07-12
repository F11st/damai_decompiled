package com.taobao.rxm.consume;

import android.util.Log;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import tb.a22;
import tb.cu1;
import tb.d62;
import tb.e62;
import tb.h42;
import tb.hh0;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BaseConsumer<OUT, CONTEXT extends a22> implements Consumer<OUT, CONTEXT> {
    final CONTEXT a;
    boolean b;
    private Scheduler c;
    private final e62 d;

    public BaseConsumer(CONTEXT context) {
        cu1.c(context);
        this.a = context;
        this.d = new e62();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d62<OUT> d62Var) {
        try {
            if (8 != d62Var.a && !this.a.j()) {
                int i = d62Var.a;
                if (i == 1) {
                    g(d62Var.c, d62Var.b);
                    return;
                } else if (i == 4) {
                    h(d62Var.d);
                    return;
                } else if (i != 16) {
                    return;
                } else {
                    f(d62Var.e);
                    return;
                }
            }
            e();
        } catch (Exception e) {
            i(e);
        }
    }

    private void j(d62<OUT> d62Var) {
        if (d()) {
            ScheduledAction offer = this.d.offer();
            if (offer == null) {
                offer = new ScheduledAction(getContext().h(), this, d62Var) { // from class: com.taobao.rxm.consume.BaseConsumer.1
                    @Override // com.taobao.rxm.schedule.ScheduledAction
                    public void run(Consumer consumer, d62 d62Var2) {
                        BaseConsumer.this.b(d62Var2);
                    }
                };
                offer.setScheduledActionPool(this.d);
            } else {
                offer.reset(getContext().h(), this, d62Var);
            }
            this.c.schedule(offer);
            return;
        }
        b(d62Var);
    }

    @Override // com.taobao.rxm.consume.Consumer
    /* renamed from: c */
    public CONTEXT getContext() {
        return this.a;
    }

    @Override // com.taobao.rxm.consume.Consumer
    public Consumer<OUT, CONTEXT> consumeOn(Scheduler scheduler) {
        this.c = scheduler;
        return this;
    }

    protected boolean d() {
        Scheduler scheduler = this.c;
        return (scheduler == null || (scheduler.isScheduleMainThread() && h42.b())) ? false : true;
    }

    protected abstract void e();

    protected abstract void f(Throwable th);

    protected abstract void g(OUT out, boolean z);

    protected abstract void h(float f);

    protected void i(Exception exc) {
        hh0.c("RxSysLog", "UnhandledException when BaseConsumer dispatch result: %s", Log.getStackTraceString(exc));
    }

    @Override // com.taobao.rxm.consume.Consumer
    public synchronized void onCancellation() {
        if (this.b) {
            return;
        }
        this.b = true;
        j(new d62<>(8, true));
    }

    @Override // com.taobao.rxm.consume.Consumer
    public synchronized void onFailure(Throwable th) {
        if (this.b) {
            return;
        }
        if (this.a.j()) {
            onCancellation();
            return;
        }
        this.b = true;
        d62<OUT> d62Var = new d62<>(16, true);
        d62Var.e = th;
        j(d62Var);
    }

    @Override // com.taobao.rxm.consume.Consumer
    public synchronized void onNewResult(OUT out, boolean z) {
        if (this.b) {
            return;
        }
        if (this.a.j()) {
            onCancellation();
            return;
        }
        this.b = z;
        d62<OUT> d62Var = new d62<>(1, z);
        d62Var.c = out;
        j(d62Var);
    }

    @Override // com.taobao.rxm.consume.Consumer
    public synchronized void onProgressUpdate(float f) {
        if (this.b) {
            return;
        }
        d62<OUT> d62Var = new d62<>(4, false);
        d62Var.d = f;
        j(d62Var);
    }

    public String toString() {
        return h42.a(getClass()) + "[cxt-id:" + getContext().d() + jn1.ARRAY_END_STR;
    }
}
