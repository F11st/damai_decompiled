package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class n implements Content, BaseKeyframeAnimation.AnimationListener {
    private final String a;
    private final boolean b;
    private final List<BaseKeyframeAnimation.AnimationListener> c = new ArrayList();
    private final ShapeTrimPath.Type d;
    private final BaseKeyframeAnimation<?, Float> e;
    private final BaseKeyframeAnimation<?, Float> f;
    private final BaseKeyframeAnimation<?, Float> g;

    public n(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.a = shapeTrimPath.b();
        this.b = shapeTrimPath.f();
        this.d = shapeTrimPath.e();
        BaseKeyframeAnimation<Float, Float> createAnimation = shapeTrimPath.d().createAnimation();
        this.e = createAnimation;
        BaseKeyframeAnimation<Float, Float> createAnimation2 = shapeTrimPath.a().createAnimation();
        this.f = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = shapeTrimPath.c().createAnimation();
        this.g = createAnimation3;
        aVar.c(createAnimation);
        aVar.c(createAnimation2);
        aVar.c(createAnimation3);
        createAnimation.a(this);
        createAnimation2.a(this);
        createAnimation3.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.c.add(animationListener);
    }

    public BaseKeyframeAnimation<?, Float> b() {
        return this.f;
    }

    public BaseKeyframeAnimation<?, Float> c() {
        return this.g;
    }

    public BaseKeyframeAnimation<?, Float> d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type e() {
        return this.d;
    }

    public boolean f() {
        return this.b;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).onValueChanged();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }
}
