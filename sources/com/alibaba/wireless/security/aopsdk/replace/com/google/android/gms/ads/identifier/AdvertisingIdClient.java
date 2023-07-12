package com.alibaba.wireless.security.aopsdk.replace.com.google.android.gms.ads.identifier;

import android.content.Context;
import com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* loaded from: classes.dex */
public class AdvertisingIdClient {
    public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context context) throws Throwable {
        long nanoTime;
        if (!ConfigManager.getInstance().isEnabled()) {
            return com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(context);
        }
        Invocation invocation = new Invocation(PrivacyDoubleList.Methods.AdvertisingIdClient_getAdvertisingIdInfo_Context, null, context);
        AopBridge bridge = AopManager.getInstance().getBridge();
        if (bridge.callBeforeBridge(invocation)) {
            if (!invocation.shouldBlock()) {
                try {
                    Context context2 = (Context) invocation.getArgL(0);
                    nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
                    AdvertisingIdClient.Info advertisingIdInfo = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(context2);
                    if (bridge.getTp()) {
                        invocation.invokeTimeCost = (System.nanoTime() - nanoTime) / 1000;
                    }
                    invocation.setResult(advertisingIdInfo);
                } catch (Throwable th) {
                    invocation.setThrowable(th);
                }
            }
            bridge.callAfterBridge(invocation);
            if (bridge.getTp()) {
                bridge.reportTimeCost(invocation);
            }
            return (AdvertisingIdClient.Info) bridge.resultBridge(invocation);
        }
        nanoTime = bridge.getTp() ? System.nanoTime() : 0L;
        try {
            AdvertisingIdClient.Info advertisingIdInfo2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(context);
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
