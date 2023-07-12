package com.youku.live.animation;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface IAnimationView {
    void cancel();

    void play(AnimationFileType animationFileType, String str);

    void setAnimationCallback(IAnimationCallback iAnimationCallback);
}
