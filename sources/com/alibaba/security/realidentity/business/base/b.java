package com.alibaba.security.realidentity.business.base;

import android.content.Context;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.track.model.a;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.c;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class b {
    protected static final String a = "BusinessWorker";
    public Context b;
    public String c;
    private long d;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface a {
        void a(BucketParams bucketParams, Exception exc, boolean z);

        void a(BucketParams bucketParams, boolean z);

        void b(BucketParams bucketParams, boolean z);
    }

    public b(Context context) {
        this.b = context;
    }

    private void a(String str) {
        this.c = str;
    }

    private String k() {
        return this.c;
    }

    public abstract void a(c cVar);

    public abstract void a(c cVar, a aVar);

    public abstract void a(c cVar, BucketParams bucketParams);

    protected abstract String b();

    public abstract void b(c cVar, BucketParams bucketParams);

    protected abstract String c();

    protected abstract String d();

    protected abstract String e();

    protected abstract String f();

    protected abstract String g();

    public abstract void h();

    public abstract BusinessType i();

    protected boolean j() {
        return true;
    }

    public final void a(c cVar, final com.alibaba.security.realidentity.business.base.chain.a aVar) {
        this.d = System.currentTimeMillis();
        a(cVar, new a() { // from class: com.alibaba.security.realidentity.business.base.b.1
            @Override // com.alibaba.security.realidentity.business.base.b.a
            public final void a(BucketParams bucketParams, boolean z) {
                if (bucketParams != null) {
                    bucketParams.setCurrentErrorCode(bucketParams.parseErrorCode());
                }
                b.a(b.this, true);
                b.this.h();
                com.alibaba.security.realidentity.business.base.chain.a aVar2 = aVar;
                if (aVar2 != null) {
                    b.this.i();
                    aVar2.a(bucketParams, z);
                }
            }

            @Override // com.alibaba.security.realidentity.business.base.b.a
            public final void b(BucketParams bucketParams, boolean z) {
                if (bucketParams != null) {
                    bucketParams.setCurrentErrorCode(bucketParams.parseErrorCode());
                }
                b.a(b.this, false);
                b.this.h();
                com.alibaba.security.realidentity.business.base.chain.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(b.this.i(), bucketParams, z);
                }
            }

            @Override // com.alibaba.security.realidentity.business.base.b.a
            public final void a(BucketParams bucketParams, Exception exc, boolean z) {
                BucketParams.ErrorCode createAuditNotCode = BucketParams.ErrorCode.createAuditNotCode();
                createAuditNotCode.errorMsg = com.alibaba.security.common.d.b.b(exc);
                createAuditNotCode.globalErrorCode = GlobalErrorCode.ERROR_ONLINE_NET_ERROR;
                createAuditNotCode.errorCode = String.valueOf((int) GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
                bucketParams.setCurrentErrorCode(createAuditNotCode);
                b.a(b.this, exc);
                b.this.h();
                com.alibaba.security.realidentity.business.base.chain.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(b.this.i(), bucketParams, com.alibaba.security.common.d.b.b(exc), z);
                }
            }
        });
    }

    public final void a() {
        if (j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setLayer(a.C0166a.a);
            trackLog.setService(d());
            trackLog.setMethod(e());
            trackLog.setParams(b());
            trackLog.setMsg("");
            trackLog.setResult("");
            a(trackLog);
        }
    }

    private void a(Exception exc) {
        if (j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - this.d);
            trackLog.setLayer(a.C0166a.a);
            trackLog.setService(d());
            trackLog.setMethod(f());
            trackLog.setParams(b());
            trackLog.setMsg("");
            trackLog.setResult("onNetError: " + com.alibaba.security.common.d.b.b(exc));
            trackLog.setCode(-1);
            a(trackLog);
        }
    }

    private void a(boolean z) {
        if (j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - this.d);
            trackLog.setLayer(a.C0166a.a);
            trackLog.setService(d());
            trackLog.setMethod(f());
            trackLog.setParams(b());
            trackLog.setMsg(g());
            trackLog.setResult(c());
            trackLog.setCode(z ? 0 : -2);
            a(trackLog);
        }
    }

    public final void a(TrackLog trackLog) {
        g unused = g.a.a;
        g.a(this.c, trackLog);
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        if (bVar.j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - bVar.d);
            trackLog.setLayer(a.C0166a.a);
            trackLog.setService(bVar.d());
            trackLog.setMethod(bVar.f());
            trackLog.setParams(bVar.b());
            trackLog.setMsg(bVar.g());
            trackLog.setResult(bVar.c());
            trackLog.setCode(z ? 0 : -2);
            bVar.a(trackLog);
        }
    }

    static /* synthetic */ void a(b bVar, Exception exc) {
        if (bVar.j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - bVar.d);
            trackLog.setLayer(a.C0166a.a);
            trackLog.setService(bVar.d());
            trackLog.setMethod(bVar.f());
            trackLog.setParams(bVar.b());
            trackLog.setMsg("");
            trackLog.setResult("onNetError: " + com.alibaba.security.common.d.b.b(exc));
            trackLog.setCode(-1);
            bVar.a(trackLog);
        }
    }
}
