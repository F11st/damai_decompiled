package android.taobao.windvane.packageapp;

import android.taobao.windvane.WindvaneException;
import android.taobao.windvane.packageapp.zipapp.data.ZipGlobalConfig;
import android.webkit.ValueCallback;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVPackageAppConfig implements WVPackageAppConfigInterface {
    @Override // android.taobao.windvane.packageapp.WVPackageAppConfigInterface
    public ZipGlobalConfig getGlobalConfig() {
        return null;
    }

    @Override // android.taobao.windvane.packageapp.WVPackageAppConfigInterface
    public void requestFullConfigNextTime() {
    }

    @Override // android.taobao.windvane.packageapp.WVPackageAppConfigInterface
    public boolean saveLocalConfig(ZipGlobalConfig zipGlobalConfig) {
        return false;
    }

    @Override // android.taobao.windvane.packageapp.WVPackageAppConfigInterface
    public void updateGlobalConfig(boolean z, ValueCallback<ZipGlobalConfig> valueCallback, ValueCallback<WindvaneException> valueCallback2, String str, String str2) {
    }
}
