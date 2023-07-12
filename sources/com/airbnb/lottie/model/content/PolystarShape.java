package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.C2836i;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import tb.k5;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class PolystarShape implements ContentModel {
    private final String a;
    private final Type b;
    private final k5 c;
    private final AnimatableValue<PointF, PointF> d;
    private final k5 e;
    private final k5 f;
    private final k5 g;
    private final k5 h;
    private final k5 i;
    private final boolean j;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, k5 k5Var, AnimatableValue<PointF, PointF> animatableValue, k5 k5Var2, k5 k5Var3, k5 k5Var4, k5 k5Var5, k5 k5Var6, boolean z) {
        this.a = str;
        this.b = type;
        this.c = k5Var;
        this.d = animatableValue;
        this.e = k5Var2;
        this.f = k5Var3;
        this.g = k5Var4;
        this.h = k5Var5;
        this.i = k5Var6;
        this.j = z;
    }

    public k5 a() {
        return this.f;
    }

    public k5 b() {
        return this.h;
    }

    public String c() {
        return this.a;
    }

    public k5 d() {
        return this.g;
    }

    public k5 e() {
        return this.i;
    }

    public k5 f() {
        return this.c;
    }

    public AnimatableValue<PointF, PointF> g() {
        return this.d;
    }

    public k5 h() {
        return this.e;
    }

    public Type i() {
        return this.b;
    }

    public boolean j() {
        return this.j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a) {
        return new C2836i(lottieDrawable, abstractC2872a, this);
    }
}
