package com.google.common.util.concurrent;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class JdkFutureAdapters$ListenableFutureAdapter$1 implements Runnable {
    final /* synthetic */ l this$0;

    JdkFutureAdapters$ListenableFutureAdapter$1(l lVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            q.a(l.b(this.this$0));
        } catch (Throwable unused) {
        }
        l.c(this.this$0).b();
    }
}
