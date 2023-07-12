package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.C2829c;
import java.util.Collections;
import java.util.List;
import tb.lb2;
import tb.s71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.model.layer.e */
/* loaded from: classes9.dex */
public class C2879e extends AbstractC2872a {
    private final C2829c z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2879e(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        C2829c c2829c = new C2829c(lottieDrawable, this, new lb2("__container", layer.l(), false));
        this.z = c2829c;
        c2829c.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.z.getBounds(rectF, this.m, z);
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a
    void n(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.z.draw(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a
    protected void x(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        this.z.resolveKeyPath(s71Var, i, list, s71Var2);
    }
}
