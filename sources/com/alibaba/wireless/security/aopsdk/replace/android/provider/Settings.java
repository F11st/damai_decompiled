package com.alibaba.wireless.security.aopsdk.replace.android.provider;

import android.content.ContentResolver;
import android.provider.Settings;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;

/* loaded from: classes.dex */
public class Settings {

    /* loaded from: classes.dex */
    public static class Secure {
        public static String getString(ContentResolver contentResolver, String str) throws Throwable {
            long nanoTime;
            if (!ConfigManager.getInstance().isEnabled()) {
                return Settings.Secure.getString(contentResolver, str);
            }
            Invocation invocation = new Invocation(PrivacyDoubleList.Methods.Settings_Secure_getString_ContentResolver_String, null, contentResolver, str);
            AopBridge bridge = AopManager.getInstance().getBridge();
            if (bridge.callBeforeBridge(invocation)) {
                if (!invocation.shouldBlock()) {
                    try {
                        ContentResolver contentResolver2 = (ContentResolver) invocation.getArgL(0);
                        String str2 = (String) invocation.getArgL(1);
                        nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                        String string = Settings.Secure.getString(contentResolver2, str2);
                        if (bridge.getTp()) {
                            invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                        }
                        invocation.setResult(string);
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
            nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
            try {
                String string2 = Settings.Secure.getString(contentResolver, str);
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
    }
}
