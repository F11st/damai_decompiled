package com.baseproject.utils.speedtest;

import com.baseproject.utils.speedtest.C4669f;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class DNSResolver$1 implements Runnable {
    final /* synthetic */ C4669f.C4670a val$record;

    DNSResolver$1(C4669f.C4670a c4670a) {
        this.val$record = c4670a;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4669f.c(this.val$record);
    }
}
