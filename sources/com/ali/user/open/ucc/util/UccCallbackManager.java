package com.ali.user.open.ucc.util;

import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.ucc.UccCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccCallbackManager {
    private static Map<String, List<LoginCallback>> trustLoginCallbacks = new HashMap();
    private static Map<String, List<UccCallback>> uccCallbacks = new HashMap();

    public static synchronized List<LoginCallback> getTrustLoginCallbackWithSite(String str) {
        List<LoginCallback> list;
        synchronized (UccCallbackManager.class) {
            list = trustLoginCallbacks.get(str);
        }
        return list;
    }

    public static synchronized List<UccCallback> getUccCallbackWithSite(String str) {
        List<UccCallback> list;
        synchronized (UccCallbackManager.class) {
            list = uccCallbacks.get(str);
        }
        return list;
    }

    public static synchronized void registerTrustLoginUccCallback(String str, LoginCallback loginCallback) {
        synchronized (UccCallbackManager.class) {
            if (loginCallback != null) {
                List<LoginCallback> list = trustLoginCallbacks.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(loginCallback);
                trustLoginCallbacks.put(str, list);
            }
        }
    }

    public static synchronized void registerUccCallback(String str, UccCallback uccCallback) {
        synchronized (UccCallbackManager.class) {
            if (uccCallback != null) {
                List<UccCallback> list = uccCallbacks.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(uccCallback);
                uccCallbacks.put(str, list);
            }
        }
    }

    public static synchronized void unregisterTrustLoginCallback(String str) {
        synchronized (UccCallbackManager.class) {
            trustLoginCallbacks.remove(str);
        }
    }

    public static synchronized void unregisterUccCallback(String str) {
        synchronized (UccCallbackManager.class) {
            uccCallbacks.remove(str);
        }
    }
}
