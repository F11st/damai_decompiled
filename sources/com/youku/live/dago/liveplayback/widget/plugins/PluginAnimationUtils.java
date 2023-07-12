package com.youku.live.dago.liveplayback.widget.plugins;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;

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

    private PluginAnimationUtils() {
    }

    public static int getDuration() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951517487")) {
            return ((Integer) ipChange.ipc$dispatch("-951517487", new Object[0])).intValue();
        }
        return 300;
    }

    public static void pluginBottomHide(View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877667480")) {
            ipChange.ipc$dispatch("-877667480", new Object[]{view, animationActionListener});
        } else if (view.getParent() != null) {
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Constants.Name.Y, ((ViewGroup) view.getParent()).getHeight()).setDuration(300L);
            if (animationActionListener != null) {
                duration2.addListener(new Animator.AnimatorListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1246403207")) {
                            ipChange2.ipc$dispatch("-1246403207", new Object[]{this, animator});
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-638750634")) {
                            ipChange2.ipc$dispatch("-638750634", new Object[]{this, animator});
                        } else {
                            AnimationActionListener.this.onAnimationEnd();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1067172408")) {
                            ipChange2.ipc$dispatch("1067172408", new Object[]{this, animator});
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1103437777")) {
                            ipChange2.ipc$dispatch("-1103437777", new Object[]{this, animator});
                        }
                    }
                });
            }
            duration2.start();
        }
    }

    public static void pluginBottomShow(View view, final AnimationActionListener animationActionListener, float... fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518555310")) {
            ipChange.ipc$dispatch("1518555310", new Object[]{view, animationActionListener, fArr});
            return;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Constants.Name.Y, fArr).setDuration(300L);
        if (animationActionListener != null) {
            duration2.addListener(new Animator.AnimatorListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-477233192")) {
                        ipChange2.ipc$dispatch("-477233192", new Object[]{this, animator});
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-646509993")) {
                        ipChange2.ipc$dispatch("-646509993", new Object[]{this, animator});
                    } else {
                        AnimationActionListener.this.onAnimationEnd();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1836342423")) {
                        ipChange2.ipc$dispatch("1836342423", new Object[]{this, animator});
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "29752816")) {
                        ipChange2.ipc$dispatch("29752816", new Object[]{this, animator});
                    }
                }
            });
        }
        duration2.start();
    }

    public static void pluginTopHide(View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245310790")) {
            ipChange.ipc$dispatch("245310790", new Object[]{view, animationActionListener});
            return;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Constants.Name.Y, -view.getHeight()).setDuration(300L);
        if (animationActionListener != null) {
            duration2.addListener(new Animator.AnimatorListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "291936823")) {
                        ipChange2.ipc$dispatch("291936823", new Object[]{this, animator});
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-654269352")) {
                        ipChange2.ipc$dispatch("-654269352", new Object[]{this, animator});
                    } else {
                        AnimationActionListener.this.onAnimationEnd();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1689454858")) {
                        ipChange2.ipc$dispatch("-1689454858", new Object[]{this, animator});
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1162943409")) {
                        ipChange2.ipc$dispatch("1162943409", new Object[]{this, animator});
                    }
                }
            });
        }
        duration2.start();
    }

    public static void pluginTopShow(View view, final AnimationActionListener animationActionListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-689966207")) {
            ipChange.ipc$dispatch("-689966207", new Object[]{view, animationActionListener});
            return;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, Constants.Name.Y, 0.0f).setDuration(300L);
        if (animationActionListener != null) {
            duration2.addListener(new Animator.AnimatorListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.PluginAnimationUtils.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1061106838")) {
                        ipChange2.ipc$dispatch("1061106838", new Object[]{this, animator});
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-662028711")) {
                        ipChange2.ipc$dispatch("-662028711", new Object[]{this, animator});
                    } else {
                        AnimationActionListener.this.onAnimationEnd();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-920284843")) {
                        ipChange2.ipc$dispatch("-920284843", new Object[]{this, animator});
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1998833294")) {
                        ipChange2.ipc$dispatch("-1998833294", new Object[]{this, animator});
                    }
                }
            });
        }
        duration2.start();
    }
}
