package tb;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2857k;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class r5 implements AnimatableValue<PointF, PointF> {
    private final k5 a;
    private final k5 b;

    public r5(k5 k5Var, k5 k5Var2) {
        this.a = k5Var;
        this.b = k5Var2;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new C2857k(this.a.createAnimation(), this.b.createAnimation());
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<u71<PointF>> getKeyframes() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.a.isStatic() && this.b.isStatic();
    }
}
