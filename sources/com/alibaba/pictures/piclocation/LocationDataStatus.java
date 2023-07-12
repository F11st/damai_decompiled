package com.alibaba.pictures.piclocation;

import com.amap.api.services.core.AMapException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/alibaba/pictures/piclocation/LocationDataStatus;", "", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "setDes", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "CACHE", "NOCACHE", "NOTINIT", "NOPERMISSION", "TIMEOUT", "GETFAILED", "BLACKLIST", "NOTAGREEPRIVACY", "UNKNOW", "location_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public enum LocationDataStatus {
    CACHE(200, "有缓存"),
    NOCACHE(300, "无缓存"),
    NOTINIT(400, "没初始化"),
    NOPERMISSION(500, "没权限"),
    TIMEOUT(600, "超时"),
    GETFAILED(700, "接口失败"),
    BLACKLIST(800, "黑名单"),
    NOTAGREEPRIVACY(900, "未调用隐私合规接口"),
    UNKNOW(999, AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
    
    private int code;
    @NotNull
    private String des;

    LocationDataStatus(int i, String str) {
        this.code = i;
        this.des = str;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getDes() {
        return this.des;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setDes(@NotNull String str) {
        b41.i(str, "<set-?>");
        this.des = str;
    }
}
