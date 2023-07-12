package com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingTransition;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.YumFloating;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ScaleFloatingTransition implements FloatingTransition {
    private static transient /* synthetic */ IpChange $ipChange;
    private double mBounciness;
    private long mDuration;
    private double mSpeed;

    public ScaleFloatingTransition() {
        this.mDuration = 1000L;
        this.mBounciness = 10.0d;
        this.mSpeed = 15.0d;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingTransition
    public void applyFloating(final YumFloating yumFloating) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971118386")) {
            ipChange.ipc$dispatch("971118386", new Object[]{this, yumFloating});
            return;
        }
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(this.mDuration);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.ScaleFloatingTransition.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "336743052")) {
                    ipChange2.ipc$dispatch("336743052", new Object[]{this, valueAnimator});
                } else {
                    yumFloating.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
    }

    public ScaleFloatingTransition(long j) {
        this.mDuration = j;
        this.mBounciness = 10.0d;
        this.mSpeed = 15.0d;
    }

    public ScaleFloatingTransition(long j, double d, double d2) {
        this.mDuration = j;
        this.mBounciness = d;
        this.mSpeed = d2;
    }
}
