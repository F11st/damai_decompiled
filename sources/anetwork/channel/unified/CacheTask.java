package anetwork.channel.unified;

import anet.channel.fulltrace.C0179a;
import anet.channel.request.C0193a;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.interceptor.Callback;
import mtopsdk.common.util.HttpHeaderConstant;
import tb.he;
import tb.z12;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CacheTask implements IUnifiedTask {
    private static final String TAG = "anet.CacheTask";
    private Cache cache;
    private volatile boolean isCanceled = false;
    private C0254b rc;

    public CacheTask(C0254b c0254b, Cache cache) {
        this.rc = null;
        this.cache = null;
        this.rc = c0254b;
        this.cache = cache;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.isCanceled = true;
        this.rc.a.f.ret = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean equals;
        Cache.Entry entry;
        if (this.isCanceled) {
            return;
        }
        z12 z12Var = this.rc.a;
        RequestStatistic requestStatistic = z12Var.f;
        if (this.cache != null) {
            String h = z12Var.h();
            C0193a b = this.rc.a.b();
            String str = b.g().get("Cache-Control");
            boolean equals2 = "no-store".equals(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (equals2) {
                this.cache.remove(h);
                equals = false;
                entry = null;
            } else {
                equals = HttpHeaderConstant.NO_CACHE.equals(str);
                entry = this.cache.get(h);
                if (ALog.g(2)) {
                    String str2 = this.rc.c;
                    Object[] objArr = new Object[8];
                    objArr[0] = "hit";
                    objArr[1] = Boolean.valueOf(entry != null);
                    objArr[2] = "cost";
                    objArr[3] = Long.valueOf(requestStatistic.cacheTime);
                    objArr[4] = "length";
                    objArr[5] = Integer.valueOf(entry != null ? entry.data.length : 0);
                    objArr[6] = "key";
                    objArr[7] = h;
                    ALog.f(TAG, "read cache", str2, objArr);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            requestStatistic.cacheTime = currentTimeMillis2 - currentTimeMillis;
            if (entry != null && !equals && entry.isFresh()) {
                if (this.rc.d.compareAndSet(false, true)) {
                    this.rc.c();
                    requestStatistic.ret = 1;
                    requestStatistic.statusCode = 200;
                    requestStatistic.msg = "SUCCESS";
                    requestStatistic.protocolType = "cache";
                    requestStatistic.rspEnd = currentTimeMillis2;
                    C0179a.f().log(requestStatistic.span, "netRspRecvEnd", null);
                    requestStatistic.processTime = currentTimeMillis2 - requestStatistic.start;
                    if (ALog.g(2)) {
                        C0254b c0254b = this.rc;
                        ALog.f(TAG, "hit fresh cache", c0254b.c, "URL", c0254b.a.e().n());
                    }
                    this.rc.b.onResponseCode(200, entry.responseHeaders);
                    Callback callback = this.rc.b;
                    byte[] bArr = entry.data;
                    callback.onDataReceiveSize(1, bArr.length, he.g(bArr));
                    this.rc.b.onFinish(new DefaultFinishEvent(200, "SUCCESS", b));
                }
            } else if (this.isCanceled) {
            } else {
                NetworkTask networkTask = new NetworkTask(this.rc, equals2 ? null : this.cache, entry);
                this.rc.e = networkTask;
                networkTask.run();
            }
        }
    }
}
