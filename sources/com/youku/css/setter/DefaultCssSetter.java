package com.youku.css.setter;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.youku.css.R;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Border;
import com.youku.css.dto.Css;
import com.youku.css.dto.Gradient;
import com.youku.css.util.ColorUtil;
import com.youku.css.util.DimenUtils;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DefaultCssSetter {
    DefaultCssSetter() {
    }

    public static boolean isSupportedCss(Css css, String str) {
        Gradient gradient;
        Gradient gradient2;
        Border border;
        return css != null && (("backgroundColor".equalsIgnoreCase(str) && !TextUtils.isEmpty(css.backgroundColor)) || !((!CssConst.CssAttrs.BORDER_COLOR.equalsIgnoreCase(str) || (border = css.border) == null || TextUtils.isEmpty(border.color)) && ((!CssConst.CssAttrs.START_COLOR.equalsIgnoreCase(str) || (gradient2 = css.gradient) == null || TextUtils.isEmpty(gradient2.startColor)) && (!CssConst.CssAttrs.END_COLOR.equalsIgnoreCase(str) || (gradient = css.gradient) == null || TextUtils.isEmpty(gradient.endColor)))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resetCss(View view) {
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        Drawable mutate = background != null ? background.mutate() : null;
        if (mutate != null) {
            if (mutate instanceof GradientDrawable) {
                int i = R.id.tag_css_color_state_list;
                if (view.getTag(i) instanceof ColorStateList) {
                    ColorStateList colorStateList = (ColorStateList) view.getTag(i);
                    if (Build.VERSION.SDK_INT >= 21) {
                        ((GradientDrawable) mutate).setColor(colorStateList);
                    }
                    view.setTag(i, null);
                }
            } else if (mutate instanceof ColorDrawable) {
                int i2 = R.id.tag_css_background_color;
                if (view.getTag(i2) instanceof Integer) {
                    ((ColorDrawable) mutate).setColor(((Integer) view.getTag(i2)).intValue());
                    view.setTag(i2, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCss(View view, Css css) {
        int identifier;
        if (view == null || css == null) {
            return;
        }
        Drawable background = view.getBackground();
        Drawable mutate = background != null ? background.mutate() : null;
        Gradient gradient = css.gradient;
        if (gradient != null && !TextUtils.isEmpty(gradient.startColor) && !TextUtils.isEmpty(css.gradient.endColor)) {
            int[] iArr = {ColorUtil.parseColorSafely(css.gradient.startColor), ColorUtil.parseColorSafely(css.gradient.endColor)};
            if (mutate instanceof GradientDrawable) {
                ((GradientDrawable) mutate).setColors(iArr);
            } else {
                mutate = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr);
            }
            ViewCompat.setBackground(view, mutate);
        } else if (!TextUtils.isEmpty(css.backgroundColor)) {
            int parseColorSafely = ColorUtil.parseColorSafely(css.backgroundColor);
            if (mutate instanceof GradientDrawable) {
                if (Build.VERSION.SDK_INT >= 24) {
                    ColorStateList color = ((GradientDrawable) mutate).getColor();
                    int i = R.id.tag_css_color_state_list;
                    if (view.getTag(i) == null) {
                        view.setTag(i, color);
                    }
                }
                ((GradientDrawable) mutate).setColor(parseColorSafely);
                ViewCompat.setBackground(view, mutate);
            } else {
                if (mutate instanceof ColorDrawable) {
                    ColorDrawable colorDrawable = (ColorDrawable) mutate;
                    if (colorDrawable.getColor() != parseColorSafely) {
                        int i2 = R.id.tag_css_background_color;
                        if (view.getTag(i2) == null) {
                            view.setTag(i2, Integer.valueOf(colorDrawable.getColor()));
                        }
                        colorDrawable.setColor(parseColorSafely);
                        ViewCompat.setBackground(view, mutate);
                    }
                }
                if (view.getBackground() == null) {
                    view.setBackgroundColor(parseColorSafely);
                }
            }
        }
        Border border = css.border;
        if (border == null || border.color == null || !(mutate instanceof GradientDrawable)) {
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) mutate;
        try {
            if (!TextUtils.isEmpty(border.radius)) {
                gradientDrawable.setCornerRadius(DimenUtils.getIdentifier(view.getContext(), css.border.radius));
            }
            if (TextUtils.isEmpty(css.border.width)) {
                Field field = gradientDrawable.getConstantState().getClass().getField("mStrokeWidth");
                field.setAccessible(true);
                identifier = ((Integer) field.get(gradientDrawable.getConstantState())).intValue();
            } else {
                identifier = DimenUtils.getIdentifier(view.getContext(), css.border.width);
            }
            gradientDrawable.setStroke(identifier, ColorUtil.parseColorSafely(css.border.color));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ViewCompat.setBackground(view, gradientDrawable);
    }
}
