package com.alibaba.pictures.dolores.response;

import com.amap.api.services.core.AMapException;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/alibaba/pictures/dolores/response/BizResponseType;", "", "", "code", "I", "getCode", "()I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "localDes", "getLocalDes", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "RESULT_SUCCESS", "RESULT_FAIL", "NET_WORK_ERROR", "RESULT_CODE_SESSION_EXPIRED", "RESULT_CODE_INTERCEPTOR_ERROR", "RESULT_CODE_ILLEGAL_SIGN", "RESULT_CODE_LOGIN_CANCELED", "RESULT_NO_CACHE", "RESULT_CACHED", "RESULT_CACHE_EXPIRED", "RESULT_CACHE_ERROR", "NET_OVER_TIME", "PARSE_ERROR_MISS_TRANSFORMER", "PARSE_ERROR_MISS_TRANSFORM_TYPE", "RESPONSE_NULL_ERROR", "PARSE_ERROR", "MTOP_INIT_ERROR", "REQUEST_TASK_CANCELED", "UNKNOWN_ERROR", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public enum BizResponseType {
    RESULT_SUCCESS(0, "请求成功", "业务请求成功"),
    RESULT_FAIL(1, "小二很忙，系统很累，稍后再试吧", "业务请求失败"),
    NET_WORK_ERROR(2, "网络不给力!", "网络连接失败"),
    RESULT_CODE_SESSION_EXPIRED(3, "请先登录后再试！", "登录过期！"),
    RESULT_CODE_INTERCEPTOR_ERROR(5, "小二很忙，系统很累，稍后再试吧", "请求暴露切面处理出错"),
    RESULT_CODE_ILLEGAL_SIGN(7, "小二很忙，系统很累，稍后再试吧", "签名校验失败，非法签名"),
    RESULT_CODE_LOGIN_CANCELED(8, "小二很忙，系统很累，稍后再试吧", "Session 过期，且触发的登录取消"),
    RESULT_NO_CACHE(16, "", "没有缓存"),
    RESULT_CACHED(32, "", "命中缓存"),
    RESULT_CACHE_EXPIRED(48, "", "缓存过期"),
    RESULT_CACHE_ERROR(64, "", "缓存错误"),
    NET_OVER_TIME(80, "网络不给力!", "网络超时"),
    PARSE_ERROR_MISS_TRANSFORMER(96, "小二很忙，系统很累，稍后再试吧", "数据解析错误：缺少数据解析器"),
    PARSE_ERROR_MISS_TRANSFORM_TYPE(98, "小二很忙，系统很累，稍后再试吧", "数据解析错误：没有指定对应bizTypeClass"),
    RESPONSE_NULL_ERROR(99, "小二很忙，系统很累，稍后再试吧", "返回值为null"),
    PARSE_ERROR(100, "小二很忙，系统很累，稍后再试吧", "数据解析出错"),
    MTOP_INIT_ERROR(112, "小二很忙，系统很累，稍后再试吧", "mtop business not init!"),
    REQUEST_TASK_CANCELED(128, "小二很忙，系统很累，稍后再试吧", "请求取消！"),
    UNKNOWN_ERROR(257, "小二很忙，系统很累，稍后再试吧", AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
    
    private final int code;
    @NotNull
    private final String desc;
    @NotNull
    private final String localDes;

    BizResponseType(int i, String str, String str2) {
        this.code = i;
        this.desc = str;
        this.localDes = str2;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getLocalDes() {
        return this.localDes;
    }
}
