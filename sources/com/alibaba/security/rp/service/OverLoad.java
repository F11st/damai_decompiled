package com.alibaba.security.rp.service;

import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.C3847g;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OverLoad {
    private static void collectUsingLog() {
        TrackLog createClassInvokedMonitor = TrackLog.createClassInvokedMonitor("OverLoad", "isLivenessReady");
        createClassInvokedMonitor.setVerifyToken(C3847g.C3848a.a.d);
        createClassInvokedMonitor.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        createClassInvokedMonitor.addTag10("Android");
        C3829a.C3830a.a.a(createClassInvokedMonitor);
        C3829a.C3830a.a.a(false);
    }

    public static boolean isLivenessReady() {
        collectUsingLog();
        return true;
    }
}
