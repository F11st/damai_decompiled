package com.youku.live.dago.liveplayback.widget.plugins.dmmulti;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MultiGridViewUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Bitmap convertViewToBitmap(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1029078593")) {
            return (Bitmap) ipChange.ipc$dispatch("-1029078593", new Object[]{view});
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431420365")) {
            return ((Integer) ipChange.ipc$dispatch("-431420365", new Object[]{context, Float.valueOf(f)})).intValue();
        }
        if (context == null || context.getResources() == null) {
            return 1;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @SuppressLint({"NewApi"})
    public static final int getScreenHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-593746287")) {
            return ((Integer) ipChange.ipc$dispatch("-593746287", new Object[]{context})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getRealMetrics(((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
    }

    @SuppressLint({"NewApi"})
    public static final int getScreenWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420930600")) {
            return ((Integer) ipChange.ipc$dispatch("1420930600", new Object[]{context})).intValue();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getRealMetrics(((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
    }

    public static double[] getWHFor16bi9(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221029697")) {
            return (double[]) ipChange.ipc$dispatch("-1221029697", new Object[]{context});
        }
        double[] dArr = {0.0d, 0.0d};
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        if (context.getResources().getConfiguration().orientation == 1) {
            dArr[0] = i;
            dArr[1] = (i * 9) / 16;
        } else {
            dArr[0] = (i2 * 16) / 9;
            dArr[1] = i2;
        }
        return dArr;
    }

    public static int px2dip(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-726097503") ? ((Integer) ipChange.ipc$dispatch("-726097503", new Object[]{context, Float.valueOf(f)})).intValue() : (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
