package com.alibaba.wireless.security.aopsdk.replace.android.location;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class Location {
    public static double getAltitude(android.location.Location location) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return location.getAltitude();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Location_getAltitude, location, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    double altitude = location.getAltitude();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(Double.valueOf(altitude));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Double) bridge.resultBridge(invocation)).doubleValue();
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            double altitude2 = location.getAltitude();
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

    public static double getLatitude(android.location.Location location) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return location.getLatitude();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Location_getLatitude, location, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    double latitude = location.getLatitude();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(Double.valueOf(latitude));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Double) bridge.resultBridge(invocation)).doubleValue();
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            double latitude2 = location.getLatitude();
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

    public static double getLongitude(android.location.Location location) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return location.getLongitude();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Location_getLongitude, location, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    double longitude = location.getLongitude();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(Double.valueOf(longitude));
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return ((Double) bridge.resultBridge(invocation)).doubleValue();
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            double longitude2 = location.getLongitude();
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
