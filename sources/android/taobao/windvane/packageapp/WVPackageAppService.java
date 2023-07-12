package android.taobao.windvane.packageapp;

import android.taobao.windvane.config.EnvEnum;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPackageAppService {
    private static IPackageZipPrefixAdapter packageZipPrefixAdapter;
    private static WVPackageAppConfigInterface wvPackageApp;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface IPackageZipPrefixAdapter {
        String getPackageZipPrefix(EnvEnum envEnum, boolean z);
    }

    public static IPackageZipPrefixAdapter getPackageZipPrefixAdapter() {
        return packageZipPrefixAdapter;
    }

    public static WVPackageAppConfigInterface getWvPackageAppConfig() {
        return wvPackageApp;
    }

    public static void registerWvPackageAppConfig(WVPackageAppConfigInterface wVPackageAppConfigInterface) {
        wvPackageApp = wVPackageAppConfigInterface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setPackageZipPrefixAdapter(IPackageZipPrefixAdapter iPackageZipPrefixAdapter) {
        packageZipPrefixAdapter = iPackageZipPrefixAdapter;
    }
}
