package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;
import tb.aw2;
import tb.f81;
import tb.k5;
import tb.lc1;
import tb.s71;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class b extends com.airbnb.lottie.model.layer.a {
    private final List<com.airbnb.lottie.model.layer.a> A;
    private final RectF B;
    private final RectF C;
    private Paint D;
    @Nullable
    private Boolean E;
    @Nullable
    private Boolean F;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> z;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, com.airbnb.lottie.a aVar) {
        super(lottieDrawable, layer);
        int i;
        com.airbnb.lottie.model.layer.a aVar2;
        this.A = new ArrayList();
        this.B = new RectF();
        this.C = new RectF();
        this.D = new Paint();
        k5 s = layer.s();
        if (s != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = s.createAnimation();
            this.z = createAnimation;
            c(createAnimation);
            this.z.a(this);
        } else {
            this.z = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(aVar.j().size());
        int size = list.size() - 1;
        com.airbnb.lottie.model.layer.a aVar3 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            com.airbnb.lottie.model.layer.a o = com.airbnb.lottie.model.layer.a.o(layer2, lottieDrawable, aVar);
            if (o != null) {
                longSparseArray.put(o.p().b(), o);
                if (aVar3 != null) {
                    aVar3.y(o);
                    aVar3 = null;
                } else {
                    this.A.add(0, o);
                    int i2 = a.a[layer2.f().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar3 = o;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            com.airbnb.lottie.model.layer.a aVar4 = (com.airbnb.lottie.model.layer.a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar4 != null && (aVar2 = (com.airbnb.lottie.model.layer.a) longSparseArray.get(aVar4.p().h())) != null) {
                aVar4.A(aVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void B(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.B(f);
        if (this.z != null) {
            f = ((this.z.h().floatValue() * this.o.a().h()) - this.o.a().o()) / (this.n.getComposition().e() + 0.01f);
        }
        if (this.z == null) {
            f -= this.o.p();
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.A.get(size).B(f);
        }
    }

    public boolean E() {
        if (this.F == null) {
            for (int size = this.A.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.layer.a aVar = this.A.get(size);
                if (aVar instanceof e) {
                    if (aVar.q()) {
                        this.F = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).E()) {
                    this.F = Boolean.TRUE;
                    return true;
                }
            }
            this.F = Boolean.FALSE;
        }
        return this.F.booleanValue();
    }

    public boolean F() {
        if (this.E == null) {
            if (r()) {
                this.E = Boolean.TRUE;
                return true;
            }
            for (int size = this.A.size() - 1; size >= 0; size--) {
                if (this.A.get(size).r()) {
                    this.E = Boolean.TRUE;
                    return true;
                }
            }
            this.E = Boolean.FALSE;
        }
        return this.E.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        super.addValueCallback(t, lc1Var);
        if (t == LottieProperty.TIME_REMAP) {
            if (lc1Var == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.z;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.n(null);
                    return;
                }
                return;
            }
            n nVar = new n(lc1Var);
            this.z = nVar;
            nVar.a(this);
            c(this.z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.B.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.A.get(size).getBounds(this.B, this.m, true);
            rectF.union(this.B);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void n(Canvas canvas, Matrix matrix, int i) {
        f81.a("CompositionLayer#draw");
        this.C.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.C);
        boolean z = this.n.isApplyingOpacityToLayersEnabled() && this.A.size() > 1 && i != 255;
        if (z) {
            this.D.setAlpha(i);
            aw2.m(canvas, this.C, this.D);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.A.size() - 1; size >= 0; size--) {
            if (!this.C.isEmpty() ? canvas.clipRect(this.C) : true) {
                this.A.get(size).draw(canvas, matrix, i);
            }
        }
        canvas.restore();
        f81.b("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void x(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            this.A.get(i2).resolveKeyPath(s71Var, i, list, s71Var2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void z(boolean z) {
        super.z(z);
        for (com.airbnb.lottie.model.layer.a aVar : this.A) {
            aVar.z(z);
        }
    }
}
