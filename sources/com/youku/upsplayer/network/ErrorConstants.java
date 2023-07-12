package com.youku.upsplayer.network;

import android.text.TextUtils;
import android.util.SparseArray;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ErrorConstants {
    public static final int CKEY_ERROR = 28002;
    public static final int ERROR_ASYN_ONFAILURE = 3004;
    public static final int ERROR_CONNECT_EXCEPTION = 3011;
    public static final int ERROR_CONSTRUCT_FAILURE = 3006;
    public static final int ERROR_INIT = 3001;
    public static final int ERROR_NETWORKSDK_READ_STREAM = 3002;
    public static final int ERROR_NO_EXCEPTION_MESSAGE = 3014;
    public static final int ERROR_NO_ROUTE_HOST = 3013;
    public static final int ERROR_READ_RESPONSE = 3003;
    public static final int ERROR_SOCKET_EXCEPTION = 3007;
    public static final int ERROR_SOCKET_TIME_OUT = 3008;
    public static final int ERROR_SSL_EXCEPTION = 3012;
    public static final int ERROR_SYN_ONFAILURE = 3005;
    public static final int ERROR_UNKNOWN = 3000;
    public static final int ERROR_UNKNOWN_HOST = 3010;
    public static final int ERROR_UNKNOWN_SERVICE = 3009;
    public static final int ERROR_UPS_WEB_ANTI = 28109;
    public static final int ERROR_UPS_WEB_FLOW_LIMIT = 28110;
    public static final int JSON_SYNTAX = 28001;
    public static final int NET_WORK_INIT_ERROR = 29001;
    public static final int NET_WORK_READ_ERROR = 29002;
    public static final int REQUEST_ERROR_CODE_NO_RESPONSE = 20101;
    public static final int REQUEST_ERROR_CODE_SOCKET_TIMEOUT = 20103;
    private static SparseArray<String> errorMap;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        errorMap = sparseArray;
        sparseArray.put(3014, "无异常信息");
        errorMap.put(3000, "未知异常");
        errorMap.put(3001, "容器初始化异常");
        errorMap.put(3002, "Networksdk_数据流读取异常");
        errorMap.put(3003, "解析Response失败");
        errorMap.put(3004, "异步请求失败");
        errorMap.put(3005, "同步请求失败");
        errorMap.put(3006, "请求构造异常");
        errorMap.put(3007, "Socket异常");
        errorMap.put(3008, "Socket超时");
        errorMap.put(3009, "UnknownService");
        errorMap.put(3010, "域名不能解析");
        errorMap.put(3011, "连接异常");
        errorMap.put(3012, "SSL异常");
        errorMap.put(3013, "没有找到路由");
        errorMap.put(28001, "Json解析错误");
        errorMap.put(ERROR_UPS_WEB_ANTI, "防刷错误");
        errorMap.put(ERROR_UPS_WEB_FLOW_LIMIT, "限流错误");
    }

    public static boolean containError(int i) {
        return errorMap.get(i) != null;
    }

    public static int converRespondCode(int i) {
        if (i == 28001 || i == 28109 || i == 28110) {
            return i;
        }
        if (i > -500 && i <= -100) {
            if (i != -400) {
                if (i != -103 && i != -401) {
                    return Math.abs(i) + 29000;
                }
                return REQUEST_ERROR_CODE_SOCKET_TIMEOUT;
            }
            return REQUEST_ERROR_CODE_NO_RESPONSE;
        } else if (i < 3015 && i >= 3000) {
            if (i != 3000) {
                if (i == 3001) {
                    return NET_WORK_INIT_ERROR;
                }
                if (i == 3002) {
                    return NET_WORK_READ_ERROR;
                }
                if (i != 3008) {
                    return Math.abs(i) + 26900;
                }
                return REQUEST_ERROR_CODE_SOCKET_TIMEOUT;
            }
            return REQUEST_ERROR_CODE_NO_RESPONSE;
        } else if (i > 4076 || i <= 4000) {
            if (i <= 0) {
                if ((i > -6001 || i < -6009) && i != -5001) {
                    return i;
                }
                i = Math.abs(i);
            }
            return i + 20000;
        } else {
            return 32177 - i;
        }
    }

    public static String getErrorMsg(int i) {
        if (i == 3000) {
            return "";
        }
        String str = errorMap.get(i);
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static int getJsonSyntaxErrorCode() {
        return 28001;
    }

    public static int getReadResponseErrorCode() {
        return 3003;
    }

    public static int judgeException(IOException iOException) {
        if (iOException instanceof NoRouteToHostException) {
            return 3013;
        }
        if (iOException instanceof ConnectException) {
            return 3011;
        }
        if (iOException instanceof SocketException) {
            return 3007;
        }
        if (iOException instanceof SocketTimeoutException) {
            return 3008;
        }
        if (iOException instanceof UnknownServiceException) {
            return 3009;
        }
        if (iOException instanceof UnknownHostException) {
            return 3010;
        }
        return iOException instanceof SSLException ? 3012 : 3000;
    }
}
