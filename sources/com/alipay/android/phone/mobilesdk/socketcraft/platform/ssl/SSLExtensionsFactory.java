package com.alipay.android.phone.mobilesdk.socketcraft.platform.ssl;

import com.alipay.android.phone.mobilesdk.socketcraft.integrated.ssl.MPaaSSSLExtensions;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SSLExtensionsFactory {
    private static SSLExtensions a;

    public static final SSLExtensions getInstance() {
        SSLExtensions sSLExtensions = a;
        if (sSLExtensions != null) {
            return sSLExtensions;
        }
        synchronized (SSLExtensions.class) {
            if (PlatformUtil.isAndroidMPaaSPlatform()) {
                a = (SSLExtensions) MPaaSSSLExtensions.class.newInstance();
                SCLogCatUtil.info("SSLExtensionsFactory", String.format("New instance ok, class: %s", "com.alipay.android.phone.mobilesdk.socketcraft.integrated.ssl.MPaaSSSLExtensions"));
            }
            if (a == null) {
                a = new DefaultSSLExtensions();
            }
        }
        return a;
    }
}
