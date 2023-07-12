package com.youku.alixplayer.opensdk.statistics;

import anet.channel.status.NetworkStatusHelper;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class StaticsUtil {
    public static final int PLATFORM_YOUKU = 101;
    public static final String PLAY_CODE_100 = "-100";
    public static final String PLAY_CODE_101 = "-101";
    public static final String PLAY_CODE_102 = "-102";
    public static final String PLAY_CODE_103 = "-103";
    public static final String PLAY_CODE_104 = "-104";
    public static final String PLAY_CODE_105 = "-105";
    public static final String PLAY_CODE_106 = "-106";
    public static final String PLAY_CODE_SUCCESS = "200";
    public static final String PLAY_TYPE_DOWNLOADING = "downloading";
    public static final String PLAY_TYPE_LOCAL = "local";
    public static final String PLAY_TYPE_NET = "net";

    /* compiled from: Taobao */
    /* renamed from: com.youku.alixplayer.opensdk.statistics.StaticsUtil$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus;

        static {
            int[] iArr = new int[NetworkStatusHelper.NetworkStatus.values().length];
            $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus = iArr;
            try {
                iArr[NetworkStatusHelper.NetworkStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.NO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.G4.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.NetworkStatus.WIFI.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static String getNetStatus() {
        switch (AnonymousClass1.$SwitchMap$anet$channel$status$NetworkStatusHelper$NetworkStatus[NetworkStatusHelper.i().ordinal()]) {
            case 1:
            default:
                return "NONE";
            case 2:
                return "noNetwork";
            case 3:
                return "2G";
            case 4:
                return "3G";
            case 5:
                return "4G";
            case 6:
                return "WiFi";
        }
    }
}
