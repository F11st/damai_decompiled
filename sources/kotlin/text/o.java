package kotlin.text;

import com.taobao.weex.common.Constants;
import java.util.Collection;
import java.util.Iterator;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i31;
import tb.n31;
import tb.ty1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class o extends n {
    @NotNull
    public static String A(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        int Z;
        b41.i(str, "<this>");
        b41.i(str2, "oldValue");
        b41.i(str3, "newValue");
        Z = StringsKt__StringsKt.Z(str, str2, 0, z, 2, null);
        return Z < 0 ? str : StringsKt__StringsKt.p0(str, Z, str2.length() + Z, str3).toString();
    }

    public static /* synthetic */ String B(String str, String str2, String str3, boolean z, int i, Object obj) {
        String A;
        if ((i & 4) != 0) {
            z = false;
        }
        A = A(str, str2, str3, z);
        return A;
    }

    public static final boolean C(@NotNull String str, @NotNull String str2, int i, boolean z) {
        b41.i(str, "<this>");
        b41.i(str2, Constants.Name.PREFIX);
        if (!z) {
            return str.startsWith(str2, i);
        }
        return t(str, i, str2, 0, str2.length(), z);
    }

    public static boolean D(@NotNull String str, @NotNull String str2, boolean z) {
        b41.i(str, "<this>");
        b41.i(str2, Constants.Name.PREFIX);
        if (!z) {
            return str.startsWith(str2);
        }
        return t(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean E(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C(str, str2, i, z);
    }

    public static /* synthetic */ boolean F(String str, String str2, boolean z, int i, Object obj) {
        boolean D;
        if ((i & 2) != 0) {
            z = false;
        }
        D = D(str, str2, z);
        return D;
    }

    @SinceKotlin(version = "1.5")
    public static final boolean m(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return StringsKt__StringsKt.M(charSequence, charSequence2);
    }

    @SinceKotlin(version = "1.5")
    public static boolean n(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z) {
        if (z) {
            return StringsKt__StringsKt.L(charSequence, charSequence2);
        }
        return m(charSequence, charSequence2);
    }

    public static final boolean o(@NotNull String str, @NotNull String str2, boolean z) {
        b41.i(str, "<this>");
        b41.i(str2, Constants.Name.SUFFIX);
        if (!z) {
            return str.endsWith(str2);
        }
        return t(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean p(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return o(str, str2, z);
    }

    public static boolean q(@Nullable String str, @Nullable String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean r(String str, String str2, boolean z, int i, Object obj) {
        boolean q;
        if ((i & 2) != 0) {
            z = false;
        }
        q = q(str, str2, z);
        return q;
    }

    public static boolean s(@NotNull CharSequence charSequence) {
        n31 S;
        boolean c;
        boolean z;
        b41.i(charSequence, "<this>");
        if (charSequence.length() != 0) {
            S = StringsKt__StringsKt.S(charSequence);
            if (!(S instanceof Collection) || !((Collection) S).isEmpty()) {
                Iterator<Integer> it = S.iterator();
                while (it.hasNext()) {
                    c = b.c(charSequence.charAt(((i31) it).nextInt()));
                    if (!c) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean t(@NotNull String str, int i, @NotNull String str2, int i2, int i3, boolean z) {
        b41.i(str, "<this>");
        b41.i(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }

    public static /* synthetic */ boolean u(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        return t(str, i, str2, i2, i3, (i4 & 16) != 0 ? false : z);
    }

    @NotNull
    public static String v(@NotNull CharSequence charSequence, int i) {
        b41.i(charSequence, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        } else if (i != 0) {
            if (i != 1) {
                int length = charSequence.length();
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(charSequence.length() * i);
                        i31 it = new n31(1, i).iterator();
                        while (it.hasNext()) {
                            it.nextInt();
                            sb.append(charSequence);
                        }
                        String sb2 = sb.toString();
                        b41.h(sb2, "{\n                    va…tring()\n                }");
                        return sb2;
                    }
                    char charAt = charSequence.charAt(0);
                    char[] cArr = new char[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        cArr[i2] = charAt;
                    }
                    return new String(cArr);
                }
                return "";
            }
            return charSequence.toString();
        } else {
            return "";
        }
    }

    @NotNull
    public static final String w(@NotNull String str, char c, char c2, boolean z) {
        b41.i(str, "<this>");
        if (!z) {
            String replace = str.replace(c, c2);
            b41.h(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (c.d(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @NotNull
    public static final String x(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        int a;
        b41.i(str, "<this>");
        b41.i(str2, "oldValue");
        b41.i(str3, "newValue");
        int i = 0;
        int V = StringsKt__StringsKt.V(str, str2, 0, z);
        if (V < 0) {
            return str;
        }
        int length = str2.length();
        a = ty1.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i, V);
                sb.append(str3);
                i = V + length;
                if (V >= str.length()) {
                    break;
                }
                V = StringsKt__StringsKt.V(str, str2, V + a, z);
            } while (V > 0);
            sb.append((CharSequence) str, i, str.length());
            String sb2 = sb.toString();
            b41.h(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String y(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return w(str, c, c2, z);
    }

    public static /* synthetic */ String z(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return x(str, str2, str3, z);
    }
}
