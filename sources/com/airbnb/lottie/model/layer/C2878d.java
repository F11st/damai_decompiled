package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.model.layer.d */
/* loaded from: classes9.dex */
public class C2878d extends AbstractC2872a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C2878d(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a
    void n(Canvas canvas, Matrix matrix, int i) {
    }
}
