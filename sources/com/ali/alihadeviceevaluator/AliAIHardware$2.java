package com.ali.alihadeviceevaluator;

import tb.m71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
class AliAIHardware$2 implements Runnable {
    final /* synthetic */ C2938a this$0;
    final /* synthetic */ float val$score;

    AliAIHardware$2(C2938a c2938a, float f) {
        this.val$score = f;
    }

    @Override // java.lang.Runnable
    public void run() {
        float f = this.val$score;
        if (f <= 0.0f || f > 100.0f) {
            return;
        }
        C2938a.c(this.this$0, f);
        C2938a c2938a = this.this$0;
        C2938a.e(c2938a, C2938a.b(c2938a));
        C2938a c2938a2 = this.this$0;
        C2938a.f(c2938a2, C2938a.d(c2938a2));
        m71.a().putLong("lasttimestamp", System.currentTimeMillis());
        m71.a().putFloat("score", this.val$score);
        m71.a().commit();
    }
}
