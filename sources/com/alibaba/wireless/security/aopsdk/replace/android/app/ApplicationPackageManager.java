package com.alibaba.wireless.security.aopsdk.replace.android.app;

import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.List;

/* loaded from: classes.dex */
public class ApplicationPackageManager {
    public static List getInstalledApplications(android.app.ApplicationPackageManager applicationPackageManager, int i) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return applicationPackageManager.getInstalledApplications(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.ApplicationPackageManager_getInstalledApplications_int, applicationPackageManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    List installedApplications = applicationPackageManager.getInstalledApplications(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(installedApplications);
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
            List installedApplications2 = applicationPackageManager.getInstalledApplications(i);
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

    public static List getInstalledPackages(android.app.ApplicationPackageManager applicationPackageManager, int i) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return applicationPackageManager.getInstalledPackages(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.ApplicationPackageManager_getInstalledPackages_int, applicationPackageManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    List installedPackages = applicationPackageManager.getInstalledPackages(argI);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(installedPackages);
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
            List installedPackages2 = applicationPackageManager.getInstalledPackages(i);
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
