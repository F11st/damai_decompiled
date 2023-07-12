package com.youku.playerservice.axp.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.youku.android.liveservice.bean.BizType;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.cache.CacheManager;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ApsUtil {
    public static final String TAG = "ApsUtil";

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum BusinessType {
        TYPE_VOD,
        TYPE_OTHER_LIVE,
        TYPE_RTP_LIVE,
        TYPE_CMAF_WIDEVINE,
        TYPE_SOURCE;

        int getBit() {
            return 1 << ordinal();
        }
    }

    public static boolean enableAv1() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_switch", "enable_av1", "1"));
    }

    public static boolean enableAxpLivePlayControlCache() {
        return isAxpPlayerSwitch("player_axp_liveplaycontrol_cache_enable", true);
    }

    public static boolean enableAxpSuperResolution() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_superresolution_config", "player_super_resolution_axp_enable", "0"));
    }

    public static boolean enableDelaySEI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "1".equals(ConfigFetcher.getInstance().getConfig("live_delaysei_config", str, "0"));
    }

    public static String enableDownloader(String str) {
        ConfigFetcher configFetcher;
        String str2;
        if ("feed".equals(str)) {
            configFetcher = ConfigFetcher.getInstance();
            str2 = "ykstream_version_feed";
        } else if (CacheManager.BIZ_TYPE_VOD.equals(str)) {
            configFetcher = ConfigFetcher.getInstance();
            str2 = "ykstream_version";
        } else if (!"live".equals(str)) {
            return "1";
        } else {
            configFetcher = ConfigFetcher.getInstance();
            str2 = "ykstream_version_live";
        }
        return configFetcher.getConfig("player_new_core", str2, "1");
    }

    public static boolean enableGetPlayerInfoByKey() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_get_player_info_by_key", "1"));
    }

    public static boolean enableHbr() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("z_real_config", "z_real_enable", "0"));
    }

    public static boolean enableInteractSEI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "1".equals(ConfigFetcher.getInstance().getConfig("live_sei_config", str, "0"));
    }

    public static boolean enableLiveMaster() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_live_master", "1"));
    }

    public static boolean enableLiveSlice() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_live_slice", "1"));
    }

    public static boolean enableMinVideoCacheCheck(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String config = ConfigFetcher.getInstance().getConfig("middle_play_config", "enableMinVideoCacheCheck", "1.1");
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        return config.contains(str);
    }

    public static boolean enableNoSurfacePlay() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("laifeng_config", "enable_no_surface", "0"));
    }

    public static boolean enablePlayInfoResponseCache() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_playinforesponse_cache", "1"));
    }

    public static boolean enablePursue(Context context, BizType bizType) {
        String[] split;
        String config = ConfigFetcher.getInstance().getConfig("live_mediasource_config", "enable_pursue", "");
        if (!TextUtils.isEmpty(config) && (split = config.split(",")) != null) {
            for (String str : split) {
                boolean equalsIgnoreCase = str.equalsIgnoreCase(bizType.getValue());
                boolean equalsIgnoreCase2 = str.equalsIgnoreCase(bizType.getDescription());
                if (equalsIgnoreCase || equalsIgnoreCase2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean enableSameThreadSync() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_same_thread_sync", "1"));
    }

    public static boolean enableSei() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_switch", "enable_sei", "1"));
    }

    public static boolean enableSubtitle() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_subtitle", "0"));
    }

    public static boolean enableSuperResolution() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_superresolution_config", "player_super_resolution_axp_live_enable", "0"));
    }

    public static boolean enableUpsLocalCache() {
        return !"0".equals(ConfigFetcher.getInstance().getConfig("player_switch", "enable_localCache", "0"));
    }

    public static boolean enableUpsLocalCache(int i) {
        ConfigFetcher configFetcher = ConfigFetcher.getInstance();
        return "1".equals(configFetcher.getConfig("player_switch", i + "_localCache", "0"));
    }

    public static boolean enableUpsLocalCache(int i, String str) {
        ConfigFetcher configFetcher = ConfigFetcher.getInstance();
        String config = configFetcher.getConfig("player_switch", i + "_localCacheSource", null);
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        if (jn1.MUL.equals(config)) {
            return true;
        }
        return config.contains(str);
    }

    public static boolean enableUpsMtopServerUnit() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_network_config", "ups_mtop_unit", "1"));
    }

    public static boolean enableVodSliceDown() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_vod_slice_down", "0"));
    }

    public static long getLiveInfoExpiredTime() {
        try {
            return Long.parseLong(ConfigFetcher.getInstance().getConfig("player_cache_config", "cache_liveInfo_expired_time", "3"));
        } catch (Exception unused) {
            Logger.d("getLiveInfoExpiredTime error");
            return 3L;
        }
    }

    public static String getPlayerSourceConfigCanUseMultiGet() {
        return ConfigFetcher.getInstance().getConfig("middle_play_config", "player_sources_can_use_multiget_ups", "2.1;2.2;2.3;2.4;2.5;3;3.1;3.2;3.3;7;24;");
    }

    public static String getPlayerSourceConfigCanUseQGet() {
        return ConfigFetcher.getInstance().getConfig("middle_play_config", "player_sources_can_use_qget_ups", "1;1.1;1.2");
    }

    public static String getPlayerSourceConfigThreeSecond() {
        return ConfigFetcher.getInstance().getConfig("player_axp_config", "player_sources_three_second", "2;2.1;2.2;2.3;2.4;2.5;3.1");
    }

    public static String getQGetUpsLimitNum() {
        return ConfigFetcher.getInstance().getConfig("minset_config", "limitNum", "10");
    }

    public static long getSEIInterval() {
        try {
            return Long.parseLong(ConfigFetcher.getInstance().getConfig("live_sei_config", "sei_interval", "1000"));
        } catch (Exception unused) {
            Logger.d("getSEIInterval error");
            return 1000L;
        }
    }

    public static String getSinglePlayerConfig() {
        return ConfigFetcher.getInstance().getConfig("player_axp_config", "single_player_playersource", "19;25");
    }

    public static long getUpsInfoByMultiGetExpiredTime() {
        try {
            return Long.parseLong(ConfigFetcher.getInstance().getConfig("player_cache_config", "cache_upsInfo_multiget_expired_time", "18000"));
        } catch (Exception unused) {
            Logger.d("getUpsInfoByMultiGetExpiredTime error");
            return 18000L;
        }
    }

    public static long getUpsInfoExpiredTime() {
        try {
            return Long.parseLong(ConfigFetcher.getInstance().getConfig("player_cache_config", "cache_upsInfo_expired_time", "10800"));
        } catch (Exception unused) {
            Logger.d("getUpsInfoExpiredTime error");
            return 10800L;
        }
    }

    public static boolean handleStateChangedSyncEnable() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "handle_state_changed_sync", "1"));
    }

    public static boolean httpDnsEnable() {
        String config = ConfigFetcher.getInstance().getConfig("player_network_httpdns", "httpdns_enable", null);
        Log.d(TAG, "httpDnsEnable: config" + config);
        return !"0".equals(config);
    }

    public static boolean isAxpPlayerSwitch(String str, boolean z) {
        return "1".equals(ConfigFetcher.getInstance().getConfig("axp_player_switch", str, z ? "1" : "0"));
    }

    public static boolean setAlixplayerNullEnable() {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_axp_config", "set_lastholder_alixplayer_null", "1"));
    }
}
