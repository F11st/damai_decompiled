package tb;

import com.taobao.phenix.cache.memory.MemOnlyFailedException;
import com.taobao.phenix.chain.ImageDecodingListener;
import com.taobao.phenix.chain.PhenixProduceListener;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.phenix.loader.network.HttpCodeResponseException;
import com.taobao.phenix.request.C6865a;
import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.rxm.consume.BaseConsumer;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.ProducerListener;
import com.taobao.rxm.schedule.Scheduler;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zr1 extends BaseConsumer<tq1, C6865a> {
    private final wr1 e;
    private final ImageFlowMonitor f;
    private final SchedulerSupplier g;

    public zr1(C6865a c6865a, wr1 wr1Var, ImageFlowMonitor imageFlowMonitor, SchedulerSupplier schedulerSupplier, ImageDecodingListener imageDecodingListener) {
        super(c6865a);
        this.e = wr1Var;
        this.f = imageFlowMonitor;
        this.g = schedulerSupplier;
        c6865a.p(new PhenixProduceListener(c6865a, wr1Var.s(), imageDecodingListener));
    }

    private void l(long j) {
        if (this.f != null) {
            ImageStatistics U = getContext().U();
            U.w(m(j, false, true, getContext().d()));
            this.f.onSuccess(U);
        }
    }

    private Map<String, Integer> m(long j, boolean z, boolean z2, int i) {
        StringBuilder sb;
        if (z || z2) {
            int S = (int) (j - getContext().S());
            int V = getContext().V() <= 0 ? 0 : (int) (j - getContext().V());
            if (z) {
                sb = new StringBuilder(150);
                sb.append("User-Callback: ");
                sb.append(System.currentTimeMillis() - j);
                sb.append('\n');
                sb.append("Total-Time: ");
                sb.append(S);
                sb.append('\n');
                sb.append("Wait-Main: ");
                sb.append(V);
                sb.append('\n');
            } else {
                sb = null;
            }
            HashMap hashMap = z2 ? new HashMap() : null;
            int i2 = 0;
            for (Map.Entry<String, Long> entry : getContext().Q().entrySet()) {
                String key = entry.getKey();
                int intValue = entry.getValue().intValue();
                if (z) {
                    sb.append(key);
                    sb.append(": ");
                    if (intValue < 0) {
                        sb.append("Unknown(cause interrupted)");
                    } else {
                        sb.append(intValue);
                    }
                    sb.append('\n');
                }
                if (intValue >= 0) {
                    i2 += intValue;
                    if (z2) {
                        hashMap.put(key, Integer.valueOf(intValue));
                    }
                }
            }
            int i3 = i2 + V;
            if (S < i3) {
                S = i3;
            }
            int i4 = (S - i2) - V;
            if (z2) {
                hashMap.put(ImageStatistics.KEY_TOTAL_TIME, Integer.valueOf(S));
                hashMap.put(ImageStatistics.KEY_SCHEDULE_TIME, Integer.valueOf(i4));
                ImageFlowMonitor imageFlowMonitor = this.f;
                if (imageFlowMonitor != null && this.g != null && i4 >= imageFlowMonitor.getMinimumScheduleTime2StatWaitSize()) {
                    hashMap.put(ImageStatistics.KEY_MASTER_WAIT_SIZE, Integer.valueOf(this.g.forCpuBound().getQueueSize()));
                    hashMap.put(ImageStatistics.KEY_NETWORK_WAIT_SIZE, Integer.valueOf(this.g.forNetwork().getQueueSize()));
                    hashMap.put(ImageStatistics.KEY_DECODE_WAIT_SIZE, Integer.valueOf(this.g.forDecode().getQueueSize()));
                }
                hashMap.put(ImageStatistics.KEY_WAIT_FOR_MAIN, Integer.valueOf(V));
            }
            if (z) {
                sb.append("Schedule-Time: ");
                sb.append(i4);
                xt2.k("PhenixConsumer", getContext(), "Detail-Cost:\n%s\n", sb.substring(0));
            }
            xt2.c("Phenix", "requestId=%d,UI_QUEUE_SIZE=%d", Integer.valueOf(i), Integer.valueOf(this.g.forUiThread().getQueueSize()));
            return hashMap;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean n(com.taobao.phenix.request.C6865a r7, java.lang.Throwable r8) {
        /*
            r6 = this;
            boolean r0 = r7.c0()
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            r0 = 0
            com.taobao.phenix.request.b r2 = r7.G()
            java.lang.String r2 = r2.k()
            tb.wr1 r3 = r6.e
            com.taobao.phenix.intf.event.IRetryHandlerOnFailure r3 = r3.u()
            if (r3 == 0) goto L25
            tb.wr1 r0 = r6.e
            java.lang.String r0 = r3.getRetryUrl(r0, r8)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L4e
        L25:
            boolean r3 = r8 instanceof com.taobao.phenix.decode.DecodeException
            if (r3 == 0) goto L4e
            r3 = r8
            com.taobao.phenix.decode.DecodeException r3 = (com.taobao.phenix.decode.DecodeException) r3
            tb.a22 r4 = r6.getContext()
            com.taobao.phenix.request.a r4 = (com.taobao.phenix.request.C6865a) r4
            com.taobao.phenix.request.b r4 = r4.G()
            boolean r5 = r3.isDataFromDisk()
            if (r5 == 0) goto L4e
            com.taobao.phenix.decode.DecodeException$DecodedError r5 = com.taobao.phenix.decode.DecodeException.DecodedError.UNLINK_SO_ERROR
            com.taobao.phenix.decode.DecodeException$DecodedError r3 = r3.getDecodedError()
            if (r5 == r3) goto L4e
            boolean r3 = r4.n()
            if (r3 != 0) goto L4e
            r7.s0()
            r0 = r2
        L4e:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L55
            return r1
        L55:
            r7.i0(r0)
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r8
            r8 = 1
            r0[r8] = r2
            java.lang.String r1 = "PhenixConsumer"
            java.lang.String r2 = "retry to load when received failure=%s, raw=%s"
            tb.xt2.x(r1, r7, r2, r0)
            tb.wr1 r7 = r6.e
            r7.n()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.zr1.n(com.taobao.phenix.request.a, java.lang.Throwable):boolean");
    }

    @Override // com.taobao.rxm.consume.BaseConsumer, com.taobao.rxm.consume.Consumer
    public Consumer<tq1, C6865a> consumeOn(Scheduler scheduler) {
        super.consumeOn(scheduler);
        ProducerListener g = getContext().g();
        if (g != null) {
            ((PhenixProduceListener) g).h(scheduler);
        }
        return this;
    }

    @Override // com.taobao.rxm.consume.BaseConsumer
    protected void e() {
        String N = getContext().N();
        xt2.k("PhenixConsumer", getContext(), "received cancellation, cost=%dms", Long.valueOf(System.currentTimeMillis() - getContext().S()));
        op0.g(getContext().U());
        op0.i(getContext().U());
        if (this.e.q() != null) {
            this.e.q().onHappen(new xr1(N, getContext().P()));
        }
        op0.h(getContext().U());
        ImageFlowMonitor imageFlowMonitor = this.f;
        if (imageFlowMonitor != null) {
            imageFlowMonitor.onCancel(getContext().U());
        }
        hh0.b(6, "Phenix", "Cancelled | requestId:" + getContext().d() + "| url:" + N);
    }

    @Override // com.taobao.rxm.consume.BaseConsumer
    protected void f(Throwable th) {
        C6865a context = getContext();
        if (n(context, th)) {
            return;
        }
        if (th instanceof MemOnlyFailedException) {
            xt2.k("PhenixConsumer", getContext(), "ignored MemOnlyFailedException(%s)", th);
            return;
        }
        xt2.m("PhenixConsumer", getContext(), "received failure=%s", th);
        if (hh0.g(3) && th != null) {
            th.printStackTrace();
        }
        op0.i(getContext().U());
        if (this.e.r() != null) {
            nh0 nh0Var = new nh0(context.P());
            if (th != null && (th instanceof HttpCodeResponseException)) {
                HttpCodeResponseException httpCodeResponseException = (HttpCodeResponseException) th;
                nh0Var.g(httpCodeResponseException.getHttpCode());
                nh0Var.h(httpCodeResponseException.getMessage());
            }
            nh0Var.i(404);
            nh0Var.c(getContext().N());
            this.e.r().onHappen(nh0Var);
        }
        op0.h(getContext().U());
        ImageFlowMonitor imageFlowMonitor = this.f;
        if (imageFlowMonitor != null) {
            imageFlowMonitor.onFail(context.U(), th);
        }
    }

    @Override // com.taobao.rxm.consume.BaseConsumer
    public void h(float f) {
        if (this.e.t() != null) {
            gv1 gv1Var = new gv1(getContext().P(), f);
            gv1Var.c(getContext().N());
            this.e.t().onHappen(gv1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.rxm.consume.BaseConsumer
    /* renamed from: k */
    public void g(tq1 tq1Var, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        xt2.n("Phenix", "UI Thread Process CallBack Started.", getContext());
        IPhenixListener<ui2> w = this.e.w();
        xt2.k("PhenixConsumer", getContext(), "received new result=%s, isLast=%b", tq1Var, Boolean.valueOf(z));
        op0.i(getContext().U());
        if (w != null) {
            ui2 ui2Var = new ui2(getContext().P());
            ui2Var.j(tq1Var);
            ui2Var.c(getContext().N());
            ui2Var.k(tq1Var.isFromMemory());
            ui2Var.l(!z);
            ui2Var.d(tq1Var.isFromDisk());
            ui2Var.e(tq1Var.isFromSecondary());
            w.onHappen(ui2Var);
        }
        xt2.n("Phenix", "UI Thread Process CallBack End.", getContext());
        op0.h(getContext().U());
        if (z) {
            l(currentTimeMillis);
        }
    }
}
