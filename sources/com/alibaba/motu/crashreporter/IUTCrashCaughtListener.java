package com.alibaba.motu.crashreporter;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface IUTCrashCaughtListener {
    Map<String, Object> onCrashCaught(Thread thread, Throwable th);
}
