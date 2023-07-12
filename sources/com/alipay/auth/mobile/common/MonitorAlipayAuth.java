package com.alipay.auth.mobile.common;

import com.alipay.auth.mobile.api.IAlipayAuthMonitor;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MonitorAlipayAuth {
    private static MonitorAlipayAuth a;

    private MonitorAlipayAuth() {
    }

    public static synchronized MonitorAlipayAuth getInstance() {
        MonitorAlipayAuth monitorAlipayAuth;
        synchronized (MonitorAlipayAuth.class) {
            if (a == null) {
                a = new MonitorAlipayAuth();
            }
            monitorAlipayAuth = a;
        }
        return monitorAlipayAuth;
    }

    public void monitorAlipayAuth(IAlipayAuthMonitor iAlipayAuthMonitor, String str) {
        monitorAlipayAuth(iAlipayAuthMonitor, str, null);
    }

    public void monitorAlipayAuth(IAlipayAuthMonitor iAlipayAuthMonitor, String str, Properties properties) {
        if (iAlipayAuthMonitor != null) {
            try {
                iAlipayAuthMonitor.monitorAliayAuth(str, properties);
            } catch (Throwable th) {
                LoggerUtils.e("MonitorAlipayAuth", "monitorAlipayAuth", th);
            }
        }
    }
}
