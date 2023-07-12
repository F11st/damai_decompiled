package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.al;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class by extends al.AbstractRunnableC7597a {
    final /* synthetic */ bx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a */
    public String mo706a() {
        return "10052";
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC7622cn interfaceC7622cn;
        InterfaceC7622cn interfaceC7622cn2;
        Context context;
        AbstractC7535b.c("exec== mUploadJob");
        interfaceC7622cn = this.a.f144a;
        if (interfaceC7622cn != null) {
            interfaceC7622cn2 = this.a.f144a;
            context = this.a.f141a;
            interfaceC7622cn2.a(context);
            this.a.b("upload_time");
        }
    }
}
