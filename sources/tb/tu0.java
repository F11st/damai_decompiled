package tb;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.GradientType;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class tu0 implements ContentModel {
    private final GradientType a;
    private final Path.FillType b;
    private final l5 c;
    private final m5 d;
    private final o5 e;
    private final o5 f;
    private final String g;
    private final boolean h;

    public tu0(String str, GradientType gradientType, Path.FillType fillType, l5 l5Var, m5 m5Var, o5 o5Var, o5 o5Var2, k5 k5Var, k5 k5Var2, boolean z) {
        this.a = gradientType;
        this.b = fillType;
        this.c = l5Var;
        this.d = m5Var;
        this.e = o5Var;
        this.f = o5Var2;
        this.g = str;
        this.h = z;
    }

    public o5 a() {
        return this.f;
    }

    public Path.FillType b() {
        return this.b;
    }

    public l5 c() {
        return this.c;
    }

    public GradientType d() {
        return this.a;
    }

    public String e() {
        return this.g;
    }

    public m5 f() {
        return this.d;
    }

    public o5 g() {
        return this.e;
    }

    public boolean h() {
        return this.h;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.f(lottieDrawable, aVar, this);
    }
}
