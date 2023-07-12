package com.taobao.tao.remotebusiness;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RequestPoolManager {
    private static ConcurrentHashMap<String, RequestPool> poolConcurrentHashMap = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Type {
        public static final String ANTI = "ANTI";
        public static final String AUTH = "AUTH";
        public static final String DEFAULT = "DEFAULT";
        public static final String SESSION = "SESSION";

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes11.dex */
        public @interface Definition {
        }
    }

    public static RequestPool getPool(String str) {
        RequestPool requestPool = poolConcurrentHashMap.get(str);
        if (requestPool == null) {
            synchronized (RequestPoolManager.class) {
                requestPool = poolConcurrentHashMap.get(str);
                if (requestPool == null) {
                    requestPool = new RequestPool();
                    poolConcurrentHashMap.put(str, requestPool);
                }
            }
        }
        return requestPool;
    }
}
