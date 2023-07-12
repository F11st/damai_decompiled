package com.real.android.nativehtml.android;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.css.CssUnit;
import com.real.android.nativehtml.common.layout.Layout;
import tb.eq;
import tb.fq;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.real.android.nativehtml.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C0269a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Layout.Directive.values().length];
            b = iArr;
            try {
                iArr[Layout.Directive.MINIMUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Layout.Directive.STRETCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Layout.Directive.FIT_CONTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[CssEnum.values().length];
            a = iArr2;
            try {
                iArr2[CssEnum.UNDERLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CssEnum.LINE_THROUGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Layout.Directive directive) {
        int i = C0269a.b[directive.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return 0;
                }
                throw new IllegalArgumentException();
            }
            return 1073741824;
        }
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(fq fqVar) {
        CssProperty cssProperty = CssProperty.FONT_FAMILY;
        if (fqVar.k(cssProperty)) {
            String b = eq.b(fqVar.h(cssProperty));
            return b.substring(b.lastIndexOf(44) + 1).trim();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(fq fqVar) {
        int i = C0269a.a[fqVar.f(CssProperty.TEXT_DECORATION).ordinal()];
        if (i != 1) {
            return i != 2 ? 0 : 16;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(fq fqVar) {
        int i = fqVar.c(CssProperty.FONT_WEIGHT, CssUnit.NUMBER) > 600.0f ? 1 : 0;
        return fqVar.f(CssProperty.FONT_STYLE) == CssEnum.ITALIC ? i | 2 : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(fq fqVar) {
        int d = d(fqVar);
        if (!fqVar.k(CssProperty.FONT_FAMILY)) {
            return Typeface.defaultFromStyle(d);
        }
        return Typeface.create(b(fqVar), d);
    }

    public static void f(fq fqVar, float f, Paint paint) {
        paint.setTextSize(fqVar.g(CssProperty.FONT_SIZE, 0.0f) * f);
        paint.setTypeface(e(fqVar));
        paint.setFlags((paint.getFlags() & (-25)) | c(fqVar));
        paint.setColor(fqVar.e(CssProperty.COLOR));
    }
}
