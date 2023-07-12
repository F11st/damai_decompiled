package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2859m;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.ArrayList;
import java.util.List;
import tb.aw2;
import tb.g81;
import tb.lb2;
import tb.lc1;
import tb.s71;
import tb.u5;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.c */
/* loaded from: classes9.dex */
public class C2829c implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private Paint a;
    private RectF b;
    private final Matrix c;
    private final Path d;
    private final RectF e;
    private final String f;
    private final boolean g;
    private final List<Content> h;
    private final LottieDrawable i;
    @Nullable
    private List<PathContent> j;
    @Nullable
    private C2859m k;

    public C2829c(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, lb2 lb2Var) {
        this(lottieDrawable, abstractC2872a, lb2Var.b(), lb2Var.c(), a(lottieDrawable, abstractC2872a, lb2Var.a()), b(lb2Var.a()));
    }

    private static List<Content> a(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i).toContent(lottieDrawable, abstractC2872a);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    @Nullable
    static u5 b(List<ContentModel> list) {
        for (int i = 0; i < list.size(); i++) {
            ContentModel contentModel = list.get(i);
            if (contentModel instanceof u5) {
                return (u5) contentModel;
            }
        }
        return null;
    }

    private boolean e() {
        int i = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            if ((this.h.get(i2) instanceof DrawingContent) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        C2859m c2859m = this.k;
        if (c2859m != null) {
            c2859m.c(t, lc1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<PathContent> c() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i = 0; i < this.h.size(); i++) {
                Content content = this.h.get(i);
                if (content instanceof PathContent) {
                    this.j.add((PathContent) content);
                }
            }
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix d() {
        C2859m c2859m = this.k;
        if (c2859m != null) {
            return c2859m.f();
        }
        this.c.reset();
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        C2859m c2859m = this.k;
        if (c2859m != null) {
            this.c.preConcat(c2859m.f());
            i = (int) (((((this.k.h() == null ? 100 : this.k.h().h().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.i.isApplyingOpacityToLayersEnabled() && e() && i != 255;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            getBounds(this.b, this.c, true);
            this.a.setAlpha(i);
            aw2.m(canvas, this.b, this.a);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content content = this.h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).draw(canvas, this.c, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.c.set(matrix);
        C2859m c2859m = this.k;
        if (c2859m != null) {
            this.c.preConcat(c2859m.f());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content content = this.h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.e, this.c, z);
                rectF.union(this.e);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.c.reset();
        C2859m c2859m = this.k;
        if (c2859m != null) {
            this.c.set(c2859m.f());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content content = this.h.get(size);
            if (content instanceof PathContent) {
                this.d.addPath(((PathContent) content).getPath(), this.c);
            }
        }
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        if (s71Var.g(getName(), i) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                s71Var2 = s71Var2.a(getName());
                if (s71Var.c(getName(), i)) {
                    list.add(s71Var2.i(this));
                }
            }
            if (s71Var.h(getName(), i)) {
                int e = i + s71Var.e(getName(), i);
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    Content content = this.h.get(i2);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(s71Var, e, list, s71Var2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.h.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            Content content = this.h.get(size);
            content.setContents(arrayList, this.h.subList(0, size));
            arrayList.add(content);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2829c(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, String str, boolean z, List<Content> list, @Nullable u5 u5Var) {
        this.a = new g81();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = lottieDrawable;
        this.g = z;
        this.h = list;
        if (u5Var != null) {
            C2859m a = u5Var.a();
            this.k = a;
            a.a(abstractC2872a);
            this.k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }
}
