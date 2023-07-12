package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Collection;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class w extends XMPushService.j {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private String f1000a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f1001a;
    private String b;
    private String c;

    public w(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f1000a = str;
        this.f1001a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo1157a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo878a() {
        bg.b next;
        t m1238a = u.m1238a((Context) this.a);
        if (m1238a == null) {
            try {
                m1238a = u.a(this.a, this.f1000a, this.b, this.c);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e);
            }
        }
        if (m1238a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            x.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m586a("do registration now.");
        Collection<bg.b> m1195a = bg.a().m1195a("5");
        if (m1195a.isEmpty()) {
            next = m1238a.a(this.a);
            ah.a(this.a, next);
            bg.a().a(next);
        } else {
            next = m1195a.iterator().next();
        }
        if (!this.a.m1155c()) {
            x.a(this.f1000a, this.f1001a);
            this.a.a(true);
            return;
        }
        try {
            bg.c cVar = next.f923a;
            if (cVar == bg.c.binded) {
                ah.a(this.a, this.f1000a, this.f1001a);
            } else if (cVar == bg.c.unbind) {
                x.a(this.f1000a, this.f1001a);
                XMPushService xMPushService = this.a;
                xMPushService.getClass();
                xMPushService.a(new XMPushService.b(next));
            }
        } catch (gh e2) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e2);
            this.a.a(10, e2);
        }
    }
}
