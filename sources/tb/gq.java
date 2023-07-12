package tb;

import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.caverock.androidsvg.SVGParser;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.css.CssUnit;
import com.real.android.nativehtml.common.dom.Element;
import com.real.android.nativehtml.common.dom.HtmlCollection;
import com.taobao.weex.ui.component.WXBasicComponentType;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class gq {
    private static final float[] i = {2.0f, 1.5f, 1.17f, 1.12f, 0.83f, 0.67f};
    public HashMap<String, gq> a;
    private HashMap<String, gq> b;
    private ArrayList<String> c;
    private StringBuilder d;
    private ArrayList<HashMap<String, gq>> e;
    private gq f;
    private gq g;
    private ArrayList<fq> h;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a {
        a(URI uri, int[] iArr) {
        }
    }

    private static void b(Element element, URI uri, fq fqVar, List<gq> list, List<gq> list2) {
        fq fqVar2 = new fq();
        if (fqVar != null) {
            fqVar2.j(fqVar);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).c(element, arrayList, arrayList2, arrayList3);
        }
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            gq gqVar = list2.get(i3);
            arrayList3.add(gqVar);
            gqVar.c(element, arrayList, arrayList2, arrayList3);
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            fqVar2.r((fq) arrayList.get(i4));
        }
        fqVar2.r(element.getStyle());
        element.setComputedStyle(fqVar2);
        HtmlCollection children = element.getChildren();
        for (int i5 = 0; i5 < children.getLength(); i5++) {
            b(children.item(i5), uri, fqVar2, arrayList2, arrayList3);
        }
    }

    private static void d(Element element, Map<String, gq> map, String str, List<fq> list, List<gq> list2, List<gq> list3) {
        gq gqVar;
        if (str == null || map == null || (gqVar = map.get(str)) == null) {
            return;
        }
        gqVar.c(element, list, list2, list3);
    }

    private gq e(char c, String str, String str2) {
        int i2;
        if (this.d == null) {
            this.d = new StringBuilder();
            this.c = new ArrayList<>();
            this.e = new ArrayList<>();
            i2 = -1;
        } else {
            i2 = -1;
            for (int i3 = 0; i3 < this.d.length(); i3++) {
                if (this.d.charAt(i3) == c && this.c.get(i3).equals(str)) {
                    i2 = i3;
                }
            }
        }
        if (i2 == -1) {
            i2 = this.d.length();
            this.d.append(c);
            this.c.add(str);
            this.e.add(new HashMap<>());
        }
        return g(this.e.get(i2), str2);
    }

    public static gq f(int i2) {
        gq gqVar = new gq();
        int i3 = (i2 * 3) / 4;
        int i4 = (i2 * 4) / 2;
        int i5 = i2 / 2;
        if (i3 != 12) {
            gqVar.h(jn1.MUL).n(CssProperty.FONT_SIZE, i3, CssUnit.PT);
        }
        fq n = gqVar.h(":link").n(CssProperty.COLOR, -1.6776961E7f, CssUnit.ARGB);
        CssProperty cssProperty = CssProperty.TEXT_DECORATION;
        n.q(cssProperty, CssEnum.UNDERLINE);
        fq h = gqVar.h(ILocatable.ADDRESS);
        CssProperty cssProperty2 = CssProperty.DISPLAY;
        CssEnum cssEnum = CssEnum.BLOCK;
        h.q(cssProperty2, cssEnum);
        gqVar.h("b").n(CssProperty.FONT_WEIGHT, 700.0f, CssUnit.NUMBER);
        gqVar.h(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP).d = "monospace";
        gqVar.h("big").n(CssProperty.FONT_SIZE, (i3 * 4) / 3, CssUnit.PT);
        fq q = gqVar.h("blockquote").q(cssProperty2, cssEnum);
        CssProperty cssProperty3 = CssProperty.MARGIN_TOP;
        float f = i5;
        CssUnit cssUnit = CssUnit.PX;
        float f2 = i4;
        fq n2 = q.n(cssProperty3, f, cssUnit).n(CssProperty.MARGIN_RIGHT, f2, cssUnit);
        CssProperty cssProperty4 = CssProperty.MARGIN_BOTTOM;
        fq n3 = n2.n(cssProperty4, f, cssUnit);
        CssProperty cssProperty5 = CssProperty.MARGIN_LEFT;
        n3.n(cssProperty5, f2, cssUnit);
        fq q2 = gqVar.h("body").q(cssProperty2, cssEnum);
        CssProperty cssProperty6 = CssProperty.PADDING;
        q2.o(cssProperty6, i5 / 2, cssUnit, 0);
        gqVar.h(BaseCellItem.TYPE_BUTTON).q(cssProperty2, CssEnum.INLINE_BLOCK).n(cssProperty6, 30.0f, cssUnit);
        gqVar.h("center").q(cssProperty2, cssEnum).n(cssProperty3, f, cssUnit).n(cssProperty4, f, cssUnit).q(CssProperty.TEXT_ALIGN, CssEnum.CENTER);
        gqVar.h("dd").q(cssProperty2, cssEnum).n(cssProperty5, f2, cssUnit);
        gqVar.h("del").q(cssProperty, CssEnum.LINE_THROUGH);
        gqVar.h("dir").q(cssProperty2, cssEnum).n(cssProperty3, f, cssUnit).n(cssProperty4, f, cssUnit).n(cssProperty5, f2, cssUnit).q(CssProperty.LIST_STYLE_TYPE, CssEnum.SQUARE);
        gqVar.h(WXBasicComponentType.DIV).q(cssProperty2, cssEnum);
        gqVar.h("dl").q(cssProperty2, cssEnum);
        gqVar.h("dt").q(cssProperty2, cssEnum);
        gqVar.h(com.alipay.sdk.m.l.c.c).q(cssProperty2, cssEnum);
        for (int i6 = 1; i6 <= 6; i6++) {
            fq n4 = gqVar.h("h" + i6).q(CssProperty.DISPLAY, CssEnum.BLOCK).n(CssProperty.FONT_WEIGHT, 700.0f, CssUnit.NUMBER);
            CssProperty cssProperty7 = CssProperty.MARGIN_TOP;
            CssUnit cssUnit2 = CssUnit.PX;
            n4.n(cssProperty7, f, cssUnit2).n(CssProperty.MARGIN_BOTTOM, f, cssUnit2).n(CssProperty.FONT_SIZE, (float) Math.round(i[i6 + (-1)] * ((float) i3)), CssUnit.PT);
        }
        fq h2 = gqVar.h("hr");
        CssProperty cssProperty8 = CssProperty.DISPLAY;
        CssEnum cssEnum2 = CssEnum.BLOCK;
        fq q3 = h2.q(cssProperty8, cssEnum2);
        CssProperty cssProperty9 = CssProperty.BORDER_TOP_STYLE;
        CssEnum cssEnum3 = CssEnum.SOLID;
        fq n5 = q3.q(cssProperty9, cssEnum3).n(CssProperty.BORDER_TOP_COLOR, -7829368.0f, CssUnit.ARGB);
        CssProperty cssProperty10 = CssProperty.MARGIN_TOP;
        CssUnit cssUnit3 = CssUnit.PX;
        fq n6 = n5.n(cssProperty10, f, cssUnit3);
        CssProperty cssProperty11 = CssProperty.MARGIN_BOTTOM;
        n6.n(cssProperty11, f, cssUnit3);
        fq fqVar = new fq();
        CssProperty cssProperty12 = CssProperty.FONT_STYLE;
        CssEnum cssEnum4 = CssEnum.ITALIC;
        fqVar.q(cssProperty12, cssEnum4);
        gqVar.h("i").q(cssProperty12, cssEnum4);
        gqVar.h("em").q(cssProperty12, cssEnum4);
        fq h3 = gqVar.h("img");
        CssEnum cssEnum5 = CssEnum.INLINE_BLOCK;
        h3.q(cssProperty8, cssEnum5);
        gqVar.h("input").q(cssProperty8, cssEnum5);
        fq h4 = gqVar.h("ins");
        CssProperty cssProperty13 = CssProperty.TEXT_DECORATION;
        CssEnum cssEnum6 = CssEnum.UNDERLINE;
        h4.q(cssProperty13, cssEnum6);
        gqVar.h(AppIconSetting.LARGE_ICON_URL).q(cssProperty8, CssEnum.LIST_ITEM).n(cssProperty10, f, cssUnit3).n(cssProperty11, f, cssUnit3);
        gqVar.h("marquee").q(cssProperty8, cssEnum2);
        fq n7 = gqVar.h("menu").q(cssProperty8, cssEnum2).n(cssProperty10, f, cssUnit3).n(cssProperty11, f, cssUnit3);
        CssProperty cssProperty14 = CssProperty.MARGIN_LEFT;
        fq n8 = n7.n(cssProperty14, f2, cssUnit3);
        CssProperty cssProperty15 = CssProperty.LIST_STYLE_TYPE;
        CssEnum cssEnum7 = CssEnum.SQUARE;
        n8.q(cssProperty15, cssEnum7);
        gqVar.h("ol").q(cssProperty8, cssEnum2).n(cssProperty14, f2, cssUnit3).q(cssProperty15, CssEnum.DECIMAL);
        gqVar.h("p").q(cssProperty8, cssEnum2).n(cssProperty10, f, cssUnit3).n(cssProperty11, f, cssUnit3);
        new fq().q(cssProperty8, cssEnum2).q(CssProperty.WHITE_SPACE, CssEnum.PRE).n(cssProperty10, f, cssUnit3).n(cssProperty11, f, cssUnit3);
        gqVar.h("pre").d = "monospace";
        fq h5 = gqVar.h("script");
        CssEnum cssEnum8 = CssEnum.NONE;
        h5.q(cssProperty8, cssEnum8);
        fq h6 = gqVar.h("small");
        CssProperty cssProperty16 = CssProperty.FONT_SIZE;
        float f3 = (i3 * 3) / 4;
        CssUnit cssUnit4 = CssUnit.PT;
        h6.n(cssProperty16, f3, cssUnit4);
        gqVar.h("strike").q(cssProperty13, CssEnum.LINE_THROUGH);
        fq h7 = gqVar.h("strong");
        CssProperty cssProperty17 = CssProperty.FONT_WEIGHT;
        CssUnit cssUnit5 = CssUnit.NUMBER;
        h7.n(cssProperty17, 700.0f, cssUnit5);
        gqVar.h("style").q(cssProperty8, cssEnum8);
        fq n9 = gqVar.h("sup").n(cssProperty16, f3, cssUnit4);
        CssProperty cssProperty18 = CssProperty.VERTICAL_ALIGN;
        n9.q(cssProperty18, CssEnum.SUPER);
        gqVar.h("sub").n(cssProperty16, f3, cssUnit4).q(cssProperty18, CssEnum.SUB);
        gqVar.h("table").n(CssProperty.BORDER_SPACING, 2.0f, cssUnit3).q(cssProperty8, CssEnum.TABLE).q(CssProperty.CLEAR, CssEnum.BOTH);
        fq h8 = gqVar.h(TimeDisplaySetting.TIME_DISPLAY);
        CssEnum cssEnum9 = CssEnum.TABLE_CELL;
        fq q4 = h8.q(cssProperty8, cssEnum9);
        CssProperty cssProperty19 = CssProperty.PADDING;
        fq n10 = q4.n(cssProperty19, 10.0f, cssUnit3);
        CssProperty cssProperty20 = CssProperty.BORDER_STYLE;
        fq q5 = n10.q(cssProperty20, cssEnum3);
        CssProperty cssProperty21 = CssProperty.TEXT_ALIGN;
        q5.q(cssProperty21, CssEnum.LEFT);
        gqVar.h("th").q(cssProperty8, cssEnum9).n(cssProperty17, 700.0f, cssUnit5).n(cssProperty19, 10.0f, cssUnit3).q(cssProperty20, cssEnum3).q(cssProperty21, CssEnum.CENTER);
        gqVar.h("tr").q(cssProperty8, CssEnum.TABLE_ROW);
        gqVar.h(IRequestConst.U).q(cssProperty13, cssEnum6);
        gqVar.h("ul").q(cssProperty8, cssEnum2).n(cssProperty14, f2, cssUnit3).q(cssProperty15, cssEnum7);
        gqVar.h("ul ul").q(cssProperty15, CssEnum.CIRCLE);
        gqVar.h("ul ul ul").q(cssProperty15, CssEnum.DISC);
        return gqVar;
    }

    private static gq g(Map<String, gq> map, String str) {
        gq gqVar = map.get(str);
        if (gqVar == null) {
            gq gqVar2 = new gq();
            map.put(str, gqVar2);
            return gqVar2;
        }
        return gqVar;
    }

    public static boolean i(String str, String[] strArr) {
        if (str == null) {
            return true;
        }
        String lowerCase = str.trim().toLowerCase(Locale.US);
        return lowerCase.length() == 0 || lowerCase.equals("all") || eq.c(strArr, lowerCase) != -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0128, code lost:
        r3 = r15.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012a, code lost:
        if (r3 == 44) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012c, code lost:
        if (r3 == 123) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x012f, code lost:
        r15 = new tb.fq();
        r15.e = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0138, code lost:
        if (r1.h != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x013a, code lost:
        r1.h = new java.util.ArrayList<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0141, code lost:
        r1.h.add(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0146, code lost:
        return r15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private tb.fq j(tb.hq r15) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.gq.j(tb.hq):tb.fq");
    }

    public void a(Element element, URI uri) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        b(element, uri, null, new ArrayList(), arrayList);
    }

    public void c(Element element, List<fq> list, List<gq> list2, List<gq> list3) {
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                fq fqVar = this.h.get(i2);
                int size = list.size();
                while (true) {
                    if (size <= 0) {
                        break;
                    }
                    fq fqVar2 = list.get(size - 1);
                    if (fqVar2.a(fqVar) < 0) {
                        break;
                    } else if (fqVar2 == fqVar) {
                        size = -1;
                        break;
                    } else {
                        size--;
                    }
                }
                if (size != -1) {
                    list.add(size, fqVar);
                }
            }
        }
        if (this.d != null) {
            for (int i3 = 0; i3 < this.d.length(); i3++) {
                char charAt = this.d.charAt(i3);
                String attribute = element.getAttribute(this.c.get(i3));
                if (attribute != null) {
                    HashMap<String, gq> hashMap = this.e.get(i3);
                    if (charAt == 7) {
                        d(element, hashMap, "", list, list2, list3);
                    } else if (charAt == '\b') {
                        d(element, hashMap, attribute, list, list2, list3);
                    } else {
                        for (String str : eq.d(attribute, charAt == '\t' ? ' ' : ',')) {
                            d(element, hashMap, str, list, list2, list3);
                        }
                    }
                }
            }
        }
        HashMap<String, gq> hashMap2 = this.a;
        if (hashMap2 != null) {
            d(element, hashMap2, element.getLocalName(), list, list2, list3);
        }
        gq gqVar = this.f;
        if (gqVar != null) {
            list2.add(gqVar);
        }
        gq gqVar2 = this.g;
        if (gqVar2 != null) {
            list3.add(gqVar2);
        }
    }

    public fq h(String str) {
        fq j = j(new hq(null, str + jn1.BLOCK_START_STR));
        int i2 = j.e;
        if (i2 >= 0) {
            j.e = i2 - 1000000;
        }
        return j;
    }

    public gq k(String str, URI uri, int[] iArr, String[] strArr, List<a> list) {
        int i2;
        hq hqVar = new hq(uri, str);
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = hqVar.a;
            if (i4 == -1) {
                return this;
            }
            if (i4 == -3) {
                int i5 = 1;
                if (SVGParser.XML_STYLESHEET_ATTR_MEDIA.equals(hqVar.b)) {
                    hqVar.c(false);
                    z = false;
                    do {
                        if (hqVar.a != 44) {
                            z |= i(hqVar.b, strArr);
                        }
                        hqVar.c(false);
                        i2 = hqVar.a;
                        if (i2 == 123) {
                            break;
                        }
                    } while (i2 != -1);
                    hqVar.c(false);
                    if (z) {
                        continue;
                    } else {
                        do {
                            int i6 = hqVar.a;
                            if (i6 == -1) {
                                return this;
                            }
                            if (i6 == 123) {
                                i5++;
                            } else if (i6 == 125) {
                                i5--;
                            }
                            hqVar.c(false);
                        } while (i5 > 0);
                    }
                } else if ("import".equals(hqVar.b)) {
                    hqVar.c(false);
                    String str2 = hqVar.b;
                    hqVar.c(false);
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i7 = hqVar.a;
                        if (i7 == 59 || i7 == -1) {
                            break;
                        }
                        sb.append(hqVar.b);
                        hqVar.c(false);
                    }
                    if (list != null && i(sb.toString(), strArr)) {
                        int[] iArr2 = new int[iArr.length + 1];
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        iArr2[iArr.length] = i3;
                        list.add(new a(uri.resolve(str2), iArr2));
                    }
                    hqVar.c(false);
                    i3++;
                } else {
                    hqVar.b("unsupported @" + hqVar.b);
                    hqVar.c(false);
                }
            } else if (i4 == 125) {
                if (!z) {
                    hqVar.b("unexpected }");
                }
                hqVar.c(false);
                z = false;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(j(hqVar));
                while (hqVar.a == 44) {
                    hqVar.c(false);
                    arrayList.add(j(hqVar));
                }
                fq fqVar = new fq();
                if (hqVar.a == 123) {
                    hqVar.c(false);
                    fqVar.m(hqVar);
                    hqVar.a(125);
                } else {
                    hqVar.b("{ expected");
                }
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    fq fqVar2 = (fq) arrayList.get(i8);
                    if (fqVar2 != null) {
                        fqVar2.f = i3;
                        fqVar2.g = iArr;
                        fqVar2.r(fqVar);
                    }
                }
                hqVar.c(false);
                i3++;
            }
        }
    }

    public void l(String str, StringBuilder sb) {
        if (this.h != null) {
            sb.append(str.length() == 0 ? jn1.MUL : str);
            sb.append(" {");
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                this.h.get(i2).s("", sb);
            }
            sb.append("}\n");
        }
        HashMap<String, gq> hashMap = this.a;
        if (hashMap != null) {
            for (Map.Entry<String, gq> entry : hashMap.entrySet()) {
                entry.getValue().l(entry.getKey() + str, sb);
            }
        }
        if (this.d != null) {
            for (int i3 = 0; i3 < this.d.length(); i3++) {
                char charAt = this.d.charAt(i3);
                StringBuilder sb2 = new StringBuilder(str);
                sb2.append(jn1.ARRAY_START);
                sb2.append(this.c.get(i3));
                if (charAt == 7) {
                    sb2.append(jn1.ARRAY_END);
                    this.e.get(i3).get("").l(sb2.toString(), sb);
                } else {
                    switch (charAt) {
                        case '\b':
                            sb2.append(com.alipay.sdk.m.n.a.h);
                            break;
                        case '\t':
                            sb2.append("~=");
                            break;
                        case '\n':
                            sb2.append("|=");
                            break;
                    }
                    for (Map.Entry<String, gq> entry2 : this.e.get(i3).entrySet()) {
                        entry2.getValue().l(sb2.toString() + jn1.QUOTE + entry2.getKey() + "\"]", sb);
                    }
                }
            }
        }
        gq gqVar = this.g;
        if (gqVar != null) {
            gqVar.l(str + " ", sb);
        }
        gq gqVar2 = this.f;
        if (gqVar2 != null) {
            gqVar2.l(str + " > ", sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        l("", sb);
        return sb.toString();
    }
}
