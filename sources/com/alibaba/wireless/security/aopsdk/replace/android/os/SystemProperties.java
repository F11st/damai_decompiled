package com.alibaba.wireless.security.aopsdk.replace.android.os;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class SystemProperties {
    public static String get(String str) throws Throwable {
        long nanoTime;
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.SystemProperties.get(str);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.SystemProperties_get_String, null, str);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String str3 = android.os.SystemProperties.get(str2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(str3);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (String) bridge.resultBridge(invocation);
        }
        nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String str4 = android.os.SystemProperties.get(str);
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
                if (bridge.getTp()) {
                    invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    bridge.reportTimeCost(invocation);
                }
            }
        }
    }
}
