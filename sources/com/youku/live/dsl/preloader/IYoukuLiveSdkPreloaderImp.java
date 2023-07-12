package com.youku.live.dsl.preloader;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.pretch.LiveSdkPreloader;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IYoukuLiveSdkPreloaderImp implements IYoukuLiveSdkPreloader {
    private static transient /* synthetic */ IpChange $ipChange;
    private static IYoukuLiveSdkPreloaderImp sInstance;

    public static IYoukuLiveSdkPreloader getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198421457")) {
            return (IYoukuLiveSdkPreloader) ipChange.ipc$dispatch("-198421457", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (IYoukuLiveSdkPreloader.class) {
                if (sInstance == null) {
                    sInstance = new IYoukuLiveSdkPreloaderImp();
                }
            }
        }
        return sInstance;
    }

    @Override // com.youku.live.dsl.preloader.IYoukuLiveSdkPreloader
    public boolean initYoukuLive(Application application, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562818431")) {
            return ((Boolean) ipChange.ipc$dispatch("1562818431", new Object[]{this, application, Boolean.valueOf(z)})).booleanValue();
        }
        if (z) {
            LiveSdkPreloader.preRegisterAll(application);
        } else {
            LiveSdkPreloader.registerAll(application);
        }
        return true;
    }
}
