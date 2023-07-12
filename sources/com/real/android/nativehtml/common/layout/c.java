package com.real.android.nativehtml.common.layout;

import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.real.android.nativehtml.common.layout.Layout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tb.fq;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class c implements Layout {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a {
        float a;
        Map<Integer, Float> b;
        float c;
        int d;
        float e;
        ComponentElement f;
        float g;

        a() {
        }
    }

    static float a(ComponentElement componentElement, Layout.Directive directive, float f, ArrayList<a> arrayList) {
        int i;
        a aVar;
        HtmlCollection children = componentElement.getChildren();
        arrayList.clear();
        float g = componentElement.getComputedStyle().g(CssProperty.BORDER_SPACING, f);
        Layout.Directive directive2 = directive == Layout.Directive.MINIMUM ? directive : Layout.Directive.FIT_CONTENT;
        int i2 = 0;
        for (int i3 = 0; i3 < children.getLength(); i3++) {
            HtmlCollection children2 = children.item(i3).getChildren();
            int i4 = 0;
            for (int i5 = 0; i5 < children2.getLength(); i5++) {
                ComponentElement componentElement2 = (ComponentElement) children2.item(i5);
                while (true) {
                    if (arrayList.size() <= i4) {
                        arrayList.add(new a());
                    } else {
                        aVar = arrayList.get(i4);
                        int i6 = aVar.d;
                        if (i6 == 0) {
                            break;
                        }
                        aVar.d = i6 - 1;
                        i4++;
                    }
                }
                float c = b.c(componentElement2, directive2, f);
                int b = b(componentElement2);
                int c2 = c(componentElement2);
                if (b == 1) {
                    aVar.a = Math.max(aVar.a, c);
                } else {
                    if (aVar.b == null) {
                        aVar.b = new HashMap();
                    }
                    Float f2 = aVar.b.get(Integer.valueOf(b));
                    Map<Integer, Float> map = aVar.b;
                    Integer valueOf = Integer.valueOf(b);
                    if (f2 != null) {
                        c = Math.max(f2.floatValue(), c);
                    }
                    map.put(valueOf, Float.valueOf(c));
                    while (arrayList.size() < i4 + b) {
                        arrayList.add(new a());
                    }
                }
                if (c2 > 0) {
                    for (int i7 = 0; i7 < b; i7++) {
                        arrayList.get(i4 + i7).d = c2 - 1;
                    }
                }
                i4 += b;
            }
            i2 = Math.max(i2, i4);
        }
        while (arrayList.size() <= i2) {
            arrayList.add(new a());
        }
        int i8 = 0;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            if (i9 != 0) {
                i8 = (int) (i8 + g);
            }
            a aVar2 = arrayList.get(i9);
            aVar2.d = 0;
            Map<Integer, Float> map2 = aVar2.b;
            if (map2 != null) {
                for (Map.Entry<Integer, Float> entry : map2.entrySet()) {
                    int intValue = entry.getKey().intValue();
                    float floatValue = entry.getValue().floatValue();
                    float f3 = 0.0f;
                    int i10 = i9;
                    while (true) {
                        i = i9 + intValue;
                        if (i10 >= i) {
                            break;
                        }
                        f3 += arrayList.get(i10).a;
                        i10++;
                    }
                    if (f3 < floatValue) {
                        float f4 = (floatValue - f3) / intValue;
                        for (int i11 = i9; i11 < i; i11++) {
                            arrayList.get(i11).a += f4;
                        }
                    }
                }
            }
            i8 = (int) (i8 + aVar2.a);
        }
        return i8;
    }

    static int b(Element element) {
        String attribute = element.getAttribute("colspan");
        if (attribute == null || attribute.isEmpty()) {
            return 1;
        }
        try {
            return Integer.parseInt(attribute.trim());
        } catch (Exception unused) {
            return 1;
        }
    }

    static int c(Element element) {
        String attribute = element.getAttribute("rowspan");
        if (attribute == null || attribute.isEmpty()) {
            return 1;
        }
        try {
            return Integer.parseInt(attribute.trim());
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // com.real.android.nativehtml.common.layout.Layout
    public float layout(ComponentElement componentElement, float f, float f2, float f3, boolean z) {
        a aVar;
        int i;
        HtmlCollection children = componentElement.getChildren();
        ArrayList arrayList = new ArrayList();
        float a2 = a(componentElement, Layout.Directive.FIT_CONTENT, f3, arrayList);
        float g = componentElement.getComputedStyle().g(CssProperty.BORDER_SPACING, f3);
        float size = (arrayList.size() - 1) * g;
        float f4 = f3 - size;
        float f5 = a2 - size;
        if (f5 > f4) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                aVar2.a = (aVar2.a * f4) / f5;
            }
        }
        int i2 = 0;
        float f6 = 0.0f;
        while (i2 < children.getLength()) {
            ComponentElement componentElement2 = (ComponentElement) children.item(i2);
            HtmlCollection children2 = componentElement2.getChildren();
            int i3 = 0;
            int i4 = 0;
            while (i3 < children2.getLength()) {
                ComponentElement componentElement3 = (ComponentElement) children2.item(i3);
                while (true) {
                    if (arrayList.size() <= i4) {
                        arrayList.add(new a());
                    } else {
                        aVar = (a) arrayList.get(i4);
                        if (aVar.d == 0) {
                            break;
                        }
                        i4++;
                    }
                }
                fq computedStyle = componentElement3.getComputedStyle();
                float g2 = computedStyle.g(CssProperty.BORDER_TOP_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_TOP, f3);
                float g3 = computedStyle.g(CssProperty.BORDER_BOTTOM_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_BOTTOM, f3);
                HtmlCollection htmlCollection = children2;
                float g4 = computedStyle.g(CssProperty.BORDER_LEFT_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_LEFT, f3);
                HtmlCollection htmlCollection2 = children;
                float g5 = computedStyle.g(CssProperty.BORDER_RIGHT_WIDTH, f3) + computedStyle.g(CssProperty.PADDING_RIGHT, f3);
                int b = b(componentElement3);
                ComponentElement componentElement4 = componentElement2;
                int i5 = i4;
                int i6 = i2;
                int i7 = 0;
                while (true) {
                    i = i4 + b;
                    if (i5 < i) {
                        int i8 = (int) (i7 + ((a) arrayList.get(i5)).a);
                        if (i5 > i4) {
                            i8 = (int) (i8 + g);
                        }
                        i7 = i8;
                        i5++;
                    }
                }
                float f7 = i7;
                float d = b.d(componentElement3, (f7 - g4) - g5, f3);
                aVar.d = c(componentElement3);
                aVar.e = g2 + d + g3;
                aVar.f = componentElement3;
                aVar.c = f7;
                aVar.g = f6;
                i3++;
                i4 = i;
                children2 = htmlCollection;
                children = htmlCollection2;
                i2 = i6;
                componentElement2 = componentElement4;
            }
            ComponentElement componentElement5 = componentElement2;
            HtmlCollection htmlCollection3 = children;
            int i9 = i2;
            Iterator it2 = arrayList.iterator();
            float f8 = 0.0f;
            while (it2.hasNext()) {
                a aVar3 = (a) it2.next();
                if (aVar3.d == 1) {
                    f8 = Math.max(f8, aVar3.e);
                }
            }
            if (!z) {
                componentElement5.setBorderBoxBounds(0.0f, f6, f3, f8, f3);
            }
            Iterator it3 = arrayList.iterator();
            int i10 = 0;
            while (it3.hasNext()) {
                a aVar4 = (a) it3.next();
                int i11 = aVar4.d;
                if (i11 == 1) {
                    aVar4.d = 0;
                    if (!z) {
                        aVar4.f.setBorderBoxBounds(i10, 0.0f, aVar4.c, (f6 + f8) - aVar4.g, f3);
                    }
                } else if (i11 > 1) {
                    aVar4.e -= f8 - g;
                    aVar4.d = i11 - 1;
                }
                i10 = (int) (i10 + aVar4.a + g);
            }
            f6 += f8 + g;
            i2 = i9 + 1;
            children = htmlCollection3;
        }
        return f6 - g;
    }

    @Override // com.real.android.nativehtml.common.layout.Layout
    public float measureWidth(ComponentElement componentElement, Layout.Directive directive, float f) {
        return a(componentElement, directive, f, new ArrayList());
    }
}
