package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.InterfaceC7550c;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bs implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private InterfaceC7550c f139a;

    public void a(Context context) {
        this.a = context;
    }

    public void a(InterfaceC7550c interfaceC7550c) {
        this.f139a = interfaceC7550c;
    }

    @Override // java.lang.Runnable
    public void run() {
        bw a;
        String str;
        long currentTimeMillis;
        try {
            InterfaceC7550c interfaceC7550c = this.f139a;
            if (interfaceC7550c != null) {
                interfaceC7550c.a();
            }
            AbstractC7535b.c("begin read and send perf / event");
            InterfaceC7550c interfaceC7550c2 = this.f139a;
            if (interfaceC7550c2 instanceof IEventProcessor) {
                a = bw.a(this.a);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else if (!(interfaceC7550c2 instanceof IPerfProcessor)) {
                return;
            } else {
                a = bw.a(this.a);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            }
            a.m710a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e) {
            AbstractC7535b.a(e);
        }
    }
}
