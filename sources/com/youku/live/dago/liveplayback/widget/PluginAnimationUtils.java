package com.youku.live.dago.liveplayback.widget;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PluginAnimationUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int duration = 300;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface AnimationActionListener {
        void onAnimationEnd();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class SimpleAnimationListener implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private PluginAnimationUtils() {
    }

    public static int getDuration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1895715840")) {
            return ((Integer) ipChange.ipc$dispatch("1895715840", new Object[0])).intValue();
        }
        return 300;
    }

    public static void pluginBottomActivityHide(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1370809099")) {
            ipChange.ipc$dispatch("-1370809099", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.8f, 1, 1.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(300L);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.14
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-801146992")) {
                        ipChange2.ipc$dispatch("-801146992", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-349381148")) {
                        ipChange2.ipc$dispatch("-349381148", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1687054057")) {
                        ipChange2.ipc$dispatch("1687054057", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(animationSet);
        }
    }

    public static void pluginBottomActivityShow(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "302994992")) {
            ipChange.ipc$dispatch("302994992", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.8f, 1, 1.0f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setDuration(300L);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setInterpolator(new BounceInterpolator());
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.13
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1494539697")) {
                        ipChange2.ipc$dispatch("-1494539697", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1581237957")) {
                        ipChange2.ipc$dispatch("1581237957", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1056595432")) {
                        ipChange2.ipc$dispatch("1056595432", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(animationSet);
        }
    }

    public static void pluginBottomHide(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622991302")) {
            ipChange.ipc$dispatch("622991302", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-442008274")) {
                        ipChange2.ipc$dispatch("-442008274", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-11367546")) {
                        ipChange2.ipc$dispatch("-11367546", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1072988921")) {
                        ipChange2.ipc$dispatch("-1072988921", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginBottomShow(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1998171903")) {
            ipChange.ipc$dispatch("-1998171903", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "251384431")) {
                        ipChange2.ipc$dispatch("251384431", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1941986651")) {
                        ipChange2.ipc$dispatch("-1941986651", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-442530296")) {
                        ipChange2.ipc$dispatch("-442530296", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginDisappearToFixedPos(final View view, int i, int i2, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274048595")) {
            ipChange.ipc$dispatch("-274048595", new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 0, i, 1, 0.0f, 0, i2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.1f, 1.0f, 0.1f, 1, 0.5f, 1, 0.5f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animationSet.setDuration(500L);
            animationSet.setRepeatCount(0);
            animationSet.setFillAfter(false);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.17
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1279031123")) {
                        ipChange2.ipc$dispatch("1279031123", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1846271167")) {
                        ipChange2.ipc$dispatch("-1846271167", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-716537364")) {
                        ipChange2.ipc$dispatch("-716537364", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(animationSet);
        }
    }

    public static void pluginLeftHide(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "314765026")) {
            ipChange.ipc$dispatch("314765026", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1828793684")) {
                        ipChange2.ipc$dispatch("-1828793684", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-445096632")) {
                        ipChange2.ipc$dispatch("-445096632", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1961061125")) {
                        ipChange2.ipc$dispatch("1961061125", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginLeftShow(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1988569117")) {
            ipChange.ipc$dispatch("1988569117", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1135400979")) {
                        ipChange2.ipc$dispatch("-1135400979", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1919251559")) {
                        ipChange2.ipc$dispatch("1919251559", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1703447546")) {
                        ipChange2.ipc$dispatch("-1703447546", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginPanoramaAdTipHide(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-721745644")) {
            ipChange.ipc$dispatch("-721745644", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 0.0f, 1, 0.5f);
            scaleAnimation.setDuration(300L);
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.12
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2107034894")) {
                        ipChange2.ipc$dispatch("2107034894", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-783110234")) {
                        ipChange2.ipc$dispatch("-783110234", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "426136807")) {
                        ipChange2.ipc$dispatch("426136807", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(scaleAnimation);
        }
    }

    public static void pluginRightHide(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524770771")) {
            ipChange.ipc$dispatch("-1524770771", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1079388202")) {
                        ipChange2.ipc$dispatch("1079388202", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-878825718")) {
                        ipChange2.ipc$dispatch("-878825718", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "700143875")) {
                        ipChange2.ipc$dispatch("700143875", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginRightInteractTextHide(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-712502192")) {
            ipChange.ipc$dispatch("-712502192", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.5f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setDuration(300L);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.16
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "585638418")) {
                        ipChange2.ipc$dispatch("585638418", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "84347938")) {
                        ipChange2.ipc$dispatch("84347938", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1346995989")) {
                        ipChange2.ipc$dispatch("-1346995989", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(animationSet);
        }
    }

    public static void pluginRightInteractTextShow(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961301899")) {
            ipChange.ipc$dispatch("961301899", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.5f);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setDuration(300L);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.15
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-107754287")) {
                        ipChange2.ipc$dispatch("-107754287", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2014967043")) {
                        ipChange2.ipc$dispatch("2014967043", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1977454614")) {
                        ipChange2.ipc$dispatch("-1977454614", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(animationSet);
        }
    }

    public static void pluginRightShow(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "149033320")) {
            ipChange.ipc$dispatch("149033320", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1772780907")) {
                        ipChange2.ipc$dispatch("1772780907", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1485522473")) {
                        ipChange2.ipc$dispatch("1485522473", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1330602500")) {
                        ipChange2.ipc$dispatch("1330602500", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginStartAlpha(final View view, long j, float f, float f2, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722472131")) {
            ipChange.ipc$dispatch("-722472131", new Object[]{view, Long.valueOf(j), Float.valueOf(f), Float.valueOf(f2), animationActionListener});
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.11
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1413642189")) {
                    ipChange2.ipc$dispatch("1413642189", new Object[]{this, animation});
                    return;
                }
                AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                if (animationActionListener2 != null) {
                    animationActionListener2.onAnimationEnd();
                }
                view.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1147508871")) {
                    ipChange2.ipc$dispatch("1147508871", new Object[]{this, animation});
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-204321818")) {
                    ipChange2.ipc$dispatch("-204321818", new Object[]{this, animation});
                }
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static void pluginTipMoveDown(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1969466378")) {
            ipChange.ipc$dispatch("-1969466378", new Object[]{view});
        } else if (view.getAnimation() == null) {
            ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY() + ((RelativeLayout.LayoutParams) view.getLayoutParams()).bottomMargin).setDuration(300L).start();
        }
    }

    public static void pluginTipMoveUp(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1248265967")) {
            ipChange.ipc$dispatch("1248265967", new Object[]{view});
        } else if (view.getAnimation() == null) {
            ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY() - ((RelativeLayout.LayoutParams) view.getLayoutParams()).bottomMargin).setDuration(300L).start();
        }
    }

    public static void pluginTipMoveY(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377888543")) {
            ipChange.ipc$dispatch("-1377888543", new Object[]{view, Float.valueOf(f)});
        } else if (view.getAnimation() == null) {
            ObjectAnimator.ofFloat(view, "translationY", f).setDuration(2000L).start();
        }
    }

    public static void pluginTopHide(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-618375130")) {
            ipChange.ipc$dispatch("-618375130", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.9
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1963404750")) {
                        ipChange2.ipc$dispatch("-1963404750", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "856090626")) {
                        ipChange2.ipc$dispatch("856090626", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1448845579")) {
                        ipChange2.ipc$dispatch("1448845579", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginTopShow(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055428961")) {
            ipChange.ipc$dispatch("1055428961", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.10
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "720249484")) {
                        ipChange2.ipc$dispatch("720249484", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1216839320")) {
                        ipChange2.ipc$dispatch("-1216839320", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-834780443")) {
                        ipChange2.ipc$dispatch("-834780443", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginWebPlayControlHide(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284746704")) {
            ipChange.ipc$dispatch("-284746704", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "944777136")) {
                        ipChange2.ipc$dispatch("944777136", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "422361540")) {
                        ipChange2.ipc$dispatch("422361540", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "187928329")) {
                        ipChange2.ipc$dispatch("187928329", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void pluginWebPlayControlShow(final View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389057387")) {
            ipChange.ipc$dispatch("1389057387", new Object[]{view, animationActionListener});
        } else if (view.getAnimation() == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setRepeatCount(0);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.live.dago.liveplayback.widget.PluginAnimationUtils.8
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1638169841")) {
                        ipChange2.ipc$dispatch("1638169841", new Object[]{this, animation});
                        return;
                    }
                    AnimationActionListener animationActionListener2 = AnimationActionListener.this;
                    if (animationActionListener2 != null) {
                        animationActionListener2.onAnimationEnd();
                    }
                    view.clearAnimation();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1508257565")) {
                        ipChange2.ipc$dispatch("-1508257565", new Object[]{this, animation});
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "818386954")) {
                        ipChange2.ipc$dispatch("818386954", new Object[]{this, animation});
                    }
                }
            });
            view.startAnimation(translateAnimation);
        }
    }

    public static void startAlpha(View view, long j, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314940969")) {
            ipChange.ipc$dispatch("1314940969", new Object[]{view, Long.valueOf(j), Float.valueOf(f), Float.valueOf(f2)});
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    public static void startTranslate(View view, long j, int i, float f, int i2, float f2, int i3, float f3, int i4, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1752637549")) {
            ipChange.ipc$dispatch("1752637549", new Object[]{view, Long.valueOf(j), Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Float.valueOf(f3), Integer.valueOf(i4), Float.valueOf(f4)});
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(i, f, i2, f2, i3, f3, i4, f4);
        translateAnimation.setDuration(j);
        animationSet.addAnimation(translateAnimation);
        view.startAnimation(animationSet);
    }

    public static void pluginTipMoveY(View view, float f, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "235158531")) {
            ipChange.ipc$dispatch("235158531", new Object[]{view, Float.valueOf(f), Long.valueOf(j)});
        } else if (view.getAnimation() == null) {
            ObjectAnimator.ofFloat(view, "translationY", f).setDuration(j).start();
        }
    }
}
