package com.taobao.pexode.animate;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AnimatedDrawableFrameInfo {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final DisposalMode e;
    public final BlendMode f;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum BlendMode {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum DisposalMode {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, BlendMode blendMode, DisposalMode disposalMode) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.f = blendMode;
        this.e = disposalMode;
    }
}
