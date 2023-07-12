package com.google.common.util.concurrent;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class JdkFutureAdapters$ListenableFutureAdapter$1 implements Runnable {
    final /* synthetic */ C5357l this$0;

    JdkFutureAdapters$ListenableFutureAdapter$1(C5357l c5357l) {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C5363q.a(C5357l.b(this.this$0));
        } catch (Throwable unused) {
        }
        C5357l.c(this.this$0).b();
    }
}
