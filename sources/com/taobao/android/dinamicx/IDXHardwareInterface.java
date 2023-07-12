package com.taobao.android.dinamicx;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXHardwareInterface {
    public static final int LEVEL_HIGH = 0;
    public static final int LEVEL_LOW = 2;
    public static final int LEVEL_MEDIUM = 1;
    public static final int LEVEL_UNKNOWN = -1;

    int getDeviceLevel();
}
