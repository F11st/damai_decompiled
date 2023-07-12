package com.ut.mini.module.plugin;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTPluginMgr {
    private static final String TAG = "UTPluginMgr";
    private static UTPluginMgr mInstance;
    private UTPluginConfigMgr mUTPluginConfigMgr = new UTPluginConfigMgr();

    private UTPluginMgr() {
    }

    public static UTPluginMgr getInstance() {
        if (mInstance == null) {
            synchronized (UTPluginMgr.class) {
                if (mInstance == null) {
                    mInstance = new UTPluginMgr();
                }
            }
        }
        return mInstance;
    }

    @Deprecated
    public UTPluginConfigMgr getUTPluginConfigMgr() {
        return this.mUTPluginConfigMgr;
    }

    @Deprecated
    public synchronized void registerPlugin(UTPlugin uTPlugin) {
        this.mUTPluginConfigMgr.registerPlugin(uTPlugin);
    }

    public synchronized void unregisterPlugin(UTPlugin uTPlugin) {
        this.mUTPluginConfigMgr.unregisterPlugin(uTPlugin);
    }

    public synchronized void registerPlugin(UTPlugin uTPlugin, boolean z, List<String> list, List<String> list2) {
        if (uTPlugin == null) {
            Logger.i(TAG, "registerPlugin listener is null");
        } else if (TextUtils.isEmpty(uTPlugin.getPluginName())) {
            Logger.i(TAG, "registerPlugin listenerName is null");
        } else {
            uTPlugin.setUTPluginParam(false, z, list, list2);
            registerPlugin(uTPlugin);
        }
    }
}
