package tb;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ContentModel;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class kb2 implements ContentModel {
    private final boolean a;
    private final Path.FillType b;
    private final String c;
    @Nullable
    private final j5 d;
    @Nullable
    private final m5 e;
    private final boolean f;

    public kb2(String str, boolean z, Path.FillType fillType, @Nullable j5 j5Var, @Nullable m5 m5Var, boolean z2) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = j5Var;
        this.e = m5Var;
        this.f = z2;
    }

    @Nullable
    public j5 a() {
        return this.d;
    }

    public Path.FillType b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @Nullable
    public m5 d() {
        return this.e;
    }

    public boolean e() {
        return this.f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.animation.content.e(lottieDrawable, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
