package tb;

import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.schedule.Scheduler;
import tb.a22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gh<OUT, NEXT_OUT extends Releasable, CONTEXT extends a22> implements Consumer<NEXT_OUT, CONTEXT> {
    private Consumer<OUT, CONTEXT> a;
    private jh<OUT, NEXT_OUT, CONTEXT> b;
    private Scheduler c;

    public gh(Consumer<OUT, CONTEXT> consumer, jh<OUT, NEXT_OUT, CONTEXT> jhVar) {
        this.a = consumer;
        this.b = jhVar;
    }

    @Override // com.taobao.rxm.consume.Consumer
    /* renamed from: a */
    public CONTEXT getContext() {
        Consumer<OUT, CONTEXT> consumer = this.a;
        if (consumer == null) {
            return null;
        }
        return consumer.getContext();
    }

    @Override // com.taobao.rxm.consume.Consumer
    /* renamed from: b */
    public void onNewResult(NEXT_OUT next_out, boolean z) {
        String name = this.b.getName();
        boolean z2 = false;
        if (getContext().i()) {
            hh0.f("RxSysLog", "[DelegateConsumer] ID=%d cancelled before receiving new result, producer=%s isLast=%b", Integer.valueOf(getContext().d()), name, Boolean.valueOf(z));
            if (next_out != null) {
                next_out.release();
            }
            this.a.onCancellation();
            return;
        }
        if (this.b.e().a(1) || (z && this.b.e().a(2))) {
            z2 = true;
        }
        if (z2) {
            this.b.y(this.a, z, next_out);
        } else {
            this.a.onNewResult(next_out, z);
        }
    }

    public gh<OUT, NEXT_OUT, CONTEXT> c() {
        d(null, null);
        return this;
    }

    @Override // com.taobao.rxm.consume.Consumer
    public Consumer<NEXT_OUT, CONTEXT> consumeOn(Scheduler scheduler) {
        this.c = scheduler;
        return this;
    }

    public gh<OUT, NEXT_OUT, CONTEXT> d(Consumer<OUT, CONTEXT> consumer, jh<OUT, NEXT_OUT, CONTEXT> jhVar) {
        this.a = consumer;
        this.b = jhVar;
        return this;
    }

    protected void finalize() {
        try {
            l60<OUT, NEXT_OUT, CONTEXT> g = this.b.g();
            if (g == null || g.recycle(this)) {
                return;
            }
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.taobao.rxm.consume.Consumer
    public void onCancellation() {
        if (this.b.e().a(8)) {
            this.b.u(this.a);
        } else {
            this.a.onCancellation();
        }
    }

    @Override // com.taobao.rxm.consume.Consumer
    public void onFailure(Throwable th) {
        if (this.b.e().a(16)) {
            this.b.x(this.a, th);
        } else {
            this.a.onFailure(th);
        }
    }

    @Override // com.taobao.rxm.consume.Consumer
    public void onProgressUpdate(float f) {
        if (this.b.e().a(4)) {
            this.b.A(this.a, f);
        } else {
            this.a.onProgressUpdate(f);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(h42.a(gh.class));
        sb.append("[cxt-id:");
        sb.append(getContext() != null ? getContext().d() : 0);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
