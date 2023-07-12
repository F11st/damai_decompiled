package com.alipay.sdk.m.d0;

import com.alipay.sdk.m.z.C4368a;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.d0.b */
/* loaded from: classes12.dex */
public class RunnableC4171b implements Runnable {
    public final /* synthetic */ DataReportRequest a;
    public final /* synthetic */ C4172c b;

    public RunnableC4171b(C4172c c4172c, DataReportRequest dataReportRequest) {
        this.b = c4172c;
        this.a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.b.c;
            DataReportResult unused = C4172c.e = dataReportService.reportData(this.a);
        } catch (Throwable th) {
            DataReportResult unused2 = C4172c.e = new DataReportResult();
            dataReportResult = C4172c.e;
            dataReportResult.success = false;
            dataReportResult2 = C4172c.e;
            dataReportResult2.resultCode = "static data rpc upload error, " + C4368a.a(th);
            C4368a.a(th);
        }
    }
}
