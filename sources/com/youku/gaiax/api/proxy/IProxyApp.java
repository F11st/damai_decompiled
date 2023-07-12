package com.youku.gaiax.api.proxy;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u000bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/api/proxy/IProxyApp;", "", "Ltb/wt2;", "appInit", "Landroid/content/res/Resources;", "resources", "Landroid/content/Context;", "applicationContext", "topActivity", "", "isNetworkAvailable", "", "getAppVersionName", "isDaily", "isPre", "isOnline", "getUtdid", "getPlatform", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IProxyApp {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static void appInit(@NotNull IProxyApp iProxyApp) {
            b41.i(iProxyApp, "this");
        }

        @NotNull
        public static String getPlatform(@NotNull IProxyApp iProxyApp) {
            b41.i(iProxyApp, "this");
            return "ANDROID";
        }
    }

    void appInit();

    @Nullable
    Context applicationContext();

    @NotNull
    String getAppVersionName();

    @NotNull
    String getPlatform();

    @NotNull
    String getUtdid();

    boolean isDaily();

    boolean isNetworkAvailable();

    boolean isOnline();

    boolean isPre();

    @Nullable
    Resources resources();

    @Nullable
    Context topActivity();
}
