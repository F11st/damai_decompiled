package com.youku.style.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Window;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import com.youku.middlewareservice.provider.darkmode.DarkModeProviderProxy;
import com.youku.style.IStyle;
import com.youku.style.StyleVisitor;
import java.util.Map;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ActivityTopStatusBarColorSupport implements IStyle {
    private static int s_SystemUiVisibilityOrigin = -1;
    private Activity mActivity;

    public ActivityTopStatusBarColorSupport(Activity activity) {
        this.mActivity = activity;
    }

    private static String getXiaomiVersion() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "ro.miui.ui.version.name");
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean isTransparentStatusBar() {
        if (isXiaomiDevice()) {
            String xiaomiVersion = getXiaomiVersion();
            if (TextUtils.isEmpty(xiaomiVersion)) {
                return false;
            }
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return isXiaomiDevice() && Integer.parseInt(xiaomiVersion.replace("V", "")) >= 9;
        }
        return true;
    }

    private static boolean isXiaomiDevice() {
        return "Xiaomi".equals(Build.getMANUFACTURER());
    }

    public static void setStatusBarTextColorBlack(Activity activity, boolean z) {
        if (isTransparentStatusBar()) {
            if (s_SystemUiVisibilityOrigin == -1) {
                s_SystemUiVisibilityOrigin = activity.getWindow().getDecorView().getSystemUiVisibility();
            }
            Window window = activity.getWindow();
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
                if (z) {
                    window.getDecorView().setSystemUiVisibility(9216);
                } else if (s_SystemUiVisibilityOrigin != -1) {
                    window.getDecorView().setSystemUiVisibility(s_SystemUiVisibilityOrigin);
                }
            }
        }
    }

    @Override // com.youku.style.IStyle
    public void resetStyle() {
        setStatusBarTextColorBlack(this.mActivity, !DarkModeProviderProxy.isDarkMode());
    }

    @Override // com.youku.style.IStyle
    public void setStyle(Map map) {
        StyleVisitor styleVisitor = new StyleVisitor(map);
        if (styleVisitor.hasStyleValue("homeStateBarTextColor")) {
            setStatusBarTextColorBlack(this.mActivity, !TextUtils.equals(styleVisitor.getStyleStringValue("homeStateBarTextColor"), "white"));
        } else {
            resetStyle();
        }
    }
}
