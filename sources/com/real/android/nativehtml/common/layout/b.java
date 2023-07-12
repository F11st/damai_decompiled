package com.real.android.nativehtml.common.layout;

import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.layout.Layout;
import tb.fq;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class b {
    public static float a(ComponentElement componentElement, float f, float f2) {
        fq computedStyle = componentElement.getComputedStyle();
        return computedStyle.g(CssProperty.BORDER_TOP_WIDTH, f2) + computedStyle.g(CssProperty.PADDING_TOP, f2) + d(componentElement, f, f2) + computedStyle.g(CssProperty.PADDING_BOTTOM, f2) + computedStyle.g(CssProperty.BORDER_BOTTOM_WIDTH, f2);
    }

    public static float[] b(ComponentElement componentElement, Layout.Directive directive, float f) {
        float e = e(componentElement, directive, f);
        fq computedStyle = componentElement.getComputedStyle();
        return new float[]{computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f) + computedStyle.g(CssProperty.PADDING_LEFT, f) + e + computedStyle.g(CssProperty.PADDING_RIGHT, f) + computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f), a(componentElement, e, f)};
    }

    public static float c(ComponentElement componentElement, Layout.Directive directive, float f) {
        fq computedStyle = componentElement.getComputedStyle();
        return computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f) + computedStyle.g(CssProperty.PADDING_LEFT, f) + e(componentElement, directive, f) + computedStyle.g(CssProperty.PADDING_RIGHT, f) + computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f);
    }

    public static float d(ComponentElement componentElement, float f, float f2) {
        fq computedStyle = componentElement.getComputedStyle();
        CssProperty cssProperty = CssProperty.HEIGHT;
        if (computedStyle.k(cssProperty)) {
            return computedStyle.g(cssProperty, f2);
        }
        return componentElement.getIntrinsicContentBoxHeightForWidth(f, f2);
    }

    public static float e(ComponentElement componentElement, Layout.Directive directive, float f) {
        fq computedStyle = componentElement.getComputedStyle();
        CssProperty cssProperty = CssProperty.WIDTH;
        if (computedStyle.k(cssProperty)) {
            return computedStyle.g(cssProperty, f);
        }
        float g = (((((f - computedStyle.g(CssProperty.MARGIN_LEFT, f)) - computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f)) - computedStyle.g(CssProperty.PADDING_LEFT, f)) - computedStyle.g(CssProperty.PADDING_RIGHT, f)) - computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f)) - computedStyle.g(CssProperty.MARGIN_RIGHT, f);
        return (computedStyle.f(CssProperty.DISPLAY) == CssEnum.BLOCK && directive == Layout.Directive.STRETCH) ? g : Math.min(g, componentElement.getIntrinsicContentBoxWidth(directive, g));
    }

    public static boolean f(ComponentElement componentElement) {
        fq computedStyle = componentElement.getComputedStyle();
        CssEnum f = computedStyle.f(CssProperty.DISPLAY);
        return f == CssEnum.NONE || ((f == CssEnum.BLOCK || f == CssEnum.TABLE) && computedStyle.f(CssProperty.POSITION) == CssEnum.ABSOLUTE);
    }

    public static boolean g(ComponentElement componentElement, float f, float f2, float f3, boolean z, ComponentElement componentElement2) {
        float g;
        boolean f4 = f(componentElement2);
        if (!f4 || z || componentElement2.getComputedStyle().f(CssProperty.DISPLAY) == CssEnum.NONE) {
            return f4;
        }
        fq computedStyle = componentElement2.getComputedStyle();
        float g2 = computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_LEFT, f3);
        float g3 = computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_RIGHT, f3);
        float g4 = computedStyle.g(CssProperty.BORDER_TOP_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_TOP, f3);
        float g5 = computedStyle.g(CssProperty.BORDER_BOTTOM_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_BOTTOM, f3);
        float e = e(componentElement2, Layout.Directive.MINIMUM, f3);
        float f5 = g3 + g2 + e;
        float d = g5 + d(componentElement2, e, f3) + g4;
        CssProperty cssProperty = CssProperty.LEFT;
        if (computedStyle.k(cssProperty)) {
            g = computedStyle.g(cssProperty, f3) + f;
        } else {
            CssProperty cssProperty2 = CssProperty.RIGHT;
            g = computedStyle.k(cssProperty2) ? ((f + f3) - f5) - computedStyle.g(cssProperty2, f3) : f;
        }
        CssProperty cssProperty3 = CssProperty.TOP;
        if (computedStyle.k(cssProperty3)) {
            g4 = computedStyle.g(cssProperty3, f3) + f2;
        }
        componentElement2.setBorderBoxBounds(g, g4, f5, d, f3);
        return true;
    }
}
