package com.youku.alixplayer;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IPeriod<T> {
    public static final int FEATURE_NONE = 0;
    public static final int FEATURE_PRELOAD_REQUIRED = 1;
    public static final int PERIOD_TYPE_MAIN = 0;
    public static final int PERIOD_TYPE_MID_AD = 3;
    public static final int PERIOD_TYPE_POST_AD = 4;
    public static final int PERIOD_TYPE_POST_VIPAD = 5;
    public static final int PERIOD_TYPE_PRE_AD = 1;
    public static final int PERIOD_TYPE_PRE_VIPAD = 2;

    long getIdentity();

    List<T> getSourceList();

    int getType();
}
