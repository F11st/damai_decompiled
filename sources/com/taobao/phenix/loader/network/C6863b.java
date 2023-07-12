package com.taobao.phenix.loader.network;

import android.text.TextUtils;
import com.taobao.phenix.loader.network.HttpLoader;
import com.taobao.phenix.request.C6865a;
import com.taobao.phenix.request.C6866b;
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
/* renamed from: com.taobao.phenix.loader.network.b */
/* loaded from: classes11.dex */
public class C6863b extends BaseChainProducer<oe0, p22, C6865a> implements RequestCancelListener<C6865a> {
    private HttpLoader j;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.phenix.loader.network.b$a */
    /* loaded from: classes11.dex */
    class C6864a implements HttpLoader.FinishCallback {
        final /* synthetic */ long a;
        final /* synthetic */ Consumer b;
        final /* synthetic */ C6865a c;

        C6864a(long j, Consumer consumer, C6865a c6865a) {
            this.a = j;
            this.b = consumer;
            this.c = c6865a;
        }

        @Override // com.taobao.phenix.loader.network.HttpLoader.FinishCallback
        public void onError(Exception exc) {
            C6863b.this.K(((C6865a) this.b.getContext()).d());
            this.b.onFailure(exc);
        }

        @Override // com.taobao.phenix.loader.network.HttpLoader.FinishCallback
        public void onFinished(p22 p22Var) {
            boolean z = this.a != Thread.currentThread().getId();
            C6865a c6865a = (C6865a) this.b.getContext();
            c6865a.t("inner_is_async_http", Boolean.toString(z));
            if (c6865a.i()) {
                xt2.n("Phenix", "request is cancelled before consuming response data", this.c);
                this.b.onCancellation();
                p22Var.release();
                C6863b.this.K(c6865a.d());
                return;
            }
            xt2.n("Phenix", "Network Connect Finished.", this.c);
            C6863b.this.n(this.b, true);
            if (z) {
                C6863b.this.z(this.b, true, p22Var, false);
            } else {
                C6863b.this.consumeNewResult(this.b, true, p22Var);
            }
        }
    }

    public C6863b(HttpLoader httpLoader) {
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
    public void consumeNewResult(Consumer<oe0, C6865a> consumer, boolean z, p22 p22Var) {
        q(consumer, z);
        C6865a context = consumer.getContext();
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
            C6866b G = context.G();
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
    public void onCancel(C6865a c6865a) {
        K(c6865a.d());
        xt2.n("Phenix", "received cancellation.", c6865a);
        Future<?> B = c6865a.B();
        if (B != null) {
            c6865a.k0(null);
            try {
                B.cancel(true);
                xt2.k("Network", c6865a, "cancelled blocking future(%s), result=%b", B, Boolean.valueOf(B.isCancelled()));
            } catch (Exception e) {
                xt2.m("Network", c6865a, "cancel blocking future error=%s", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.jh
    public boolean b(Consumer<oe0, C6865a> consumer, ScheduledAction scheduledAction) {
        Map<String, String> H;
        String str;
        C6865a context = consumer.getContext();
        long id = Thread.currentThread().getId();
        o(consumer);
        xt2.n("Phenix", "Network Connect Started.", context);
        context.t("inner_network_start_time", String.valueOf(System.currentTimeMillis()));
        context.l(this);
        if (!TextUtils.isEmpty(context.U().q)) {
            context.t("f-traceId", context.U().q);
        }
        context.k0(this.j.load(context.N(), context.H(), new C6864a(id, consumer, context)));
        if (scheduledAction != null && ((H = context.H()) == null || (str = H.get("inner_is_async_http")) == null || Boolean.valueOf(str).booleanValue())) {
            scheduledAction.notConsumeAction(true);
        }
        return true;
    }
}
