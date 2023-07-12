package tb;

import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class jg {
    @NotNull
    public static final String a(@NotNull String str) {
        b41.i(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt <= 'z') {
            z = true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            b41.h(substring, "(this as java.lang.String).substring(startIndex)");
            return String.valueOf(upperCase) + substring;
        }
        return str;
    }

    @NotNull
    public static final String b(@NotNull String str) {
        b41.i(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt <= 'Z') {
            z = true;
        }
        if (z) {
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            b41.h(substring, "(this as java.lang.String).substring(startIndex)");
            return String.valueOf(lowerCase) + substring;
        }
        return str;
    }

    @NotNull
    public static final String c(@NotNull String str, boolean z) {
        n31 S;
        Integer num;
        b41.i(str, "<this>");
        if ((str.length() == 0) || !d(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z)) {
            if (z) {
                return b(str);
            }
            if (str.length() > 0) {
                char lowerCase = Character.toLowerCase(str.charAt(0));
                String substring = str.substring(1);
                b41.h(substring, "(this as java.lang.String).substring(startIndex)");
                return String.valueOf(lowerCase) + substring;
            }
            return str;
        }
        S = StringsKt__StringsKt.S(str);
        Iterator<Integer> it = S.iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (!d(str, num.intValue(), z)) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 == null) {
            return e(str, z);
        }
        int intValue = num2.intValue() - 1;
        String substring2 = str.substring(0, intValue);
        b41.h(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String e = e(substring2, z);
        String substring3 = str.substring(intValue);
        b41.h(substring3, "(this as java.lang.String).substring(startIndex)");
        return b41.r(e, substring3);
    }

    private static final boolean d(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        if (z) {
            return 'A' <= charAt && charAt <= 'Z';
        }
        return Character.isUpperCase(charAt);
    }

    private static final String e(String str, boolean z) {
        if (z) {
            return f(str);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        b41.h(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @NotNull
    public static final String f(@NotNull String str) {
        b41.i(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            i++;
            if ('A' <= charAt && charAt <= 'Z') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "builder.toString()");
        return sb2;
    }
}
