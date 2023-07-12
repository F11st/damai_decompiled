package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.al;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bz extends al.AbstractRunnableC7597a {
    final /* synthetic */ bx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bx bxVar) {
        this.a = bxVar;
    }

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a */
    public String mo706a() {
        return "10054";
    }

    @Override // java.lang.Runnable
    public void run() {
        String c;
        Context context;
        Context context2;
        AbstractC7535b.c("exec== DbSizeControlJob");
        c = this.a.c();
        context = this.a.f141a;
        cc ccVar = new cc(c, new WeakReference(context));
        context2 = this.a.f141a;
        cj.a(context2).a(ccVar);
        this.a.b("check_time");
    }
}
