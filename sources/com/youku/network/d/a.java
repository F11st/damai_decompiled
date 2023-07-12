package com.youku.network.d;

import android.text.TextUtils;
import com.taobao.orange.OrangeConfig;
import com.youku.network.config.YKNetworkConfig;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class a {
    private static ConcurrentHashMap<String, C0396a> a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.network.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0396a {
        double a;
        YKNetworkConfig.CallType b;

        private C0396a() {
        }
    }

    private static YKNetworkConfig.CallType a(String str, double d, YKNetworkConfig.CallType callType) {
        C0396a c0396a = a.get(str);
        if (c0396a == null) {
            c0396a = new C0396a();
        } else if (com.youku.d.b.a.a(c0396a.a, d, 1.0E-6d)) {
            return c0396a.b;
        }
        c0396a.a = d;
        boolean z = false;
        try {
            z = com.youku.d.a.a.a(str, d);
        } catch (Exception e) {
            e.printStackTrace();
            com.youku.httpcommunication.a.c("CallRuleStrategy", "RuleSwitcher switchHit error");
        }
        if (z) {
            c0396a.b = YKNetworkConfig.CallType.MTOP;
        } else {
            c0396a.b = callType;
        }
        a.put(str, c0396a);
        return c0396a.b;
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
            com.youku.httpcommunication.a.c("CallRuleStrategy", "orange error");
        }
        return a(str, d, callType);
    }
}
