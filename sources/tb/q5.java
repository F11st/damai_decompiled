package tb;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class q5 extends ha<jb2, Path> {
    public q5(List<u71<jb2>> list) {
        super((List) list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<jb2, Path> createAnimation() {
        return new com.airbnb.lottie.animation.keyframe.j(this.a);
    }
}
