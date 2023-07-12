package com.xiaomi.mipush.sdk;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class z implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.c(this.a);
    }
}
