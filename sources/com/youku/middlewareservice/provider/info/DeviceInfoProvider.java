package com.youku.middlewareservice.provider.info;

import android.app.Activity;
import android.content.res.Configuration;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface DeviceInfoProvider {
    String getAndroidId();

    int getCPUCoresCount();

    String getCpuAbi();

    String getCpuInfo();

    String getImei();

    String getImsi();

    String getMachineType();

    String getMeid();

    String getMemoryInfo();

    String getOSVersion();

    int getStatusBarHeight();

    int getWindowHeight();

    int getWindowWidth();

    boolean is64Device();

    boolean isCurrentPageHwMagicWindow(Activity activity);

    boolean isCurrentPageHwMagicWindow(Configuration configuration);

    boolean isFoldScreen();

    boolean isHwMagicWindow();

    boolean isPad();

    boolean isTalkBackOpen();

    boolean isUseLargeLayout();
}
