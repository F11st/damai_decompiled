package com.alibaba.pictures.cornerstone.protocol;

import android.app.Application;
import android.content.Context;
import com.alibaba.pictures.cornerstone.EnvMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\t\u001a\u00020\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\f\u001a\u00020\u000bH&J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H&J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u000bH&J\b\u0010\u0015\u001a\u00020\u000bH&¨\u0006\u0016"}, d2 = {"Lcom/alibaba/pictures/cornerstone/protocol/IAppInfo;", "", "Landroid/content/Context;", "getAppContext", "Landroid/app/Application;", "getApplication", "", "getAppKey", "Lcom/alibaba/pictures/cornerstone/EnvMode;", "getEnv", "getTTID", "", "debugable", "getPackageName", "", "getVersionCode", "()Ljava/lang/Integer;", "getVersionName", "getChannelId", "getAppClientName", "isFullApp", "isPreInstall", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IAppInfo {
    boolean debugable();

    @NotNull
    String getAppClientName();

    @NotNull
    Context getAppContext();

    @Nullable
    String getAppKey();

    @NotNull
    Application getApplication();

    @Nullable
    String getChannelId();

    @NotNull
    EnvMode getEnv();

    @Nullable
    String getPackageName();

    @Nullable
    String getTTID();

    @Nullable
    Integer getVersionCode();

    @Nullable
    String getVersionName();

    boolean isFullApp();

    boolean isPreInstall();
}
