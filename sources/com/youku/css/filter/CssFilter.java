package com.youku.css.filter;

import android.text.TextUtils;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Border;
import com.youku.css.dto.Css;
import com.youku.css.dto.Gradient;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CssFilter {
    public static final int FILTER_TYPE_FOLLOW_ONE_KEY = 2;
    public static final int FILTER_TYPE_FOLLOW_ONE_KEY_ALPHA = 3;
    public static final int FILTER_TYPE_NONE = 0;
    public static final int FILTER_TYPE_ONLY_SET_ONE_KEY = 1;

    public static String filterColor(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.length() == 2) {
            if (str2.length() == 9) {
                return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + str2.substring(3, 9);
            } else if (str2.length() == 7) {
                return Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str + str2.substring(1, 7);
            }
        }
        return str2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0238, code lost:
        if (r1.equals("color") == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
        if (r1.equals("color") == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012a, code lost:
        if (r1.equals("color") == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0179, code lost:
        if (r1.equals("color") == false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.youku.css.dto.Css filterCss(com.youku.css.dto.Css r12, int r13, java.lang.String... r14) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.css.filter.CssFilter.filterCss(com.youku.css.dto.Css, int, java.lang.String[]):com.youku.css.dto.Css");
    }

    private static String getValueFromCssKey(Css css, String str) {
        if (css == null) {
            return "";
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1072949178:
                if (str.equals(CssConst.CssAttrs.END_COLOR)) {
                    c = 0;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 1;
                    break;
                }
                break;
            case 320716577:
                if (str.equals(CssConst.CssAttrs.BORDER_COLOR)) {
                    c = 2;
                    break;
                }
                break;
            case 1206759839:
                if (str.equals(CssConst.CssAttrs.START_COLOR)) {
                    c = 3;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Gradient gradient = css.gradient;
                if (gradient != null) {
                    return gradient.endColor;
                }
                break;
            case 1:
                return css.color;
            case 2:
                Border border = css.border;
                if (border != null) {
                    return border.color;
                }
                break;
            case 3:
                Gradient gradient2 = css.gradient;
                if (gradient2 != null) {
                    return gradient2.startColor;
                }
                break;
            case 4:
                return css.backgroundColor;
        }
        return "";
    }
}
