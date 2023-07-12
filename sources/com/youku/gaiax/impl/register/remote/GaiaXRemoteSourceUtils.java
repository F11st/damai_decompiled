package com.youku.gaiax.impl.register.remote;

import com.youku.gaiax.api.proxy.IProxyApp;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R$\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/youku/gaiax/impl/register/remote/GaiaXRemoteSourceUtils;", "", "", "getPlatform", "", "getAppVersion", "getOnlineStatus", "getOnlineStatusText", "appVersion", "Ljava/lang/Long;", "()Ljava/lang/Long;", "setAppVersion", "(Ljava/lang/Long;)V", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXRemoteSourceUtils {
    @NotNull
    public static final GaiaXRemoteSourceUtils INSTANCE = new GaiaXRemoteSourceUtils();
    @Nullable
    private static Long appVersion;

    private GaiaXRemoteSourceUtils() {
    }

    @Nullable
    /* renamed from: getAppVersion  reason: collision with other method in class */
    public final Long m1259getAppVersion() {
        return appVersion;
    }

    @NotNull
    public final String getOnlineStatus() {
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyApp app2 = companion.getInstance().getApp();
        boolean z = false;
        if (app2 != null && app2.isDaily()) {
            return "DAILY_ONLINE";
        }
        IProxyApp app3 = companion.getInstance().getApp();
        if (app3 != null && app3.isPre()) {
            return "PRE_ONLINE";
        }
        IProxyApp app4 = companion.getInstance().getApp();
        if (app4 != null && app4.isOnline()) {
            z = true;
        }
        return z ? "PUBLISH_ONLINE" : "NONE";
    }

    @NotNull
    public final String getOnlineStatusText() {
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyApp app2 = companion.getInstance().getApp();
        boolean z = false;
        if (app2 != null && app2.isDaily()) {
            return "日常";
        }
        IProxyApp app3 = companion.getInstance().getApp();
        if (app3 != null && app3.isPre()) {
            return "预发";
        }
        IProxyApp app4 = companion.getInstance().getApp();
        if (app4 != null && app4.isOnline()) {
            z = true;
        }
        return z ? "线上" : "无";
    }

    @NotNull
    public final String getPlatform() {
        String platform;
        IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
        return (app2 == null || (platform = app2.getPlatform()) == null) ? "" : platform;
    }

    public final void setAppVersion(@Nullable Long l) {
        appVersion = l;
    }

    public final long getAppVersion() {
        String appVersionName;
        if (appVersion == null) {
            IProxyApp app2 = GaiaXProxy.Companion.getInstance().getApp();
            if (app2 == null || (appVersionName = app2.getAppVersionName()) == null) {
                appVersionName = "";
            }
            appVersion = GaiaXRemoteVersionUtils.INSTANCE.parseVersion(b41.r(appVersionName, ""));
        }
        Long l = appVersion;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }
}
