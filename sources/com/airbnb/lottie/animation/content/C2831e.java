package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2847a;
import com.airbnb.lottie.animation.keyframe.C2860n;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.ArrayList;
import java.util.List;
import tb.eg1;
import tb.f81;
import tb.g81;
import tb.kb2;
import tb.lc1;
import tb.s71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.e */
/* loaded from: classes9.dex */
public class C2831e implements DrawingContent, KeyPathElementContent, BaseKeyframeAnimation.AnimationListener {
    private final Path a;
    private final Paint b;
    private final AbstractC2872a c;
    private final String d;
    private final boolean e;
    private final List<PathContent> f;
    private final BaseKeyframeAnimation<Integer, Integer> g;
    private final BaseKeyframeAnimation<Integer, Integer> h;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> i;
    private final LottieDrawable j;

    public C2831e(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, kb2 kb2Var) {
        Path path = new Path();
        this.a = path;
        this.b = new g81(1);
        this.f = new ArrayList();
        this.c = abstractC2872a;
        this.d = kb2Var.c();
        this.e = kb2Var.e();
        this.j = lottieDrawable;
        if (kb2Var.a() != null && kb2Var.d() != null) {
            path.setFillType(kb2Var.b());
            BaseKeyframeAnimation<Integer, Integer> createAnimation = kb2Var.a().createAnimation();
            this.g = createAnimation;
            createAnimation.a(this);
            abstractC2872a.c(createAnimation);
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = kb2Var.d().createAnimation();
            this.h = createAnimation2;
            createAnimation2.a(this);
            abstractC2872a.c(createAnimation2);
            return;
        }
        this.g = null;
        this.h = null;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        if (t == LottieProperty.COLOR) {
            this.g.n(lc1Var);
        } else if (t == LottieProperty.OPACITY) {
            this.h.n(lc1Var);
        } else if (t == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.i;
            if (baseKeyframeAnimation != null) {
                this.c.w(baseKeyframeAnimation);
            }
            if (lc1Var == null) {
                this.i = null;
                return;
            }
            C2860n c2860n = new C2860n(lc1Var);
            this.i = c2860n;
            c2860n.a(this);
            this.c.c(this.i);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        f81.a("FillContent#draw");
        this.b.setColor(((C2847a) this.g).p());
        this.b.setAlpha(eg1.d((int) ((((i / 255.0f) * this.h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.i;
        if (baseKeyframeAnimation != null) {
            this.b.setColorFilter(baseKeyframeAnimation.h());
        }
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(this.f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        f81.b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.a.addPath(this.f.get(i).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        eg1.m(s71Var, i, list, s71Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content content = list2.get(i);
            if (content instanceof PathContent) {
                this.f.add((PathContent) content);
            }
        }
    }
}
