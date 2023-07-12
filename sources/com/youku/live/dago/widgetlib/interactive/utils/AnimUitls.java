package com.youku.live.dago.widgetlib.interactive.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AnimUitls {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void startAppearAnimBottom(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215652678")) {
            ipChange.ipc$dispatch("-215652678", new Object[]{view});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(250L);
        view.startAnimation(translateAnimation);
        view.setVisibility(0);
    }

    public static void startAppearAnimRight(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-192632185")) {
            ipChange.ipc$dispatch("-192632185", new Object[]{view});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(250L);
        view.startAnimation(translateAnimation);
        view.setVisibility(0);
    }

    public static void startDisappearAnimBottom(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942832912")) {
            ipChange.ipc$dispatch("-942832912", new Object[]{view});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.utils.AnimUitls.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1245810166")) {
                    ipChange2.ipc$dispatch("1245810166", new Object[]{this, animation});
                } else {
                    view.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "605644222")) {
                    ipChange2.ipc$dispatch("605644222", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1717861327")) {
                    ipChange2.ipc$dispatch("1717861327", new Object[]{this, animation});
                }
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static void startDisappearAnimRight(final View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753741713")) {
            ipChange.ipc$dispatch("753741713", new Object[]{view});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(250L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.utils.AnimUitls.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1939202871")) {
                    ipChange2.ipc$dispatch("1939202871", new Object[]{this, animation});
                } else {
                    view.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1324974883")) {
                    ipChange2.ipc$dispatch("-1324974883", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1946647344")) {
                    ipChange2.ipc$dispatch("-1946647344", new Object[]{this, animation});
                }
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static void switchGiftBoardView(final View view, final View view2, final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546940304")) {
            ipChange.ipc$dispatch("-1546940304", new Object[]{view, view2, Boolean.valueOf(z)});
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.utils.AnimUitls.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1662371720")) {
                    ipChange2.ipc$dispatch("-1662371720", new Object[]{this, animation});
                    return;
                }
                view2.setVisibility(8);
                if (z) {
                    AnimUitls.startAppearAnimRight(view);
                } else {
                    AnimUitls.startAppearAnimBottom(view);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1039373308")) {
                    ipChange2.ipc$dispatch("1039373308", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1316188719")) {
                    ipChange2.ipc$dispatch("-1316188719", new Object[]{this, animation});
                }
            }
        });
        view2.startAnimation(translateAnimation);
    }

    public static void switchKeyBoardView(final View view, final View view2, boolean z) {
        TranslateAnimation translateAnimation;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688371317")) {
            ipChange.ipc$dispatch("1688371317", new Object[]{view, view2, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        }
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.widgetlib.interactive.utils.AnimUitls.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-968979015")) {
                    ipChange2.ipc$dispatch("-968979015", new Object[]{this, animation});
                    return;
                }
                view2.setVisibility(8);
                AnimUitls.startAppearAnimBottom(view);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-891245797")) {
                    ipChange2.ipc$dispatch("-891245797", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-685730094")) {
                    ipChange2.ipc$dispatch("-685730094", new Object[]{this, animation});
                }
            }
        });
        view2.startAnimation(translateAnimation);
    }
}
