package com.youku.live.dago.widgetlib.interactive.gift.lottery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.view.OtherPersonLotteryGiftView;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.view.OtherPersonLotteryTextView;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LotteryGiftOtherPersonViewController {
    private static transient /* synthetic */ IpChange $ipChange;

    private Animator getAppearingAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-73132337")) {
            return (Animator) ipChange.ipc$dispatch("-73132337", new Object[]{this});
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat((Object) null, "ScaleX", 2.0f, 1.0f), ObjectAnimator.ofFloat((Object) null, "ScaleY", 2.0f, 1.0f), ObjectAnimator.ofFloat((Object) null, "Alpha", 0.0f, 1.0f));
        return animatorSet;
    }

    private Animator getDisappearingAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119425897")) {
            return (Animator) ipChange.ipc$dispatch("1119425897", new Object[]{this});
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat((Object) null, "ScaleX", 1.0f, 0.0f), ObjectAnimator.ofFloat((Object) null, "ScaleY", 1.0f, 0.0f), ObjectAnimator.ofFloat((Object) null, "Alpha", 1.0f, 0.0f));
        return animatorSet;
    }

    private Animator getHolderAnimation(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1376048072") ? (Animator) ipChange.ipc$dispatch("-1376048072", new Object[]{this, view}) : ObjectAnimator.ofFloat(view, "Alpha", 1.0f, 1.0f);
    }

    public void addLargeLotteryView(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840563908")) {
            ipChange.ipc$dispatch("-1840563908", new Object[]{this, viewGroup});
        }
    }

    public void addSmallLotteryView(Context context, ViewGroup viewGroup, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48310466")) {
            ipChange.ipc$dispatch("-48310466", new Object[]{this, context, viewGroup, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "addSmallLotteryView " + i + "    count = " + i2);
        if (i == 500 && (viewGroup instanceof RelativeLayout)) {
            final RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.lottery_info_container);
            if (relativeLayout.getChildCount() != 0) {
                relativeLayout.removeAllViews();
            }
            ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "new LayoutTransition()");
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.setAnimator(2, getAppearingAnimation());
            layoutTransition.setDuration(2, 250L);
            layoutTransition.setStartDelay(2, 0L);
            layoutTransition.setAnimator(3, getDisappearingAnimation());
            layoutTransition.setDuration(3, 250L);
            layoutTransition.setStartDelay(3, 0L);
            if (i == 10 || i == 100) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DensityUtil.dip2px(context, 125.0f), DensityUtil.dip2px(context, 20.0f));
                layoutParams.topMargin = DensityUtil.dip2px(context, 40.0f);
                layoutParams.leftMargin = DensityUtil.dip2px(context, 12.0f);
                OtherPersonLotteryTextView otherPersonLotteryTextView = new OtherPersonLotteryTextView(context);
                otherPersonLotteryTextView.setId(R.id.lottery_other_person_view);
                relativeLayout.setLayoutTransition(layoutTransition);
                relativeLayout.addView(otherPersonLotteryTextView, layoutParams);
                otherPersonLotteryTextView.display(i, i2);
            } else if (i == 500) {
                ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "显示动画特效");
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DensityUtil.dip2px(context, 100.0f), DensityUtil.dip2px(context, 100.0f));
                OtherPersonLotteryGiftView otherPersonLotteryGiftView = new OtherPersonLotteryGiftView(context);
                otherPersonLotteryGiftView.setId(R.id.lottery_other_person_view);
                relativeLayout.setLayoutTransition(layoutTransition);
                relativeLayout.addView(otherPersonLotteryGiftView, layoutParams2);
                otherPersonLotteryGiftView.displayEffect(i, i2);
            }
            Animator holderAnimation = getHolderAnimation(relativeLayout);
            ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "getHolderAnimation");
            holderAnimation.setDuration(3000L);
            holderAnimation.addListener(new AnimatorListenerAdapter() { // from class: com.youku.live.dago.widgetlib.interactive.gift.lottery.LotteryGiftOtherPersonViewController.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1314162957")) {
                        ipChange2.ipc$dispatch("1314162957", new Object[]{this, animator});
                        return;
                    }
                    RelativeLayout relativeLayout2 = relativeLayout;
                    if (relativeLayout2 == null || relativeLayout2.getChildCount() == 0) {
                        return;
                    }
                    relativeLayout.removeAllViews();
                }
            });
            holderAnimation.start();
        }
    }

    public void removeGiftView(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1536123937")) {
            ipChange.ipc$dispatch("-1536123937", new Object[]{this, viewGroup});
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.lottery_info_container);
        if (relativeLayout.getChildCount() != 0) {
            relativeLayout.removeAllViews();
        }
    }
}
