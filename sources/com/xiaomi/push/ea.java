package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ea implements Runnable {
    final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f291a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f292a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(Context context, String str, int i, String str2) {
        this.f291a = context;
        this.f292a = str;
        this.a = i;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        dz.c(this.f291a, this.f292a, this.a, this.b);
    }
}
