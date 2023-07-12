package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class y implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f81a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context, Intent intent) {
        this.a = context;
        this.f81a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.startService(this.f81a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a(e.getMessage());
        }
    }
}
