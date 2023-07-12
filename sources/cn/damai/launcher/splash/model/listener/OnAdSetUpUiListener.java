package cn.damai.launcher.splash.model.listener;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import cn.damai.launcher.splash.api.SplashResponse;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface OnAdSetUpUiListener {
    void dispatchNoneAdAction(int i, String str, String str2);

    void dispatchShowAdAction(boolean z, Drawable drawable, @NonNull SplashResponse splashResponse);
}
