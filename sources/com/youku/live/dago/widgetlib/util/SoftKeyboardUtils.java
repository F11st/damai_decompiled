package com.youku.live.dago.widgetlib.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SoftKeyboardUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    @TargetApi(17)
    private static int getSoftButtonsBarHeight(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516823269")) {
            return ((Integer) ipChange.ipc$dispatch("1516823269", new Object[]{activity})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        Display.getRealMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        if (i2 > i) {
            return i2 - i;
        }
        return 0;
    }

    public static void hideSoftKeyboard(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2112391376")) {
            ipChange.ipc$dispatch("-2112391376", new Object[]{activity});
        } else {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static void hideSystemSoftKeyboard(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319700287")) {
            ipChange.ipc$dispatch("-319700287", new Object[]{activity});
        } else {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
        }
    }

    public static boolean isSoftShowing(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "215783326")) {
            return ((Boolean) ipChange.ipc$dispatch("215783326", new Object[]{activity})).booleanValue();
        }
        int height = activity.getWindow().getDecorView().getHeight();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return (height * 2) / 3 > rect.bottom + getSoftButtonsBarHeight(activity);
    }

    public static void showORhideSoftKeyboard(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192213648")) {
            ipChange.ipc$dispatch("1192213648", new Object[]{activity});
        } else {
            ((InputMethodManager) activity.getSystemService("input_method")).toggleSoftInput(0, 2);
        }
    }

    public static void showSoftKeyboard(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330314667")) {
            ipChange.ipc$dispatch("-1330314667", new Object[]{activity});
        } else {
            ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(activity.getWindow().getDecorView(), 2);
        }
    }
}
