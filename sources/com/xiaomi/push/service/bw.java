package com.xiaomi.push.service;

import com.xiaomi.push.ao;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.bv;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bw extends ao.AbstractC7600b {
    final /* synthetic */ bv a;

    /* renamed from: a  reason: collision with other field name */
    boolean f946a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar) {
        this.a = bvVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039 A[Catch: Exception -> 0x0047, TRY_LEAVE, TryCatch #0 {Exception -> 0x0047, blocks: (B:2:0x0000, B:4:0x0012, B:9:0x0024, B:11:0x0039), top: B:16:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.xiaomi.push.ao.AbstractC7600b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r3 = this;
            android.content.Context r0 = com.xiaomi.push.C7786v.m1245a()     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.service.a r0 = com.xiaomi.push.service.C7718a.a(r0)     // Catch: java.lang.Exception -> L47
            java.lang.String r0 = r0.a()     // Catch: java.lang.Exception -> L47
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L47
            if (r1 != 0) goto L22
            com.xiaomi.push.q r1 = com.xiaomi.push.EnumC7693q.China     // Catch: java.lang.Exception -> L47
            java.lang.String r1 = r1.name()     // Catch: java.lang.Exception -> L47
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L1f
            goto L22
        L1f:
            java.lang.String r0 = "https://resolver.msg.global.xiaomi.net/psc/?t=a"
            goto L24
        L22:
            java.lang.String r0 = "https://resolver.msg.xiaomi.net/psc/?t=a"
        L24:
            android.content.Context r1 = com.xiaomi.push.C7786v.m1245a()     // Catch: java.lang.Exception -> L47
            r2 = 0
            java.lang.String r0 = com.xiaomi.push.cz.a(r1, r0, r2)     // Catch: java.lang.Exception -> L47
            r1 = 10
            byte[] r0 = android.util.Base64.decode(r0, r1)     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.dw$a r0 = com.xiaomi.push.dw.C7634a.a(r0)     // Catch: java.lang.Exception -> L47
            if (r0 == 0) goto L60
            com.xiaomi.push.service.bv r1 = r3.a     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.service.bv.a(r1, r0)     // Catch: java.lang.Exception -> L47
            r0 = 1
            r3.f946a = r0     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.service.bv r0 = r3.a     // Catch: java.lang.Exception -> L47
            com.xiaomi.push.service.bv.m1208a(r0)     // Catch: java.lang.Exception -> L47
            goto L60
        L47:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "fetch config failure: "
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.xiaomi.channel.commonutils.logger.AbstractC7535b.m586a(r0)
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bw.b():void");
    }

    @Override // com.xiaomi.push.ao.AbstractC7600b
    /* renamed from: c */
    public void mo765c() {
        List list;
        List list2;
        bv.AbstractC7745a[] abstractC7745aArr;
        dw.C7634a c7634a;
        this.a.f943a = null;
        if (this.f946a) {
            synchronized (this.a) {
                list = this.a.f945a;
                list2 = this.a.f945a;
                abstractC7745aArr = (bv.AbstractC7745a[]) list.toArray(new bv.AbstractC7745a[list2.size()]);
            }
            for (bv.AbstractC7745a abstractC7745a : abstractC7745aArr) {
                c7634a = this.a.f944a;
                abstractC7745a.a(c7634a);
            }
        }
    }
}
