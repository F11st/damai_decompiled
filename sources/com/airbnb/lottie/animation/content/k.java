package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import tb.eg1;
import tb.lc1;
import tb.s71;
import tb.t12;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class k implements DrawingContent, GreedyContent, KeyPathElementContent, PathContent, BaseKeyframeAnimation.AnimationListener {
    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final LottieDrawable c;
    private final com.airbnb.lottie.model.layer.a d;
    private final String e;
    private final boolean f;
    private final BaseKeyframeAnimation<Float, Float> g;
    private final BaseKeyframeAnimation<Float, Float> h;
    private final com.airbnb.lottie.animation.keyframe.m i;
    private c j;

    public k(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, t12 t12Var) {
        this.c = lottieDrawable;
        this.d = aVar;
        this.e = t12Var.b();
        this.f = t12Var.e();
        BaseKeyframeAnimation<Float, Float> createAnimation = t12Var.a().createAnimation();
        this.g = createAnimation;
        aVar.c(createAnimation);
        createAnimation.a(this);
        BaseKeyframeAnimation<Float, Float> createAnimation2 = t12Var.c().createAnimation();
        this.h = createAnimation2;
        aVar.c(createAnimation2);
        createAnimation2.a(this);
        com.airbnb.lottie.animation.keyframe.m a = t12Var.d().a();
        this.i = a;
        a.a(aVar);
        a.b(this);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.j = new c(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        if (this.i.c(t, lc1Var)) {
            return;
        }
        if (t == LottieProperty.REPEATER_COPIES) {
            this.g.n(lc1Var);
        } else if (t == LottieProperty.REPEATER_OFFSET) {
            this.h.n(lc1Var);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.g.h().floatValue();
        float floatValue2 = this.h.h().floatValue();
        float floatValue3 = this.i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.i.e().h().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.i.g(f + floatValue2));
            this.j.draw(canvas, this.a, (int) (i * eg1.k(floatValue3, floatValue4, f / floatValue)));
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.j.getBounds(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.e;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        Path path = this.j.getPath();
        this.b.reset();
        float floatValue = this.g.h().floatValue();
        float floatValue2 = this.h.h().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.g(i + floatValue2));
            this.b.addPath(path, this.a);
        }
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        eg1.m(s71Var, i, list, s71Var2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        this.j.setContents(list, list2);
    }
}
