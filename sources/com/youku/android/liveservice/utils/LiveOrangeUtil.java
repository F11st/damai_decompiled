package com.youku.android.liveservice.utils;

import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LiveOrangeUtil {
    public static final String LIVE_GROUP_NAME = "YKLService";
    public static final String LIVE_ROOM_AB_TEST = "YKLService_ABTest";
    private static final String TAG = "LiveOrangeUtil";
    private static boolean sIsEnable = true;
    private static boolean sIsV3EnableInit;

    public static boolean enableOnRecycledViewTimeOver() {
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig(LIVE_ROOM_AB_TEST, "enable_recycle_view_time_over", "false"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean enableOnViewDetachedFromWindowTimeOver() {
        try {
            return Boolean.parseBoolean(OrangeConfig.getInstance().getConfig(LIVE_ROOM_AB_TEST, "enable_detached_from_window_time_over", "true"));
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static int getChannelLimitTime() {
        int i;
        try {
            i = Integer.parseInt(OrangeConfig.getInstance().getConfig(LIVE_ROOM_AB_TEST, "channel_cms_default_limit_time", "10"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 10;
        }
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "getChannelLimitTime time = " + i);
        }
        return i;
    }

    public static String getChannelLiveId() {
        String config = OrangeConfig.getInstance().getConfig(LIVE_ROOM_AB_TEST, "channel_cms_default_live_id", "8006302");
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "getChannelLiveId liveId = " + config);
        }
        return config;
    }

    public static int getChannelMute() {
        int i;
        try {
            i = Integer.parseInt(OrangeConfig.getInstance().getConfig(LIVE_ROOM_AB_TEST, "channel_cms_mute", "1"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 1;
        }
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "getChannelMute mute = " + i);
        }
        return i;
    }

    public static int getChannelQuality() {
        int i;
        try {
            i = Integer.parseInt(OrangeConfig.getInstance().getConfig(LIVE_ROOM_AB_TEST, "channel_cms_quality_v2", "2"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 2;
        }
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "getChannelQuality quality = " + i);
        }
        return i;
    }

    public static String getChannelVid() {
        String config = OrangeConfig.getInstance().getConfig(LIVE_ROOM_AB_TEST, "channel_cms_default_video_id", "XMjYwODQwNjM3Mg==");
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "getChannelVid videoId = " + config);
        }
        return config;
    }

    public static int getDeviceLimit() {
        int i;
        try {
            i = Integer.parseInt(OrangeConfig.getInstance().getConfig(LIVE_ROOM_AB_TEST, "channel_cms_device_limit_score", "50"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 50;
        }
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "getDeviceLimit score = " + i);
        }
        return i;
    }

    public static int getOpenOnePlayerRate() {
        try {
            return Integer.parseInt(OrangeConfig.getInstance().getConfig(LIVE_GROUP_NAME, "ONEPLAYER_OPEN_RATE_IN_CMS", "0"));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isInOnePlayerWhiteList(String str) {
        String config = OrangeConfig.getInstance().getConfig(LIVE_GROUP_NAME, "LIVE_ONEPLAYER_WHITELIST_UTDID_IN_CMS", "");
        return config != null && config.length() > 0 && str != null && str.length() > 0 && config.indexOf(str) >= 0;
    }

    public static boolean isUseControlV3() {
        if (!sIsV3EnableInit) {
            try {
                sIsEnable = Boolean.parseBoolean(OrangeConfig.getInstance().getConfig(LIVE_GROUP_NAME, "playControlV3Enable", "true"));
                sIsV3EnableInit = true;
            } catch (Exception e) {
                sIsEnable = false;
                e.printStackTrace();
            }
        }
        return sIsEnable;
    }
}
