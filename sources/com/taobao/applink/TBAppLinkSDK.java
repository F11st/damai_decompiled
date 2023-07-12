package com.taobao.applink;

import tb.sj2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TBAppLinkSDK {
    private static volatile TBAppLinkSDK b;
    public sj2 a;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum JumpFailedMode {
        DOWNLOAD_TAOBAO,
        OPEN_H5,
        NONE
    }

    private TBAppLinkSDK() {
        JumpFailedMode jumpFailedMode = JumpFailedMode.DOWNLOAD_TAOBAO;
    }

    public static TBAppLinkSDK a() {
        if (b != null) {
            return b;
        }
        synchronized (TBAppLinkSDK.class) {
            if (b == null) {
                b = new TBAppLinkSDK();
            }
        }
        return b;
    }
}
