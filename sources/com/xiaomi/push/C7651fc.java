package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.fc */
/* loaded from: classes11.dex */
public class C7651fc implements bg.C7737b.InterfaceC7738a {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private fw f344a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f345a;

    /* renamed from: a  reason: collision with other field name */
    private bg.C7737b f346a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f348a = false;

    /* renamed from: a  reason: collision with other field name */
    private bg.EnumC7741c f347a = bg.EnumC7741c.binding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7651fc(XMPushService xMPushService, bg.C7737b c7737b) {
        this.f345a = xMPushService;
        this.f346a = c7737b;
    }

    private void b() {
        this.f346a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            r4 = this;
            r4.b()
            boolean r0 = r4.f348a
            if (r0 != 0) goto L8
            return
        L8:
            int r0 = r4.a
            r1 = 11
            if (r0 != r1) goto Lf
            return
        Lf:
            com.xiaomi.push.fh r0 = com.xiaomi.push.fh.m881a()
            com.xiaomi.push.fa r0 = r0.m883a()
            int[] r1 = com.xiaomi.push.fe.a
            com.xiaomi.push.service.bg$c r2 = r4.f347a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L31
            r3 = 3
            if (r1 == r3) goto L28
            goto L5c
        L28:
            com.xiaomi.push.ez r1 = com.xiaomi.push.ez.BIND_SUCCESS
        L2a:
            int r1 = r1.a()
            r0.f330a = r1
            goto L5c
        L31:
            int r1 = r4.a
            r3 = 17
            if (r1 != r3) goto L3a
            com.xiaomi.push.ez r1 = com.xiaomi.push.ez.BIND_TCP_READ_TIMEOUT
            goto L2a
        L3a:
            r3 = 21
            if (r1 != r3) goto L41
            com.xiaomi.push.ez r1 = com.xiaomi.push.ez.BIND_TIMEOUT
            goto L2a
        L41:
            com.xiaomi.push.fg r1 = com.xiaomi.push.fh.a()     // Catch: java.lang.NullPointerException -> L5b
            java.lang.Exception r1 = r1.a()     // Catch: java.lang.NullPointerException -> L5b
            com.xiaomi.push.ff$a r1 = com.xiaomi.push.ff.c(r1)     // Catch: java.lang.NullPointerException -> L5b
            com.xiaomi.push.ez r3 = r1.a     // Catch: java.lang.NullPointerException -> L5b
            int r3 = r3.a()     // Catch: java.lang.NullPointerException -> L5b
            r0.f330a = r3     // Catch: java.lang.NullPointerException -> L5b
            java.lang.String r1 = r1.f349a     // Catch: java.lang.NullPointerException -> L5b
            r0.c(r1)     // Catch: java.lang.NullPointerException -> L5b
            goto L5c
        L5b:
            r0 = 0
        L5c:
            if (r0 == 0) goto L83
            com.xiaomi.push.fw r1 = r4.f344a
            java.lang.String r1 = r1.mo910a()
            r0.b(r1)
            com.xiaomi.push.service.bg$b r1 = r4.f346a
            java.lang.String r1 = r1.f928b
            r0.d(r1)
            r0.f333b = r2
            com.xiaomi.push.service.bg$b r1 = r4.f346a     // Catch: java.lang.NumberFormatException -> L7c
            java.lang.String r1 = r1.g     // Catch: java.lang.NumberFormatException -> L7c
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L7c
            byte r1 = (byte) r1     // Catch: java.lang.NumberFormatException -> L7c
            r0.a(r1)     // Catch: java.lang.NumberFormatException -> L7c
        L7c:
            com.xiaomi.push.fh r1 = com.xiaomi.push.fh.m881a()
            r1.a(r0)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C7651fc.c():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f346a.a(this);
        this.f344a = this.f345a.m1147a();
    }

    @Override // com.xiaomi.push.service.bg.C7737b.InterfaceC7738a
    public void a(bg.EnumC7741c enumC7741c, bg.EnumC7741c enumC7741c2, int i) {
        if (!this.f348a && enumC7741c == bg.EnumC7741c.binding) {
            this.f347a = enumC7741c2;
            this.a = i;
            this.f348a = true;
        }
        this.f345a.a(new fd(this, 4));
    }
}
