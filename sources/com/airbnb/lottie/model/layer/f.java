package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import tb.g81;
import tb.lc1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class f extends a {
    private final Paint A;
    private final float[] B;
    private final Path C;
    private final Layer D;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> E;
    private final RectF z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.z = new RectF();
        g81 g81Var = new g81();
        this.A = g81Var;
        this.B = new float[8];
        this.C = new Path();
        this.D = layer;
        g81Var.setAlpha(0);
        g81Var.setStyle(Paint.Style.FILL);
        g81Var.setColor(layer.m());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        super.addValueCallback(t, lc1Var);
        if (t == LottieProperty.COLOR_FILTER) {
            if (lc1Var == null) {
                this.E = null;
            } else {
                this.E = new n(lc1Var);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        this.z.set(0.0f, 0.0f, this.D.o(), this.D.n());
        this.m.mapRect(this.z);
        rectF.set(this.z);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void n(Canvas canvas, Matrix matrix, int i) {
        int alpha = Color.alpha(this.D.m());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i / 255.0f) * (((alpha / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
        this.A.setAlpha(intValue);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.E;
        if (baseKeyframeAnimation != null) {
            this.A.setColorFilter(baseKeyframeAnimation.h());
        }
        if (intValue > 0) {
            float[] fArr = this.B;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.D.o();
            float[] fArr2 = this.B;
            fArr2[3] = 0.0f;
            fArr2[4] = this.D.o();
            this.B[5] = this.D.n();
            float[] fArr3 = this.B;
            fArr3[6] = 0.0f;
            fArr3[7] = this.D.n();
            matrix.mapPoints(this.B);
            this.C.reset();
            Path path = this.C;
            float[] fArr4 = this.B;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.C;
            float[] fArr5 = this.B;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.C;
            float[] fArr6 = this.B;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.C;
            float[] fArr7 = this.B;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.C;
            float[] fArr8 = this.B;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.C.close();
            canvas.drawPath(this.C, this.A);
        }
    }
}
