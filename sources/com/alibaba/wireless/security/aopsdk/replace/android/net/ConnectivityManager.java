package com.alibaba.wireless.security.aopsdk.replace.android.net;

import android.net.NetworkInfo;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class ConnectivityManager {
    public static NetworkInfo getActiveNetworkInfo(android.net.ConnectivityManager connectivityManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return connectivityManager.getActiveNetworkInfo();
        }
        Invocation invocation = new Invocation("android.net.ConnectivityManager.getActiveNetworkInfo()", connectivityManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(activeNetworkInfo);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (NetworkInfo) bridge.resultBridge(invocation);
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            NetworkInfo activeNetworkInfo2 = connectivityManager.getActiveNetworkInfo();
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
