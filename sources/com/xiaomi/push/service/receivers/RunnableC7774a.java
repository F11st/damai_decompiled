package com.xiaomi.push.service.receivers;

import android.content.Context;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.service.receivers.a */
/* loaded from: classes11.dex */
class RunnableC7774a implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f993a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7774a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f993a = networkStatusReceiver;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f993a.a(this.a);
    }
}
