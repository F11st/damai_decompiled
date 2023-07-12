package com.alibaba.analytics.core.config;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;

/* compiled from: Taobao */
@Deprecated
/* renamed from: com.alibaba.analytics.core.config.a */
/* loaded from: classes5.dex */
public class C3108a implements SystemConfigMgr.IKVChangeListener {
    public static final String KEY = "sw_plugin";

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        if (KEY.equalsIgnoreCase(str)) {
            boolean z = false;
            try {
                z = Boolean.parseBoolean(str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                Variables.n().o0();
            }
        }
    }
}
