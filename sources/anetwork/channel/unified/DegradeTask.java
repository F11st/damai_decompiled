package anetwork.channel.unified;

import android.text.TextUtils;
import anet.channel.RequestCb;
import anet.channel.request.Cancelable;
import anet.channel.request.a;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cookie.CookieManager;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.List;
import java.util.Map;
import tb.h01;
import tb.he;
import tb.zh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DegradeTask implements IUnifiedTask {
    private static final String TAG = "anet.DegradeTask";
    private b rc;
    private anet.channel.request.a request;
    private volatile boolean isCanceled = false;
    volatile Cancelable cancelable = null;
    private int contentLength = 0;
    private int dataChunkIndex = 0;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    class a implements RequestCb {
        a() {
        }

        @Override // anet.channel.RequestCb
        public void onDataReceive(he heVar, boolean z) {
            if (DegradeTask.this.rc.d.get()) {
                return;
            }
            DegradeTask.access$208(DegradeTask.this);
            if (DegradeTask.this.rc.b != null) {
                DegradeTask.this.rc.b.onDataReceiveSize(DegradeTask.this.dataChunkIndex, DegradeTask.this.contentLength, heVar);
            }
        }

        @Override // anet.channel.RequestCb
        public void onFinish(int i, String str, RequestStatistic requestStatistic) {
            if (DegradeTask.this.rc.d.getAndSet(true)) {
                return;
            }
            if (ALog.g(2)) {
                ALog.f(DegradeTask.TAG, "[onFinish]", DegradeTask.this.rc.c, "code", Integer.valueOf(i), "msg", str);
            }
            DegradeTask.this.rc.c();
            requestStatistic.isDone.set(true);
            if (DegradeTask.this.rc.b != null) {
                DegradeTask.this.rc.b.onFinish(new DefaultFinishEvent(i, str, DegradeTask.this.request));
            }
        }

        @Override // anet.channel.RequestCb
        public void onResponseCode(int i, Map<String, List<String>> map) {
            if (DegradeTask.this.rc.d.get()) {
                return;
            }
            DegradeTask.this.rc.c();
            CookieManager.l(DegradeTask.this.rc.a.h(), map);
            DegradeTask.this.contentLength = h01.f(map);
            if (DegradeTask.this.rc.b != null) {
                DegradeTask.this.rc.b.onResponseCode(i, map);
            }
        }
    }

    public DegradeTask(b bVar) {
        this.rc = bVar;
        this.request = bVar.a.b();
    }

    static /* synthetic */ int access$208(DegradeTask degradeTask) {
        int i = degradeTask.dataChunkIndex;
        degradeTask.dataChunkIndex = i + 1;
        return i;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.isCanceled = true;
        if (this.cancelable != null) {
            this.cancelable.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isCanceled) {
            return;
        }
        if (this.rc.a.n()) {
            String i = CookieManager.i(this.rc.a.h());
            if (!TextUtils.isEmpty(i)) {
                a.b u = this.request.u();
                String str = this.request.g().get(IRequestConst.COOKIE);
                if (!TextUtils.isEmpty(str)) {
                    i = zh2.e(str, "; ", i);
                }
                u.I(IRequestConst.COOKIE, i);
                this.request = u.J();
            }
        }
        this.request.r.degraded = 2;
        this.request.r.sendBeforeTime = System.currentTimeMillis() - this.request.r.reqStart;
        anet.channel.session.a.b(this.request, new a());
    }
}
