package com.alibaba.motu.crashreporter.ignores;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FakeFinallzeExceptionIgnore implements UncaughtExceptionIgnore {
    @Override // com.alibaba.motu.crashreporter.ignores.UncaughtExceptionIgnore
    public String getName() {
        return "FakeFinallzeExceptionIgnore";
    }

    @Override // com.alibaba.motu.crashreporter.ignores.UncaughtExceptionIgnore
    public boolean uncaughtExceptionIgnore(Thread thread, Throwable th) {
        String name = thread.getName();
        if (("FinalizerDaemon".equals(name) || "FakeFinalizerDaemon".equals(name) || "FinalizerWatchdogDaemon".equals(name) || "FakeFinalizerWatchdogDaemon".equals(name)) && (th instanceof IllegalStateException)) {
            return "not running".equals(th.getMessage()) || "already running".equals(th.getMessage());
        }
        return false;
    }
}
