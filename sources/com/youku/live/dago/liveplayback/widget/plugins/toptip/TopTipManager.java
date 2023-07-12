package com.youku.live.dago.liveplayback.widget.plugins.toptip;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.TipsConfig;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.tipsconfig.TipInfo;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.tipsconfig.TipsConfigManager;
import com.youku.live.dago.liveplayback.widget.plugins.tipsview.tipsconfig.TipsConfigManagerEx;
import com.youku.live.dago.liveplayback.widget.plugins.toptip.TopTipConfigManager;
import com.youku.uplayer.AliMediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TopTipManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "TopTipManager";
    public static final int TIP_LEVEL_DEFINED_START = 900;
    public static final int TIP_LEVEL_MAX = 1000;
    public static final int TIP_LEVEL_MIN = 0;
    public static final int TIP_STYLE_CUSTOM = 6;
    public static final int TIP_STYLE_DEFAULT = 5;
    public static final int TIP_STYLE_VIP = 4;
    public static final int TIP_TYPE_SYSTEM = 1000;
    public static final int TIP_TYPE_USER = 1001;
    private static final Map<String, Integer> sLevelMap;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface TipName {
        public static final String CATON_COMPLAINT_ENTRY_TIP_PLUGIN = "caton_complaint_entry_show";
        public static final String CHANGE_LANGUAGE_PLUGIN = "change_language_plugin";
        public static final String CHANGE_QUALITY_TIP_PLUGIN = "video_quality_change";
        public static final String DEFAULT_PLUGIN = "default_plugin";
        public static final String KUKAN_PLUGIN = "kukan_plugin";
        public static final String LOCK_PLUGIN = "lock_plugin";
        public static final String MON_VOD = "mon_vod";
        public static final String MORE_PLUGIN = "more_plugin";
        public static final String NIGHT_MODE_PLUGIN = "night_mode";
        public static final String PLAY_NEXT_PLUGIN = "play_next_plugin";
        public static final String SPEED_PLUGIN = "speed_plugin";
        public static final String TIME_CLOSURE_PLUGIN = "time_closure_plugin";
        public static final String TINY_VIP_SKIP_AD = "tiny_vip_skip_ad";
        public static final String VIP_TIP_PLUGIN = "vip_tip_plugin";
        public static final String WATCH_SOME_ONE_PLUGIN = "watch_some_one_plugin";
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface TipSeq {
        public static final int SEQ_3G_TIP_PLUGIN_4G_PLAYER = 39;
        public static final int SEQ_CATON_COMPLAINT_ENTRY_TIP_PLUGIN = 48;
        public static final int SEQ_LOCK_PLUGIN = 66;
        public static final int SEQ_MORE_PLUGIN_CACHE_FAILED = 29;
        public static final int SEQ_MORE_PLUGIN_FAVORITE = 67;
        public static final int SEQ_MORE_PLUGIN_FOLLOW_CANCEL = 28;
        public static final int SEQ_MORE_PLUGIN_FOLLOW_JOIN = 26;
        public static final int SEQ_MORE_PLUGIN_FOLLOW_JOIN_NO_PROG = 27;
        public static final int SEQ_MORE_PLUGIN_NIGHT_MODE_CLOSE = 38;
        public static final int SEQ_MORE_PLUGIN_NIGHT_MODE_OPEN = 37;
        public static final int SEQ_MORE_PLUGIN_TIME_CLOSE = 68;
        public static final int SEQ_PLAY_CACHE_VIDEO_WHEN_4G = 65;
        public static final int SEQ_PLAY_CACHE_VIDEO_WHEN_ERROR_NO_WIFI = 62;
        public static final int SEQ_PLUGIN_SERIES_MON_VOD = 58;
        public static final int SEQ_QUALITY_PLUGIN_1080_USE = 16;
        public static final int SEQ_QUALITY_PLUGIN_4G_DOLBY_USE = 13;
        public static final int SEQ_QUALITY_PLUGIN_720_USE = -1;
        public static final int SEQ_QUALITY_PLUGIN_DOBY_OPENED = 34;
        public static final int SEQ_QUALITY_PLUGIN_DOLBY_CLOSING = 35;
        public static final int SEQ_QUALITY_PLUGIN_DOLBY_USE = 14;
        public static final int SEQ_QUALITY_PLUGIN_HBR_CLOSING = 53;
        public static final int SEQ_QUALITY_PLUGIN_HBR_FILM_PASS_CLOSED = 60;
        public static final int SEQ_QUALITY_PLUGIN_HBR_FILM_PASS_OPENED = 59;
        public static final int SEQ_QUALITY_PLUGIN_HBR_LIMITED_TIME_FREE_OPENED = 57;
        public static final int SEQ_QUALITY_PLUGIN_HBR_OPENED = 52;
        public static final int SEQ_QUALITY_PLUGIN_HBR_OPENING = 51;
        public static final int SEQ_QUALITY_PLUGIN_HDR_CLOSED = 33;
        public static final int SEQ_QUALITY_PLUGIN_HDR_CLOSING = 32;
        public static final int SEQ_QUALITY_PLUGIN_HDR_OPENED = 31;
        public static final int SEQ_QUALITY_PLUGIN_HDR_OPENING = 30;
        public static final int SEQ_QUALITY_PLUGIN_HDR_USE = 15;
        public static final int SEQ_QUALITY_PLUGIN_WIFI_DOLBY_REC = 8;
        public static final int SEQ_QUALITY_PLUGIN_WIFI_HDR_REC = 9;
        public static final int SEQ_SPEED_PLUGIN_INFO = 69;
        public static final int SEQ_SPEED_THREE_TO_TWO = 56;
        public static final int SEQ_SWITCH_SUBTITLE_FAILED = 55;
        public static final int SEQ_SWITCH_SUBTITLE_SUCCESS = 54;
        public static final int SEQ_TIME_CLOSURE_PLUGIN = 19;
        public static final int SEQ_VIDEO_PLAY_NEXT = 40;
        public static final int SEQ_VIDEO_QUALITY_SWITCHED = 43;
        public static final int SEQ_VIDEO_QUALITY_SWITCHED_1080P = 46;
        public static final int SEQ_VIDEO_QUALITY_SWITCHED_HDR_1080P_50 = 47;
        public static final int SEQ_VIDEO_QUALITY_SWITCHING = 42;
        public static final int SEQ_VIDEO_QUALITY_SWITCHING_1080P = 44;
        public static final int SEQ_VIDEO_QUALITY_SWITCHING_HDR_1080P_50 = 45;
        public static final int SEQ_VIP_PLUGIN_SKIP_AD = 11;
        public static final int SEQ_VIP_PLUGIN_SKIP_HEAD_AND_TAIL = 10;
        public static final int SEQ_WATCH_SOMEONE_PLUGIN = 41;
    }

    static {
        HashMap hashMap = new HashMap();
        sLevelMap = hashMap;
        hashMap.put(TipName.VIP_TIP_PLUGIN, 1000);
        hashMap.put(TipName.MORE_PLUGIN, 900);
        hashMap.put(TipName.MON_VOD, 940);
        hashMap.put(TipName.TINY_VIP_SKIP_AD, 950);
        hashMap.put(TipName.CHANGE_QUALITY_TIP_PLUGIN, 930);
        hashMap.put(TipName.CATON_COMPLAINT_ENTRY_TIP_PLUGIN, 930);
        hashMap.put(TipName.TIME_CLOSURE_PLUGIN, 910);
        hashMap.put(TipName.PLAY_NEXT_PLUGIN, 910);
        hashMap.put(TipName.WATCH_SOME_ONE_PLUGIN, 910);
        hashMap.put(TipName.NIGHT_MODE_PLUGIN, Integer.valueOf((int) AliMediaPlayer.UPLAYER_PROPERTY_TYPE_NETWORK_STATUS));
        hashMap.put(TipName.DEFAULT_PLUGIN, 0);
    }

    public static boolean canShowTopTip(AlixPlayerContext alixPlayerContext, TopTipInfo topTipInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494827349")) {
            return ((Boolean) ipChange.ipc$dispatch("1494827349", new Object[]{alixPlayerContext, topTipInfo})).booleanValue();
        }
        if (topTipInfo == null) {
            return false;
        }
        String str = topTipInfo.featureId;
        String str2 = topTipInfo.playIdUsingFrequency;
        int i = topTipInfo.frequency;
        TipsConfig.FrequencyType frequencyType = topTipInfo.frequencyType;
        if (TextUtils.isEmpty(str2)) {
            return TipsConfigManagerEx.canShowTips(alixPlayerContext, str, frequencyType, i);
        }
        return false;
    }

    public static boolean canShowWhenControlBarVisible(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-879754436") ? ((Boolean) ipChange.ipc$dispatch("-879754436", new Object[]{Integer.valueOf(i)})).booleanValue() : 1001 == i;
    }

    public static void customTopTip(TopTipInfo topTipInfo, Context context) {
        TipInfo tipInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "39784224")) {
            ipChange.ipc$dispatch("39784224", new Object[]{topTipInfo, context});
        } else if (topTipInfo == null) {
        } else {
            TopTipConfigManager.RemoteTopTipInfo remoteTopTipInfo = TopTipConfigManager.getRemoteTopTipInfo(topTipInfo.tipSeq, context);
            if (remoteTopTipInfo != null) {
                if (remoteTopTipInfo.isVipStyle()) {
                    topTipInfo.style = 4;
                } else if (remoteTopTipInfo.isCustomStyle()) {
                    topTipInfo.style = 6;
                } else {
                    topTipInfo.style = 5;
                }
                if (!TextUtils.isEmpty(remoteTopTipInfo.reminder)) {
                    if (topTipInfo.style == 4 && !remoteTopTipInfo.reminder.contains("</font>")) {
                        remoteTopTipInfo.reminder = "<font color=#F7C3A7>" + remoteTopTipInfo.reminder + "</font>";
                    }
                    topTipInfo.text = Html.fromHtml(remoteTopTipInfo.reminder);
                }
                if (!TextUtils.isEmpty(remoteTopTipInfo.icon)) {
                    topTipInfo.leftVipIconUrl = remoteTopTipInfo.icon;
                }
                if (!TextUtils.isEmpty(remoteTopTipInfo.bgImgUrl) && remoteTopTipInfo.isCustomStyle()) {
                    topTipInfo.backImgUrl = remoteTopTipInfo.bgImgUrl;
                }
                int i = remoteTopTipInfo.displayTime;
                if (i > 0) {
                    topTipInfo.time = i * 1000;
                }
            }
            if (TextUtils.isEmpty(topTipInfo.featureId) || (tipInfo = TipsConfigManager.getTipInfo(topTipInfo.featureId)) == null) {
                return;
            }
            int i2 = tipInfo.duration;
            if (i2 > 0) {
                topTipInfo.time = i2;
            }
            if (tipInfo.type == 1) {
                topTipInfo.style = 4;
            } else {
                topTipInfo.style = 5;
            }
            if (!TextUtils.isEmpty(tipInfo.text) && tipInfo.type == 1 && !tipInfo.text.contains("</font>")) {
                tipInfo.text = "<font color=#F7C3A7>" + tipInfo.text + "</font>";
            }
            topTipInfo.text = Html.fromHtml(tipInfo.text);
            if (!TextUtils.isEmpty(tipInfo.icon)) {
                topTipInfo.leftVipIconUrl = tipInfo.icon;
            }
            if (!TextUtils.isEmpty(tipInfo.bgImg)) {
                topTipInfo.backImgUrl = tipInfo.bgImg;
            }
            int i3 = tipInfo.frequencyType;
            if (i3 > -1) {
                topTipInfo.frequency = tipInfo.frequencyCount;
                if (i3 == 0) {
                    topTipInfo.frequencyType = TipsConfig.FrequencyType.NO_LIMIT;
                } else if (i3 == 1) {
                    topTipInfo.frequencyType = TipsConfig.FrequencyType.APP_INSTALL;
                } else if (i3 == 2) {
                    topTipInfo.frequencyType = TipsConfig.FrequencyType.APP_RUN;
                } else if (i3 == 3) {
                    topTipInfo.frequencyType = TipsConfig.FrequencyType.DAY;
                } else if (i3 != 4) {
                } else {
                    topTipInfo.frequencyType = TipsConfig.FrequencyType.DAYS;
                }
            }
        }
    }

    public static int getRealLevel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296705126")) {
            return ((Integer) ipChange.ipc$dispatch("296705126", new Object[]{Integer.valueOf(i)})).intValue();
        }
        if (isValidLevel(i)) {
            return i;
        }
        return 0;
    }

    public static TopTipConfigManager.RemoteTopTipInfo getRemoteTopTipConfig(int i, Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1931460839") ? (TopTipConfigManager.RemoteTopTipInfo) ipChange.ipc$dispatch("1931460839", new Object[]{Integer.valueOf(i), context}) : TopTipConfigManager.getRemoteTopTipInfo(i, context);
    }

    public static int getTipLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1502775128")) {
            return ((Integer) ipChange.ipc$dispatch("-1502775128", new Object[]{str})).intValue();
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, Integer> map = sLevelMap;
            if (map.containsKey(str)) {
                return map.get(str).intValue();
            }
        }
        return 0;
    }

    public static boolean isValidLevel(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2067282777") ? ((Boolean) ipChange.ipc$dispatch("2067282777", new Object[]{Integer.valueOf(i)})).booleanValue() : i >= 0 || i <= 1000;
    }

    public static void recordHasShown(AlixPlayerContext alixPlayerContext, TopTipInfo topTipInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841607888")) {
            ipChange.ipc$dispatch("841607888", new Object[]{alixPlayerContext, topTipInfo});
        } else if (topTipInfo == null) {
        } else {
            String str = topTipInfo.featureId;
            String str2 = topTipInfo.playIdUsingFrequency;
            TipsConfig.FrequencyType frequencyType = topTipInfo.frequencyType;
            if (TextUtils.isEmpty(str2)) {
                TipsConfigManagerEx.recordTipsHasShown(alixPlayerContext, str, frequencyType);
            }
        }
    }

    public static void registerTipLevel(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1468846587")) {
            ipChange.ipc$dispatch("-1468846587", new Object[]{str, Integer.valueOf(i)});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            sLevelMap.put(str, Integer.valueOf((i < 0 || i > 1000) ? 0 : 0));
        }
    }
}
