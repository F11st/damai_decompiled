package com.alipay.sdk.m.d0;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b implements Runnable {
    public final /* synthetic */ DataReportRequest a;
    public final /* synthetic */ c b;

    public b(c cVar, DataReportRequest dataReportRequest) {
        this.b = cVar;
        this.a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.b.c;
            DataReportResult unused = c.e = dataReportService.reportData(this.a);
        } catch (Throwable th) {
            DataReportResult unused2 = c.e = new DataReportResult();
            dataReportResult = c.e;
            dataReportResult.success = false;
            dataReportResult2 = c.e;
            dataReportResult2.resultCode = "static data rpc upload error, " + com.alipay.sdk.m.z.a.a(th);
            com.alipay.sdk.m.z.a.a(th);
        }
    }
}
