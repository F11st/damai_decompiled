package com.youku.gaiax.provider.module;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.annotation.Keep;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.youku.gaiax.api.proxy.IProxyPrefs;
import com.youku.gaiax.provider.module.GaiaXProxyPrefs;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.resource.utils.WoodpeckerLocalConfigCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\rH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J$\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J+\u0010\u001e\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyPrefs;", "Lcom/youku/gaiax/api/proxy/IProxyPrefs;", "", "id", "key", "", "contains", "Ltb/wt2;", "removeKey", "getString", "def", "", "getInt", "", "getLong", "value", "putString", "putInt", "", "putFloat", "", "putDouble", "putLong", "nameSpace", "defaultValue", "getOrangeConfig", "", WoodpeckerLocalConfigCenter.SP_CONFIGS_KEY, "Lkotlin/Function0;", "success", "registerOrangeInitConfig", "([Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxyPrefs implements IProxyPrefs {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerOrangeInitConfig$lambda-0  reason: not valid java name */
    public static final void m1261registerOrangeInitConfig$lambda0(Function0 function0, String str, boolean z) {
        b41.i(function0, "$success");
        function0.invoke();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public boolean contains(@NotNull String str, @NotNull String str2) {
        SharedPreferences sharedPreferences;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        return (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null || !sharedPreferences.contains(str2)) ? false : true;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public int getInt(@NotNull String str, @NotNull String str2) {
        SharedPreferences sharedPreferences;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null) {
            return 0;
        }
        return sharedPreferences.getInt(str2, 0);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public long getLong(@NotNull String str, @NotNull String str2) {
        SharedPreferences sharedPreferences;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str2, 0L);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    @Nullable
    public String getOrangeConfig(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        b41.i(str, "nameSpace");
        b41.i(str2, "key");
        return OrangeConfig.getInstance().getConfig(str, str2, str3);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    @Nullable
    public String getString(@NotNull String str, @NotNull String str2) {
        SharedPreferences sharedPreferences;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str2, "");
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public void prefsInit() {
        IProxyPrefs.DefaultImpls.prefsInit(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public boolean putDouble(@NotNull String str, @NotNull String str2, double d) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putFloat;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null || (putFloat = edit.putFloat(str2, (float) d)) == null) {
            return true;
        }
        putFloat.apply();
        return true;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public boolean putFloat(@NotNull String str, @NotNull String str2, float f) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putFloat;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null || (putFloat = edit.putFloat(str2, f)) == null) {
            return true;
        }
        putFloat.apply();
        return true;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public boolean putInt(@NotNull String str, @NotNull String str2, int i) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putInt;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null || (putInt = edit.putInt(str2, i)) == null) {
            return true;
        }
        putInt.apply();
        return true;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public boolean putLong(@NotNull String str, @NotNull String str2, long j) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putLong;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null || (putLong = edit.putLong(str2, j)) == null) {
            return true;
        }
        putLong.apply();
        return true;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public boolean putString(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        b41.i(str, "id");
        b41.i(str2, "key");
        b41.i(str3, "value");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null || (putString = edit.putString(str2, str3)) == null) {
            return true;
        }
        putString.apply();
        return true;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public void registerOrangeInitConfig(@NotNull String[] strArr, @NotNull final Function0<wt2> function0) {
        b41.i(strArr, WoodpeckerLocalConfigCenter.SP_CONFIGS_KEY);
        b41.i(function0, "success");
        OrangeConfig.getInstance().registerListener(strArr, new OrangeConfigListenerV1() { // from class: tb.et0
            @Override // com.taobao.orange.OrangeConfigListenerV1
            public final void onConfigUpdate(String str, boolean z) {
                GaiaXProxyPrefs.m1261registerOrangeInitConfig$lambda0(Function0.this, str, z);
            }
        });
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public void removeKey(@NotNull String str, @NotNull String str2) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null || (putString = edit.putString(str2, "")) == null) {
            return;
        }
        putString.apply();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public int getInt(@NotNull String str, @NotNull String str2, int i) {
        SharedPreferences sharedPreferences;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null) {
            return 0;
        }
        return sharedPreferences.getInt(str2, i);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    public long getLong(@NotNull String str, @NotNull String str2, long j) {
        SharedPreferences sharedPreferences;
        b41.i(str, "id");
        b41.i(str2, "key");
        Application application = AppInfoProviderProxy.getApplication();
        if (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(str2, j);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyPrefs
    @NotNull
    public String getString(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        SharedPreferences sharedPreferences;
        String string;
        b41.i(str, "id");
        b41.i(str2, "key");
        b41.i(str3, "def");
        Application application = AppInfoProviderProxy.getApplication();
        return (application == null || (sharedPreferences = application.getSharedPreferences(str, 0)) == null || (string = sharedPreferences.getString(str2, str3)) == null) ? "" : string;
    }
}
