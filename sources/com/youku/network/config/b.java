package com.youku.network.config;

import android.util.SparseArray;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.network.d;
import com.youku.upsplayer.network.ErrorConstants;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class b {
    private static SparseArray<String> a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(-3014, "无异常信息");
        a.put(-3000, "未知异常");
        a.put(AVFSCacheConstants.AVFS_ERROR_FILE_READ, "容器初始化异常");
        a.put(AVFSCacheConstants.AVFS_ERROR_FILE_INDEX_MISS, "Networksdk_数据流读取异常");
        a.put(AVFSCacheConstants.AVFS_ERROR_FILE_WRITE, "OkHttp_解析Response失败");
        a.put(-3004, "OkHttp_异步请求失败");
        a.put(-3005, "OkHttp_同步请求失败");
        a.put(-3006, "OkHttp_请求构造异常");
        a.put(-3007, "OkHttp_Socket异常");
        a.put(-3008, "OkHttp_Socket超时");
        a.put(-3009, "OkHttp_unknownService");
        a.put(AVFSCacheConstants.AVFS_ERROR_FILE_DESERIALIZATION, "OkHttp_域名不能解析");
        a.put(AVFSCacheConstants.AVFS_ERROR_FILE_SERIALIZATION, "OkHttp_连接异常");
        a.put(-3012, "OkHttp_SSL异常");
        a.put(-3013, "OkHttp_没有找到路由");
        a.put(-3015, "OKHTTP_解析header失败");
        a.put(-3016, "OKHTTP_Response过大");
        a.put(-3017, "OKHTTP_超时");
        a.put(-3018, "OKHTTP_无网络库");
    }

    public static int a(int i, int i2) {
        if (i <= -100) {
            if (i == -400) {
                return ErrorConstants.REQUEST_ERROR_CODE_NO_RESPONSE;
            }
            if (i != -103 && i != -401) {
                return Math.abs(i) + 29000;
            }
        } else if (i2 <= -3015 || i2 > -3000) {
            return (i2 < -4076 || i2 >= -4000) ? i > 0 ? i + 20000 : i : i2 + 32177;
        } else if (i2 == -3001) {
            return ErrorConstants.NET_WORK_INIT_ERROR;
        } else {
            if (i2 == -3002) {
                return ErrorConstants.NET_WORK_READ_ERROR;
            }
            if (i2 != -3008) {
                return Math.abs(i2) + 26900;
            }
        }
        return ErrorConstants.REQUEST_ERROR_CODE_SOCKET_TIMEOUT;
    }

    public static d a(d dVar, IOException iOException, int i) {
        int i2;
        if (iOException == null) {
            i2 = -3014;
        } else if (iOException instanceof NoRouteToHostException) {
            i2 = -3013;
        } else if (iOException instanceof ConnectException) {
            i2 = AVFSCacheConstants.AVFS_ERROR_FILE_SERIALIZATION;
        } else if (iOException instanceof SocketException) {
            i2 = -3007;
        } else if (iOException instanceof SocketTimeoutException) {
            i2 = -3008;
        } else if (iOException instanceof UnknownServiceException) {
            i2 = -3009;
        } else if (iOException instanceof UnknownHostException) {
            i2 = AVFSCacheConstants.AVFS_ERROR_FILE_DESERIALIZATION;
        } else if (!(iOException instanceof SSLPeerUnverifiedException)) {
            dVar.a(i);
            return dVar;
        } else {
            i2 = -3012;
        }
        dVar.a(i2);
        return dVar;
    }

    public static boolean a(int i) {
        return a.get(i) != null;
    }
}
