package com.alibaba.ability.env;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0001H\u0016J\u001f\u0010\r\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00018&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/alibaba/ability/env/IAbilityContext;", "", "Landroid/view/View;", "view", "withInvokeView", "Lcom/alibaba/ability/env/IAbilityEnv;", "getAbilityEnv", "getInvokeView", "", "key", "data", "withUserData", "T", "getUserData", "(Ljava/lang/String;)Ljava/lang/Object;", "getEnv", "()Lcom/alibaba/ability/env/IAbilityEnv;", "setEnv", "(Lcom/alibaba/ability/env/IAbilityEnv;)V", "env", "Ljava/lang/ref/WeakReference;", "getInvokeViewRef", "()Ljava/lang/ref/WeakReference;", "setInvokeViewRef", "(Ljava/lang/ref/WeakReference;)V", "invokeViewRef", "getUserContext", "()Ljava/lang/Object;", "setUserContext", "(Ljava/lang/Object;)V", "userContext", "", "getUserDataMap", "()Ljava/util/Map;", "setUserDataMap", "(Ljava/util/Map;)V", "userDataMap", "megability_interface_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes9.dex */
public interface IAbilityContext {

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a {
        @NotNull
        public static IAbilityEnv a(@NotNull IAbilityContext iAbilityContext) {
            IAbilityEnv env = iAbilityContext.getEnv();
            b41.f(env);
            return env;
        }

        @Nullable
        public static View b(@NotNull IAbilityContext iAbilityContext) {
            WeakReference<View> invokeViewRef = iAbilityContext.getInvokeViewRef();
            if (invokeViewRef != null) {
                return invokeViewRef.get();
            }
            return null;
        }

        @Nullable
        public static <T> T c(@NotNull IAbilityContext iAbilityContext, @NotNull String str) {
            b41.i(str, "key");
            Map<String, Object> userDataMap = iAbilityContext.getUserDataMap();
            Object obj = userDataMap != null ? userDataMap.get(str) : null;
            if (obj instanceof Object) {
                return (T) obj;
            }
            return null;
        }

        @NotNull
        public static IAbilityContext d(@NotNull IAbilityContext iAbilityContext, @Nullable View view) {
            if (view != null) {
                iAbilityContext.setInvokeViewRef(new WeakReference<>(view));
            }
            return iAbilityContext;
        }

        @NotNull
        public static IAbilityContext e(@NotNull IAbilityContext iAbilityContext, @NotNull String str, @NotNull Object obj) {
            b41.i(str, "key");
            b41.i(obj, "data");
            if (iAbilityContext.getUserDataMap() == null) {
                iAbilityContext.setUserDataMap(new LinkedHashMap());
            }
            Map<String, Object> userDataMap = iAbilityContext.getUserDataMap();
            b41.f(userDataMap);
            userDataMap.put(str, obj);
            return iAbilityContext;
        }
    }

    @NotNull
    IAbilityEnv getAbilityEnv();

    @Nullable
    IAbilityEnv getEnv();

    @Nullable
    View getInvokeView();

    @Nullable
    WeakReference<View> getInvokeViewRef();

    @Nullable
    Object getUserContext();

    @Nullable
    <T> T getUserData(@NotNull String str);

    @Nullable
    Map<String, Object> getUserDataMap();

    void setEnv(@Nullable IAbilityEnv iAbilityEnv);

    void setInvokeViewRef(@Nullable WeakReference<View> weakReference);

    void setUserContext(@Nullable Object obj);

    void setUserDataMap(@Nullable Map<String, Object> map);

    @NotNull
    IAbilityContext withInvokeView(@Nullable View view);

    @NotNull
    IAbilityContext withUserData(@NotNull String str, @NotNull Object obj);
}
