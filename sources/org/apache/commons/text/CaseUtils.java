package org.apache.commons.text;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CaseUtils {
    private static Set<Integer> generateDelimiterSet(char[] cArr) {
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(Character.codePointAt(new char[]{' '}, 0)));
        if (cArr != null && cArr.length != 0) {
            for (int i = 0; i < cArr.length; i++) {
                hashSet.add(Integer.valueOf(Character.codePointAt(cArr, i)));
            }
        }
        return hashSet;
    }

    public static String toCamelCase(String str, boolean z, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length();
        int[] iArr = new int[length];
        Set<Integer> generateDelimiterSet = generateDelimiterSet(cArr);
        boolean z2 = z;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = lowerCase.codePointAt(i);
            if (generateDelimiterSet.contains(Integer.valueOf(codePointAt))) {
                z2 = i2 != 0;
                i += Character.charCount(codePointAt);
            } else if (!z2 && (i2 != 0 || !z)) {
                iArr[i2] = codePointAt;
                i += Character.charCount(codePointAt);
                i2++;
            } else {
                int titleCase = Character.toTitleCase(codePointAt);
                iArr[i2] = titleCase;
                i += Character.charCount(titleCase);
                i2++;
                z2 = false;
            }
        }
        return i2 != 0 ? new String(iArr, 0, i2) : lowerCase;
    }
}
