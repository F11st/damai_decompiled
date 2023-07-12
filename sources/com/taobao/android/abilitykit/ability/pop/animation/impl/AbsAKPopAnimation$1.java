package com.taobao.android.abilitykit.ability.pop.animation.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.taobao.android.abilitykit.ability.pop.animation.IAKPopAnimationCallback;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
class AbsAKPopAnimation$1 implements Runnable {
    final /* synthetic */ AbstractC6297a this$0;
    final /* synthetic */ IAKPopAnimationCallback val$callback;
    final /* synthetic */ View val$targetView;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.abilitykit.ability.pop.animation.impl.AbsAKPopAnimation$1$a */
    /* loaded from: classes8.dex */
    class C6296a extends AnimatorListenerAdapter {
        C6296a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            IAKPopAnimationCallback iAKPopAnimationCallback = AbsAKPopAnimation$1.this.val$callback;
            if (iAKPopAnimationCallback != null) {
                iAKPopAnimationCallback.onAnimationFinished();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            AbsAKPopAnimation$1.this.val$targetView.setVisibility(0);
        }
    }

    AbsAKPopAnimation$1(AbstractC6297a abstractC6297a, View view, IAKPopAnimationCallback iAKPopAnimationCallback) {
        this.val$targetView = view;
        this.val$callback = iAKPopAnimationCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractC6297a abstractC6297a = this.this$0;
        AbstractC6297a.b(abstractC6297a, AbstractC6297a.c(abstractC6297a, this.val$targetView));
        AbstractC6297a.a(this.this$0).removeAllListeners();
        AbstractC6297a.a(this.this$0).addListener(new C6296a());
        AbstractC6297a.a(this.this$0).start();
    }
}
