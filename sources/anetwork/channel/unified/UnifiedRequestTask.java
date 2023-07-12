package anetwork.channel.unified;

import android.os.Looper;
import android.text.TextUtils;
import anet.channel.fulltrace.C0179a;
import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.monitor.BandWidthSampler;
import anet.channel.request.C0193a;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.entity.Repeater;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.interceptor.Interceptor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import tb.cf0;
import tb.hh1;
import tb.jn1;
import tb.rj1;
import tb.v31;
import tb.vp0;
import tb.x6;
import tb.z12;
import tb.ze;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UnifiedRequestTask {
    protected C0254b a;

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.unified.UnifiedRequestTask$a */
    /* loaded from: classes.dex */
    class C0252a implements Interceptor.Chain {
        private int a;
        private C0193a b;
        private Callback c;

        C0252a(int i, C0193a c0193a, Callback callback) {
            this.a = 0;
            this.b = null;
            this.c = null;
            this.a = i;
            this.b = c0193a;
            this.c = callback;
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public Callback callback() {
            return this.c;
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public Future proceed(C0193a c0193a, Callback callback) {
            if (UnifiedRequestTask.this.a.d.get()) {
                ALog.f("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", c0193a.n(), new Object[0]);
                return null;
            } else if (this.a < v31.c()) {
                C0252a c0252a = new C0252a(this.a + 1, c0193a, callback);
                Interceptor b = v31.b(this.a);
                UnifiedRequestTask.this.a.a.f.lastInterceptor = String.valueOf(b.getClass());
                return b.intercept(c0252a);
            } else {
                UnifiedRequestTask.this.a.a.r(c0193a);
                C0254b c0254b = UnifiedRequestTask.this.a;
                c0254b.b = callback;
                ALog.e("anet.UnifiedRequestTask", "start task", c0254b.c, new Object[0]);
                Cache c = rj1.p() ? ze.c(UnifiedRequestTask.this.a.a.h(), UnifiedRequestTask.this.a.a.d()) : null;
                C0254b c0254b2 = UnifiedRequestTask.this.a;
                c0254b2.e = c != null ? new CacheTask(c0254b2, c) : new NetworkTask(c0254b2, null, null);
                if (c == null) {
                    UnifiedRequestTask.this.f();
                }
                UnifiedRequestTask.this.a.e.run();
                UnifiedRequestTask.this.d();
                return null;
            }
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public C0193a request() {
            return this.b;
        }
    }

    public UnifiedRequestTask(z12 z12Var, Repeater repeater) {
        repeater.k(z12Var.i);
        this.a = new C0254b(z12Var, repeater);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.a.g = ThreadPoolExecutorFactory.j(new Runnable() { // from class: anetwork.channel.unified.UnifiedRequestTask.4
            @Override // java.lang.Runnable
            public void run() {
                if (UnifiedRequestTask.this.a.d.compareAndSet(false, true)) {
                    RequestStatistic requestStatistic = UnifiedRequestTask.this.a.a.f;
                    if (requestStatistic.isDone.compareAndSet(false, true)) {
                        requestStatistic.statusCode = -202;
                        requestStatistic.msg = cf0.b(-202);
                        requestStatistic.rspEnd = System.currentTimeMillis();
                        C0179a.f().log(requestStatistic.span, "netRspRecvEnd", null);
                        ALog.e("anet.UnifiedRequestTask", "task time out", UnifiedRequestTask.this.a.c, "rs", requestStatistic);
                        x6.b().commitStat(new ExceptionStatistic(-202, null, requestStatistic, null));
                    }
                    UnifiedRequestTask.this.a.b();
                    UnifiedRequestTask.this.a.a();
                    UnifiedRequestTask.this.a.b.onFinish(new DefaultFinishEvent(-202, (String) null, UnifiedRequestTask.this.a.a.b()));
                }
            }
        }, this.a.a.i(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (rj1.s() && rj1.w() && NetworkStatusHelper.d() != null) {
            if ((rj1.t(this.a.a.b().c()) && "picture".equalsIgnoreCase(this.a.a.c())) || rj1.x(this.a.a.e())) {
                this.a.f = new MultiPathTask(this.a);
                ThreadPoolExecutorFactory.j(new Runnable() { // from class: anetwork.channel.unified.UnifiedRequestTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UnifiedRequestTask.this.a.d.get()) {
                            return;
                        }
                        ALog.e("anet.UnifiedRequestTask", "[submitMultiPathTask]request is in multi path white list.", null, new Object[0]);
                        if (UnifiedRequestTask.this.a.f != null) {
                            ThreadPoolExecutorFactory.c(UnifiedRequestTask.this.a.f);
                        }
                    }
                }, rj1.b(), TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.a.d.compareAndSet(false, true)) {
            ALog.e("anet.UnifiedRequestTask", "task cancelled", this.a.c, "URL", this.a.a.e().l());
            RequestStatistic requestStatistic = this.a.a.f;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.ret = 2;
                requestStatistic.statusCode = cf0.ERROR_REQUEST_CANCEL;
                requestStatistic.msg = cf0.b(cf0.ERROR_REQUEST_CANCEL);
                requestStatistic.rspEnd = System.currentTimeMillis();
                C0179a.f().log(requestStatistic.span, "netRspRecvEnd", null);
                x6.b().commitStat(new ExceptionStatistic(cf0.ERROR_REQUEST_CANCEL, null, requestStatistic, null));
                if (requestStatistic.recDataSize > 102400) {
                    BandWidthSampler.f().i(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.recDataSize);
                }
            }
            this.a.b();
            this.a.a();
            this.a.c();
            this.a.b.onFinish(new DefaultFinishEvent((int) cf0.ERROR_REQUEST_CANCEL, (String) null, this.a.a.b()));
        }
    }

    public Future e() {
        long currentTimeMillis = System.currentTimeMillis();
        this.a.a.f.reqServiceTransmissionEnd = currentTimeMillis;
        this.a.a.f.start = currentTimeMillis;
        z12 z12Var = this.a.a;
        z12Var.f.isReqSync = z12Var.o();
        this.a.a.f.isReqMain = Looper.myLooper() == Looper.getMainLooper();
        this.a.a.f.multiPathOpened = rj1.w() ? 1 : 0;
        try {
            z12 z12Var2 = this.a.a;
            z12Var2.f.netReqStart = Long.valueOf(z12Var2.g("f-netReqStart")).longValue();
        } catch (Exception unused) {
        }
        IFullTraceAnalysisV3.ISpan createRequest = C0179a.f().createRequest(this.a.a.f());
        if (createRequest != null) {
            this.a.a.f.span = createRequest;
            C0179a.f().log(createRequest, "netReqStart", "url=" + this.a.a.h());
        }
        String g = this.a.a.g("f-traceId");
        if (!TextUtils.isEmpty(g)) {
            this.a.a.f.falcoId = g;
        }
        String g2 = this.a.a.g("f-reqProcess");
        z12 z12Var3 = this.a.a;
        RequestStatistic requestStatistic = z12Var3.f;
        requestStatistic.process = g2;
        requestStatistic.pTraceId = z12Var3.g("f-pTraceId");
        C0254b c0254b = this.a;
        ALog.e("anet.UnifiedRequestTask", "[falcoId:" + g + jn1.ARRAY_END_STR + "start", c0254b.c, hh1.DIMEN_BIZ, c0254b.a.b().c(), "processFrom", g2, "url", this.a.a.h());
        if (rj1.G(this.a.a.e())) {
            DegradeTask degradeTask = new DegradeTask(this.a);
            this.a.e = degradeTask;
            degradeTask.cancelable = new vp0(ThreadPoolExecutorFactory.c(new Runnable() { // from class: anetwork.channel.unified.UnifiedRequestTask.2
                @Override // java.lang.Runnable
                public void run() {
                    UnifiedRequestTask.this.a.e.run();
                }
            }), this.a.a.b().n());
            d();
            return new FutureC0253a(this);
        }
        ThreadPoolExecutorFactory.g(new Runnable() { // from class: anetwork.channel.unified.UnifiedRequestTask.3
            @Override // java.lang.Runnable
            public void run() {
                UnifiedRequestTask unifiedRequestTask = UnifiedRequestTask.this;
                new C0252a(0, unifiedRequestTask.a.a.b(), UnifiedRequestTask.this.a.b).proceed(UnifiedRequestTask.this.a.a.b(), UnifiedRequestTask.this.a.b);
            }
        }, ThreadPoolExecutorFactory.C0235b.a);
        return new FutureC0253a(this);
    }
}
