package com.alibaba.security.realidentity.business.base;

import android.content.Context;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.common.d.C3805b;
import com.alibaba.security.common.track.model.C3834a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.business.C3873c;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.base.chain.InterfaceC3864a;
import com.alibaba.security.realidentity.business.bucket.BucketParams;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.business.base.b */
/* loaded from: classes8.dex */
public abstract class AbstractC3862b {
    protected static final String a = "BusinessWorker";
    public Context b;
    public String c;
    private long d;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.business.base.b$a */
    /* loaded from: classes8.dex */
    public interface InterfaceC3863a {
        void a(BucketParams bucketParams, Exception exc, boolean z);

        void a(BucketParams bucketParams, boolean z);

        void b(BucketParams bucketParams, boolean z);
    }

    public AbstractC3862b(Context context) {
        this.b = context;
    }

    private void a(String str) {
        this.c = str;
    }

    private String k() {
        return this.c;
    }

    public abstract void a(C3873c c3873c);

    public abstract void a(C3873c c3873c, InterfaceC3863a interfaceC3863a);

    public abstract void a(C3873c c3873c, BucketParams bucketParams);

    protected abstract String b();

    public abstract void b(C3873c c3873c, BucketParams bucketParams);

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

    public final void a(C3873c c3873c, final InterfaceC3864a interfaceC3864a) {
        this.d = System.currentTimeMillis();
        a(c3873c, new InterfaceC3863a() { // from class: com.alibaba.security.realidentity.business.base.b.1
            @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b.InterfaceC3863a
            public final void a(BucketParams bucketParams, boolean z) {
                if (bucketParams != null) {
                    bucketParams.setCurrentErrorCode(bucketParams.parseErrorCode());
                }
                AbstractC3862b.a(AbstractC3862b.this, true);
                AbstractC3862b.this.h();
                InterfaceC3864a interfaceC3864a2 = interfaceC3864a;
                if (interfaceC3864a2 != null) {
                    AbstractC3862b.this.i();
                    interfaceC3864a2.a(bucketParams, z);
                }
            }

            @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b.InterfaceC3863a
            public final void b(BucketParams bucketParams, boolean z) {
                if (bucketParams != null) {
                    bucketParams.setCurrentErrorCode(bucketParams.parseErrorCode());
                }
                AbstractC3862b.a(AbstractC3862b.this, false);
                AbstractC3862b.this.h();
                InterfaceC3864a interfaceC3864a2 = interfaceC3864a;
                if (interfaceC3864a2 != null) {
                    interfaceC3864a2.a(AbstractC3862b.this.i(), bucketParams, z);
                }
            }

            @Override // com.alibaba.security.realidentity.business.base.AbstractC3862b.InterfaceC3863a
            public final void a(BucketParams bucketParams, Exception exc, boolean z) {
                BucketParams.ErrorCode createAuditNotCode = BucketParams.ErrorCode.createAuditNotCode();
                createAuditNotCode.errorMsg = C3805b.b(exc);
                createAuditNotCode.globalErrorCode = GlobalErrorCode.ERROR_ONLINE_NET_ERROR;
                createAuditNotCode.errorCode = String.valueOf((int) GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
                bucketParams.setCurrentErrorCode(createAuditNotCode);
                AbstractC3862b.a(AbstractC3862b.this, exc);
                AbstractC3862b.this.h();
                InterfaceC3864a interfaceC3864a2 = interfaceC3864a;
                if (interfaceC3864a2 != null) {
                    interfaceC3864a2.a(AbstractC3862b.this.i(), bucketParams, C3805b.b(exc), z);
                }
            }
        });
    }

    public final void a() {
        if (j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setLayer(C3834a.C3835a.a);
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
            trackLog.setLayer(C3834a.C3835a.a);
            trackLog.setService(d());
            trackLog.setMethod(f());
            trackLog.setParams(b());
            trackLog.setMsg("");
            trackLog.setResult("onNetError: " + C3805b.b(exc));
            trackLog.setCode(-1);
            a(trackLog);
        }
    }

    private void a(boolean z) {
        if (j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - this.d);
            trackLog.setLayer(C3834a.C3835a.a);
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
        C3847g unused = C3847g.C3848a.a;
        C3847g.a(this.c, trackLog);
    }

    static /* synthetic */ void a(AbstractC3862b abstractC3862b, boolean z) {
        if (abstractC3862b.j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - abstractC3862b.d);
            trackLog.setLayer(C3834a.C3835a.a);
            trackLog.setService(abstractC3862b.d());
            trackLog.setMethod(abstractC3862b.f());
            trackLog.setParams(abstractC3862b.b());
            trackLog.setMsg(abstractC3862b.g());
            trackLog.setResult(abstractC3862b.c());
            trackLog.setCode(z ? 0 : -2);
            abstractC3862b.a(trackLog);
        }
    }

    static /* synthetic */ void a(AbstractC3862b abstractC3862b, Exception exc) {
        if (abstractC3862b.j()) {
            TrackLog trackLog = new TrackLog();
            trackLog.setRt(System.currentTimeMillis() - abstractC3862b.d);
            trackLog.setLayer(C3834a.C3835a.a);
            trackLog.setService(abstractC3862b.d());
            trackLog.setMethod(abstractC3862b.f());
            trackLog.setParams(abstractC3862b.b());
            trackLog.setMsg("");
            trackLog.setResult("onNetError: " + C3805b.b(exc));
            trackLog.setCode(-1);
            abstractC3862b.a(trackLog);
        }
    }
}
