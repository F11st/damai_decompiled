package com.youku.live.dago.widgetlib.interactive.utils;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ThemeUtils {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ClipDrawable getClipDrawable(Drawable drawable, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786784945")) {
            return (ClipDrawable) ipChange.ipc$dispatch("786784945", new Object[]{drawable, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (drawable != null) {
            return new ClipDrawable(drawable, i, i2);
        }
        return null;
    }

    public static GradientDrawable getDrawable(int i, int i2, int i3, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-262402936")) {
            return (GradientDrawable) ipChange.ipc$dispatch("-262402936", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(i3, i2);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    public static GradientDrawable getGradientDrawable(int i, int i2, GradientDrawable.Orientation orientation, int i3, int i4, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-332987385")) {
            return (GradientDrawable) ipChange.ipc$dispatch("-332987385", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), orientation, Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{i, i2});
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setStroke(i4, i3);
        gradientDrawable.setCornerRadius(f);
        return gradientDrawable;
    }

    public static GradientDrawable getOvalDrawable(int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105659590")) {
            return (GradientDrawable) ipChange.ipc$dispatch("-105659590", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setSize(i4, i5);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(i3, i2);
        return gradientDrawable;
    }

    public static GradientDrawable getRadiusDrawable(int i, int i2, int i3, float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370069466")) {
            return (GradientDrawable) ipChange.ipc$dispatch("370069466", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(i3, i2);
        gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
        return gradientDrawable;
    }

    public static GradientDrawable getGradientDrawable(int i, int i2, GradientDrawable.Orientation orientation, int i3, int i4, float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801193965")) {
            return (GradientDrawable) ipChange.ipc$dispatch("1801193965", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), orientation, Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(new int[]{i, i2});
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setStroke(i4, i3);
        gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
        return gradientDrawable;
    }
}
