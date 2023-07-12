package com.alibaba.youku.webp4pexode;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum WebpImageType {
    WEBP_SIMPLE(false, false),
    WEBP_LOSSLESS(false, false),
    WEBP_LOSSLESS_WITH_ALPHA(true, false),
    WEBP_EXTENDED(false, false),
    WEBP_EXTENDED_WITH_ALPHA(true, false),
    WEBP_EXTENDED_ANIMATED(false, true),
    NONE_WEBP(false, false);
    
    private final boolean hasAlpha;
    private final boolean hasAnimation;

    WebpImageType(boolean z, boolean z2) {
        this.hasAlpha = z;
        this.hasAnimation = z2;
    }

    public boolean hasAlpha() {
        return this.hasAlpha;
    }

    public boolean hasAnimation() {
        return this.hasAnimation;
    }
}
