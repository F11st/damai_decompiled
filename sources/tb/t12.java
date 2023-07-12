package tb;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.C2839k;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.AbstractC2872a;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class t12 implements ContentModel {
    private final String a;
    private final k5 b;
    private final k5 c;
    private final u5 d;
    private final boolean e;

    public t12(String str, k5 k5Var, k5 k5Var2, u5 u5Var, boolean z) {
        this.a = str;
        this.b = k5Var;
        this.c = k5Var2;
        this.d = u5Var;
        this.e = z;
    }

    public k5 a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public k5 c() {
        return this.c;
    }

    public u5 d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a) {
        return new C2839k(lottieDrawable, abstractC2872a, this);
    }
}
