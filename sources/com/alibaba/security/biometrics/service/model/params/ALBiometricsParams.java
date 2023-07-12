package com.alibaba.security.biometrics.service.model.params;

import com.alibaba.security.biometrics.service.common.ABDefaultConfig;
import com.alibaba.security.biometrics.service.util.params.BundleKey;
import com.alibaba.security.biometrics.service.util.params.JsonBundleConverter;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALBiometricsParams implements Serializable {
    @BundleKey(key = ALBiometricsKeys.KEY_ACTIVITY_BRIGNTHNESS_REVERSE)
    public int activityBrignthnessReverse;
    @BundleKey(key = ALBiometricsKeys.KEY_ACTIVITY_ORIENTATION)
    public int activityOrientation;
    @BundleKey(key = ALBiometricsKeys.KEY_BACK_CAMERA_CFG)
    public String backCameraCfg;
    @BundleKey(key = ALBiometricsKeys.KEY_BIO_STEPS)
    public List<Integer> bioSteps;
    @BundleKey(key = ALBiometricsKeys.KEY_BIZ_CONF)
    public String bizConf;
    @BundleKey(key = ALBiometricsKeys.KEY_CAMERA2_OPEN)
    public boolean camera2Open;
    @BundleKey(key = ALBiometricsKeys.KEY_DATA_COLLECT_INTERVAL)
    public int collectInterval;
    @BundleKey(key = ALBiometricsKeys.KEY_DATA_COLLECT_ENABLED_SENSORS)
    public String enabledSensors;
    @BundleKey(key = ALBiometricsKeys.KEY_FACE_RECOGNIZE_RETRY)
    public boolean faceRecognizeRetry;
    @BundleKey(key = ALBiometricsKeys.KEY_VERIFY_TOKEN)
    public String mVerifyToken;
    @BundleKey(key = ALBiometricsKeys.KEY_START_VERIFY_TYPE)
    public String mVerifyType;
    @BundleKey(key = ALBiometricsKeys.KEY_DATA_COLLECT_MAX_CLICK_COUNT)
    public int maxClickCount;
    @BundleKey(key = ALBiometricsKeys.KEY_DATA_COLLECT_MAX_SENSOR_COUNT)
    public int maxSensorCount;
    @BundleKey(key = ALBiometricsKeys.KEY_DATA_COLLECT_SWITCH)
    public boolean needCollect;
    @BundleKey(key = ALBiometricsKeys.KEY_NEED_ORIGINAL_IMAGE)
    public boolean needOriginalImage;
    @BundleKey(key = ALBiometricsKeys.KEY_STEP_STEPS)
    public List<String> pageSteps;
    @BundleKey(key = ALBiometricsKeys.KEY_REACH_BUSINESS_RETRY_LIMITED)
    public boolean reachBusinessRetryLimit;
    @BundleKey(key = ALBiometricsKeys.KEY_ROTATION_ANGLE_CFG)
    public String rotationAngleCfg;
    @BundleKey(key = ALBiometricsKeys.KEY_SHOW_OHTER_BUTTON)
    public boolean showOtherButton;
    @BundleKey(key = ALBiometricsKeys.KEY_STEP_NAV)
    public boolean stepNav = false;
    @BundleKey(key = ALBiometricsKeys.KEY_STEP_PRIVACY)
    public boolean stepPrivacy = false;
    @BundleKey(key = ALBiometricsKeys.KEY_STEP_RESULT)
    public boolean stepResult = false;
    @BundleKey(key = ALBiometricsKeys.KEY_USERNAME)
    public String userName = "";
    @BundleKey(key = ALBiometricsKeys.KEY_SHOW_CHECK_DIALOG)
    public boolean showCheckDialog = true;
    @BundleKey(key = ALBiometricsKeys.KEY_SOUND_ON)
    public boolean soundOn = true;
    @BundleKey(key = ALBiometricsKeys.KEY_SHOW_SOUND_SWITCH)
    public boolean showSoundSwitch = true;
    @BundleKey(key = ALBiometricsKeys.KEY_SDK_TYPE)
    public int sdkType = 1;
    @BundleKey(key = ALBiometricsKeys.KEY_SUPPORT_X86)
    public boolean supportX86 = false;
    @BundleKey(key = ALBiometricsKeys.KEY_SEC_TOKEN)
    public String secToken = "";
    @BundleKey(key = ALBiometricsKeys.KEY_STEP_ADJUST)
    public boolean stepAdjust = true;
    @BundleKey(key = ALBiometricsKeys.KEY_ACTION_COUNT)
    public int actionCount = 2;
    @BundleKey(key = ALBiometricsKeys.KEY_APP_ID)
    public String appId = "";
    @BundleKey(key = "uid")
    public String uid = "";
    @BundleKey(key = "deviceId")
    public String deviceId = "";
    @BundleKey(key = "sceneId")
    public String sceneId = "";
    @BundleKey(key = ALBiometricsKeys.KEY_FACE_ONLY)
    public boolean faceOnly = false;
    @BundleKey(key = ALBiometricsKeys.KEY_VALID_REGION_LEFT)
    public float validRegionLeft = 0.1f;
    @BundleKey(key = ALBiometricsKeys.KEY_VALID_REGION_RIGHT)
    public float validRegionRight = 0.9f;
    @BundleKey(key = ALBiometricsKeys.KEY_VALID_REGION_TOP)
    public float validRegionTop = 0.1f;
    @BundleKey(key = ALBiometricsKeys.KEY_VALID_REGION_BOTTOM)
    public float validRegionBottom = 0.8f;
    @BundleKey(key = ALBiometricsKeys.KEY_MIN_QUALITY)
    public int minQuality = 25;
    @BundleKey(key = ALBiometricsKeys.KEY_MINE_THRESHOLD)
    public int mineThreshold = 1;
    @BundleKey(key = ALBiometricsKeys.KEY_RETRY_THRESHOLD)
    public int retryThreshold = 5;
    @BundleKey(key = ALBiometricsKeys.KEY_LOG_IMAGES)
    public boolean logImages = false;
    @BundleKey(key = "strategy")
    public int[] strategy = null;
    @BundleKey(key = ALBiometricsKeys.KEY_SAVE_IMAGES_FILE)
    public boolean saveImagesFile = true;
    @BundleKey(key = ALBiometricsKeys.KEY_LESS_IMAGE_MODE)
    public boolean lessImageMode = true;
    @BundleKey(key = ALBiometricsKeys.KEY_BIG_IMAGE_SIZE)
    public int bigImageSize = ABDefaultConfig.DEFAULT_BIG_IMAGE_SIZE;
    @BundleKey(key = ALBiometricsKeys.KEY_DETECT_WRONG_ACTION)
    public boolean detectWrongAction = true;
    @BundleKey(key = ALBiometricsKeys.KEY_DETECT_OCCLUSION)
    public boolean detectOcclusion = true;
    @BundleKey(key = ALBiometricsKeys.KEY_MOTION_BLUR)
    public float motionBlur = 1.0f;
    @BundleKey(key = ALBiometricsKeys.KEY_GUASSIAN_BLUR)
    public float gaussianBlur = 0.8f;
    @BundleKey(key = ALBiometricsKeys.KEY_IMAGE_STRATEGY)
    public int imageStrategy = 1;
    @BundleKey(key = ALBiometricsKeys.KEY_NOFACE_THRESHOLD)
    public int noFaceThreshold = 5;
    @BundleKey(key = ALBiometricsKeys.KEY_ACTIVE_ACTION_THRESHOLD)
    public float activeActionThreshold = 1.1f;
    @BundleKey(key = ALBiometricsKeys.KEY_INACTIVE_ACTION_THRESHOLD)
    public float inactiveActionThreshold = 1.5f;
    @BundleKey(key = ALBiometricsKeys.KEY_YAW_THRESHOLD)
    public float yawThreshold = 0.1f;
    @BundleKey(key = ALBiometricsKeys.KEY_PITCH_THRESHOLD)
    public float pitchThreshold = 0.1f;
    @BundleKey(key = "timeout")
    public int timeout = 40;
    @BundleKey(key = ALBiometricsKeys.KEY_COMPRESS_QUALITY)
    public int compressQuality = 80;
    @BundleKey(key = ALBiometricsKeys.KEY_SENSORDATA_INTERVALS)
    public int sensorDataIntervals = 0;
    @BundleKey(key = ALBiometricsKeys.KEY_REFLECT_IL_THRESHOLD)
    public int reflectILThreshold = 400;
    @BundleKey(key = ALBiometricsKeys.KEY_REFLECT_PREV_FAIL_THRESHOLD)
    public int reflectPrevFailThreshold = 5;
    @BundleKey(key = ALBiometricsKeys.KEY_REFLECT_DISTANCE_THRESHOLD)
    public float reflectDistanceThreshold = 1.0f;
    @BundleKey(key = ALBiometricsKeys.KEY_RECAP_ENABLE)
    public boolean recapEnable = false;
    @BundleKey(key = ALBiometricsKeys.KEY_RECAP_MODE)
    public int recapMode = 1;
    @BundleKey(key = "recapThreshold")
    public float recapThreshold = 60.0f;
    @BundleKey(key = ALBiometricsKeys.KEY_RECAP_MNN_ENABLE)
    public boolean recapMNNEnable = false;
    @BundleKey(key = ALBiometricsKeys.KEY_FACE_IMG_CHECK_ENABLE)
    public boolean faceImgCheckEnable = false;
    @BundleKey(key = ALBiometricsKeys.KEY_FACE_RECOGNIZE_SCORE_THRESHOLD)
    public float faceRecognizeScoreThreshold = 0.54f;
    @BundleKey(key = ALBiometricsKeys.KEY_FACE_RECOGNIZE_TARGET_DATA)
    public byte[] faceRecognizeTargetData = null;
    @BundleKey(key = ALBiometricsKeys.KEY_NEED_DISPLAY_WAITING_VIEW)
    public boolean needDisplayWaitingView = false;
    @BundleKey(key = "actionWhileCheckFail")
    public int actionWhileCheckFail = -1;
    @BundleKey(key = "strategyWhileCheckFail")
    public int[] strategyWhileCheckFail = null;
    @BundleKey(key = ALBiometricsKeys.KEY_IMG_COUNT)
    public int imageCount = 1;
    @BundleKey(key = ALBiometricsKeys.KEY_IMG_INTERVALS)
    public int imageIntervals = 250;
    @BundleKey(key = ALBiometricsKeys.KEY_BG_DETECT_TIME_INTERVALS)
    public int bgDetectTimeIntervals = -1;
    @BundleKey(key = ALBiometricsKeys.KEY_BG_DETECT_COLOR_THRESHOLD)
    public int bgDetectColorThreshold = -1;
    @BundleKey(key = "needSuccessVideo")
    public boolean needSuccessVideo = false;
    @BundleKey(key = "needFailVideo")
    public boolean needFailVideo = false;
    @BundleKey(key = ALBiometricsKeys.KEY_LICENSE_DATA)
    public byte[] licenseData = null;
    @BundleKey(key = ALBiometricsKeys.KEY_LICENSE_TIME_DATA)
    public byte[] licenseTimeData = null;
    @BundleKey(converter = JsonBundleConverter.class, key = ALBiometricsKeys.KEY_BIOMETRICS_CONFIG)
    public BiometricsConfig biometricsConfig = null;
    @BundleKey(key = ALBiometricsKeys.KEY_CAMERA_PREVIEW_SWITCH)
    public boolean cameraPreviewSizeSwitch = true;
    @BundleKey(key = ALBiometricsKeys.KEY_BEAUTY_SWITCH)
    public boolean isBeautyOpen = true;
    public int mBiometricsType = 1;
    @BundleKey(key = ALBiometricsKeys.KEY_CTID_RESULT_CODE)
    public int ctidResultCode = -2;
}
