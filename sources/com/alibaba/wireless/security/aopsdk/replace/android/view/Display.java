package com.alibaba.wireless.security.aopsdk.replace.android.view;

import android.graphics.Point;
import android.util.DisplayMetrics;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class Display {
    public static void getMetrics(android.view.Display display, DisplayMetrics displayMetrics) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            display.getMetrics(displayMetrics);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Display_getMetrics_DisplayMetrics, display, displayMetrics);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    DisplayMetrics displayMetrics2 = (DisplayMetrics) invocation.getArgL(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    display.getMetrics(displayMetrics2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            display.getMetrics(displayMetrics);
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

    public static void getRealMetrics(android.view.Display display, DisplayMetrics displayMetrics) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            display.getRealMetrics(displayMetrics);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Display_getRealMetrics_DisplayMetrics, display, displayMetrics);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    DisplayMetrics displayMetrics2 = (DisplayMetrics) invocation.getArgL(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    display.getRealMetrics(displayMetrics2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            display.getRealMetrics(displayMetrics);
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

    public static void getRealSize(android.view.Display display, Point point) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            display.getRealSize(point);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Display_getRealSize_Point, display, point);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Point point2 = (Point) invocation.getArgL(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    display.getRealSize(point2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            display.getRealSize(point);
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

    public static void getSize(android.view.Display display, Point point) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            display.getSize(point);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Display_getSize_Point, display, point);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Point point2 = (Point) invocation.getArgL(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    display.getSize(point2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(null);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            bridge.resultBridgeV(invocation);
            return;
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            display.getSize(point);
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
