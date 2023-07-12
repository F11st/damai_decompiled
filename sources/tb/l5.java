package tb;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class l5 extends ha<qu0, qu0> {
    public l5(List<u71<qu0>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<qu0, qu0> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.c(this.a);
    }
}
