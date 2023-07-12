package com.xiaomi.push;

import com.xiaomi.push.ao;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class aq implements Runnable {
    final /* synthetic */ ao.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ao f98a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, ao.b bVar) {
        this.f98a = aoVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f98a.a(this.a);
    }
}
