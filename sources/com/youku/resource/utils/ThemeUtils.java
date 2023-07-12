package com.youku.resource.utils;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ThemeUtils {
    public static void forceOffDarkMode(AppCompatActivity appCompatActivity) {
        try {
            if (UIMode.getInstance().isDarkMode()) {
                appCompatActivity.getDelegate().setLocalNightMode(1);
                ColorConfigureManager.getInstance().onConfigureChanged();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void recoveryTheme(AppCompatActivity appCompatActivity) {
        try {
            if (UIMode.getInstance().isDarkMode()) {
                appCompatActivity.getDelegate().setLocalNightMode(2);
            } else {
                appCompatActivity.getDelegate().setLocalNightMode(1);
            }
            ColorConfigureManager.getInstance().onConfigureChanged();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setTheme(Context context) {
        if (AppPerfABUtils.isForbidRoundCorner()) {
            context.setTheme(R.C8077style.YoukuResourceTheme_ThemeLowPref);
        } else {
            context.setTheme(R.C8077style.YoukuResourceTheme_Theme2);
        }
    }
}
