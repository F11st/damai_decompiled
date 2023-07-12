package com.alibaba.analytics.core.config;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;

/* compiled from: Taobao */
/* renamed from: com.alibaba.analytics.core.config.b */
/* loaded from: classes5.dex */
public class C3109b implements SystemConfigMgr.IKVChangeListener {
    public static final String KEY = "disable_ut_debug";
    private static boolean a;

    public C3109b() {
        b(SystemConfigMgr.i().h(KEY));
    }

    public static boolean a() {
        return a;
    }

    private void b(String str) {
        Logger.f("DisableUtDebugConfigListener", "parseConfig value", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("1".equalsIgnoreCase(str)) {
            a = true;
        } else {
            a = false;
        }
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        b(str2);
    }
}
