package com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.BaseFloatingPathTransition;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingPath;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.PathPosition;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.YumFloating;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftFloatingTrastion extends BaseFloatingPathTransition {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean disappear = false;

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingTransition
    public void applyFloating(final YumFloating yumFloating) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083015307")) {
            ipChange.ipc$dispatch("-1083015307", new Object[]{this, yumFloating});
        } else if (yumFloating == null) {
        } else {
            ValueAnimator ofFloat = ObjectAnimator.ofFloat(getStartPathPosition(), getEndPathPosition());
            final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(yumFloating.getTargetView(), "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ofFloat.setDuration(1500L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.GiftFloatingTrastion.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1980556913")) {
                        ipChange2.ipc$dispatch("-1980556913", new Object[]{this, valueAnimator});
                        return;
                    }
                    PathPosition floatingPosition = GiftFloatingTrastion.this.getFloatingPosition(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (!GiftFloatingTrastion.this.disappear && floatingPosition.y < -420.0f) {
                        GiftFloatingTrastion.this.disappear = true;
                        ofFloat2.start();
                    }
                    yumFloating.setTranslationX(floatingPosition.x);
                    yumFloating.setTranslationY(floatingPosition.y);
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.GiftFloatingTrastion.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1249615039")) {
                        ipChange2.ipc$dispatch("1249615039", new Object[]{this, animator});
                        return;
                    }
                    if (yumFloating.getTargetView() != null) {
                        yumFloating.getTargetView().clearAnimation();
                    }
                    yumFloating.clear();
                }
            });
            ValueAnimator ofFloat3 = ObjectAnimator.ofFloat(0.0f, 1.0f);
            ofFloat3.setDuration(500L);
            ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.GiftFloatingTrastion.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-719639663")) {
                        ipChange2.ipc$dispatch("-719639663", new Object[]{this, valueAnimator});
                        return;
                    }
                    yumFloating.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    yumFloating.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat3.start();
            ofFloat.start();
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingPathTransition
    public FloatingPath getFloatingPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424362180")) {
            return (FloatingPath) ipChange.ipc$dispatch("1424362180", new Object[]{this});
        }
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(-50.0f, -100.0f, 0.0f, -190.0f);
        path.quadTo(100.0f, -310.0f, 0.0f, -470.0f);
        return FloatingPath.create(path, false);
    }
}
