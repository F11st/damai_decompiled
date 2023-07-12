package com.ut.mini.crashhandler;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IUTCrashCaughtListener {
    Map<String, Object> onCrashCaught(Thread thread, Throwable th);
}
