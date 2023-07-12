package tb;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.C2840l;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.AbstractC2872a;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class mb2 implements ContentModel {
    private final String a;
    private final int b;
    private final q5 c;
    private final boolean d;

    public mb2(String str, int i, q5 q5Var, boolean z) {
        this.a = str;
        this.b = i;
        this.c = q5Var;
        this.d = z;
    }

    public String a() {
        return this.a;
    }

    public q5 b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a) {
        return new C2840l(lottieDrawable, abstractC2872a, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
