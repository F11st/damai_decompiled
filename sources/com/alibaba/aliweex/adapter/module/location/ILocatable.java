package com.alibaba.aliweex.adapter.module.location;

import com.taobao.weex.WXSDKInstance;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface ILocatable {
    public static final String ADDRESS = "address";
    public static final String COORDS = "coords";
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MSG = "errorMsg";
    public static final int REQUEST_CUR_PERMISSION_CODE = 18;
    public static final String REQUEST_PERMISSION_CODE = "requestCode";
    public static final int REQUEST_WATCH_PERMISSION_CODE = 19;
    public static final String WATCH_ID = "watchId";

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface ErrorCode {
        public static final int LOCATION_ERROR = 9003;
        public static final int LOCATION_TIME_OUT = 9004;
        public static final int NO_PERMISSION_ERROR = 90001;
        public static final int PARAMS_ERROR = 90002;
        public static final int SUCCESS = 90000;
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface ErrorMsg {
        public static final String LOCATION_ERROR = "LOCATION_FAIL";
        public static final String LOCATION_TIME_OUT = "LOCATION_TIME_OUT";
        public static final String NO_PERMISSION_ERROR = "NO PERMISSION";
        public static final String PARAMS_ERROR = "PARAMS_ERROR";
        public static final String SUCCESS = "SUCCESS";
    }

    void clearWatch(String str);

    void destroy();

    void getCurrentPosition(String str, String str2, String str3);

    void setWXSDKInstance(WXSDKInstance wXSDKInstance);

    void watchPosition(String str, String str2, String str3);
}
