package com.uc.webview.export.internal.setup;

import android.content.Context;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.interfaces.UCMobileWebKit;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class UCMRunningInfo {
    public final Context appCtx;
    public final ClassLoader classLoader;
    public final int coreType;
    public final boolean isFirstTimeOdex;
    public final boolean isOldExtraKernel;
    public final boolean isShareCore;
    public final int loadType;
    public final ClassLoader shellClassLoader;
    public final UCMobileWebKit ucMobileWebKit;
    public final bt ucmPackageInfo;

    public UCMRunningInfo(Context context, bt btVar, ClassLoader classLoader, ClassLoader classLoader2, boolean z, boolean z2, UCMobileWebKit uCMobileWebKit, int i, boolean z3, int i2) {
        this.appCtx = context.getApplicationContext();
        this.ucmPackageInfo = btVar;
        this.classLoader = classLoader;
        this.ucMobileWebKit = uCMobileWebKit;
        this.coreType = i;
        this.isOldExtraKernel = z;
        this.shellClassLoader = classLoader2;
        this.isFirstTimeOdex = z2;
        this.isShareCore = z3;
        this.loadType = i2;
    }
}
