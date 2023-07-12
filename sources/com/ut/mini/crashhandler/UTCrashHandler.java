package com.ut.mini.crashhandler;

import com.alibaba.motu.crashreporter.MotuCrashReporter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTCrashHandler {
    private static UTCrashHandler s_instance = new UTCrashHandler();

    public static UTCrashHandler getInstance() {
        return s_instance;
    }

    public void setCrashCaughtListener(IUTCrashCaughtListener iUTCrashCaughtListener) {
        MotuCrashReporter.getInstance().setCrashCaughtListener(new UTCrashHandlerWapper(iUTCrashCaughtListener));
    }
}
