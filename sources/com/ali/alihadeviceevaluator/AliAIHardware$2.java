package com.ali.alihadeviceevaluator;

import tb.m71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
class AliAIHardware$2 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ float val$score;

    AliAIHardware$2(a aVar, float f) {
        this.val$score = f;
    }

    @Override // java.lang.Runnable
    public void run() {
        float f = this.val$score;
        if (f <= 0.0f || f > 100.0f) {
            return;
        }
        a.c(this.this$0, f);
        a aVar = this.this$0;
        a.e(aVar, a.b(aVar));
        a aVar2 = this.this$0;
        a.f(aVar2, a.d(aVar2));
        m71.a().putLong("lasttimestamp", System.currentTimeMillis());
        m71.a().putFloat("score", this.val$score);
        m71.a().commit();
    }
}
