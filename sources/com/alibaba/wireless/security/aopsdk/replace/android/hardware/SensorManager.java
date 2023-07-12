package com.alibaba.wireless.security.aopsdk.replace.android.hardware;

import android.hardware.Sensor;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class SensorManager {
    public static Sensor getDefaultSensor(android.hardware.SensorManager sensorManager, int i) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return sensorManager.getDefaultSensor(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.SensorManager_getDefaultSensor_int, sensorManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    Sensor defaultSensor = sensorManager.getDefaultSensor(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(defaultSensor);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (Sensor) bridge.resultBridge(invocation);
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(i);
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

    public static Sensor getDefaultSensor(android.hardware.SensorManager sensorManager, int i, boolean z) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return sensorManager.getDefaultSensor(i, z);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.SensorManager_getDefaultSensor_int_boolean, sensorManager, Integer.valueOf(i), Boolean.valueOf(z));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    boolean argZ = invocation.getArgZ(1);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    Sensor defaultSensor = sensorManager.getDefaultSensor(argI, argZ);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(defaultSensor);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (Sensor) bridge.resultBridge(invocation);
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(i, z);
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
