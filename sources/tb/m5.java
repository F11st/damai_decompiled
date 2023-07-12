package tb;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class m5 extends ha<Integer, Integer> {
    public m5(List<u71<Integer>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.d(this.a);
    }
}
