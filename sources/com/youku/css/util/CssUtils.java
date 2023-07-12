package com.youku.css.util;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CssUtils {
    public static void seTextViewDrawable(TextView textView, Drawable drawable, int i) {
        if (textView == null) {
            return;
        }
        if (i == 0) {
            textView.setCompoundDrawables(drawable, textView.getCompoundDrawables()[1], textView.getCompoundDrawables()[2], textView.getCompoundDrawables()[3]);
        } else if (i == 1) {
            textView.setCompoundDrawables(textView.getCompoundDrawables()[0], drawable, textView.getCompoundDrawables()[2], textView.getCompoundDrawables()[3]);
        } else if (i == 2) {
            textView.setCompoundDrawables(textView.getCompoundDrawables()[0], textView.getCompoundDrawables()[1], drawable, textView.getCompoundDrawables()[3]);
        } else if (i != 3) {
        } else {
            textView.setCompoundDrawables(textView.getCompoundDrawables()[0], textView.getCompoundDrawables()[1], textView.getCompoundDrawables()[2], drawable);
        }
    }
}
