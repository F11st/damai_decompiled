package com.alibaba.wireless.security.aopsdk.replace.android.util;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class DisplayMetrics {
    public static int getheightPixels(android.util.DisplayMetrics displayMetrics) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return displayMetrics.heightPixels;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.DisplayMetrics_getheightPixels, displayMetrics, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    int i = displayMetrics.heightPixels;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(i));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Integer) bridge.resultBridge(invocation)).intValue();
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            int i2 = displayMetrics.heightPixels;
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

    public static int getwidthPixels(android.util.DisplayMetrics displayMetrics) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return displayMetrics.widthPixels;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.DisplayMetrics_getwidthPixels, displayMetrics, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    int i = displayMetrics.widthPixels;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(i));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Integer) bridge.resultBridge(invocation)).intValue();
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            int i2 = displayMetrics.widthPixels;
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
