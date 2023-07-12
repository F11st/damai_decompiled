package com.ut.mini.module.process;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import com.ut.mini.UTTracker;
import com.ut.mini.scene.UTSceneTracker;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbsMultiProcessAdapter {
    public UTSceneTracker getSubProcessUTSceneTracker() {
        return null;
    }

    public abstract Class<? extends UTTracker> getSubProcessUTTrackerClass();

    public abstract Class<? extends WVApiPlugin> getSubProcessWVApiPluginClass();

    public abstract void initProxy();

    public abstract boolean isUiSubProcess();

    public abstract void registerActivityLifecycleCallbacks();
}
