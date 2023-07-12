package com.youku.tinywindow;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.youku.media.arch.instruments.ConfigFetcher;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TinyWindowUtils {
    private static final String PIP_NAMESPACE = "youku_pip_config";

    public static boolean enablePlayerStartDestroy() {
        return "1".equals(ConfigFetcher.getInstance().getConfig(PIP_NAMESPACE, "enable_player_start_destroy", "0"));
    }

    public static boolean enableTinyWindow() {
        return "1".equals(ConfigFetcher.getInstance().getConfig(PIP_NAMESPACE, "key_enable_tiny_window", "1"));
    }

    public static int getApplyPermissionCount() {
        try {
            return Integer.parseInt(ConfigFetcher.getInstance().getConfig(PIP_NAMESPACE, "apply_permission_count", "1"));
        } catch (Exception unused) {
            return 1;
        }
    }

    public static final int getScreenWidth(Context context) {
        Display defaultDisplay;
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW);
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }
}
