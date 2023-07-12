package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.C7672hn;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class aa implements Runnable {
    final /* synthetic */ MiTinyDataClient.C7555a.C7556a a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ C7672hn f38a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MiTinyDataClient.C7555a.C7556a c7556a, C7672hn c7672hn) {
        this.a = c7556a;
        this.f38a = c7672hn;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f33a.add(this.f38a);
        this.a.a();
    }
}
