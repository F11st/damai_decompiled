package com.youku.css.setter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Border;
import com.youku.css.dto.Css;
import com.youku.css.filter.CssFilter;
import com.youku.css.finder.CssFinder;
import com.youku.style.IStyleView;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CssSetter {
    private static Css getCss(String str, String str2, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (!lowerCase.contains("bg") && !lowerCase.contains("background") && !lowerCase.contains("fill")) {
                strArr = new String[]{"color"};
            } else {
                strArr = new String[]{"backgroundColor"};
            }
        }
        Css css = new Css();
        for (String str3 : strArr) {
            str3.hashCode();
            char c = 65535;
            switch (str3.hashCode()) {
                case 94842723:
                    if (str3.equals("color")) {
                        c = 0;
                        break;
                    }
                    break;
                case 320716577:
                    if (str3.equals(CssConst.CssAttrs.BORDER_COLOR)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str3.equals("backgroundColor")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    css.color = str2;
                    break;
                case 1:
                    if (css.border == null) {
                        css.border = new Border();
                    }
                    css.border.color = str2;
                    break;
                case 2:
                    css.backgroundColor = str2;
                    break;
            }
        }
        return css;
    }

    public static int resetColor(View view, @IdRes int i) {
        if (view == null || !(view.getTag(i) instanceof Integer)) {
            return 0;
        }
        int intValue = ((Integer) view.getTag(i)).intValue();
        view.setTag(i, null);
        return intValue;
    }

    public static void resetCss(View view, String str) {
        if (view != null) {
            if (view instanceof ICssSetter2) {
                ((ICssSetter2) view).resetCss(str);
                return;
            }
            DefaultCssSetter.resetCss(view);
            if (TextView.class.isAssignableFrom(view.getClass())) {
                TextViewCssSetter.resetCss((TextView) view);
            } else if (ImageView.class.isAssignableFrom(view.getClass())) {
                ImageViewCssSetter.resetCss((ImageView) view);
            }
        }
    }

    public static void saveColor(View view, @IdRes int i, int i2) {
        if (view == null || view.getTag(i) != null) {
            return;
        }
        view.setTag(i, Integer.valueOf(i2));
    }

    public static void setColor(View view, String str, String str2, String... strArr) {
        Css css = getCss(str, str2, strArr);
        if (css == null) {
            resetCss(view, str);
        } else if (view instanceof ICssSetter) {
            ((ICssSetter) view).setCss(str, css);
        } else if (strArr.length == 1) {
            if (DefaultCssSetter.isSupportedCss(css, strArr[0])) {
                DefaultCssSetter.setCss(view, css);
            } else if (TextView.class.isAssignableFrom(view.getClass())) {
                TextViewCssSetter.setCss((TextView) view, css);
            } else if (ImageView.class.isAssignableFrom(view.getClass())) {
                ImageViewCssSetter.setCss((ImageView) view, css);
            }
        } else {
            DefaultCssSetter.setCss(view, css);
            if (TextView.class.isAssignableFrom(view.getClass())) {
                TextViewCssSetter.setCss((TextView) view, css);
            } else if (ImageView.class.isAssignableFrom(view.getClass())) {
                ImageViewCssSetter.setCss((ImageView) view, css);
            }
        }
    }

    public static void setColorAlpha(View view, String str, String str2, int i, String... strArr) {
        String hexString = Integer.toHexString((i * 255) / 100);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        setColor(view, str, CssFilter.filterColor(hexString, str2), strArr);
    }

    private static void setCss(View view, String str, Css css, int i, String... strArr) {
        if (css == null || view == null) {
            return;
        }
        Css filterCss = CssFilter.filterCss(css, i, strArr);
        if (view instanceof ICssSetter) {
            ((ICssSetter) view).setCss(str, filterCss);
        } else if (1 == i && strArr != null && filterCss != null && strArr.length > 0) {
            if (DefaultCssSetter.isSupportedCss(filterCss, strArr[0])) {
                DefaultCssSetter.setCss(view, filterCss);
            } else if (TextView.class.isAssignableFrom(view.getClass())) {
                TextViewCssSetter.setCss((TextView) view, filterCss);
            } else if (ImageView.class.isAssignableFrom(view.getClass())) {
                ImageViewCssSetter.setCss((ImageView) view, filterCss);
            }
        } else {
            DefaultCssSetter.setCss(view, filterCss);
            if (TextView.class.isAssignableFrom(view.getClass())) {
                TextViewCssSetter.setCss((TextView) view, filterCss);
            } else if (ImageView.class.isAssignableFrom(view.getClass())) {
                ImageViewCssSetter.setCss((ImageView) view, filterCss);
            }
        }
    }

    public static void setCssFollow(View view, String str, Map<String, Css> map, String... strArr) {
        Css findCss = CssFinder.findCss(map, str);
        if (findCss != null) {
            setCss(view, str, findCss, 2, strArr);
        }
    }

    public static void setCssToField(View view, String str, Map<String, Css> map, String... strArr) {
        Css findCss = CssFinder.findCss(map, str);
        if (findCss != null) {
            setCss(view, str, findCss, 1, strArr);
        }
    }

    public static void setCssWithAlphaCompact(View view, String str, Map<String, Css> map, String... strArr) {
        Css findCss = CssFinder.findCss(map, str);
        if (findCss != null) {
            setCss(view, str, findCss, 3, strArr);
        }
    }

    @Deprecated
    public static void setImageColorFilter(ImageView imageView, String str, Map<String, Css> map) {
        setCssToField(imageView, str, map, "backgroundColor");
    }

    public static void setColorAlpha(IStyleView iStyleView, String str, String str2, int i, String... strArr) {
        String hexString = Integer.toHexString((i * 255) / 100);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        setColor(iStyleView, str, CssFilter.filterColor(hexString, str2), strArr);
    }

    private static void setCss(IStyleView iStyleView, Css css, String str, int i, String... strArr) {
        if (css == null || iStyleView == null) {
            return;
        }
        iStyleView.setStyle(str, CssFilter.filterCss(css, i, strArr));
    }

    public static void setColor(IStyleView iStyleView, String str, String str2, String... strArr) {
        Css css = getCss(str, str2, strArr);
        if (css == null) {
            return;
        }
        iStyleView.setStyle(str, css);
    }

    public static void setCss(View view, String str, Map<String, Css> map) {
        Css findCss = CssFinder.findCss(map, str);
        if (findCss != null) {
            setCss(view, str, findCss, 0, "");
        } else {
            resetCss(view, str);
        }
    }

    public static void setCss(IStyleView iStyleView, String str, Map<String, Css> map) {
        Css findCss = CssFinder.findCss(map, str);
        if (findCss != null) {
            setCss(iStyleView, findCss, str, 0, "");
        }
    }
}
