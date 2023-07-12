package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.C2841m;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.List;
import tb.j5;
import tb.k5;
import tb.m5;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ShapeStroke implements ContentModel {
    private final String a;
    @Nullable
    private final k5 b;
    private final List<k5> c;
    private final j5 d;
    private final m5 e;
    private final k5 f;
    private final LineCapType g;
    private final LineJoinType h;
    private final float i;
    private final boolean j;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = C2870a.a[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = C2870a.b[ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$a */
    /* loaded from: classes17.dex */
    static /* synthetic */ class C2870a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable k5 k5Var, List<k5> list, j5 j5Var, m5 m5Var, k5 k5Var2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.a = str;
        this.b = k5Var;
        this.c = list;
        this.d = j5Var;
        this.e = m5Var;
        this.f = k5Var2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f;
        this.j = z;
    }

    public LineCapType a() {
        return this.g;
    }

    public j5 b() {
        return this.d;
    }

    public k5 c() {
        return this.b;
    }

    public LineJoinType d() {
        return this.h;
    }

    public List<k5> e() {
        return this.c;
    }

    public float f() {
        return this.i;
    }

    public String g() {
        return this.a;
    }

    public m5 h() {
        return this.e;
    }

    public k5 i() {
        return this.f;
    }

    public boolean j() {
        return this.j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a) {
        return new C2841m(lottieDrawable, abstractC2872a, this);
    }
}
