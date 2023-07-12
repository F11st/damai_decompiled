package com.meizu.cloud.pushsdk.d.e.a;

import com.meizu.cloud.pushsdk.d.b.a.C6005b;
import com.meizu.cloud.pushsdk.d.c.C6015b;
import com.meizu.cloud.pushsdk.d.e.AbstractC6022a;
import com.meizu.cloud.pushsdk.d.e.C6025b;
import com.meizu.cloud.pushsdk.d.f.C6030c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.e.a.a */
/* loaded from: classes10.dex */
public class C6024a extends AbstractC6022a {
    private static final String n = "a";
    private static ScheduledExecutorService o;

    public C6024a(AbstractC6022a.C6023a c6023a) {
        super(c6023a);
        C6005b.a(this.k);
        c();
    }

    @Override // com.meizu.cloud.pushsdk.d.e.AbstractC6022a
    public void a(final C6015b c6015b, final boolean z) {
        C6005b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.d.e.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                C6024a.super.a(c6015b, z);
            }
        });
    }

    public void c() {
        if (o == null && this.i) {
            C6030c.b(n, "Session checking has been resumed.", new Object[0]);
            final C6025b c6025b = this.d;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            o = newSingleThreadScheduledExecutor;
            Runnable runnable = new Runnable() { // from class: com.meizu.cloud.pushsdk.d.e.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    c6025b.b();
                }
            };
            long j = this.j;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(runnable, j, j, this.l);
        }
    }
}
