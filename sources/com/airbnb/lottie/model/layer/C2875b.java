package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2860n;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;
import tb.aw2;
import tb.f81;
import tb.k5;
import tb.lc1;
import tb.s71;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.model.layer.b */
/* loaded from: classes9.dex */
public class C2875b extends AbstractC2872a {
    private final List<AbstractC2872a> A;
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
    /* renamed from: com.airbnb.lottie.model.layer.b$a */
    /* loaded from: classes17.dex */
    static /* synthetic */ class C2876a {
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

    public C2875b(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, C2821a c2821a) {
        super(lottieDrawable, layer);
        int i;
        AbstractC2872a abstractC2872a;
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
        LongSparseArray longSparseArray = new LongSparseArray(c2821a.j().size());
        int size = list.size() - 1;
        AbstractC2872a abstractC2872a2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            AbstractC2872a o = AbstractC2872a.o(layer2, lottieDrawable, c2821a);
            if (o != null) {
                longSparseArray.put(o.p().b(), o);
                if (abstractC2872a2 != null) {
                    abstractC2872a2.y(o);
                    abstractC2872a2 = null;
                } else {
                    this.A.add(0, o);
                    int i2 = C2876a.a[layer2.f().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        abstractC2872a2 = o;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            AbstractC2872a abstractC2872a3 = (AbstractC2872a) longSparseArray.get(longSparseArray.keyAt(i));
            if (abstractC2872a3 != null && (abstractC2872a = (AbstractC2872a) longSparseArray.get(abstractC2872a3.p().h())) != null) {
                abstractC2872a3.A(abstractC2872a);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a
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
                AbstractC2872a abstractC2872a = this.A.get(size);
                if (abstractC2872a instanceof C2879e) {
                    if (abstractC2872a.q()) {
                        this.F = Boolean.TRUE;
                        return true;
                    }
                } else if ((abstractC2872a instanceof C2875b) && ((C2875b) abstractC2872a).E()) {
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

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a, com.airbnb.lottie.model.KeyPathElement
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
            C2860n c2860n = new C2860n(lc1Var);
            this.z = c2860n;
            c2860n.a(this);
            c(this.z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        for (int size = this.A.size() - 1; size >= 0; size--) {
            this.B.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.A.get(size).getBounds(this.B, this.m, true);
            rectF.union(this.B);
        }
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a
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

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a
    protected void x(s71 s71Var, int i, List<s71> list, s71 s71Var2) {
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            this.A.get(i2).resolveKeyPath(s71Var, i, list, s71Var2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a
    public void z(boolean z) {
        super.z(z);
        for (AbstractC2872a abstractC2872a : this.A) {
            abstractC2872a.z(z);
        }
    }
}
