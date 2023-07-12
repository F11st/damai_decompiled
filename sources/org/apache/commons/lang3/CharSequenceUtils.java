package org.apache.commons.lang3;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CharSequenceUtils {
    private static final int NOT_FOUND = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int indexOf(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(i, i2);
        }
        int length = charSequence.length();
        if (i2 < 0) {
            i2 = 0;
        }
        if (i < 65536) {
            for (int i3 = i2; i3 < length; i3++) {
                if (charSequence.charAt(i3) == i) {
                    return i3;
                }
            }
        }
        if (i <= 1114111) {
            char[] chars = Character.toChars(i);
            while (i2 < length - 1) {
                char charAt = charSequence.charAt(i2);
                int i4 = i2 + 1;
                char charAt2 = charSequence.charAt(i4);
                if (charAt == chars[0] && charAt2 == chars[1]) {
                    return i2;
                }
                i2 = i4;
            }
            return -1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int lastIndexOf(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(i, i2);
        }
        int length = charSequence.length();
        if (i2 < 0) {
            return -1;
        }
        if (i2 >= length) {
            i2 = length - 1;
        }
        if (i < 65536) {
            for (int i3 = i2; i3 >= 0; i3--) {
                if (charSequence.charAt(i3) == i) {
                    return i3;
                }
            }
        }
        if (i <= 1114111) {
            char[] chars = Character.toChars(i);
            if (i2 == length - 1) {
                return -1;
            }
            while (i2 >= 0) {
                char charAt = charSequence.charAt(i2);
                char charAt2 = charSequence.charAt(i2 + 1);
                if (chars[0] == charAt && chars[1] == charAt2) {
                    return i2;
                }
                i2--;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean regionMatches(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
        }
        int length = charSequence.length() - i;
        int length2 = charSequence2.length() - i2;
        if (i < 0 || i2 < 0 || i3 < 0 || length < i3 || length2 < i3) {
            return false;
        }
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                return true;
            }
            int i5 = i + 1;
            char charAt = charSequence.charAt(i);
            int i6 = i2 + 1;
            char charAt2 = charSequence2.charAt(i2);
            if (charAt != charAt2) {
                if (!z) {
                    return false;
                }
                if (Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                    return false;
                }
            }
            i = i5;
            i3 = i4;
            i2 = i6;
        }
    }

    public static CharSequence subSequence(CharSequence charSequence, int i) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.subSequence(i, charSequence.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i = 0; i < length; i++) {
            cArr[i] = charSequence.charAt(i);
        }
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence.toString().indexOf(charSequence2.toString(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), i);
    }
}
