package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.List;
import tb.jb2;
import tb.mb2;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.l */
/* loaded from: classes9.dex */
public class C2840l implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final String b;
    private final boolean c;
    private final LottieDrawable d;
    private final BaseKeyframeAnimation<?, Path> e;
    private boolean f;
    private final Path a = new Path();
    private C2828b g = new C2828b();

    public C2840l(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a, mb2 mb2Var) {
        this.b = mb2Var.a();
        this.c = mb2Var.c();
        this.d = lottieDrawable;
        BaseKeyframeAnimation<jb2, Path> createAnimation = mb2Var.b().createAnimation();
        this.e = createAnimation;
        abstractC2872a.c(createAnimation);
        createAnimation.a(this);
    }

    private void a() {
        this.f = false;
        this.d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.f) {
            return this.a;
        }
        this.a.reset();
        if (this.c) {
            this.f = true;
            return this.a;
        }
        this.a.set(this.e.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.g.b(this.a);
        this.f = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        a();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof C2842n) {
                C2842n c2842n = (C2842n) content;
                if (c2842n.e() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.g.a(c2842n);
                    c2842n.a(this);
                }
            }
        }
    }
}
