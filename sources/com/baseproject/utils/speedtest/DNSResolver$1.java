package com.baseproject.utils.speedtest;

import com.baseproject.utils.speedtest.f;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class DNSResolver$1 implements Runnable {
    final /* synthetic */ f.a val$record;

    DNSResolver$1(f.a aVar) {
        this.val$record = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.c(this.val$record);
    }
}
