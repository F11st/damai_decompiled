package com.youku.uplayer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface OnTurboStatusListener {
    public static final int PRELOAD_SOURCE_MSG_ADD_FAILED = 4;
    public static final int PRELOAD_SOURCE_MSG_ADD_SUCCESS = 1;
    public static final int PRELOAD_SOURCE_MSG_ATTACH_SUCCESS = 3;
    public static final int PRELOAD_SOURCE_MSG_CLOSE_FAILED = 5;
    public static final int PRELOAD_SOURCE_MSG_CLOSE_SUCCESS = 2;
    public static final int PRELOAD_SOURCE_STATUS_CREATEIMPL_FAILED = -7;
    public static final int PRELOAD_SOURCE_STATUS_ERASE_FAILED = -9;
    public static final int PRELOAD_SOURCE_STATUS_FINDSTREAM_FAILED = -5;
    public static final int PRELOAD_SOURCE_STATUS_HAS_ADDED = -2;
    public static final int PRELOAD_SOURCE_STATUS_HAS_NO_ADDED = -10;
    public static final int PRELOAD_SOURCE_STATUS_INSERT_FAILED = -8;
    public static final int PRELOAD_SOURCE_STATUS_INVALID_PARAMS = -1;
    public static final int PRELOAD_SOURCE_STATUS_NO_ADDED_BEFORE = -3;
    public static final int PRELOAD_SOURCE_STATUS_NO_TRACKS = -6;
    public static final int PRELOAD_SOURCE_STATUS_OPEN_FAILED = -4;

    boolean needObserverUrl(String str);

    void onStatusChanged(int i, int i2, String str);
}
