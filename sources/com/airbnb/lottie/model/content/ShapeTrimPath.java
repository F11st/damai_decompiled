package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.C2842n;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.layer.AbstractC2872a;
import tb.k5;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ShapeTrimPath implements ContentModel {
    private final String a;
    private final Type b;
    private final k5 c;
    private final k5 d;
    private final k5 e;
    private final boolean f;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i != 1) {
                if (i == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i);
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, k5 k5Var, k5 k5Var2, k5 k5Var3, boolean z) {
        this.a = str;
        this.b = type;
        this.c = k5Var;
        this.d = k5Var2;
        this.e = k5Var3;
        this.f = z;
    }

    public k5 a() {
        return this.d;
    }

    public String b() {
        return this.a;
    }

    public k5 c() {
        return this.e;
    }

    public k5 d() {
        return this.c;
    }

    public Type e() {
        return this.b;
    }

    public boolean f() {
        return this.f;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, AbstractC2872a abstractC2872a) {
        return new C2842n(abstractC2872a, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
