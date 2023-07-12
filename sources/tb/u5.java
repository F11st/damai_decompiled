package tb;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.ContentModel;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class u5 implements ModifierContent, ContentModel {
    @Nullable
    private final n5 a;
    @Nullable
    private final AnimatableValue<PointF, PointF> b;
    @Nullable
    private final p5 c;
    @Nullable
    private final k5 d;
    @Nullable
    private final m5 e;
    @Nullable
    private final k5 f;
    @Nullable
    private final k5 g;
    @Nullable
    private final k5 h;
    @Nullable
    private final k5 i;

    public u5() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public com.airbnb.lottie.animation.keyframe.m a() {
        return new com.airbnb.lottie.animation.keyframe.m(this);
    }

    @Nullable
    public n5 b() {
        return this.a;
    }

    @Nullable
    public k5 c() {
        return this.i;
    }

    @Nullable
    public m5 d() {
        return this.e;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> e() {
        return this.b;
    }

    @Nullable
    public k5 f() {
        return this.d;
    }

    @Nullable
    public p5 g() {
        return this.c;
    }

    @Nullable
    public k5 h() {
        return this.f;
    }

    @Nullable
    public k5 i() {
        return this.g;
    }

    @Nullable
    public k5 j() {
        return this.h;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    public u5(@Nullable n5 n5Var, @Nullable AnimatableValue<PointF, PointF> animatableValue, @Nullable p5 p5Var, @Nullable k5 k5Var, @Nullable m5 m5Var, @Nullable k5 k5Var2, @Nullable k5 k5Var3, @Nullable k5 k5Var4, @Nullable k5 k5Var5) {
        this.a = n5Var;
        this.b = animatableValue;
        this.c = p5Var;
        this.d = k5Var;
        this.e = m5Var;
        this.h = k5Var2;
        this.i = k5Var3;
        this.f = k5Var4;
        this.g = k5Var5;
    }
}
