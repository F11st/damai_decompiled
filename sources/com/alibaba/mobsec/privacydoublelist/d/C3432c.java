package com.alibaba.mobsec.privacydoublelist.d;

import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.report.PrivacyDoubleListReporter;
import com.alibaba.wireless.security.aopsdk.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.mobsec.privacydoublelist.d.c */
/* loaded from: classes6.dex */
public class C3432c implements InterfaceC3430a {
    public void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(PrivacyDoubleListReporter.UT_KEY, str);
        if (PdlEnvUtils.a) {
            Log.d("DL-UT", "Ut report");
        }
        if (C3431b.a() == 0) {
            if (C3431b.i) {
                Log.i("UTMethodJniBridge", "UserTracke is not avaiable.");
                return;
            }
            return;
        }
        try {
            Map map = (Map) C3431b.e.invoke(C3431b.d.newInstance("Page_PrivacyCompliance", 19999, BuildConfig.FLAVOR, "1.1.2", "", hashMap), new Object[0]);
            if (map != null && map.size() != 0) {
                Object invoke = C3431b.f.invoke(C3431b.c, new Object[0]);
                if (invoke == null) {
                    if (C3431b.i) {
                        Log.i("UTMethodJniBridge", "Fail to create call getInstance.");
                    }
                } else {
                    Object invoke2 = C3431b.g.invoke(invoke, "DoubleList");
                    if (invoke2 == null) {
                        if (C3431b.i) {
                            Log.i("UTMethodJniBridge", "Fail to create call getDefaultTracker.");
                        }
                    } else {
                        C3431b.h.invoke(invoke2, map);
                    }
                }
            }
            if (C3431b.i) {
                Log.i("UTMethodJniBridge", "Fail to create call build method.");
            }
        } catch (Exception e) {
            if (C3431b.i) {
                Log.e("UTMethodJniBridge", e.toString(), e);
            }
        }
    }
}
