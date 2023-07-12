package com.alibaba.analytics.core.config;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.extend.UTExtendSwitch;

/* compiled from: Taobao */
/* renamed from: com.alibaba.analytics.core.config.f */
/* loaded from: classes5.dex */
public class C3115f implements SystemConfigMgr.IKVChangeListener {
    public static final String KEY = "xmodule";
    private static boolean a = true;

    public C3115f() {
        b(SystemConfigMgr.i().h(KEY));
    }

    public static boolean a() {
        return UTExtendSwitch.bXmodule && a;
    }

    private void b(String str) {
        Logger.f("XmoduleConfigListener", "parseConfig value", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("0".equalsIgnoreCase(str)) {
            a = false;
        } else {
            a = true;
        }
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        b(str2);
    }
}
