package com.alibaba.motu.crashreporter.ignores;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public interface UncaughtExceptionIgnore {
    String getName();

    boolean uncaughtExceptionIgnore(Thread thread, Throwable th);
}
