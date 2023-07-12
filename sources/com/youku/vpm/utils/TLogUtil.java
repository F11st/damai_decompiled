package com.youku.vpm.utils;

import com.youku.media.arch.instruments.utils.RemoteLogger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TLogUtil {
    public static void loge(String str, String str2) {
        RemoteLogger.log(str, str2);
    }

    public static void vpmLog(String str) {
        RemoteLogger.log("[KeyFlow][VPM]", str);
    }
}
