package com.youku.live.dsl.config;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IConfigImp implements IConfig {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_LOCALCONFIG_APPKEY = "appkey";
    public static final String KEY_LOCALCONFIG_IMMERSE = "immerse";
    public static final String KEY_LOCALCONFIG_PID = "pid";
    public static final String NAMESPACE_LOCALCONFIG = "localconfig";
    public static final String NAMESPACE_LOCALCONFIG_PAY = "localconfig_pay";
    public static final String VALUE_0 = "0";
    public static final String VALUE_1 = "1";
    private boolean withOutStatusBar = false;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class NameSpacePay {
        public static final String KEY_WEICHAT_APP_ID = "key_wechat_app_id";
    }

    @Override // com.youku.live.dsl.config.IConfig
    public String getString(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1785865087")) {
            return (String) ipChange.ipc$dispatch("-1785865087", new Object[]{this, str, str2, str3});
        }
        if (NAMESPACE_LOCALCONFIG.equals(str)) {
            return KEY_LOCALCONFIG_IMMERSE.equals(str2) ? "0" : "appkey".equals(str2) ? AppConfig.c() : str3;
        }
        return OrangeConfig.getInstance().getConfig(str, str2, str3);
    }
}
