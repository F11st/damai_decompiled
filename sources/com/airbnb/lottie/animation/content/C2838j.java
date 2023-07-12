package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2848b;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.List;
import tb.eg1;
import tb.lc1;
import tb.oz1;
import tb.s71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.j */
/* loaded from: classes9.dex */
public class C2838j implements KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final String c;
    private final boolean d;
    private final LottieDrawable e;
    private final BaseKeyframeAnimation<?, PointF> f;
    private final BaseKeyframeAnimation<?, PointF> g;
    private final BaseKeyframeAnimation<?, Float> h;
    private boolean j;
    private final Path a = new Path();
    private final RectF b = new RectF();
    private C2828b i = new C2828b();

    public C2838j(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, oz1 oz1Var) {
        this.c = oz1Var.b();
        this.d = oz1Var.e();
        this.e = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = oz1Var.c().createAnimation();
        this.f = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = oz1Var.d().createAnimation();
        this.g = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = oz1Var.a().createAnimation();
        this.h = createAnimation3;
        abstractC2872a.c(createAnimation);
        abstractC2872a.c(createAnimation2);
        abstractC2872a.c(createAnimation3);
        createAnimation.a(this);
        createAnimation2.a(this);
        createAnimation3.a(this);
    }

    private void a() {
        this.j = false;
        this.e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        if (t == LottieProperty.RECTANGLE_SIZE) {
            this.g.n(lc1Var);
        } else if (t == LottieProperty.POSITION) {
            this.f.n(lc1Var);
        } else if (t == LottieProperty.CORNER_RADIUS) {
            this.h.n(lc1Var);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.j = true;
            return this.a;
        }
        PointF h = this.g.h();
        float f = h.x / 2.0f;
        float f2 = h.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.h;
        float p = baseKeyframeAnimation == null ? 0.0f : ((C2848b) baseKeyframeAnimation).p();
        float min = Math.min(f, f2);
        if (p > min) {
            p = min;
        }
        PointF h2 = this.f.h();
        this.a.moveTo(h2.x + f, (h2.y - f2) + p);
        this.a.lineTo(h2.x + f, (h2.y + f2) - p);
        int i = (p > 0.0f ? 1 : (p == 0.0f ? 0 : -1));
        if (i > 0) {
            RectF rectF = this.b;
            float f3 = h2.x;
            float f4 = p * 2.0f;
            float f5 = h2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((h2.x - f) + p, h2.y + f2);
        if (i > 0) {
            RectF rectF2 = this.b;
            float f6 = h2.x;
            float f7 = h2.y;
            float f8 = p * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(h2.x - f, (h2.y - f2) + p);
        if (i > 0) {
            RectF rectF3 = this.b;
            float f9 = h2.x;
            float f10 = h2.y;
            float f11 = p * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((h2.x + f) - p, h2.y - f2);
        if (i > 0) {
            RectF rectF4 = this.b;
            float f12 = h2.x;
            float f13 = p * 2.0f;
            float f14 = h2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.b(this.a);
        this.j = true;
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
            if (content instanceof C2842n) {
                C2842n c2842n = (C2842n) content;
                if (c2842n.e() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.i.a(c2842n);
                    c2842n.a(this);
                }
            }
        }
    }
}
