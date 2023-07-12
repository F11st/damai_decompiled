package com.alibaba.wireless.security.aopsdk.replace.android.location;

import android.app.PendingIntent;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationRequest;
import android.os.CancellationSignal;
import android.os.Looper;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class LocationManager {
    public static void getCurrentLocation(android.location.LocationManager locationManager, String str, LocationRequest locationRequest, CancellationSignal cancellationSignal, Executor executor, Consumer consumer) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.getCurrentLocation(str, locationRequest, cancellationSignal, executor, consumer);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_getCurrentLocation_String_LocationRequest_CancellationSignal_Executor_Consumer, locationManager, str, locationRequest, cancellationSignal, executor, consumer);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    LocationRequest locationRequest2 = (LocationRequest) invocation.getArgL(1);
                    CancellationSignal cancellationSignal2 = (CancellationSignal) invocation.getArgL(2);
                    Executor executor2 = (Executor) invocation.getArgL(3);
                    Consumer<android.location.Location> consumer2 = (Consumer) invocation.getArgL(4);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.getCurrentLocation(str2, locationRequest2, cancellationSignal2, executor2, consumer2);
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
            locationManager.getCurrentLocation(str, locationRequest, cancellationSignal, executor, consumer);
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

    public static android.location.Location getLastKnownLocation(android.location.LocationManager locationManager, String str) throws Throwable {
        long nanoTime;
        if (!ConfigManager.getInstance().isEnabled()) {
            return locationManager.getLastKnownLocation(str);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_getLastKnownLocation_String, locationManager, str);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    android.location.Location lastKnownLocation = locationManager.getLastKnownLocation(str2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(lastKnownLocation);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (android.location.Location) bridge.resultBridge(invocation);
        }
        nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            android.location.Location lastKnownLocation2 = locationManager.getLastKnownLocation(str);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, long j, float f, Criteria criteria, PendingIntent pendingIntent) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(j, f, criteria, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_long_float_Criteria_PendingIntent, locationManager, Long.valueOf(j), Float.valueOf(f), criteria, pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long argJ = invocation.getArgJ(0);
                    float argF = invocation.getArgF(1);
                    Criteria criteria2 = (Criteria) invocation.getArgL(2);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(3);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(argJ, argF, criteria2, pendingIntent2);
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
            locationManager.requestLocationUpdates(j, f, criteria, pendingIntent);
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

    public static void requestSingleUpdate(android.location.LocationManager locationManager, Criteria criteria, PendingIntent pendingIntent) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestSingleUpdate(criteria, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestSingleUpdate_Criteria_PendingIntent, locationManager, criteria, pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Criteria criteria2 = (Criteria) invocation.getArgL(0);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(1);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestSingleUpdate(criteria2, pendingIntent2);
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
            locationManager.requestSingleUpdate(criteria, pendingIntent);
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

    public static void requestSingleUpdate(android.location.LocationManager locationManager, Criteria criteria, LocationListener locationListener, Looper looper) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestSingleUpdate(criteria, locationListener, looper);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestSingleUpdate_Criteria_LocationListener_Looper, locationManager, criteria, locationListener, looper);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Criteria criteria2 = (Criteria) invocation.getArgL(0);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(1);
                    Looper looper2 = (Looper) invocation.getArgL(2);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestSingleUpdate(criteria2, locationListener2, looper2);
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
            locationManager.requestSingleUpdate(criteria, locationListener, looper);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, long j, float f, Criteria criteria, LocationListener locationListener, Looper looper) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(j, f, criteria, locationListener, looper);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_long_float_Criteria_LocationListener_Looper, locationManager, Long.valueOf(j), Float.valueOf(f), criteria, locationListener, looper);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long argJ = invocation.getArgJ(0);
                    float argF = invocation.getArgF(1);
                    Criteria criteria2 = (Criteria) invocation.getArgL(2);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(3);
                    Looper looper2 = (Looper) invocation.getArgL(4);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(argJ, argF, criteria2, locationListener2, looper2);
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
            locationManager.requestLocationUpdates(j, f, criteria, locationListener, looper);
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

    public static void getCurrentLocation(android.location.LocationManager locationManager, String str, CancellationSignal cancellationSignal, Executor executor, Consumer consumer) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.getCurrentLocation(str, cancellationSignal, executor, consumer);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_getCurrentLocation_String_CancellationSignal_Executor_Consumer, locationManager, str, cancellationSignal, executor, consumer);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    CancellationSignal cancellationSignal2 = (CancellationSignal) invocation.getArgL(1);
                    Executor executor2 = (Executor) invocation.getArgL(2);
                    Consumer<android.location.Location> consumer2 = (Consumer) invocation.getArgL(3);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.getCurrentLocation(str2, cancellationSignal2, executor2, consumer2);
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
            locationManager.getCurrentLocation(str, cancellationSignal, executor, consumer);
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

    public static void requestSingleUpdate(android.location.LocationManager locationManager, String str, PendingIntent pendingIntent) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestSingleUpdate(str, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestSingleUpdate_String_PendingIntent, locationManager, str, pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(1);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestSingleUpdate(str2, pendingIntent2);
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
            locationManager.requestSingleUpdate(str, pendingIntent);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, long j, float f, Criteria criteria, Executor executor, LocationListener locationListener) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(j, f, criteria, executor, locationListener);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_long_float_Criteria_Executor_LocationListener, locationManager, Long.valueOf(j), Float.valueOf(f), criteria, executor, locationListener);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long argJ = invocation.getArgJ(0);
                    float argF = invocation.getArgF(1);
                    Criteria criteria2 = (Criteria) invocation.getArgL(2);
                    Executor executor2 = (Executor) invocation.getArgL(3);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(4);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(argJ, argF, criteria2, executor2, locationListener2);
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
            locationManager.requestLocationUpdates(j, f, criteria, executor, locationListener);
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

    public static void requestSingleUpdate(android.location.LocationManager locationManager, String str, LocationListener locationListener, Looper looper) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestSingleUpdate(str, locationListener, looper);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestSingleUpdate_String_LocationListener_Looper, locationManager, str, locationListener, looper);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(1);
                    Looper looper2 = (Looper) invocation.getArgL(2);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestSingleUpdate(str2, locationListener2, looper2);
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
            locationManager.requestSingleUpdate(str, locationListener, looper);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, long j, float f, PendingIntent pendingIntent) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, j, f, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_long_float_PendingIntent, locationManager, str, Long.valueOf(j), Float.valueOf(f), pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    long argJ = invocation.getArgJ(1);
                    float argF = invocation.getArgF(2);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(3);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(str2, argJ, argF, pendingIntent2);
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
            locationManager.requestLocationUpdates(str, j, f, pendingIntent);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, long j, float f, LocationListener locationListener) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, j, f, locationListener);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_long_float_LocationListener, locationManager, str, Long.valueOf(j), Float.valueOf(f), locationListener);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    long argJ = invocation.getArgJ(1);
                    float argF = invocation.getArgF(2);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(3);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(str2, argJ, argF, locationListener2);
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
            locationManager.requestLocationUpdates(str, j, f, locationListener);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, long j, float f, LocationListener locationListener, Looper looper) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, j, f, locationListener, looper);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_long_float_LocationListener_Looper, locationManager, str, Long.valueOf(j), Float.valueOf(f), locationListener, looper);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    long argJ = invocation.getArgJ(1);
                    float argF = invocation.getArgF(2);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(3);
                    Looper looper2 = (Looper) invocation.getArgL(4);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(str2, argJ, argF, locationListener2, looper2);
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
            locationManager.requestLocationUpdates(str, j, f, locationListener, looper);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, long j, float f, Executor executor, LocationListener locationListener) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, j, f, executor, locationListener);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_long_float_Executor_LocationListener, locationManager, str, Long.valueOf(j), Float.valueOf(f), executor, locationListener);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    long argJ = invocation.getArgJ(1);
                    float argF = invocation.getArgF(2);
                    Executor executor2 = (Executor) invocation.getArgL(3);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(4);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(str2, argJ, argF, executor2, locationListener2);
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
            locationManager.requestLocationUpdates(str, j, f, executor, locationListener);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, LocationRequest locationRequest, PendingIntent pendingIntent) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, locationRequest, pendingIntent);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_LocationRequest_PendingIntent, locationManager, str, locationRequest, pendingIntent);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    LocationRequest locationRequest2 = (LocationRequest) invocation.getArgL(1);
                    PendingIntent pendingIntent2 = (PendingIntent) invocation.getArgL(2);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(str2, locationRequest2, pendingIntent2);
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
            locationManager.requestLocationUpdates(str, locationRequest, pendingIntent);
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

    public static void requestLocationUpdates(android.location.LocationManager locationManager, String str, LocationRequest locationRequest, Executor executor, LocationListener locationListener) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
            return;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.LocationManager_requestLocationUpdates_String_LocationRequest_Executor_LocationListener, locationManager, str, locationRequest, executor, locationListener);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    String str2 = (String) invocation.getArgL(0);
                    LocationRequest locationRequest2 = (LocationRequest) invocation.getArgL(1);
                    Executor executor2 = (Executor) invocation.getArgL(2);
                    LocationListener locationListener2 = (LocationListener) invocation.getArgL(3);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    locationManager.requestLocationUpdates(str2, locationRequest2, executor2, locationListener2);
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
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
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
