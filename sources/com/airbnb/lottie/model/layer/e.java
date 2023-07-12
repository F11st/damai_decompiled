package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import java.util.Collections;
import java.util.List;
import tb.lb2;
import tb.s71;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class e extends a {
    private final com.airbnb.lottie.animation.content.c z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        com.airbnb.lottie.animation.content.c cVar = new com.airbnb.lottie.animation.content.c(lottieDrawable, this, new lb2("__container", layer.l(), false));
        this.z = cVar;
        cVar.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.z.getBounds(rectF, this.m, z);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void n(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.z.draw(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void x(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        this.z.resolveKeyPath(s71Var, i, list, s71Var2);
    }
}
