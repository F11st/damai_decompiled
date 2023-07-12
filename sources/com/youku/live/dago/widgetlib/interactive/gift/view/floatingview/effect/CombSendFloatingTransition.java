package com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Path;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.BaseFloatingPathTransition;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingPath;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.PathPosition;
import com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.YumFloating;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CombSendFloatingTransition extends BaseFloatingPathTransition {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DURATION = 1000;
    private static final long END_DURATION = 200;
    private Context mContext;
    private int screenHeight;
    private int screenWidth;
    private int secondPointY;
    private int x;
    private int y;
    private static final int pointX = UIUtil.dip2px(90);
    private static final int pointY = UIUtil.dip2px(162);
    private static final int giftTrackPointX = UIUtil.dip2px(185);

    public CombSendFloatingTransition(Context context, int i, int i2, int i3, boolean z) {
        ((ILog) Dsl.getService(ILog.class)).i("GiftPointReal= ", " y= " + i);
        this.mContext = context;
        if (i == 0) {
            this.x = Math.abs((i2 / 2) - pointX);
            this.y = Math.abs((i3 / 2) - pointY);
        } else {
            int i4 = (i2 - giftTrackPointX) - pointX;
            this.x = z ? Math.abs(i4 - UIUtil.dip2px(40)) : Math.abs(i4);
            this.y = Math.abs(i - (z ? pointY : UIUtil.dip2px(60)));
        }
        this.secondPointY = UIUtil.dip2px(z ? 100 : 200);
    }

    private void doWhenAnimEnd(final YumFloating yumFloating) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1981345616")) {
            ipChange.ipc$dispatch("1981345616", new Object[]{this, yumFloating});
            return;
        }
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.2f, 2.2f);
        ofFloat.setDuration(END_DURATION);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.CombSendFloatingTransition.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-202040803")) {
                    ipChange2.ipc$dispatch("-202040803", new Object[]{this, valueAnimator});
                    return;
                }
                yumFloating.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                yumFloating.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(0.5f, 0.0f);
        ofFloat2.setDuration(END_DURATION);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.CombSendFloatingTransition.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "428417822")) {
                    ipChange2.ipc$dispatch("428417822", new Object[]{this, valueAnimator});
                } else {
                    yumFloating.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.CombSendFloatingTransition.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "140485966")) {
                    ipChange2.ipc$dispatch("140485966", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                yumFloating.getTargetView().clearAnimation();
                yumFloating.clear();
            }
        });
        animatorSet.start();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingTransition
    public void applyFloating(final YumFloating yumFloating) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534289279")) {
            ipChange.ipc$dispatch("1534289279", new Object[]{this, yumFloating});
            return;
        }
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(0.8f, 1.2f);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.CombSendFloatingTransition.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1571091993")) {
                    ipChange2.ipc$dispatch("1571091993", new Object[]{this, valueAnimator});
                    return;
                }
                yumFloating.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                yumFloating.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(1.0f, 0.1f);
        ofFloat2.setDuration(1000L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.CombSendFloatingTransition.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2093416678")) {
                    ipChange2.ipc$dispatch("-2093416678", new Object[]{this, valueAnimator});
                } else {
                    yumFloating.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ValueAnimator ofFloat3 = ObjectAnimator.ofFloat(getStartPathPosition(), getEndPathPosition());
        ofFloat3.setDuration(1000L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.CombSendFloatingTransition.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1462958053")) {
                    ipChange2.ipc$dispatch("-1462958053", new Object[]{this, valueAnimator});
                    return;
                }
                PathPosition floatingPosition = CombSendFloatingTransition.this.getFloatingPosition(((Float) valueAnimator.getAnimatedValue()).floatValue());
                yumFloating.setTranslationX(floatingPosition.x);
                yumFloating.setTranslationY(floatingPosition.y);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.effect.CombSendFloatingTransition.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "163764043")) {
                    ipChange2.ipc$dispatch("163764043", new Object[]{this, animator});
                    return;
                }
                super.onAnimationEnd(animator);
                if (yumFloating.getTargetView() != null) {
                    yumFloating.getTargetView().clearAnimation();
                }
                yumFloating.clear();
            }
        });
        animatorSet.start();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.floatingview.transition.FloatingPathTransition
    public FloatingPath getFloatingPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-196766130")) {
            return (FloatingPath) ipChange.ipc$dispatch("-196766130", new Object[]{this});
        }
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(-UIUtil.dip2px(5), -this.secondPointY, -this.x, -this.y);
        return FloatingPath.create(path, false);
    }
}
