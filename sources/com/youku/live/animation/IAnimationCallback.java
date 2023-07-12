package com.youku.live.animation;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IAnimationCallback {
    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationError(AnimationError animationError);

    void onAnimationStart();
}
