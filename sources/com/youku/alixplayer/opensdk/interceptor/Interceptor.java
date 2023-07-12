package com.youku.alixplayer.opensdk.interceptor;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Interceptor {
    public static final int ERROR = 3;
    public static final int PLAY = 0;
    public static final int REQUEST = 1;
    public static final int SET_DATASOURCE = 2;

    void intercept(Chain<Object> chain);
}
