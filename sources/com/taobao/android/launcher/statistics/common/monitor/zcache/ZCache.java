package com.taobao.android.launcher.statistics.common.monitor.zcache;

import android.taobao.windvane.packageapp.WVPackageAppManager;
import android.taobao.windvane.packageapp.adaptive.IZCacheFirstUpdateFinishCallback;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ZCache implements IZCacheFirstUpdateFinishCallback {
    public final Info info = new Info();

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class Info {
        public int count;
        public String type;
    }

    public void start() {
        WVPackageAppManager.getInstance().registerUpdateFinishCallback(this);
    }

    public void stop() {
        WVPackageAppManager.getInstance().registerUpdateFinishCallback(null);
    }

    @Override // android.taobao.windvane.packageapp.adaptive.IZCacheFirstUpdateFinishCallback
    public void updateCount(String str, int i) {
        Info info = this.info;
        info.type = str;
        info.count = i;
    }
}
