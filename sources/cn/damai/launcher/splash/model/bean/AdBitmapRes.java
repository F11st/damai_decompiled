package cn.damai.launcher.splash.model.bean;

import android.graphics.drawable.BitmapDrawable;
import cn.damai.launcher.splash.api.SplashResponse;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class AdBitmapRes implements Serializable {
    public final BitmapDrawable mAdBitmapDrawable;
    public final SplashResponse mAdSplashRes;

    public AdBitmapRes(BitmapDrawable bitmapDrawable, SplashResponse splashResponse) {
        this.mAdBitmapDrawable = bitmapDrawable;
        this.mAdSplashRes = splashResponse;
    }
}
