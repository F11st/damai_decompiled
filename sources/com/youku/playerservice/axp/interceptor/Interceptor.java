package com.youku.playerservice.axp.interceptor;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface Interceptor {
    public static final int ERROR = 3;
    public static final int PLAY = 0;
    public static final int REQUEST = 1;
    public static final int SEEK = 2;
    public static final int START = 4;

    void intercept(Chain chain);
}
