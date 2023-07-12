package tb;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.C2829c;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class lb2 implements ContentModel {
    private final String a;
    private final List<ContentModel> b;
    private final boolean c;

    public lb2(String str, List<ContentModel> list, boolean z) {
        this.a = str;
        this.b = list;
        this.c = z;
    }

    public List<ContentModel> a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public boolean c() {
        return this.c;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a) {
        return new C2829c(lottieDrawable, abstractC2872a, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
