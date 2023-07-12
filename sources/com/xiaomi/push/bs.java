package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bs implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f139a;

    public void a(Context context) {
        this.a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f139a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bw a;
        String str;
        long currentTimeMillis;
        try {
            com.xiaomi.clientreport.processor.c cVar = this.f139a;
            if (cVar != null) {
                cVar.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            com.xiaomi.clientreport.processor.c cVar2 = this.f139a;
            if (cVar2 instanceof IEventProcessor) {
                a = bw.a(this.a);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else if (!(cVar2 instanceof IPerfProcessor)) {
                return;
            } else {
                a = bw.a(this.a);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            }
            a.m710a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
