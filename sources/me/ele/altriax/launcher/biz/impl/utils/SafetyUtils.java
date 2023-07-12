package me.ele.altriax.launcher.biz.impl.utils;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class SafetyUtils {
    private static final String EMPTY_STRING = "";
    private static final String TAG = "SafetyUtils";

    public static <V extends View> V safetyFindViewById(@Nullable View view, @IdRes int i) {
        if (view == null) {
            return null;
        }
        try {
            return (V) view.findViewById(i);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
            return null;
        }
    }

    public static double safetyGetDouble(@Nullable String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
            return 0.0d;
        }
    }

    public static long safetyGetLong(@Nullable String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
            return 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <Expect, Target> Expect safetyMandatoryTransform(@Nullable Target target) {
        if (target == 0) {
            return null;
        }
        return target;
    }

    public static int safetyParseColor(@Nullable String str, @ColorInt int i) {
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static void safetySetBackground(@Nullable View view, @NonNull Drawable drawable) {
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void safetySetImageResource(@Nullable ImageView imageView, @DrawableRes int i) {
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(i);
    }

    public static void safetySetText(@Nullable TextView textView, @Nullable String str) {
        if (textView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
    }

    public static void safetySetTextColor(@Nullable TextView textView, @ColorInt int i) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(i);
    }
}
