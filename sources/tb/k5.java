package tb;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class k5 extends ha<Float, Float> {
    k5() {
        super(Float.valueOf(0.0f));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Float, Float> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.b(this.a);
    }

    public k5(List<u71<Float>> list) {
        super((List) list);
    }
}
