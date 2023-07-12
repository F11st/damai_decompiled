package com.alibaba.security.biometrics.service.constants;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class GlobalErrorCode {
    public static final int ERROR_ALGO_CONFIG_FAIL = -10202;
    public static final int ERROR_ALGO_DETECTING_FAIL = -10203;
    public static final int ERROR_ALGO_INIT_FAIL = -10201;
    public static final int ERROR_ALGO_MODEL_COPY_FAIL = -10207;
    public static final int ERROR_ALGO_MUCH_MINE = -10206;
    public static final int ERROR_ALGO_ONLINE_RECOGNIZE_ERROR = -10208;
    public static final int ERROR_ALGO_RECAP_FAIL = -10209;
    public static final int ERROR_ALGO_RECAP_INIT_FAIL = -10216;
    public static final int ERROR_ALGO_REFLECT_FAIL = -10211;
    public static final int ERROR_ALGO_REFLECT_NO_FACE = -10210;
    public static final int ERROR_ALGO_SO_LOAD_FAIL = -10200;
    public static final int ERROR_ALGO_TIMEOUT_ACTION = -10204;
    public static final int ERROR_ALGO_TIMEOUT_ADJUST = -10205;
    public static final int ERROR_BIO_TIMEOUT = -10217;
    public static final int ERROR_BUSINESS_RETRY_REACH_THRESHOLD = -10407;
    public static final int ERROR_CTID = -10415;
    public static final int ERROR_CTID_APP_ERROR = 4007;
    public static final int ERROR_CTID_CANCEL = 4000;
    public static final int ERROR_CTID_DATA_ERROR = 4008;
    public static final int ERROR_CTID_NOT_BINDING = 4006;
    public static final int ERROR_CTID_NO_CERT = 4005;
    public static final int ERROR_CTID_SIGN_OUT = 4003;
    public static final int ERROR_CTID_SYS = 4001;
    public static final int ERROR_CTID_UNINSTALL = 4002;
    public static final int ERROR_CTID_UNREGISTER = 4004;
    public static final int ERROR_DETECT_INTERRUPT = -10406;
    public static final int ERROR_DETECT_NOT_ENOUNGH_IMAGE = -10212;
    public static final int ERROR_DEVICE_CAMERA_DATA_FAIL = -10106;
    public static final int ERROR_DEVICE_CAMERA_INIT = -10102;
    public static final int ERROR_DEVICE_CAMERA_NO_PERMISSION = -10103;
    public static final int ERROR_DEVICE_CPU_NOT_SUPPORT = -10104;
    public static final int ERROR_DEVICE_HW_MAGIC_WINDOW = -10107;
    public static final int ERROR_DEVICE_NOT_SUPPORT_NEON = -10100;
    public static final int ERROR_DEVICE_NOT_SUPPORT_X86 = -10105;
    public static final int ERROR_DEVICE_NO_CAMERA = -10101;
    public static final int ERROR_INIT = -10400;
    public static final int ERROR_INNER_MORTAL = -10408;
    public static final int ERROR_INVALID_TIMESTAMP_EXPIRED = -10413;
    public static final int ERROR_ONLINE_NET_ERROR = -10300;
    public static final int ERROR_PROCESS_RESTART_OR_LOW_MEMORY = -10414;
    public static final int ERROR_REPEAT_VERIFY = -10404;
    public static final int ERROR_SERVER_CODE_3001 = 3001;
    public static final int ERROR_SERVER_CODE_3101 = 3101;
    public static final int ERROR_SERVER_CODE_3102 = 3102;
    public static final int ERROR_SERVER_CODE_3103 = 3103;
    public static final int ERROR_SERVER_CODE_3104 = 3104;
    public static final int ERROR_SERVER_CODE_3203 = 3203;
    public static final int ERROR_SERVER_CODE_3204 = 3204;
    public static final int ERROR_SERVER_CODE_3206 = 3206;
    public static final int ERROR_SERVER_CODE_3208 = 3208;
    public static final int ERROR_SG = -10403;
    public static final int ERROR_STATUS_CARD_FRONT_NO_EXIST = 13;
    public static final int ERROR_STATUS_CARD_ILLEGAL_COPY = 8;
    public static final int ERROR_STATUS_FACE_CARD_NOT_MATCH = 6;
    public static final int ERROR_STATUS_FACE_FACE_NOT_MATCH = 10;
    public static final int ERROR_STATUS_FACE_OR_CARD_POLICE_NOT_MATCH = 7;
    public static final int ERROR_STATUS_OCR_CARD_EXPIRED = 5;
    public static final int ERROR_STATUS_OCR_CARD_NAME_NOT_MATCH = 3;
    public static final int ERROR_STATUS_OCR_CARD_NUM_NOT_MATCH = 4;
    public static final int ERROR_STATUS_POLICE_PHOTO_ERROR = 11;
    public static final int ERROR_STATUS_POLICE_SYSTEM_ERROR = 12;
    public static final int ERROR_STATUS_REAL_NAME_CHECK_FAIL = 2;
    public static final int ERROR_STATUS_RISK_FACE = 9;
    public static final int ERROR_TOKEN_EMPTY = -10401;
    public static final int ERROR_TOUCH_TOO_MUCH_MINE_ACTION = -10213;
    public static final int ERROR_TOUCH_TOO_MUCH_MINE_FACE = -10214;
    public static final int ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION = -10215;
    public static final int ERROR_TOUCH_TOO_MUCH_MINE_OTHER = -10219;
    public static final int ERROR_UNKNOWN = -10000;
    public static final int ERROR_UPLOAD_BIO_DATA = -10303;
    public static final int ERROR_UPLOAD_BIO_PIC_ERROR = -10301;
    public static final int ERROR_URL_EMPTY = -10402;
    public static final int ERROR_USER_EXIT = -1;
    public static final int ERROR_USER_RETRY_LIMITED = -10405;
    public static final int ERROR_VERIFY_BIO_DATA = -10302;
    public static final int ERROR_WEBVIEW_LOAD_FAIL = -10500;
    public static final int INIT = -99999;
    public static final int SUCCESS = 0;

    public static String mappingResultCode(int i) {
        if (i != -10500) {
            if (i != -10415) {
                if (i != -10413) {
                    if (i != -10219) {
                        if (i != -10000) {
                            if (i != -1) {
                                if (i != 0) {
                                    switch (i) {
                                        case ERROR_BUSINESS_RETRY_REACH_THRESHOLD /* -10407 */:
                                        case ERROR_USER_RETRY_LIMITED /* -10405 */:
                                            return "-50";
                                        case ERROR_DETECT_INTERRUPT /* -10406 */:
                                        case ERROR_REPEAT_VERIFY /* -10404 */:
                                        case ERROR_SG /* -10403 */:
                                        case ERROR_URL_EMPTY /* -10402 */:
                                        case ERROR_TOKEN_EMPTY /* -10401 */:
                                        case ERROR_INIT /* -10400 */:
                                            return "-40";
                                        default:
                                            switch (i) {
                                                case ERROR_VERIFY_BIO_DATA /* -10302 */:
                                                case ERROR_UPLOAD_BIO_PIC_ERROR /* -10301 */:
                                                case ERROR_ONLINE_NET_ERROR /* -10300 */:
                                                    return "-30";
                                                default:
                                                    switch (i) {
                                                        case ERROR_BIO_TIMEOUT /* -10217 */:
                                                        case ERROR_ALGO_RECAP_INIT_FAIL /* -10216 */:
                                                        case ERROR_TOUCH_TOO_MUCH_MINE_OCCLUSION /* -10215 */:
                                                        case ERROR_TOUCH_TOO_MUCH_MINE_FACE /* -10214 */:
                                                        case ERROR_TOUCH_TOO_MUCH_MINE_ACTION /* -10213 */:
                                                        case ERROR_DETECT_NOT_ENOUNGH_IMAGE /* -10212 */:
                                                            return "-20";
                                                        default:
                                                            switch (i) {
                                                                case ERROR_ALGO_REFLECT_NO_FACE /* -10210 */:
                                                                case ERROR_ALGO_RECAP_FAIL /* -10209 */:
                                                                case ERROR_ALGO_ONLINE_RECOGNIZE_ERROR /* -10208 */:
                                                                case ERROR_ALGO_MODEL_COPY_FAIL /* -10207 */:
                                                                case ERROR_ALGO_MUCH_MINE /* -10206 */:
                                                                case ERROR_ALGO_TIMEOUT_ADJUST /* -10205 */:
                                                                case ERROR_ALGO_TIMEOUT_ACTION /* -10204 */:
                                                                case ERROR_ALGO_DETECTING_FAIL /* -10203 */:
                                                                case ERROR_ALGO_CONFIG_FAIL /* -10202 */:
                                                                case ERROR_ALGO_INIT_FAIL /* -10201 */:
                                                                case ERROR_ALGO_SO_LOAD_FAIL /* -10200 */:
                                                                    return "-20";
                                                                default:
                                                                    switch (i) {
                                                                        case ERROR_DEVICE_HW_MAGIC_WINDOW /* -10107 */:
                                                                        case ERROR_DEVICE_CAMERA_DATA_FAIL /* -10106 */:
                                                                        case ERROR_DEVICE_NOT_SUPPORT_X86 /* -10105 */:
                                                                        case ERROR_DEVICE_CPU_NOT_SUPPORT /* -10104 */:
                                                                        case ERROR_DEVICE_CAMERA_NO_PERMISSION /* -10103 */:
                                                                        case ERROR_DEVICE_CAMERA_INIT /* -10102 */:
                                                                        case ERROR_DEVICE_NO_CAMERA /* -10101 */:
                                                                        case ERROR_DEVICE_NOT_SUPPORT_NEON /* -10100 */:
                                                                            return "-10";
                                                                        default:
                                                                            switch (i) {
                                                                                case 2:
                                                                                case 3:
                                                                                case 4:
                                                                                case 5:
                                                                                case 6:
                                                                                case 7:
                                                                                case 8:
                                                                                case 9:
                                                                                case 10:
                                                                                case 11:
                                                                                case 12:
                                                                                case 13:
                                                                                    return "2";
                                                                                default:
                                                                                    return String.valueOf(i);
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                }
                                return "0";
                            }
                            return "-1";
                        }
                        return "-10000";
                    }
                    return "-20";
                }
                return "-60";
            }
            return "-40";
        }
        return "-50";
    }
}
