package com.alibaba.wireless.security.aopsdk.replace.android.view;

import android.graphics.Rect;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class WindowMetrics {
    public static Rect getBounds(android.view.WindowMetrics windowMetrics) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return windowMetrics.getBounds();
        }
        Invocation invocation = new Invocation("android.view.WindowMetrics.getBounds()", windowMetrics, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    Rect bounds = windowMetrics.getBounds();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(bounds);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (Rect) bridge.resultBridge(invocation);
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            Rect bounds2 = windowMetrics.getBounds();
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
