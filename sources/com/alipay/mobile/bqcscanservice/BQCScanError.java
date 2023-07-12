package com.alipay.mobile.bqcscanservice;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BQCScanError {
    public CameraAPIType apiType;
    public int errorCode;
    public String msg;
    public ErrorType type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alipay.mobile.bqcscanservice.BQCScanError$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ErrorType.values().length];
            a = iArr;
            try {
                iArr[ErrorType.ERROR_CAMERA_OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ErrorType.ERROR_CAMERA_CALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum CameraAPIType {
        API1,
        API2
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CameraErrorAPI1 {
        public static final int ERROR_CODE_DEFAULT = 0;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CameraErrorAPI2 {
        public static final int ERROR_CALLBACK_CAMERA_DEVICE = 1302;
        public static final int ERROR_CALLBACK_CAMERA_DISABLED = 1304;
        public static final int ERROR_CALLBACK_CAMERA_IN_USE = 1300;
        public static final int ERROR_CALLBACK_CAMERA_SERVICE = 1303;
        public static final int ERROR_CALLBACK_MAX_CAMERA_IN_USE = 1301;
        public static final int ERROR_CALLBACK_MAX_CAMERA_IN_USE_OPEN_CAMERA_3000MS_TIMEOUT = 1301001;
        public static final int ERROR_CALLBACK_SESSION_CONFIG_FAIL = 1305;
        public static final int ERROR_CODE_DEFAULT = 1000;
        public static final int ERROR_DEFAULT_DISABLE_CAMERA_POLICY = 1003;
        public static final int ERROR_DEFAULT_DISABLE_CAMERA_POLICY_CAMERA_FUNCTION_DISABLED = 1003004;
        public static final int ERROR_DEFAULT_DISABLE_CAMERA_POLICY_DISABLE_BY_POLICY = 1003001;
        public static final int ERROR_DEFAULT_DISABLE_CAMERA_POLICY_OPEN_FROM_BACKGROUND = 1003002;
        public static final int ERROR_DEFAULT_DISABLE_CAMERA_POLICY_SENSOR_PRIVACY = 1003003;
        public static final int ERROR_DEFAULT_DISABLE_CAMERA_SERVICE = 1001;
        public static final int ERROR_DEFAULT_DISABLE_CAMERA_SERVICE_UNKNOWN_CAMERA_ID = 1001001;
        public static final int ERROR_DEFAULT_ILLEGALARGUMENT_TO_HAL = 1001002;
        public static final int ERROR_DEFAULT_NO_PERMISSION = 1002;
        public static final int ERROR_DEFAULT_NO_PERMISSION_NOT_ACTIVE_USER_USE_CAMERA = 1002001;
        public static final int ERROR_DEFAULT_NO_PERMISSION_NO_CAMERA_PERMISSION = 1002002;
        public static final int ERROR_INIT_CAMERA_CHARACTERISTICS_NULL = 1102;
        public static final int ERROR_INIT_CAMERA_ID_LIST_NULL = 1101;
        public static final int ERROR_INIT_CAMERA_MANAGER_NULL = 1100;
        public static final int ERROR_INIT_ONLY_HAS_FRONT_CAMERA = 1103;
        public static final int ERROR_OPEN_CAMERA_DEVICE_FROM_CALLBACK_ERROR = 1206;
        public static final int ERROR_OPEN_CAMERA_DISCONNECTED = 1200;
        public static final int ERROR_OPEN_CAMERA_DISCONNECTED_CAMERA_DEVICE_UNAVAILABLE = 1200002;
        public static final int ERROR_OPEN_CAMERA_DISCONNECTED_SERVICE_UNAVAILABLE = 1200001;
        public static final int ERROR_OPEN_CAMERA_IN_USE = 1201;
        public static final int ERROR_OPEN_CAMERA_IN_USE_HIGH_PRIORITY_USING = 1201001;
        public static final int ERROR_OPEN_CAMERA_IN_USE_IS_ALREADY_OPEN = 1201002;
        public static final int ERROR_OPEN_CAMERA_SERVICE_ERROR = 1203;
        public static final int ERROR_OPEN_MAX_CAMERA_IN_USE = 1202;
        public static final int ERROR_OPEN_RESTART_CAMERA_ERROR = 1204;
        public static final int ERROR_OPEN_RETRY_CAMERA_FOR_CALLBACK_ERROR = 1205;
        public static final int ERROR_RUNTIME_CAMERA_DEVICE_IN_ERROR = 1400005;
        public static final int ERROR_RUNTIME_CREATE_DEFAULT_TEMPLATE_REQUEST_FAIL = 1400004;
        public static final int ERROR_RUNTIME_DEVICE_DISCONNECTED = 1400001;
        public static final int ERROR_RUNTIME_EACH_REQUEST_MUST_HAS_ONE_SURFACE_AT_LEAST = 1400006;
        public static final int ERROR_RUNTIME_FINALIZE_CONFIGURATION_EXCEPTION = 1401;
        public static final int ERROR_RUNTIME_FUNCTION_NOT_IMPLEMENTED = 1400003;
        public static final int ERROR_RUNTIME_LONG_TIME_NO_FRAME_WITH_ERROR = 1403;
        public static final int ERROR_RUNTIME_SERVICE_DIED_UNEXPECTEDLY = 1400002;
        public static final int ERROR_RUNTIME_SESSION_CREATE_EXCEPTION = 1400;
        public static final int ERROR_RUNTIME_SESSION_CREATE_EXCEPTION_SURFACE_ABANDONED = 1400007;
        public static final int ERROR_RUNTIME_SET_CAPTURE_REQUEST_EXCEPTION = 1402;
        public static final int NO_ERROR = 0;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum ErrorType {
        ERROR_CAMERA_INIT,
        ERROR_CAMERA_OPEN,
        ERROR_CAMERA_CALLBACK,
        ERROR_INIT_ENGINE,
        ERROR_CAMERA_RUNTIME,
        NoError,
        initEngineError,
        CameraOpenError,
        CameraPreviewError,
        ScanTypeNotSupport
    }

    public BQCScanError(ErrorType errorType, String str, int i, CameraAPIType cameraAPIType) {
        this.type = errorType;
        this.msg = str;
        this.errorCode = getInternalErrorCode(cameraAPIType, errorType, i);
        this.apiType = cameraAPIType;
    }

    public static int callbackErrorToInternalErrorCode(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return i;
                        }
                        return 1303;
                    }
                    return 1302;
                }
                return CameraErrorAPI2.ERROR_CALLBACK_CAMERA_DISABLED;
            }
            return 1301;
        }
        return 1300;
    }

    public static int callbackErrorToOpenErrorCode(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return i;
                        }
                        return 1203;
                    }
                    return 1206;
                }
                return 1003;
            }
            return 1202;
        }
        return 1201;
    }

    public static int openErrorToInternalErrorCode(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return i;
                        }
                        return 1202;
                    }
                    return 1201;
                }
                return 1203;
            }
            return 1200;
        }
        return 1003;
    }

    public int getInternalErrorCode(CameraAPIType cameraAPIType, ErrorType errorType, int i) {
        if (CameraAPIType.API1 == cameraAPIType) {
            return i;
        }
        int i2 = AnonymousClass1.a[errorType.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? i : callbackErrorToInternalErrorCode(i);
        }
        return openErrorToInternalErrorCode(i);
    }
}
