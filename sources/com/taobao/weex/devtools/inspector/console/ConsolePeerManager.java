package com.taobao.weex.devtools.inspector.console;

import com.taobao.weex.devtools.inspector.helper.ChromePeerManager;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ConsolePeerManager extends ChromePeerManager {
    private static ConsolePeerManager sInstance;

    private ConsolePeerManager() {
    }

    @Nullable
    public static synchronized ConsolePeerManager getInstanceOrNull() {
        ConsolePeerManager orCreateInstance;
        synchronized (ConsolePeerManager.class) {
            orCreateInstance = getOrCreateInstance();
        }
        return orCreateInstance;
    }

    public static synchronized ConsolePeerManager getOrCreateInstance() {
        ConsolePeerManager consolePeerManager;
        synchronized (ConsolePeerManager.class) {
            if (sInstance == null) {
                sInstance = new ConsolePeerManager();
            }
            consolePeerManager = sInstance;
        }
        return consolePeerManager;
    }
}
