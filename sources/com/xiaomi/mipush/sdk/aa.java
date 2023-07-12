package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hn;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class aa implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0358a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hn f38a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MiTinyDataClient.a.C0358a c0358a, hn hnVar) {
        this.a = c0358a;
        this.f38a = hnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f33a.add(this.f38a);
        this.a.a();
    }
}
