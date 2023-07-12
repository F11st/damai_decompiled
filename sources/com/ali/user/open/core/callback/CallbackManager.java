package com.ali.user.open.core.callback;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CallbackManager {
    private static Map<Integer, Object> staticCallbacks = new HashMap();

    public static synchronized Object getCallback(Integer num) {
        Object obj;
        synchronized (CallbackManager.class) {
            obj = staticCallbacks.get(num);
        }
        return obj;
    }

    public static synchronized void registerCallback(int i, Object obj) {
        synchronized (CallbackManager.class) {
            if (obj != null) {
                staticCallbacks.put(Integer.valueOf(i), obj);
            }
        }
    }

    public static void unregisterCallback(int i) {
        staticCallbacks.remove(Integer.valueOf(i));
    }
}
