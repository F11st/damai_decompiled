package com.youku.resource.utils;

import android.graphics.Typeface;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IconFontUtils {
    private static Typeface mIconFont;

    public static Typeface getIconFont() {
        initIconFont();
        return mIconFont;
    }

    private static void initIconFont() {
        try {
            if (mIconFont == null) {
                mIconFont = Typeface.createFromAsset(AppInfoProviderProxy.getApplication().getResources().getAssets(), "yk_iconfont.ttf");
            }
        } catch (Exception e) {
            if (AppInfoProviderProxy.isDebuggable()) {
                e.printStackTrace();
            }
        }
    }
}
