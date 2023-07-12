package tb;

import android.text.TextUtils;
import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.ChainConsumer;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.Producer;
import com.taobao.rxm.produce.ProducerListener;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import tb.a22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class jh<OUT, NEXT_OUT extends Releasable, CONTEXT extends a22> implements Producer<OUT, CONTEXT>, ChainConsumer<OUT, NEXT_OUT, CONTEXT> {
    private final String a;
    private final int b;
    private final jn c;
    private Type[] d;
    private Producer<NEXT_OUT, CONTEXT> e;
    private Scheduler f;
    private Scheduler g;

    public jh(String str, int i, int i2) {
        this.a = f(str);
        this.b = i;
        this.c = new jn(i2);
    }

    private boolean d() {
        if (this.d == null) {
            try {
                this.d = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
            } catch (Exception e) {
                hh0.c("RxSysLog", "chain producer get generic types error=%s", e);
                return false;
            }
        }
        return true;
    }

    private String f(String str) {
        if (TextUtils.isEmpty(str)) {
            String name = getClass().getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf != -1 ? name.substring(lastIndexOf + 1) : name;
        }
        return str;
    }

    private boolean l() {
        return this.b == 2;
    }

    private void r(Consumer<OUT, CONTEXT> consumer, boolean z, boolean z2, boolean z3) {
        ProducerListener g = consumer.getContext().g();
        if (g != null) {
            g.onExitOut(consumer.getContext(), getClass(), z, z2, z3);
        }
    }

    private void s(Consumer<OUT, CONTEXT> consumer, boolean z, boolean z2) {
        ProducerListener g = consumer.getContext().g();
        if (g != null) {
            g.onEnterIn(consumer.getContext(), getClass(), z, z2);
        }
    }

    public void A(Consumer<OUT, CONTEXT> consumer, float f) {
        d62<NEXT_OUT> d62Var = new d62<>(4, false);
        d62Var.d = f;
        v(this.g, consumer, d62Var);
    }

    public <NN_OUT extends Releasable> jh B(jh<NEXT_OUT, NN_OUT, CONTEXT> jhVar) {
        cu1.c(jhVar);
        this.e = jhVar;
        return jhVar;
    }

    protected boolean a(Consumer<OUT, CONTEXT> consumer) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Consumer<OUT, CONTEXT> consumer, ScheduledAction scheduledAction) {
        return a(consumer);
    }

    @Override // com.taobao.rxm.consume.ChainConsumer
    /* renamed from: c */
    public jh<OUT, NEXT_OUT, CONTEXT> consumeOn(Scheduler scheduler) {
        this.g = scheduler;
        return this;
    }

    public jn e() {
        return this.c;
    }

    public abstract l60<OUT, NEXT_OUT, CONTEXT> g();

    @Override // com.taobao.rxm.consume.ChainConsumer
    public Scheduler getConsumeScheduler() {
        return this.g;
    }

    @Override // com.taobao.rxm.produce.Producer
    public String getName() {
        return this.a;
    }

    @Override // com.taobao.rxm.produce.Producer
    public Scheduler getProduceScheduler() {
        return this.f;
    }

    public Type h() {
        if (d()) {
            Type[] typeArr = this.d;
            if (typeArr[1] == a22.class) {
                return typeArr[0];
            }
            return typeArr[1];
        }
        return null;
    }

    public Producer<NEXT_OUT, CONTEXT> i() {
        return this.e;
    }

    public Type j() {
        if (d()) {
            return this.d[0];
        }
        return null;
    }

    public int k() {
        return this.b;
    }

    public boolean m() {
        return (l() || e().a(1)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(Consumer<OUT, CONTEXT> consumer, boolean z) {
        r(consumer, false, z, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(Consumer<OUT, CONTEXT> consumer) {
        s(consumer, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Consumer<OUT, CONTEXT> consumer, boolean z, boolean z2) {
        r(consumer, true, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(Consumer<OUT, CONTEXT> consumer, boolean z) {
        s(consumer, true, z);
    }

    @Override // com.taobao.rxm.produce.Producer
    /* renamed from: t */
    public jh<OUT, NEXT_OUT, CONTEXT> produceOn(Scheduler scheduler) {
        this.f = scheduler;
        return this;
    }

    public void u(Consumer<OUT, CONTEXT> consumer) {
        v(this.g, consumer, new d62<>(8, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(Scheduler scheduler, Consumer<OUT, CONTEXT> consumer, d62<NEXT_OUT> d62Var) {
        w(scheduler, consumer, d62Var, true);
    }

    protected abstract void w(Scheduler scheduler, Consumer<OUT, CONTEXT> consumer, d62<NEXT_OUT> d62Var, boolean z);

    public void x(Consumer<OUT, CONTEXT> consumer, Throwable th) {
        d62<NEXT_OUT> d62Var = new d62<>(16, true);
        d62Var.e = th;
        v(this.g, consumer, d62Var);
    }

    public void y(Consumer<OUT, CONTEXT> consumer, boolean z, NEXT_OUT next_out) {
        z(consumer, z, next_out, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void z(Consumer<OUT, CONTEXT> consumer, boolean z, NEXT_OUT next_out, boolean z2) {
        d62<NEXT_OUT> d62Var = new d62<>(1, z);
        d62Var.c = next_out;
        w(this.g, consumer, d62Var, z2);
    }
}
