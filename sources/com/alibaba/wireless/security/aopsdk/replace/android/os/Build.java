package com.alibaba.wireless.security.aopsdk.replace.android.os;

import android.os.Build;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class Build {

    /* loaded from: classes.dex */
    public static class VERSION {
        public static String getRELEASE() throws Throwable {
            if (!ConfigManager.getInstance().isEnabled()) {
                return Build.VERSION.RELEASE;
            }
            Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_VERSION_getRELEASE, null, new Object[0]);
            AopBridge bridge = AopManager.getInstance().getBridge();
            if (bridge.callBeforeBridge(invocation)) {
                if (!invocation.shouldBlock()) {
                    try {
                        long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                        String str = Build.VERSION.RELEASE;
                        if (bridge.getTp()) {
                            invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                        }
                        invocation.setResult(str);
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
                String str2 = Build.VERSION.RELEASE;
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

        public static String getRELEASE_OR_CODENAME() throws Throwable {
            if (!ConfigManager.getInstance().isEnabled()) {
                return Build.VERSION.RELEASE_OR_CODENAME;
            }
            Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_VERSION_getRELEASE_OR_CODENAME, null, new Object[0]);
            AopBridge bridge = AopManager.getInstance().getBridge();
            if (bridge.callBeforeBridge(invocation)) {
                if (!invocation.shouldBlock()) {
                    try {
                        long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                        String str = Build.VERSION.RELEASE_OR_CODENAME;
                        if (bridge.getTp()) {
                            invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                        }
                        invocation.setResult(str);
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
                String str2 = Build.VERSION.RELEASE_OR_CODENAME;
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

    public static String getBRAND() throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.BRAND;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getBRAND, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String str = android.os.Build.BRAND;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(str);
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
            String str2 = android.os.Build.BRAND;
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

    public static String getCPU_ABI() throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.CPU_ABI;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getCPU_ABI, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String str = android.os.Build.CPU_ABI;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(str);
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
            String str2 = android.os.Build.CPU_ABI;
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

    public static String getMANUFACTURER() throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.MANUFACTURER;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getMANUFACTURER, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String str = android.os.Build.MANUFACTURER;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(str);
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
            String str2 = android.os.Build.MANUFACTURER;
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

    public static String getMODEL() throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.MODEL;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getMODEL, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String str = android.os.Build.MODEL;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(str);
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
            String str2 = android.os.Build.MODEL;
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

    public static String getPRODUCT() throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.PRODUCT;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getPRODUCT, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String str = android.os.Build.PRODUCT;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(str);
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
            String str2 = android.os.Build.PRODUCT;
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

    public static String getSERIAL() throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.SERIAL;
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Fields.Build_getSERIAL, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String str = android.os.Build.SERIAL;
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(str);
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
            String str2 = android.os.Build.SERIAL;
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

    public static String getSerial() throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return android.os.Build.getSerial();
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Build_getSerial, null, new Object[0]);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    String serial = android.os.Build.getSerial();
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(serial);
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
            String serial2 = android.os.Build.getSerial();
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
