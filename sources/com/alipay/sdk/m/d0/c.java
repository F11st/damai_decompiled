package com.alipay.sdk.m.d0;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c implements a {
    public static c d;
    public static DataReportResult e;
    public w a;
    public BugTrackMessageService b;
    public DataReportService c;

    public c(Context context, String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.a = hVar;
        this.b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.c = (DataReportService) this.a.a(DataReportService.class, aaVar);
    }

    public static synchronized c a(Context context, String str) {
        c cVar;
        synchronized (c.class) {
            if (d == null) {
                d = new c(context, str);
            }
            cVar = d;
        }
        return cVar;
    }

    @Override // com.alipay.sdk.m.d0.a
    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.c != null) {
            e = null;
            new Thread(new b(this, dataReportRequest)).start();
            for (int i = com.alipay.sdk.m.e0.a.a; e == null && i >= 0; i -= 50) {
                Thread.sleep(50L);
            }
        }
        return e;
    }

    @Override // com.alipay.sdk.m.d0.a
    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        if (com.alipay.sdk.m.z.a.a(str) || (bugTrackMessageService = this.b) == null) {
            return false;
        }
        String str2 = null;
        try {
            str2 = bugTrackMessageService.logCollect(com.alipay.sdk.m.z.a.f(str));
        } catch (Throwable unused) {
        }
        if (com.alipay.sdk.m.z.a.a(str2)) {
            return false;
        }
        return ((Boolean) new JSONObject(str2).get("success")).booleanValue();
    }
}
