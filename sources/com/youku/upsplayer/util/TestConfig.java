package com.youku.upsplayer.util;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TestConfig {
    private static boolean sIsCheckUrl;
    private static boolean sIsCompress;
    private static boolean sIsCompressConfigValid;

    static {
        int i = SystemUtils.getInt("debug.ups.config.compress", -1);
        int i2 = SystemUtils.getInt("debug.ups.config.checkurl", -1);
        sIsCompress = i == 1;
        sIsCompressConfigValid = i != -1;
        sIsCheckUrl = i2 == 1;
    }

    public static boolean isCheckUrl() {
        return sIsCheckUrl;
    }

    public static boolean isCompress() {
        return sIsCompress;
    }

    public static boolean isIsCompressConfigValid() {
        return sIsCompressConfigValid;
    }
}
