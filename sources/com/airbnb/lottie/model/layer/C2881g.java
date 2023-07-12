package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.C2829c;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.C2858l;
import com.airbnb.lottie.animation.keyframe.C2860n;
import com.airbnb.lottie.model.DocumentData;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;
import tb.aw2;
import tb.cp0;
import tb.j5;
import tb.k5;
import tb.lb2;
import tb.lc1;
import tb.t5;
import tb.xo0;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.model.layer.g */
/* loaded from: classes9.dex */
public class C2881g extends AbstractC2872a {
    private final RectF A;
    private final Matrix B;
    private final Paint C;
    private final Paint D;
    private final Map<cp0, List<C2829c>> E;
    private final LongSparseArray<String> F;
    private final C2858l G;
    private final LottieDrawable H;
    private final C2821a I;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> J;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> K;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> L;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> M;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> N;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> O;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> P;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> Q;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> R;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> S;
    private final StringBuilder z;

    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.model.layer.g$a */
    /* loaded from: classes17.dex */
    class C2882a extends Paint {
        C2882a(C2881g c2881g, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.model.layer.g$b */
    /* loaded from: classes17.dex */
    class C2883b extends Paint {
        C2883b(C2881g c2881g, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.model.layer.g$c */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class C2884c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2881g(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        k5 k5Var;
        k5 k5Var2;
        j5 j5Var;
        j5 j5Var2;
        this.z = new StringBuilder(2);
        this.A = new RectF();
        this.B = new Matrix();
        this.C = new C2882a(this, 1);
        this.D = new C2883b(this, 1);
        this.E = new HashMap();
        this.F = new LongSparseArray<>();
        this.H = lottieDrawable;
        this.I = layer.a();
        C2858l createAnimation = layer.q().createAnimation();
        this.G = createAnimation;
        createAnimation.a(this);
        c(createAnimation);
        t5 r = layer.r();
        if (r != null && (j5Var2 = r.a) != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = j5Var2.createAnimation();
            this.J = createAnimation2;
            createAnimation2.a(this);
            c(this.J);
        }
        if (r != null && (j5Var = r.b) != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation3 = j5Var.createAnimation();
            this.L = createAnimation3;
            createAnimation3.a(this);
            c(this.L);
        }
        if (r != null && (k5Var2 = r.c) != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation4 = k5Var2.createAnimation();
            this.N = createAnimation4;
            createAnimation4.a(this);
            c(this.N);
        }
        if (r == null || (k5Var = r.d) == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> createAnimation5 = k5Var.createAnimation();
        this.P = createAnimation5;
        createAnimation5.a(this);
        c(this.P);
    }

    private void E(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = C2884c.a[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else if (i != 3) {
        } else {
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    private String F(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!R(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = codePointAt;
        if (this.F.containsKey(j)) {
            return this.F.get(j);
        }
        this.z.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.z.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.z.toString();
        this.F.put(j, sb);
        return sb;
    }

    private void G(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void H(cp0 cp0Var, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<C2829c> O = O(cp0Var);
        for (int i = 0; i < O.size(); i++) {
            Path path = O.get(i).getPath();
            path.computeBounds(this.A, false);
            this.B.set(matrix);
            this.B.preTranslate(0.0f, (-documentData.g) * aw2.e());
            this.B.preScale(f, f);
            path.transform(this.B);
            if (documentData.k) {
                K(path, this.C, canvas);
                K(path, this.D, canvas);
            } else {
                K(path, this.D, canvas);
                K(path, this.C, canvas);
            }
        }
    }

    private void I(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.k) {
            G(str, this.C, canvas);
            G(str, this.D, canvas);
            return;
        }
        G(str, this.D, canvas);
        G(str, this.C, canvas);
    }

    private void J(String str, DocumentData documentData, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String F = F(str, i);
            i += F.length();
            I(F, documentData, canvas);
            canvas.translate(this.C.measureText(F) + f, 0.0f);
        }
    }

    private void K(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void L(String str, DocumentData documentData, Matrix matrix, xo0 xo0Var, Canvas canvas, float f, float f2) {
        float floatValue;
        for (int i = 0; i < str.length(); i++) {
            cp0 cp0Var = this.I.c().get(cp0.c(str.charAt(i), xo0Var.a(), xo0Var.c()));
            if (cp0Var != null) {
                H(cp0Var, matrix, f2, documentData, canvas);
                float b = ((float) cp0Var.b()) * f2 * aw2.e() * f;
                float f3 = documentData.e / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.Q;
                if (baseKeyframeAnimation != null) {
                    floatValue = baseKeyframeAnimation.h().floatValue();
                } else {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.P;
                    if (baseKeyframeAnimation2 != null) {
                        floatValue = baseKeyframeAnimation2.h().floatValue();
                    }
                    canvas.translate(b + (f3 * f), 0.0f);
                }
                f3 += floatValue;
                canvas.translate(b + (f3 * f), 0.0f);
            }
        }
    }

    private void M(DocumentData documentData, Matrix matrix, xo0 xo0Var, Canvas canvas) {
        float f;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.S;
        if (baseKeyframeAnimation != null) {
            f = baseKeyframeAnimation.h().floatValue();
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.R;
            if (baseKeyframeAnimation2 != null) {
                f = baseKeyframeAnimation2.h().floatValue();
            } else {
                f = documentData.c;
            }
        }
        float f2 = f / 100.0f;
        float g = aw2.g(matrix);
        String str = documentData.a;
        float e = documentData.f * aw2.e();
        List<String> Q = Q(str);
        int size = Q.size();
        for (int i = 0; i < size; i++) {
            String str2 = Q.get(i);
            float P = P(str2, xo0Var, f2, g);
            canvas.save();
            E(documentData.d, canvas, P);
            canvas.translate(0.0f, (i * e) - (((size - 1) * e) / 2.0f));
            L(str2, documentData, matrix, xo0Var, canvas, g, f2);
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4 A[LOOP:0: B:20:0x00a2->B:21:0x00a4, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void N(com.airbnb.lottie.model.DocumentData r7, tb.xo0 r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            tb.aw2.g(r9)
            com.airbnb.lottie.LottieDrawable r9 = r6.H
            java.lang.String r0 = r8.a()
            java.lang.String r8 = r8.c()
            android.graphics.Typeface r8 = r9.getTypeface(r0, r8)
            if (r8 != 0) goto L14
            return
        L14:
            java.lang.String r9 = r7.a
            com.airbnb.lottie.LottieDrawable r0 = r6.H
            r0.getTextDelegate()
            android.graphics.Paint r0 = r6.C
            r0.setTypeface(r8)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r8 = r6.S
            if (r8 == 0) goto L2f
            java.lang.Object r8 = r8.h()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L40
        L2f:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r8 = r6.R
            if (r8 == 0) goto L3e
            java.lang.Object r8 = r8.h()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L40
        L3e:
            float r8 = r7.c
        L40:
            android.graphics.Paint r0 = r6.C
            float r1 = tb.aw2.e()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.D
            android.graphics.Paint r1 = r6.C
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.D
            android.graphics.Paint r1 = r6.C
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.f
            float r1 = tb.aw2.e()
            float r0 = r0 * r1
            int r1 = r7.e
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r2 = r6.Q
            if (r2 == 0) goto L7f
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L7d:
            float r1 = r1 + r2
            goto L8e
        L7f:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r2 = r6.P
            if (r2 == 0) goto L8e
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L7d
        L8e:
            float r2 = tb.aw2.e()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.Q(r9)
            int r9 = r8.size()
            r2 = 0
        La2:
            if (r2 >= r9) goto Ldb
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.D
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            com.airbnb.lottie.model.DocumentData$Justification r5 = r7.d
            r6.E(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.J(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto La2
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.C2881g.N(com.airbnb.lottie.model.DocumentData, tb.xo0, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    private List<C2829c> O(cp0 cp0Var) {
        if (this.E.containsKey(cp0Var)) {
            return this.E.get(cp0Var);
        }
        List<lb2> a = cp0Var.a();
        int size = a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new C2829c(this.H, this, a.get(i)));
        }
        this.E.put(cp0Var, arrayList);
        return arrayList;
    }

    private float P(String str, xo0 xo0Var, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            cp0 cp0Var = this.I.c().get(cp0.c(str.charAt(i), xo0Var.a(), xo0Var.c()));
            if (cp0Var != null) {
                f3 = (float) (f3 + (cp0Var.b() * f * aw2.e() * f2));
            }
        }
        return f3;
    }

    private List<String> Q(String str) {
        return Arrays.asList(str.replaceAll(SocketClient.NETASCII_EOL, StringUtils.CR).replaceAll(StringUtils.LF, StringUtils.CR).split(StringUtils.CR));
    }

    private boolean R(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable lc1<T> lc1Var) {
        super.addValueCallback(t, lc1Var);
        if (t == LottieProperty.COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.K;
            if (baseKeyframeAnimation != null) {
                w(baseKeyframeAnimation);
            }
            if (lc1Var == null) {
                this.K = null;
                return;
            }
            C2860n c2860n = new C2860n(lc1Var);
            this.K = c2860n;
            c2860n.a(this);
            c(this.K);
        } else if (t == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.M;
            if (baseKeyframeAnimation2 != null) {
                w(baseKeyframeAnimation2);
            }
            if (lc1Var == null) {
                this.M = null;
                return;
            }
            C2860n c2860n2 = new C2860n(lc1Var);
            this.M = c2860n2;
            c2860n2.a(this);
            c(this.M);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.O;
            if (baseKeyframeAnimation3 != null) {
                w(baseKeyframeAnimation3);
            }
            if (lc1Var == null) {
                this.O = null;
                return;
            }
            C2860n c2860n3 = new C2860n(lc1Var);
            this.O = c2860n3;
            c2860n3.a(this);
            c(this.O);
        } else if (t == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.Q;
            if (baseKeyframeAnimation4 != null) {
                w(baseKeyframeAnimation4);
            }
            if (lc1Var == null) {
                this.Q = null;
                return;
            }
            C2860n c2860n4 = new C2860n(lc1Var);
            this.Q = c2860n4;
            c2860n4.a(this);
            c(this.Q);
        } else if (t == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.S;
            if (baseKeyframeAnimation5 != null) {
                w(baseKeyframeAnimation5);
            }
            if (lc1Var == null) {
                this.S = null;
                return;
            }
            C2860n c2860n5 = new C2860n(lc1Var);
            this.S = c2860n5;
            c2860n5.a(this);
            c(this.S);
        }
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, Rect.width(this.I.b()), Rect.height(this.I.b()));
    }

    @Override // com.airbnb.lottie.model.layer.AbstractC2872a
    void n(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.H.useTextGlyphs()) {
            canvas.concat(matrix);
        }
        DocumentData h = this.G.h();
        xo0 xo0Var = this.I.g().get(h.b);
        if (xo0Var == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.K;
        if (baseKeyframeAnimation != null) {
            this.C.setColor(baseKeyframeAnimation.h().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.J;
            if (baseKeyframeAnimation2 != null) {
                this.C.setColor(baseKeyframeAnimation2.h().intValue());
            } else {
                this.C.setColor(h.h);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.M;
        if (baseKeyframeAnimation3 != null) {
            this.D.setColor(baseKeyframeAnimation3.h().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.L;
            if (baseKeyframeAnimation4 != null) {
                this.D.setColor(baseKeyframeAnimation4.h().intValue());
            } else {
                this.D.setColor(h.i);
            }
        }
        int intValue = ((this.v.h() == null ? 100 : this.v.h().h().intValue()) * 255) / 100;
        this.C.setAlpha(intValue);
        this.D.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.O;
        if (baseKeyframeAnimation5 != null) {
            this.D.setStrokeWidth(baseKeyframeAnimation5.h().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.N;
            if (baseKeyframeAnimation6 != null) {
                this.D.setStrokeWidth(baseKeyframeAnimation6.h().floatValue());
            } else {
                this.D.setStrokeWidth(h.j * aw2.e() * aw2.g(matrix));
            }
        }
        if (this.H.useTextGlyphs()) {
            M(h, matrix, xo0Var, canvas);
        } else {
            N(h, xo0Var, matrix, canvas);
        }
        canvas.restore();
    }
}
