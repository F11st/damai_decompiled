package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.util.Collection;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.w */
/* loaded from: classes11.dex */
public class C7780w extends XMPushService.AbstractC7707j {
    private XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    private String f1000a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f1001a;
    private String b;
    private String c;

    public C7780w(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f1000a = str;
        this.f1001a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public String mo1157a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC7707j
    /* renamed from: a */
    public void mo878a() {
        bg.C7737b next;
        C7776t m1238a = C7777u.m1238a((Context) this.a);
        if (m1238a == null) {
            try {
                m1238a = C7777u.a(this.a, this.f1000a, this.b, this.c);
            } catch (Exception e) {
                AbstractC7535b.d("fail to register push account. " + e);
            }
        }
        if (m1238a == null) {
            AbstractC7535b.d("no account for registration.");
            C7781x.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        AbstractC7535b.m586a("do registration now.");
        Collection<bg.C7737b> m1195a = bg.a().m1195a("5");
        if (m1195a.isEmpty()) {
            next = m1238a.a(this.a);
            ah.a(this.a, next);
            bg.a().a(next);
        } else {
            next = m1195a.iterator().next();
        }
        if (!this.a.m1155c()) {
            C7781x.a(this.f1000a, this.f1001a);
            this.a.a(true);
            return;
        }
        try {
            bg.EnumC7741c enumC7741c = next.f923a;
            if (enumC7741c == bg.EnumC7741c.binded) {
                ah.a(this.a, this.f1000a, this.f1001a);
            } else if (enumC7741c == bg.EnumC7741c.unbind) {
                C7781x.a(this.f1000a, this.f1001a);
                XMPushService xMPushService = this.a;
                xMPushService.getClass();
                xMPushService.a(new XMPushService.C7699b(next));
            }
        } catch (gh e2) {
            AbstractC7535b.d("meet error, disconnect connection. " + e2);
            this.a.a(10, e2);
        }
    }
}
