package com.alibaba.wireless.security.open.securityguardaccsadapter.usertrack;

import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IUserTrackPlugin {
    int[] getAttentionEventIds();

    String getPluginName();

    Map<String, String> onEventDispatch(String str, int i, String str2, String str3, String str4);
}
