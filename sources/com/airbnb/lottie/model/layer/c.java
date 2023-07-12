package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import tb.aw2;
import tb.g81;
import tb.lc1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class c extends a {
    private final Rect A;
    private final Rect B;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> C;
    private final Paint z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.z = new g81(3);
        this.A = new Rect();
        this.B = new Rect();
    }

    @Nullable
    private Bitmap E() {
        return this.n.getImageAsset(this.o.k());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        super.addValueCallback(t, lc1Var);
        if (t == LottieProperty.COLOR_FILTER) {
            if (lc1Var == null) {
                this.C = null;
            } else {
                this.C = new n(lc1Var);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        Bitmap E = E();
        if (E != null) {
            rectF.set(0.0f, 0.0f, E.getWidth() * aw2.e(), E.getHeight() * aw2.e());
            this.m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void n(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap E = E();
        if (E == null || E.isRecycled()) {
            return;
        }
        float e = aw2.e();
        this.z.setAlpha(i);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.C;
        if (baseKeyframeAnimation != null) {
            this.z.setColorFilter(baseKeyframeAnimation.h());
        }
        canvas.save();
        canvas.concat(matrix);
        this.A.set(0, 0, E.getWidth(), E.getHeight());
        this.B.set(0, 0, (int) (E.getWidth() * e), (int) (E.getHeight() * e));
        canvas.drawBitmap(E, this.A, this.B, this.z);
        canvas.restore();
    }
}
