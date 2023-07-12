package com.alibaba.wireless.security.aopsdk.replace.android.content.pm;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import java.util.List;

/* loaded from: classes.dex */
public class PackageManager {
    public static List getInstalledApplications(android.content.pm.PackageManager packageManager, int i) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return packageManager.getInstalledApplications(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.PackageManager_getInstalledApplications_int, packageManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(argI);
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
            List<ApplicationInfo> installedApplications2 = packageManager.getInstalledApplications(i);
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

    public static List getInstalledPackages(android.content.pm.PackageManager packageManager, int i) throws Throwable {
        if (!ConfigManager.getInstance().isEnabled()) {
            return packageManager.getInstalledPackages(i);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.PackageManager_getInstalledPackages_int, packageManager, Integer.valueOf(i));
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    int argI = invocation.getArgI(0);
                    long nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    List<PackageInfo> installedPackages = packageManager.getInstalledPackages(argI);
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
            List<PackageInfo> installedPackages2 = packageManager.getInstalledPackages(i);
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
