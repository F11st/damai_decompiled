package com.youku.gaiax;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"Lcom/youku/gaiax/IEnvConfig;", "", "Lcom/alibaba/fastjson/JSONObject;", "getConfigs", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IEnvConfig {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @NotNull
        public static JSONObject getConfigs(@NotNull IEnvConfig iEnvConfig) {
            b41.i(iEnvConfig, "this");
            return new JSONObject();
        }
    }

    @NotNull
    JSONObject getConfigs();
}
