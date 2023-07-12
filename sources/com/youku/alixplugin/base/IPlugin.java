package com.youku.alixplugin.base;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface IPlugin {
    public static final int PLUGIN_FLAG_GONE = 8;
    public static final int PLUGIN_FLAG_INVISIBLE = 4;
    public static final int PLUGIN_FLAG_NONE = 0;
    public static final int PLUGIN_FLAG_REGISTER = 16;
    public static final int PLUGIN_FLAG_UNREGISTER = 32;
    public static final int PLUGIN_FLAG_VISIBLE = 2;
    public static final int PLUGIN_VISIBILITY_MASK = 15;

    View getHolderView();

    String getLayerId();

    int getMajorLevel();

    int getMinorLevel();

    String getName();

    boolean isActive();

    boolean isAttached();

    boolean isEnable();

    void onAvailabilityChanged(boolean z, int i);

    void onCreate();

    void onDestroy();

    void onStart();

    void onStop();

    void release();

    void setEnable(boolean z);
}
