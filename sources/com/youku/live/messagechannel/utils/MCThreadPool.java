package com.youku.live.messagechannel.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCThreadPool {
    public static ThreadPoolExecutor markMsgStore;
    public static ThreadPoolExecutor sessionOperator;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        sessionOperator = new ThreadPoolExecutor(3, 3, 60L, timeUnit, new LinkedBlockingQueue(), new MCThreadFactory("session-operate"));
        markMsgStore = new ThreadPoolExecutor(4, 4, 60L, timeUnit, new LinkedBlockingQueue(), new MCThreadFactory("mark-msg-store"));
    }
}
