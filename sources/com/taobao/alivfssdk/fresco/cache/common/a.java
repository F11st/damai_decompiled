package com.taobao.alivfssdk.fresco.cache.common;

import androidx.annotation.Nullable;
import com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class a implements CacheErrorLogger {
    private static a a;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    @Override // com.taobao.alivfssdk.fresco.cache.common.CacheErrorLogger
    public void logError(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, String str, String str2, @Nullable Throwable th) {
    }
}
