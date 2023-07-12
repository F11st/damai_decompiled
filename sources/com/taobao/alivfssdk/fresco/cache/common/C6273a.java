package com.taobao.alivfssdk.fresco.cache.common;

import androidx.annotation.Nullable;
import com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger;

/* compiled from: Taobao */
/* renamed from: com.taobao.alivfssdk.fresco.cache.common.a */
/* loaded from: classes8.dex */
public class C6273a implements CacheErrorLogger {
    private static C6273a a;

    private C6273a() {
    }

    public static synchronized C6273a a() {
        C6273a c6273a;
        synchronized (C6273a.class) {
            if (a == null) {
                a = new C6273a();
            }
            c6273a = a;
        }
        return c6273a;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger
    public void logError(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, String str, String str2, @Nullable Throwable th) {
    }
}
