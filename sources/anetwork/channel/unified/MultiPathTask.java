package anetwork.channel.unified;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import anet.channel.RequestCb;
import anet.channel.request.C0193a;
import anet.channel.request.Cancelable;
import anet.channel.session.HttpSession;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cookie.CookieManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.h01;
import tb.he;
import tb.hu0;
import tb.jg1;
import tb.o01;
import tb.zh2;
import tb.zm;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MultiPathTask implements IUnifiedTask {
    private static final String TAG = "anet.MultiPathTask";
    private static AtomicBoolean toastStatus = new AtomicBoolean(false);
    private static Handler uiHandler = new Handler(Looper.getMainLooper());
    private String f_refer;
    private C0254b rc;
    private C0193a req;
    private volatile boolean isCanceled = false;
    volatile Cancelable cancelable = null;
    private int contentLength = 0;
    private int dataChunkIndex = 0;
    private AtomicBoolean responseReturn = new AtomicBoolean(false);

    /* compiled from: Taobao */
    /* renamed from: anetwork.channel.unified.MultiPathTask$a */
    /* loaded from: classes.dex */
    class C0248a implements RequestCb {
        final /* synthetic */ RequestStatistic a;
        final /* synthetic */ C0193a b;

        C0248a(RequestStatistic requestStatistic, C0193a c0193a) {
            this.a = requestStatistic;
            this.b = c0193a;
        }

        @Override // anet.channel.RequestCb
        public void onDataReceive(he heVar, boolean z) {
            if (!MultiPathTask.this.responseReturn.get() || MultiPathTask.this.isCanceled || MultiPathTask.this.rc.d.get()) {
                return;
            }
            MultiPathTask.access$408(MultiPathTask.this);
            if (MultiPathTask.this.rc.b != null) {
                MultiPathTask.this.rc.b.onDataReceiveSize(MultiPathTask.this.dataChunkIndex, MultiPathTask.this.contentLength, heVar);
            }
        }

        @Override // anet.channel.RequestCb
        public void onFinish(int i, String str, RequestStatistic requestStatistic) {
            if (!MultiPathTask.this.responseReturn.get() || MultiPathTask.this.isCanceled || MultiPathTask.this.rc.d.getAndSet(true)) {
                return;
            }
            if (ALog.g(2)) {
                ALog.f(MultiPathTask.TAG, "[onFinish]", MultiPathTask.this.rc.c, "code", Integer.valueOf(i), "msg", str);
            }
            requestStatistic.useMultiPath = 1;
            MultiPathTask.this.rc.c();
            requestStatistic.isDone.set(true);
            if (MultiPathTask.this.rc.b != null) {
                MultiPathTask.this.rc.b.onFinish(new DefaultFinishEvent(i, str, this.b));
            }
        }

        @Override // anet.channel.RequestCb
        public void onResponseCode(int i, Map<String, List<String>> map) {
            if (MultiPathTask.this.rc.d.get() || MultiPathTask.this.isCanceled || i != 200) {
                return;
            }
            MultiPathTask.this.responseReturn.set(true);
            this.a.useMultiPath = 1;
            MultiPathTask.this.rc.c();
            CookieManager.l(MultiPathTask.this.rc.a.h(), map);
            MultiPathTask.this.contentLength = h01.f(map);
            if (MultiPathTask.this.rc.b != null) {
                MultiPathTask.this.rc.b.onResponseCode(i, map);
            }
        }
    }

    public MultiPathTask(C0254b c0254b) {
        this.rc = c0254b;
        this.req = c0254b.a.b();
        this.f_refer = c0254b.a.d().get(HttpHeaderConstant.F_REFER);
    }

    static /* synthetic */ int access$408(MultiPathTask multiPathTask) {
        int i = multiPathTask.dataChunkIndex;
        multiPathTask.dataChunkIndex = i + 1;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private anet.channel.request.C0193a preProcessRequest(anet.channel.request.C0193a r6) {
        /*
            r5 = this;
            anetwork.channel.unified.b r0 = r5.rc
            tb.z12 r0 = r0.a
            boolean r0 = r0.n()
            if (r0 == 0) goto L3c
            anetwork.channel.unified.b r0 = r5.rc
            tb.z12 r0 = r0.a
            java.lang.String r0 = r0.h()
            java.lang.String r0 = anetwork.channel.cookie.CookieManager.i(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L3c
            anet.channel.request.a$b r1 = r6.u()
            java.util.Map r2 = r6.g()
            java.lang.String r3 = "Cookie"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L38
            java.lang.String r4 = "; "
            java.lang.String r0 = tb.zh2.e(r2, r4, r0)
        L38:
            r1.I(r3, r0)
            goto L3d
        L3c:
            r1 = 0
        L3d:
            if (r1 != 0) goto L40
            goto L44
        L40:
            anet.channel.request.a r6 = r1.J()
        L44:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.unified.MultiPathTask.preProcessRequest(anet.channel.request.a):anet.channel.request.a");
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.isCanceled = true;
        if (this.cancelable != null) {
            this.cancelable.cancel();
        }
    }

    public boolean isResponseReturn() {
        return this.responseReturn.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isCanceled || this.rc.d.get()) {
            return;
        }
        ALog.e(TAG, "start multi path request.", this.rc.c, new Object[0]);
        if (toastStatus.compareAndSet(false, true)) {
            uiHandler.post(new Runnable() { // from class: anetwork.channel.unified.MultiPathTask.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(hu0.c(), "正在移动数据改善浏览体验，可在设置-通用里关闭", 0).show();
                }
            });
        }
        C0193a preProcessRequest = preProcessRequest(this.req);
        o01 e = this.rc.a.e();
        RequestStatistic requestStatistic = this.rc.a.f;
        String e2 = zh2.e(e.j(), jg1.SCHEME_SLASH, e.d());
        Context c = hu0.c();
        HttpSession httpSession = new HttpSession(c, new zm(e2, this.rc.c + "_mc", null));
        httpSession.F(true);
        this.cancelable = httpSession.w(preProcessRequest, new C0248a(requestStatistic, preProcessRequest));
    }
}
