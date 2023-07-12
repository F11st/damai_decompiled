package com.alibaba.wireless.security.aopsdk.replace.android.telephony;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.List;

/* loaded from: classes.dex */
public class TelephonyManager {
    public static List getAllCellInfo(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getAllCellInfo();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getAllCellInfo, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(allCellInfo);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (List) bridge.resultBridge(invocation);
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            List<CellInfo> allCellInfo2 = telephonyManager.getAllCellInfo();
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

    public static CellLocation getCellLocation(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getCellLocation();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getCellLocation, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(cellLocation);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (CellLocation) bridge.resultBridge(invocation);
        }
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            CellLocation cellLocation2 = telephonyManager.getCellLocation();
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

    public static int getDataNetworkType(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getDataNetworkType();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getDataNetworkType, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    int dataNetworkType = telephonyManager.getDataNetworkType();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(dataNetworkType));
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
            int dataNetworkType2 = telephonyManager.getDataNetworkType();
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

    public static String getDeviceId(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getDeviceId();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getDeviceId, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String deviceId = telephonyManager.getDeviceId();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(deviceId);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String deviceId2 = telephonyManager.getDeviceId();
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

    public static String getImei(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getImei();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getImei, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String imei = telephonyManager.getImei();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(imei);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String imei2 = telephonyManager.getImei();
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

    public static String getMeid(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getMeid();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getMeid, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String meid = telephonyManager.getMeid();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(meid);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String meid2 = telephonyManager.getMeid();
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

    public static int getNetworkType(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getNetworkType();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getNetworkType, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    int networkType = telephonyManager.getNetworkType();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(Integer.valueOf(networkType));
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
            int networkType2 = telephonyManager.getNetworkType();
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

    public static String getSimOperator(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getSimOperator();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getSimOperator, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String simOperator = telephonyManager.getSimOperator();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(simOperator);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String simOperator2 = telephonyManager.getSimOperator();
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

    public static String getSimOperatorName(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getSimOperatorName();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getSimOperatorName, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String simOperatorName = telephonyManager.getSimOperatorName();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(simOperatorName);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String simOperatorName2 = telephonyManager.getSimOperatorName();
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

    public static String getSimSerialNumber(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getSimSerialNumber();
        }
        Invocation invocation = new Invocation("android.telephony.TelephonyManager.getSimSerialNumber()", telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String simSerialNumber = telephonyManager.getSimSerialNumber();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(simSerialNumber);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String simSerialNumber2 = telephonyManager.getSimSerialNumber();
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

    public static String getSubscriberId(android.telephony.TelephonyManager telephonyManager) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getSubscriberId();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getSubscriberId, telephonyManager, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String subscriberId = telephonyManager.getSubscriberId();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(subscriberId);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String subscriberId2 = telephonyManager.getSubscriberId();
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

    public static String getDeviceId(android.telephony.TelephonyManager telephonyManager, int i) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getDeviceId(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getDeviceId_int, telephonyManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String deviceId = telephonyManager.getDeviceId(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(deviceId);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String deviceId2 = telephonyManager.getDeviceId(i);
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

    public static String getImei(android.telephony.TelephonyManager telephonyManager, int i) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getImei(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getImei_int, telephonyManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String imei = telephonyManager.getImei(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(imei);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String imei2 = telephonyManager.getImei(i);
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

    public static String getMeid(android.telephony.TelephonyManager telephonyManager, int i) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return telephonyManager.getMeid(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.TelephonyManager_getMeid_int, telephonyManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String meid = telephonyManager.getMeid(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(meid);
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
        long nanoTime2 = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            String meid2 = telephonyManager.getMeid(i);
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
