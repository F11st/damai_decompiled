package com.youku.middlewareservice.provider.info;

import android.app.Application;
import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface AppInfoProvider {
    public static final String String_YOUKU = "Youku";
    public static final String String_YOUKU_Lite = "YoukuLite";

    String getAppActiveTime();

    String getAppActiveVersion();

    Context getAppContext();

    String getAppKey();

    String getAppType();

    Application getApplication();

    String getChannel();

    String getCurrentProcessName();

    String getManufacturedAppType();

    String getPackageName();

    String getPreInstallBrand();

    String getTTID();

    int getVersionCode();

    String getVersionName();

    boolean isAbi64FromApk();

    boolean isDebuggable();

    boolean isFullApp();

    boolean isHuaweiCarPreInstall();

    boolean isHuaweiPreInstall();

    boolean isManufacturedApp();

    boolean isMicroApp();

    boolean isPreInstallPackage();

    boolean isTudou();

    boolean isYouku();
}
