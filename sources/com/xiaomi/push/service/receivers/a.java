package com.xiaomi.push.service.receivers;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class a implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f993a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f993a = networkStatusReceiver;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f993a.a(this.a);
    }
}
