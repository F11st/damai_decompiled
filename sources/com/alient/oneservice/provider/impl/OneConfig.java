package com.alient.oneservice.provider.impl;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class OneConfig {
    public static boolean CHECK_UPDATE_BACKGROUND;
    public static boolean CHECK_UPDATE_SYNC;
    public static String appkey;
    private static String channel;
    private static int envType;
    private static String ttid;

    public static String getChannel() {
        return channel;
    }

    public static int getEnvType() {
        return envType;
    }

    public static String getTtid() {
        return ttid;
    }

    public static void setChannel(String str) {
        channel = str;
    }

    public static void setEnvType(int i) {
        envType = i;
    }

    public static void setTtid(String str) {
        ttid = str;
    }
}
