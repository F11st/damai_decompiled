package com.real.android.nativehtml.common.layout;

import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.layout.Layout;
import tb.fq;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class a implements Layout {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.real.android.nativehtml.common.layout.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C0271a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CssEnum.values().length];
            a = iArr;
            try {
                iArr[CssEnum.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CssEnum.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static void a(Element element, StringBuilder sb, float f, float f2, float f3) {
        float f4;
        if (sb == null) {
            return;
        }
        CssEnum f5 = element.getComputedStyle().f(CssProperty.TEXT_ALIGN);
        CssEnum f6 = element.getComputedStyle().f(CssProperty.VERTICAL_ALIGN);
        if (f5 == CssEnum.RIGHT) {
            f4 = f2 - f;
        } else {
            f4 = f5 == CssEnum.CENTER ? (f2 - f) / 2.0f : 0.0f;
        }
        for (int i = 0; i < sb.length(); i += 2) {
            char charAt = sb.charAt(i);
            float charAt2 = sb.charAt(i + 1);
            int i2 = C0271a.a[f6.ordinal()];
            ((ComponentElement) element.getChildren().item(charAt)).moveRelative(f4, i2 != 1 ? i2 != 2 ? (f3 - charAt2) / 2.0f : f3 - charAt2 : 0.0f);
        }
        sb.setLength(0);
    }

    @Override // com.real.android.nativehtml.common.layout.Layout
    public float layout(ComponentElement componentElement, float f, float f2, float f3, boolean z) {
        ComponentElement componentElement2;
        float f4;
        float f5;
        HtmlCollection children = componentElement.getChildren();
        StringBuilder sb = z ? null : new StringBuilder();
        int i = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (i < componentElement.getChildren().getLength()) {
            ComponentElement componentElement3 = (ComponentElement) children.item(i);
            fq computedStyle = componentElement3.getComputedStyle();
            CssEnum f10 = computedStyle.f(CssProperty.DISPLAY);
            HtmlCollection htmlCollection = children;
            if (!b.g(componentElement, f, f2, f3, z, componentElement3)) {
                float g = computedStyle.g(CssProperty.MARGIN_LEFT, f3);
                float g2 = computedStyle.g(CssProperty.MARGIN_RIGHT, f3);
                if (f10 != CssEnum.BLOCK && f10 != CssEnum.TABLE && f10 != CssEnum.LIST_ITEM) {
                    int i2 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                    if (i2 == 0) {
                        f8 += f9;
                        f9 = 0.0f;
                    }
                    Layout.Directive directive = Layout.Directive.FIT_CONTENT;
                    componentElement2 = componentElement3;
                    float e = b.e(componentElement2, directive, f3);
                    float c = b.c(componentElement2, directive, f3);
                    float f11 = g + c + g2;
                    float a = b.a(componentElement2, e, f3);
                    if (i2 > 0 && f6 + f11 > f3) {
                        a(componentElement, sb, f6, f3, f7);
                        f8 += f7;
                        f6 = 0.0f;
                    }
                    if (z) {
                        f4 = f8;
                        f5 = a;
                    } else {
                        float f12 = f8 + f2;
                        f4 = f8;
                        f5 = a;
                        componentElement2.setBorderBoxBounds(f6 + f + g, f12, c, a, f3);
                        sb.append((char) i);
                        sb.append((char) f5);
                    }
                    f6 += f11;
                    f7 = Math.max(f7, f5);
                    f8 = f4;
                } else {
                    componentElement2 = componentElement3;
                    if (f6 > 0.0f) {
                        a(componentElement, sb, f6 - f, f3, f7);
                        f8 += f7;
                        f6 = 0.0f;
                        f7 = 0.0f;
                    }
                    float max = f8 + Math.max(f9, computedStyle.g(CssProperty.MARGIN_TOP, f3));
                    Layout.Directive directive2 = Layout.Directive.STRETCH;
                    float e2 = b.e(componentElement2, directive2, f3);
                    float c2 = b.c(componentElement2, directive2, f3);
                    float a2 = b.a(componentElement2, e2, f3);
                    if (!z) {
                        componentElement2.setBorderBoxBounds(f + g, max + f, c2, a2, f3);
                    }
                    f8 = max + a2;
                    f9 = computedStyle.g(CssProperty.MARGIN_BOTTOM, f3);
                }
                if (computedStyle.f(CssProperty.POSITION) == CssEnum.RELATIVE) {
                    float g3 = computedStyle.g(CssProperty.LEFT, f3) - computedStyle.g(CssProperty.RIGHT, f3);
                    float g4 = computedStyle.g(CssProperty.TOP, f3) - computedStyle.g(CssProperty.BOTTOM, f3);
                    if (g3 != 0.0f || g4 != 0.0f) {
                        componentElement2.moveRelative(g3, g4);
                    }
                }
            }
            i++;
            children = htmlCollection;
        }
        if (f6 > 0.0f) {
            a(componentElement, sb, f6, f3, f7);
            f8 += f7;
        }
        return f8 + f9;
    }

    @Override // com.real.android.nativehtml.common.layout.Layout
    public float measureWidth(ComponentElement componentElement, Layout.Directive directive, float f) {
        HtmlCollection children = componentElement.getChildren();
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i = 0; i < children.getLength(); i++) {
            ComponentElement componentElement2 = (ComponentElement) componentElement.getChildren().item(i);
            fq computedStyle = componentElement2.getComputedStyle();
            CssEnum f4 = computedStyle.f(CssProperty.DISPLAY);
            if (!b.f(componentElement2)) {
                float g = computedStyle.g(CssProperty.MARGIN_LEFT, f);
                float g2 = computedStyle.g(CssProperty.MARGIN_RIGHT, f);
                if (f4 != CssEnum.BLOCK && f4 != CssEnum.TABLE && f4 != CssEnum.LIST_ITEM && directive != Layout.Directive.MINIMUM) {
                    f2 += g + b.c(componentElement2, Layout.Directive.FIT_CONTENT, f) + g2;
                } else {
                    if (f2 > 0.0f) {
                        f3 = Math.max(f2, f3);
                    }
                    f3 = Math.max(f3, g + b.c(componentElement2, directive, f) + g2);
                }
            }
        }
        return Math.max(f2, f3);
    }
}
