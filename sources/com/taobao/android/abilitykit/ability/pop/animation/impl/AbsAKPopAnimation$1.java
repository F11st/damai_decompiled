package com.taobao.android.abilitykit.ability.pop.animation.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.taobao.android.abilitykit.ability.pop.animation.IAKPopAnimationCallback;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
class AbsAKPopAnimation$1 implements Runnable {
    final /* synthetic */ com.taobao.android.abilitykit.ability.pop.animation.impl.a this$0;
    final /* synthetic */ IAKPopAnimationCallback val$callback;
    final /* synthetic */ View val$targetView;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class a extends AnimatorListenerAdapter {
        a() {
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

    AbsAKPopAnimation$1(com.taobao.android.abilitykit.ability.pop.animation.impl.a aVar, View view, IAKPopAnimationCallback iAKPopAnimationCallback) {
        this.val$targetView = view;
        this.val$callback = iAKPopAnimationCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.taobao.android.abilitykit.ability.pop.animation.impl.a aVar = this.this$0;
        com.taobao.android.abilitykit.ability.pop.animation.impl.a.b(aVar, com.taobao.android.abilitykit.ability.pop.animation.impl.a.c(aVar, this.val$targetView));
        com.taobao.android.abilitykit.ability.pop.animation.impl.a.a(this.this$0).removeAllListeners();
        com.taobao.android.abilitykit.ability.pop.animation.impl.a.a(this.this$0).addListener(new a());
        com.taobao.android.abilitykit.ability.pop.animation.impl.a.a(this.this$0).start();
    }
}
