package com.alibaba.wireless.security.open.securityguardaccsadapter.usertrack;

import com.ut.mini.module.plugin.UTPlugin;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UserTrackPlugin extends UTPlugin {
    private static final boolean DEBUG = false;
    private static final String TAG = "UserTrackPlugin";
    private final IUserTrackPlugin mUserTrackPlugin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserTrackPlugin(IUserTrackPlugin iUserTrackPlugin) {
        this.mUserTrackPlugin = iUserTrackPlugin;
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    public int[] getAttentionEventIds() {
        return this.mUserTrackPlugin.getAttentionEventIds();
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    public String getPluginName() {
        return this.mUserTrackPlugin.getPluginName();
    }

    @Override // com.ut.mini.module.plugin.UTPlugin
    public Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4) {
        return this.mUserTrackPlugin.onEventDispatch(str, i, str2, str3, str4);
    }
}
