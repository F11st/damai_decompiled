package com.youku.playerservice.axp.resize;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface IResizer {
    public static final int VIEW_CUT_MODE_FITXY = 2;
    public static final int VIEW_CUT_MODE_FULL = 1;
    public static final int VIEW_CUT_MODE_NONE = 0;
    public static final int VIEW_CUT_MODE_SMART = 3;

    void addOnResizerListener(OnResizerListener onResizerListener);

    void setVideoCutMode(int i);
}
