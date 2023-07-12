package android.taobao.windvane.packageapp;

import android.app.Application;
import android.content.Context;
import android.taobao.windvane.config.WVLocaleConfig;
import android.taobao.windvane.packageapp.WVPackageAppService;
import android.taobao.windvane.packageapp.adaptive.IZCacheFirstUpdateFinishCallback;
import android.taobao.windvane.packageapp.adaptive.InitZCacheTask;
import android.taobao.windvane.util.CommonUtils;
import com.taobao.zcache.ZCacheInitTask;
import com.taobao.zcache.ZCacheInitializer;
import com.taobao.zcache.ZCacheManager;
import com.taobao.zcache.ZCacheSDK;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPackageAppManager {
    private static WVPackageAppManager appManager;
    private IZCacheFirstUpdateFinishCallback updateFinishCallback;

    public static WVPackageAppManager getInstance() {
        if (appManager == null) {
            synchronized (WVPackageAppManager.class) {
                if (appManager == null) {
                    appManager = new WVPackageAppManager();
                }
            }
        }
        return appManager;
    }

    public IZCacheFirstUpdateFinishCallback getUpdateFinishCallback() {
        return this.updateFinishCallback;
    }

    public void init(Context context, boolean z) {
        try {
            if (CommonUtils.isMainProcess(context)) {
                new InitZCacheTask().init((Application) context, null);
                WVLocaleConfig.getInstance().init();
                ZCacheInitTask.getInstance().init();
                ZCacheSDK.initExtra();
                ZCacheInitializer.initConfig();
                ZCacheManager.instance().installPreload("preloadpackageapp.zip");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void registerUpdateFinishCallback(IZCacheFirstUpdateFinishCallback iZCacheFirstUpdateFinishCallback) {
        this.updateFinishCallback = iZCacheFirstUpdateFinishCallback;
    }

    public void setPackageZipPrefixAdapter(WVPackageAppService.IPackageZipPrefixAdapter iPackageZipPrefixAdapter) {
        WVPackageAppService.setPackageZipPrefixAdapter(iPackageZipPrefixAdapter);
    }
}
