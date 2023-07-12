package tb;

import com.real.android.nativehtml.common.css.CssEnum;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class bi2 {
    private static final String[] a = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] b = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CssEnum.values().length];
            a = iArr;
            try {
                iArr[CssEnum.DECIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CssEnum.LOWER_LATIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CssEnum.LOWER_GREEK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CssEnum.LOWER_ROMAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CssEnum.UPPER_LATIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[CssEnum.UPPER_ROMAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[CssEnum.SQUARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static String a(CssEnum cssEnum, int i) {
        switch (a.a[cssEnum.ordinal()]) {
            case 1:
                return String.valueOf(i) + ". ";
            case 2:
                return b(i, 'a', 26) + ". ";
            case 3:
                return b(i, (char) 945, 25) + ". ";
            case 4:
                return c(i) + ". ";
            case 5:
                return b(i, 'a', 26) + ". ";
            case 6:
                return c(i).toUpperCase() + ". ";
            case 7:
                return "▪ ";
            default:
                return "• ";
        }
    }

    static final String b(int i, char c, int i2) {
        StringBuilder sb = new StringBuilder();
        do {
            int i3 = i - 1;
            sb.insert(0, (char) ((i3 % i2) + c));
            i = i3 / i2;
        } while (i != 0);
        return sb.toString();
    }

    static final String c(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < b.length; i2++) {
            while (true) {
                int[] iArr = b;
                if (i % iArr[i2] < i) {
                    sb.append(a[i2]);
                    i -= iArr[i2];
                }
            }
        }
        return sb.toString();
    }
}
