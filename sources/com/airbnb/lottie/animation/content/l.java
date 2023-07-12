package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;
import tb.jb2;
import tb.mb2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class l implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final String b;
    private final boolean c;
    private final LottieDrawable d;
    private final BaseKeyframeAnimation<?, Path> e;
    private boolean f;
    private final Path a = new Path();
    private b g = new b();

    public l(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, mb2 mb2Var) {
        this.b = mb2Var.a();
        this.c = mb2Var.c();
        this.d = lottieDrawable;
        BaseKeyframeAnimation<jb2, Path> createAnimation = mb2Var.b().createAnimation();
        this.e = createAnimation;
        aVar.c(createAnimation);
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
