package tb;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2854h;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class o5 extends AbstractC9212ha<PointF, PointF> {
    public o5(List<u71<PointF>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new C2854h(this.a);
    }
}
