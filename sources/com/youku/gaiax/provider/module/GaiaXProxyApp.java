package com.youku.gaiax.provider.module;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.Keep;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import com.ta.utdid2.device.UTDevice;
import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.gaiax.provider.module.util.Utils;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.EnvUrlProviderProxy;
import com.youku.middlewareservice.provider.info.NetworkInfoProviderProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/provider/module/GaiaXProxyApp;", "Lcom/youku/gaiax/api/proxy/IProxyApp;", "Landroid/content/res/Resources;", "resources", "Landroid/content/Context;", "topActivity", "applicationContext", "", "isDaily", "isPre", "isOnline", "", "getUtdid", "isNetworkAvailable", "getAppVersionName", "getPlatform", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXProxyApp implements IProxyApp {
    @Override // com.youku.gaiax.api.proxy.IProxyApp
    public void appInit() {
        IProxyApp.DefaultImpls.appInit(this);
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    @Nullable
    public Context applicationContext() {
        return AppInfoProviderProxy.getApplication();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    @NotNull
    public String getAppVersionName() {
        String versionName = AppInfoProviderProxy.getVersionName();
        b41.h(versionName, "getVersionName()");
        return versionName;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    @NotNull
    public String getPlatform() {
        PictureGaiaXProviderProxy.Companion companion = PictureGaiaXProviderProxy.Companion;
        return companion.isDamaiApp() ? Utils.DAMAI_PLATFORM : companion.isTppApp() ? Utils.TPP_PLATFORM : "ANDORID";
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    @NotNull
    public String getUtdid() {
        String utdid = UTDevice.getUtdid(AppInfoProviderProxy.getApplication());
        b41.h(utdid, "getUtdid(AppInfoProviderProxy.getApplication())");
        return utdid;
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    public boolean isDaily() {
        return EnvUrlProviderProxy.isDaily();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    public boolean isNetworkAvailable() {
        return NetworkInfoProviderProxy.isNetworkAvailable();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    public boolean isOnline() {
        return EnvUrlProviderProxy.isOnline();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    public boolean isPre() {
        return EnvUrlProviderProxy.isPre();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    @Nullable
    public Resources resources() {
        return AppInfoProviderProxy.getApplication().getResources();
    }

    @Override // com.youku.gaiax.api.proxy.IProxyApp
    @Nullable
    public Context topActivity() {
        return AppConfigProviderProxy.topActivity();
    }
}
