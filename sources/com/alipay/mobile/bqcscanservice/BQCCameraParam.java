package com.alipay.mobile.bqcscanservice;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BQCCameraParam {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final String EXPOSURE_INDEX = "index";
    public static final String EXPOSURE_OFF = "close";
    public static final String EXPOSURE_ON = "open";
    public static final String FOCUS_AREA_OFF = "close";
    public static final String FOCUS_AREA_ON = "open";
    public static final String FOCUS_AREA_RADIUS = "radius";
    public static final String FOCUS_ONCE = "once";
    public static final String FOCUS_TYPE_AI = "ai";
    public static final String FOCUS_TYPE_AUTO = "auto";
    public static final String FOCUS_TYPE_C_PICTURE = "c_picture";
    public static final String FOCUS_TYPE_C_VIDEO = "c_video";
    public static final String FOCUS_TYPE_EDOF = "edof";
    public static final String FOCUS_TYPE_MACRO = "macro";
    public static final String FOCUS_TYPE_WX = "wx";
    public static final String KEY_CAMERA2_FOCUS_DISTANCE_AVG_VALUE = "fd_avg_value";
    public static final String KEY_CAMERA2_FOCUS_DISTANCE_TOTAL_COUNT = "fd_total_count";
    public static final String SCENE_ACTION = "action";
    public static final String SCENE_AUTO = "auto";
    public static final String SCENE_BARCODE = "barcode";
    public static final String SCENE_BEACH = "beach";
    public static final String SCENE_CANDLE = "candle";
    public static final String SCENE_FIREWORKS = "fireworks";
    public static final String SCENE_LANDSCAPE = "landscape";
    public static final String SCENE_NIGHT = "night";
    public static final String SCENE_NIGHT_P = "night_p";
    public static final String SCENE_PARTY = "party";
    public static final String SCENE_PORTRAIT = "portrait";
    public static final String SCENE_SNOW = "snow";
    public static final String SCENE_SPORTS = "sports";
    public static final String SCENE_ST_PHOTO = "st_photo";
    public static final String SCENE_SUNSET = "sunset";
    public static final String SCENE_THEATRE = "theatre";
    public static final String SWITCH_AUTO = "auto";
    public static final String SWITCH_OFF = "close";
    public static final String SWITCH_ON = "open";
    public static final String VALUE_NO = "no";
    public static final String VALUE_YES = "yes";
    private static final HashMap<String, Integer> a;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum CameraConfigType {
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum CameraOperationInstruction {
        FOCUS_MODE,
        FOCUS_MANUAL,
        SCENE_MODE,
        FOCUS_AREA,
        EXPOSURE_STATE
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CameraPropertyParam {
        public static final String BACK_CAMERA_INDEX = "Back_Camera_Index";
        public static final String CAMERA_FACING = "Camera_Facing";
        public static final String CAMERA_ROTATE_ORIENTATION = "Camera_Rotate_Orientation";
        public static final String MAX_EXPOSURE_INDEX = "Max_Exposure_Index";
        public static final String MAX_PICTURE_SIZE_VALID = "Max_Picture_Size_Valid";
        public static final String MIN_EXPOSURE_INDEX = "Min_Exposure_Index";
        public static final String PREVIEW_HEIGHT = "Preview_Height";
        public static final String PREVIEW_SIZE = "preview_size";
        public static final String PREVIEW_WIDTH = "Preview_Width";
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class ConfigParam {
        public static final String KEY_AE_AF_REGION_BOX_PROPORTION = "ae_af_region_box-proportion";
        public static final String KEY_CAMERA2_AE_AF_REGION_BOX_PROPORTION = "camera2_ae_af_region_box-proportion";
        public static final String KEY_CAMERA2_ENABLE_BEST_RECOGNIZE_PREVIEW_SIZE = "camera2_enable_best_recognize_pv_size";
        public static final String KEY_CAMERA2_FOCUS_ABNORMAL_CHECK_PARAMS = "camera2_focus_abnormal_check_params";
        public static final String KEY_CAMERA2_FOCUS_DISTANCE_INFO = "camera2_focus_distance_info";
        public static final String KEY_CAMERA2_MAX_RETRY_OPEN_NUM = "camera2_max_retry_open_num";
        public static final String KEY_CAMERA2_MAX_RETRY_START_PREVIEW_NUM = "camera2_max_retry_preview_num";
        public static final String KEY_CAMERA2_PIPELINE_MODE = "camera2_pipeline_mode";
        public static final String KEY_CAMERA2_SECOND_FOCUS_MODE_SUPPORT = "camera2_second_focus_mode_support";
        public static final String KEY_CAMERA2_SUPPORT_INIT_FOCUS_DISTANCE = "camera2_support_focus_distance";
        public static final String KEY_CAMERA_ENABLE_PV_WATCH_DOG = "camera_enable_pv_watch_dog";
        public static final String KEY_CAMERA_FINGERPRINT = "camera_fingerprint";
        public static final String KEY_CAMERA_ID_BACKUP = "key_camera_id_backup";
        public static final String KEY_CAMERA_PERMISSION_DETECT = "key_camera_permission_detect";
        public static final String KEY_DYNAMICAL_PREVIEWSIZE = "key_dynamical_previewSize";
        public static final String KEY_ENABLE_AUTO_FOCUS_QUICK_SWITCH = "enable_autofocus_quick_switch";
        public static final String KEY_ENABLE_COMPATIBLE = "enable_compatible";
        public static final String KEY_ENABLE_INIT_FOCUS_TO_AUTO = "enable_init_focus_to_auto";
        public static final String KEY_ENABLE_OPTIMIZE_PARAMETERS = "enable_optimize_parameters";
        public static final String KEY_MAX_PREVIEW = "key_max_preview";
        public static final String KEY_MERGE_CAMERA_PARAM = "merge_camera_param";
        public static final String KEY_MIN_PREVIEW = "key_min_preview";
        public static final String KEY_NEW_FOCUS_CONFIG = "new_focus_config";
        public static final String KEY_NOT_RUN_STOP_PREVIEW = "not_run_stopPreview";
        public static final String KEY_OPEN_CAMERA_FAULT_TOLERANT = "useCameraFaultTolerant";
        public static final String KEY_OPEN_CAMERA_RETRY_TIME = "open_camera_retry_num";
        public static final String KEY_PICTURE_SIZE_TIMES = "picture_size_times";
        public static final String KEY_SERVICE_CONFIG_PREVIEW_SIZE_RULE = "service_config_pv_size_rule";
        public static final String KEY_START_PREVIEW_RETRY_TIME = "start_preview_retry_num";
        public static final String KEY_STOP_CANCEL_FOCUS = "stop_cancel_focus";
        public static final String KEY_SUPPORT_FRAME_CALLBACK = "key_support_frame_callback";
        public static final String KEY_SUPPORT_MANUAL_FOCUS = "key_support_manual_focus";
        public static final String KEY_SUPPORT_PICTURE_SIZE = "support_picture_size";
        public static final String KEY_THRESHOLD_SWITCH_TO_AUTO_DURATION = "key_threshold_switch_to_auto_duration";
        public static final String LOCAL_CAMERA2_INIT_FOCUS_DISTANCE_INFO = "local_camera2_focus_distance_info";
        public static final String LOCAL_MAX_PICTURE_VALID = "local_max_picture_valid";
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class EngineType {
        public static final String SCAN_MA = "MA";

        public EngineType(BQCCameraParam bQCCameraParam) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum MaEngineType {
        ALL(0),
        BAR(1),
        QRCODE(2),
        DEFAULT(3),
        LOTTERY(4);
        
        public int type;

        MaEngineType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class ServicePropertyParam {
        public static final String CAMERA_FRAME_DELAY = "camera_frame_delay";
        public static final String NOT_SELF_DIAGNOSE = "not_self_diagnose";
        public static final String SERVICE_IN_DEBUG = "debug";
        public static final String SERVICE_OPERATION_CONFIG = "service_operation_configs";
        public static final String SERVICE_PPS_CONFIG = "service_pps_config";
        public static final String SERVICE_STATISTICS_CAMERA = "service_statistics_camera";
        public static final String USE_FRAME_AHEAD = "use_frame_ahead";
        public static final String USE_NEW_SCAN_EXECUTOR = "scan_new_executor";
        public static final String USE_NEW_SURFACE = "scan_use_new_surface";
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("auto", 0);
        hashMap.put(FOCUS_TYPE_C_VIDEO, 1);
        hashMap.put(FOCUS_TYPE_C_PICTURE, 2);
    }

    public static String mergeFocusParams(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap<String, Integer> hashMap = a;
            Integer num = hashMap.get(str);
            Integer num2 = hashMap.get(str2);
            if (num != null && num2 != null && num2.intValue() < num.intValue()) {
                return str2;
            }
        }
        return str;
    }

    public static boolean validFocusConfigType(String str) {
        return "auto".equalsIgnoreCase(str) || FOCUS_TYPE_C_PICTURE.equalsIgnoreCase(str) || FOCUS_TYPE_C_VIDEO.equalsIgnoreCase(str) || FOCUS_TYPE_WX.equalsIgnoreCase(str) || FOCUS_TYPE_AI.equalsIgnoreCase(str) || FOCUS_TYPE_EDOF.equalsIgnoreCase(str) || FOCUS_TYPE_MACRO.equalsIgnoreCase(str);
    }
}
