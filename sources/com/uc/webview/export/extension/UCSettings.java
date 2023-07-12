package com.uc.webview.export.extension;

import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;
import com.uc.webview.export.internal.utility.C7329e;
import com.uc.webview.export.internal.utility.Log;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public abstract class UCSettings implements InvokeObject {
    public static final String CD_RESOURCE_DISABLE_SW_SCRIPTCACHE_LIST = "crwp_disable_sw_scriptcache_list";
    public static final String CD_RESOURCE_EMBED_SURFACE_EMBED_VIEW_ENABLE_LIST = "crwp_embed_surface_embed_view_enable_list";
    public static final String CD_RESOURCE_EMBED_VIEW_REATTACH_LIST = "crwp_embed_view_reattach_list";
    public static final String CD_RESOURCE_ENABLE_IMG_ERROR_INFO = "enable_img_error_info";
    public static final String CD_RESOURCE_FOCUS_AUTO_POPUP_INPUT_WHITELIST = "u4_focus_auto_popup_input_list";
    public static final String CD_RESOURCE_HYBRID_RENDER_EMBED_VIEW_ENABLE_LIST = "crwp_hybrid_render_embed_view_enable_list";
    public static final String CD_RESOURCE_STAT_FILTER_LIST = "stat_filter_list";
    public static final String KEY_ADBLOCK_WHITE_LIST = "resadwhitelist";
    public static final String KEY_COOKIES_BLACKLIST_FOR_JS = "CookiesBlacklistForJs";
    public static final String KEY_DISABLE_ACCELERATE_CANVAS = "DisableAccelerateCanvas";
    @Deprecated
    public static final String KEY_DISABLE_FLOAT_VIDEO_VIEW = "video_fixed_sw_hostlist";
    @Deprecated
    public static final String KEY_DISABLE_VIDEO_RESUME = "disable_video_resume";
    public static final String KEY_DISCARDABLE_FREE_IF_HAS_GPU_DECODE = "DiscardableFreeIfHasGpuDecode";
    @Deprecated
    public static final String KEY_DONOT_PAUSE_AFTER_EXIT_VIDEO_FULLSCREEN = "crsp_npef";
    @Deprecated
    public static final String KEY_DONOT_PAUSE_AFTER_SHOW_MODE_CHANGED = "crsp_npsmc";
    public static final String KEY_ENABLE_VIDEO_AUTO_PLAY_LIST = "video_play_gesture_whitelist";
    public static final String KEY_MEM_CACHE_PAGE_COUNT = "CachePageNumber";
    public static final String KEY_MEM_DISCARDABLE_LIMIT_BYTE = "DiscardableLimitBytes";
    public static final String KEY_MEM_DISCARDABLE_RELEASE_FOR_ALLOC_FAILED_SWITCH = "DiscardableReleaseForAllocFailedSwitch";
    public static final String KEY_MEM_DISCARDABLE_RELEASE_FREE_AFTER_SECOND = "DiscardableReleaseFreeAfterSecond";
    public static final String KEY_MEM_DISCARDABLE_RELEASE_FREE_AFTER_TIME_SWITCH = "DiscardableReleaseFreeAfterTimeSwitch";
    public static final String KEY_MEM_DISCARDABLE_RELEASE_FREE_UNTIL_BYTE = "DiscardableReleaseFreeUntilByte";
    public static final String KEY_MEM_GR_DISCARDABLE_LIMIT_BYTE = "GrDiscardableLimitByte";
    public static final String KEY_MEM_GR_RESOURCE_CACHE_LIMIT_BYTE = "GrResourceCacheLimitByte";
    public static final String KEY_NIGHT_MODE_COLOR = "NightModeColor";
    @Deprecated
    public static final String KEY_NO_DISPLAY_WANING_WHEN_PLAY_MEDIA_ON_MOBILE_NETWORK = "crsp_nwomn";
    public static final String KEY_USE_RAW_VIDEO_CONTROLS = "u4xr_video_st_list";
    @Deprecated
    public static final String KEY_VIDEO_ENTER_VIEW_FULLSCREEN_ONLY = "crsp_fsa_bl";
    @Deprecated
    public static final String KEY_VIDEO_SUPPORT_RAW_CONTROLS_ATTR = "crsp_sp_rc";
    public static final String KEY_WEBAUDIO_DISABLE_DEFAULT_DECODER = "crsp_wddd";
    private static Set<String> a;

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add("u4xr_video_st_list");
        a.add(KEY_VIDEO_SUPPORT_RAW_CONTROLS_ATTR);
        a.add(KEY_VIDEO_ENTER_VIEW_FULLSCREEN_ONLY);
        a.add(KEY_DISABLE_FLOAT_VIDEO_VIEW);
        a.add("video_play_gesture_whitelist");
        a.add(KEY_ADBLOCK_WHITE_LIST);
        a.add(CD_RESOURCE_STAT_FILTER_LIST);
        a.add(KEY_NIGHT_MODE_COLOR);
        a.add("u4_focus_auto_popup_input_list");
        a.add("crwp_hybrid_render_embed_view_enable_list");
        a.add("crwp_embed_surface_embed_view_enable_list");
        a.add("crwp_embed_view_reattach_list");
        a.add("crwp_disable_sw_scriptcache_list");
        a.add("enable_img_error_info");
        a.add("CachePageNumber");
        a.add(KEY_DISCARDABLE_FREE_IF_HAS_GPU_DECODE);
        a.add("DiscardableLimitBytes");
        a.add("DiscardableReleaseFreeAfterTimeSwitch");
        a.add("DiscardableReleaseFreeAfterSecond");
        a.add("DiscardableReleaseFreeUntilByte");
        a.add("DiscardableReleaseForAllocFailedSwitch");
        a.add("GrDiscardableLimitByte");
        a.add("GrResourceCacheLimitByte");
        a.add("CookiesBlacklistForJs");
    }

    public static boolean getGlobalBoolValue(String str) {
        IGlobalSettings f = SDKFactory.f();
        if (f != null) {
            return f.getBoolValue(str);
        }
        return false;
    }

    public static int getGlobalIntValue(String str) {
        IGlobalSettings f = SDKFactory.f();
        if (f != null) {
            return f.getIntValue(str);
        }
        return -1;
    }

    public static String getGlobalStringValue(String str) {
        IGlobalSettings f = SDKFactory.f();
        return f != null ? f.getStringValue(str) : "";
    }

    @Deprecated
    public static boolean isEnableCustomErrorPage() {
        return true;
    }

    public static void setGlobalBoolValue(String str, boolean z) {
        IGlobalSettings f = SDKFactory.f();
        if (f != null) {
            f.setBoolValue(str, z);
        }
    }

    public static void setGlobalIntValue(String str, int i) {
        IGlobalSettings f = SDKFactory.f();
        if (f != null) {
            f.setIntValue(str, i);
        }
    }

    public static void setGlobalStringValue(String str, String str2) {
        IGlobalSettings f = SDKFactory.f();
        if (f != null) {
            f.setStringValue(str, str2);
        }
    }

    public static void updateBussinessInfo(int i, int i2, String str, Object obj) {
        String str2;
        UCMobileWebKit d = SDKFactory.d();
        if (d == null || !a.contains(str)) {
            return;
        }
        if (obj instanceof String[]) {
            StringBuilder sb = new StringBuilder();
            for (String str3 : (String[]) obj) {
                String trim = str3.trim();
                if (trim.length() != 0) {
                    sb.append(trim);
                    sb.append("^^");
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 2);
                str2 = sb.toString();
                d.updateBussinessInfo(i, i2, str, str2);
            }
        }
        str2 = obj instanceof String ? (String) obj : "";
        d.updateBussinessInfo(i, i2, str, str2);
    }

    public static void updateDynamicSettings(String str, String str2) {
        C7329e.a(str, str2);
    }

    public void setCameraType(int i) {
        invoke(305, new Object[]{Integer.valueOf(i)});
    }

    @Deprecated
    public void setEnableFastScroller(boolean z) {
        Log.w("UCSettings", "setEnableFastScroller not override");
    }

    @Deprecated
    public void setEnableUCProxy(boolean z) {
        Log.w("UCSettings", "setEnableUCProxy deprecated");
    }

    @Deprecated
    public void setForceUCProxy(boolean z) {
        Log.w("UCSettings", "setForceUCProxy deprecated");
    }

    public void setStringValue(String str, String str2) {
        invoke(304, new Object[]{str, str2});
    }

    @Deprecated
    public void setUCCookieType(int i) {
        Log.w("UCSettings", "setUCCookieType deprecated");
    }
}
