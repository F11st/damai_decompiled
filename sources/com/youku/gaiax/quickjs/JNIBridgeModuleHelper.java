package com.youku.gaiax.quickjs;

import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class JNIBridgeModuleHelper {
    private static BridgeModuleListener moduleListener;

    private static long callAsync(long j, long j2, String str) {
        BridgeModuleListener bridgeModuleListener = moduleListener;
        if (bridgeModuleListener != null) {
            return bridgeModuleListener.callAsync(j, j2, str);
        }
        return -1L;
    }

    private static long callPromise(long j, String str) {
        BridgeModuleListener bridgeModuleListener = moduleListener;
        if (bridgeModuleListener != null) {
            return bridgeModuleListener.callPromise(j, str);
        }
        return -1L;
    }

    private static long callSync(long j, String str) {
        BridgeModuleListener bridgeModuleListener = moduleListener;
        if (bridgeModuleListener != null) {
            return bridgeModuleListener.callSync(j, str);
        }
        return -1L;
    }

    public static void setListener(BridgeModuleListener bridgeModuleListener) {
        moduleListener = bridgeModuleListener;
    }

    public static void wrapAsJSValueException(Exception exc) {
        BridgeModuleListener bridgeModuleListener = moduleListener;
        if (bridgeModuleListener != null) {
            bridgeModuleListener.wrapAsJSValueException(exc);
        }
    }
}
