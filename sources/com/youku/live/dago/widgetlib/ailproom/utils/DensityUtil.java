package com.youku.live.dago.widgetlib.ailproom.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DensityUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1999185214") ? ((Integer) ipChange.ipc$dispatch("1999185214", new Object[]{context, Float.valueOf(f)})).intValue() : (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int getScreenHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110906382")) {
            return ((Integer) ipChange.ipc$dispatch("-110906382", new Object[0])).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) AppContextUtils.getApp().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static final int getScreenWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031412559")) {
            return ((Integer) ipChange.ipc$dispatch("-2031412559", new Object[0])).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) AppContextUtils.getApp().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static int getWindowHeight(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4520448")) {
            return ((Integer) ipChange.ipc$dispatch("-4520448", new Object[]{activity})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    public static int getWindowWidth(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1373115385")) {
            return ((Integer) ipChange.ipc$dispatch("-1373115385", new Object[]{activity})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(activity.getWindowManager().getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static int px2dip(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1704508076") ? ((Integer) ipChange.ipc$dispatch("1704508076", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-541501098") ? ((Integer) ipChange.ipc$dispatch("-541501098", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int getWindowHeight(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1021722400") ? ((Integer) ipChange.ipc$dispatch("1021722400", new Object[]{context})).intValue() : ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getHeight();
    }

    public static int getWindowWidth(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1334495161") ? ((Integer) ipChange.ipc$dispatch("1334495161", new Object[]{context})).intValue() : ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getWidth();
    }
}
