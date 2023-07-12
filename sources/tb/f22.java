package tb;

import android.text.TextUtils;
import com.taobao.rxm.common.Releasable;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.produce.BaseChainProducer;
import com.taobao.rxm.request.MultiplexCancelListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.a22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f22<OUT extends Releasable, CONTEXT extends a22> extends BaseChainProducer<OUT, OUT, CONTEXT> implements MultiplexCancelListener {
    public Class<OUT> j;
    private Map<String, Integer> k;
    private Map<Integer, ArrayList<Consumer<OUT, CONTEXT>>> l;

    public f22(Class<OUT> cls) {
        super(1, 29);
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.j = cls;
    }

    private void H(ArrayList<Consumer<OUT, CONTEXT>> arrayList, Consumer<OUT, CONTEXT> consumer) {
        arrayList.add(consumer);
        int h = consumer.getContext().h();
        CONTEXT context = J(arrayList).getContext();
        if (h > context.h()) {
            context.q(h);
        }
        if (!context.i() || consumer.getContext().j()) {
            return;
        }
        context.c(false);
    }

    private void I(Consumer<OUT, CONTEXT> consumer, d62<OUT> d62Var) {
        CONTEXT context = consumer.getContext();
        ArrayList<Consumer<OUT, CONTEXT>> arrayList = this.l.get(Integer.valueOf(context.d()));
        String e = context.e();
        int i = 4;
        if (arrayList == null) {
            hh0.i("RxSysLog", "[RequestMultiplex] group has been removed from multiplex, but pipeline is still producing new result(multiplex:%s, id:%d, pipeline:%d, type:%d)", e, Integer.valueOf(context.d()), Integer.valueOf(context.f()), Integer.valueOf(d62Var.a));
            return;
        }
        synchronized (this) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Consumer<OUT, CONTEXT> consumer2 = arrayList.get(i2);
                CONTEXT context2 = consumer2.getContext();
                if (consumer2 != consumer) {
                    context2.r(context);
                }
                if (!context2.j()) {
                    int i3 = d62Var.a;
                    if (i3 == 1) {
                        consumer2.onNewResult(d62Var.c, d62Var.b);
                    } else if (i3 == i) {
                        consumer2.onProgressUpdate(d62Var.d);
                    } else if (i3 == 8) {
                        hh0.c("RxSysLog", "[RequestMultiplex] ID=%d consumers of the group were not all cancelled, but pipeline dispatched cancellation result", Integer.valueOf(context2.d()));
                        consumer2.onCancellation();
                    } else if (i3 == 16) {
                        consumer2.onFailure(d62Var.e);
                    }
                } else {
                    if (d62Var.a == 16) {
                        hh0.f("RxSysLog", "[RequestMultiplex] ID=%d received error after cancellation, throwable=%s", Integer.valueOf(context2.d()), d62Var.e);
                    }
                    consumer2.onCancellation();
                }
                i2++;
                i = 4;
            }
            if (d62Var.b) {
                if (!TextUtils.isEmpty(e)) {
                    this.k.remove(e);
                }
                this.l.remove(Integer.valueOf(context.d()));
            }
        }
    }

    private Consumer<OUT, CONTEXT> J(ArrayList<Consumer<OUT, CONTEXT>> arrayList) {
        return arrayList.get(0);
    }

    private boolean K(ArrayList<Consumer<OUT, CONTEXT>> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList.get(i).getContext().j()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    /* renamed from: D */
    public void consumeNewResult(Consumer<OUT, CONTEXT> consumer, boolean z, OUT out) {
        d62<OUT> d62Var = new d62<>(1, z);
        d62Var.c = out;
        I(consumer, d62Var);
    }

    @Override // tb.jh
    protected boolean a(Consumer<OUT, CONTEXT> consumer) {
        ArrayList<Consumer<OUT, CONTEXT>> arrayList;
        boolean z;
        CONTEXT context = consumer.getContext();
        String e = context.e();
        synchronized (this) {
            Integer num = this.k.get(e);
            if (num == null) {
                num = Integer.valueOf(context.d());
                this.k.put(e, num);
                arrayList = new ArrayList<>(2);
                this.l.put(num, arrayList);
                z = false;
            } else {
                arrayList = this.l.get(num);
                z = true;
            }
            context.o(num.intValue());
            context.n(this);
            H(arrayList, consumer);
        }
        return z;
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    public void consumeCancellation(Consumer<OUT, CONTEXT> consumer) {
        I(consumer, new d62<>(8, true));
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    public void consumeFailure(Consumer<OUT, CONTEXT> consumer, Throwable th) {
        d62<OUT> d62Var = new d62<>(16, true);
        d62Var.e = th;
        I(consumer, d62Var);
    }

    @Override // com.taobao.rxm.produce.BaseChainProducer, com.taobao.rxm.consume.ChainConsumer
    public void consumeProgressUpdate(Consumer<OUT, CONTEXT> consumer, float f) {
        d62<OUT> d62Var = new d62<>(4, false);
        d62Var.d = f;
        I(consumer, d62Var);
    }

    @Override // tb.jh
    public Type h() {
        return this.j;
    }

    @Override // tb.jh
    public Type j() {
        return this.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:9:0x0021, B:11:0x0033, B:17:0x003f, B:18:0x004f), top: B:25:0x0021 }] */
    @Override // com.taobao.rxm.request.MultiplexCancelListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCancelRequest(tb.a22 r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.e()
            java.util.Map<java.lang.String, java.lang.Integer> r1 = r7.k
            boolean r1 = r1.containsKey(r0)
            if (r1 != 0) goto Ld
            return
        Ld:
            java.util.Map<java.lang.Integer, java.util.ArrayList<com.taobao.rxm.consume.Consumer<OUT extends com.taobao.rxm.common.Releasable, CONTEXT extends tb.a22>>> r1 = r7.l
            int r8 = r8.f()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Object r8 = r1.get(r8)
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            if (r8 != 0) goto L20
            return
        L20:
            monitor-enter(r7)
            com.taobao.rxm.consume.Consumer r1 = r7.J(r8)     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r2 = r1.getContext()     // Catch: java.lang.Throwable -> L5c
            tb.a22 r2 = (tb.a22) r2     // Catch: java.lang.Throwable -> L5c
            boolean r2 = r2.i()     // Catch: java.lang.Throwable -> L5c
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L3c
            boolean r8 = r7.K(r8)     // Catch: java.lang.Throwable -> L5c
            if (r8 == 0) goto L3a
            goto L3c
        L3a:
            r8 = 0
            goto L3d
        L3c:
            r8 = 1
        L3d:
            if (r8 == 0) goto L4f
            java.util.Map<java.lang.String, java.lang.Integer> r2 = r7.k     // Catch: java.lang.Throwable -> L5c
            r2.remove(r0)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r2 = "RxSysLog"
            java.lang.String r5 = "[RequestMultiplex] all of context in group[key:%s] were cancelled, remove it from KeyToGroupId"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5c
            r6[r3] = r0     // Catch: java.lang.Throwable -> L5c
            tb.hh0.a(r2, r5, r6)     // Catch: java.lang.Throwable -> L5c
        L4f:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L5c
            if (r8 == 0) goto L5b
            java.lang.Object r8 = r1.getContext()
            tb.a22 r8 = (tb.a22) r8
            r8.c(r4)
        L5b:
            return
        L5c:
            r8 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L5c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.f22.onCancelRequest(tb.a22):void");
    }
}
