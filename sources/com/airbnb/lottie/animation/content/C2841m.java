package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2847a;
import com.airbnb.lottie.animation.keyframe.C2860n;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import tb.lc1;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.m */
/* loaded from: classes9.dex */
public class C2841m extends AbstractC2825a {
    private final AbstractC2872a o;
    private final String p;
    private final boolean q;
    private final BaseKeyframeAnimation<Integer, Integer> r;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> s;

    public C2841m(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, ShapeStroke shapeStroke) {
        super(lottieDrawable, abstractC2872a, shapeStroke.a().toPaintCap(), shapeStroke.d().toPaintJoin(), shapeStroke.f(), shapeStroke.h(), shapeStroke.i(), shapeStroke.e(), shapeStroke.c());
        this.o = abstractC2872a;
        this.p = shapeStroke.g();
        this.q = shapeStroke.j();
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeStroke.b().createAnimation();
        this.r = createAnimation;
        createAnimation.a(this);
        abstractC2872a.c(createAnimation);
    }

    @Override // com.airbnb.lottie.animation.content.AbstractC2825a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        super.addValueCallback(t, lc1Var);
        if (t == LottieProperty.STROKE_COLOR) {
            this.r.n(lc1Var);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.s;
            if (baseKeyframeAnimation != null) {
                this.o.w(baseKeyframeAnimation);
            }
            if (lc1Var == null) {
                this.s = null;
                return;
            }
            C2860n c2860n = new C2860n(lc1Var);
            this.s = c2860n;
            c2860n.a(this);
            this.o.c(this.r);
        }
    }

    @Override // com.airbnb.lottie.animation.content.AbstractC2825a, com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (this.q) {
            return;
        }
        this.i.setColor(((C2847a) this.r).p());
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.s;
        if (baseKeyframeAnimation != null) {
            this.i.setColorFilter(baseKeyframeAnimation.h());
        }
        super.draw(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.p;
    }
}
