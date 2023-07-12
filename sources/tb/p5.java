package tb;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class p5 extends ha<a62, a62> {
    public p5(List<u71<a62>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<a62, a62> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.i(this.a);
    }
}
