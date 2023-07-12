package com.taobao.weex.devtools.inspector.network;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: Taobao */
@ThreadSafe
/* loaded from: classes11.dex */
public class AsyncPrettyPrinterRegistry {
    private final Map<String, AsyncPrettyPrinterFactory> mRegistry = new HashMap();

    @Nullable
    public synchronized AsyncPrettyPrinterFactory lookup(String str) {
        return this.mRegistry.get(str);
    }

    public synchronized void register(String str, AsyncPrettyPrinterFactory asyncPrettyPrinterFactory) {
        this.mRegistry.put(str, asyncPrettyPrinterFactory);
    }

    public synchronized boolean unregister(String str) {
        return this.mRegistry.remove(str) != null;
    }
}
