package com.youku.network;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YKNetwork$1 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ a val$callback;

    YKNetwork$1(b bVar, a aVar) {
        this.this$0 = bVar;
        this.val$callback = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.youku.network.call.b bVar;
        this.this$0.a();
        bVar = this.this$0.d;
        bVar.a(this.val$callback);
    }
}
