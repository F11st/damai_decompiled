package com.airbnb.lottie.model.content;

import tb.m5;
import tb.q5;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Mask {
    private final MaskMode a;
    private final q5 b;
    private final m5 c;
    private final boolean d;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, q5 q5Var, m5 m5Var, boolean z) {
        this.a = maskMode;
        this.b = q5Var;
        this.c = m5Var;
        this.d = z;
    }

    public MaskMode a() {
        return this.a;
    }

    public q5 b() {
        return this.b;
    }

    public m5 c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
