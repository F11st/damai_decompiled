package com.youku.arch.v3.token;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u001f\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0005R\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/youku/arch/v3/token/StrategyTokenManager;", "T", "", "Lcom/youku/arch/v3/token/StrategyTokenJavaBean;", "raw", "Ltb/wt2;", "addToken", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "tokenKey", "getToken", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "parseTokenRaw", "(Landroid/content/Context;Lcom/youku/arch/v3/token/StrategyTokenJavaBean;)Ljava/lang/Object;", "getMapAsStringValue", "resetCache", "Ljava/util/concurrent/ConcurrentHashMap;", "tokenMap", "Ljava/util/concurrent/ConcurrentHashMap;", "cacheTokenValueMap", "deviceType", "Ljava/lang/String;", "getDeviceType", "()Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class StrategyTokenManager<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private ConcurrentHashMap<String, StrategyTokenJavaBean> tokenMap = new ConcurrentHashMap<>();
    @NotNull
    private ConcurrentHashMap<String, T> cacheTokenValueMap = new ConcurrentHashMap<>();
    @NotNull
    private final String deviceType = "dev_phone";

    public final void addToken(@NotNull StrategyTokenJavaBean strategyTokenJavaBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549278459")) {
            ipChange.ipc$dispatch("-549278459", new Object[]{this, strategyTokenJavaBean});
            return;
        }
        b41.i(strategyTokenJavaBean, "raw");
        ConcurrentHashMap<String, StrategyTokenJavaBean> concurrentHashMap = this.tokenMap;
        String str = strategyTokenJavaBean.token;
        b41.h(str, "raw.token");
        concurrentHashMap.put(str, strategyTokenJavaBean);
    }

    @NotNull
    public final String getDeviceType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1581352517") ? (String) ipChange.ipc$dispatch("-1581352517", new Object[]{this}) : this.deviceType;
    }

    @NotNull
    public final String getMapAsStringValue(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1044981061")) {
            return (String) ipChange.ipc$dispatch("-1044981061", new Object[]{this, context});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        JSONObject jSONObject = new JSONObject();
        for (String str : this.tokenMap.keySet()) {
            b41.h(str, "token");
            jSONObject.put((JSONObject) str, String.valueOf(getToken(context, str)));
        }
        String jSONString = jSONObject.toJSONString();
        b41.h(jSONString, "jsonObject.toJSONString()");
        return jSONString;
    }

    @Nullable
    public final T getToken(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246551044")) {
            return (T) ipChange.ipc$dispatch("-1246551044", new Object[]{this, context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "tokenKey");
        if (this.cacheTokenValueMap.containsKey(str)) {
            return this.cacheTokenValueMap.get(str);
        }
        if (this.tokenMap.get(str) != null) {
            StrategyTokenJavaBean strategyTokenJavaBean = this.tokenMap.get(str);
            b41.f(strategyTokenJavaBean);
            b41.h(strategyTokenJavaBean, "tokenMap[tokenKey]!!");
            T parseTokenRaw = parseTokenRaw(context, strategyTokenJavaBean);
            this.cacheTokenValueMap.put(str, parseTokenRaw);
            return parseTokenRaw;
        }
        return null;
    }

    public abstract T parseTokenRaw(@NotNull Context context, @NotNull StrategyTokenJavaBean strategyTokenJavaBean);

    public final void resetCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715967892")) {
            ipChange.ipc$dispatch("-1715967892", new Object[]{this});
        } else {
            this.cacheTokenValueMap.clear();
        }
    }
}
