package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.cj;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cc implements Runnable {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f152a;

    public cc(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f152a = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f152a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (cp.a(this.a) <= cb.f150a) {
            AbstractC7535b.b("=====> do not need clean db");
            return;
        }
        cf a = cf.a(this.a);
        ce a2 = ce.a(this.a);
        a.a(a2);
        a2.a(C7616cd.a(context, this.a, 1000));
        cj.a(context).a((cj.AbstractRunnableC7617a) a);
    }
}
