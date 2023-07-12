package com.xiaomi.push.service;

import com.xiaomi.push.fh;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bq {
    private static int d = 300000;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f939a;
    private int b = 0;
    private int c = 0;
    private int a = 500;

    /* renamed from: a  reason: collision with other field name */
    private long f938a = 0;

    public bq(XMPushService xMPushService) {
        this.f939a = xMPushService;
    }

    private int a() {
        if (this.b > 8) {
            return com.alipay.sdk.m.e0.a.a;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f938a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f938a >= 310000) {
            this.a = 1000;
            this.c = 0;
            return 0;
        }
        int i2 = this.a;
        int i3 = d;
        if (i2 >= i3) {
            return i2;
        }
        int i4 = this.c + 1;
        this.c = i4;
        if (i4 >= 4) {
            return i3;
        }
        this.a = (int) (i2 * 1.5d);
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1205a() {
        this.f938a = System.currentTimeMillis();
        this.f939a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f939a.m1150a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f939a.m1151a(1)) {
                this.b++;
            }
            this.f939a.a(1);
            XMPushService xMPushService = this.f939a;
            xMPushService.getClass();
            xMPushService.a(new XMPushService.e());
        } else if (this.f939a.m1151a(1)) {
        } else {
            int a = a();
            this.b++;
            com.xiaomi.channel.commonutils.logger.b.m586a("schedule reconnect in " + a + "ms");
            XMPushService xMPushService2 = this.f939a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.e(), (long) a);
            if (this.b == 2 && fh.m881a().m886a()) {
                ap.b();
            }
            if (this.b == 3) {
                ap.a();
            }
        }
    }
}
