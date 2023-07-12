package com.youku.uplayer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface OnPreLoadExtraListener {
    public static final int PRELOAD_MSG_CANCELED = 6;
    public static final int PRELOAD_MSG_COMPLETED = 2;
    public static final int PRELOAD_MSG_FAILED = 3;
    public static final int PRELOAD_MSG_PLAYING = 5;
    public static final int PRELOAD_MSG_PRELOADING = 4;
    public static final int PRELOAD_MSG_STARTED = 1;

    String getPreloadUrl();

    boolean isListenAllPreloadStatus();

    void onPreloadStatucChanged(int i, String str);
}
