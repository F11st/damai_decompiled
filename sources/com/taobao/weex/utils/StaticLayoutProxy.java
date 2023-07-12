package com.taobao.weex.utils;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StaticLayoutProxy {
    private static Constructor<StaticLayout> a;

    private static StaticLayout a(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT < 18) {
            return null;
        }
        try {
            if (a == null) {
                Class cls = Float.TYPE;
                a = StaticLayout.class.getConstructor(CharSequence.class, TextPaint.class, Integer.TYPE, Layout.Alignment.class, TextDirectionHeuristic.class, cls, cls, Boolean.TYPE);
            }
            Constructor<StaticLayout> constructor = a;
            if (constructor != null) {
                return constructor.newInstance(charSequence, textPaint, Integer.valueOf(i), alignment, textDirectionHeuristic, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static StaticLayout create(CharSequence charSequence, TextPaint textPaint, int i, Layout.Alignment alignment, float f, float f2, boolean z, boolean z2) {
        if (Build.VERSION.SDK_INT >= 18 && z2) {
            StaticLayout a2 = a(charSequence, textPaint, i, alignment, TextDirectionHeuristics.RTL, f, f2, z);
            return a2 != null ? a2 : new StaticLayout(charSequence, textPaint, i, alignment, f, f2, z);
        }
        return new StaticLayout(charSequence, textPaint, i, alignment, f, f2, z);
    }
}
