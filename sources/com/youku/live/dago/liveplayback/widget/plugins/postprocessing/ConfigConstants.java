package com.youku.live.dago.liveplayback.widget.plugins.postprocessing;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ConfigConstants {
    static final String ALGORITHM_OFF = "0";
    static final HashMap<String, String> CONFIG_TYPE_NAMESPACE_MAP;
    static final String DEFAULT_TYPE_ID = "0";
    static final String KEY_ALGORITHM = "app_post_processing_algorithm";
    static final String KEY_AUTO = "app_post_processing_in_auto";
    static final String KEY_CONFIG_LIST = "app_post_processing_config_list";
    static final String KEY_DEFAULT_CONFIG = "app_post_processing_default_config";
    static final String KEY_ENABLE = "app_post_processing_enable";
    static final String KEY_EXTEND = "app_post_processing_extend";
    static final String KEY_EXTRA_SWITCH = "app_post_processing_switch";
    static final String KEY_MODE = "app_post_processing_mode";
    public static final String KEY_NEW_MANAGER = "enable_new_manager";
    static final String KEY_SCORE = "app_post_processing_min_device_store";
    static final String KEY_STEAM_TYPE = "app_post_processing_stream_type";
    static final String KEY_TYPE = "app_post_processing_type";
    static final String KEY_UPS_CONFIG = "post_process_config";
    static final int LIVE_PP_MODE_APS = 1;
    static final int LIVE_PP_MODE_OFF = 0;
    static final int LIVE_PP_MODE_PC = 2;
    static final String MODE_OFF = "0";
    static final String MODE_ON_AUTO = "1";
    static final String MODE_ON_MANUAL = "2";
    static final String NAMESPACE_ADAPTIVE_SHARP_2 = "pp_adaptive_sharp";
    @Deprecated
    static final String NAMESPACE_AUDIO_ENHANCEMENT = "app_audio_enhancement";
    static final String NAMESPACE_AUDIO_ENHANCEMENT_2 = "pp_audio_enhancement";
    @Deprecated
    static final String NAMESPACE_COLOR_FILTER = "app_color_filter";
    static final String NAMESPACE_COLOR_FILTER_2 = "pp_color_filter";
    @Deprecated
    static final String NAMESPACE_COLOR_SPACE_FILTER = "app_color_space_correct";
    static final String NAMESPACE_COLOR_SPACE_FILTER_2 = "pp_color_space_correct";
    static final String NAMESPACE_DEBAND_2 = "pp_deband";
    static final String NAMESPACE_FILE_STYLE_2 = "pp_film_style";
    static final String NAMESPACE_HDR10_2 = "pp_hdr10";
    static final String NAMESPACE_HDR_2 = "pp_hdr";
    static final String NAMESPACE_PIXELWORK_2 = "pp_pixelwork";
    public static final String NAMESPACE_PP_MANAGER = "pp_manager";
    static final String NAMESPACE_PP_TYPE_LIVE_MAP = "pp_type_map_live";
    static final String NAMESPACE_PP_TYPE_MAP = "pp_type_map";
    @Deprecated
    static final String NAMESPACE_SHARP = "app_post_sharp";
    static final String NAMESPACE_SHARP_2 = "pp_sharp";
    static final String PARAM_KEY_EXTEND = "extend";
    static final String PARAM_KEY_TYPE = "type";
    static final String PARAM_KEY_UPS_EXTEND = "ups_extend";
    static final String PP_ALGORITHM = "appPostProcessingAlgorithm";
    static final String PP_DEFAULT_EXTEND = "appPostProcessingDefaultExtend";
    static final String PP_EXTEND = "appPostProcessingExtend";
    static final String PP_MODE = "appPostProcessingMode";
    static final String PP_TYPE = "appPostProcessingType";
    public static final String TYPE_AUDIO_ENHANCEMENT = "8";
    public static final String TYPE_HDR = "3";

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        CONFIG_TYPE_NAMESPACE_MAP = hashMap;
        hashMap.put("8", NAMESPACE_AUDIO_ENHANCEMENT_2);
    }
}
