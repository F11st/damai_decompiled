package com.alibaba.wireless.security.open.securityguardaccsadapter.usertrack;

import com.ut.mini.module.plugin.UTPluginMgr;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UserTrackAdaptor {
    private static final boolean DEBUG = false;
    private static final String TAG = "UserTrackAdaptor";

    public static void registerListener(IUserTrackPlugin iUserTrackPlugin) {
        if (iUserTrackPlugin != null) {
            UTPluginMgr.getInstance().registerPlugin(new UserTrackPlugin(iUserTrackPlugin));
        }
    }
}
