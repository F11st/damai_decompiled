package com.alibaba.wireless.security.aopsdk.replace.com.alibaba.openid;

import android.content.Context;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class OpenDeviceId {
    public static String getOAID(Context context) throws Throwable {
        long nanoTime;
        if (!ConfigManager.getInstance().isEnabled()) {
            return com.alibaba.openid.OpenDeviceId.getOAID(context);
        }
        Invocation invocation = new Invocation("com.alibaba.openid.OpenDeviceId.getOAID(android.content.Context)", null, context);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Context context2 = (Context) invocation.getArgL(0);
                    nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String oaid = com.alibaba.openid.OpenDeviceId.getOAID(context2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(oaid);
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
            String oaid2 = com.alibaba.openid.OpenDeviceId.getOAID(context);
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
