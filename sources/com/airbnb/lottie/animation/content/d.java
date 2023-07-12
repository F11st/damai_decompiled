package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import tb.eg1;
import tb.lc1;
import tb.s71;
import tb.wi;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class d implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final String b;
    private final LottieDrawable c;
    private final BaseKeyframeAnimation<?, PointF> d;
    private final BaseKeyframeAnimation<?, PointF> e;
    private final wi f;
    private boolean h;
    private final Path a = new Path();
    private b g = new b();

    public d(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, wi wiVar) {
        this.b = wiVar.a();
        this.c = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = wiVar.c().createAnimation();
        this.d = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = wiVar.b().createAnimation();
        this.e = createAnimation2;
        this.f = wiVar;
        aVar.c(createAnimation);
        aVar.c(createAnimation2);
        createAnimation.a(this);
        createAnimation2.a(this);
    }

    private void a() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        if (t == LottieProperty.ELLIPSE_SIZE) {
            this.d.n(lc1Var);
        } else if (t == LottieProperty.POSITION) {
            this.e.n(lc1Var);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        if (this.f.d()) {
            this.h = true;
            return this.a;
        }
        PointF h = this.d.h();
        float f = h.x / 2.0f;
        float f2 = h.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.a.reset();
        if (this.f.e()) {
            float f5 = -f2;
            this.a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF h2 = this.e.h();
        this.a.offset(h2.x, h2.y);
        this.a.close();
        this.g.b(this.a);
        this.h = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        eg1.m(s71Var, i, list, s71Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof n) {
                n nVar = (n) content;
                if (nVar.e() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.g.a(nVar);
                    nVar.a(this);
                }
            }
        }
    }
}
