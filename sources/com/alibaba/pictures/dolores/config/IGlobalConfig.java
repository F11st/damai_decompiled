package com.alibaba.pictures.dolores.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/alibaba/pictures/dolores/config/IGlobalConfig;", "", "Lcom/alibaba/pictures/dolores/config/IGlobalConfig$Key;", "key", "", "default", "getGlobalConfig", "Key", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IGlobalConfig {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/alibaba/pictures/dolores/config/IGlobalConfig$Key;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "valueDesc", "getValueDesc", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "WUA_SWITCH", "IS_GET", "IS_USE_HTTPS", "PROJECT_NAME", "NEED_LOGIN_FOR_ALL_REQ", "GENERAL_REQUEST_ERROR_MSG", "DOLORES_API_WHITE_LIST", "PREFETCH_BLACK_LIST", "dolores_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public enum Key {
        WUA_SWITCH("wuaSwitch", "on|off"),
        IS_GET("isGet", "true|false"),
        IS_USE_HTTPS("isGet", "true|false"),
        PROJECT_NAME("projectName", "project name"),
        NEED_LOGIN_FOR_ALL_REQ("needLoginForAll", "true|false,need login for all request"),
        GENERAL_REQUEST_ERROR_MSG("generalErrorMsg", "app业务层通用透出的错误tip"),
        DOLORES_API_WHITE_LIST("doloresWhiteList", "白名单"),
        PREFETCH_BLACK_LIST("prefetchBlackList", "数据预加载黑名单");
        
        @NotNull
        private final String key;
        @NotNull
        private final String valueDesc;

        Key(String str, String str2) {
            this.key = str;
            this.valueDesc = str2;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final String getValueDesc() {
            return this.valueDesc;
        }
    }

    @Nullable
    String getGlobalConfig(@NotNull Key key, @Nullable String str);
}
