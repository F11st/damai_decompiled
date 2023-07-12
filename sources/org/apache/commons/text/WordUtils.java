package org.apache.commons.text;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WordUtils {
    public static String abbreviate(String str, int i, int i2, String str2) {
        boolean z = true;
        Validate.isTrue(i2 >= -1, "upper value cannot be less than -1", new Object[0]);
        if (i2 < i && i2 != -1) {
            z = false;
        }
        Validate.isTrue(z, "upper value is less than lower value", new Object[0]);
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (i > str.length()) {
            i = str.length();
        }
        if (i2 == -1 || i2 > str.length()) {
            i2 = str.length();
        }
        StringBuilder sb = new StringBuilder();
        int indexOf = StringUtils.indexOf(str, " ", i);
        if (indexOf == -1) {
            sb.append((CharSequence) str, 0, i2);
            if (i2 != str.length()) {
                sb.append(StringUtils.defaultString(str2));
            }
        } else if (indexOf > i2) {
            sb.append((CharSequence) str, 0, i2);
            sb.append(StringUtils.defaultString(str2));
        } else {
            sb.append((CharSequence) str, 0, indexOf);
            sb.append(StringUtils.defaultString(str2));
        }
        return sb.toString();
    }

    public static String capitalize(String str) {
        return capitalize(str, null);
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, null);
    }

    public static boolean containsAllWords(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (StringUtils.isEmpty(charSequence) || ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence2 : charSequenceArr) {
            if (StringUtils.isBlank(charSequence2)) {
                return false;
            }
            if (!Pattern.compile(".*\\b" + ((Object) charSequence2) + "\\b.*").matcher(charSequence).matches()) {
                return false;
            }
        }
        return true;
    }

    private static Set<Integer> generateDelimiterSet(char[] cArr) {
        HashSet hashSet = new HashSet();
        if (cArr == null || cArr.length == 0) {
            if (cArr == null) {
                hashSet.add(Integer.valueOf(Character.codePointAt(new char[]{' '}, 0)));
            }
            return hashSet;
        }
        for (int i = 0; i < cArr.length; i++) {
            hashSet.add(Integer.valueOf(Character.codePointAt(cArr, i)));
        }
        return hashSet;
    }

    public static String initials(String str) {
        return initials(str, null);
    }

    @Deprecated
    public static boolean isDelimiter(char c, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c);
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public static String swapCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int[] iArr = new int[length];
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!Character.isUpperCase(codePointAt) && !Character.isTitleCase(codePointAt)) {
                if (!Character.isLowerCase(codePointAt)) {
                    z = Character.isWhitespace(codePointAt);
                } else if (z) {
                    codePointAt = Character.toTitleCase(codePointAt);
                } else {
                    codePointAt = Character.toUpperCase(codePointAt);
                }
                iArr[i2] = codePointAt;
                i += Character.charCount(codePointAt);
                i2++;
            } else {
                codePointAt = Character.toLowerCase(codePointAt);
            }
            z = false;
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, null);
    }

    public static String wrap(String str, int i) {
        return wrap(str, i, null, false);
    }

    public static String capitalize(String str, char... cArr) {
        int codePointAt;
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        Set<Integer> generateDelimiterSet = generateDelimiterSet(cArr);
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            while (i < length) {
                codePointAt = str.codePointAt(i);
                if (generateDelimiterSet.contains(Integer.valueOf(codePointAt))) {
                    break;
                } else if (z) {
                    int titleCase = Character.toTitleCase(codePointAt);
                    iArr[i2] = titleCase;
                    i += Character.charCount(titleCase);
                    i2++;
                    z = false;
                } else {
                    iArr[i2] = codePointAt;
                    i += Character.charCount(codePointAt);
                    i2++;
                }
            }
            return new String(iArr, 0, i2);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
    }

    public static String capitalizeFully(String str, char... cArr) {
        return StringUtils.isEmpty(str) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String initials(String str, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (cArr == null || cArr.length != 0) {
            Set<Integer> generateDelimiterSet = generateDelimiterSet(cArr);
            int length = str.length();
            int[] iArr = new int[(length / 2) + 1];
            int i = 0;
            int i2 = 0;
            boolean z = true;
            while (i < length) {
                int codePointAt = str.codePointAt(i);
                if (generateDelimiterSet.contains(Integer.valueOf(codePointAt)) || (cArr == null && Character.isWhitespace(codePointAt))) {
                    z = true;
                } else if (z) {
                    iArr[i2] = codePointAt;
                    i2++;
                    z = false;
                }
                i += Character.charCount(codePointAt);
            }
            return new String(iArr, 0, i2);
        }
        return "";
    }

    public static String uncapitalize(String str, char... cArr) {
        int codePointAt;
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        Set<Integer> generateDelimiterSet = generateDelimiterSet(cArr);
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            while (i < length) {
                codePointAt = str.codePointAt(i);
                if (generateDelimiterSet.contains(Integer.valueOf(codePointAt))) {
                    break;
                } else if (z) {
                    int lowerCase = Character.toLowerCase(codePointAt);
                    iArr[i2] = lowerCase;
                    i += Character.charCount(lowerCase);
                    i2++;
                    z = false;
                } else {
                    iArr[i2] = codePointAt;
                    i += Character.charCount(codePointAt);
                    i2++;
                }
            }
            return new String(iArr, 0, i2);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
    }

    public static String wrap(String str, int i, String str2, boolean z) {
        return wrap(str, i, str2, z, " ");
    }

    @Deprecated
    public static boolean isDelimiter(int i, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(i);
        }
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (Character.codePointAt(cArr, i2) == i) {
                return true;
            }
        }
        return false;
    }

    public static String wrap(String str, int i, String str2, boolean z, String str3) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = System.lineSeparator();
        }
        if (i < 1) {
            i = 1;
        }
        if (StringUtils.isBlank(str3)) {
            str3 = " ";
        }
        Pattern compile = Pattern.compile(str3);
        int length = str.length();
        int i2 = 0;
        StringBuilder sb = new StringBuilder(length + 32);
        while (i2 < length) {
            int i3 = -1;
            int i4 = i2 + i;
            Matcher matcher = compile.matcher(str.substring(i2, Math.min(i4 + 1, length)));
            if (matcher.find()) {
                if (matcher.start() == 0) {
                    i2 += matcher.end();
                } else {
                    i3 = matcher.start() + i2;
                }
            }
            if (length - i2 <= i) {
                break;
            }
            while (matcher.find()) {
                i3 = matcher.start() + i2;
            }
            if (i3 >= i2) {
                sb.append((CharSequence) str, i2, i3);
                sb.append(str2);
            } else if (z) {
                sb.append((CharSequence) str, i2, i4);
                sb.append(str2);
                i2 = i4;
            } else {
                Matcher matcher2 = compile.matcher(str.substring(i4));
                if (matcher2.find()) {
                    i3 = matcher2.start() + i2 + i;
                }
                if (i3 >= 0) {
                    sb.append((CharSequence) str, i2, i3);
                    sb.append(str2);
                } else {
                    sb.append((CharSequence) str, i2, str.length());
                    i2 = length;
                }
            }
            i2 = i3 + 1;
        }
        sb.append((CharSequence) str, i2, str.length());
        return sb.toString();
    }
}
