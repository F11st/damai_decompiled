package com.youku.network;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
class YKNetwork$2 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ a val$callback;

    YKNetwork$2(b bVar, a aVar) {
        this.this$0 = bVar;
        this.val$callback = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.youku.network.call.b bVar;
        this.this$0.a();
        bVar = this.this$0.d;
        bVar.b(this.val$callback);
    }
}
