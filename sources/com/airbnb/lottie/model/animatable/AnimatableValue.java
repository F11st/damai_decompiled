package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;
import tb.u71;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface AnimatableValue<K, A> {
    BaseKeyframeAnimation<K, A> createAnimation();

    List<u71<K>> getKeyframes();

    boolean isStatic();
}
