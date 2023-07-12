package com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool;

import com.alipay.android.phone.mobilesdk.socketcraft.integrated.threadpool.MPaaSNetworkAsyncTaskExecutor;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.PlatformUtil;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SCNetworkAsyncTaskExecutorFactory {
    private static SCNetworkAsyncTaskExecutor a;

    public static final SCNetworkAsyncTaskExecutor getInstance() {
        SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor = a;
        if (sCNetworkAsyncTaskExecutor != null) {
            return sCNetworkAsyncTaskExecutor;
        }
        synchronized (SCNetworkAsyncTaskExecutorFactory.class) {
            SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor2 = a;
            if (sCNetworkAsyncTaskExecutor2 != null) {
                return sCNetworkAsyncTaskExecutor2;
            }
            if (PlatformUtil.isAndroidMPaaSPlatform()) {
                SCNetworkAsyncTaskExecutor sCNetworkAsyncTaskExecutor3 = (SCNetworkAsyncTaskExecutor) MPaaSNetworkAsyncTaskExecutor.class.newInstance();
                a = sCNetworkAsyncTaskExecutor3;
                return sCNetworkAsyncTaskExecutor3;
            }
            if (a == null) {
                a = new DefaultSCNetworkAsyncTaskExecutor();
            }
            return a;
        }
    }
}
