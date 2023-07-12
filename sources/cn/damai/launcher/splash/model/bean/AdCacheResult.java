package cn.damai.launcher.splash.model.bean;

import cn.damai.launcher.splash.api.SplashResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AdCacheResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public final File adCacheFile;
    public final SplashResponse cacheRes;
    public final boolean isUseCache;

    public AdCacheResult(boolean z, SplashResponse splashResponse, File file) {
        this.isUseCache = z;
        this.cacheRes = splashResponse;
        this.adCacheFile = file;
    }

    public static AdCacheResult noneCacheAd() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "226938467") ? (AdCacheResult) ipChange.ipc$dispatch("226938467", new Object[0]) : new AdCacheResult(false, null, null);
    }
}
