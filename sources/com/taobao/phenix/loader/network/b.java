package com.taobao.phenix.loader.network;

import android.text.TextUtils;
import com.taobao.phenix.loader.network.HttpLoader;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import com.taobao.rxm.request.RequestCancelListener;
import com.taobao.rxm.schedule.PairingThrottlingScheduler;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import java.util.Map;
import java.util.concurrent.Future;
import tb.cu1;
import tb.ne0;
import tb.oe0;
import tb.op0;
import tb.p22;
import tb.xt2;
import tb.yg2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b extends BaseChainProducer<oe0, p22, com.taobao.phenix.request.a> implements RequestCancelListener<com.taobao.phenix.request.a> {
    private HttpLoader j;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements HttpLoader.FinishCallback {
        final /* synthetic */ long a;
        final /* synthetic */ Consumer b;
        final /* synthetic */ com.taobao.phenix.request.a c;

        a(long j, Consumer consumer, com.taobao.phenix.request.a aVar) {
            this.a = j;
            this.b = consumer;
            this.c = aVar;
        }

        @Override // com.taobao.phenix.loader.network.HttpLoader.FinishCallback
        public void onError(Exception exc) {
            b.this.K(((com.taobao.phenix.request.a) this.b.getContext()).d());
            this.b.onFailure(exc);
        }

        @Override // com.taobao.phenix.loader.network.HttpLoader.FinishCallback
        public void onFinished(p22 p22Var) {
            boolean z = this.a != Thread.currentThread().getId();
            com.taobao.phenix.request.a aVar = (com.taobao.phenix.request.a) this.b.getContext();
            aVar.t("inner_is_async_http", Boolean.toString(z));
            if (aVar.i()) {
                xt2.n("Phenix", "request is cancelled before consuming response data", this.c);
                this.b.onCancellation();
                p22Var.release();
                b.this.K(aVar.d());
                return;
            }
            xt2.n("Phenix", "Network Connect Finished.", this.c);
            b.this.n(this.b, true);
            if (z) {
                b.this.z(this.b, true, p22Var, false);
            } else {
                b.this.consumeNewResult(this.b, true, p22Var);
            }
        }
    }

    public b(HttpLoader httpLoader) {
        super(2, 0);
        cu1.c(httpLoader);
        this.j = httpLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i) {
        Scheduler consumeScheduler = getConsumeScheduler();
        if (consumeScheduler instanceof PairingThrottlingScheduler) {
            ((PairingThrottlingScheduler) consumeScheduler).c(i);
        }
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    /* renamed from: J */
    public void consumeNewResult(Consumer<oe0, com.taobao.phenix.request.a> consumer, boolean z, p22 p22Var) {
        q(consumer, z);
        com.taobao.phenix.request.a context = consumer.getContext();
        xt2.n("Phenix", "Network Read Started.", context);
        op0.j(context.U());
        if (context.i()) {
            xt2.q("Network", context, "request is cancelled before reading response stream", new Object[0]);
            consumer.onCancellation();
            p22Var.release();
            return;
        }
        yg2 yg2Var = new yg2(consumer, p22Var.b, context.R());
        try {
            ne0 c = ne0.c(p22Var, yg2Var);
            if (yg2Var.d()) {
                return;
            }
            context.U().A(c.b);
            if (!c.g) {
                xt2.m("Network", context, "miss bytes while reading response[type:%d], read=%d, content=%d", Integer.valueOf(p22Var.a), Integer.valueOf(yg2Var.b()), Integer.valueOf(yg2Var.d));
                consumer.onFailure(new IncompleteResponseException());
                return;
            }
            context.s(this);
            com.taobao.phenix.request.b G = context.G();
            p(consumer, true, z);
            xt2.n("Phenix", "Network Read Finished.", context);
            consumer.onNewResult(new oe0(c, G.k(), 1, false, G.i()), z);
        } catch (Exception e) {
            xt2.m("Network", context, "transform data from response[type:%d] error, read=%d, content=%d, throwable=%s", Integer.valueOf(p22Var.a), Integer.valueOf(yg2Var.b()), Integer.valueOf(yg2Var.d), e);
            consumer.onFailure(e);
        }
    }

    @Override // com.taobao.rxm.request.RequestCancelListener
    /* renamed from: L */
    public void onCancel(com.taobao.phenix.request.a aVar) {
        K(aVar.d());
        xt2.n("Phenix", "received cancellation.", aVar);
        Future<?> B = aVar.B();
        if (B != null) {
            aVar.k0(null);
            try {
                B.cancel(true);
                xt2.k("Network", aVar, "cancelled blocking future(%s), result=%b", B, Boolean.valueOf(B.isCancelled()));
            } catch (Exception e) {
                xt2.m("Network", aVar, "cancel blocking future error=%s", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.jh
    public boolean b(Consumer<oe0, com.taobao.phenix.request.a> consumer, ScheduledAction scheduledAction) {
        Map<String, String> H;
        String str;
        com.taobao.phenix.request.a context = consumer.getContext();
        long id = Thread.currentThread().getId();
        o(consumer);
        xt2.n("Phenix", "Network Connect Started.", context);
        context.t("inner_network_start_time", String.valueOf(System.currentTimeMillis()));
        context.l(this);
        if (!TextUtils.isEmpty(context.U().q)) {
            context.t("f-traceId", context.U().q);
        }
        context.k0(this.j.load(context.N(), context.H(), new a(id, consumer, context)));
        if (scheduledAction != null && ((H = context.H()) == null || (str = H.get("inner_is_async_http")) == null || Boolean.valueOf(str).booleanValue())) {
            scheduledAction.notConsumeAction(true);
        }
        return true;
    }
}
