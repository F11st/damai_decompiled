package tb;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class wi implements ContentModel {
    private final String a;
    private final AnimatableValue<PointF, PointF> b;
    private final o5 c;
    private final boolean d;
    private final boolean e;

    public wi(String str, AnimatableValue<PointF, PointF> animatableValue, o5 o5Var, boolean z, boolean z2) {
        this.a = str;
        this.b = animatableValue;
        this.c = o5Var;
        this.d = z;
        this.e = z2;
    }

    public String a() {
        return this.a;
    }

    public AnimatableValue<PointF, PointF> b() {
        return this.b;
    }

    public o5 c() {
        return this.c;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.d(lottieDrawable, aVar, this);
    }
}
