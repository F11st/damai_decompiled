package com.youku.alixplayer.opensdk.resize;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IResizer {
    public static final int VIEW_CUT_MODE_CENTER_CROP = 4;
    public static final int VIEW_CUT_MODE_FITXY = 1;
    public static final int VIEW_CUT_MODE_HEIGHT = 3;
    public static final int VIEW_CUT_MODE_NONE = 0;
    public static final int VIEW_CUT_MODE_WIDTH = 2;

    void addOnResizerListener(OnResizerListener onResizerListener);

    void setVideoCutMode(int i);
}
