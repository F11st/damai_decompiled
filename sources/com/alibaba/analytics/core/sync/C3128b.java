package com.alibaba.analytics.core.sync;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.utils.Logger;

/* compiled from: Taobao */
/* renamed from: com.alibaba.analytics.core.sync.b */
/* loaded from: classes5.dex */
class C3128b implements SystemConfigMgr.IKVChangeListener {
    private static C3128b b;
    private boolean a = false;

    private C3128b() {
        c(SystemConfigMgr.i().h("ut_sample_nw"));
        SystemConfigMgr.i().l("ut_sample_nw", this);
    }

    public static synchronized C3128b a() {
        C3128b c3128b;
        synchronized (C3128b.class) {
            if (b == null) {
                b = new C3128b();
            }
            c3128b = b;
        }
        return c3128b;
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
