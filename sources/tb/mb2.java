package tb;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;

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
    public Content toContent(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.l(lottieDrawable, aVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
