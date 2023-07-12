package com.youku.live.dago.liveplayback.widget.plugins.tipsview;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TipsConstants {
    public static String TAG = "TipsPlugin";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class LeftBottomTips {
        public static int COMMON_INFO = 10000;
        public static int COMMON_VIP = 20000;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public interface KEY {
            public static final String KEY_ADVERTISE_GUIDE = "key_advertise_guide";
            public static final String KEY_DEFAULT = "key_default";
            public static final String KEY_RECOMMEND_QUALITY_HBR = "key_recommend_quality_hbr";
            public static final String KEY_RESERVATION = "key_reservation";
            public static final String KEY_VIP = "key_vip";
        }

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        public interface LEVEL {
            public static final int ADVERTISE_GUIDE;
            public static final int DEFAULT;
            public static final int RECOMMEND_QUALITY;
            public static final int RESERVATION;
            public static final int VIP;

            static {
                int i = LeftBottomTips.COMMON_INFO;
                DEFAULT = i;
                RESERVATION = i;
                ADVERTISE_GUIDE = i;
                VIP = LeftBottomTips.COMMON_VIP;
                RECOMMEND_QUALITY = LeftBottomTips.COMMON_INFO;
            }
        }
    }
}
