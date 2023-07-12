package com.youku.resource.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.youku.analytics.AnalyticsAgent;
import com.youku.live.dsl.config.IDynamicConfig;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import com.youku.middlewareservice.provider.kvdata.HighPerfSPProviderProxy;
import com.youku.middlewareservice.provider.youku.YoukuDeviceInfoProviderProxy;
import com.youku.nobelsdk.NobelManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AppPerfABUtils {
    private static final String HOME_START_AB_EXP_ID = "816";
    private static final String HOME_START_CONTROL_EXP_ID = "825";
    private static final String HOME_START_NO_OPT1 = "1900";
    private static final String HOME_START_NO_OPT2 = "1901";
    private static final String HOME_START_NO_OPT3 = "1920";
    private static final String NOBEL_KEY_DOUBLE_FEED_RELOAD = "nobel_id_double_feed_reload";
    private static final String NOBEL_KEY_HOME_START_AB = "nobel_key_home_start_ab";
    private static final String NOBEL_KEY_HOME_START_CONTROL = "nobel_key_home_start_control";
    private static final String NOBEL_KEY_LIGHT_WIDGET_BY_DEVICE = "nobel_id_light_widget_by_device";
    private static int isDegradeModelState = -1;
    private static int isForbidPreLoadFeedImg = -1;
    private static int isForbidPreLoadMore = -1;
    private static int isOpenDegradeMode = -1;
    private static int mAutoPlayScore = -1;
    private static int mDefaultDegradeScore = -1;
    private static int mDegradeMode = -1;
    private static int mDetailNotifyScore = -1;
    private static int mDeviceScore = 0;
    private static int mFeedPreloadScore = -1;
    private static int mForbidGifImg = -1;
    private static int mForbidManualParse = -1;
    private static int mForbidManualParseFeed = -1;
    private static int mForbidPoplayerScore = -1;
    private static int mForbidUcModule = -1;
    private static int mGuideScore = -1;
    private static int mNoOptLessRequestLayout = -1;
    private static int mNoResizeR1YkimgCom = -1;
    private static int mNoSetEnableLayoutOptimize = -1;
    private static int mOpenBackgroundSetImageUrlScore = -1;
    private static int mOpenComponentFilter = -1;
    private static int mRoundCornerScore = -1;
    private static int mScrollLoadImageScore = -1;
    private static int sCacheModuleReloadOffset = -1;
    private static int sClosePreRenderTextOpt = -1;
    private static int sFakeCoverTimeout = -1;
    private static int sFakeCoverTimeoutLow = -1;
    private static int sForbidAutoRefreshModule = -1;
    private static int sForbidAutoRefreshMultiModules = -1;
    private static int sForbidBackgroundSetImageUrlDouble = -1;
    private static int sForbidByDeviceType = -1;
    private static int sForbidChannelPreload = -1;
    private static int sForbidChannelVHPreload = -1;
    private static int sForbidDelayActualData = -1;
    private static int sForbidDoubleFeedImgPreload = -1;
    private static int sForbidDoubleFeedVHPreload = -1;
    private static int sForbidFeedVHPreload = -1;
    private static int sForbidHomeBehavix = -1;
    private static int sForbidHomeLoadMoreAsynic = -1;
    private static int sForbidHomePreFetch = -1;
    private static int sForbidHomeStartOpt = -1;
    private static int sForbidHomeVHPreload = -1;
    private static int sForbidLoadMoreOnActionUp = -1;
    private static int sForbidPreRenderViewReleaseBitmap = -1;
    private static int sForbidPreloadAtmosBg = -1;
    private static int sForbidShowCoverForGif = -1;
    private static int sForbidSimpleLayoutScore = -1;
    private static int sForbidSmoothScrollFeature = -1;
    public static long sHomeFirstScreenRenderTime = -1;
    public static boolean sHomePageVisibleChanged = false;
    private static int sHomeStartOpt = -1;
    private static int sHomeStartOptWoodPicker = -1;
    private static int sIsABForbidLightWidget = -1;
    private static Boolean sIsGrayVersion = null;
    private static int sIsHitDoubleFeedReload = -1;
    private static int sIsPreRenderViewHardwareAccelerated = -1;
    private static int sLightWeightReleaseDrawableOnPageLeave = -1;
    private static int sLoadMoreThresholdNum = -1;
    private static boolean sLogShown = false;
    private static int sOpenSimpleLayout = -1;
    private static int sOpenStaticLayoutOpt = -1;
    private static int sOptHomeFrameTask = -1;
    private static int sPreloadImgForFakeCover = -1;
    private static int sRcmdStayTimeSecondThreshold = -1;
    private static List<String> sSimpleLayoutPageBlackList = null;
    private static List<Integer> sSimpleLayoutTypeBlackList = null;
    private static int sStripDataOnSave = -1;
    public static long sUserDraggingHomePageTime = -1;
    private static String sWoodpeckerSimpleLayoutSwitchVal;

    private static boolean equalsLoosely(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return TextUtils.isEmpty(str2);
        }
        return str.equals(str2);
    }

    public static int getCacheModuleReloadOffset() {
        if (sCacheModuleReloadOffset == -1) {
            sCacheModuleReloadOffset = getDegradePrefs("cache_module_reload_offset");
        }
        return sCacheModuleReloadOffset;
    }

    public static int getDegradeMode() {
        if (mDegradeMode == -1) {
            mDegradeMode = getDegradePrefs("degrade_mode", 0);
        }
        return mDegradeMode;
    }

    private static int getDegradePrefs(String str, int i) {
        try {
            return HighPerfSPProviderProxy.getInt("degrade_prefs", str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int getDeviceScore() {
        int i = mDeviceScore;
        if (i <= 0 || i >= Integer.MAX_VALUE) {
            int degradePrefs = getDegradePrefs("device_score", -1);
            mDeviceScore = degradePrefs;
            if (degradePrefs == -1) {
                int deviceScore = YoukuDeviceInfoProviderProxy.getDeviceScore();
                mDeviceScore = deviceScore;
                if (deviceScore > 0 && deviceScore < Integer.MAX_VALUE) {
                    saveDegradePrefs("device_score", deviceScore);
                }
            }
            if (mDeviceScore <= 0) {
                mDeviceScore = Integer.MAX_VALUE;
            }
            return mDeviceScore;
        }
        return i;
    }

    public static long getFakeCoverTimeout() {
        int i;
        if (sFakeCoverTimeout < 0) {
            parseFakeCoverTimeout();
        }
        if (isOpenDegrade()) {
            i = sFakeCoverTimeoutLow;
        } else {
            i = sFakeCoverTimeout;
        }
        return i;
    }

    public static int getLoadMoreThreshold() {
        if (sLoadMoreThresholdNum == -1) {
            sLoadMoreThresholdNum = getDegradePrefs("load_more_threshold");
        }
        return sLoadMoreThresholdNum;
    }

    public static int getRcmdStayTimeSecondThreshold() {
        if (sRcmdStayTimeSecondThreshold == -1) {
            sRcmdStayTimeSecondThreshold = getDegradePrefs("rcmd_stay_time_second");
        }
        return sRcmdStayTimeSecondThreshold;
    }

    private static String getWoodpeckerSimpleLayoutSwitch() {
        if (sWoodpeckerSimpleLayoutSwitchVal == null) {
            sWoodpeckerSimpleLayoutSwitchVal = WoodpeckerLocalConfigCenter.getCheckedVal("simple_layout_switch");
        }
        return sWoodpeckerSimpleLayoutSwitchVal;
    }

    private static boolean isABForbidLightWidget() {
        if (sIsABForbidLightWidget == -1) {
            if ("1883".equals(getDegradePrefs(NOBEL_KEY_LIGHT_WIDGET_BY_DEVICE, "none"))) {
                sIsABForbidLightWidget = 1;
            } else {
                sIsABForbidLightWidget = 0;
            }
        }
        return sIsABForbidLightWidget == 1;
    }

    private static boolean isDegradeDevice() {
        int i;
        int i2 = isDegradeModelState;
        if (i2 != -1) {
            return i2 == 1;
        }
        String degradePrefs = getDegradePrefs("degrade_device_list", "");
        if (TextUtils.isEmpty(degradePrefs)) {
            isDegradeModelState = 0;
            return false;
        }
        String[] split = degradePrefs.split(",");
        if (split.length == 0) {
            isDegradeModelState = 0;
            return false;
        }
        String model = Build.getMODEL();
        if (!TextUtils.isEmpty(model)) {
            for (String str : split) {
                if (model.equalsIgnoreCase(str.trim())) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        isDegradeModelState = i;
        return i == 1;
    }

    public static boolean isDegradeDoubleFeedFilmList() {
        return isForbidAutoPlay();
    }

    public static boolean isDisableBackgroundSetImageUrl() {
        return !isOpenBackgroundSetImageUrl();
    }

    public static boolean isForbidAutoPlay() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mAutoPlayScore == -1) {
            mAutoPlayScore = getDegradePrefs("degrade_auto_play");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mAutoPlayScore > getDeviceScore());
    }

    public static boolean isForbidAutoRefreshModule() {
        int i = sForbidAutoRefreshModule;
        if (i != -1) {
            return i == 1;
        }
        int degradePrefs = getDegradePrefs("forbid_auto_refresh_module", 0);
        sForbidAutoRefreshModule = degradePrefs;
        return degradePrefs == 1;
    }

    public static boolean isForbidAutoRefreshMultiModules() {
        int i = sForbidAutoRefreshMultiModules;
        if (i != -1) {
            return i == 1;
        }
        int degradePrefs = getDegradePrefs("forbid_auto_refresh_multi_modules", 0);
        sForbidAutoRefreshMultiModules = degradePrefs;
        return degradePrefs == 1;
    }

    public static boolean isForbidChannelLoading() {
        return false;
    }

    public static boolean isForbidChannelPreload() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (sForbidChannelPreload == -1) {
            sForbidChannelPreload = getDegradePrefs("degrade_forbid_channel_preload");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || sForbidChannelPreload > getDeviceScore());
    }

    public static boolean isForbidDelayActualData() {
        if (sForbidDelayActualData < 0) {
            sForbidDelayActualData = getDegradePrefs("forbid_delay_actual_data", 0);
        }
        return sForbidDelayActualData != 0;
    }

    public static boolean isForbidDetailNotify() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mDetailNotifyScore == -1) {
            mDetailNotifyScore = getDegradePrefs("degrade_detail_notify");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mDetailNotifyScore > getDeviceScore());
    }

    public static boolean isForbidFeedPreload() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mFeedPreloadScore == -1) {
            mFeedPreloadScore = getDegradePrefs("degrade_feed_preload", -1);
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mFeedPreloadScore > getDeviceScore());
    }

    public static boolean isForbidGifImg() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mForbidGifImg == -1) {
            mForbidGifImg = getDegradePrefs("degrade_forbid_gif_img");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mForbidGifImg > getDeviceScore());
    }

    public static boolean isForbidGuide() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mGuideScore == -1) {
            mGuideScore = getDegradePrefs("degrade_guide_score");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mGuideScore > getDeviceScore());
    }

    public static boolean isForbidHomeBehavix() {
        if (sForbidHomeBehavix == -1) {
            sForbidHomeBehavix = getDegradePrefs("forbid_home_behavix", 0);
        }
        return sForbidHomeBehavix == 1;
    }

    public static boolean isForbidHomePrefetch() {
        int i = sForbidHomePreFetch;
        if (i != -1) {
            return i == 1;
        }
        int degradePrefs = getDegradePrefs("forbid_home_prefetch", 0);
        sForbidHomePreFetch = degradePrefs;
        return degradePrefs == 1;
    }

    public static boolean isForbidHomeSmoothScrollFeature() {
        int i = sForbidSmoothScrollFeature;
        if (i != -1) {
            return i == 1;
        }
        int degradePrefs = getDegradePrefs("forbid_smooth_scroll_feature", 0);
        sForbidSmoothScrollFeature = degradePrefs;
        return degradePrefs == 1;
    }

    private static boolean isForbidHomeStartOpt() {
        if (sForbidHomeStartOpt < 0) {
            sForbidHomeStartOpt = getDegradePrefs("forbid_home_start_opt", 0);
        }
        return sForbidHomeStartOpt != 0;
    }

    public static boolean isForbidLightWidgetByDeviceType() {
        if (sForbidByDeviceType == -1) {
            sForbidByDeviceType = (DeviceInfoProviderProxy.isFoldScreen() || DeviceInfoProviderProxy.isPad()) ? 1 : 0;
        }
        return sForbidByDeviceType == 1;
    }

    public static boolean isForbidLoadMoreOnActionUp() {
        if (sForbidLoadMoreOnActionUp == -1) {
            sForbidLoadMoreOnActionUp = getDegradePrefs("forbid_loadmore_on_action_up");
        }
        return sForbidLoadMoreOnActionUp > 0;
    }

    private static boolean isForbidManualParse() {
        if (mForbidManualParse == -1) {
            mForbidManualParse = getDegradePrefs("forbid_manual_parse");
        }
        return mForbidManualParse > 0;
    }

    public static boolean isForbidManualParseFeed() {
        if (mForbidManualParseFeed == -1) {
            mForbidManualParseFeed = getDegradePrefs("forbid_manual_parse_feed");
        }
        return mForbidManualParseFeed > 0;
    }

    public static boolean isForbidMergeLayerDegrade() {
        return false;
    }

    public static boolean isForbidPoplayer() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mForbidPoplayerScore == -1) {
            mForbidPoplayerScore = getDegradePrefs("degrade_forbid_poplayer");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mForbidPoplayerScore > getDeviceScore());
    }

    private static boolean isForbidPreLoadFeedImg() {
        int i = isForbidPreLoadFeedImg;
        if (i != -1) {
            return i == 1;
        }
        int degradePrefs = getDegradePrefs("forbid_pre_load_feed_img", 0);
        isForbidPreLoadFeedImg = degradePrefs;
        return degradePrefs == 1;
    }

    private static boolean isForbidPreLoadMore() {
        int i = isForbidPreLoadMore;
        if (i != -1) {
            return i == 1;
        }
        int degradePrefs = getDegradePrefs("forbid_pre_load_more", 0);
        isForbidPreLoadMore = degradePrefs;
        return degradePrefs == 1;
    }

    public static boolean isForbidPreRenderViewReleaseBitmap() {
        if (sForbidPreRenderViewReleaseBitmap == -1) {
            sForbidPreRenderViewReleaseBitmap = getDegradePrefs("forbid_prerender_view_release_bp", 0);
        }
        return sForbidPreRenderViewReleaseBitmap == 1;
    }

    public static boolean isForbidPreloadAtmosBg() {
        if (sForbidPreloadAtmosBg == -1) {
            sForbidPreloadAtmosBg = getDegradePrefs("forbid_preload_atmos_bg", 0);
        }
        return sForbidPreloadAtmosBg == 1;
    }

    @Deprecated
    public static boolean isForbidPreviewGuide() {
        return isForbidGuide();
    }

    @Deprecated
    public static boolean isForbidRocketGuide() {
        return isForbidGuide();
    }

    public static boolean isForbidRoundCorner() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mRoundCornerScore == -1) {
            mRoundCornerScore = getDegradePrefs("degrade_round_corner");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mRoundCornerScore > getDeviceScore());
    }

    public static boolean isForbidShowCoverForGif() {
        if (sForbidShowCoverForGif < 0) {
            sForbidShowCoverForGif = getDegradePrefs("forbid_show_cover_for_gif", 1);
        }
        return sForbidShowCoverForGif != 0;
    }

    public static boolean isForbidUcModule() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mForbidUcModule == -1) {
            mForbidUcModule = getDegradePrefs("degrade_uc_module");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mForbidUcModule > getDeviceScore());
    }

    public static boolean isGrayVersion() {
        if (sIsGrayVersion == null) {
            sIsGrayVersion = Boolean.valueOf(AppInfoProviderProxy.getVersionName() != null && AppInfoProviderProxy.getVersionName().split("\\.").length > 3);
        }
        return sIsGrayVersion.booleanValue();
    }

    public static boolean isHitDoubleFeedReload() {
        if (sIsHitDoubleFeedReload == -1) {
            sIsHitDoubleFeedReload = "2401".equals(getDegradePrefs(NOBEL_KEY_DOUBLE_FEED_RELOAD, "none")) ? 1 : 0;
        }
        return sIsHitDoubleFeedReload == 1;
    }

    @Deprecated
    public static Boolean isHitLightWidgetByDeviceAB() {
        return Boolean.FALSE;
    }

    public static synchronized boolean isInSimpleLayoutBlackList(int i) {
        boolean contains;
        synchronized (AppPerfABUtils.class) {
            try {
                if (sSimpleLayoutTypeBlackList == null) {
                    sSimpleLayoutTypeBlackList = new ArrayList();
                    String degradePrefs = getDegradePrefs("simple_layout_black_list", "");
                    if (!TextUtils.isEmpty(degradePrefs)) {
                        String[] split = degradePrefs.split(",");
                        if (split.length > 0) {
                            for (String str : split) {
                                sSimpleLayoutTypeBlackList.add(Integer.valueOf(Integer.parseInt(str)));
                            }
                        }
                    }
                }
                contains = sSimpleLayoutTypeBlackList.contains(Integer.valueOf(i));
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
                return false;
            }
        }
        return contains;
    }

    public static synchronized boolean isInSimpleLayoutPageBlackList(String str) {
        boolean contains;
        synchronized (AppPerfABUtils.class) {
            try {
                if (sSimpleLayoutPageBlackList == null) {
                    sSimpleLayoutPageBlackList = new ArrayList();
                    String degradePrefs = getDegradePrefs("simple_layout_page_black_list", "");
                    if (!TextUtils.isEmpty(degradePrefs)) {
                        String[] split = degradePrefs.split(",");
                        if (split.length > 0) {
                            sSimpleLayoutPageBlackList.addAll(Arrays.asList(split));
                        }
                    }
                }
                contains = sSimpleLayoutPageBlackList.contains(str);
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
                return false;
            }
        }
        return contains;
    }

    public static boolean isInSimpleLayoutWhiteList(int i) {
        return i == 12041 || i == 12058;
    }

    public static boolean isLWReleaseDrawableOnPageLeave() {
        int i = sLightWeightReleaseDrawableOnPageLeave;
        if (i != -1) {
            return i == 1;
        }
        int i2 = getDeviceScore() > getDegradePrefs("light_weight_release_drawable_on_leave", Integer.MAX_VALUE) ? 0 : 1;
        sLightWeightReleaseDrawableOnPageLeave = i2;
        return i2 == 1;
    }

    public static boolean isNoOptLessRequestLayout() {
        if (mNoOptLessRequestLayout == -1) {
            mNoOptLessRequestLayout = getDegradePrefs("opt_no_OptLessRequestLayout", 0);
        }
        return mNoOptLessRequestLayout > 0 || !isOpenPerf();
    }

    public static boolean isNoResizeR1YkimgCom() {
        if (mNoResizeR1YkimgCom == -1) {
            mNoResizeR1YkimgCom = getDegradePrefs("opt_no_Resize_r1_ykimg_com", 0);
        }
        return mNoResizeR1YkimgCom > 0 || !isOpenPerf();
    }

    public static boolean isNoSetEnableLayoutOptimize() {
        if (mNoSetEnableLayoutOptimize == -1) {
            mNoSetEnableLayoutOptimize = getDegradePrefs("opt_no_setEnableLayoutOptimize");
        }
        return mNoSetEnableLayoutOptimize > 0 || !isOpenPerf();
    }

    private static boolean isOpenBackgroundSetImageUrl() {
        if (getDegradeMode() == 1) {
            return true;
        }
        boolean z = false;
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mOpenBackgroundSetImageUrlScore == -1) {
            mOpenBackgroundSetImageUrlScore = getDegradePrefs("opt_backgroundImageUrl");
        }
        if (isOpenDegradeSwitch() && (isDegradeDevice() || mOpenBackgroundSetImageUrlScore > getDeviceScore())) {
            z = true;
        }
        if (!sLogShown && AppInfoProviderProxy.isDebuggable()) {
            Log.e("AppPerfABUtils", "isOpenBackgroundSetImageUrl = " + z);
            sLogShown = true;
        }
        return z;
    }

    public static boolean isOpenBackgroundSetImageUrlDouble() {
        if (sForbidBackgroundSetImageUrlDouble == -1) {
            sForbidBackgroundSetImageUrlDouble = getDegradePrefs("forbid_backgroundImageUrlDouble", 0);
        }
        return sForbidBackgroundSetImageUrlDouble <= 0 && isOpenPerf();
    }

    public static boolean isOpenChannelVHPreload() {
        if (sForbidChannelVHPreload == -1) {
            sForbidChannelVHPreload = getDegradePrefs("forbid_channel_vh_preload", 0);
        }
        return sForbidChannelVHPreload <= 0 && isOpenPerf();
    }

    public static boolean isOpenComponentFilter() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mOpenComponentFilter == -1) {
            mOpenComponentFilter = getDegradePrefs("degrade_component_filter");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mOpenComponentFilter > getDeviceScore());
    }

    private static boolean isOpenDefaultDegrade() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (mDefaultDegradeScore == -1) {
            mDefaultDegradeScore = getDegradePrefs("degrade_default_score");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mDefaultDegradeScore > getDeviceScore());
    }

    public static boolean isOpenDegrade() {
        return isOpenDefaultDegrade();
    }

    private static boolean isOpenDegradeSwitch() {
        if (isOpenDegradeMode != -1) {
            return isOpenPerf() && isOpenDegradeMode == 1;
        }
        isOpenDegradeMode = getDegradePrefs("open_degrade", 0);
        return isOpenPerf() && isOpenDegradeMode == 1;
    }

    public static boolean isOpenDetailPerf() {
        return isOpenPerf();
    }

    public static boolean isOpenDoubleFeedImgPreload() {
        if (sForbidDoubleFeedImgPreload == -1) {
            sForbidDoubleFeedImgPreload = getDegradePrefs("forbid_double_feed_img_preload", 0);
        }
        return sForbidDoubleFeedImgPreload <= 0 && isOpenPerf();
    }

    public static boolean isOpenDoubleFeedVHPreload() {
        if (sForbidDoubleFeedVHPreload == -1) {
            sForbidDoubleFeedVHPreload = getDegradePrefs("forbid_double_feed_vh_preload", 0);
        }
        return sForbidDoubleFeedVHPreload <= 0 && isOpenPerf();
    }

    public static boolean isOpenFeedVHPreload() {
        if (sForbidFeedVHPreload == -1) {
            sForbidFeedVHPreload = getDegradePrefs("forbid_feed_vh_preload", 0);
        }
        return sForbidFeedVHPreload <= 0 && isOpenPerf();
    }

    public static boolean isOpenHomeLoadMoreAsynic() {
        if (sForbidHomeLoadMoreAsynic == -1) {
            sForbidHomeLoadMoreAsynic = getDegradePrefs("forbid_home_load_more_asynic", 0);
        }
        return sForbidHomeLoadMoreAsynic <= 0 && isOpenPerf();
    }

    public static boolean isOpenHomePerf() {
        return isOpenPerf();
    }

    public static boolean isOpenHomeStartOpt() {
        if (sHomeStartOptWoodPicker < 0) {
            String checkedVal = WoodpeckerLocalConfigCenter.getCheckedVal("home_start_opt");
            if ("open".equals(checkedVal)) {
                sHomeStartOptWoodPicker = 1;
            } else if ("close".equals(checkedVal)) {
                sHomeStartOptWoodPicker = 2;
            } else {
                sHomeStartOptWoodPicker = 0;
            }
        }
        int i = sHomeStartOptWoodPicker;
        if (i == 1) {
            return true;
        }
        if (i == 2 || isForbidHomeStartOpt()) {
            return false;
        }
        if (sHomeStartOpt < 0) {
            String degradePrefs = getDegradePrefs(NOBEL_KEY_HOME_START_AB, "");
            if (HOME_START_NO_OPT1.equals(degradePrefs)) {
                sHomeStartOpt = 0;
            } else if (HOME_START_NO_OPT2.equals(degradePrefs)) {
                sHomeStartOpt = 1;
            } else if (HOME_START_NO_OPT3.equals(getDegradePrefs(NOBEL_KEY_HOME_START_CONTROL, ""))) {
                sHomeStartOpt = 1;
            } else {
                sHomeStartOpt = 0;
            }
        }
        return sHomeStartOpt > 0;
    }

    public static boolean isOpenHomeVHPreload() {
        if (sForbidHomeVHPreload == -1) {
            sForbidHomeVHPreload = getDegradePrefs("forbid_home_vh_preload", 0);
        }
        return sForbidHomeVHPreload <= 0 && isOpenPerf();
    }

    @Deprecated
    public static boolean isOpenPerf() {
        return true;
    }

    public static boolean isOpenPreRenderTextOpt() {
        if (sClosePreRenderTextOpt == -1) {
            sClosePreRenderTextOpt = getDegradePrefs("close_prerender_text_opt", 0);
        }
        return sClosePreRenderTextOpt <= 0;
    }

    public static boolean isOpenPreRenderViewHardwareAccelerated() {
        if (sIsPreRenderViewHardwareAccelerated == -1) {
            sIsPreRenderViewHardwareAccelerated = getDegradePrefs("open_lw_hard_accelerated", 0);
        }
        return sIsPreRenderViewHardwareAccelerated == 1;
    }

    public static boolean isOpenSimpleLayout() {
        if (DebugSwitchUtils.isWoodpeckerOpen() || isGrayVersion() || AppInfoProviderProxy.isDebuggable()) {
            if ("open".equals(getWoodpeckerSimpleLayoutSwitch())) {
                return true;
            }
            if ("close".equals(getWoodpeckerSimpleLayoutSwitch())) {
                return false;
            }
        }
        int i = sOpenSimpleLayout;
        if (i != -1) {
            return i == 1;
        }
        if (sForbidSimpleLayoutScore == -1) {
            sForbidSimpleLayoutScore = getDegradePrefs("forbid_simple_layout_score", Integer.MAX_VALUE);
        }
        int i2 = getDeviceScore() > sForbidSimpleLayoutScore ? 0 : 1;
        sOpenSimpleLayout = i2;
        if (i2 != 0) {
            sOpenSimpleLayout = !isABForbidLightWidget() ? 1 : 0;
        }
        if (sOpenSimpleLayout != 0) {
            sOpenSimpleLayout = !isForbidLightWidgetByDeviceType() ? 1 : 0;
        }
        return sOpenSimpleLayout != 0;
    }

    public static boolean isOpenStaticLayoutOpt() {
        if (sOpenStaticLayoutOpt == -1) {
            sOpenStaticLayoutOpt = getDegradePrefs("open_static_layout_opt", 1);
        }
        return sOpenStaticLayoutOpt == 1;
    }

    public static boolean isOpenTrace() {
        return false;
    }

    public static boolean isOptHomeFrameTask() {
        if (getDegradeMode() == 1) {
            return true;
        }
        if (getDegradeMode() == 2) {
            return false;
        }
        if (sOptHomeFrameTask == -1) {
            sOptHomeFrameTask = getDegradePrefs("opt_home_frame_task");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || sOptHomeFrameTask > getDeviceScore());
    }

    public static boolean isPreLoadFeedImg() {
        if (getDegradeMode() == 1) {
            return true;
        }
        return (getDegradeMode() == 2 || !isOpenPerf() || isForbidPreLoadFeedImg()) ? false : true;
    }

    public static boolean isPreLoadMore() {
        if (getDegradeMode() == 1) {
            return true;
        }
        return (getDegradeMode() == 2 || !isOpenPerf() || isForbidPreLoadMore()) ? false : true;
    }

    public static boolean isPreloadImgForFakeCover() {
        if (sPreloadImgForFakeCover < 0) {
            sPreloadImgForFakeCover = getDegradePrefs("opt_preload_img_for_fake_cover", 1);
        }
        return sPreloadImgForFakeCover != 0;
    }

    public static boolean isScrollForbidImg() {
        if (mScrollLoadImageScore == -1) {
            mScrollLoadImageScore = getDegradePrefs("degrade_scroll_load_img");
        }
        return isOpenDegradeSwitch() && (isDegradeDevice() || mScrollLoadImageScore > getDeviceScore());
    }

    public static boolean isSpeedCutFling() {
        return isOpenDegrade();
    }

    public static boolean isStripDataOnSave() {
        if (sStripDataOnSave < 0) {
            sStripDataOnSave = getDegradePrefs("opt_strip_remote_data_on_save", 0);
        }
        return sStripDataOnSave != 0;
    }

    public static boolean isUseDoubleFeedVisualOpti() {
        return (isOpenDegrade() || isForbidRoundCorner()) ? false : true;
    }

    public static boolean isUseManualParse(boolean z) {
        return z ? isOpenPerf() && !isForbidManualParseFeed() : isOpenPerf() && !isForbidManualParse();
    }

    private static void parseFakeCoverTimeout() {
        String degradePrefs = getDegradePrefs("opt_fake_cover_timeout", (String) null);
        if (TextUtils.isEmpty(degradePrefs)) {
            sFakeCoverTimeout = 0;
            sFakeCoverTimeoutLow = 0;
            return;
        }
        String[] split = degradePrefs.split(",");
        if (split.length != 2) {
            sFakeCoverTimeout = 0;
            sFakeCoverTimeoutLow = 0;
            return;
        }
        try {
            sFakeCoverTimeout = Integer.parseInt(split[0]);
        } catch (Exception unused) {
            sFakeCoverTimeout = 0;
        }
        try {
            sFakeCoverTimeoutLow = Integer.parseInt(split[1]);
        } catch (Exception unused2) {
            sFakeCoverTimeoutLow = 0;
        }
    }

    private static int parseInt(String str, int i) {
        try {
            return TextUtils.isEmpty(str) ? i : Integer.parseInt(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    public static void saveDegradeMode(boolean z) {
        saveDegradePrefs("degrade_mode", z ? 2 : 1);
    }

    public static void saveDegradePrefs(String str, int i) {
        try {
            HighPerfSPProviderProxy.putInt("degrade_prefs", str, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveMapToPrefs(Map<String, String> map, String str, int i) {
        if (map != null && map.containsKey(str)) {
            saveDegradePrefs(str, parseInt(map.get(str), i));
        } else {
            saveDegradePrefs(str, i);
        }
    }

    private static void saveMapToPrefsIfContains(Map<String, String> map, String str, int i) {
        if (map == null || !map.containsKey(str)) {
            return;
        }
        saveDegradePrefs(str, parseInt(map.get(str), i));
    }

    private static void saveNobelHomeStartOpt() {
        String hitAB = NobelManager.getInstance().hitAB(HOME_START_AB_EXP_ID);
        String degradePrefs = getDegradePrefs(NOBEL_KEY_HOME_START_AB, "");
        if (hitAB != null && !equalsLoosely(hitAB, degradePrefs)) {
            saveDegradePrefs(NOBEL_KEY_HOME_START_AB, hitAB);
        }
        String hitAB2 = NobelManager.getInstance().hitAB(HOME_START_CONTROL_EXP_ID);
        String degradePrefs2 = getDegradePrefs(NOBEL_KEY_HOME_START_CONTROL, "");
        if (hitAB2 == null || equalsLoosely(hitAB2, degradePrefs2)) {
            return;
        }
        saveDegradePrefs(NOBEL_KEY_HOME_START_CONTROL, hitAB2);
    }

    public static void savePerfNobelAb() {
        String hitAB = NobelManager.getInstance().hitAB("809");
        if (hitAB != null) {
            if (!hitAB.equals(getDegradePrefs(NOBEL_KEY_LIGHT_WIDGET_BY_DEVICE, "none"))) {
                saveDegradePrefs(NOBEL_KEY_LIGHT_WIDGET_BY_DEVICE, hitAB);
            }
        } else {
            saveDegradePrefs(NOBEL_KEY_LIGHT_WIDGET_BY_DEVICE, "none");
        }
        String hitAB2 = NobelManager.getInstance().hitAB("1031");
        if (hitAB2 != null) {
            if (!hitAB2.equals(getDegradePrefs(NOBEL_KEY_DOUBLE_FEED_RELOAD, "none"))) {
                saveDegradePrefs(NOBEL_KEY_DOUBLE_FEED_RELOAD, hitAB2);
            }
        } else {
            saveDegradePrefs(NOBEL_KEY_DOUBLE_FEED_RELOAD, "none");
        }
        saveNobelHomeStartOpt();
    }

    public static void sendDeviceInfoUT() {
        HashMap hashMap = new HashMap();
        hashMap.put(IDynamicConfig.KEY_DEVICE_SCORE, mDeviceScore + "");
        hashMap.put("isOpenPerf", isOpenPerf() + "");
        hashMap.put("isOpenDegradeMode", isOpenDegradeMode + "");
        AnalyticsAgent.utCustomEvent("HOME_AppPerf", 19999, "home_device_info", "", "", hashMap);
    }

    public static void updateDegradeOrangeConfigs(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        saveMapToPrefs(map, "open_degrade", 0);
        saveMapToPrefsIfContains(map, "degrade_default_score", 0);
        saveMapToPrefsIfContains(map, "degrade_round_corner", 0);
        saveMapToPrefsIfContains(map, "degrade_feed_preload", 0);
        saveMapToPrefsIfContains(map, "degrade_scroll_load_img", 0);
        saveMapToPrefsIfContains(map, "degrade_forbid_gif_img", 0);
        saveMapToPrefsIfContains(map, "degrade_detail_notify", 0);
        saveMapToPrefsIfContains(map, "degrade_guide_score", 0);
        saveMapToPrefsIfContains(map, "degrade_forbid_poplayer", 0);
        saveMapToPrefsIfContains(map, "degrade_auto_play", 0);
        saveMapToPrefsIfContains(map, "degrade_uc_module", 0);
        saveMapToPrefsIfContains(map, "degrade_forbid_channel_preload", 0);
        saveMapToPrefs(map, "opt_backgroundImageUrl", 0);
        saveMapToPrefs(map, "forbid_backgroundImageUrlDouble", 0);
        saveMapToPrefs(map, "opt_no_setEnableLayoutOptimize", 0);
        saveMapToPrefs(map, "opt_no_OptLessRequestLayout", 0);
        saveMapToPrefs(map, "opt_no_Resize_r1_ykimg_com", 0);
        saveMapToPrefs(map, "forbid_pre_load_more", 0);
        saveMapToPrefs(map, "forbid_async_view", 0);
        saveMapToPrefs(map, "forbid_channel_async_view", 0);
        saveMapToPrefs(map, "forbid_manual_parse", 0);
        saveMapToPrefs(map, "forbid_manual_parse_feed", 0);
        saveMapToPrefs(map, "forbid_home_load_more_asynic", 0);
        saveMapToPrefs(map, "forbid_home_vh_preload", 0);
        saveMapToPrefs(map, "forbid_channel_vh_preload", 0);
        saveMapToPrefs(map, "forbid_feed_vh_preload", 0);
        saveMapToPrefs(map, "forbid_double_feed_vh_preload", 0);
        saveMapToPrefs(map, "forbid_double_feed_img_preload", 0);
        saveMapToPrefs(map, "forbid_send_device_info", 0);
        saveMapToPrefs(map, "opt_home_frame_task", 0);
        saveMapToPrefs(map, "forbid_loadmore_on_action_up", 0);
        saveMapToPrefs(map, "load_more_threshold", 0);
        saveMapToPrefs(map, "forbid_home_start_opt", 0);
        saveMapToPrefs(map, "opt_fake_cover_timeout", (String) null);
        saveMapToPrefs(map, "opt_strip_remote_data_on_save", 0);
        saveMapToPrefs(map, "opt_preload_img_for_fake_cover", 1);
        saveMapToPrefs(map, "forbid_show_cover_for_gif", 1);
        saveMapToPrefs(map, "forbid_delay_actual_data", 0);
        saveMapToPrefs(map, "forbid_preload_atmos_bg", (String) null);
        saveMapToPrefs(map, "forbid_smooth_scroll_feature", 0);
        saveMapToPrefs(map, "forbid_simple_layout_score", Integer.MAX_VALUE);
        saveMapToPrefs(map, "cache_module_reload_offset", 0);
        saveMapToPrefs(map, "simple_layout_black_list", "");
        saveMapToPrefs(map, "simple_layout_page_black_list", "");
        saveMapToPrefs(map, "forbid_auto_refresh_module", 0);
        saveMapToPrefs(map, "forbid_auto_refresh_multi_modules", 0);
        saveMapToPrefs(map, "light_weight_release_drawable_on_leave", Integer.MAX_VALUE);
        saveMapToPrefs(map, "close_prerender_text_opt", 0);
        saveMapToPrefs(map, "open_static_layout_opt", 1);
        saveMapToPrefs(map, "open_lw_hard_accelerated", 0);
        saveMapToPrefs(map, "forbid_prerender_view_release_bp", 0);
        saveMapToPrefs(map, "forbid_home_behavix", 0);
        saveMapToPrefs(map, "rcmd_stay_time_second", 20000);
        if (map.containsKey("degrade_device_list")) {
            saveDegradePrefs("degrade_device_list", map.get("degrade_device_list"));
        } else {
            saveDegradePrefs("degrade_device_list", "");
        }
    }

    private static String getDegradePrefs(String str, String str2) {
        try {
            return HighPerfSPProviderProxy.getString("degrade_prefs", str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    private static int getDegradePrefs(String str) {
        return getDegradePrefs(str, 0);
    }

    public static void saveDegradePrefs(String str, String str2) {
        try {
            HighPerfSPProviderProxy.putString("degrade_prefs", str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveMapToPrefs(Map<String, String> map, String str, String str2) {
        if (map != null && map.containsKey(str)) {
            saveDegradePrefs(str, map.get(str));
        } else {
            saveDegradePrefs(str, str2);
        }
    }
}
