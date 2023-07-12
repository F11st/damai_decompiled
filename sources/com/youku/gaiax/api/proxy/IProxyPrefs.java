package com.youku.gaiax.api.proxy;

import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.utils.ConfigUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \"2\u00020\u0001:\u0001\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J \u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000eH&J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H&J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH&J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0013H&J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0015H&J \u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eH&J$\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H&J+\u0010\u001f\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH&¢\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\u0002H\u0002¨\u0006#"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyPrefs;", "", "Ltb/wt2;", "prefsInit", "", "id", "key", "", "contains", "removeKey", "getString", "def", "", "getInt", "", "getLong", "value", "putString", "putInt", "", "putFloat", "", "putDouble", "putLong", "nameSpace", "defaultValue", "getOrangeConfig", "", "arrayOf", "Lkotlin/Function0;", "success", "registerOrangeInitConfig", "([Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "initOrange", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IProxyPrefs {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyPrefs$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        private static final String TAG = "[GaiaX]";

        private Companion() {
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        private static void initOrange(IProxyPrefs iProxyPrefs) {
            iProxyPrefs.registerOrangeInitConfig(new String[]{ConfigUtils.GAIAX_SDK_CONFIG_NAME_SPACE}, new Function0<wt2>() { // from class: com.youku.gaiax.api.proxy.IProxyPrefs$initOrange$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        Log log = Log.INSTANCE;
                        if (log.isLog()) {
                            log.d("[GaiaX]", b41.r("GaiaXOrange配置更新 - ", new JSONObject()));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public static void prefsInit(@NotNull IProxyPrefs iProxyPrefs) {
            b41.i(iProxyPrefs, "this");
            initOrange(iProxyPrefs);
        }
    }

    boolean contains(@NotNull String str, @NotNull String str2);

    int getInt(@NotNull String str, @NotNull String str2);

    int getInt(@NotNull String str, @NotNull String str2, int i);

    long getLong(@NotNull String str, @NotNull String str2);

    long getLong(@NotNull String str, @NotNull String str2, long j);

    @Nullable
    String getOrangeConfig(@NotNull String str, @NotNull String str2, @Nullable String str3);

    @Nullable
    String getString(@NotNull String str, @NotNull String str2);

    @NotNull
    String getString(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void prefsInit();

    boolean putDouble(@NotNull String str, @NotNull String str2, double d);

    boolean putFloat(@NotNull String str, @NotNull String str2, float f);

    boolean putInt(@NotNull String str, @NotNull String str2, int i);

    boolean putLong(@NotNull String str, @NotNull String str2, long j);

    boolean putString(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void registerOrangeInitConfig(@NotNull String[] strArr, @NotNull Function0<wt2> function0);

    void removeKey(@NotNull String str, @NotNull String str2);
}
