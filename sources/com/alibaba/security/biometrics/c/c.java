package com.alibaba.security.biometrics.c;

import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class c {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.c.c$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static class AnonymousClass1 implements Animation.AnimationListener {
        final /* synthetic */ View a;
        final /* synthetic */ Animation.AnimationListener b = null;

        public AnonymousClass1(View view) {
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            this.a.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 11) {
                this.a.setAlpha(1.0f);
            }
            this.a.clearAnimation();
            Animation.AnimationListener animationListener = this.b;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            this.a.setVisibility(0);
        }
    }

    private static void a(View view, Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillBefore(true);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(animationListener);
        view.startAnimation(alphaAnimation);
    }

    private static void a(View view) {
        try {
            if (Build.VERSION.SDK_INT < 11) {
                view.setVisibility(0);
                view.setAlpha(1.0f);
                return;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(view);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillBefore(true);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setAnimationListener(anonymousClass1);
            view.startAnimation(alphaAnimation);
        } catch (Throwable unused) {
        }
    }
}
