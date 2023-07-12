package com.alibaba.motu.crashreporter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class NativeCrashListenerManager {
    private static volatile NativeCrashListenerManager sInstance;
    private List<NativeCrashListener> mListeners = new CopyOnWriteArrayList();

    public static NativeCrashListenerManager sharedInstance() {
        if (sInstance == null) {
            synchronized (NativeCrashListenerManager.class) {
                if (sInstance == null) {
                    sInstance = new NativeCrashListenerManager();
                }
            }
        }
        return sInstance;
    }

    public void addNativeCrashListener(NativeCrashListener nativeCrashListener) {
        this.mListeners.add(nativeCrashListener);
    }

    public void onNativeCrash(NativeCrashContext nativeCrashContext) {
        try {
            for (NativeCrashListener nativeCrashListener : this.mListeners) {
                if (nativeCrashListener != null) {
                    nativeCrashListener.onNativeCrash(nativeCrashContext);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
