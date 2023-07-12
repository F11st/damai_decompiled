package tb;

import android.util.SparseArray;
import com.amap.api.services.core.AMapException;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class cf0 {
    public static final int ERROR_ACCS_CUSTOM_FRAME_CB_NULL = -105;
    public static final int ERROR_AUTH_EXCEPTION = -302;
    public static final int ERROR_CONNECT_EXCEPTION = -406;
    public static final int ERROR_CONN_TIME_OUT = -400;
    public static final int ERROR_DATA_LENGTH_NOT_MATCH = -206;
    public static final int ERROR_DATA_TOO_LARGE = -303;
    public static final int ERROR_EXCEPTION = -101;
    public static final int ERROR_GET_PROCESS_NULL = -108;
    public static final int ERROR_HOST_NOT_VERIFY_ERROR = -403;
    public static final int ERROR_IO_EXCEPTION = -404;
    public static final int ERROR_NO_NETWORK = -200;
    public static final int ERROR_NO_STRATEGY = -203;
    @Deprecated
    public static final int ERROR_OPEN_CONNECTION_NULL = -407;
    public static final int ERROR_PARAM_ILLEGAL = -102;
    public static final int ERROR_REMOTE_CALL_FAIL = -103;
    public static final int ERROR_REQUEST_CANCEL = -204;
    public static final int ERROR_REQUEST_FAIL = -201;
    public static final int ERROR_REQUEST_FORBIDDEN_IN_BG = -205;
    public static final int ERROR_REQUEST_TIME_OUT = -202;
    public static final int ERROR_SESSION_INVALID = -301;
    public static final int ERROR_SOCKET_TIME_OUT = -401;
    public static final int ERROR_SSL_ERROR = -402;
    public static final int ERROR_TNET_EXCEPTION = -300;
    public static final int ERROR_TNET_REQUEST_FAIL = -304;
    public static final int ERROR_UNKNOWN = -100;
    public static final int ERROR_UNKNOWN_HOST_EXCEPTION = -405;
    public static final int SC_OK = 200;
    private static SparseArray<String> a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(200, "请求成功");
        a.put(-100, AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        a.put(-101, "发生异常");
        a.put(-102, com.amap.api.maps.AMapException.ILLEGAL_AMAP_ARGUMENT);
        a.put(-103, "远程调用失败");
        a.put(-105, "ACCS自定义帧回调为空");
        a.put(-108, "获取Process失败");
        a.put(-200, ErrorConstant.ERRMSG_NO_NETWORK);
        a.put(ERROR_NO_STRATEGY, "无策略");
        a.put(-202, "请求超时");
        a.put(ERROR_REQUEST_CANCEL, "请求被取消");
        a.put(ERROR_REQUEST_FORBIDDEN_IN_BG, "请求后台被禁止");
        a.put(ERROR_DATA_LENGTH_NOT_MATCH, "请求收到的数据长度与Content-Length不匹配");
        a.put(-300, "Tnet层抛出异常");
        a.put(ERROR_SESSION_INVALID, "Session不可用");
        a.put(ERROR_AUTH_EXCEPTION, "鉴权异常");
        a.put(ERROR_DATA_TOO_LARGE, "自定义帧数据过大");
        a.put(ERROR_TNET_REQUEST_FAIL, "Tnet请求失败");
        a.put(-400, "连接超时");
        a.put(ERROR_SOCKET_TIME_OUT, "Socket超时");
        a.put(ERROR_SSL_ERROR, "SSL失败");
        a.put(ERROR_HOST_NOT_VERIFY_ERROR, "域名未认证");
        a.put(ERROR_IO_EXCEPTION, "IO异常");
        a.put(ERROR_UNKNOWN_HOST_EXCEPTION, "域名不能解析");
        a.put(ERROR_CONNECT_EXCEPTION, "连接异常");
    }

    public static String a(int i, String str) {
        return zh2.e(b(i), ":", str);
    }

    public static String b(int i) {
        return zh2.j(a.get(i));
    }
}
