package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.C2833g;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import java.util.List;
import tb.k5;
import tb.l5;
import tb.m5;
import tb.o5;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.model.content.a */
/* loaded from: classes9.dex */
public class C2871a implements ContentModel {
    private final String a;
    private final GradientType b;
    private final l5 c;
    private final m5 d;
    private final o5 e;
    private final o5 f;
    private final k5 g;
    private final ShapeStroke.LineCapType h;
    private final ShapeStroke.LineJoinType i;
    private final float j;
    private final List<k5> k;
    @Nullable
    private final k5 l;
    private final boolean m;

    public C2871a(String str, GradientType gradientType, l5 l5Var, m5 m5Var, o5 o5Var, o5 o5Var2, k5 k5Var, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<k5> list, @Nullable k5 k5Var2, boolean z) {
        this.a = str;
        this.b = gradientType;
        this.c = l5Var;
        this.d = m5Var;
        this.e = o5Var;
        this.f = o5Var2;
        this.g = k5Var;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = f;
        this.k = list;
        this.l = k5Var2;
        this.m = z;
    }

    public ShapeStroke.LineCapType a() {
        return this.h;
    }

    @Nullable
    public k5 b() {
        return this.l;
    }

    public o5 c() {
        return this.f;
    }

    public l5 d() {
        return this.c;
    }

    public GradientType e() {
        return this.b;
    }

    public ShapeStroke.LineJoinType f() {
        return this.i;
    }

    public List<k5> g() {
        return this.k;
    }

    public float h() {
        return this.j;
    }

    public String i() {
        return this.a;
    }

    public m5 j() {
        return this.d;
    }

    public o5 k() {
        return this.e;
    }

    public k5 l() {
        return this.g;
    }

    public boolean m() {
        return this.m;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a) {
        return new C2833g(lottieDrawable, abstractC2872a, this);
    }
}
