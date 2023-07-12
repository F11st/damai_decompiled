package tb;

import com.real.android.nativehtml.common.css.CssEnum;
import com.real.android.nativehtml.common.css.CssProperty;
import com.real.android.nativehtml.common.css.CssUnit;
import java.net.URI;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class fq {
    public static final int DPI = 96;
    public static final float FONT_WEIGHT_BOLD = 700.0f;
    public static final float FONT_WEIGHT_NORMAL = 400.0f;
    private static final int[] h = new int[0];
    private static final fq i = new fq();
    private static final CssUnit[] j = CssUnit.values();
    private static final CssProperty[] k;
    private static final CssEnum[] l;
    private static final LinkedHashMap<String, CssProperty> m;
    private static final LinkedHashMap<String, CssEnum> n;
    private static final LinkedHashMap<String, CssUnit> o;
    private float[] a;
    private byte[] b;
    String c;
    String d;
    int e;
    int f;
    int[] g = h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.fq$a */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C9144a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[CssEnum.values().length];
            c = iArr;
            try {
                iArr[CssEnum.WHITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[CssEnum.SILVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[CssEnum.GRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[CssEnum.RED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[CssEnum.MAROON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[CssEnum.YELLOW.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[CssEnum.OLIVE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[CssEnum.LIME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[CssEnum.GREEN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[CssEnum.AQUA.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[CssEnum.TEAL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                c[CssEnum.BLUE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                c[CssEnum.NAVY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                c[CssEnum.FUCHSIA.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                c[CssEnum.PURPLE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                c[CssEnum.TOP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                c[CssEnum.LEFT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                c[CssEnum.CENTER.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                c[CssEnum.RIGHT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                c[CssEnum.BOTTOM.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr2 = new int[CssProperty.values().length];
            b = iArr2;
            try {
                iArr2[CssProperty.BORDER_TOP_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                b[CssProperty.BORDER_BOTTOM_WIDTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                b[CssProperty.BORDER_LEFT_WIDTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                b[CssProperty.BORDER_RIGHT_WIDTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                b[CssProperty.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                b[CssProperty.HEIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                b[CssProperty.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                b[CssProperty.RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                b[CssProperty.TABLE_LAYOUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                b[CssProperty.TOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                b[CssProperty.WIDTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                b[CssProperty.BACKGROUND_COLOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                b[CssProperty.DISPLAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                b[CssProperty.FONT_SIZE.ordinal()] = 14;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                b[CssProperty.FONT_WEIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                b[CssProperty.LINE_HEIGHT.ordinal()] = 16;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                b[CssProperty.LIST_STYLE_TYPE.ordinal()] = 17;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                b[CssProperty.USER_SELECT.ordinal()] = 18;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                b[CssProperty.POSITION.ordinal()] = 19;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                b[CssProperty.BACKGROUND_REPEAT.ordinal()] = 20;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                b[CssProperty.OVERFLOW.ordinal()] = 21;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                b[CssProperty.WHITE_SPACE.ordinal()] = 22;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                b[CssProperty.TEXT_OVERFLOW.ordinal()] = 23;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                b[CssProperty.BACKGROUND_POSITION_X.ordinal()] = 24;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                b[CssProperty.BACKGROUND_POSITION_Y.ordinal()] = 25;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                b[CssProperty.COLOR.ordinal()] = 26;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                b[CssProperty.BORDER_TOP_COLOR.ordinal()] = 27;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                b[CssProperty.BORDER_RIGHT_COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                b[CssProperty.BORDER_BOTTOM_COLOR.ordinal()] = 29;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                b[CssProperty.BORDER_LEFT_COLOR.ordinal()] = 30;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                b[CssProperty.MARGIN_TOP.ordinal()] = 31;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                b[CssProperty.MARGIN_RIGHT.ordinal()] = 32;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                b[CssProperty.MARGIN_BOTTOM.ordinal()] = 33;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                b[CssProperty.MARGIN_LEFT.ordinal()] = 34;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                b[CssProperty.PADDING_TOP.ordinal()] = 35;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                b[CssProperty.PADDING_RIGHT.ordinal()] = 36;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                b[CssProperty.PADDING_BOTTOM.ordinal()] = 37;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                b[CssProperty.PADDING_LEFT.ordinal()] = 38;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                b[CssProperty.BORDER.ordinal()] = 39;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                b[CssProperty.BACKGROUND.ordinal()] = 40;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                b[CssProperty.BACKGROUND_POSITION.ordinal()] = 41;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                b[CssProperty.LIST_STYLE.ordinal()] = 42;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                b[CssProperty.FONT.ordinal()] = 43;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                b[CssProperty.BORDER_COLOR.ordinal()] = 44;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                b[CssProperty.BORDER_STYLE.ordinal()] = 45;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                b[CssProperty.BORDER_WIDTH.ordinal()] = 46;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                b[CssProperty.PADDING.ordinal()] = 47;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                b[CssProperty.MARGIN.ordinal()] = 48;
            } catch (NoSuchFieldError unused68) {
            }
            int[] iArr3 = new int[CssUnit.values().length];
            a = iArr3;
            try {
                iArr3[CssUnit.ENUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                a[CssUnit.ARGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                a[CssUnit.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                a[CssUnit.PX.ordinal()] = 4;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                a[CssUnit.NUMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                a[CssUnit.EM.ordinal()] = 6;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                a[CssUnit.EX.ordinal()] = 7;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                a[CssUnit.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                a[CssUnit.CM.ordinal()] = 9;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                a[CssUnit.MM.ordinal()] = 10;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                a[CssUnit.PT.ordinal()] = 11;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                a[CssUnit.PC.ordinal()] = 12;
            } catch (NoSuchFieldError unused80) {
            }
        }
    }

    static {
        CssEnum[] cssEnumArr;
        CssProperty[] values = CssProperty.values();
        k = values;
        l = CssEnum.values();
        m = new LinkedHashMap<>();
        n = new LinkedHashMap<>();
        o = new LinkedHashMap<>();
        for (CssProperty cssProperty : values) {
            m.put(eq.a(cssProperty.name()), cssProperty);
        }
        for (CssEnum cssEnum : l) {
            n.put(eq.a(cssEnum.name()), cssEnum);
        }
        CssUnit[] cssUnitArr = j;
        int length = cssUnitArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            CssUnit cssUnit = cssUnitArr[i2];
            o.put(cssUnit == CssUnit.PERCENT ? "%" : eq.a(cssUnit.name()), cssUnit);
        }
    }

    public static fq b(String str) {
        fq fqVar = new fq();
        fqVar.l(null, str);
        return fqVar;
    }

    public int a(fq fqVar) {
        int i2 = this.e;
        int i3 = fqVar.e;
        if (i2 > i3) {
            return 1;
        }
        if (i2 < i3) {
            return -1;
        }
        int min = Math.min(this.g.length, fqVar.g.length);
        for (int i4 = 0; i4 < min; i4++) {
            int[] iArr = this.g;
            int i5 = iArr[i4];
            int[] iArr2 = fqVar.g;
            if (i5 > iArr2[i4]) {
                return 1;
            }
            if (iArr[i4] < iArr2[i4]) {
                return -1;
            }
        }
        int i6 = min + 1;
        int[] iArr3 = this.g;
        int i7 = i6 < iArr3.length ? iArr3[i6] : this.f;
        int[] iArr4 = fqVar.g;
        return i7 - (i6 < iArr4.length ? iArr4[i6] : fqVar.f);
    }

    public float c(CssProperty cssProperty, CssUnit cssUnit) {
        return d(cssProperty, cssUnit, 0.0f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public float d(CssProperty cssProperty, CssUnit cssUnit, float f) {
        int ordinal;
        float f2;
        float c;
        int ordinal2 = cssProperty.ordinal();
        float[] fArr = this.a;
        float f3 = 0.0f;
        if (fArr != null && ordinal2 < fArr.length && this.b[ordinal2] != 0) {
            f2 = fArr[ordinal2];
        } else {
            switch (C9144a.b[cssProperty.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    ordinal = CssEnum.MEDIUM.ordinal();
                    f2 = ordinal;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    ordinal = CssEnum.AUTO.ordinal();
                    f2 = ordinal;
                    break;
                case 12:
                    f2 = 1.6777215E7f;
                    break;
                case 13:
                    ordinal = CssEnum.INLINE.ordinal();
                    f2 = ordinal;
                    break;
                case 14:
                    f2 = 12.0f;
                    break;
                case 15:
                    f2 = 400.0f;
                    break;
                case 16:
                    f2 = 100.0f;
                    break;
                case 17:
                    ordinal = CssEnum.DISC.ordinal();
                    f2 = ordinal;
                    break;
                case 18:
                    ordinal = CssEnum.TEXT.ordinal();
                    f2 = ordinal;
                    break;
                case 19:
                    ordinal = CssEnum.STATIC.ordinal();
                    f2 = ordinal;
                    break;
                case 20:
                    ordinal = CssEnum.REPEAT.ordinal();
                    f2 = ordinal;
                    break;
                case 21:
                case 22:
                case 23:
                    ordinal = CssEnum.TEXT.ordinal();
                    f2 = ordinal;
                    break;
                default:
                    int i2 = C9144a.a[i(cssProperty).ordinal()];
                    if (i2 == 1) {
                        ordinal = CssEnum.NONE.ordinal();
                        f2 = ordinal;
                        break;
                    } else if (i2 == 2) {
                        f2 = -1.6777216E7f;
                        break;
                    } else {
                        f2 = 0.0f;
                        break;
                    }
            }
        }
        CssUnit i3 = i(cssProperty);
        if (i3 == cssUnit) {
            return f2;
        }
        if (i3 == CssUnit.ENUM && cssUnit == CssUnit.ARGB) {
            switch (C9144a.c[l[(int) f2].ordinal()]) {
                case 1:
                    return -1.0f;
                case 2:
                    return -4144960.0f;
                case 3:
                    return -8355712.0f;
                case 4:
                    return -65536.0f;
                case 5:
                    return -8388608.0f;
                case 6:
                    return -256.0f;
                case 7:
                    return -8355840.0f;
                case 8:
                    return -1.6711936E7f;
                case 9:
                    return -1.6744448E7f;
                case 10:
                    return -1.6711681E7f;
                case 11:
                    return -1.674432E7f;
                case 12:
                    return -1.6776961E7f;
                case 13:
                    return -1.6777088E7f;
                case 14:
                    return -65281.0f;
                case 15:
                    return -8388480.0f;
                default:
                    return -1.6777216E7f;
            }
        }
        int[] iArr = C9144a.a;
        switch (iArr[i3.ordinal()]) {
            case 1:
                if (f2 != CssEnum.NONE.ordinal()) {
                    if (ordinal2 >= CssProperty.BORDER_TOP_WIDTH.ordinal() && ordinal2 <= CssProperty.BORDER_LEFT_WIDTH.ordinal()) {
                        if (f2 != CssEnum.THIN.ordinal()) {
                            if (f2 != CssEnum.THICK.ordinal()) {
                                f3 = 2.0f;
                                break;
                            } else {
                                f3 = 3.0f;
                                break;
                            }
                        } else {
                            f3 = 1.0f;
                            break;
                        }
                    } else {
                        System.err.println("CssStyleDeclaration: Can't convert enum " + f2 + " to " + cssUnit + " for " + cssProperty);
                        break;
                    }
                }
                f3 = f2;
                break;
            case 2:
            default:
                System.err.println("CssStyleDeclaration: Can't convert enum 0.0 to " + cssUnit + " for " + cssProperty);
                break;
            case 3:
                if (cssProperty != CssProperty.FONT_SIZE) {
                    if (cssProperty != CssProperty.LINE_HEIGHT) {
                        f3 = (f * f2) / 100.0f;
                        break;
                    } else {
                        f3 = 20.0f;
                        break;
                    }
                }
                f3 = 16.0f;
                break;
            case 4:
            case 5:
                f3 = f2;
                break;
            case 6:
                CssProperty cssProperty2 = CssProperty.FONT_SIZE;
                if (cssProperty != cssProperty2) {
                    c = c(cssProperty2, CssUnit.PX);
                    f3 = f2 * c;
                    break;
                }
                f3 = 16.0f;
                break;
            case 7:
                CssProperty cssProperty3 = CssProperty.FONT_SIZE;
                if (cssProperty != cssProperty3) {
                    c = c(cssProperty3, CssUnit.PX) / 2.0f;
                    f3 = f2 * c;
                    break;
                } else {
                    f3 = 8.0f;
                    break;
                }
            case 8:
                f3 = f2 * 96.0f;
                break;
            case 9:
                c = 37.795277f;
                f3 = f2 * c;
                break;
            case 10:
                c = 3.7795277f;
                f3 = f2 * c;
                break;
            case 11:
                f3 = f2 * 1.0f;
                break;
            case 12:
                f3 = f2 * 16.0f;
                break;
        }
        switch (iArr[cssUnit.ordinal()]) {
            case 6:
                return f3 / c(CssProperty.FONT_SIZE, CssUnit.PX);
            case 7:
                return (f3 / c(CssProperty.FONT_SIZE, CssUnit.PX)) / 2.0f;
            case 8:
                return f3 / 96.0f;
            case 9:
                return (f3 * 2.54f) / 96.0f;
            case 10:
                return (f3 * 25.4f) / 96.0f;
            case 11:
                return (f3 * 72.0f) / 96.0f;
            case 12:
                return (f3 * 6.0f) / 96.0f;
            default:
                return f3;
        }
    }

    public int e(CssProperty cssProperty) {
        return (int) c(cssProperty, CssUnit.ARGB);
    }

    public CssEnum f(CssProperty cssProperty) {
        return l[(int) c(cssProperty, CssUnit.ENUM)];
    }

    public float g(CssProperty cssProperty, float f) {
        int i2 = C9144a.b[cssProperty.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4 && f(CssProperty.BORDER_RIGHT_STYLE) == CssEnum.NONE) {
                        return 0.0f;
                    }
                } else if (f(CssProperty.BORDER_LEFT_STYLE) == CssEnum.NONE) {
                    return 0.0f;
                }
            } else if (f(CssProperty.BORDER_BOTTOM_STYLE) == CssEnum.NONE) {
                return 0.0f;
            }
        } else if (f(CssProperty.BORDER_TOP_STYLE) == CssEnum.NONE) {
            return 0.0f;
        }
        return d(cssProperty, CssUnit.PX, f);
    }

    public String h(CssProperty cssProperty) {
        if (k(cssProperty)) {
            if (cssProperty == CssProperty.BACKGROUND_IMAGE) {
                return this.c;
            }
            if (cssProperty == CssProperty.FONT_FAMILY) {
                return this.d;
            }
            CssUnit i2 = i(cssProperty);
            int i3 = C9144a.a[i2.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    StringBuilder sb = new StringBuilder();
                    float c = c(cssProperty, i2);
                    int i4 = (int) c;
                    if (c == i4) {
                        sb.append(i4);
                    } else {
                        sb.append(c);
                    }
                    if (i2 == CssUnit.PERCENT) {
                        sb.append("%");
                    } else if (i2 != CssUnit.NUMBER) {
                        sb.append(eq.a(i2.name()));
                    }
                    return sb.toString();
                }
                return '#' + Integer.toString((e(cssProperty) & 16777215) | 16777216, 16).substring(1);
            }
            return eq.a(f(cssProperty).name());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.real.android.nativehtml.common.css.CssUnit i(com.real.android.nativehtml.common.css.CssProperty r4) {
        /*
            r3 = this;
            int r0 = r4.ordinal()
            byte[] r1 = r3.b
            if (r1 == 0) goto L16
            int r2 = r1.length
            if (r0 >= r2) goto L16
            r2 = r1[r0]
            if (r2 == 0) goto L16
            com.real.android.nativehtml.common.css.CssUnit[] r4 = tb.fq.j
            r0 = r1[r0]
            r4 = r4[r0]
            return r4
        L16:
            int[] r0 = tb.fq.C9144a.b
            int r4 = r4.ordinal()
            r4 = r0[r4]
            r0 = 12
            if (r4 == r0) goto L34
            switch(r4) {
                case 14: goto L31;
                case 15: goto L2e;
                case 16: goto L2b;
                default: goto L25;
            }
        L25:
            switch(r4) {
                case 24: goto L2b;
                case 25: goto L2b;
                case 26: goto L34;
                case 27: goto L34;
                case 28: goto L34;
                case 29: goto L34;
                case 30: goto L34;
                case 31: goto L2e;
                case 32: goto L2e;
                case 33: goto L2e;
                case 34: goto L2e;
                case 35: goto L2e;
                case 36: goto L2e;
                case 37: goto L2e;
                case 38: goto L2e;
                default: goto L28;
            }
        L28:
            com.real.android.nativehtml.common.css.CssUnit r4 = com.real.android.nativehtml.common.css.CssUnit.ENUM
            return r4
        L2b:
            com.real.android.nativehtml.common.css.CssUnit r4 = com.real.android.nativehtml.common.css.CssUnit.PERCENT
            return r4
        L2e:
            com.real.android.nativehtml.common.css.CssUnit r4 = com.real.android.nativehtml.common.css.CssUnit.NUMBER
            return r4
        L31:
            com.real.android.nativehtml.common.css.CssUnit r4 = com.real.android.nativehtml.common.css.CssUnit.PT
            return r4
        L34:
            com.real.android.nativehtml.common.css.CssUnit r4 = com.real.android.nativehtml.common.css.CssUnit.ARGB
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.fq.i(com.real.android.nativehtml.common.css.CssProperty):com.real.android.nativehtml.common.css.CssUnit");
    }

    public void j(fq fqVar) {
        if (fqVar == null) {
            fqVar = i;
        }
        float[] fArr = this.a;
        int length = fArr == null ? 0 : fArr.length;
        float[] fArr2 = fqVar.a;
        int max = Math.max(length, fArr2 == null ? 0 : fArr2.length);
        for (int i2 = 0; i2 < max; i2++) {
            CssProperty cssProperty = k[i2];
            if (i(cssProperty) == CssUnit.ENUM && f(cssProperty) == CssEnum.INHERIT) {
                if (cssProperty == CssProperty.BACKGROUND_IMAGE) {
                    this.c = fqVar.c;
                } else if (cssProperty == CssProperty.FONT_FAMILY) {
                    this.d = fqVar.d;
                } else {
                    CssUnit i3 = fqVar.i(cssProperty);
                    n(cssProperty, fqVar.c(cssProperty, i3), i3);
                }
            } else {
                CssUnit i4 = i(cssProperty);
                CssUnit cssUnit = CssUnit.PERCENT;
                if (i4 == cssUnit) {
                    CssProperty cssProperty2 = CssProperty.FONT_SIZE;
                    if (cssProperty == cssProperty2) {
                        CssUnit i5 = fqVar.i(cssProperty);
                        n(cssProperty, (fqVar.c(cssProperty, i5) * c(cssProperty, cssUnit)) / 100.0f, i5);
                    } else if (cssProperty == CssProperty.LINE_HEIGHT) {
                        CssUnit i6 = i(cssProperty2);
                        n(cssProperty, (c(cssProperty2, i6) * c(cssProperty, cssUnit)) / 100.0f, i6);
                    }
                } else {
                    CssUnit i7 = i(cssProperty);
                    CssUnit cssUnit2 = CssUnit.EM;
                    if (i7 == cssUnit2 && cssProperty == CssProperty.FONT_SIZE) {
                        CssUnit i8 = fqVar.i(cssProperty);
                        n(cssProperty, fqVar.c(cssProperty, i8) * c(cssProperty, cssUnit2), i8);
                    } else {
                        CssUnit i9 = i(cssProperty);
                        CssUnit cssUnit3 = CssUnit.EX;
                        if (i9 == cssUnit3 && cssProperty == CssProperty.FONT_SIZE) {
                            CssUnit i10 = fqVar.i(cssProperty);
                            n(cssProperty, (fqVar.c(cssProperty, i10) * c(cssProperty, cssUnit3)) / 2.0f, i10);
                        } else if (fqVar.k(cssProperty) && i2 < CssProperty.TEXT_PROPERTY_COUNT && cssProperty != CssProperty.BACKGROUND_COLOR && cssProperty != CssProperty.DISPLAY) {
                            if (cssProperty == CssProperty.FONT_FAMILY) {
                                this.d = fqVar.d;
                            }
                            CssUnit i11 = fqVar.i(cssProperty);
                            n(cssProperty, fqVar.c(cssProperty, i11), i11);
                        }
                    }
                }
            }
        }
    }

    public boolean k(CssProperty cssProperty) {
        if (cssProperty == CssProperty.BACKGROUND_IMAGE) {
            return this.c != null;
        } else if (cssProperty == CssProperty.FONT_FAMILY) {
            return this.d != null;
        } else {
            float[] fArr = this.a;
            return (fArr == null || fArr.length <= cssProperty.ordinal() || this.b[cssProperty.ordinal()] == 0) ? false : true;
        }
    }

    public void l(URI uri, String str) {
        m(new hq(uri, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(hq hqVar) {
        while (true) {
            int i2 = hqVar.a;
            if (i2 == -1 || i2 == 125) {
                return;
            }
            if (i2 == -2) {
                String str = hqVar.b;
                CssProperty cssProperty = m.get(str);
                if (cssProperty == null) {
                    hqVar.b("unrecognized property");
                }
                hqVar.c(false);
                if (hqVar.a == 58) {
                    hqVar.c(false);
                    int i3 = 0;
                    while (true) {
                        int i4 = hqVar.a;
                        if (i4 != -4) {
                            if (i4 == -2) {
                                CssEnum cssEnum = n.get(hqVar.b);
                                if (cssEnum != null) {
                                    o(cssProperty, cssEnum.ordinal(), CssUnit.ENUM, i3);
                                } else if (cssProperty != CssProperty.FONT && cssProperty != CssProperty.FONT_FAMILY) {
                                    hqVar.b("Unrecognized value '" + cssEnum + "' for property " + str);
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    String str2 = this.d;
                                    sb.append(str2 != null ? str2 : "");
                                    sb.append(hqVar.b);
                                    this.d = sb.toString();
                                }
                            } else if (i4 != 44) {
                                switch (i4) {
                                    case -10:
                                        if (cssProperty != CssProperty.BACKGROUND && cssProperty != CssProperty.BACKGROUND_IMAGE) {
                                            break;
                                        } else {
                                            this.c = hqVar.b;
                                            break;
                                        }
                                        break;
                                    case -9:
                                        o(cssProperty, hqVar.c, o.get(hqVar.b), i3);
                                        break;
                                    case -8:
                                        o(cssProperty, hqVar.c, CssUnit.PERCENT, i3);
                                        break;
                                    case -7:
                                        o(cssProperty, hqVar.c, CssUnit.NUMBER, i3);
                                        break;
                                    case -6:
                                        p(cssProperty, '#' + hqVar.b, i3);
                                        break;
                                }
                            }
                            i3++;
                            hqVar.c(false);
                        }
                        if (cssProperty == CssProperty.FONT || cssProperty == CssProperty.FONT_FAMILY) {
                            StringBuilder sb2 = new StringBuilder();
                            String str3 = this.d;
                            sb2.append(str3 != null ? str3 : "");
                            sb2.append(hqVar.b);
                            this.d = sb2.toString();
                        }
                        i3++;
                        hqVar.c(false);
                    }
                }
            }
            if (hqVar.a == 33) {
                hqVar.c(false);
                if (hqVar.a == -2 && "important".equals(hqVar.b)) {
                    this.e = 1000000;
                    hqVar.c(false);
                }
            }
            while (true) {
                int i5 = hqVar.a;
                if (i5 != -1 && i5 != 59 && i5 != 125) {
                    hqVar.b("skipping");
                    hqVar.c(false);
                }
            }
            while (hqVar.a == 59) {
                hqVar.c(false);
            }
        }
    }

    public fq n(CssProperty cssProperty, float f, CssUnit cssUnit) {
        int ordinal = cssProperty.ordinal();
        int i2 = CssProperty.REGULAR_PROPERTY_COUNT;
        if (ordinal >= i2) {
            return o(cssProperty, f, cssUnit, 0);
        }
        float[] fArr = this.a;
        if (fArr == null || ordinal >= fArr.length) {
            int i3 = CssProperty.TEXT_PROPERTY_COUNT;
            if (ordinal < i3) {
                i2 = i3;
            }
            float[] fArr2 = new float[i2];
            byte[] bArr = new byte[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                byte[] bArr2 = this.b;
                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            }
            this.a = fArr2;
            this.b = bArr;
        }
        this.a[ordinal] = f;
        this.b[ordinal] = (byte) cssUnit.ordinal();
        return this;
    }

    public fq o(CssProperty cssProperty, float f, CssUnit cssUnit, int i2) {
        int ordinal;
        if (cssProperty == null) {
            return this;
        }
        int i3 = 0;
        switch (C9144a.b[cssProperty.ordinal()]) {
            case 39:
                if (cssUnit == CssUnit.ARGB) {
                    o(CssProperty.BORDER_COLOR, f, cssUnit, 0);
                } else if (i2 == 0) {
                    o(CssProperty.BORDER_WIDTH, f, cssUnit, 0);
                } else if (i2 == 1) {
                    o(CssProperty.BORDER_STYLE, f, cssUnit, 0);
                } else if (i2 == 3) {
                    o(CssProperty.BORDER_COLOR, f, cssUnit, 0);
                }
                ordinal = -1;
                break;
            case 40:
                CssUnit cssUnit2 = CssUnit.ENUM;
                if (cssUnit == cssUnit2) {
                    CssEnum cssEnum = CssEnum.INHERIT;
                    if (f == cssEnum.ordinal() && i2 == 0) {
                        q(CssProperty.BACKGROUND_COLOR, cssEnum);
                        q(CssProperty.BACKGROUND_REPEAT, cssEnum);
                        q(CssProperty.BACKGROUND_POSITION_X, cssEnum);
                        q(CssProperty.BACKGROUND_POSITION_Y, cssEnum);
                        ordinal = -1;
                        break;
                    }
                }
                if (cssUnit == CssUnit.ARGB) {
                    n(CssProperty.BACKGROUND_COLOR, f, cssUnit);
                } else if (cssUnit == cssUnit2 && (f == CssEnum.NO_REPEAT.ordinal() || f == CssEnum.REPEAT.ordinal() || f == CssEnum.REPEAT_X.ordinal() || f == CssEnum.REPEAT_Y.ordinal())) {
                    n(CssProperty.BACKGROUND_REPEAT, f, cssUnit2);
                } else if (cssUnit != cssUnit2 || (f != CssEnum.SCROLL.ordinal() && f != CssEnum.FIXED.ordinal())) {
                    CssProperty cssProperty2 = CssProperty.BACKGROUND_POSITION_X;
                    if (!k(cssProperty2)) {
                        n(cssProperty2, f, cssUnit);
                    }
                    n(CssProperty.BACKGROUND_POSITION_Y, f, cssUnit);
                }
                ordinal = -1;
                break;
            case 41:
                if (i2 == 0) {
                    n(CssProperty.BACKGROUND_POSITION_X, f, cssUnit);
                }
                if (i2 == 0 || i2 == 1) {
                    n(CssProperty.BACKGROUND_POSITION_Y, f, cssUnit);
                }
                ordinal = -1;
                break;
            case 42:
                if (i2 == 0 && cssUnit == CssUnit.ENUM) {
                    CssEnum cssEnum2 = CssEnum.INHERIT;
                    if (f == cssEnum2.ordinal()) {
                        q(CssProperty.LIST_STYLE_POSITION, cssEnum2);
                        q(CssProperty.LIST_STYLE_TYPE, cssEnum2);
                        ordinal = -1;
                        break;
                    }
                }
                if (cssUnit == CssUnit.ENUM && (f == CssEnum.INSIDE.ordinal() || f == CssEnum.OUTSIDE.ordinal())) {
                    n(CssProperty.LIST_STYLE_POSITION, f, cssUnit);
                } else {
                    n(CssProperty.LIST_STYLE_TYPE, f, cssUnit);
                }
                ordinal = -1;
                break;
            case 43:
                if (cssUnit == CssUnit.NUMBER) {
                    n(CssProperty.FONT_WEIGHT, f, cssUnit);
                }
                ordinal = -1;
                break;
            case 44:
                ordinal = CssProperty.BORDER_TOP_COLOR.ordinal();
                break;
            case 45:
                ordinal = CssProperty.BORDER_TOP_STYLE.ordinal();
                break;
            case 46:
                ordinal = CssProperty.BORDER_TOP_WIDTH.ordinal();
                break;
            case 47:
                ordinal = CssProperty.PADDING_TOP.ordinal();
                break;
            case 48:
                ordinal = CssProperty.MARGIN_TOP.ordinal();
                break;
            default:
                if (cssProperty.ordinal() < CssProperty.REGULAR_PROPERTY_COUNT) {
                    n(cssProperty, f, cssUnit);
                }
                ordinal = -1;
                break;
        }
        if (ordinal != -1) {
            while (i3 < 4) {
                n(k[ordinal + i3], f, cssUnit);
                i3 += i2 == 0 ? 1 : 2;
            }
        }
        return this;
    }

    public void p(CssProperty cssProperty, String str, int i2) {
        if (str.length() > 0 && str.charAt(0) == '#') {
            try {
                int parseInt = Integer.parseInt(str.substring(1), 16);
                if (str.length() == 4) {
                    parseInt = ((parseInt & 3840) << 12) | (parseInt & 15) | ((parseInt & 255) << 4) | ((parseInt & 4080) << 8);
                }
                o(cssProperty, (-16777216) | parseInt, CssUnit.ARGB, i2);
                return;
            } catch (NumberFormatException unused) {
                return;
            }
        }
        CssEnum cssEnum = n.get(eq.b(str));
        if (cssEnum != null) {
            o(cssProperty, cssEnum.ordinal(), CssUnit.ENUM, i2);
        }
    }

    public fq q(CssProperty cssProperty, CssEnum cssEnum) {
        return n(cssProperty, cssEnum.ordinal(), CssUnit.ENUM);
    }

    public void r(fq fqVar) {
        if (fqVar == null) {
            return;
        }
        if (fqVar.a != null) {
            for (int i2 = 0; i2 < fqVar.a.length; i2++) {
                CssProperty cssProperty = k[i2];
                if (fqVar.k(cssProperty)) {
                    CssUnit i3 = fqVar.i(cssProperty);
                    n(cssProperty, fqVar.c(cssProperty, i3), i3);
                }
            }
        }
        String str = fqVar.c;
        if (str != null) {
            this.c = str;
        }
        String str2 = fqVar.d;
        if (str2 != null) {
            this.d = str2;
        }
    }

    public void s(String str, StringBuilder sb) {
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.length; i2++) {
                CssProperty cssProperty = k[i2];
                if (k(cssProperty)) {
                    if (str != null) {
                        sb.append(str);
                    }
                    sb.append(eq.a(cssProperty.name()));
                    sb.append(": ");
                    sb.append(h(cssProperty));
                    sb.append(str == null ? "; " : ";\n");
                }
            }
        }
        if (str != null) {
            sb.append("/* specifity: " + this.e + " */\n");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        s(null, sb);
        return sb.toString();
    }
}
