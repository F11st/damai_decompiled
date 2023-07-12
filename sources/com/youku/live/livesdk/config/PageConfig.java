package com.youku.live.livesdk.config;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.config.page.RequiresSDK;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PageConfig extends RemoteConfig {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ORANGE_NAMESPACE = "YKLiveRoom_ABTest";
    private static PageConfig sInstance;

    private PageConfig() {
        super("YKLiveRoom_ABTest");
    }

    public static PageConfig getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1053466725")) {
            return (PageConfig) ipChange.ipc$dispatch("-1053466725", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (PageConfig.class) {
                if (sInstance == null) {
                    sInstance = new PageConfig();
                }
            }
        }
        return sInstance;
    }

    public RequiresSDK getRequiresSDK(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1652777851")) {
            return (RequiresSDK) ipChange.ipc$dispatch("-1652777851", new Object[]{this, str});
        }
        RequiresSDK requiresSDK = new RequiresSDK();
        if (!TextUtils.isEmpty(str)) {
            requiresSDK.setRemoteConfig(getString("pageRequireSDK_" + str, RequiresSDK.VALUE_DEFAULT));
        }
        return requiresSDK;
    }
}
