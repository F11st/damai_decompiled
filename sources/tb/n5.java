package tb;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class n5 implements AnimatableValue<PointF, PointF> {
    private final List<u71<PointF>> a;

    public n5(List<u71<PointF>> list) {
        this.a = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        if (this.a.get(0).h()) {
            return new com.airbnb.lottie.animation.keyframe.h(this.a);
        }
        return new com.airbnb.lottie.animation.keyframe.g(this.a);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<u71<PointF>> getKeyframes() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.a.size() == 1 && this.a.get(0).h();
    }
}
