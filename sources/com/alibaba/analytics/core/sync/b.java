package com.alibaba.analytics.core.sync;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
class b implements SystemConfigMgr.IKVChangeListener {
    private static b b;
    private boolean a = false;

    private b() {
        c(SystemConfigMgr.i().h("ut_sample_nw"));
        SystemConfigMgr.i().l("ut_sample_nw", this);
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    private void c(String str) {
        Logger.f("SampleNetworkLogListener", "ut_sample_nw", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("1".equalsIgnoreCase(str)) {
            this.a = true;
        } else {
            this.a = false;
        }
    }

    public boolean b() {
        return this.a;
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        c(str2);
    }
}
