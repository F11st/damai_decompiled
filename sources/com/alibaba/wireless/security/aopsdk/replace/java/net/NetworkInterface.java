package com.alibaba.wireless.security.aopsdk.replace.java.net;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class NetworkInterface {
    public static byte[] getHardwareAddress(java.net.NetworkInterface networkInterface) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return networkInterface.getHardwareAddress();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.NetworkInterface_getHardwareAddress, networkInterface, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(hardwareAddress);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (byte[]) bridge.resultBridge(invocation);
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            byte[] hardwareAddress2 = networkInterface.getHardwareAddress();
        } catch (Throwable th2) {
            try {
                throw th2;
            } finally {
                if (bridge.getTp()) {
                    invocation.invokeTimeCost = (System.nanoTime() - nanoTime2) / 1000;
                    bridge.reportTimeCost(invocation);
                }
            }
        }
    }
}
