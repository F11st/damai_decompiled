package com.youku.live.dsl.share;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum ShareMode {
    SHARE_MODE_BANNER(0),
    SHARE_MODE_IMAGE(1);
    
    private final int mShareMode;

    ShareMode(int i) {
        this.mShareMode = i;
    }

    public int getShareMode() {
        return this.mShareMode;
    }
}
