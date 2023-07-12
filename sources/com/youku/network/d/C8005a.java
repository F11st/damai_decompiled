package com.youku.network.d;

import android.text.TextUtils;
import com.taobao.orange.OrangeConfig;
import com.youku.d.a.C7899a;
import com.youku.d.b.C7900a;
import com.youku.httpcommunication.C7924a;
import com.youku.network.config.YKNetworkConfig;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.youku.network.d.a */
/* loaded from: classes13.dex */
public class C8005a {
    private static ConcurrentHashMap<String, C8006a> a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.network.d.a$a */
    /* loaded from: classes13.dex */
    public static class C8006a {
        double a;
        YKNetworkConfig.CallType b;

        private C8006a() {
        }
    }

    private static YKNetworkConfig.CallType a(String str, double d, YKNetworkConfig.CallType callType) {
        C8006a c8006a = a.get(str);
        if (c8006a == null) {
            c8006a = new C8006a();
        } else if (C7900a.a(c8006a.a, d, 1.0E-6d)) {
            return c8006a.b;
        }
        c8006a.a = d;
        boolean z = false;
        try {
            z = C7899a.a(str, d);
        } catch (Exception e) {
            e.printStackTrace();
            C7924a.c("CallRuleStrategy", "RuleSwitcher switchHit error");
        }
        if (z) {
            c8006a.b = YKNetworkConfig.CallType.MTOP;
        } else {
            c8006a.b = callType;
        }
        a.put(str, c8006a);
        return c8006a.b;
    }

    public static YKNetworkConfig.CallType a(String str, YKNetworkConfig.CallType callType) {
        if (TextUtils.isEmpty(str)) {
            return callType;
        }
        double d = 0.0d;
        try {
            d = Double.parseDouble(OrangeConfig.getInstance().getConfig(str, "percentage", "0"));
        } catch (Exception e) {
            e.getMessage();
            C7924a.c("CallRuleStrategy", "orange error");
        }
        return a(str, d, callType);
    }
}
