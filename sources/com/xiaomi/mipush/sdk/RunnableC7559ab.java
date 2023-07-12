package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.xiaomi.mipush.sdk.ab */
/* loaded from: classes11.dex */
public class RunnableC7559ab implements Runnable {
    final /* synthetic */ MiTinyDataClient.C7555a.C7556a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7559ab(MiTinyDataClient.C7555a.C7556a c7556a) {
        this.a = c7556a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f33a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f34a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f34a;
            scheduledFuture2.cancel(false);
            this.a.f34a = null;
        }
    }
}
