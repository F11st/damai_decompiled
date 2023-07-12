package com.youku.network;

import com.youku.network.call.C7988b;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YKNetwork$1 implements Runnable {
    final /* synthetic */ C7980b this$0;
    final /* synthetic */ InterfaceC7974a val$callback;

    YKNetwork$1(C7980b c7980b, InterfaceC7974a interfaceC7974a) {
        this.this$0 = c7980b;
        this.val$callback = interfaceC7974a;
    }

    @Override // java.lang.Runnable
    public void run() {
        C7988b c7988b;
        this.this$0.a();
        c7988b = this.this$0.d;
        c7988b.a(this.val$callback);
    }
}
