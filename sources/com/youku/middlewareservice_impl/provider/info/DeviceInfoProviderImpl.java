package com.youku.middlewareservice_impl.provider.info;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.alient.oneservice.provider.impl.OneContext;
import com.ta.utdid2.android.utils.SystemProperties;
import com.youku.arch.v3.data.Constants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.DeviceInfoProvider;
import java.io.File;
import java.io.FileFilter;
import tb.b80;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DeviceInfoProviderImpl implements DeviceInfoProvider {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.youku.middlewareservice_impl.provider.info.DeviceInfoProviderImpl.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i = 3; i < name.length(); i++) {
                    if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
    private static final int DEVICEINFO_UNKNOWN = 0;

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getAndroidId() {
        return TelephonyManagerUtil.getAndroidID(AppInfoProviderProxy.getAppContext());
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public int getCPUCoresCount() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return 0;
        }
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getCpuAbi() {
        String str = SystemProperties.get("ro.product.cpu.abi");
        if (TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT >= 21) {
                return Build.SUPPORTED_ABIS[0];
            }
            return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
        }
        return str;
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getCpuInfo() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI();
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getImei() {
        return TelephonyManagerUtil.getImei(AppInfoProviderProxy.getAppContext());
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getImsi() {
        return TelephonyManagerUtil.getMeid(AppInfoProviderProxy.getAppContext());
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getMachineType() {
        return com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getMeid() {
        return TelephonyManagerUtil.getMeid(AppInfoProviderProxy.getAppContext());
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getMemoryInfo() {
        try {
            return String.valueOf((float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d));
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public String getOSVersion() {
        return Build.VERSION.getRELEASE();
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public int getStatusBarHeight() {
        Resources resources = OneContext.getApplicationContext().getResources();
        try {
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", Constants.DIMEN, "android"));
        } catch (Resources.NotFoundException unused) {
            Log.d("getStatusBarHeight", "NotFoundException");
            return 0;
        } catch (Exception e) {
            Log.d("getStatusBarHeight", e.getMessage());
            return 0;
        }
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public int getWindowHeight() {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getMetrics(((WindowManager) OneContext.getApplicationContext().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public int getWindowWidth() {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display.getMetrics(((WindowManager) OneContext.getApplicationContext().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
            return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public boolean is64Device() {
        String cpuAbi = getCpuAbi();
        return !TextUtils.isEmpty(cpuAbi) && cpuAbi.contains("64");
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public boolean isCurrentPageHwMagicWindow(Activity activity) {
        if (activity == null) {
            return false;
        }
        return b80.e(activity);
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public boolean isFoldScreen() {
        return b80.g(AppInfoProviderProxy.getAppContext());
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public boolean isHwMagicWindow() {
        return false;
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public boolean isPad() {
        return b80.m(AppInfoProviderProxy.getAppContext());
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public boolean isTalkBackOpen() {
        try {
            return isTalkBackOpen(OneContext.getApplicationContext());
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public boolean isUseLargeLayout() {
        return false;
    }

    private boolean isTalkBackOpen(Context context) throws RuntimeException {
        if (context == null) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    @Override // com.youku.middlewareservice.provider.info.DeviceInfoProvider
    public boolean isCurrentPageHwMagicWindow(Configuration configuration) {
        if (configuration == null) {
            return false;
        }
        return b80.f(configuration);
    }
}
