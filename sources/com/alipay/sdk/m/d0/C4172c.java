package com.alipay.sdk.m.d0;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.AbstractC4091w;
import com.alipay.android.phone.mrpc.core.C4075h;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.sdk.m.e0.C4186a;
import com.alipay.sdk.m.z.C4368a;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.d0.c */
/* loaded from: classes10.dex */
public class C4172c implements InterfaceC4170a {
    public static C4172c d;
    public static DataReportResult e;
    public AbstractC4091w a;
    public BugTrackMessageService b;
    public DataReportService c;

    public C4172c(Context context, String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        C4075h c4075h = new C4075h(context);
        this.a = c4075h;
        this.b = (BugTrackMessageService) c4075h.a(BugTrackMessageService.class, aaVar);
        this.c = (DataReportService) this.a.a(DataReportService.class, aaVar);
    }

    public static synchronized C4172c a(Context context, String str) {
        C4172c c4172c;
        synchronized (C4172c.class) {
            if (d == null) {
                d = new C4172c(context, str);
            }
            c4172c = d;
        }
        return c4172c;
    }

    @Override // com.alipay.sdk.m.d0.InterfaceC4170a
    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.c != null) {
            e = null;
            new Thread(new RunnableC4171b(this, dataReportRequest)).start();
            for (int i = C4186a.a; e == null && i >= 0; i -= 50) {
                Thread.sleep(50L);
            }
        }
        return e;
    }

    @Override // com.alipay.sdk.m.d0.InterfaceC4170a
    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        if (C4368a.a(str) || (bugTrackMessageService = this.b) == null) {
            return false;
        }
        String str2 = null;
        try {
            str2 = bugTrackMessageService.logCollect(C4368a.f(str));
        } catch (Throwable unused) {
        }
        if (C4368a.a(str2)) {
            return false;
        }
        return ((Boolean) new JSONObject(str2).get("success")).booleanValue();
    }
}
