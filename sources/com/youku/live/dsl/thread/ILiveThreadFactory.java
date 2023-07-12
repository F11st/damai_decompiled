package com.youku.live.dsl.thread;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface ILiveThreadFactory {
    public static final String GROUP = "YoukuLive";
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_IMMEDIATE = 3;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_NORMAL = 1;
    public static final int TYPE_CPU = 2;
    public static final int TYPE_IO = 1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_PRC = 3;

    void excute(Runnable runnable);

    void excuteWithPriority(Runnable runnable, int i);

    void excuteWithType(Runnable runnable, int i);

    void excuteWithTypePriority(Runnable runnable, int i, int i2);
}
